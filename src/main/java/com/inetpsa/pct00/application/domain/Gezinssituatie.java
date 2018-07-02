package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Gezinssituatie.
 */
@Entity
@Table(name = "gezinssituatie")
public class Gezinssituatie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "burgerlijke_staat")
    private String burgerlijkeStaat;

    @Column(name = "huwelijkse_vw")
    private String huwelijkseVw;

    @Column(name = "huwelijk_ontbonden")
    private String huwelijkOntbonden;

    @Column(name = "weduwe_weduwnaar")
    private String weduweWeduwnaar;

    @Column(name = "kinderen_aantal")
    private Integer kinderenAantal;

    @ManyToOne
    @JsonIgnoreProperties("gezinssituaties")
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

    public Gezinssituatie volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getBurgerlijkeStaat() {
        return burgerlijkeStaat;
    }

    public Gezinssituatie burgerlijkeStaat(String burgerlijkeStaat) {
        this.burgerlijkeStaat = burgerlijkeStaat;
        return this;
    }

    public void setBurgerlijkeStaat(String burgerlijkeStaat) {
        this.burgerlijkeStaat = burgerlijkeStaat;
    }

    public String getHuwelijkseVw() {
        return huwelijkseVw;
    }

    public Gezinssituatie huwelijkseVw(String huwelijkseVw) {
        this.huwelijkseVw = huwelijkseVw;
        return this;
    }

    public void setHuwelijkseVw(String huwelijkseVw) {
        this.huwelijkseVw = huwelijkseVw;
    }

    public String getHuwelijkOntbonden() {
        return huwelijkOntbonden;
    }

    public Gezinssituatie huwelijkOntbonden(String huwelijkOntbonden) {
        this.huwelijkOntbonden = huwelijkOntbonden;
        return this;
    }

    public void setHuwelijkOntbonden(String huwelijkOntbonden) {
        this.huwelijkOntbonden = huwelijkOntbonden;
    }

    public String getWeduweWeduwnaar() {
        return weduweWeduwnaar;
    }

    public Gezinssituatie weduweWeduwnaar(String weduweWeduwnaar) {
        this.weduweWeduwnaar = weduweWeduwnaar;
        return this;
    }

    public void setWeduweWeduwnaar(String weduweWeduwnaar) {
        this.weduweWeduwnaar = weduweWeduwnaar;
    }

    public Integer getKinderenAantal() {
        return kinderenAantal;
    }

    public Gezinssituatie kinderenAantal(Integer kinderenAantal) {
        this.kinderenAantal = kinderenAantal;
        return this;
    }

    public void setKinderenAantal(Integer kinderenAantal) {
        this.kinderenAantal = kinderenAantal;
    }

    public FdnAanvrager getFdnAanvrager() {
        return fdnAanvrager;
    }

    public Gezinssituatie fdnAanvrager(FdnAanvrager fdnAanvrager) {
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
        Gezinssituatie gezinssituatie = (Gezinssituatie) o;
        if (gezinssituatie.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gezinssituatie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Gezinssituatie{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", burgerlijkeStaat='" + getBurgerlijkeStaat() + "'" +
            ", huwelijkseVw='" + getHuwelijkseVw() + "'" +
            ", huwelijkOntbonden='" + getHuwelijkOntbonden() + "'" +
            ", weduweWeduwnaar='" + getWeduweWeduwnaar() + "'" +
            ", kinderenAantal=" + getKinderenAantal() +
            "}";
    }
}
