package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * ' RecordType 99: Eindrecord
 * 'Private Type Record_Eind
 * '  PCFinetnr       As String * 11
 * '  RecordType      As String * 2
 * '  Volgnr          As String * 3
 * '  CreatieDatum    As String * 8
 * '  CreatieTijd     As String * 5
 * '  AantalAanvragen As String * 5
 * '  AantalRegels    As String * 5
 * '  FILLER          As String * 473 ' In doc. stond 472, uit bestand blijkt 473
 * '  FILLER2     As String * 128
 * 'End Type
 */
@ApiModel(description = "' RecordType 99: Eindrecord 'Private Type Record_Eind '  PCFinetnr       As String * 11 '  RecordType      As String * 2 '  Volgnr          As String * 3 '  CreatieDatum    As String * 8 '  CreatieTijd     As String * 5 '  AantalAanvragen As String * 5 '  AantalRegels    As String * 5 '  FILLER          As String * 473 ' In doc. stond 472, uit bestand blijkt 473 '  FILLER2     As String * 128 'End Type")
@Entity
@Table(name = "record_99_eind")
public class Record99Eind implements Serializable {

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

    @Column(name = "aantal_aanvragen")
    private Integer aantalAanvragen;

    @Column(name = "aantal_regels")
    private Integer aantalRegels;

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

    public Record99Eind pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record99Eind recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record99Eind volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public LocalDate getCreatieDatum() {
        return creatieDatum;
    }

    public Record99Eind creatieDatum(LocalDate creatieDatum) {
        this.creatieDatum = creatieDatum;
        return this;
    }

    public void setCreatieDatum(LocalDate creatieDatum) {
        this.creatieDatum = creatieDatum;
    }

    public ZonedDateTime getCreatieTijd() {
        return creatieTijd;
    }

    public Record99Eind creatieTijd(ZonedDateTime creatieTijd) {
        this.creatieTijd = creatieTijd;
        return this;
    }

    public void setCreatieTijd(ZonedDateTime creatieTijd) {
        this.creatieTijd = creatieTijd;
    }

    public Integer getAantalAanvragen() {
        return aantalAanvragen;
    }

    public Record99Eind aantalAanvragen(Integer aantalAanvragen) {
        this.aantalAanvragen = aantalAanvragen;
        return this;
    }

    public void setAantalAanvragen(Integer aantalAanvragen) {
        this.aantalAanvragen = aantalAanvragen;
    }

    public Integer getAantalRegels() {
        return aantalRegels;
    }

    public Record99Eind aantalRegels(Integer aantalRegels) {
        this.aantalRegels = aantalRegels;
        return this;
    }

    public void setAantalRegels(Integer aantalRegels) {
        this.aantalRegels = aantalRegels;
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
        Record99Eind record99Eind = (Record99Eind) o;
        if (record99Eind.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record99Eind.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record99Eind{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", creatieDatum='" + getCreatieDatum() + "'" +
            ", creatieTijd='" + getCreatieTijd() + "'" +
            ", aantalAanvragen=" + getAantalAanvragen() +
            ", aantalRegels=" + getAantalRegels() +
            "}";
    }
}
