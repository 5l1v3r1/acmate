package org.svv.acmate.executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.svv.acmate.burpsuite.SiteMap;
import org.svv.acmate.exception.ExecutorException;
import org.svv.acmate.model.Request;
import org.svv.acmate.model.TargetAppModel;
import org.svv.acmate.model.config.User;

import burp.IBurpExtenderCallbacks;

public class ACTestExistingRequestsExecutor extends ACTestExecutor {
	
	private static final int SIZE_OF_THREAD_POOL = 4;
	private static final long TIMEOUT = 10; // minutes

	private ExecutorService executorService;

	public ACTestExistingRequestsExecutor(IBurpExtenderCallbacks callbacks,
			SiteMap siteMap, TargetAppModel appModel) {
		super(callbacks, siteMap, appModel);
		
	}

	@Override
	public void execute() throws ExecutorException {
		sequentialExecute();
//		parallelExecute();
	}
	
	/**
	 * Execute sequentially the sessions
	 * 
	 * @throws ExecutorException
	 */
	private void sequentialExecute() throws ExecutorException{
		
		List<String> selectedPaths = new ArrayList<String>();
		List<User> selectedUsers = new ArrayList<User>();
		
		if (!isExecutionReady(selectedPaths, selectedUsers)){
			return;
		}
		
		/////////////////////////////////
		// using executor service
//		executorService = Executors.newFixedThreadPool(1);
//		
//		for (int i = 0; i < selectedUsers.size(); i++){
//			User u = selectedUsers.get(i);
//			Session s = new Session(u, selectedPaths, callbacks, siteMap, appModel);
//			try {
//				executorService.submit(s).get(TIMEOUT, TimeUnit.SECONDS);
//				informProgress(i);
//			} catch (Exception e) {
//				e.printStackTrace();
//				if (e.getMessage() == null || e.getMessage().isEmpty()){
//					throw new ExecutorException("Unknown exception during AC testing!");
//				} else 
//					throw new ExecutorException(e.getLocalizedMessage());
//			}
//		}
//		
//		executorService.shutdown();
		
		
		List<Request> selectedRequests  = new LinkedList<Request>(); // use linkedlist to add faster
		for (String path : selectedPaths){
			List<Request> requests = siteMap.getPathRequestsMap().get(path);
			selectedRequests.addAll(requests);
		}
		
		if (selectedRequests.size() == 0){
			throw new ExecutorException("Cannot get any existing requests, execution aborted!");
		}
		
		// sessions
		List<Session> sessions = prepareSessions(selectedUsers, selectedRequests);
		// start execution
		notifyStartExecution(sessions);
		
		// start testing in an independent thread
		startACTest(sessions);
		
	}
	
	/**
	 * Experimental: executing sessions in parallel
	 * 
	 * @throws ExecutorException
	 */
	private void parallelExecute() throws ExecutorException{
		if (siteMap == null || appModel == null){
			throw new ExecutorException("Site map or target application cannot be null!");
		}
		
		
		List<String> selectedPaths = new ArrayList<String>();
		for (String path : siteMap.getPaths()){
			Boolean val = siteMap.getSelectedPaths().get(path);
			
			if (val != null && val.booleanValue()){
				selectedPaths.add(path);
			}
		}
		
		if (selectedPaths.size() == 0){
			throw new ExecutorException("Please select target pages for AC testing!");
		}
		
		// check users
		List<User> selectedUsers = new ArrayList<User>();
		for (User u : appModel.getActiveUsers().keySet()){
			Boolean val = appModel.getActiveUsers().get(u);
			if (val.booleanValue()){
				selectedUsers.add(u);
			}
		}
		
		if (selectedUsers.size() == 0){
			throw new ExecutorException("Select users for AC testing!");
		}
		
		// ready to run
		int actualNumThread = SIZE_OF_THREAD_POOL;
		if (actualNumThread > Runtime.getRuntime().availableProcessors())
			actualNumThread = Runtime.getRuntime().availableProcessors();
		
		if (actualNumThread > selectedUsers.size())
			actualNumThread = selectedUsers.size();
		
		executorService = Executors.newFixedThreadPool(actualNumThread);
		
		List<Session> sessions = new ArrayList<Session>();
		
		List<Request> selectedRequests  = new LinkedList<Request>(); 
		for (String path : selectedPaths){
			List<Request> requests = siteMap.getPathRequestsMap().get(path);
			selectedRequests.addAll(requests);
		}
		
		// start execution
		notifyStartExecution(sessions);
		
		// submit jobs
		for (int i = 0; i < selectedUsers.size(); i++){
			User u = selectedUsers.get(i);
			sessions.add(new Session(u, selectedRequests, callbacks, appModel));
		}

		
		try {
			// blocking
//			List<Future<Session>> list = executorService.invokeAll(sessions);   
			
			
			// non blocking
			Collection<Future<Session>> futures = new ArrayList<Future<Session>>(sessions.size());
		    for (Callable<Session> s: sessions) {
		        futures.add(executorService.submit(s));
		    }
		    
//			for (Future<Session> s : list){
//				Session result = s.get(TIMEOUT, TimeUnit.MINUTES);
//			}
		
			executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new ExecutorException("Interrupted exception occured during AC testing!");
		} catch (Exception e){
			e.printStackTrace();
			if (e.getMessage() == null || e.getMessage().isEmpty()){
				throw new ExecutorException("Timeout exception due to parallel execution!");
			} else 
				throw new ExecutorException(e.getMessage());
		}
		// end execution
		notifyDoneExecution();
	}
	

}
