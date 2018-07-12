
package com.inetpsa.pct00.application.service.wltp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigCriteriaFeature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigCriteriaFeature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehicleUse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="BodyStyle" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrBodyStyle" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Grade" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrCommercialName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransmissionType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrTransmissionType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrTypeBoiteVitesse" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrNumberOfDoors" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DerivedModels" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Engine" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrEngine" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Energy" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EcoLabel" type="{http://www.w3.org/2001/XMLSchema}boolean" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EcoLabelText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Feature" type="{http://inetpsa.com/cfg}Feature" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigCriteriaFeature", propOrder = {
    "vehicleUse",
    "model",
    "bodyStyle",
    "grBodyStyle",
    "grade",
    "grCommercialName",
    "transmissionType",
    "grTransmissionType",
    "grTypeBoiteVitesse",
    "grNumberOfDoors",
    "derivedModels",
    "engine",
    "grEngine",
    "energy",
    "ecoLabel",
    "ecoLabelText",
    "feature"
})
public class ConfigCriteriaFeature {

    @XmlElement(name = "VehicleUse")
    protected String vehicleUse;
    @XmlElement(name = "Model", required = true)
    protected List<String> model;
    @XmlElement(name = "BodyStyle")
    protected List<String> bodyStyle;
    @XmlElement(name = "GrBodyStyle")
    protected List<String> grBodyStyle;
    @XmlElement(name = "Grade")
    protected List<String> grade;
    @XmlElement(name = "GrCommercialName")
    protected List<String> grCommercialName;
    @XmlElement(name = "TransmissionType")
    protected List<String> transmissionType;
    @XmlElement(name = "GrTransmissionType")
    protected List<String> grTransmissionType;
    @XmlElement(name = "GrTypeBoiteVitesse")
    protected List<String> grTypeBoiteVitesse;
    @XmlElement(name = "GrNumberOfDoors")
    protected List<String> grNumberOfDoors;
    @XmlElement(name = "DerivedModels")
    protected List<String> derivedModels;
    @XmlElement(name = "Engine")
    protected List<String> engine;
    @XmlElement(name = "GrEngine")
    protected List<String> grEngine;
    @XmlElement(name = "Energy")
    protected List<String> energy;
    @XmlElement(name = "EcoLabel", type = Boolean.class)
    protected List<Boolean> ecoLabel;
    @XmlElement(name = "EcoLabelText")
    protected List<String> ecoLabelText;
    @XmlElement(name = "Feature", required = true)
    protected List<Feature> feature;

    /**
     * Gets the value of the vehicleUse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleUse() {
        return vehicleUse;
    }

    /**
     * Sets the value of the vehicleUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleUse(String value) {
        this.vehicleUse = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the model property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getModel() {
        if (model == null) {
            model = new ArrayList<String>();
        }
        return this.model;
    }

    /**
     * Gets the value of the bodyStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bodyStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBodyStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBodyStyle() {
        if (bodyStyle == null) {
            bodyStyle = new ArrayList<String>();
        }
        return this.bodyStyle;
    }

    /**
     * Gets the value of the grBodyStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grBodyStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrBodyStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrBodyStyle() {
        if (grBodyStyle == null) {
            grBodyStyle = new ArrayList<String>();
        }
        return this.grBodyStyle;
    }

    /**
     * Gets the value of the grade property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grade property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrade().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrade() {
        if (grade == null) {
            grade = new ArrayList<String>();
        }
        return this.grade;
    }

    /**
     * Gets the value of the grCommercialName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grCommercialName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrCommercialName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrCommercialName() {
        if (grCommercialName == null) {
            grCommercialName = new ArrayList<String>();
        }
        return this.grCommercialName;
    }

    /**
     * Gets the value of the transmissionType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transmissionType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransmissionType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTransmissionType() {
        if (transmissionType == null) {
            transmissionType = new ArrayList<String>();
        }
        return this.transmissionType;
    }

    /**
     * Gets the value of the grTransmissionType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grTransmissionType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrTransmissionType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrTransmissionType() {
        if (grTransmissionType == null) {
            grTransmissionType = new ArrayList<String>();
        }
        return this.grTransmissionType;
    }

    /**
     * Gets the value of the grTypeBoiteVitesse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grTypeBoiteVitesse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrTypeBoiteVitesse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrTypeBoiteVitesse() {
        if (grTypeBoiteVitesse == null) {
            grTypeBoiteVitesse = new ArrayList<String>();
        }
        return this.grTypeBoiteVitesse;
    }

    /**
     * Gets the value of the grNumberOfDoors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grNumberOfDoors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrNumberOfDoors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrNumberOfDoors() {
        if (grNumberOfDoors == null) {
            grNumberOfDoors = new ArrayList<String>();
        }
        return this.grNumberOfDoors;
    }

    /**
     * Gets the value of the derivedModels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivedModels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivedModels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDerivedModels() {
        if (derivedModels == null) {
            derivedModels = new ArrayList<String>();
        }
        return this.derivedModels;
    }

    /**
     * Gets the value of the engine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the engine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEngine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEngine() {
        if (engine == null) {
            engine = new ArrayList<String>();
        }
        return this.engine;
    }

    /**
     * Gets the value of the grEngine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grEngine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrEngine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGrEngine() {
        if (grEngine == null) {
            grEngine = new ArrayList<String>();
        }
        return this.grEngine;
    }

    /**
     * Gets the value of the energy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the energy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnergy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEnergy() {
        if (energy == null) {
            energy = new ArrayList<String>();
        }
        return this.energy;
    }

    /**
     * Gets the value of the ecoLabel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecoLabel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEcoLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     * 
     * 
     */
    public List<Boolean> getEcoLabel() {
        if (ecoLabel == null) {
            ecoLabel = new ArrayList<Boolean>();
        }
        return this.ecoLabel;
    }

    /**
     * Gets the value of the ecoLabelText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecoLabelText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEcoLabelText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEcoLabelText() {
        if (ecoLabelText == null) {
            ecoLabelText = new ArrayList<String>();
        }
        return this.ecoLabelText;
    }

    /**
     * Gets the value of the feature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Feature }
     * 
     * 
     */
    public List<Feature> getFeature() {
        if (feature == null) {
            feature = new ArrayList<Feature>();
        }
        return this.feature;
    }

}
