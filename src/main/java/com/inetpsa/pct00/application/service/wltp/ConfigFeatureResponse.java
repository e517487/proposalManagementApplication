
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://inetpsa.com/cfg}ConfigFeatureResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "configFeatureResponse"
})
@XmlRootElement(name = "ConfigFeatureResponse", namespace = "http://xml.inetpsa.com/Services/Cfg/Config")
public class ConfigFeatureResponse {

    @XmlElement(name = "ConfigFeatureResponse", required = true)
    protected ConfigFeatureResponseType configFeatureResponse;

    /**
     * Gets the value of the configFeatureResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigFeatureResponseType }
     *     
     */
    public ConfigFeatureResponseType getConfigFeatureResponse() {
        return configFeatureResponse;
    }

    /**
     * Sets the value of the configFeatureResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigFeatureResponseType }
     *     
     */
    public void setConfigFeatureResponse(ConfigFeatureResponseType value) {
        this.configFeatureResponse = value;
    }

}
