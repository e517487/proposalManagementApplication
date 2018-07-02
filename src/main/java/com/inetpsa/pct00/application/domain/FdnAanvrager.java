package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * 0..n of FdnAanvrager allowed per <Aanvraagbericht>
 */
@ApiModel(description = "0..n of FdnAanvrager allowed per <Aanvraagbericht>")
@Entity
@Table(name = "fdn_aanvrager")
public class FdnAanvrager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "soort_aanvrager")
    private String soortAanvrager;

    @Column(name = "achter_naam")
    private String achterNaam;

    @Column(name = "voorletters")
    private String voorletters;

    @Column(name = "geb_naam")
    private String gebNaam;

    @Column(name = "woonachtig_huidig_dt")
    private LocalDate woonachtigHuidigDt;

    @Column(name = "tel_bereikbaar")
    private String telBereikbaar;

    @Column(name = "telefoon_nr_prive")
    private String telefoonNrPrive;

    @Column(name = "iban")
    private String iban;

    @Column(name = "geboorte_dt")
    private LocalDate geboorteDt;

    @Column(name = "nationaliteit")
    private String nationaliteit;

    @Column(name = "geslacht")
    private String geslacht;

    @Column(name = "sociaal_fiscaal_nr")
    private String sociaalFiscaalNr;

    @Column(name = "relatie_tp")
    private String relatieTp;

    @OneToMany(mappedBy = "fdnAanvrager")
    private Set<Adres> adres = new HashSet<>();

    @OneToMany(mappedBy = "fdnAanvrager")
    private Set<Legitimatiebewijs> legitimatiebewijs = new HashSet<>();

    @OneToMany(mappedBy = "fdnAanvrager")
    private Set<Werksituatie> werksituaties = new HashSet<>();

    @OneToMany(mappedBy = "fdnAanvrager")
    private Set<Gezinssituatie> gezinssituaties = new HashSet<>();

    @OneToMany(mappedBy = "fdnAanvrager")
    private Set<FinancieleSituatie> financieleSituaties = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("fdnAanvragers")
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

    public FdnAanvrager volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getSoortAanvrager() {
        return soortAanvrager;
    }

    public FdnAanvrager soortAanvrager(String soortAanvrager) {
        this.soortAanvrager = soortAanvrager;
        return this;
    }

    public void setSoortAanvrager(String soortAanvrager) {
        this.soortAanvrager = soortAanvrager;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public FdnAanvrager achterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
        return this;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public FdnAanvrager voorletters(String voorletters) {
        this.voorletters = voorletters;
        return this;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getGebNaam() {
        return gebNaam;
    }

    public FdnAanvrager gebNaam(String gebNaam) {
        this.gebNaam = gebNaam;
        return this;
    }

    public void setGebNaam(String gebNaam) {
        this.gebNaam = gebNaam;
    }

    public LocalDate getWoonachtigHuidigDt() {
        return woonachtigHuidigDt;
    }

    public FdnAanvrager woonachtigHuidigDt(LocalDate woonachtigHuidigDt) {
        this.woonachtigHuidigDt = woonachtigHuidigDt;
        return this;
    }

    public void setWoonachtigHuidigDt(LocalDate woonachtigHuidigDt) {
        this.woonachtigHuidigDt = woonachtigHuidigDt;
    }

    public String getTelBereikbaar() {
        return telBereikbaar;
    }

    public FdnAanvrager telBereikbaar(String telBereikbaar) {
        this.telBereikbaar = telBereikbaar;
        return this;
    }

    public void setTelBereikbaar(String telBereikbaar) {
        this.telBereikbaar = telBereikbaar;
    }

    public String getTelefoonNrPrive() {
        return telefoonNrPrive;
    }

    public FdnAanvrager telefoonNrPrive(String telefoonNrPrive) {
        this.telefoonNrPrive = telefoonNrPrive;
        return this;
    }

    public void setTelefoonNrPrive(String telefoonNrPrive) {
        this.telefoonNrPrive = telefoonNrPrive;
    }

    public String getIban() {
        return iban;
    }

    public FdnAanvrager iban(String iban) {
        this.iban = iban;
        return this;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDate getGeboorteDt() {
        return geboorteDt;
    }

    public FdnAanvrager geboorteDt(LocalDate geboorteDt) {
        this.geboorteDt = geboorteDt;
        return this;
    }

    public void setGeboorteDt(LocalDate geboorteDt) {
        this.geboorteDt = geboorteDt;
    }

    public String getNationaliteit() {
        return nationaliteit;
    }

    public FdnAanvrager nationaliteit(String nationaliteit) {
        this.nationaliteit = nationaliteit;
        return this;
    }

    public void setNationaliteit(String nationaliteit) {
        this.nationaliteit = nationaliteit;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public FdnAanvrager geslacht(String geslacht) {
        this.geslacht = geslacht;
        return this;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getSociaalFiscaalNr() {
        return sociaalFiscaalNr;
    }

    public FdnAanvrager sociaalFiscaalNr(String sociaalFiscaalNr) {
        this.sociaalFiscaalNr = sociaalFiscaalNr;
        return this;
    }

    public void setSociaalFiscaalNr(String sociaalFiscaalNr) {
        this.sociaalFiscaalNr = sociaalFiscaalNr;
    }

    public String getRelatieTp() {
        return relatieTp;
    }

    public FdnAanvrager relatieTp(String relatieTp) {
        this.relatieTp = relatieTp;
        return this;
    }

    public void setRelatieTp(String relatieTp) {
        this.relatieTp = relatieTp;
    }

    public Set<Adres> getAdres() {
        return adres;
    }

    public FdnAanvrager adres(Set<Adres> adres) {
        this.adres = adres;
        return this;
    }

    public FdnAanvrager addAdres(Adres adres) {
        this.adres.add(adres);
        adres.setFdnAanvrager(this);
        return this;
    }

    public FdnAanvrager removeAdres(Adres adres) {
        this.adres.remove(adres);
        adres.setFdnAanvrager(null);
        return this;
    }

    public void setAdres(Set<Adres> adres) {
        this.adres = adres;
    }

    public Set<Legitimatiebewijs> getLegitimatiebewijs() {
        return legitimatiebewijs;
    }

    public FdnAanvrager legitimatiebewijs(Set<Legitimatiebewijs> legitimatiebewijs) {
        this.legitimatiebewijs = legitimatiebewijs;
        return this;
    }

    public FdnAanvrager addLegitimatiebewijs(Legitimatiebewijs legitimatiebewijs) {
        this.legitimatiebewijs.add(legitimatiebewijs);
        legitimatiebewijs.setFdnAanvrager(this);
        return this;
    }

    public FdnAanvrager removeLegitimatiebewijs(Legitimatiebewijs legitimatiebewijs) {
        this.legitimatiebewijs.remove(legitimatiebewijs);
        legitimatiebewijs.setFdnAanvrager(null);
        return this;
    }

    public void setLegitimatiebewijs(Set<Legitimatiebewijs> legitimatiebewijs) {
        this.legitimatiebewijs = legitimatiebewijs;
    }

    public Set<Werksituatie> getWerksituaties() {
        return werksituaties;
    }

    public FdnAanvrager werksituaties(Set<Werksituatie> werksituaties) {
        this.werksituaties = werksituaties;
        return this;
    }

    public FdnAanvrager addWerksituatie(Werksituatie werksituatie) {
        this.werksituaties.add(werksituatie);
        werksituatie.setFdnAanvrager(this);
        return this;
    }

    public FdnAanvrager removeWerksituatie(Werksituatie werksituatie) {
        this.werksituaties.remove(werksituatie);
        werksituatie.setFdnAanvrager(null);
        return this;
    }

    public void setWerksituaties(Set<Werksituatie> werksituaties) {
        this.werksituaties = werksituaties;
    }

    public Set<Gezinssituatie> getGezinssituaties() {
        return gezinssituaties;
    }

    public FdnAanvrager gezinssituaties(Set<Gezinssituatie> gezinssituaties) {
        this.gezinssituaties = gezinssituaties;
        return this;
    }

    public FdnAanvrager addGezinssituatie(Gezinssituatie gezinssituatie) {
        this.gezinssituaties.add(gezinssituatie);
        gezinssituatie.setFdnAanvrager(this);
        return this;
    }

    public FdnAanvrager removeGezinssituatie(Gezinssituatie gezinssituatie) {
        this.gezinssituaties.remove(gezinssituatie);
        gezinssituatie.setFdnAanvrager(null);
        return this;
    }

    public void setGezinssituaties(Set<Gezinssituatie> gezinssituaties) {
        this.gezinssituaties = gezinssituaties;
    }

    public Set<FinancieleSituatie> getFinancieleSituaties() {
        return financieleSituaties;
    }

    public FdnAanvrager financieleSituaties(Set<FinancieleSituatie> financieleSituaties) {
        this.financieleSituaties = financieleSituaties;
        return this;
    }

    public FdnAanvrager addFinancieleSituatie(FinancieleSituatie financieleSituatie) {
        this.financieleSituaties.add(financieleSituatie);
        financieleSituatie.setFdnAanvrager(this);
        return this;
    }

    public FdnAanvrager removeFinancieleSituatie(FinancieleSituatie financieleSituatie) {
        this.financieleSituaties.remove(financieleSituatie);
        financieleSituatie.setFdnAanvrager(null);
        return this;
    }

    public void setFinancieleSituaties(Set<FinancieleSituatie> financieleSituaties) {
        this.financieleSituaties = financieleSituaties;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public FdnAanvrager aanvraagbericht(Aanvraagbericht aanvraagbericht) {
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
        FdnAanvrager fdnAanvrager = (FdnAanvrager) o;
        if (fdnAanvrager.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), fdnAanvrager.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FdnAanvrager{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soortAanvrager='" + getSoortAanvrager() + "'" +
            ", achterNaam='" + getAchterNaam() + "'" +
            ", voorletters='" + getVoorletters() + "'" +
            ", gebNaam='" + getGebNaam() + "'" +
            ", woonachtigHuidigDt='" + getWoonachtigHuidigDt() + "'" +
            ", telBereikbaar='" + getTelBereikbaar() + "'" +
            ", telefoonNrPrive='" + getTelefoonNrPrive() + "'" +
            ", iban='" + getIban() + "'" +
            ", geboorteDt='" + getGeboorteDt() + "'" +
            ", nationaliteit='" + getNationaliteit() + "'" +
            ", geslacht='" + getGeslacht() + "'" +
            ", sociaalFiscaalNr='" + getSociaalFiscaalNr() + "'" +
            ", relatieTp='" + getRelatieTp() + "'" +
            "}";
    }
}
