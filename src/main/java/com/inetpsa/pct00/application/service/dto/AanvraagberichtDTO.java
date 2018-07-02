package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Aanvraagbericht entity.
 */
public class AanvraagberichtDTO implements Serializable {

    private Long id;

    private Long rekenmoduleAanvraagId;

    private Long headerId;

    private Long algemeenId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRekenmoduleAanvraagId() {
        return rekenmoduleAanvraagId;
    }

    public void setRekenmoduleAanvraagId(Long rekenmoduleAanvraagId) {
        this.rekenmoduleAanvraagId = rekenmoduleAanvraagId;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public Long getAlgemeenId() {
        return algemeenId;
    }

    public void setAlgemeenId(Long algemeenId) {
        this.algemeenId = algemeenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AanvraagberichtDTO aanvraagberichtDTO = (AanvraagberichtDTO) o;
        if (aanvraagberichtDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aanvraagberichtDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AanvraagberichtDTO{" +
            "id=" + getId() +
            ", rekenmoduleAanvraag=" + getRekenmoduleAanvraagId() +
            ", header=" + getHeaderId() +
            ", algemeen=" + getAlgemeenId() +
            "}";
    }
}
