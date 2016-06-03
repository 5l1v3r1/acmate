//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.21 at 03:58:52 PM CEST 
//


package org.svv.xinput;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for complexDataSpecType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="complexDataSpecType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://acmate.svv.org/xinput}simpleDataSpecType"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://acmate.svv.org/xinput}commonAttGroup"/>
 *       &lt;attribute name="base" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "complexDataSpecType", propOrder = {
    "facets"
})
public class ComplexDataSpecType {

    @XmlElementRefs({
        @XmlElementRef(name = "totalDigits", namespace = "http://acmate.svv.org/xinput", type = TotalDigits.class, required = false),
        @XmlElementRef(name = "minExclusive", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "maxExclusive", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "fractionDigits", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "maxLength", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "minLength", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "enumeration", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "length", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "maxInclusive", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "minInclusive", namespace = "http://acmate.svv.org/xinput", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pattern", namespace = "http://acmate.svv.org/xinput", type = Pattern.class, required = false)
    })
    protected List<Object> facets;
    @XmlAttribute(name = "base", required = true)
    protected QName base;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the facets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalDigits }
     * {@link JAXBElement }{@code <}{@link Facet }{@code >}
     * {@link JAXBElement }{@code <}{@link Facet }{@code >}
     * {@link JAXBElement }{@code <}{@link NumFacet }{@code >}
     * {@link JAXBElement }{@code <}{@link NumFacet }{@code >}
     * {@link JAXBElement }{@code <}{@link NumFacet }{@code >}
     * {@link JAXBElement }{@code <}{@link NoFixedFacet }{@code >}
     * {@link JAXBElement }{@code <}{@link NumFacet }{@code >}
     * {@link JAXBElement }{@code <}{@link Facet }{@code >}
     * {@link JAXBElement }{@code <}{@link Facet }{@code >}
     * {@link Pattern }
     * 
     * 
     */
    public List<Object> getFacets() {
        if (facets == null) {
            facets = new ArrayList<Object>();
        }
        return this.facets;
    }

    /**
     * Gets the value of the base property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setBase(QName value) {
        this.base = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
