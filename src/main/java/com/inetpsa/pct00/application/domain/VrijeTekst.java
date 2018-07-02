package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * 0..n of VrijeTekst allowed per <Aanvraagbericht>
 * Make a tekst blok(s) containing severalrows of tekst.
 */
@ApiModel(description = "0..n of VrijeTekst allowed per <Aanvraagbericht>Make a tekst blok(s) containing severalrows of tekst.")
@Entity
@Table(name = "vrije_tekst")
public class VrijeTekst implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @OneToMany(mappedBy = "vrijeTekst")
    private Set<TekstRegel> tekstRegels = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("vrijeTeksts")
    private Aanvraagbericht aanvraagbericht;

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

    public VrijeTekst volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public Set<TekstRegel> getTekstRegels() {
        return tekstRegels;
    }

    public VrijeTekst tekstRegels(Set<TekstRegel> tekstRegels) {
        this.tekstRegels = tekstRegels;
        return this;
    }

    public VrijeTekst addTekstRegel(TekstRegel tekstRegel) {
        this.tekstRegels.add(tekstRegel);
        tekstRegel.setVrijeTekst(this);
        return this;
    }

    public VrijeTekst removeTekstRegel(TekstRegel tekstRegel) {
        this.tekstRegels.remove(tekstRegel);
        tekstRegel.setVrijeTekst(null);
        return this;
    }

    public void setTekstRegels(Set<TekstRegel> tekstRegels) {
        this.tekstRegels = tekstRegels;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public VrijeTekst aanvraagbericht(Aanvraagbericht aanvraagbericht) {
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
        VrijeTekst vrijeTekst = (VrijeTekst) o;
        if (vrijeTekst.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vrijeTekst.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VrijeTekst{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            "}";
    }
}
