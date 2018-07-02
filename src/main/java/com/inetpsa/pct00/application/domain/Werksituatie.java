package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Werksituatie.
 */
@Entity
@Table(name = "werksituatie")
public class Werksituatie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "beroep")
    private String beroep;

    @Column(name = "aard_dienstverband")
    private String aardDienstverband;

    @Column(name = "begin_dienstverband_dt")
    private LocalDate beginDienstverbandDt;

    @OneToMany(mappedBy = "werksituatie")
    private Set<NawWerkgeverUWV> nawWerkgeverUWVS = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("werksituaties")
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

    public Werksituatie volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getBeroep() {
        return beroep;
    }

    public Werksituatie beroep(String beroep) {
        this.beroep = beroep;
        return this;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public String getAardDienstverband() {
        return aardDienstverband;
    }

    public Werksituatie aardDienstverband(String aardDienstverband) {
        this.aardDienstverband = aardDienstverband;
        return this;
    }

    public void setAardDienstverband(String aardDienstverband) {
        this.aardDienstverband = aardDienstverband;
    }

    public LocalDate getBeginDienstverbandDt() {
        return beginDienstverbandDt;
    }

    public Werksituatie beginDienstverbandDt(LocalDate beginDienstverbandDt) {
        this.beginDienstverbandDt = beginDienstverbandDt;
        return this;
    }

    public void setBeginDienstverbandDt(LocalDate beginDienstverbandDt) {
        this.beginDienstverbandDt = beginDienstverbandDt;
    }

    public Set<NawWerkgeverUWV> getNawWerkgeverUWVS() {
        return nawWerkgeverUWVS;
    }

    public Werksituatie nawWerkgeverUWVS(Set<NawWerkgeverUWV> nawWerkgeverUWVS) {
        this.nawWerkgeverUWVS = nawWerkgeverUWVS;
        return this;
    }

    public Werksituatie addNawWerkgeverUWV(NawWerkgeverUWV nawWerkgeverUWV) {
        this.nawWerkgeverUWVS.add(nawWerkgeverUWV);
        nawWerkgeverUWV.setWerksituatie(this);
        return this;
    }

    public Werksituatie removeNawWerkgeverUWV(NawWerkgeverUWV nawWerkgeverUWV) {
        this.nawWerkgeverUWVS.remove(nawWerkgeverUWV);
        nawWerkgeverUWV.setWerksituatie(null);
        return this;
    }

    public void setNawWerkgeverUWVS(Set<NawWerkgeverUWV> nawWerkgeverUWVS) {
        this.nawWerkgeverUWVS = nawWerkgeverUWVS;
    }

    public FdnAanvrager getFdnAanvrager() {
        return fdnAanvrager;
    }

    public Werksituatie fdnAanvrager(FdnAanvrager fdnAanvrager) {
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
        Werksituatie werksituatie = (Werksituatie) o;
        if (werksituatie.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), werksituatie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Werksituatie{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", beroep='" + getBeroep() + "'" +
            ", aardDienstverband='" + getAardDienstverband() + "'" +
            ", beginDienstverbandDt='" + getBeginDienstverbandDt() + "'" +
            "}";
    }
}
