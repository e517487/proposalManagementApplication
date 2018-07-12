
package com.inetpsa.pct00.application.service.wltp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StandardCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StandardCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="StandardFeatures" type="{http://inetpsa.com/cfg}StandardFeature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Packs100" type="{http://inetpsa.com/cfg}Pack100" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardCategory", propOrder = {
    "id",
    "label",
    "rank",
    "standardFeatures",
    "packs100"
})
public class StandardCategory {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String label;
    protected int rank;
    @XmlElement(name = "StandardFeatures")
    protected List<StandardFeature> standardFeatures;
    @XmlElement(name = "Packs100")
    protected List<Pack100> packs100;

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
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     */
    public void setRank(int value) {
        this.rank = value;
    }

    /**
     * Gets the value of the standardFeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardFeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardFeatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardFeature }
     * 
     * 
     */
    public List<StandardFeature> getStandardFeatures() {
        if (standardFeatures == null) {
            standardFeatures = new ArrayList<StandardFeature>();
        }
        return this.standardFeatures;
    }

    /**
     * Gets the value of the packs100 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packs100 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPacks100().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pack100 }
     * 
     * 
     */
    public List<Pack100> getPacks100() {
        if (packs100 == null) {
            packs100 = new ArrayList<Pack100>();
        }
        return this.packs100;
    }

}
