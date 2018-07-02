package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Gezinssituatie entity.
 */
public class GezinssituatieDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String burgerlijkeStaat;

    private String huwelijkseVw;

    private String huwelijkOntbonden;

    private String weduweWeduwnaar;

    private Integer kinderenAantal;

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

    public String getBurgerlijkeStaat() {
        return burgerlijkeStaat;
    }

    public void setBurgerlijkeStaat(String burgerlijkeStaat) {
        this.burgerlijkeStaat = burgerlijkeStaat;
    }

    public String getHuwelijkseVw() {
        return huwelijkseVw;
    }

    public void setHuwelijkseVw(String huwelijkseVw) {
        this.huwelijkseVw = huwelijkseVw;
    }

    public String getHuwelijkOntbonden() {
        return huwelijkOntbonden;
    }

    public void setHuwelijkOntbonden(String huwelijkOntbonden) {
        this.huwelijkOntbonden = huwelijkOntbonden;
    }

    public String getWeduweWeduwnaar() {
        return weduweWeduwnaar;
    }

    public void setWeduweWeduwnaar(String weduweWeduwnaar) {
        this.weduweWeduwnaar = weduweWeduwnaar;
    }

    public Integer getKinderenAantal() {
        return kinderenAantal;
    }

    public void setKinderenAantal(Integer kinderenAantal) {
        this.kinderenAantal = kinderenAantal;
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

        GezinssituatieDTO gezinssituatieDTO = (GezinssituatieDTO) o;
        if (gezinssituatieDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gezinssituatieDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GezinssituatieDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", burgerlijkeStaat='" + getBurgerlijkeStaat() + "'" +
            ", huwelijkseVw='" + getHuwelijkseVw() + "'" +
            ", huwelijkOntbonden='" + getHuwelijkOntbonden() + "'" +
            ", weduweWeduwnaar='" + getWeduweWeduwnaar() + "'" +
            ", kinderenAantal=" + getKinderenAantal() +
            ", fdnAanvrager=" + getFdnAanvragerId() +
            "}";
    }
}
