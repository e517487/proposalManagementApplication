
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WLTP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WLTP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlagWLTP" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DateWLTP" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PhaseWLTP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FactoryWLTP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WLTP", propOrder = {
    "flagWLTP",
    "dateWLTP",
    "phaseWLTP",
    "factoryWLTP"
})
public class WLTP {

    @XmlElement(name = "FlagWLTP")
    protected boolean flagWLTP;
    @XmlElement(name = "DateWLTP")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateWLTP;
    @XmlElement(name = "PhaseWLTP", required = true)
    protected String phaseWLTP;
    @XmlElement(name = "FactoryWLTP")
    protected String factoryWLTP;

    /**
     * Gets the value of the flagWLTP property.
     * 
     */
    public boolean isFlagWLTP() {
        return flagWLTP;
    }

    /**
     * Sets the value of the flagWLTP property.
     * 
     */
    public void setFlagWLTP(boolean value) {
        this.flagWLTP = value;
    }

    /**
     * Gets the value of the dateWLTP property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateWLTP() {
        return dateWLTP;
    }

    /**
     * Sets the value of the dateWLTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateWLTP(XMLGregorianCalendar value) {
        this.dateWLTP = value;
    }

    /**
     * Gets the value of the phaseWLTP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhaseWLTP() {
        return phaseWLTP;
    }

    /**
     * Sets the value of the phaseWLTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhaseWLTP(String value) {
        this.phaseWLTP = value;
    }

    /**
     * Gets the value of the factoryWLTP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactoryWLTP() {
        return factoryWLTP;
    }

    /**
     * Sets the value of the factoryWLTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactoryWLTP(String value) {
        this.factoryWLTP = value;
    }

}
