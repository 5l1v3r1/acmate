/*******************************************************************************
 * Copyright (c) 2016, SVV Lab, University of Luxembourg
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * 3. Neither the name of acmate nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.svv.acmate.gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.commons.lang3.StringUtils;
import org.svv.acmate.burpsuite.SiteMap;
import org.svv.acmate.executor.ExecutorFactory;
import org.svv.acmate.executor.IExecutorListener;
import org.svv.acmate.executor.Session;
import org.svv.acmate.gui.table.ActiveUserTableModel;
import org.svv.acmate.gui.table.ITableSelection;
import org.svv.acmate.gui.table.PageTableModel;
import org.svv.acmate.gui.table.SessionTableModel;
import org.svv.acmate.model.TargetAppModel;
import org.svv.acmate.model.config.Authentication;
import org.svv.acmate.model.config.AuthenticationMethod;

/**
 *
 * @author cdnguyen
 */
public class ACTestingPanel extends javax.swing.JPanel implements ISiteMapListener, IModelListener, IExecutorListener {
	
	private int testingMode = ExecutorFactory.TESTING_MODE_RUN_WITH_EXISTING_REQUESTS; // default
	
    private TargetAppModel model;
    private SiteMap siteMap;
    private IMainController controller;
    
    private ActiveUserTableModel userModel;
    private PageTableModel pageModel;
    private SessionTableModel sessionModel;
    
