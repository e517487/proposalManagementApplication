package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the VrijeTekst entity.
 */
public class VrijeTekstDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private Long aanvraagberichtId;

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

    public Long getAanvraagberichtId() {
        return aanvraagberichtId;
    }

    public void setAanvraagberichtId(Long aanvraagberichtId) {
        this.aanvraagberichtId = aanvraagberichtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VrijeTekstDTO vrijeTekstDTO = (VrijeTekstDTO) o;
        if (vrijeTekstDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vrijeTekstDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VrijeTekstDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", aanvraagbericht=" + getAanvraagberichtId() +
            "}";
    }
}
