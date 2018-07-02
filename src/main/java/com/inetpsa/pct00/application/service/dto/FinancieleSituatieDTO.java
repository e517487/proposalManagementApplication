package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the FinancieleSituatie entity.
 */
public class FinancieleSituatieDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private BigDecimal brutoMaandInk;

    private BigDecimal nettoMaandInk;

    private String voorlopigeTeruggaaf;

    private String eigenWoning;

    private String hypotheek;

    private BigDecimal brutoMndHypotheek;

    private String lopendeLeningen;

    private String woonsituatie;

    private BigDecimal woonlasten;

    private Long fdnAanvragerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public BigDecimal getBrutoMaandInk() {
        return brutoMaandInk;
    }

    public void setBrutoMaandInk(BigDecimal brutoMaandInk) {
        this.brutoMaandInk = brutoMaandInk;
    }

    public BigDecimal getNettoMaandInk() {
        return nettoMaandInk;
    }

    public void setNettoMaandInk(BigDecimal nettoMaandInk) {
        this.nettoMaandInk = nettoMaandInk;
    }

    public String getVoorlopigeTeruggaaf() {
        return voorlopigeTeruggaaf;
    }

    public void setVoorlopigeTeruggaaf(String voorlopigeTeruggaaf) {
        this.voorlopigeTeruggaaf = voorlopigeTeruggaaf;
    }

    public String getEigenWoning() {
        return eigenWoning;
    }

    public void setEigenWoning(String eigenWoning) {
        this.eigenWoning = eigenWoning;
    }

    public String getHypotheek() {
        return hypotheek;
    }

    public void setHypotheek(String hypotheek) {
        this.hypotheek = hypotheek;
    }

    public BigDecimal getBrutoMndHypotheek() {
        return brutoMndHypotheek;
    }

    public void setBrutoMndHypotheek(BigDecimal brutoMndHypotheek) {
        this.brutoMndHypotheek = brutoMndHypotheek;
    }

    public String getLopendeLeningen() {
        return lopendeLeningen;
    }

    public void setLopendeLeningen(String lopendeLeningen) {
        this.lopendeLeningen = lopendeLeningen;
    }

    public String getWoonsituatie() {
        return woonsituatie;
    }

    public void setWoonsituatie(String woonsituatie) {
        this.woonsituatie = woonsituatie;
    }

    public BigDecimal getWoonlasten() {
        return woonlasten;
    }

    public void setWoonlasten(BigDecimal woonlasten) {
        this.woonlasten = woonlasten;
    }

    public Long getFdnAanvragerId() {
        return fdnAanvragerId;
    }

    public void setFdnAanvragerId(Long fdnAanvragerId) {
        this.fdnAanvragerId = fdnAanvragerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FinancieleSituatieDTO financieleSituatieDTO = (FinancieleSituatieDTO) o;
        if (financieleSituatieDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), financieleSituatieDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "FinancieleSituatieDTO{" +
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
            ", fdnAanvrager=" + getFdnAanvragerId() +
            "}";
    }
}
