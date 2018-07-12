package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Recordtype 20 : Financieel
 * Private Type Record_Financieel
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * con_soort         As String * 2
 * Ma_Optie          As String * 1 ' niet meer gebruikt in PCRT
 * KM_Jaar           As String * 6 ' niet meer gebruikt in PCRT
 * KM_Stand          As String * 6 ' niet meer gebruikt in PCRT
 * Afg_kent          As String * 6
 * Verkprijs         As String * 9
 * Aanbetal          As String * 9
 * Vergoeding        As String * 9
 * herfin_bed        As String * 9
 * hoofdsom          As String * 9 ' EH 27-5-2004
 * fin_bedrag        As String * 9 ' EH 27-5-2004
 * Restant           As String * 9 ' EH 27-5-2004
 * Looptijd          As String * 2
 * Termijn           As String * 9
 * Interest          As String * 7
 * Service           As String * 1
 * GMINRUIL          As String * 9 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * FILLER            As String * 383
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "Recordtype 20 : Financieel Private Type Record_Financieel PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 con_soort         As String * 2 Ma_Optie          As String * 1 ' niet meer gebruikt in PCRT KM_Jaar           As String * 6 ' niet meer gebruikt in PCRT KM_Stand          As String * 6 ' niet meer gebruikt in PCRT Afg_kent          As String * 6 Verkprijs         As String * 9 Aanbetal          As String * 9 Vergoeding        As String * 9 herfin_bed        As String * 9 hoofdsom          As String * 9 ' EH 27-5-2004 fin_bedrag        As String * 9 ' EH 27-5-2004 Restant           As String * 9 ' EH 27-5-2004 Looptijd          As String * 2 Termijn           As String * 9 Interest          As String * 7 Service           As String * 1 GMINRUIL          As String * 9 ' 120904 PROOVIT-EH: ALN-36 (MB) FILLER            As String * 383 FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_20_financieel")
public class Record20Financieel implements Serializable {

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

    public Record20Financieel pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record20Financieel recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record20Financieel volgNr(Integer volgNr) {
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
        Record20Financieel record20Financieel = (Record20Financieel) o;
        if (record20Financieel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record20Financieel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record20Financieel{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
