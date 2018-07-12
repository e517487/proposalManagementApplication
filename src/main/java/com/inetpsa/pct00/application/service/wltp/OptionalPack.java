
package com.inetpsa.pct00.application.service.wltp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionalPack complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionalPack">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="classe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="CommercialOffers" type="{http://inetpsa.com/cfg}CommercialOffers" minOccurs="0"/>
 *         &lt;element name="assembly" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="selection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forced" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Co2Variation" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Co2Global" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PackFeatures" type="{http://inetpsa.com/cfg}PackFeature" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element name="Status" type="{http://inetpsa.com/cfg}GeosStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionalPack", propOrder = {
    "id",
    "code",
    "rank",
    "classe",
    "label",
    "description",
    "price",
    "priceTtc",
    "priceMrip",
    "priceMripTtc",
    "commercialOffers",
    "assembly",
    "selection",
    "forced",
    "co2Variation",
    "co2Global",
    "packFeatures",
    "status"
})
public class OptionalPack {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String code;
    protected int rank;
    @XmlElement(required = true)
    protected String classe;
    @XmlElement(required = true)
    protected String label;
    protected String description;
    @XmlElement(name = "Price")
    protected Price price;
    @XmlElement(name = "PriceTtc")
    protected Price priceTtc;
    @XmlElement(name = "PriceMrip")
    protected Price priceMrip;
    @XmlElement(name = "PriceMripTtc")
    protected Price priceMripTtc;
    @XmlElement(name = "CommercialOffers")
    protected CommercialOffers commercialOffers;
    protected int assembly;
    protected String selection;
    protected boolean forced;
    @XmlElement(name = "Co2Variation")
    protected Float co2Variation;
    @XmlElement(name = "Co2Global")
    protected Float co2Global;
    @XmlElement(name = "PackFeatures", required = true)
    protected List<PackFeature> packFeatures;
    @XmlElement(name = "Status")
    protected GeosStatus status;

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
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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
     * Gets the value of the classe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasse() {
        return classe;
    }

    /**
     * Sets the value of the classe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasse(String value) {
        this.classe = value;
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
    }

    /**
     * Gets the value of the priceTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPriceTtc() {
        return priceTtc;
    }

    /**
     * Sets the value of the priceTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPriceTtc(Price value) {
        this.priceTtc = value;
    }

    /**
     * Gets the value of the priceMrip property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPriceMrip() {
        return priceMrip;
    }

    /**
     * Sets the value of the priceMrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPriceMrip(Price value) {
        this.priceMrip = value;
    }

    /**
     * Gets the value of the priceMripTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPriceMripTtc() {
        return priceMripTtc;
    }

    /**
     * Sets the value of the priceMripTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPriceMripTtc(Price value) {
        this.priceMripTtc = value;
    }

    /**
     * Gets the value of the commercialOffers property.
     * 
     * @return
     *     possible object is
     *     {@link CommercialOffers }
     *     
     */
    public CommercialOffers getCommercialOffers() {
        return commercialOffers;
    }

    /**
     * Sets the value of the commercialOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialOffers }
     *     
     */
    public void setCommercialOffers(CommercialOffers value) {
        this.commercialOffers = value;
    }

    /**
     * Gets the value of the assembly property.
     * 
     */
    public int getAssembly() {
        return assembly;
    }

    /**
     * Sets the value of the assembly property.
     * 
     */
    public void setAssembly(int value) {
        this.assembly = value;
    }

    /**
     * Gets the value of the selection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelection() {
        return selection;
    }

    /**
     * Sets the value of the selection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelection(String value) {
        this.selection = value;
    }

    /**
     * Gets the value of the forced property.
     * 
     */
    public boolean isForced() {
        return forced;
    }

    /**
     * Sets the value of the forced property.
     * 
     */
    public void setForced(boolean value) {
        this.forced = value;
    }

    /**
     * Gets the value of the co2Variation property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCo2Variation() {
        return co2Variation;
    }

    /**
     * Sets the value of the co2Variation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCo2Variation(Float value) {
        this.co2Variation = value;
    }

    /**
     * Gets the value of the co2Global property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCo2Global() {
        return co2Global;
    }

    /**
     * Sets the value of the co2Global property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCo2Global(Float value) {
        this.co2Global = value;
    }

    /**
     * Gets the value of the packFeatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packFeatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackFeatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PackFeature }
     * 
     * 
     */
    public List<PackFeature> getPackFeatures() {
        if (packFeatures == null) {
            packFeatures = new ArrayList<PackFeature>();
        }
        return this.packFeatures;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link GeosStatus }
     *     
     */
    public GeosStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeosStatus }
     *     
     */
    public void setStatus(GeosStatus value) {
        this.status = value;
    }

}
