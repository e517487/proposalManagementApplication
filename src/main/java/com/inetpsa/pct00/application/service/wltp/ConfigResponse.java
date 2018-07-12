
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
 *         &lt;element ref="{http://inetpsa.com/cfg}ConfigResponse"/>
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
    "configResponse"
})
@XmlRootElement(name = "ConfigResponse", namespace = "http://xml.inetpsa.com/Services/Cfg/Config")
public class ConfigResponse {

    @XmlElement(name = "ConfigResponse", required = true)
    protected ConfigResponseType configResponse;

    /**
     * Gets the value of the configResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigResponseType }
     *     
     */
    public ConfigResponseType getConfigResponse() {
        return configResponse;
    }

    /**
     * Sets the value of the configResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigResponseType }
     *     
     */
    public void setConfigResponse(ConfigResponseType value) {
        this.configResponse = value;
    }

}
