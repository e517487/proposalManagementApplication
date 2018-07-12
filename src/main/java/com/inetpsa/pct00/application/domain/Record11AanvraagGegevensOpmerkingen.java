package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 11 : Aanvraaggegevens, opmerking
 * Private Type Record_AV_Opmerking
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * VolgNr            As String * 3
 * Regel1            As String * 80
 * Regel2            As String * 80
 * Regel3            As String * 80
 * Regel4            As String * 80
 * Regel5            As String * 80
 * Regel6            As String * 80
 * FILLER            As String * 31 ' in doc stond 32?
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 11 : Aanvraaggegevens, opmerking Private Type Record_AV_Opmerking PCFinetnr         As String * 11 RecordType        As String * 2 VolgNr            As String * 3 Regel1            As String * 80 Regel2            As String * 80 Regel3            As String * 80 Regel4            As String * 80 Regel5            As String * 80 Regel6            As String * 80 FILLER            As String * 31 ' in doc stond 32? FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_11_aanvraag_gegevens_opmerkingen")
public class Record11AanvraagGegevensOpmerkingen implements Serializable {

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

    public Record11AanvraagGegevensOpmerkingen pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record11AanvraagGegevensOpmerkingen recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record11AanvraagGegevensOpmerkingen volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
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
        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen = (Record11AanvraagGegevensOpmerkingen) o;
        if (record11AanvraagGegevensOpmerkingen.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record11AanvraagGegevensOpmerkingen.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record11AanvraagGegevensOpmerkingen{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
