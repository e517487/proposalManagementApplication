package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 61, 62, 63 : Uitleg
 * Private Type Record_Uitleg ' 141008 PROOVIT-EH: DESIN-292 - New record, multi used by 61, 62, 63
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * Rol               As String * 2
 * UITLEGGEZIN       As String * 240
 * UITLEGINKOMSTEN   As String * 240
 * UITLEGINPLATFORM  As String * 200
 * Filler3           As String * 2  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 61, 62, 63 : Uitleg Private Type Record_Uitleg ' 141008 PROOVIT-EH: DESIN-292 - New record, multi used by 61, 62, 63 PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 Rol               As String * 2 UITLEGGEZIN       As String * 240 UITLEGINKOMSTEN   As String * 240 UITLEGINPLATFORM  As String * 200 Filler3           As String * 2  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_61_uitleg")
public class Record61Uitleg implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "pc_finet_nr")
    private String pcFinetNr;

    @Column(name = "record_type")
    private Integer recordType;

    @Column(name = "volg_nr")
    private Integer volgNr;

    @Column(name = "rol")
    private String rol;

    @Column(name = "uitleg_gezin")
    private String uitlegGezin;

    @Column(name = "uitleg_inkomsten")
    private String uitlegInkomsten;

    @Column(name = "uitleg_in_platform")
    private String uitlegInPlatform;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcFinetNr() {
        return pcFinetNr;
    }

    public Record61Uitleg pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record61Uitleg recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record61Uitleg volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public String getRol() {
        return rol;
    }

    public Record61Uitleg rol(String rol) {
        this.rol = rol;
        return this;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUitlegGezin() {
        return uitlegGezin;
    }

    public Record61Uitleg uitlegGezin(String uitlegGezin) {
        this.uitlegGezin = uitlegGezin;
        return this;
    }

    public void setUitlegGezin(String uitlegGezin) {
        this.uitlegGezin = uitlegGezin;
    }

    public String getUitlegInkomsten() {
        return uitlegInkomsten;
    }

    public Record61Uitleg uitlegInkomsten(String uitlegInkomsten) {
        this.uitlegInkomsten = uitlegInkomsten;
        return this;
    }

    public void setUitlegInkomsten(String uitlegInkomsten) {
        this.uitlegInkomsten = uitlegInkomsten;
    }

    public String getUitlegInPlatform() {
        return uitlegInPlatform;
    }

    public Record61Uitleg uitlegInPlatform(String uitlegInPlatform) {
        this.uitlegInPlatform = uitlegInPlatform;
        return this;
    }

    public void setUitlegInPlatform(String uitlegInPlatform) {
        this.uitlegInPlatform = uitlegInPlatform;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Record61Uitleg record61Uitleg = (Record61Uitleg) o;
        if (record61Uitleg.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record61Uitleg.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record61Uitleg{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", rol='" + getRol() + "'" +
            ", uitlegGezin='" + getUitlegGezin() + "'" +
            ", uitlegInkomsten='" + getUitlegInkomsten() + "'" +
            ", uitlegInPlatform='" + getUitlegInPlatform() + "'" +
            "}";
    }
}
