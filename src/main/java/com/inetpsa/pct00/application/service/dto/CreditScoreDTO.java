package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CreditScore entity.
 */
public class CreditScoreDTO implements Serializable {

    private Long id;

    private Long requestId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        CreditScoreDTO creditScoreDTO = (CreditScoreDTO) o;
        if (creditScoreDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), creditScoreDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CreditScoreDTO{" +
            "id=" + getId() +
            ", request=" + getRequestId() +
            "}";
    }
}
