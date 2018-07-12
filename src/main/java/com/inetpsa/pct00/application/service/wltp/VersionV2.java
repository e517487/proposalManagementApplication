
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionV2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://inetpsa.com/cfg}VersionAbstract">
 *       &lt;sequence>
 *         &lt;element name="LookFeatures" type="{http://inetpsa.com/cfg}LookFeaturesV2"/>
 *         &lt;element name="FlagWLTP" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BaseVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WLTPCharacteristics" type="{http://inetpsa.com/cfg}WLTPCharacteristics" minOccurs="0"/>
 *         &lt;element name="GrTypeBoiteVitesse" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrNumberOfDoors" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrBrand" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrDistrBrand" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="DerivedModels" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="EcoLabelText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GrEcommerce" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionV2", propOrder = {
    "lookFeatures",
    "flagWLTP",
    "baseVersion",
    "wltpCharacteristics",
    "grTypeBoiteVitesse",
    "grNumberOfDoors",
    "grBrand",
    "grDistrBrand",
    "derivedModels",
    "ecoLabelText",
    "grEcommerce"
})
public class VersionV2
    extends VersionAbstract
{

    @XmlElement(name = "LookFeatures", required = true)
    protected LookFeaturesV2 lookFeatures;
    @XmlElement(name = "FlagWLTP")
    protected Boolean flagWLTP;
    @XmlElement(name = "BaseVersion")
    protected String baseVersion;
    @XmlElement(name = "WLTPCharacteristics")
    protected WLTPCharacteristics wltpCharacteristics;
    @XmlElement(name = "GrTypeBoiteVitesse")
    protected Identification grTypeBoiteVitesse;
    @XmlElement(name = "GrNumberOfDoors")
    protected Identification grNumberOfDoors;
    @XmlElement(name = "GrBrand")
    protected Identification grBrand;
    @XmlElement(name = "GrDistrBrand")
    protected Identification grDistrBrand;
    @XmlElement(name = "DerivedModels")
    protected Identification derivedModels;
    @XmlElement(name = "EcoLabelText")
    protected String ecoLabelText;
    @XmlElement(name = "GrEcommerce")
    protected Identification grEcommerce;

    /**
     * Gets the value of the lookFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link LookFeaturesV2 }
     *     
     */
    public LookFeaturesV2 getLookFeatures() {
        return lookFeatures;
    }

    /**
     * Sets the value of the lookFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookFeaturesV2 }
     *     
     */
    public void setLookFeatures(LookFeaturesV2 value) {
        this.lookFeatures = value;
    }

    /**
     * Gets the value of the flagWLTP property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFlagWLTP() {
        return flagWLTP;
    }

    /**
     * Sets the value of the flagWLTP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFlagWLTP(Boolean value) {
        this.flagWLTP = value;
    }

    /**
     * Gets the value of the baseVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseVersion() {
        return baseVersion;
    }

    /**
     * Sets the value of the baseVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseVersion(String value) {
        this.baseVersion = value;
    }

    /**
     * Gets the value of the wltpCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link WLTPCharacteristics }
     *     
     */
    public WLTPCharacteristics getWLTPCharacteristics() {
        return wltpCharacteristics;
    }

    /**
     * Sets the value of the wltpCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link WLTPCharacteristics }
     *     
     */
    public void setWLTPCharacteristics(WLTPCharacteristics value) {
        this.wltpCharacteristics = value;
    }

    /**
     * Gets the value of the grTypeBoiteVitesse property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrTypeBoiteVitesse() {
        return grTypeBoiteVitesse;
    }

    /**
     * Sets the value of the grTypeBoiteVitesse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrTypeBoiteVitesse(Identification value) {
        this.grTypeBoiteVitesse = value;
    }

    /**
     * Gets the value of the grNumberOfDoors property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrNumberOfDoors() {
        return grNumberOfDoors;
    }

    /**
     * Sets the value of the grNumberOfDoors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrNumberOfDoors(Identification value) {
        this.grNumberOfDoors = value;
    }

    /**
     * Gets the value of the grBrand property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrBrand() {
        return grBrand;
    }

    /**
     * Sets the value of the grBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrBrand(Identification value) {
        this.grBrand = value;
    }

    /**
     * Gets the value of the grDistrBrand property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrDistrBrand() {
        return grDistrBrand;
    }

    /**
     * Sets the value of the grDistrBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrDistrBrand(Identification value) {
        this.grDistrBrand = value;
    }

    /**
     * Gets the value of the derivedModels property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getDerivedModels() {
        return derivedModels;
    }

    /**
     * Sets the value of the derivedModels property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setDerivedModels(Identification value) {
        this.derivedModels = value;
    }

    /**
     * Gets the value of the ecoLabelText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEcoLabelText() {
        return ecoLabelText;
    }

    /**
     * Sets the value of the ecoLabelText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEcoLabelText(String value) {
        this.ecoLabelText = value;
    }

    /**
     * Gets the value of the grEcommerce property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrEcommerce() {
        return grEcommerce;
    }

    /**
     * Sets the value of the grEcommerce property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrEcommerce(Identification value) {
        this.grEcommerce = value;
    }

}
