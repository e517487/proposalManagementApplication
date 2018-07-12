
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfigResponseTypeV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfigResponseTypeV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Version" type="{http://inetpsa.com/cfg}VersionV2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfigResponseTypeV2", propOrder = {
    "version"
})
public class ConfigResponseTypeV2 {

    @XmlElement(name = "Version", required = true)
    protected VersionV2 version;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link VersionV2 }
     *     
     */
    public VersionV2 getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionV2 }
     *     
     */
    public void setVersion(VersionV2 value) {
        this.version = value;
    }

}
