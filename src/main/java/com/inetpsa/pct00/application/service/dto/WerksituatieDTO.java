package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Werksituatie entity.
 */
public class WerksituatieDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String beroep;

    private String aardDienstverband;

    private LocalDate beginDienstverbandDt;

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

    public String getBeroep() {
        return beroep;
    }

    public void setBeroep(String beroep) {
        this.beroep = beroep;
    }

    public String getAardDienstverband() {
        return aardDienstverband;
    }

    public void setAardDienstverband(String aardDienstverband) {
        this.aardDienstverband = aardDienstverband;
    }

    public LocalDate getBeginDienstverbandDt() {
        return beginDienstverbandDt;
    }

    public void setBeginDienstverbandDt(LocalDate beginDienstverbandDt) {
        this.beginDienstverbandDt = beginDienstverbandDt;
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

        WerksituatieDTO werksituatieDTO = (WerksituatieDTO) o;
        if (werksituatieDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), werksituatieDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WerksituatieDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", beroep='" + getBeroep() + "'" +
            ", aardDienstverband='" + getAardDienstverband() + "'" +
            ", beginDienstverbandDt='" + getBeginDienstverbandDt() + "'" +
            ", fdnAanvrager=" + getFdnAanvragerId() +
            "}";
    }
}
