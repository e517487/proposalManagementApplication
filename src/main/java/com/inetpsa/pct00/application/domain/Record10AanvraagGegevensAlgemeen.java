package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * ' Recordtype 10 : Aanvraaggegevens algemeen
 * Private Type Record_AV_ALG
 * PCFinetnr         As String * 11
 * RecordType        As String * 2    already stripped
 * Volgnr            As String * 3    0..3
 * DEALERNR          As String * 6    3..9
 * PROD_CODE         As String * 5    9..14
 * Zoeknaam          As String * 20   14..34
 * Verkoper          As String * 30   34..64
 * DealerTelnr       As String * 20   64..84
 * Acceptatie        As String * 1    84..85
 * Aanv_datum        As String * 8    85..93
 * Aanv_tijd         As String * 5    93..98
 * Acc_Datum         As String * 8    98..106
 * Acc_tijd          As String * 5    106..111
 * Prt_Datum         As String * 8    111..119
 * Invoerder         As String * 7    119..126
 * Acceptant         As String * 7    126..133
 * FILLER            As String * 365
 * FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
 * Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
 * End Type
 */
@ApiModel(description = "' Recordtype 10 : Aanvraaggegevens algemeen Private Type Record_AV_ALG PCFinetnr         As String * 11 RecordType        As String * 2    already stripped Volgnr            As String * 3    0..3 DEALERNR          As String * 6    3..9 PROD_CODE         As String * 5    9..14 Zoeknaam          As String * 20   14..34 Verkoper          As String * 30   34..64 DealerTelnr       As String * 20   64..84 Acceptatie        As String * 1    84..85 Aanv_datum        As String * 8    85..93 Aanv_tijd         As String * 5    93..98 Acc_Datum         As String * 8    98..106 Acc_tijd          As String * 5    106..111 Prt_Datum         As String * 8    111..119 Invoerder         As String * 7    119..126 Acceptant         As String * 7    126..133 FILLER            As String * 365 FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB) Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292 End Type")
@Entity
@Table(name = "record_10_aanvraag_gegevens_algemeen")
public class Record10AanvraagGegevensAlgemeen implements Serializable {

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

