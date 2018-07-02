package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A NawWerkgeverUWV.
 */
@Entity
@Table(name = "naw_werkgever_uwv")
public class NawWerkgeverUWV implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "naam")
    private String naam;

    @Column(name = "plaats_naam")
    private String plaatsNaam;

    @ManyToOne
    @JsonIgnoreProperties("nawWerkgeverUWVS")
    private Werksituatie werksituatie;

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

    public NawWerkgeverUWV volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getNaam() {
        return naam;
    }

    public NawWerkgeverUWV naam(String naam) {
        this.naam = naam;
        return this;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public NawWerkgeverUWV plaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
        return this;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public Werksituatie getWerksituatie() {
        return werksituatie;
    }

    public NawWerkgeverUWV werksituatie(Werksituatie werksituatie) {
        this.werksituatie = werksituatie;
        return this;
    }

    public void setWerksituatie(Werksituatie werksituatie) {
        this.werksituatie = werksituatie;
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
        NawWerkgeverUWV nawWerkgeverUWV = (NawWerkgeverUWV) o;
        if (nawWerkgeverUWV.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nawWerkgeverUWV.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NawWerkgeverUWV{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", naam='" + getNaam() + "'" +
            ", plaatsNaam='" + getPlaatsNaam() + "'" +
            "}";
    }
}
