package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * ' Recordtype 45 : Relatie
 * Private Type Record_Relatie
 * PCFinetnr         As String * 11
 * RecordType        As String * 2
 * Volgnr            As String * 3
 * Rol               As String * 2
 * Titulatuur        As String * 2
 * Voorletter        As String * 20
 * prefix            As String * 20
 * Naam              As String * 30
 * Zoeknaam          As String * 20
 * Straat            As String * 32
 * HuisNr            As String * 5
 * ToevhuisNr        As String * 7
 * Postcode          As String * 6
 * Plaats            As String * 32
 * TelefoonNr        As String * 20
 * gebdatum          As String * 8
 * GebPlaats         As String * 32
 * Nat               As String * 2
 * Burgstatus        As String * 2
 * geslacht          As String * 2
 * Rekeningnr        As String * 20
 * Bankgroep         As String * 2
 * Rijbewijs         As String * 20
 * Beroep            As String * 30
 * Cat_Beroep        As String * 2
 * Srt_Beroep        As String * 2
 * Naam_Werk         As String * 30
 * PltsWerk          As String * 30
 * Tel_Werk          As String * 20
 * StartWerk         As String * 8
 * Cat_Ink           As String * 2
 * Uitkering         As String * 2
 * Kinderen          As String * 2
 * Behuizing         As String * 2
 * Woon_duur         As String * 2
 * Woonlasten        As String * 8
 * ' 100310 PROOVIT-EH: Basel II -- Nieuwe velden
 * Ink_Neto          As String * 7 '  100310 PROOVIT-EH: Basel II -- NETTO
 * InkTotNeto        As String * 7 '  100310 PROOVIT-EH: Basel II -- TOTAALNETTO
 * OpbMndBdrg        As String * 7 '  100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG
 * PercSchLst        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -SCHULDENLAST
 * PercScLsTo        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -TOT - SCHULDENLAST
 * StartWonin        As String * 8 '  100907 PROOVIT-EH: Basel II -- StartWoning = datum
 * FILLER            As String * 31 ' 120904 PROOVIT-EH: ALN-36 (MBe)
 * IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MBe)
 * BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MBe)
 * EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MBe)
 * '-- 141008 PROOVIT-EH: DESIN-292 - New fields
 * NAT_CODE          As String * 3
 * VERBLIJFNR        As String * 15
 * EVOLGEZIN         As String * 1
 * EVOLINKOMSTEN     As String * 1
 * SOORTWRKCONTRAKT  As String * 1
 * EINDDATWRKCONTR   As String * 6
 * INTENTIEWRKCONTR  As String * 1
 * VERZOEKPLATFORM   As String * 1
 * '-- 141008 PROOVIT-EH: DESIN-292 - New fields END
 * Filler3           As String * 31 ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 45 : Relatie Private Type Record_Relatie PCFinetnr         As String * 11 RecordType        As String * 2 Volgnr            As String * 3 Rol               As String * 2 Titulatuur        As String * 2 Voorletter        As String * 20 prefix            As String * 20 Naam              As String * 30 Zoeknaam          As String * 20 Straat            As String * 32 HuisNr            As String * 5 ToevhuisNr        As String * 7 Postcode          As String * 6 Plaats            As String * 32 TelefoonNr        As String * 20 gebdatum          As String * 8 GebPlaats         As String * 32 Nat               As String * 2 Burgstatus        As String * 2 geslacht          As String * 2 Rekeningnr        As String * 20 Bankgroep         As String * 2 Rijbewijs         As String * 20 Beroep            As String * 30 Cat_Beroep        As String * 2 Srt_Beroep        As String * 2 Naam_Werk         As String * 30 PltsWerk          As String * 30 Tel_Werk          As String * 20 StartWerk         As String * 8 Cat_Ink           As String * 2 Uitkering         As String * 2 Kinderen          As String * 2 Behuizing         As String * 2 Woon_duur         As String * 2 Woonlasten        As String * 8 ' 100310 PROOVIT-EH: Basel II -- Nieuwe velden Ink_Neto          As String * 7 '  100310 PROOVIT-EH: Basel II -- NETTO InkTotNeto        As String * 7 '  100310 PROOVIT-EH: Basel II -- TOTAALNETTO OpbMndBdrg        As String * 7 '  100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG PercSchLst        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -SCHULDENLAST PercScLsTo        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -TOT - SCHULDENLAST StartWonin        As String * 8 '  100907 PROOVIT-EH: Basel II -- StartWoning = datum FILLER            As String * 31 ' 120904 PROOVIT-EH: ALN-36 (MBe) IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MBe) BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MBe) EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MBe) '-- 141008 PROOVIT-EH: DESIN-292 - New fields NAT_CODE          As String * 3 VERBLIJFNR        As String * 15 EVOLGEZIN         As String * 1 EVOLINKOMSTEN     As String * 1 SOORTWRKCONTRAKT  As String * 1 EINDDATWRKCONTR   As String * 6 INTENTIEWRKCONTR  As String * 1 VERZOEKPLATFORM   As String * 1 '-- 141008 PROOVIT-EH: DESIN-292 - New fields END Filler3           As String * 31 ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_45_relatie")
public class Record45Relatie implements Serializable {

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

    public Record45Relatie pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record45Relatie recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record45Relatie volgNr(Integer volgNr) {
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
        Record45Relatie record45Relatie = (Record45Relatie) o;
        if (record45Relatie.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record45Relatie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record45Relatie{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
