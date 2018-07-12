
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
 *         &lt;element ref="{http://inetpsa.com/cfg}ConfigResponseV2"/>
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
    "configResponseV2"
})
@XmlRootElement(name = "ConfigV2Response", namespace = "http://xml.inetpsa.com/Services/Cfg/Config")
public class ConfigV2Response {

    @XmlElement(name = "ConfigResponseV2", required = true)
    protected ConfigResponseTypeV2 configResponseV2;

    /**
     * Gets the value of the configResponseV2 property.
     * 
     * @return
     *     possible object is
     *     {@link ConfigResponseTypeV2 }
     *     
     */
    public ConfigResponseTypeV2 getConfigResponseV2() {
        return configResponseV2;
    }

    /**
     * Sets the value of the configResponseV2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigResponseTypeV2 }
     *     
     */
    public void setConfigResponseV2(ConfigResponseTypeV2 value) {
        this.configResponseV2 = value;
    }

}
