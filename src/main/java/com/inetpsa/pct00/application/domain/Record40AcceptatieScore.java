package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 40 : Acceptatie / Score
 * Private Type Record_Score
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * Tenaamstel        As String * 20
 * Riskmodel         As String * 1
 * MatigHist         As String * 1
 * InTeleGids        As String * 1
 * Interview         As String * 1
 * Bekend            As String * 1
 * Eerder            As String * 1
 * Alias             As String * 1
 * aCode             As String * 1
 * APlusCode         As String * 1
 * ACodeHyp          As String * 1
 * Afgelost          As String * 1
 * Lopend            As String * 1
 * Lopend_sk         As String * 1
 * Leg               As String * 1
 * Afgewezen         As String * 1
 * Score             As String * 4
 * Klasse            As String * 1
 * Auto_Acc          As String * 1
 * Add_Info          As String * 1
 * Afwijzen          As String * 1
 * Log_Score         As String * 33
 * Log_Info          As String * 24
 * Log_Afwijs        As String * 4
 * Zekerheden        As String * 5
 * bkrscore          As String * 1 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2
 * avstatus          As String * 2 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2
 * AantInkomn        As String * 1 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTINKOMEN
 * AantBkrCtr        As String * 2 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTBKRCONTR
 * FILLER            As String * 380 ' in doc. stond 380...
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 40 : Acceptatie / Score Private Type Record_Score PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 Tenaamstel        As String * 20 Riskmodel         As String * 1 MatigHist         As String * 1 InTeleGids        As String * 1 Interview         As String * 1 Bekend            As String * 1 Eerder            As String * 1 Alias             As String * 1 aCode             As String * 1 APlusCode         As String * 1 ACodeHyp          As String * 1 Afgelost          As String * 1 Lopend            As String * 1 Lopend_sk         As String * 1 Leg               As String * 1 Afgewezen         As String * 1 Score             As String * 4 Klasse            As String * 1 Auto_Acc          As String * 1 Add_Info          As String * 1 Afwijzen          As String * 1 Log_Score         As String * 33 Log_Info          As String * 24 Log_Afwijs        As String * 4 Zekerheden        As String * 5 bkrscore          As String * 1 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2 avstatus          As String * 2 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2 AantInkomn        As String * 1 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTINKOMEN AantBkrCtr        As String * 2 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTBKRCONTR FILLER            As String * 380 ' in doc. stond 380... FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_40_acceptatie_score")
public class Record40AcceptatieScore implements Serializable {

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

    public Record40AcceptatieScore pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record40AcceptatieScore recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record40AcceptatieScore volgNr(Integer volgNr) {
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
        Record40AcceptatieScore record40AcceptatieScore = (Record40AcceptatieScore) o;
        if (record40AcceptatieScore.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record40AcceptatieScore.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record40AcceptatieScore{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
