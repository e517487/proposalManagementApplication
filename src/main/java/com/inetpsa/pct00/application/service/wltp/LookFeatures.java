
package com.inetpsa.pct00.application.service.wltp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LookFeatures complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookFeatures">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InteriorFeatures" type="{http://inetpsa.com/cfg}OptionalFeature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExteriorFeatures" type="{http://inetpsa.com/cfg}OptionalFeature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookFeatures", propOrder = {
    "interiorFeatures",
    "exteriorFeatures"
})
public class LookFeatures {

    @XmlElement(name = "InteriorFeatures")
    protected List<OptionalFeature> interiorFeatures;
    @XmlElement(name = "ExteriorFeatures")
    protected List<OptionalFeature> exteriorFeatures;

    /**
     * Gets the value of the interiorFeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorFeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorFeatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionalFeature }
     * 
     * 
     */
    public List<OptionalFeature> getInteriorFeatures() {
        if (interiorFeatures == null) {
            interiorFeatures = new ArrayList<OptionalFeature>();
        }
        return this.interiorFeatures;
    }

    /**
     * Gets the value of the exteriorFeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exteriorFeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExteriorFeatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionalFeature }
     * 
     * 
     */
    public List<OptionalFeature> getExteriorFeatures() {
        if (exteriorFeatures == null) {
            exteriorFeatures = new ArrayList<OptionalFeature>();
        }
        return this.exteriorFeatures;
    }

}
