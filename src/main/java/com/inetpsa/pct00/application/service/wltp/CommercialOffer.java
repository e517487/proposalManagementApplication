
package com.inetpsa.pct00.application.service.wltp;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CommercialOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommercialOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idOc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idRemise" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applied" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="onBasePrice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="offer" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="offerStartDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="offerEndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="offerPartMar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="offerPartCre" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avantageClient" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommercialOffer", propOrder = {
    "idOc",
    "idRemise",
    "label",
    "description",
    "applied",
    "discount",
    "onBasePrice",
    "amount",
    "offer",
    "offerStartDate",
    "offerEndDate",
    "offerPartMar",
    "offerPartCre",
    "order",
    "avantageClient"
})
public class CommercialOffer {

    protected int idOc;
    protected int idRemise;
    @XmlElement(required = true)
    protected String label;
    @XmlElement(required = true)
    protected String description;
    protected boolean applied;
    @XmlElement(required = true)
    protected BigDecimal discount;
    protected Boolean onBasePrice;
    protected boolean amount;
    @XmlElement(required = true)
    protected BigDecimal offer;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar offerStartDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar offerEndDate;
    @XmlElement(required = true)
    protected BigDecimal offerPartMar;
    @XmlElement(required = true)
    protected BigDecimal offerPartCre;
    protected String order;
    protected Boolean avantageClient;

    /**
     * Gets the value of the idOc property.
     * 
     */
    public int getIdOc() {
        return idOc;
    }

    /**
     * Sets the value of the idOc property.
     * 
     */
    public void setIdOc(int value) {
        this.idOc = value;
    }

    /**
     * Gets the value of the idRemise property.
     * 
     */
    public int getIdRemise() {
        return idRemise;
    }

    /**
     * Sets the value of the idRemise property.
     * 
     */
    public void setIdRemise(int value) {
        this.idRemise = value;
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
     * Gets the value of the applied property.
     * 
     */
    public boolean isApplied() {
        return applied;
    }

    /**
     * Sets the value of the applied property.
     * 
     */
    public void setApplied(boolean value) {
        this.applied = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiscount(BigDecimal value) {
        this.discount = value;
    }

    /**
     * Gets the value of the onBasePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnBasePrice() {
        return onBasePrice;
    }

    /**
     * Sets the value of the onBasePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnBasePrice(Boolean value) {
        this.onBasePrice = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public boolean isAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(boolean value) {
        this.amount = value;
    }

    /**
     * Gets the value of the offer property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOffer() {
        return offer;
    }

    /**
     * Sets the value of the offer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOffer(BigDecimal value) {
        this.offer = value;
    }

    /**
     * Gets the value of the offerStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOfferStartDate() {
        return offerStartDate;
    }

    /**
     * Sets the value of the offerStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOfferStartDate(XMLGregorianCalendar value) {
        this.offerStartDate = value;
    }

    /**
     * Gets the value of the offerEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOfferEndDate() {
        return offerEndDate;
    }

    /**
     * Sets the value of the offerEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOfferEndDate(XMLGregorianCalendar value) {
        this.offerEndDate = value;
    }

    /**
     * Gets the value of the offerPartMar property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOfferPartMar() {
        return offerPartMar;
    }

    /**
     * Sets the value of the offerPartMar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOfferPartMar(BigDecimal value) {
        this.offerPartMar = value;
    }

    /**
     * Gets the value of the offerPartCre property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOfferPartCre() {
        return offerPartCre;
    }

    /**
     * Sets the value of the offerPartCre property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOfferPartCre(BigDecimal value) {
        this.offerPartCre = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

    /**
     * Gets the value of the avantageClient property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvantageClient() {
        return avantageClient;
    }

    /**
     * Sets the value of the avantageClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvantageClient(Boolean value) {
        this.avantageClient = value;
    }

}
