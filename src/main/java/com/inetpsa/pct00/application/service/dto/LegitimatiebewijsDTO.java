package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Legitimatiebewijs entity.
 */
public class LegitimatiebewijsDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String soort;

    private String land;

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

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
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

        LegitimatiebewijsDTO legitimatiebewijsDTO = (LegitimatiebewijsDTO) o;
        if (legitimatiebewijsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), legitimatiebewijsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LegitimatiebewijsDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", soort='" + getSoort() + "'" +
            ", land='" + getLand() + "'" +
            ", fdnAanvrager=" + getFdnAanvragerId() +
            "}";
    }
}
