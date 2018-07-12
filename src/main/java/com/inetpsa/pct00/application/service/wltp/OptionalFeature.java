
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionalFeature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OptionalFeature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="classe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="PriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="CommercialOffers" type="{http://inetpsa.com/cfg}CommercialOffers" minOccurs="0"/>
 *         &lt;element name="assembly" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="selection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Co2Variation" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Co2Global" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionalFeature", propOrder = {
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
    "specific",
    "co2Variation",
    "co2Global"
})
@XmlSeeAlso({
    OptionalFeatureV2 .class
})
public class OptionalFeature {

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
    @XmlElement(name = "Price", required = true)
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
    protected String specific;
    @XmlElement(name = "Co2Variation")
    protected Float co2Variation;
    @XmlElement(name = "Co2Global")
    protected Float co2Global;

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
     * Gets the value of the specific property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecific() {
        return specific;
    }

    /**
     * Sets the value of the specific property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecific(String value) {
        this.specific = value;
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

}