    @Column(name = "dealer_nr")
    private String dealerNr;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "zoeknaam")
    private String zoeknaam;

    @Column(name = "verkoper")
    private String verkoper;

    @Column(name = "dealer_telnr")
    private String dealerTelnr;

    @Column(name = "acceptatie")
    private String acceptatie;

    @Column(name = "aanvang_datum")
    private LocalDate aanvangDatum;

    @Column(name = "aanvang_tijd")
    private ZonedDateTime aanvangTijd;

    @Column(name = "acceptatie_datum")
    private LocalDate acceptatieDatum;

    @Column(name = "acceptatie_tijd")
    private ZonedDateTime acceptatieTijd;

    @Column(name = "prt_datum")
    private LocalDate prtDatum;

    @Column(name = "invoerder")
    private String invoerder;

    @Column(name = "acceptant")
    private String acceptant;

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

    public Record10AanvraagGegevensAlgemeen pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public Record10AanvraagGegevensAlgemeen recordType(Integer recordType) {
        this.recordType = recordType;
        return this;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public Record10AanvraagGegevensAlgemeen volgNr(Integer volgNr) {
        this.volgNr = volgNr;
        return this;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public String getDealerNr() {
        return dealerNr;
    }

    public Record10AanvraagGegevensAlgemeen dealerNr(String dealerNr) {
        this.dealerNr = dealerNr;
        return this;
    }

    public void setDealerNr(String dealerNr) {
        this.dealerNr = dealerNr;
    }

    public String getProductCode() {
        return productCode;
    }

    public Record10AanvraagGegevensAlgemeen productCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getZoeknaam() {
        return zoeknaam;
    }

    public Record10AanvraagGegevensAlgemeen zoeknaam(String zoeknaam) {
        this.zoeknaam = zoeknaam;
        return this;
    }

    public void setZoeknaam(String zoeknaam) {
        this.zoeknaam = zoeknaam;
    }

    public String getVerkoper() {
        return verkoper;
    }

    public Record10AanvraagGegevensAlgemeen verkoper(String verkoper) {
        this.verkoper = verkoper;
        return this;
    }

    public void setVerkoper(String verkoper) {
        this.verkoper = verkoper;
    }

    public String getDealerTelnr() {
        return dealerTelnr;
    }

    public Record10AanvraagGegevensAlgemeen dealerTelnr(String dealerTelnr) {
        this.dealerTelnr = dealerTelnr;
        return this;
    }

    public void setDealerTelnr(String dealerTelnr) {
        this.dealerTelnr = dealerTelnr;
    }

    public String getAcceptatie() {
        return acceptatie;
    }

    public Record10AanvraagGegevensAlgemeen acceptatie(String acceptatie) {
        this.acceptatie = acceptatie;
        return this;
    }

    public void setAcceptatie(String acceptatie) {
        this.acceptatie = acceptatie;
    }

    public LocalDate getAanvangDatum() {
        return aanvangDatum;
    }

    public Record10AanvraagGegevensAlgemeen aanvangDatum(LocalDate aanvangDatum) {
        this.aanvangDatum = aanvangDatum;
        return this;
    }

    public void setAanvangDatum(LocalDate aanvangDatum) {
        this.aanvangDatum = aanvangDatum;
    }

    public ZonedDateTime getAanvangTijd() {
        return aanvangTijd;
    }

    public Record10AanvraagGegevensAlgemeen aanvangTijd(ZonedDateTime aanvangTijd) {
        this.aanvangTijd = aanvangTijd;
        return this;
    }

    public void setAanvangTijd(ZonedDateTime aanvangTijd) {
        this.aanvangTijd = aanvangTijd;
    }

    public LocalDate getAcceptatieDatum() {
        return acceptatieDatum;
    }

    public Record10AanvraagGegevensAlgemeen acceptatieDatum(LocalDate acceptatieDatum) {
        this.acceptatieDatum = acceptatieDatum;
        return this;
    }

    public void setAcceptatieDatum(LocalDate acceptatieDatum) {
        this.acceptatieDatum = acceptatieDatum;
    }

    public ZonedDateTime getAcceptatieTijd() {
        return acceptatieTijd;
    }

    public Record10AanvraagGegevensAlgemeen acceptatieTijd(ZonedDateTime acceptatieTijd) {
        this.acceptatieTijd = acceptatieTijd;
        return this;
    }

    public void setAcceptatieTijd(ZonedDateTime acceptatieTijd) {
        this.acceptatieTijd = acceptatieTijd;
    }

    public LocalDate getPrtDatum() {
        return prtDatum;
    }

    public Record10AanvraagGegevensAlgemeen prtDatum(LocalDate prtDatum) {
        this.prtDatum = prtDatum;
        return this;
    }

    public void setPrtDatum(LocalDate prtDatum) {
        this.prtDatum = prtDatum;
    }

    public String getInvoerder() {
        return invoerder;
    }

    public Record10AanvraagGegevensAlgemeen invoerder(String invoerder) {
        this.invoerder = invoerder;
        return this;
    }

    public void setInvoerder(String invoerder) {
        this.invoerder = invoerder;
    }

    public String getAcceptant() {
        return acceptant;
    }

    public Record10AanvraagGegevensAlgemeen acceptant(String acceptant) {
        this.acceptant = acceptant;
        return this;
    }

    public void setAcceptant(String acceptant) {
        this.acceptant = acceptant;
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
        Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen = (Record10AanvraagGegevensAlgemeen) o;
        if (record10AanvraagGegevensAlgemeen.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record10AanvraagGegevensAlgemeen.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record10AanvraagGegevensAlgemeen{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", dealerNr='" + getDealerNr() + "'" +
            ", productCode='" + getProductCode() + "'" +
            ", zoeknaam='" + getZoeknaam() + "'" +
            ", verkoper='" + getVerkoper() + "'" +
            ", dealerTelnr='" + getDealerTelnr() + "'" +
            ", acceptatie='" + getAcceptatie() + "'" +
            ", aanvangDatum='" + getAanvangDatum() + "'" +
            ", aanvangTijd='" + getAanvangTijd() + "'" +
            ", acceptatieDatum='" + getAcceptatieDatum() + "'" +
            ", acceptatieTijd='" + getAcceptatieTijd() + "'" +
            ", prtDatum='" + getPrtDatum() + "'" +
            ", invoerder='" + getInvoerder() + "'" +
            ", acceptant='" + getAcceptant() + "'" +
            "}";
    }
}
