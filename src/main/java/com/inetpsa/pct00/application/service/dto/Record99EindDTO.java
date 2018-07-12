package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Record99Eind entity.
 */
public class Record99EindDTO implements Serializable {

    private Long id;

    private String pcFinetNr;

    private Integer recordType;

    private Integer volgNr;

    private LocalDate creatieDatum;

    private ZonedDateTime creatieTijd;

    private Integer aantalAanvragen;

    private Integer aantalRegels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcFinetNr() {
        return pcFinetNr;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getVolgNr() {
        return volgNr;
    }

    public void setVolgNr(Integer volgNr) {
        this.volgNr = volgNr;
    }

    public LocalDate getCreatieDatum() {
        return creatieDatum;
    }

    public void setCreatieDatum(LocalDate creatieDatum) {
        this.creatieDatum = creatieDatum;
    }

    public ZonedDateTime getCreatieTijd() {
        return creatieTijd;
    }

    public void setCreatieTijd(ZonedDateTime creatieTijd) {
        this.creatieTijd = creatieTijd;
    }

    public Integer getAantalAanvragen() {
        return aantalAanvragen;
    }

    public void setAantalAanvragen(Integer aantalAanvragen) {
        this.aantalAanvragen = aantalAanvragen;
    }

    public Integer getAantalRegels() {
        return aantalRegels;
    }

    public void setAantalRegels(Integer aantalRegels) {
        this.aantalRegels = aantalRegels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record99EindDTO record99EindDTO = (Record99EindDTO) o;
        if (record99EindDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record99EindDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record99EindDTO{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", creatieDatum='" + getCreatieDatum() + "'" +
            ", creatieTijd='" + getCreatieTijd() + "'" +
            ", aantalAanvragen=" + getAantalAanvragen() +
            ", aantalRegels=" + getAantalRegels() +
            "}";
    }
}
