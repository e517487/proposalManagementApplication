package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 46 : Relatie - Huishoudelijk
 * Private Type Record_RelatieHuish ' 100310 PROOVIT-EH: New for Basel II
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * HuisHgld          As String * 7   ' 100310 PROOVIT-EH: Basel II -- HUISHGELD
 * HuisHGlTot        As String * 7   ' 100310 PROOVIT-EH: Basel II -- TOTAALHUISHGELD
 * OpnStdMndB        As String * 7   ' 100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG - HUISH
 * VateLasten        As String * 7   ' 100310 PROOVIT-EH: Basel II -- VASTE -MNDLASTEN - HUISH
 * TotMndLast        As String * 7   ' 100310 PROOVIT-EH: Basel II -- Totaal -MNDLASTEN - HUISH
 * FILLER            As String * 460 ' 100310 PROOVIT-EH: Basel II -- in doc. stond 460
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 46 : Relatie - Huishoudelijk Private Type Record_RelatieHuish ' 100310 PROOVIT-EH: New for Basel II PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 HuisHgld          As String * 7   ' 100310 PROOVIT-EH: Basel II -- HUISHGELD HuisHGlTot        As String * 7   ' 100310 PROOVIT-EH: Basel II -- TOTAALHUISHGELD OpnStdMndB        As String * 7   ' 100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG - HUISH VateLasten        As String * 7   ' 100310 PROOVIT-EH: Basel II -- VASTE -MNDLASTEN - HUISH TotMndLast        As String * 7   ' 100310 PROOVIT-EH: Basel II -- Totaal -MNDLASTEN - HUISH FILLER            As String * 460 ' 100310 PROOVIT-EH: Basel II -- in doc. stond 460 FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_46_relatie_huishoudelijk")
public class Record46RelatieHuishoudelijk implements Serializable {

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

    public Record46RelatieHuishoudelijk pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record46RelatieHuishoudelijk recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record46RelatieHuishoudelijk volgNr(Integer volgNr) {
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
        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk = (Record46RelatieHuishoudelijk) o;
        if (record46RelatieHuishoudelijk.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record46RelatieHuishoudelijk.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record46RelatieHuishoudelijk{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
