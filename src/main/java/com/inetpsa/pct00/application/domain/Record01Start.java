package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * ' Recordtype 1 : Start (
 * 'Private Type Record_Start
 * '  PCFinetnr    As String * 11
 * '  RecordType   As String * 2
 * '  Volgnr       As String * 3
 * '  CreatieDatum As String * 8
 * '  CreatieTijd  As String * 5
 * '  FILLER       As String * 483 '<- in doc. stond 482, maar uit bestand blijkt 483 !
 * '  FILLER2     As String * 128
 * 'End Type
 */
@ApiModel(description = "' Recordtype 1 : Start ( 'Private Type Record_Start '  PCFinetnr    As String * 11 '  RecordType   As String * 2 '  Volgnr       As String * 3 '  CreatieDatum As String * 8 '  CreatieTijd  As String * 5 '  FILLER       As String * 483 '<- in doc. stond 482, maar uit bestand blijkt 483 ! '  FILLER2     As String * 128 'End Type")
@Entity
@Table(name = "record_01_start")
public class Record01Start implements Serializable {

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

    @Column(name = "creatie_datum")
    private LocalDate creatieDatum;

    @Column(name = "creatie_tijd")
    private ZonedDateTime creatieTijd;

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

    public Record01Start pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record01Start recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record01Start volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public LocalDate getCreatieDatum() {
        return creatieDatum;
    }

    public Record01Start creatieDatum(LocalDate creatieDatum) {
        this.creatieDatum = creatieDatum;
        return this;
    }

    public void setCreatieDatum(LocalDate creatieDatum) {
        this.creatieDatum = creatieDatum;
    }

    public ZonedDateTime getCreatieTijd() {
        return creatieTijd;
    }

    public Record01Start creatieTijd(ZonedDateTime creatieTijd) {
        this.creatieTijd = creatieTijd;
        return this;
    }

    public void setCreatieTijd(ZonedDateTime creatieTijd) {
        this.creatieTijd = creatieTijd;
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
        Record01Start record01Start = (Record01Start) o;
        if (record01Start.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record01Start.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record01Start{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", creatieDatum='" + getCreatieDatum() + "'" +
            ", creatieTijd='" + getCreatieTijd() + "'" +
            "}";
    }
}
