package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 1 Header allowed per <Aanvraagbericht>
 */
@ApiModel(description = "1 Header allowed per <Aanvraagbericht>")
@Entity
@Table(name = "header")
public class Header implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "email_zender")
    private String emailZender;

    @Column(name = "email_ontvanger")
    private String emailOntvanger;

    @Column(name = "ontvanger_naam")
    private String ontvangerNaam;

    @Column(name = "lognaam")
    private String lognaam;

    @Column(name = "message_ref")
    private String messageRef;

    @Column(name = "bericht_versie")
    private Integer berichtVersie;

    @Column(name = "verzend_dt")
    private LocalDate verzendDt;

    @Column(name = "verzend_tijd")
    private LocalDate verzendTijd;

    @OneToOne(mappedBy = "header")
    @JsonIgnore
    private Aanvraagbericht aanvraagbericht;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailZender() {
        return emailZender;
    }

    public Header emailZender(String emailZender) {
        this.emailZender = emailZender;
        return this;
    }

    public void setEmailZender(String emailZender) {
        this.emailZender = emailZender;
    }

    public String getEmailOntvanger() {
        return emailOntvanger;
    }

    public Header emailOntvanger(String emailOntvanger) {
        this.emailOntvanger = emailOntvanger;
        return this;
    }

    public void setEmailOntvanger(String emailOntvanger) {
        this.emailOntvanger = emailOntvanger;
    }

    public String getOntvangerNaam() {
        return ontvangerNaam;
    }

    public Header ontvangerNaam(String ontvangerNaam) {
        this.ontvangerNaam = ontvangerNaam;
        return this;
    }

    public void setOntvangerNaam(String ontvangerNaam) {
        this.ontvangerNaam = ontvangerNaam;
    }

    public String getLognaam() {
        return lognaam;
    }

    public Header lognaam(String lognaam) {
        this.lognaam = lognaam;
        return this;
    }

    public void setLognaam(String lognaam) {
        this.lognaam = lognaam;
    }

    public String getMessageRef() {
        return messageRef;
    }

    public Header messageRef(String messageRef) {
        this.messageRef = messageRef;
        return this;
    }

    public void setMessageRef(String messageRef) {
        this.messageRef = messageRef;
    }

    public Integer getBerichtVersie() {
        return berichtVersie;
    }

    public Header berichtVersie(Integer berichtVersie) {
        this.berichtVersie = berichtVersie;
        return this;
    }

    public void setBerichtVersie(Integer berichtVersie) {
        this.berichtVersie = berichtVersie;
    }

    public LocalDate getVerzendDt() {
        return verzendDt;
    }

    public Header verzendDt(LocalDate verzendDt) {
        this.verzendDt = verzendDt;
        return this;
    }

    public void setVerzendDt(LocalDate verzendDt) {
        this.verzendDt = verzendDt;
    }

    public LocalDate getVerzendTijd() {
        return verzendTijd;
    }

    public Header verzendTijd(LocalDate verzendTijd) {
        this.verzendTijd = verzendTijd;
        return this;
    }

    public void setVerzendTijd(LocalDate verzendTijd) {
        this.verzendTijd = verzendTijd;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public Header aanvraagbericht(Aanvraagbericht aanvraagbericht) {
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
        Header header = (Header) o;
        if (header.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), header.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Header{" +
            "id=" + getId() +
            ", emailZender='" + getEmailZender() + "'" +
            ", emailOntvanger='" + getEmailOntvanger() + "'" +
            ", ontvangerNaam='" + getOntvangerNaam() + "'" +
            ", lognaam='" + getLognaam() + "'" +
            ", messageRef='" + getMessageRef() + "'" +
            ", berichtVersie=" + getBerichtVersie() +
            ", verzendDt='" + getVerzendDt() + "'" +
            ", verzendTijd='" + getVerzendTijd() + "'" +
            "}";
    }
}
