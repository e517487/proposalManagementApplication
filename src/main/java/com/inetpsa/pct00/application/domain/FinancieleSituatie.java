package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A FinancieleSituatie.
 */
@Entity
@Table(name = "financiele_situatie")
public class FinancieleSituatie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "bruto_maand_ink", precision = 10, scale = 2)
    private BigDecimal brutoMaandInk;

    @Column(name = "netto_maand_ink", precision = 10, scale = 2)
    private BigDecimal nettoMaandInk;

    @Column(name = "voorlopige_teruggaaf")
    private String voorlopigeTeruggaaf;

    @Column(name = "eigen_woning")
    private String eigenWoning;

    @Column(name = "hypotheek")
    private String hypotheek;

    @Column(name = "bruto_mnd_hypotheek", precision = 10, scale = 2)
    private BigDecimal brutoMndHypotheek;

    @Column(name = "lopende_leningen")
    private String lopendeLeningen;

    @Column(name = "woonsituatie")
    private String woonsituatie;

    @Column(name = "woonlasten", precision = 10, scale = 2)
    private BigDecimal woonlasten;

    @ManyToOne
    @JsonIgnoreProperties("financieleSituaties")
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

    public FinancieleSituatie volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public BigDecimal getBrutoMaandInk() {
        return brutoMaandInk;
    }

    public FinancieleSituatie brutoMaandInk(BigDecimal brutoMaandInk) {
        this.brutoMaandInk = brutoMaandInk;
        return this;
    }

    public void setBrutoMaandInk(BigDecimal brutoMaandInk) {
        this.brutoMaandInk = brutoMaandInk;
    }

    public BigDecimal getNettoMaandInk() {
        return nettoMaandInk;
    }

    public FinancieleSituatie nettoMaandInk(BigDecimal nettoMaandInk) {
        this.nettoMaandInk = nettoMaandInk;
        return this;
    }

    public void setNettoMaandInk(BigDecimal nettoMaandInk) {
        this.nettoMaandInk = nettoMaandInk;
    }

    public String getVoorlopigeTeruggaaf() {
        return voorlopigeTeruggaaf;
    }

    public FinancieleSituatie voorlopigeTeruggaaf(String voorlopigeTeruggaaf) {
        this.voorlopigeTeruggaaf = voorlopigeTeruggaaf;
        return this;
    }

    public void setVoorlopigeTeruggaaf(String voorlopigeTeruggaaf) {
        this.voorlopigeTeruggaaf = voorlopigeTeruggaaf;
    }

    public String getEigenWoning() {
        return eigenWoning;
    }

    public FinancieleSituatie eigenWoning(String eigenWoning) {
        this.eigenWoning = eigenWoning;
        return this;
    }

    public void setEigenWoning(String eigenWoning) {
        this.eigenWoning = eigenWoning;
    }

    public String getHypotheek() {
        return hypotheek;
    }

    public FinancieleSituatie hypotheek(String hypotheek) {
        this.hypotheek = hypotheek;
        return this;
    }

    public void setHypotheek(String hypotheek) {
        this.hypotheek = hypotheek;
    }

    public BigDecimal getBrutoMndHypotheek() {
        return brutoMndHypotheek;
    }

    public FinancieleSituatie brutoMndHypotheek(BigDecimal brutoMndHypotheek) {
        this.brutoMndHypotheek = brutoMndHypotheek;
        return this;
    }

    public void setBrutoMndHypotheek(BigDecimal brutoMndHypotheek) {
        this.brutoMndHypotheek = brutoMndHypotheek;
    }

    public String getLopendeLeningen() {
        return lopendeLeningen;
    }

    public FinancieleSituatie lopendeLeningen(String lopendeLeningen) {
        this.lopendeLeningen = lopendeLeningen;
        return this;
    }

    public void setLopendeLeningen(String lopendeLeningen) {
        this.lopendeLeningen = lopendeLeningen;
    }

    public String getWoonsituatie() {
        return woonsituatie;
    }

    public FinancieleSituatie woonsituatie(String woonsituatie) {
        this.woonsituatie = woonsituatie;
        return this;
    }

    public void setWoonsituatie(String woonsituatie) {
        this.woonsituatie = woonsituatie;
    }

    public BigDecimal getWoonlasten() {
        return woonlasten;
    }

    public FinancieleSituatie woonlasten(BigDecimal woonlasten) {
        this.woonlasten = woonlasten;
        return this;
    }

    public void setWoonlasten(BigDecimal woonlasten) {
        this.woonlasten = woonlasten;
    }

    public FdnAanvrager getFdnAanvrager() {
        return fdnAanvrager;
    }

    public FinancieleSituatie fdnAanvrager(FdnAanvrager fdnAanvrager) {
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
        FinancieleSituatie financieleSituatie = (FinancieleSituatie) o;
        if (financieleSituatie.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), financieleSituatie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FinancieleSituatie{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", brutoMaandInk=" + getBrutoMaandInk() +
            ", nettoMaandInk=" + getNettoMaandInk() +
            ", voorlopigeTeruggaaf='" + getVoorlopigeTeruggaaf() + "'" +
            ", eigenWoning='" + getEigenWoning() + "'" +
            ", hypotheek='" + getHypotheek() + "'" +
            ", brutoMndHypotheek=" + getBrutoMndHypotheek() +
            ", lopendeLeningen='" + getLopendeLeningen() + "'" +
            ", woonsituatie='" + getWoonsituatie() + "'" +
            ", woonlasten=" + getWoonlasten() +
            "}";
    }
}
