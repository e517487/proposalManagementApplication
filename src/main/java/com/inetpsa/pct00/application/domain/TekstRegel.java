package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 0..n Rows of text in the parent VrijeTekst
 */
@ApiModel(description = "0..n Rows of text in the parent VrijeTekst")
@Entity
@Table(name = "tekst_regel")
public class TekstRegel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "regelnummer")
    private Long regelnummer;

    @Column(name = "tekst")
    private String tekst;

    @ManyToOne
    @JsonIgnoreProperties("tekstRegels")
    private VrijeTekst vrijeTekst;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegelnummer() {
        return regelnummer;
    }

    public TekstRegel regelnummer(Long regelnummer) {
        this.regelnummer = regelnummer;
        return this;
    }

    public void setRegelnummer(Long regelnummer) {
        this.regelnummer = regelnummer;
    }

    public String getTekst() {
        return tekst;
    }

    public TekstRegel tekst(String tekst) {
        this.tekst = tekst;
        return this;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public VrijeTekst getVrijeTekst() {
        return vrijeTekst;
    }

    public TekstRegel vrijeTekst(VrijeTekst vrijeTekst) {
        this.vrijeTekst = vrijeTekst;
        return this;
    }

    public void setVrijeTekst(VrijeTekst vrijeTekst) {
        this.vrijeTekst = vrijeTekst;
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
        TekstRegel tekstRegel = (TekstRegel) o;
        if (tekstRegel.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tekstRegel.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TekstRegel{" +
            "id=" + getId() +
            ", regelnummer=" + getRegelnummer() +
            ", tekst='" + getTekst() + "'" +
            "}";
    }
}
