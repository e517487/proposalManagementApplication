package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 1 Algemeen allowed per <Aanvraagbericht>
 */
@ApiModel(description = "1 Algemeen allowed per <Aanvraagbericht>")
@Entity
@Table(name = "algemeen")
public class Algemeen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "viewcode")
    private String viewcode;

    @Column(name = "versiecode")
    private String versiecode;

    @Column(name = "valuta")
    private String valuta;

    @Column(name = "aanvraag_versie")
    private Long aanvraagVersie;

    @Column(name = "aanvraag_volg_nr")
    private Long aanvraagVolgNr;

    @Column(name = "tussenpersoon_nr")
    private Long tussenpersoonNr;

    @Column(name = "bedrijfsnaam_tp")
    private String bedrijfsnaamTp;

    @Column(name = "contact_persoon_tp")
    private String contactPersoonTp;

    @Column(name = "maatschappij")
    private String maatschappij;

    @Column(name = "registratie_dt")
    private LocalDate registratieDt;

    @Column(name = "subagent_nr")
    private Long subagentNr;

    @Column(name = "verkopers_naam")
    private String verkopersNaam;

    @OneToOne(mappedBy = "algemeen")
    @JsonIgnore
    private Aanvraagbericht aanvraagbericht;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewcode() {
        return viewcode;
    }

    public Algemeen viewcode(String viewcode) {
        this.viewcode = viewcode;
        return this;
    }

    public void setViewcode(String viewcode) {
        this.viewcode = viewcode;
    }

    public String getVersiecode() {
        return versiecode;
    }

    public Algemeen versiecode(String versiecode) {
        this.versiecode = versiecode;
        return this;
    }

    public void setVersiecode(String versiecode) {
        this.versiecode = versiecode;
    }

    public String getValuta() {
        return valuta;
    }

    public Algemeen valuta(String valuta) {
        this.valuta = valuta;
        return this;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public Long getAanvraagVersie() {
        return aanvraagVersie;
    }

    public Algemeen aanvraagVersie(Long aanvraagVersie) {
        this.aanvraagVersie = aanvraagVersie;
        return this;
    }

    public void setAanvraagVersie(Long aanvraagVersie) {
        this.aanvraagVersie = aanvraagVersie;
    }

    public Long getAanvraagVolgNr() {
        return aanvraagVolgNr;
    }

    public Algemeen aanvraagVolgNr(Long aanvraagVolgNr) {
        this.aanvraagVolgNr = aanvraagVolgNr;
        return this;
    }

    public void setAanvraagVolgNr(Long aanvraagVolgNr) {
        this.aanvraagVolgNr = aanvraagVolgNr;
    }

    public Long getTussenpersoonNr() {
        return tussenpersoonNr;
    }

    public Algemeen tussenpersoonNr(Long tussenpersoonNr) {
        this.tussenpersoonNr = tussenpersoonNr;
        return this;
    }

    public void setTussenpersoonNr(Long tussenpersoonNr) {
        this.tussenpersoonNr = tussenpersoonNr;
    }

    public String getBedrijfsnaamTp() {
        return bedrijfsnaamTp;
    }

    public Algemeen bedrijfsnaamTp(String bedrijfsnaamTp) {
        this.bedrijfsnaamTp = bedrijfsnaamTp;
        return this;
    }

    public void setBedrijfsnaamTp(String bedrijfsnaamTp) {
        this.bedrijfsnaamTp = bedrijfsnaamTp;
    }

    public String getContactPersoonTp() {
        return contactPersoonTp;
    }

    public Algemeen contactPersoonTp(String contactPersoonTp) {
        this.contactPersoonTp = contactPersoonTp;
        return this;
    }

    public void setContactPersoonTp(String contactPersoonTp) {
        this.contactPersoonTp = contactPersoonTp;
    }

    public String getMaatschappij() {
        return maatschappij;
    }

    public Algemeen maatschappij(String maatschappij) {
        this.maatschappij = maatschappij;
        return this;
    }

    public void setMaatschappij(String maatschappij) {
        this.maatschappij = maatschappij;
    }

    public LocalDate getRegistratieDt() {
        return registratieDt;
    }

    public Algemeen registratieDt(LocalDate registratieDt) {
        this.registratieDt = registratieDt;
        return this;
    }

    public void setRegistratieDt(LocalDate registratieDt) {
        this.registratieDt = registratieDt;
    }

    public Long getSubagentNr() {
        return subagentNr;
    }

    public Algemeen subagentNr(Long subagentNr) {
        this.subagentNr = subagentNr;
        return this;
    }

    public void setSubagentNr(Long subagentNr) {
        this.subagentNr = subagentNr;
    }

    public String getVerkopersNaam() {
        return verkopersNaam;
    }

    public Algemeen verkopersNaam(String verkopersNaam) {
        this.verkopersNaam = verkopersNaam;
        return this;
    }

    public void setVerkopersNaam(String verkopersNaam) {
        this.verkopersNaam = verkopersNaam;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public Algemeen aanvraagbericht(Aanvraagbericht aanvraagbericht) {
        this.aanvraagbericht = aanvraagbericht;
        return this;
    }

    public void setAanvraagbericht(Aanvraagbericht aanvraagbericht) {
        this.aanvraagbericht = aanvraagbericht;
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
        Algemeen algemeen = (Algemeen) o;
        if (algemeen.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), algemeen.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Algemeen{" +
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
