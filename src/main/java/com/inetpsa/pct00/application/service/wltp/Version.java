
package com.inetpsa.pct00.application.service.wltp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Version complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Version">
 *   &lt;complexContent>
 *     &lt;extension base="{http://inetpsa.com/cfg}VersionAbstract">
 *       &lt;sequence>
 *         &lt;element name="LookFeatures" type="{http://inetpsa.com/cfg}LookFeatures"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Version", propOrder = {
    "lookFeatures"
})
public class Version
    extends VersionAbstract
{

    @XmlElement(name = "LookFeatures", required = true)
    protected LookFeatures lookFeatures;

    /**
     * Gets the value of the lookFeatures property.
     * 
     * @return
     *     possible object is
     *     {@link LookFeatures }
     *     
     */
    public LookFeatures getLookFeatures() {
        return lookFeatures;
    }

    /**
     * Sets the value of the lookFeatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookFeatures }
     *     
     */
    public void setLookFeatures(LookFeatures value) {
        this.lookFeatures = value;
    }

}
