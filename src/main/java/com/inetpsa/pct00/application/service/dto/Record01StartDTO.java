package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Record01Start entity.
 */
public class Record01StartDTO implements Serializable {

    private Long id;

    private String pcFinetNr;

    private Integer recordType;

    private Integer volgNr;

    private LocalDate creatieDatum;

    private ZonedDateTime creatieTijd;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record01StartDTO record01StartDTO = (Record01StartDTO) o;
        if (record01StartDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record01StartDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record01StartDTO{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", creatieDatum='" + getCreatieDatum() + "'" +
            ", creatieTijd='" + getCreatieTijd() + "'" +
            "}";
    }
}
