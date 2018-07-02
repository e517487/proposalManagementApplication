package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Adres entity.
 */
public class AdresDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String soortAdres;

    private String straatNaam;

    private String huisNr;

    private String plaatsNaam;

    private String postcode;

    private String land;

    private Long fdnAanvragerId;

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

    public String getSoortAdres() {
        return soortAdres;
    }

    public void setSoortAdres(String soortAdres) {
        this.soortAdres = soortAdres;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Long getFdnAanvragerId() {
        return fdnAanvragerId;
    }

    public void setFdnAanvragerId(Long fdnAanvragerId) {
        this.fdnAanvragerId = fdnAanvragerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AdresDTO adresDTO = (AdresDTO) o;
        if (adresDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), adresDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AdresDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soortAdres='" + getSoortAdres() + "'" +
            ", straatNaam='" + getStraatNaam() + "'" +
            ", huisNr='" + getHuisNr() + "'" +
            ", plaatsNaam='" + getPlaatsNaam() + "'" +
            ", postcode='" + getPostcode() + "'" +
            ", land='" + getLand() + "'" +
            ", fdnAanvrager=" + getFdnAanvragerId() +
            "}";
    }
}
