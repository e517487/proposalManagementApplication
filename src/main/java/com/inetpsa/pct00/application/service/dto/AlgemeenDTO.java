package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Algemeen entity.
 */
public class AlgemeenDTO implements Serializable {

    private Long id;

    private String viewcode;

    private String versiecode;

    private String valuta;

    private Long aanvraagVersie;

    private Long aanvraagVolgNr;

    private Long tussenpersoonNr;

    private String bedrijfsnaamTp;

    private String contactPersoonTp;

    private String maatschappij;

    private LocalDate registratieDt;

    private Long subagentNr;

    private String verkopersNaam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewcode() {
        return viewcode;
    }

    public void setViewcode(String viewcode) {
        this.viewcode = viewcode;
    }

    public String getVersiecode() {
        return versiecode;
    }

    public void setVersiecode(String versiecode) {
        this.versiecode = versiecode;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Long getAanvraagVersie() {
        return aanvraagVersie;
    }

    public void setAanvraagVersie(Long aanvraagVersie) {
        this.aanvraagVersie = aanvraagVersie;
    }

    public Long getAanvraagVolgNr() {
        return aanvraagVolgNr;
    }

    public void setAanvraagVolgNr(Long aanvraagVolgNr) {
        this.aanvraagVolgNr = aanvraagVolgNr;
    }

    public Long getTussenpersoonNr() {
        return tussenpersoonNr;
    }

    public void setTussenpersoonNr(Long tussenpersoonNr) {
        this.tussenpersoonNr = tussenpersoonNr;
    }

    public String getBedrijfsnaamTp() {
        return bedrijfsnaamTp;
    }

    public void setBedrijfsnaamTp(String bedrijfsnaamTp) {
        this.bedrijfsnaamTp = bedrijfsnaamTp;
    }

    public String getContactPersoonTp() {
        return contactPersoonTp;
    }

    public void setContactPersoonTp(String contactPersoonTp) {
        this.contactPersoonTp = contactPersoonTp;
    }

    public String getMaatschappij() {
        return maatschappij;
    }

    public void setMaatschappij(String maatschappij) {
        this.maatschappij = maatschappij;
    }

    public LocalDate getRegistratieDt() {
        return registratieDt;
    }

    public void setRegistratieDt(LocalDate registratieDt) {
        this.registratieDt = registratieDt;
    }

    public Long getSubagentNr() {
        return subagentNr;
    }

    public void setSubagentNr(Long subagentNr) {
        this.subagentNr = subagentNr;
    }

    public String getVerkopersNaam() {
        return verkopersNaam;
    }

    public void setVerkopersNaam(String verkopersNaam) {
        this.verkopersNaam = verkopersNaam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AlgemeenDTO algemeenDTO = (AlgemeenDTO) o;
        if (algemeenDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), algemeenDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AlgemeenDTO{" +
            "id=" + getId() +
            ", viewcode='" + getViewcode() + "'" +
            ", versiecode='" + getVersiecode() + "'" +
            ", valuta='" + getValuta() + "'" +
            ", aanvraagVersie=" + getAanvraagVersie() +
            ", aanvraagVolgNr=" + getAanvraagVolgNr() +
            ", tussenpersoonNr=" + getTussenpersoonNr() +
            ", bedrijfsnaamTp='" + getBedrijfsnaamTp() + "'" +
            ", contactPersoonTp='" + getContactPersoonTp() + "'" +
            ", maatschappij='" + getMaatschappij() + "'" +
            ", registratieDt='" + getRegistratieDt() + "'" +
            ", subagentNr=" + getSubagentNr() +
            ", verkopersNaam='" + getVerkopersNaam() + "'" +
            "}";
    }
}
