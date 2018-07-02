package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Legitimatiebewijs.
 */
@Entity
@Table(name = "legitimatiebewijs")
public class Legitimatiebewijs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "soort")
    private String soort;

    @Column(name = "land")
    private String land;

    @ManyToOne
    @JsonIgnoreProperties("legitimatiebewijs")
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

    public Legitimatiebewijs volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getSoort() {
        return soort;
    }

    public Legitimatiebewijs soort(String soort) {
        this.soort = soort;
        return this;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getLand() {
        return land;
    }

    public Legitimatiebewijs land(String land) {
        this.land = land;
        return this;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public FdnAanvrager getFdnAanvrager() {
        return fdnAanvrager;
    }

    public Legitimatiebewijs fdnAanvrager(FdnAanvrager fdnAanvrager) {
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
        Legitimatiebewijs legitimatiebewijs = (Legitimatiebewijs) o;
        if (legitimatiebewijs.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), legitimatiebewijs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Legitimatiebewijs{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soort='" + getSoort() + "'" +
            ", land='" + getLand() + "'" +
            "}";
    }
}
