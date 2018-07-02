package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the FdnAanvrager entity.
 */
public class FdnAanvragerDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String soortAanvrager;

    private String achterNaam;

    private String voorletters;

    private String gebNaam;

    private LocalDate woonachtigHuidigDt;

    private String telBereikbaar;

    private String telefoonNrPrive;

    private String iban;

    private LocalDate geboorteDt;

    private String nationaliteit;

    private String geslacht;

    private String sociaalFiscaalNr;

    private String relatieTp;

    private Long aanvraagberichtId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getSoortAanvrager() {
        return soortAanvrager;
    }

    public void setSoortAanvrager(String soortAanvrager) {
        this.soortAanvrager = soortAanvrager;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getGebNaam() {
        return gebNaam;
    }

    public void setGebNaam(String gebNaam) {
        this.gebNaam = gebNaam;
    }

    public LocalDate getWoonachtigHuidigDt() {
        return woonachtigHuidigDt;
    }

    public void setWoonachtigHuidigDt(LocalDate woonachtigHuidigDt) {
        this.woonachtigHuidigDt = woonachtigHuidigDt;
    }

    public String getTelBereikbaar() {
        return telBereikbaar;
    }

    public void setTelBereikbaar(String telBereikbaar) {
        this.telBereikbaar = telBereikbaar;
    }

    public String getTelefoonNrPrive() {
        return telefoonNrPrive;
    }

    public void setTelefoonNrPrive(String telefoonNrPrive) {
        this.telefoonNrPrive = telefoonNrPrive;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDate getGeboorteDt() {
        return geboorteDt;
    }

    public void setGeboorteDt(LocalDate geboorteDt) {
        this.geboorteDt = geboorteDt;
    }

    public String getNationaliteit() {
        return nationaliteit;
    }

    public void setNationaliteit(String nationaliteit) {
        this.nationaliteit = nationaliteit;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getSociaalFiscaalNr() {
        return sociaalFiscaalNr;
    }

    public void setSociaalFiscaalNr(String sociaalFiscaalNr) {
        this.sociaalFiscaalNr = sociaalFiscaalNr;
    }

    public String getRelatieTp() {
        return relatieTp;
    }

    public void setRelatieTp(String relatieTp) {
        this.relatieTp = relatieTp;
    }

    public Long getAanvraagberichtId() {
        return aanvraagberichtId;
    }

    public void setAanvraagberichtId(Long aanvraagberichtId) {
        this.aanvraagberichtId = aanvraagberichtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FdnAanvragerDTO fdnAanvragerDTO = (FdnAanvragerDTO) o;
        if (fdnAanvragerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fdnAanvragerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FdnAanvragerDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soortAanvrager='" + getSoortAanvrager() + "'" +
            ", achterNaam='" + getAchterNaam() + "'" +
            ", voorletters='" + getVoorletters() + "'" +
            ", gebNaam='" + getGebNaam() + "'" +
            ", woonachtigHuidigDt='" + getWoonachtigHuidigDt() + "'" +
            ", telBereikbaar='" + getTelBereikbaar() + "'" +
            ", telefoonNrPrive='" + getTelefoonNrPrive() + "'" +
            ", iban='" + getIban() + "'" +
            ", geboorteDt='" + getGeboorteDt() + "'" +
            ", nationaliteit='" + getNationaliteit() + "'" +
            ", geslacht='" + getGeslacht() + "'" +
            ", sociaalFiscaalNr='" + getSociaalFiscaalNr() + "'" +
            ", relatieTp='" + getRelatieTp() + "'" +
            ", aanvraagbericht=" + getAanvraagberichtId() +
            "}";
    }
}