	/**
     * Creates new form ACTestingPanel
     * @param model 
     */
    public ACTestingPanel(TargetAppModel model, SiteMap siteMap, IMainController controller) {
    	this.model = model;
    	this.controller = controller;
    	this.siteMap = siteMap;
    	
        model.registerModelListener(this);
        siteMap.registerSiteMapListener(this);
    	
        initComponents();
        
        userModel = new ActiveUserTableModel(model);
        tblSelectUsers.setModel(userModel);
        tblSelectUsers.getColumnModel().getColumn(1).setWidth(30);
        tblSelectUsers.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblSelectUsers.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        pageModel = new PageTableModel(siteMap);
        tblSelectPages.setModel(pageModel);
        tblSelectPages.getColumnModel().getColumn(0).setWidth(30);
        tblSelectPages.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblSelectPages.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        sessionModel = new SessionTableModel(model.getExecutionResults());
		tblTestResults.setModel(sessionModel);
        
        radioCrawlingOnly.setSelected(false);
        radioRunWithExistingRequests.setSelected(true);
        radioRunWithXInput.setSelected(false);
        
        Authentication authentication = model.getConfigModel().getAuthentication();
        txtLoginURL.setText(authentication.getLogInURL());
        txtLogOutSubfix.setText(authentication.getLogoutURLSubfix());
        
        cboLoginType.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] {AuthenticationMethod.CREDENTIAL.value() , AuthenticationMethod.HTTP_BASIC.value() }));

        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

    	 mainPanel = new javax.swing.JPanel();
         lblTargetPagesAndUsers = new javax.swing.JLabel();
         jScrollPane3 = new javax.swing.JScrollPane();
         tblSelectUsers = new javax.swing.JTable();
         jScrollPane4 = new javax.swing.JScrollPane();
         tblSelectPages = new javax.swing.JTable();
         jpanelLogin = new javax.swing.JPanel();
         lblLoginInfo = new javax.swing.JLabel();
         txtLoginURL = new javax.swing.JTextField();
         lblLoginType = new javax.swing.JLabel();
         cboLoginType = new javax.swing.JComboBox<String>();
         lblLogouSubfix = new javax.swing.JLabel();
         txtLogOutSubfix = new javax.swing.JTextField();
         bttnCustomiseUserPassFields = new javax.swing.JButton();
         acTestingPanel = new javax.swing.JPanel();
         lblNumberOfThreads = new javax.swing.JLabel();
         txtNumberParallelThreads = new javax.swing.JTextField();
         bttnStartACTesting = new javax.swing.JButton();
         lblProgress = new javax.swing.JLabel();
         barTestingProgress = new javax.swing.JProgressBar();
         lblTestSummary = new javax.swing.JLabel();
         jScrollPane5 = new javax.swing.JScrollPane();
         tblTestResults = new javax.swing.JTable();
         radioCrawlingOnly = new javax.swing.JRadioButton();
         radioRunWithExistingRequests = new javax.swing.JRadioButton();
         radioRunWithXInput = new javax.swing.JRadioButton();
         
         bttnSaveACTestResults = new javax.swing.JButton();
         bttnLoadPreviousResults = new javax.swing.JButton();
         bttnClearACSessions = new javax.swing.JButton();

         lblTargetPagesAndUsers.setText("Customize target pages and users:");

         
         jScrollPane3.setViewportView(tblSelectUsers);
         jScrollPane4.setViewportView(tblSelectPages);

         jpanelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login/Logout Info"));
         jpanelLogin.setToolTipText("Login Information");
         jpanelLogin.setName(" "); // NOI18N

         lblLoginInfo.setText("Login URL:");

         lblLoginType.setText("Login Type:");

         lblLogouSubfix.setText("Logout URL Subfix");

         bttnCustomiseUserPassFields.setText("Customize");
         bttnCustomiseUserPassFields.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bttnCustomiseUserPassFieldsActionPerformed(evt);
             }
         });
         
         txtLoginURL.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 txtLoginURLActionPerformed(evt);
             }
         });
         
         txtLogOutSubfix.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 txtLogOutSubfixActionPerformed(evt);
             }
         });
         
         bttnSaveACTestResults.setText("Save AC Test Results");
         bttnSaveACTestResults.setEnabled(false);
         bttnSaveACTestResults.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bttnSaveACTestResultsActionPerformed(evt);
             }
         });

         bttnLoadPreviousResults.setText("Load Previous Results");
         bttnLoadPreviousResults.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bttnLoadPreviousResultsActionPerformed(evt);
             }
         });
         
         bttnClearACSessions.setText("Clear");
         bttnClearACSessions.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bttnClearACSessionsActionPerformed(evt);
             }
         });
      
         lblLoginInfo.getAccessibleContext().setAccessibleName("Login Page:");

         acTestingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("AC Testing"));

         lblNumberOfThreads.setText("Number of parallel threads:");

         txtNumberParallelThreads.setToolTipText("");
         //TODO: enable this textbox when multi-thread option is activated, disable for now.
         txtNumberParallelThreads.setEnabled(false);
         txtNumberParallelThreads.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 txtNumberParallelThreadsActionPerformed(evt);
             }
         });

         bttnStartACTesting.setText("Start Testing");
         bttnStartACTesting.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 bttnStartACTestingActionPerformed(evt);
             }
         });

         lblProgress.setText("Progress:");

         lblTestSummary.setText("Session Info:");

         tblTestResults.setModel(new javax.swing.table.DefaultTableModel(
             new Object [][] {
                 {null, null},
                 {null, null},
                 {null, null},
                 {null, null}
             },
             new String [] {
                 "Session", "Progress"
             }
         ));
         jScrollPane5.setViewportView(tblTestResults);

         radioCrawlingOnly.setText("Spidering the selected pages");
         radioCrawlingOnly.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 radioCrawlingOnlyActionPerformed(evt);
             }
         });

         radioRunWithExistingRequests.setText("Run logged requests on the selected users");
         radioRunWithExistingRequests.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 radioRunWithExistingRequestsActionPerformed(evt);
             }
         });

         radioRunWithXInput.setText("Run requests generated from Xinputs on the selected users");
         radioRunWithXInput.addActionListener(new java.awt.event.ActionListener() {
             @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                 radioRunWithXInputActionPerformed(evt);
             }
         });

         
         javax.swing.GroupLayout jpanelLoginLayout = new javax.swing.GroupLayout(jpanelLogin);
         jpanelLogin.setLayout(jpanelLoginLayout);
         jpanelLoginLayout.setHorizontalGroup(
             jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jpanelLoginLayout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jpanelLoginLayout.createSequentialGroup()
                         .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(lblLoginInfo)
                             .addComponent(lblLoginType))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(txtLoginURL)
                             .addGroup(jpanelLoginLayout.createSequentialGroup()
                                 .addComponent(cboLoginType, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(bttnCustomiseUserPassFields)
                                 .addGap(0, 0, Short.MAX_VALUE))))
                     .addGroup(jpanelLoginLayout.createSequentialGroup()
                         .addComponent(lblLogouSubfix)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(txtLogOutSubfix)))
                 .addGap(21, 21, 21))
         );
         jpanelLoginLayout.setVerticalGroup(
             jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jpanelLoginLayout.createSequentialGroup()
                 .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblLoginInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                     .addComponent(txtLoginURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(cboLoginType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(bttnCustomiseUserPassFields)
                     .addComponent(lblLoginType))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblLogouSubfix)
                     .addComponent(txtLogOutSubfix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
         
         
         javax.swing.GroupLayout acTestingPanelLayout = new javax.swing.GroupLayout(acTestingPanel);
         acTestingPanel.setLayout(acTestingPanelLayout);
         acTestingPanelLayout.setHorizontalGroup(
             acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(acTestingPanelLayout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(acTestingPanelLayout.createSequentialGroup()
                         .addComponent(lblProgress)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(barTestingProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(acTestingPanelLayout.createSequentialGroup()
                         .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(acTestingPanelLayout.createSequentialGroup()
                                 .addComponent(radioCrawlingOnly)
                                 .addGap(18, 18, 18)
                                 .addComponent(radioRunWithExistingRequests)
                                 .addGap(18, 18, 18)
                                 .addComponent(radioRunWithXInput))
                             .addComponent(lblTestSummary)
                             .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(acTestingPanelLayout.createSequentialGroup()
                                 .addComponent(lblNumberOfThreads)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(txtNumberParallelThreads, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(bttnStartACTesting)))
                         .addGap(0, 0, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, acTestingPanelLayout.createSequentialGroup()
                    		 .addComponent(bttnClearACSessions, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                             .addComponent(bttnSaveACTestResults)
                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                             .addComponent(bttnLoadPreviousResults, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addGap(17, 17, 17))
         );
         acTestingPanelLayout.setVerticalGroup(
             acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(acTestingPanelLayout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(radioCrawlingOnly)
                     .addComponent(radioRunWithExistingRequests)
                     .addComponent(radioRunWithXInput))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(lblNumberOfThreads)
                     .addComponent(txtNumberParallelThreads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(bttnStartACTesting))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(lblProgress)
                     .addComponent(barTestingProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(lblTestSummary)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(acTestingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(bttnSaveACTestResults)
                     .addComponent(bttnLoadPreviousResults)
                     .addComponent(bttnClearACSessions)))
         );

         javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
         mainPanel.setLayout(mainPanelLayout);
         mainPanelLayout.setHorizontalGroup(
             mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(mainPanelLayout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(mainPanelLayout.createSequentialGroup()
                         .addComponent(lblTargetPagesAndUsers)
                         .addGap(0, 0, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                         .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                             .addGroup(mainPanelLayout.createSequentialGroup()
                                 .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addComponent(acTestingPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                             .addComponent(jpanelLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addGap(31, 31, 31))))
         );
         mainPanelLayout.setVerticalGroup(
             mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(mainPanelLayout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(lblTargetPagesAndUsers)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                     .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                 .addGap(18, 18, 18)
                 .addComponent(jpanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addComponent(acTestingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addGap(27, 27, 27))
         );

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
         this.setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGap(0, 853, Short.MAX_VALUE)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(0, 0, Short.MAX_VALUE)
                     .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(0, 0, Short.MAX_VALUE)))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGap(0, 695, Short.MAX_VALUE)
             .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(layout.createSequentialGroup()
                     .addGap(0, 0, Short.MAX_VALUE)
                     .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(0, 0, Short.MAX_VALUE)))
         );
    }// </editor-fold>                        

    
    protected void bttnCustomiseUserPassFieldsActionPerformed(ActionEvent evt) {
    	Authentication authentication = model.getConfigModel().getAuthentication();
    	
		LoginDialog dialog = new LoginDialog(authentication.getUserFieldName(), authentication.getPasswordFieldName());
		dialog.setVisible(true);
		
		if (dialog.getSelectedOption() == JOptionPane.OK_OPTION){
			authentication.setUserFieldName(dialog.getUsernameParamName());
			authentication.setPasswordFieldName(dialog.getPasswordParamName());
		}
		
		dialog.dispose();
	}

	private void bttnStartACTestingActionPerformed(java.awt.event.ActionEvent evt) {  
    	
    	addAuthenticationInfoToConfig();

		barTestingProgress.setValue(0);
		barTestingProgress.setStringPainted(true);
    	bttnStartACTesting.setEnabled(false);
    	int ret = controller.handleEvent(IMainController.ACTESTING_EVENT_STARTTEST, testingMode);
    	if (ret == -1){
    		// error, enable the start button
    		bttnStartACTesting.setEnabled(true);
    		
    	}

    }          
	
	/**
	 * Method 
	 */
	private void addAuthenticationInfoToConfig(){
		
		Authentication authentication = model.getConfigModel().getAuthentication();
		if (authentication == null){
			authentication  = new Authentication();
			model.getConfigModel().setAuthentication(authentication);
		}
		
		if (txtLoginURL.getText() != null)
			authentication.setLogInURL(txtLoginURL.getText());
		if (txtLogOutSubfix.getText() != null)
			authentication.setLogoutURLSubfix(txtLogOutSubfix.getText());
		authentication.setMethod(AuthenticationMethod.fromValue((String)cboLoginType.getSelectedItem()));
		
	}

    private void txtNumberParallelThreadsActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        String tmp = txtNumberParallelThreads.getText();
        if (tmp != null && !tmp.isEmpty()){
        	if (!StringUtils.isNumeric(tmp)){
        		int cores = Runtime.getRuntime().availableProcessors();
        		JOptionPane.showMessageDialog(this, "Number of parallel threads must be an Integer in between 1 and " + String.valueOf(cores));
        		txtNumberParallelThreads.setText(String.valueOf(cores / 2));
        	}
        }
    }    
    
    private void txtLoginURLActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	String tmp = txtLoginURL.getText();
		if (tmp != null && !tmp.isEmpty()){
			try {
				// check if we can parse the enterred URL
				URL url = new URL(tmp);
				addAuthenticationInfoToConfig();
			} catch (MalformedURLException e1) {
				JOptionPane.showMessageDialog(this, "Login URL is not welformed!");
			}
			
		}
    }                                           

    private void txtLogOutSubfixActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	String tmp = txtLogOutSubfix.getText();
		if (tmp != null && !tmp.isEmpty()){
			addAuthenticationInfoToConfig();
		}
    }                                               


    private void radioCrawlingOnlyActionPerformed(java.awt.event.ActionEvent evt) {  
    	radioCrawlingOnly.setSelected(true);
//        if (radioCrawlingOnly.isSelected()){
        	radioRunWithExistingRequests.setSelected(false);
        	radioRunWithXInput.setSelected(false);
        	testingMode = ExecutorFactory.TESTING_MODE_CRAWLING;
//        }
    }                                                 

    private void radioRunWithExistingRequestsActionPerformed(java.awt.event.ActionEvent evt) {
    	radioRunWithExistingRequests.setSelected(true);
//      	if (radioRunWithExistingRequests.isSelected()){
      		radioCrawlingOnly.setSelected(false);
      		radioRunWithXInput.setSelected(false);
      		testingMode = ExecutorFactory.TESTING_MODE_RUN_WITH_EXISTING_REQUESTS;
//      	}
    }                                                            

    private void radioRunWithXInputActionPerformed(java.awt.event.ActionEvent evt) {
    	radioRunWithXInput.setSelected(true);
//        if (radioRunWithXInput.isSelected()){
        	radioCrawlingOnly.setSelected(false);
        	radioRunWithExistingRequests.setSelected(false);
        	testingMode = ExecutorFactory.TESTING_MODE_RUN_WITH_XINPUT;
//        }
    }                                                  

    private void bttnClearACSessionsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    	bttnClearACSessions.setEnabled(false);
    	controller.handleEvent(IMainController.ACTESTING_EVENT_CLEAR_SESSIONS);
    	bttnClearACSessions.setEnabled(true);
    } 
    
    private void bttnSaveACTestResultsActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        bttnSaveACTestResults.setEnabled(false);
        controller.handleEvent(IMainController.ACTESTING_EVENT_SAVE_SESSIONS);
        bttnSaveACTestResults.setEnabled(true);
    }                                                     

    private void bttnLoadPreviousResultsActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    	bttnLoadPreviousResults.setEnabled(false);
        controller.handleEvent(IMainController.ACTESTING_EVENT_LOAD_SESSIONS);
        bttnLoadPreviousResults.setEnabled(true);
    }  
    
    @Override
    public void siteMapUpdated() {
    	pageModel.fireTableDataChanged();
    	resizeColumnWidth(tblSelectPages);
    }
    
    @Override
	public void startURLChanged() {
	  pageModel = new PageTableModel(siteMap);
      tblSelectPages.setModel(pageModel);
      
      JTableHeader header = tblSelectPages.getTableHeader();
      header.addMouseListener(new TableHeaderMouseListener(tblSelectPages, 0));
	}

    
    @Override
	public void configReloaded() {
    	 userModel = new ActiveUserTableModel(model);
         tblSelectUsers.setModel(userModel);
         
         JTableHeader header = tblSelectUsers.getTableHeader();
         header.addMouseListener(new TableHeaderMouseListener(tblSelectUsers, 1));
         
         resizeColumnWidth(tblSelectUsers);
         
         Authentication authentication = model.getConfigModel().getAuthentication();
         if (authentication != null){
	 		txtLoginURL.setText(authentication.getLogInURL());
	 		txtLogOutSubfix.setText(authentication.getLogoutURLSubfix());
	 		if (authentication.getMethod() != null) {
		 		String authenMethod = authentication.getMethod().value();
		 		if (authenMethod != null)
		 			cboLoginType.setSelectedItem(authenMethod);
	 		}
         }
	}


	@Override
	public void filterReloaded() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void usersChanged() {
		this.userModel.fireTableDataChanged();
	}

	@Override
	public void filterChanged() {}


	@Override
	public void start(int load) {
//		barTestingProgress.setString("started!");
		barTestingProgress.setMinimum(0);
		barTestingProgress.setMaximum(load);
	}

		
	@Override
	public void start(List<Session> sessions) {
		
		// overall progress 
		barTestingProgress.setMinimum(0);
		barTestingProgress.setMaximum(sessions.size());
		bttnSaveACTestResults.setEnabled(false);
		// session progress 
		
//		if (sessionModel == null){
//			sessionModel = new SessionTableModel(sessions);
//			tblTestResults.setModel(sessionModel);
//		} else {
		for (Session s : sessions){
			sessionModel.addSession(s);
		}
		sessionModel.fireTableDataChanged();
//		}
		
		bttnSaveACTestResults.setEnabled(false);
	}
	
	@Override
	public void testResultUpdated() {
//		List<Session> results = model.getExecutionResults();
//		if (results == null) 
//			return; // do nothing
//		
//		if (sessionModel == null){
//			sessionModel = new SessionTableModel(results);
//			tblTestResults.setModel(sessionModel);
//		} else {
//		for (Session s : results){
//			sessionModel.addSession(s);
//		}
//		}
		
		sessionModel.fireTableDataChanged();

		enableSaveBttn();
		
	}

	private void enableSaveBttn(){
		if (sessionModel.getRowCount() > 0)
			bttnSaveACTestResults.setEnabled(true);
	}

	@Override
	public void done() {
		barTestingProgress.setValue(barTestingProgress.getMaximum());
		bttnStartACTesting.setEnabled(true);
		JOptionPane.showMessageDialog(this, "AC Testing has finished!");
		
		enableSaveBttn();
	}

	@Override
	public void failed(String message) {
		barTestingProgress.setValue(0);
		bttnStartACTesting.setEnabled(true);
		JOptionPane.showMessageDialog(this, "Testing failed: \n" + message);
	}

	@Override
	public void progress(int complete) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
		barTestingProgress.setValue(complete);
//			}
//		});
	}
	
	// Variables declaration - do not modify            
    private javax.swing.JButton bttnClearACSessions;
	private javax.swing.JButton bttnLoadPreviousResults;
    private javax.swing.JButton bttnSaveACTestResults;
	private javax.swing.JProgressBar barTestingProgress;
	private javax.swing.JButton bttnCustomiseUserPassFields;
	private javax.swing.JButton bttnStartACTesting;
	private javax.swing.JComboBox<String> cboLoginType;
	private javax.swing.JPanel acTestingPanel;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel jpanelLogin;
	private javax.swing.JLabel lblLoginInfo;
	private javax.swing.JLabel lblLoginType;
	private javax.swing.JLabel lblLogouSubfix;
	private javax.swing.JLabel lblNumberOfThreads;
	private javax.swing.JLabel lblProgress;
	private javax.swing.JLabel lblTargetPagesAndUsers;
	private javax.swing.JLabel lblTestSummary;
	private javax.swing.JRadioButton radioCrawlingOnly;
	private javax.swing.JRadioButton radioRunWithExistingRequests;
	private javax.swing.JRadioButton radioRunWithXInput;
	private javax.swing.JTable tblSelectPages;
	private javax.swing.JTable tblSelectUsers;
	private javax.swing.JTable tblTestResults;
	private javax.swing.JTextField txtLogOutSubfix;
	private javax.swing.JTextField txtLoginURL;
	private javax.swing.JTextField txtNumberParallelThreads;
	// End of variables declaration      
	// TODO Auto-generated method stub


	// resize the column of table 
	// code taken from http://stackoverflow.com/questions/17627431/auto-resizing-the-jtable-column-widths
	
	private void resizeColumnWidth(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 80; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	
	class TableHeaderMouseListener extends MouseAdapter {
	     
	    private JTable table;
	    private int sColumn;
	     
	    public TableHeaderMouseListener(JTable table, int selectedColumn) {
	        this.table = table;
	        this.sColumn = selectedColumn;
	    }
	     
	    @Override
		public void mouseClicked(MouseEvent event) {
	        Point point = event.getPoint();
	        int column = table.columnAtPoint(point);
	        if (column == sColumn){
	        	if (table.getModel() instanceof ITableSelection){
	        		((ITableSelection)table.getModel()).toggleSelection();
	        	}
	        }
	    }
	}
}
