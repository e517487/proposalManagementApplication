package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Record62Uitleg entity.
 */
public class Record62UitlegDTO implements Serializable {

    private Long id;

    private String pcFinetNr;

    private Integer recordType;

    private Integer volgNr;

    private String rol;

    private String uitlegGezin;

    private String uitlegInkomsten;

    private String uitlegInPlatform;

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUitlegGezin() {
        return uitlegGezin;
    }

    public void setUitlegGezin(String uitlegGezin) {
        this.uitlegGezin = uitlegGezin;
    }

    public String getUitlegInkomsten() {
        return uitlegInkomsten;
    }

    public void setUitlegInkomsten(String uitlegInkomsten) {
        this.uitlegInkomsten = uitlegInkomsten;
    }

    public String getUitlegInPlatform() {
        return uitlegInPlatform;
    }

    public void setUitlegInPlatform(String uitlegInPlatform) {
        this.uitlegInPlatform = uitlegInPlatform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record62UitlegDTO record62UitlegDTO = (Record62UitlegDTO) o;
        if (record62UitlegDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), record62UitlegDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Record62UitlegDTO{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            ", recordType=" + getRecordType() +
            ", volgNr=" + getVolgNr() +
            ", rol='" + getRol() + "'" +
            ", uitlegGezin='" + getUitlegGezin() + "'" +
            ", uitlegInkomsten='" + getUitlegInkomsten() + "'" +
            ", uitlegInPlatform='" + getUitlegInPlatform() + "'" +
            "}";
    }
}
