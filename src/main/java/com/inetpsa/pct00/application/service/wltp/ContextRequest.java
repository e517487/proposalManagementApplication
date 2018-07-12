
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ContextRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContextRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Client" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Brand">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *               &lt;enumeration value="P"/>
 *               &lt;enumeration value="C"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;choice>
 *           &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;element name="TariffCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *         &lt;element name="LanguageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Network" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="TaxIncluded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="ShowBothPrices" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *           &lt;element name="ProfessionalUse" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;/choice>
 *         &lt;element name="ShowMRIP" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowBonusMalus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TariffZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalCurrency" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowUnavailableLooks" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowUnavailableOptionalFeatures" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowStatus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GeosStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShowEcommerce" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContextRequest", propOrder = {
    "client",
    "brand",
    "country",
    "date",
    "tariffCode",
    "languageID",
    "network",
    "taxIncluded",
    "showBothPrices",
    "professionalUse",
    "showMRIP",
    "showBonusMalus",
    "tariffZone",
    "localCurrency",
    "showUnavailableLooks",
    "showUnavailableOptionalFeatures",
    "showStatus",
    "geosStatus",
    "showEcommerce"
})
public class ContextRequest {

    @XmlElement(name = "Client", required = true)
    protected String client;
    @XmlElement(name = "Brand", required = true)
    protected String brand;
    @XmlElement(name = "Country", required = true)
    protected String country;
    @XmlElement(name = "Date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "TariffCode")
    protected String tariffCode;
    @XmlElement(name = "LanguageID")
    protected String languageID;
    @XmlElement(name = "Network", defaultValue = "false")
    protected Boolean network;
    @XmlElement(name = "TaxIncluded", defaultValue = "true")
    protected Boolean taxIncluded;
    @XmlElement(name = "ShowBothPrices", defaultValue = "false")
    protected Boolean showBothPrices;
    @XmlElement(name = "ProfessionalUse", defaultValue = "false")
    protected Boolean professionalUse;
    @XmlElement(name = "ShowMRIP", defaultValue = "false")
    protected Boolean showMRIP;
    @XmlElement(name = "ShowBonusMalus", defaultValue = "false")
    protected Boolean showBonusMalus;
    @XmlElement(name = "TariffZone")
    protected String tariffZone;
    @XmlElement(name = "LocalCurrency", defaultValue = "false")
    protected Boolean localCurrency;
    @XmlElement(name = "ShowUnavailableLooks", defaultValue = "true")
    protected Boolean showUnavailableLooks;
    @XmlElement(name = "ShowUnavailableOptionalFeatures", defaultValue = "false")
    protected Boolean showUnavailableOptionalFeatures;
    @XmlElement(name = "ShowStatus", defaultValue = "false")
    protected Boolean showStatus;
    @XmlElement(name = "GeosStatus")
    protected String geosStatus;
    @XmlElement(name = "ShowEcommerce", defaultValue = "false")
    protected Boolean showEcommerce;

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClient(String value) {
        this.client = value;
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the tariffCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffCode() {
        return tariffCode;
    }

    /**
     * Sets the value of the tariffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffCode(String value) {
        this.tariffCode = value;
    }

    /**
     * Gets the value of the languageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * Sets the value of the languageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageID(String value) {
        this.languageID = value;
    }

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetwork(Boolean value) {
        this.network = value;
    }

    /**
     * Gets the value of the taxIncluded property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTaxIncluded() {
        return taxIncluded;
    }

    /**
     * Sets the value of the taxIncluded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxIncluded(Boolean value) {
        this.taxIncluded = value;
    }

    /**
     * Gets the value of the showBothPrices property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowBothPrices() {
        return showBothPrices;
    }

    /**
     * Sets the value of the showBothPrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowBothPrices(Boolean value) {
        this.showBothPrices = value;
    }

    /**
     * Gets the value of the professionalUse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProfessionalUse() {
        return professionalUse;
    }

    /**
     * Sets the value of the professionalUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProfessionalUse(Boolean value) {
        this.professionalUse = value;
    }

    /**
     * Gets the value of the showMRIP property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowMRIP() {
        return showMRIP;
    }

    /**
     * Sets the value of the showMRIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowMRIP(Boolean value) {
        this.showMRIP = value;
    }

    /**
     * Gets the value of the showBonusMalus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowBonusMalus() {
        return showBonusMalus;
    }

    /**
     * Sets the value of the showBonusMalus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowBonusMalus(Boolean value) {
        this.showBonusMalus = value;
    }

    /**
     * Gets the value of the tariffZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTariffZone() {
        return tariffZone;
    }

    /**
     * Sets the value of the tariffZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTariffZone(String value) {
        this.tariffZone = value;
    }

    /**
     * Gets the value of the localCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLocalCurrency() {
        return localCurrency;
    }

    /**
     * Sets the value of the localCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLocalCurrency(Boolean value) {
        this.localCurrency = value;
    }

    /**
     * Gets the value of the showUnavailableLooks property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowUnavailableLooks() {
        return showUnavailableLooks;
    }

    /**
     * Sets the value of the showUnavailableLooks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowUnavailableLooks(Boolean value) {
        this.showUnavailableLooks = value;
    }

    /**
     * Gets the value of the showUnavailableOptionalFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowUnavailableOptionalFeatures() {
        return showUnavailableOptionalFeatures;
    }

    /**
     * Sets the value of the showUnavailableOptionalFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowUnavailableOptionalFeatures(Boolean value) {
        this.showUnavailableOptionalFeatures = value;
    }

    /**
     * Gets the value of the showStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowStatus() {
        return showStatus;
    }

    /**
     * Sets the value of the showStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowStatus(Boolean value) {
        this.showStatus = value;
    }

    /**
     * Gets the value of the geosStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeosStatus() {
        return geosStatus;
    }

    /**
     * Sets the value of the geosStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeosStatus(String value) {
        this.geosStatus = value;
    }

    /**
     * Gets the value of the showEcommerce property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowEcommerce() {
        return showEcommerce;
    }

    /**
     * Sets the value of the showEcommerce property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowEcommerce(Boolean value) {
        this.showEcommerce = value;
    }

}
