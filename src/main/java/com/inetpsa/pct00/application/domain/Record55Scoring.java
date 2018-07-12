package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 55 : Scoring
 * Private Type Record_Scoring ' 100310 PROOVIT-EH: New for Basel II
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * Scoring25         As String * 450 ' 25 * 3 * 6  ' 100310 PROOVIT-EH: Basel II -- SCORING OCCURS max 25 blocks of 6x3
 * FILLER            As String * 46  ' 100310 PROOVIT-EH: Basel II -- in doc. stond 46
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 * Private Type Record_ScoringTempRegel ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55
 * Regel     As String * 18   ' 100310 PROOVIT-EH: Basel II -- REG -code
 * End Type
 * Private Type Record_ScoringSub1 ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55
 * REG_CODE          As String * 3   ' 100310 PROOVIT-EH: Basel II -- REG -code
 * COND_NR           As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -NR
 * Cond_Score        As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -Score
 * AfwysRegCd        As String * 3   ' 100310 PROOVIT-EH: Basel II -- AFWIJS -REG - code
 * ZekerhCode        As String * 3   ' 100310 PROOVIT-EH: Basel II -- ZEKERH -code
 * InfoRegCod        As String * 3   ' 100310 PROOVIT-EH: Basel II -- INFO -REG - code
 * End Type
 */
@ApiModel(description = "' Recordtype 55 : Scoring Private Type Record_Scoring ' 100310 PROOVIT-EH: New for Basel II PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 Scoring25         As String * 450 ' 25 * 3 * 6  ' 100310 PROOVIT-EH: Basel II -- SCORING OCCURS max 25 blocks of 6x3 FILLER            As String * 46  ' 100310 PROOVIT-EH: Basel II -- in doc. stond 46 FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type Private Type Record_ScoringTempRegel ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55 Regel     As String * 18   ' 100310 PROOVIT-EH: Basel II -- REG -code End Type Private Type Record_ScoringSub1 ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55 REG_CODE          As String * 3   ' 100310 PROOVIT-EH: Basel II -- REG -code COND_NR           As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -NR Cond_Score        As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -Score AfwysRegCd        As String * 3   ' 100310 PROOVIT-EH: Basel II -- AFWIJS -REG - code ZekerhCode        As String * 3   ' 100310 PROOVIT-EH: Basel II -- ZEKERH -code InfoRegCod        As String * 3   ' 100310 PROOVIT-EH: Basel II -- INFO -REG - code End Type")
@Entity
@Table(name = "record_55_scoring")
public class Record55Scoring implements Serializable {

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

    public Record55Scoring pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record55Scoring recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record55Scoring volgNr(Integer volgNr) {
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
        Record55Scoring record55Scoring = (Record55Scoring) o;
        if (record55Scoring.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record55Scoring.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record55Scoring{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
