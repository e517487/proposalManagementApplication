package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 50 : Bedrijf
 * Private Type Record_Bedrijf
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * Rol               As String * 2
 * BedNaam           As String * 30
 * Zoeknaam          As String * 20
 * Rechtsvorm        As String * 2
 * Straat            As String * 32
 * HuisNr            As String * 5
 * ToevhuisNr        As String * 7
 * Postcode          As String * 6
 * Plaats            As String * 32
 * TelefoonNr        As String * 20
 * OprDatum          As String * 8
 * Gemachtigd        As String * 30
 * Functiegem        As String * 20
 * Rekeningnr        As String * 20
 * Bankgroep         As String * 2
 * Stat_naam         As String * 79
 * KvK_Inschr        As String * 10
 * KvK_Plaats        As String * 32
 * Kapitaal          As String * 9
 * DunBradnr         As String * 15
 * JaarBalans        As String * 4
 * FILLER            As String * 111 ' in doc. stond 110
 * IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 50 : Bedrijf Private Type Record_Bedrijf PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 Rol               As String * 2 BedNaam           As String * 30 Zoeknaam          As String * 20 Rechtsvorm        As String * 2 Straat            As String * 32 HuisNr            As String * 5 ToevhuisNr        As String * 7 Postcode          As String * 6 Plaats            As String * 32 TelefoonNr        As String * 20 OprDatum          As String * 8 Gemachtigd        As String * 30 Functiegem        As String * 20 Rekeningnr        As String * 20 Bankgroep         As String * 2 Stat_naam         As String * 79 KvK_Inschr        As String * 10 KvK_Plaats        As String * 32 Kapitaal          As String * 9 DunBradnr         As String * 15 JaarBalans        As String * 4 FILLER            As String * 111 ' in doc. stond 110 IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MB) BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MB) EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_50_bedrijf")
public class Record50Bedrijf implements Serializable {

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

    public Record50Bedrijf pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record50Bedrijf recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record50Bedrijf volgNr(Integer volgNr) {
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
        Record50Bedrijf record50Bedrijf = (Record50Bedrijf) o;
        if (record50Bedrijf.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record50Bedrijf.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record50Bedrijf{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
