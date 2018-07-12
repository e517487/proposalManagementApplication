
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VersionAbstract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VersionAbstract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdVersion" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="Tariff" type="{http://inetpsa.com/cfg}Tariff" minOccurs="0"/>
 *         &lt;element name="VehicleUse" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="Model" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="VehiclePrice" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="Price" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="FeaturesPrice" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="OptionalFeaturesPrice" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="LookFeaturesPrice" type="{http://inetpsa.com/cfg}Price"/>
 *         &lt;element name="VehiclePriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="FeaturesPriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="OptionalFeaturesPriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="LookFeaturesPriceTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="VehiclePriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="FeaturesPriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="OptionalFeaturesPriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="LookFeaturesPriceMrip" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="VehiclePriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="PriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="FeaturesPriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="OptionalFeaturesPriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="LookFeaturesPriceMripTtc" type="{http://inetpsa.com/cfg}Price" minOccurs="0"/>
 *         &lt;element name="CommercialOffers" type="{http://inetpsa.com/cfg}CommercialOffers" minOccurs="0"/>
 *         &lt;element name="Grade" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="BodyStyle" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrbodyStyle" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="DesignClass" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="CustomerType" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="ModelYear" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="ModelYearModification" type="{http://inetpsa.com/cfg}Identification"/>
 *         &lt;element name="CommercialName" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrCommercialName" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="Engine" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrEngine" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="TransmissionType" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="GrTransmissionType" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="Energy" type="{http://inetpsa.com/cfg}Identification" minOccurs="0"/>
 *         &lt;element name="Co2Rate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="Co2RateComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="Co2Class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EcoLabel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MixedConsumption" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="MixedConsumptionComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="UsefulIntLength" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="UsefulIntLengthComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="UsefulIntHeight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="UsefulIntHeightComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="ExteriorLength" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ExteriorLengthComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="ExteriorHeight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="ExteriorHeightComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="TrunkVolume" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="TrunkVolumeComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="PayloadVolume" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PayloadVolumeComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="UsefulTrayLength" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="UsefulTrayLengthComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="NumSittedPlaces" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NumSittedPlacesComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="PayloadWeight" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="PayloadWeightComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="BodyLength" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="BodyLengthComplex" type="{http://inetpsa.com/cfg}TechCharComplex" minOccurs="0"/>
 *         &lt;element name="Characteristic1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Characteristic2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Characteristic3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Characteristic4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExtendedCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VisualCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StandardFeatures" type="{http://inetpsa.com/cfg}StandardCategories"/>
 *         &lt;element name="TechnicalCharacteristics" type="{http://inetpsa.com/cfg}TechnicalCharacteristicsCategories"/>
 *         &lt;element name="OptionalFeatures" type="{http://inetpsa.com/cfg}OptionalFeaturesCategories"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VersionAbstract", propOrder = {
    "idVersion",
    "tariff",
    "vehicleUse",
    "model",
    "vehiclePrice",
    "price",
    "featuresPrice",
    "optionalFeaturesPrice",
    "lookFeaturesPrice",
    "vehiclePriceTtc",
    "priceTtc",
    "featuresPriceTtc",
    "optionalFeaturesPriceTtc",
    "lookFeaturesPriceTtc",
    "vehiclePriceMrip",
    "priceMrip",
    "featuresPriceMrip",
    "optionalFeaturesPriceMrip",
    "lookFeaturesPriceMrip",
    "vehiclePriceMripTtc",
    "priceMripTtc",
    "featuresPriceMripTtc",
    "optionalFeaturesPriceMripTtc",
    "lookFeaturesPriceMripTtc",
    "commercialOffers",
    "grade",
    "bodyStyle",
    "grbodyStyle",
    "designClass",
    "customerType",
    "modelYear",
    "modelYearModification",
    "commercialName",
    "grCommercialName",
    "engine",
    "grEngine",
    "transmissionType",
    "grTransmissionType",
    "energy",
    "co2Rate",
    "co2RateComplex",
    "co2Class",
    "ecoLabel",
    "mixedConsumption",
    "mixedConsumptionComplex",
    "usefulIntLength",
    "usefulIntLengthComplex",
    "usefulIntHeight",
    "usefulIntHeightComplex",
    "exteriorLength",
    "exteriorLengthComplex",
    "exteriorHeight",
    "exteriorHeightComplex",
    "trunkVolume",
    "trunkVolumeComplex",
    "payloadVolume",
    "payloadVolumeComplex",
    "usefulTrayLength",
    "usefulTrayLengthComplex",
    "numSittedPlaces",
    "numSittedPlacesComplex",
    "payloadWeight",
    "payloadWeightComplex",
    "bodyLength",
    "bodyLengthComplex",
    "characteristic1",
    "characteristic2",
    "characteristic3",
    "characteristic4",
    "extendedCode",
    "visualCode",
    "standardFeatures",
    "technicalCharacteristics",
    "optionalFeatures"
})
@XmlSeeAlso({
    VersionV2 .class,
    Version.class
})
public abstract class VersionAbstract {

    @XmlElement(name = "IdVersion", required = true)
    protected Identification idVersion;
    @XmlElement(name = "Tariff")
    protected Tariff tariff;
    @XmlElement(name = "VehicleUse")
    protected Identification vehicleUse;
    @XmlElement(name = "Model", required = true)
    protected Identification model;
    @XmlElement(name = "VehiclePrice", required = true)
    protected Price vehiclePrice;
    @XmlElement(name = "Price", required = true)
    protected Price price;
    @XmlElement(name = "FeaturesPrice", required = true)
    protected Price featuresPrice;
    @XmlElement(name = "OptionalFeaturesPrice", required = true)
    protected Price optionalFeaturesPrice;
    @XmlElement(name = "LookFeaturesPrice", required = true)
    protected Price lookFeaturesPrice;
    @XmlElement(name = "VehiclePriceTtc")
    protected Price vehiclePriceTtc;
    @XmlElement(name = "PriceTtc")
    protected Price priceTtc;
    @XmlElement(name = "FeaturesPriceTtc")
    protected Price featuresPriceTtc;
    @XmlElement(name = "OptionalFeaturesPriceTtc")
    protected Price optionalFeaturesPriceTtc;
    @XmlElement(name = "LookFeaturesPriceTtc")
    protected Price lookFeaturesPriceTtc;
    @XmlElement(name = "VehiclePriceMrip")
    protected Price vehiclePriceMrip;
    @XmlElement(name = "PriceMrip")
    protected Price priceMrip;
    @XmlElement(name = "FeaturesPriceMrip")
    protected Price featuresPriceMrip;
    @XmlElement(name = "OptionalFeaturesPriceMrip")
    protected Price optionalFeaturesPriceMrip;
    @XmlElement(name = "LookFeaturesPriceMrip")
    protected Price lookFeaturesPriceMrip;
    @XmlElement(name = "VehiclePriceMripTtc")
    protected Price vehiclePriceMripTtc;
    @XmlElement(name = "PriceMripTtc")
    protected Price priceMripTtc;
    @XmlElement(name = "FeaturesPriceMripTtc")
    protected Price featuresPriceMripTtc;
    @XmlElement(name = "OptionalFeaturesPriceMripTtc")
    protected Price optionalFeaturesPriceMripTtc;
    @XmlElement(name = "LookFeaturesPriceMripTtc")
    protected Price lookFeaturesPriceMripTtc;
    @XmlElement(name = "CommercialOffers")
    protected CommercialOffers commercialOffers;
    @XmlElement(name = "Grade")
    protected Identification grade;
    @XmlElement(name = "BodyStyle")
    protected Identification bodyStyle;
    @XmlElement(name = "GrbodyStyle")
    protected Identification grbodyStyle;
    @XmlElement(name = "DesignClass", required = true)
    protected Identification designClass;
    @XmlElement(name = "CustomerType", required = true)
    protected Identification customerType;
    @XmlElement(name = "ModelYear", required = true)
    protected Identification modelYear;
    @XmlElement(name = "ModelYearModification", required = true)
    protected Identification modelYearModification;
    @XmlElement(name = "CommercialName")
    protected Identification commercialName;
    @XmlElement(name = "GrCommercialName")
    protected Identification grCommercialName;
    @XmlElement(name = "Engine")
    protected Identification engine;
    @XmlElement(name = "GrEngine")
    protected Identification grEngine;
    @XmlElement(name = "TransmissionType")
    protected Identification transmissionType;
    @XmlElement(name = "GrTransmissionType")
    protected Identification grTransmissionType;
    @XmlElement(name = "Energy")
    protected Identification energy;
    @XmlElement(name = "Co2Rate")
    protected Float co2Rate;
    @XmlElement(name = "Co2RateComplex")
    protected TechCharComplex co2RateComplex;
    @XmlElement(name = "Co2Class")
    protected String co2Class;
    @XmlElement(name = "EcoLabel")
    protected Boolean ecoLabel;
    @XmlElement(name = "MixedConsumption")
    protected Float mixedConsumption;
    @XmlElement(name = "MixedConsumptionComplex")
    protected TechCharComplex mixedConsumptionComplex;
    @XmlElement(name = "UsefulIntLength")
    protected Float usefulIntLength;
    @XmlElement(name = "UsefulIntLengthComplex")
    protected TechCharComplex usefulIntLengthComplex;
    @XmlElement(name = "UsefulIntHeight")
    protected Float usefulIntHeight;
    @XmlElement(name = "UsefulIntHeightComplex")
    protected TechCharComplex usefulIntHeightComplex;
    @XmlElement(name = "ExteriorLength")
    protected Float exteriorLength;
    @XmlElement(name = "ExteriorLengthComplex")
    protected TechCharComplex exteriorLengthComplex;
    @XmlElement(name = "ExteriorHeight")
    protected Float exteriorHeight;
    @XmlElement(name = "ExteriorHeightComplex")
    protected TechCharComplex exteriorHeightComplex;
    @XmlElement(name = "TrunkVolume")
    protected Float trunkVolume;
    @XmlElement(name = "TrunkVolumeComplex")
    protected TechCharComplex trunkVolumeComplex;
    @XmlElement(name = "PayloadVolume")
    protected Float payloadVolume;
    @XmlElement(name = "PayloadVolumeComplex")
    protected TechCharComplex payloadVolumeComplex;
    @XmlElement(name = "UsefulTrayLength")
    protected Float usefulTrayLength;
    @XmlElement(name = "UsefulTrayLengthComplex")
    protected TechCharComplex usefulTrayLengthComplex;
    @XmlElement(name = "NumSittedPlaces")
    protected Integer numSittedPlaces;
    @XmlElement(name = "NumSittedPlacesComplex")
    protected TechCharComplex numSittedPlacesComplex;
    @XmlElement(name = "PayloadWeight")
    protected Float payloadWeight;
    @XmlElement(name = "PayloadWeightComplex")
    protected TechCharComplex payloadWeightComplex;
    @XmlElement(name = "BodyLength")
    protected Float bodyLength;
    @XmlElement(name = "BodyLengthComplex")
    protected TechCharComplex bodyLengthComplex;
    @XmlElement(name = "Characteristic1")
    protected String characteristic1;
    @XmlElement(name = "Characteristic2")
    protected String characteristic2;
    @XmlElement(name = "Characteristic3")
    protected String characteristic3;
    @XmlElement(name = "Characteristic4")
    protected String characteristic4;
    @XmlElement(name = "ExtendedCode")
    protected String extendedCode;
    @XmlElement(name = "VisualCode")
    protected String visualCode;
    @XmlElement(name = "StandardFeatures", required = true)
    protected StandardCategories standardFeatures;
    @XmlElement(name = "TechnicalCharacteristics", required = true)
    protected TechnicalCharacteristicsCategories technicalCharacteristics;
    @XmlElement(name = "OptionalFeatures", required = true)
    protected OptionalFeaturesCategories optionalFeatures;

    /**
     * Gets the value of the idVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getIdVersion() {
        return idVersion;
    }

    /**
     * Sets the value of the idVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setIdVersion(Identification value) {
        this.idVersion = value;
    }

    /**
     * Gets the value of the tariff property.
     * 
     * @return
     *     possible object is
     *     {@link Tariff }
     *     
     */
    public Tariff getTariff() {
        return tariff;
    }

    /**
     * Sets the value of the tariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tariff }
     *     
     */
    public void setTariff(Tariff value) {
        this.tariff = value;
    }

    /**
     * Gets the value of the vehicleUse property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getVehicleUse() {
        return vehicleUse;
    }

    /**
     * Sets the value of the vehicleUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setVehicleUse(Identification value) {
        this.vehicleUse = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setModel(Identification value) {
        this.model = value;
    }

    /**
     * Gets the value of the vehiclePrice property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getVehiclePrice() {
        return vehiclePrice;
    }

    /**
     * Sets the value of the vehiclePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setVehiclePrice(Price value) {
        this.vehiclePrice = value;
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
     * Gets the value of the featuresPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getFeaturesPrice() {
        return featuresPrice;
    }

    /**
     * Sets the value of the featuresPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setFeaturesPrice(Price value) {
        this.featuresPrice = value;
    }

    /**
     * Gets the value of the optionalFeaturesPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getOptionalFeaturesPrice() {
        return optionalFeaturesPrice;
    }

    /**
     * Sets the value of the optionalFeaturesPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setOptionalFeaturesPrice(Price value) {
        this.optionalFeaturesPrice = value;
    }

    /**
     * Gets the value of the lookFeaturesPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getLookFeaturesPrice() {
        return lookFeaturesPrice;
    }

    /**
     * Sets the value of the lookFeaturesPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setLookFeaturesPrice(Price value) {
        this.lookFeaturesPrice = value;
    }

    /**
     * Gets the value of the vehiclePriceTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getVehiclePriceTtc() {
        return vehiclePriceTtc;
    }

    /**
     * Sets the value of the vehiclePriceTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setVehiclePriceTtc(Price value) {
        this.vehiclePriceTtc = value;
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
     * Gets the value of the featuresPriceTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getFeaturesPriceTtc() {
        return featuresPriceTtc;
    }

    /**
     * Sets the value of the featuresPriceTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setFeaturesPriceTtc(Price value) {
        this.featuresPriceTtc = value;
    }

    /**
     * Gets the value of the optionalFeaturesPriceTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getOptionalFeaturesPriceTtc() {
        return optionalFeaturesPriceTtc;
    }

    /**
     * Sets the value of the optionalFeaturesPriceTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setOptionalFeaturesPriceTtc(Price value) {
        this.optionalFeaturesPriceTtc = value;
    }

    /**
     * Gets the value of the lookFeaturesPriceTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getLookFeaturesPriceTtc() {
        return lookFeaturesPriceTtc;
    }

    /**
     * Sets the value of the lookFeaturesPriceTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setLookFeaturesPriceTtc(Price value) {
        this.lookFeaturesPriceTtc = value;
    }

    /**
     * Gets the value of the vehiclePriceMrip property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getVehiclePriceMrip() {
        return vehiclePriceMrip;
    }

    /**
     * Sets the value of the vehiclePriceMrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setVehiclePriceMrip(Price value) {
        this.vehiclePriceMrip = value;
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
     * Gets the value of the featuresPriceMrip property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getFeaturesPriceMrip() {
        return featuresPriceMrip;
    }

    /**
     * Sets the value of the featuresPriceMrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setFeaturesPriceMrip(Price value) {
        this.featuresPriceMrip = value;
    }

    /**
     * Gets the value of the optionalFeaturesPriceMrip property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getOptionalFeaturesPriceMrip() {
        return optionalFeaturesPriceMrip;
    }

    /**
     * Sets the value of the optionalFeaturesPriceMrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setOptionalFeaturesPriceMrip(Price value) {
        this.optionalFeaturesPriceMrip = value;
    }

    /**
     * Gets the value of the lookFeaturesPriceMrip property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getLookFeaturesPriceMrip() {
        return lookFeaturesPriceMrip;
    }

    /**
     * Sets the value of the lookFeaturesPriceMrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setLookFeaturesPriceMrip(Price value) {
        this.lookFeaturesPriceMrip = value;
    }

    /**
     * Gets the value of the vehiclePriceMripTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getVehiclePriceMripTtc() {
        return vehiclePriceMripTtc;
    }

    /**
     * Sets the value of the vehiclePriceMripTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setVehiclePriceMripTtc(Price value) {
        this.vehiclePriceMripTtc = value;
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
     * Gets the value of the featuresPriceMripTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getFeaturesPriceMripTtc() {
        return featuresPriceMripTtc;
    }

    /**
     * Sets the value of the featuresPriceMripTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setFeaturesPriceMripTtc(Price value) {
        this.featuresPriceMripTtc = value;
    }

    /**
     * Gets the value of the optionalFeaturesPriceMripTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getOptionalFeaturesPriceMripTtc() {
        return optionalFeaturesPriceMripTtc;
    }

    /**
     * Sets the value of the optionalFeaturesPriceMripTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setOptionalFeaturesPriceMripTtc(Price value) {
        this.optionalFeaturesPriceMripTtc = value;
    }

    /**
     * Gets the value of the lookFeaturesPriceMripTtc property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getLookFeaturesPriceMripTtc() {
        return lookFeaturesPriceMripTtc;
    }

    /**
     * Sets the value of the lookFeaturesPriceMripTtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setLookFeaturesPriceMripTtc(Price value) {
        this.lookFeaturesPriceMripTtc = value;
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
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrade(Identification value) {
        this.grade = value;
    }

    /**
     * Gets the value of the bodyStyle property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getBodyStyle() {
        return bodyStyle;
    }

    /**
     * Sets the value of the bodyStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setBodyStyle(Identification value) {
        this.bodyStyle = value;
    }

    /**
     * Gets the value of the grbodyStyle property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrbodyStyle() {
        return grbodyStyle;
    }

    /**
     * Sets the value of the grbodyStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrbodyStyle(Identification value) {
        this.grbodyStyle = value;
    }

    /**
     * Gets the value of the designClass property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getDesignClass() {
        return designClass;
    }

    /**
     * Sets the value of the designClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setDesignClass(Identification value) {
        this.designClass = value;
    }

    /**
     * Gets the value of the customerType property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getCustomerType() {
        return customerType;
    }

    /**
     * Sets the value of the customerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setCustomerType(Identification value) {
        this.customerType = value;
    }

    /**
     * Gets the value of the modelYear property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getModelYear() {
        return modelYear;
    }

    /**
     * Sets the value of the modelYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setModelYear(Identification value) {
        this.modelYear = value;
    }

    /**
     * Gets the value of the modelYearModification property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getModelYearModification() {
        return modelYearModification;
    }

    /**
     * Sets the value of the modelYearModification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setModelYearModification(Identification value) {
        this.modelYearModification = value;
    }

    /**
     * Gets the value of the commercialName property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getCommercialName() {
        return commercialName;
    }

    /**
     * Sets the value of the commercialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setCommercialName(Identification value) {
        this.commercialName = value;
    }

    /**
     * Gets the value of the grCommercialName property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrCommercialName() {
        return grCommercialName;
    }

    /**
     * Sets the value of the grCommercialName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrCommercialName(Identification value) {
        this.grCommercialName = value;
    }

    /**
     * Gets the value of the engine property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setEngine(Identification value) {
        this.engine = value;
    }

    /**
     * Gets the value of the grEngine property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrEngine() {
        return grEngine;
    }

    /**
     * Sets the value of the grEngine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrEngine(Identification value) {
        this.grEngine = value;
    }

    /**
     * Gets the value of the transmissionType property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getTransmissionType() {
        return transmissionType;
    }

    /**
     * Sets the value of the transmissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setTransmissionType(Identification value) {
        this.transmissionType = value;
    }

    /**
     * Gets the value of the grTransmissionType property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getGrTransmissionType() {
        return grTransmissionType;
    }

    /**
     * Sets the value of the grTransmissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setGrTransmissionType(Identification value) {
        this.grTransmissionType = value;
    }

    /**
     * Gets the value of the energy property.
     * 
     * @return
     *     possible object is
     *     {@link Identification }
     *     
     */
    public Identification getEnergy() {
        return energy;
    }

    /**
     * Sets the value of the energy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Identification }
     *     
     */
    public void setEnergy(Identification value) {
        this.energy = value;
    }

    /**
     * Gets the value of the co2Rate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCo2Rate() {
        return co2Rate;
    }

    /**
     * Sets the value of the co2Rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCo2Rate(Float value) {
        this.co2Rate = value;
    }

    /**
     * Gets the value of the co2RateComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getCo2RateComplex() {
        return co2RateComplex;
    }

    /**
     * Sets the value of the co2RateComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setCo2RateComplex(TechCharComplex value) {
        this.co2RateComplex = value;
    }

    /**
     * Gets the value of the co2Class property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCo2Class() {
        return co2Class;
    }

    /**
     * Sets the value of the co2Class property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCo2Class(String value) {
        this.co2Class = value;
    }

    /**
     * Gets the value of the ecoLabel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEcoLabel() {
        return ecoLabel;
    }

    /**
     * Sets the value of the ecoLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEcoLabel(Boolean value) {
        this.ecoLabel = value;
    }

    /**
     * Gets the value of the mixedConsumption property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getMixedConsumption() {
        return mixedConsumption;
    }

    /**
     * Sets the value of the mixedConsumption property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setMixedConsumption(Float value) {
        this.mixedConsumption = value;
    }

    /**
     * Gets the value of the mixedConsumptionComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getMixedConsumptionComplex() {
        return mixedConsumptionComplex;
    }

    /**
     * Sets the value of the mixedConsumptionComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setMixedConsumptionComplex(TechCharComplex value) {
        this.mixedConsumptionComplex = value;
    }

    /**
     * Gets the value of the usefulIntLength property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getUsefulIntLength() {
        return usefulIntLength;
    }

    /**
     * Sets the value of the usefulIntLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setUsefulIntLength(Float value) {
        this.usefulIntLength = value;
    }

    /**
     * Gets the value of the usefulIntLengthComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getUsefulIntLengthComplex() {
        return usefulIntLengthComplex;
    }

    /**
     * Sets the value of the usefulIntLengthComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setUsefulIntLengthComplex(TechCharComplex value) {
        this.usefulIntLengthComplex = value;
    }

    /**
     * Gets the value of the usefulIntHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getUsefulIntHeight() {
        return usefulIntHeight;
    }

    /**
     * Sets the value of the usefulIntHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setUsefulIntHeight(Float value) {
        this.usefulIntHeight = value;
    }

    /**
     * Gets the value of the usefulIntHeightComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getUsefulIntHeightComplex() {
        return usefulIntHeightComplex;
    }

    /**
     * Sets the value of the usefulIntHeightComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setUsefulIntHeightComplex(TechCharComplex value) {
        this.usefulIntHeightComplex = value;
    }

    /**
     * Gets the value of the exteriorLength property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getExteriorLength() {
        return exteriorLength;
    }

    /**
     * Sets the value of the exteriorLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setExteriorLength(Float value) {
        this.exteriorLength = value;
    }

    /**
     * Gets the value of the exteriorLengthComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getExteriorLengthComplex() {
        return exteriorLengthComplex;
    }

    /**
     * Sets the value of the exteriorLengthComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setExteriorLengthComplex(TechCharComplex value) {
        this.exteriorLengthComplex = value;
    }

    /**
     * Gets the value of the exteriorHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getExteriorHeight() {
        return exteriorHeight;
    }

    /**
     * Sets the value of the exteriorHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setExteriorHeight(Float value) {
        this.exteriorHeight = value;
    }

    /**
     * Gets the value of the exteriorHeightComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getExteriorHeightComplex() {
        return exteriorHeightComplex;
    }

    /**
     * Sets the value of the exteriorHeightComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setExteriorHeightComplex(TechCharComplex value) {
        this.exteriorHeightComplex = value;
    }

    /**
     * Gets the value of the trunkVolume property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTrunkVolume() {
        return trunkVolume;
    }

    /**
     * Sets the value of the trunkVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTrunkVolume(Float value) {
        this.trunkVolume = value;
    }

    /**
     * Gets the value of the trunkVolumeComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getTrunkVolumeComplex() {
        return trunkVolumeComplex;
    }

    /**
     * Sets the value of the trunkVolumeComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setTrunkVolumeComplex(TechCharComplex value) {
        this.trunkVolumeComplex = value;
    }

    /**
     * Gets the value of the payloadVolume property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPayloadVolume() {
        return payloadVolume;
    }

    /**
     * Sets the value of the payloadVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPayloadVolume(Float value) {
        this.payloadVolume = value;
    }

    /**
     * Gets the value of the payloadVolumeComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getPayloadVolumeComplex() {
        return payloadVolumeComplex;
    }

    /**
     * Sets the value of the payloadVolumeComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setPayloadVolumeComplex(TechCharComplex value) {
        this.payloadVolumeComplex = value;
    }

    /**
     * Gets the value of the usefulTrayLength property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getUsefulTrayLength() {
        return usefulTrayLength;
    }

    /**
     * Sets the value of the usefulTrayLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setUsefulTrayLength(Float value) {
        this.usefulTrayLength = value;
    }

    /**
     * Gets the value of the usefulTrayLengthComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getUsefulTrayLengthComplex() {
        return usefulTrayLengthComplex;
    }

    /**
     * Sets the value of the usefulTrayLengthComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setUsefulTrayLengthComplex(TechCharComplex value) {
        this.usefulTrayLengthComplex = value;
    }

    /**
     * Gets the value of the numSittedPlaces property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumSittedPlaces() {
        return numSittedPlaces;
    }

    /**
     * Sets the value of the numSittedPlaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumSittedPlaces(Integer value) {
        this.numSittedPlaces = value;
    }

    /**
     * Gets the value of the numSittedPlacesComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getNumSittedPlacesComplex() {
        return numSittedPlacesComplex;
    }

    /**
     * Sets the value of the numSittedPlacesComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setNumSittedPlacesComplex(TechCharComplex value) {
        this.numSittedPlacesComplex = value;
    }

    /**
     * Gets the value of the payloadWeight property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPayloadWeight() {
        return payloadWeight;
    }

    /**
     * Sets the value of the payloadWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPayloadWeight(Float value) {
        this.payloadWeight = value;
    }

    /**
     * Gets the value of the payloadWeightComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getPayloadWeightComplex() {
        return payloadWeightComplex;
    }

    /**
     * Sets the value of the payloadWeightComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setPayloadWeightComplex(TechCharComplex value) {
        this.payloadWeightComplex = value;
    }

    /**
     * Gets the value of the bodyLength property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBodyLength() {
        return bodyLength;
    }

    /**
     * Sets the value of the bodyLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBodyLength(Float value) {
        this.bodyLength = value;
    }

    /**
     * Gets the value of the bodyLengthComplex property.
     * 
     * @return
     *     possible object is
     *     {@link TechCharComplex }
     *     
     */
    public TechCharComplex getBodyLengthComplex() {
        return bodyLengthComplex;
    }

    /**
     * Sets the value of the bodyLengthComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechCharComplex }
     *     
     */
    public void setBodyLengthComplex(TechCharComplex value) {
        this.bodyLengthComplex = value;
    }

    /**
     * Gets the value of the characteristic1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic1() {
        return characteristic1;
    }

    /**
     * Sets the value of the characteristic1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic1(String value) {
        this.characteristic1 = value;
    }

    /**
     * Gets the value of the characteristic2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic2() {
        return characteristic2;
    }

    /**
     * Sets the value of the characteristic2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic2(String value) {
        this.characteristic2 = value;
    }

    /**
     * Gets the value of the characteristic3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic3() {
        return characteristic3;
    }

    /**
     * Sets the value of the characteristic3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic3(String value) {
        this.characteristic3 = value;
    }

    /**
     * Gets the value of the characteristic4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristic4() {
        return characteristic4;
    }

    /**
     * Sets the value of the characteristic4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristic4(String value) {
        this.characteristic4 = value;
    }

    /**
     * Gets the value of the extendedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtendedCode() {
        return extendedCode;
    }

    /**
     * Sets the value of the extendedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtendedCode(String value) {
        this.extendedCode = value;
    }

    /**
     * Gets the value of the visualCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisualCode() {
        return visualCode;
    }

    /**
     * Sets the value of the visualCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisualCode(String value) {
        this.visualCode = value;
    }

    /**
     * Gets the value of the standardFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link StandardCategories }
     *     
     */
    public StandardCategories getStandardFeatures() {
        return standardFeatures;
    }

    /**
     * Sets the value of the standardFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardCategories }
     *     
     */
    public void setStandardFeatures(StandardCategories value) {
        this.standardFeatures = value;
    }

    /**
     * Gets the value of the technicalCharacteristics property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalCharacteristicsCategories }
     *     
     */
    public TechnicalCharacteristicsCategories getTechnicalCharacteristics() {
        return technicalCharacteristics;
    }

    /**
     * Sets the value of the technicalCharacteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalCharacteristicsCategories }
     *     
     */
    public void setTechnicalCharacteristics(TechnicalCharacteristicsCategories value) {
        this.technicalCharacteristics = value;
    }

    /**
     * Gets the value of the optionalFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link OptionalFeaturesCategories }
     *     
     */
    public OptionalFeaturesCategories getOptionalFeatures() {
        return optionalFeatures;
    }

    /**
     * Sets the value of the optionalFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionalFeaturesCategories }
     *     
     */
    public void setOptionalFeatures(OptionalFeaturesCategories value) {
        this.optionalFeatures = value;
    }

}
