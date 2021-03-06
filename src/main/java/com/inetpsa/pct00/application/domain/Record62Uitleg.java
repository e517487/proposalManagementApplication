package com.inetpsa.pct00.application.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Record62Uitleg.
 */
@Entity
@Table(name = "record_62_uitleg")
public class Record62Uitleg implements Serializable {

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

    public Record62Uitleg pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record62Uitleg recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record62Uitleg volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public String getRol() {
        return rol;
    }

    public Record62Uitleg rol(String rol) {
        this.rol = rol;
        return this;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUitlegGezin() {
        return uitlegGezin;
    }

    public Record62Uitleg uitlegGezin(String uitlegGezin) {
        this.uitlegGezin = uitlegGezin;
        return this;
    }

    public void setUitlegGezin(String uitlegGezin) {
        this.uitlegGezin = uitlegGezin;
    }

    public String getUitlegInkomsten() {
        return uitlegInkomsten;
    }

    public Record62Uitleg uitlegInkomsten(String uitlegInkomsten) {
        this.uitlegInkomsten = uitlegInkomsten;
        return this;
    }

    public void setUitlegInkomsten(String uitlegInkomsten) {
        this.uitlegInkomsten = uitlegInkomsten;
    }

    public String getUitlegInPlatform() {
        return uitlegInPlatform;
    }

    public Record62Uitleg uitlegInPlatform(String uitlegInPlatform) {
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
        Record62Uitleg record62Uitleg = (Record62Uitleg) o;
        if (record62Uitleg.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record62Uitleg.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record62Uitleg{" +
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
