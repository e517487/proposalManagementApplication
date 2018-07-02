package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the RekenmoduleAanvraag entity.
 */
public class RekenmoduleAanvraagDTO implements Serializable {

    private Long id;

    private String rekenmoduleAanvraagFileName;

    private Long requestId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRekenmoduleAanvraagFileName() {
        return rekenmoduleAanvraagFileName;
    }

    public void setRekenmoduleAanvraagFileName(String rekenmoduleAanvraagFileName) {
        this.rekenmoduleAanvraagFileName = rekenmoduleAanvraagFileName;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO = (RekenmoduleAanvraagDTO) o;
        if (rekenmoduleAanvraagDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rekenmoduleAanvraagDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RekenmoduleAanvraagDTO{" +
            "id=" + getId() +
            ", rekenmoduleAanvraagFileName='" + getRekenmoduleAanvraagFileName() + "'" +
            ", request=" + getRequestId() +
            "}";
    }
}
