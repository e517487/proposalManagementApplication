package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Record10AanvraagGegevensAlgemeen entity.
 */
public class Record10AanvraagGegevensAlgemeenDTO implements Serializable {

    private Long id;

    private String pcFinetNr;

    private Integer recordType;

    private Integer volgNr;

    private String dealerNr;

    private String productCode;

    private String zoeknaam;

    private String verkoper;

    private String dealerTelnr;

    private String acceptatie;

    private LocalDate aanvangDatum;

    private ZonedDateTime aanvangTijd;

    private LocalDate acceptatieDatum;

    private ZonedDateTime acceptatieTijd;

    private LocalDate prtDatum;

    private String invoerder;

    private String acceptant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcFinetNr() {
        return pcFinetNr;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public String getDealerNr() {
        return dealerNr;
    }

    public void setDealerNr(String dealerNr) {
        this.dealerNr = dealerNr;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getZoeknaam() {
        return zoeknaam;
    }

    public void setZoeknaam(String zoeknaam) {
        this.zoeknaam = zoeknaam;
    }

    public String getVerkoper() {
        return verkoper;
    }

    public void setVerkoper(String verkoper) {
        this.verkoper = verkoper;
    }

    public String getDealerTelnr() {
        return dealerTelnr;
    }

    public void setDealerTelnr(String dealerTelnr) {
        this.dealerTelnr = dealerTelnr;
    }

    public String getAcceptatie() {
        return acceptatie;
    }

    public void setAcceptatie(String acceptatie) {
        this.acceptatie = acceptatie;
    }

    public LocalDate getAanvangDatum() {
        return aanvangDatum;
    }

    public void setAanvangDatum(LocalDate aanvangDatum) {
        this.aanvangDatum = aanvangDatum;
    }

    public ZonedDateTime getAanvangTijd() {
        return aanvangTijd;
    }

    public void setAanvangTijd(ZonedDateTime aanvangTijd) {
        this.aanvangTijd = aanvangTijd;
    }

    public LocalDate getAcceptatieDatum() {
        return acceptatieDatum;
    }

    public void setAcceptatieDatum(LocalDate acceptatieDatum) {
        this.acceptatieDatum = acceptatieDatum;
    }

    public ZonedDateTime getAcceptatieTijd() {
        return acceptatieTijd;
    }

    public void setAcceptatieTijd(ZonedDateTime acceptatieTijd) {
        this.acceptatieTijd = acceptatieTijd;
    }

    public LocalDate getPrtDatum() {
        return prtDatum;
    }

    public void setPrtDatum(LocalDate prtDatum) {
        this.prtDatum = prtDatum;
    }

    public String getInvoerder() {
        return invoerder;
    }

    public void setInvoerder(String invoerder) {
        this.invoerder = invoerder;
    }

    public String getAcceptant() {
        return acceptant;
    }

    public void setAcceptant(String acceptant) {
        this.acceptant = acceptant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO = (Record10AanvraagGegevensAlgemeenDTO) o;
        if (record10AanvraagGegevensAlgemeenDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record10AanvraagGegevensAlgemeenDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record10AanvraagGegevensAlgemeenDTO{" +
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
