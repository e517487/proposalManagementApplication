
package com.inetpsa.pct00.application.service.wltp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WLTPCharacteristics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WLTPCharacteristics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://inetpsa.com/cfg}Status"/>
 *         &lt;element name="PhysResult" type="{http://inetpsa.com/cfg}PhysResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Phase" type="{http://inetpsa.com/cfg}Phase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WLTPCharacteristics", propOrder = {
    "status",
    "physResult",
    "phase"
})
public class WLTPCharacteristics {

    @XmlElement(name = "Status", required = true)
    protected Status status;
    @XmlElement(name = "PhysResult")
    protected List<PhysResult> physResult;
    @XmlElement(name = "Phase")
    protected List<Phase> phase;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the physResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the physResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhysResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysResult }
     * 
     * 
     */
    public List<PhysResult> getPhysResult() {
        if (physResult == null) {
            physResult = new ArrayList<PhysResult>();
        }
        return this.physResult;
    }

    /**
     * Gets the value of the phase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Phase }
     * 
     * 
     */
    public List<Phase> getPhase() {
        if (phase == null) {
            phase = new ArrayList<Phase>();
        }
        return this.phase;
    }

}
