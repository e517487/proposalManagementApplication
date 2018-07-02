package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(description = "not an ignored comment")
@Entity
@Table(name = "adres")
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "soort_adres")
    private String soortAdres;

    @Column(name = "straat_naam")
    private String straatNaam;

    @Column(name = "huis_nr")
    private String huisNr;

    @Column(name = "plaats_naam")
    private String plaatsNaam;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "land")
    private String land;

    @ManyToOne
    @JsonIgnoreProperties("adres")
    private FdnAanvrager fdnAanvrager;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolgnummer() {
        return volgnummer;
    }

    public Adres volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getSoortAdres() {
        return soortAdres;
    }

    public Adres soortAdres(String soortAdres) {
        this.soortAdres = soortAdres;
        return this;
    }

    public void setSoortAdres(String soortAdres) {
        this.soortAdres = soortAdres;
    }

    public String getStraatNaam() {
        return straatNaam;
    }

    public Adres straatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
        return this;
    }

    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public Adres huisNr(String huisNr) {
        this.huisNr = huisNr;
        return this;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public Adres plaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
        return this;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public Adres postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLand() {
        return land;
    }

    public Adres land(String land) {
        this.land = land;
        return this;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public FdnAanvrager getFdnAanvrager() {
        return fdnAanvrager;
    }

    public Adres fdnAanvrager(FdnAanvrager fdnAanvrager) {
        this.fdnAanvrager = fdnAanvrager;
        return this;
    }

    public void setFdnAanvrager(FdnAanvrager fdnAanvrager) {
        this.fdnAanvrager = fdnAanvrager;
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
        Adres adres = (Adres) o;
        if (adres.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), adres.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Adres{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soortAdres='" + getSoortAdres() + "'" +
            ", straatNaam='" + getStraatNaam() + "'" +
            ", huisNr='" + getHuisNr() + "'" +
            ", plaatsNaam='" + getPlaatsNaam() + "'" +
            ", postcode='" + getPostcode() + "'" +
            ", land='" + getLand() + "'" +
            "}";
    }
}
