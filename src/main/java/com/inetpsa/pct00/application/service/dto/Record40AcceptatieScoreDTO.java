package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Record40AcceptatieScore entity.
 */
public class Record40AcceptatieScoreDTO implements Serializable {

    private Long id;

    private String pcFinetNr;

    private Integer recordType;

    private Integer volgNr;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO = (Record40AcceptatieScoreDTO) o;
        if (record40AcceptatieScoreDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record40AcceptatieScoreDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record40AcceptatieScoreDTO{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            "}";
    }
}
