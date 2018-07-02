package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the TekstRegel entity.
 */
public class TekstRegelDTO implements Serializable {

    private Long id;

    private Long regelnummer;

    private String tekst;

    private Long vrijeTekstId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegelnummer() {
        return regelnummer;
    }

    public void setRegelnummer(Long regelnummer) {
        this.regelnummer = regelnummer;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getVrijeTekstId() {
        return vrijeTekstId;
    }

    public void setVrijeTekstId(Long vrijeTekstId) {
        this.vrijeTekstId = vrijeTekstId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TekstRegelDTO tekstRegelDTO = (TekstRegelDTO) o;
        if (tekstRegelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tekstRegelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TekstRegelDTO{" +
            "id=" + getId() +
            ", regelnummer=" + getRegelnummer() +
            ", tekst='" + getTekst() + "'" +
            ", vrijeTekst=" + getVrijeTekstId() +
            "}";
    }
}
