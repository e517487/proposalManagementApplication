package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the NawWerkgeverUWV entity.
 */
public class NawWerkgeverUWVDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String naam;

    private String plaatsNaam;

    private Long werksituatieId;

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

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPlaatsNaam() {
        return plaatsNaam;
    }

    public void setPlaatsNaam(String plaatsNaam) {
        this.plaatsNaam = plaatsNaam;
    }

    public Long getWerksituatieId() {
        return werksituatieId;
    }

    public void setWerksituatieId(Long werksituatieId) {
        this.werksituatieId = werksituatieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NawWerkgeverUWVDTO nawWerkgeverUWVDTO = (NawWerkgeverUWVDTO) o;
        if (nawWerkgeverUWVDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), nawWerkgeverUWVDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NawWerkgeverUWVDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", naam='" + getNaam() + "'" +
            ", plaatsNaam='" + getPlaatsNaam() + "'" +
            ", werksituatie=" + getWerksituatieId() +
            "}";
    }
}
