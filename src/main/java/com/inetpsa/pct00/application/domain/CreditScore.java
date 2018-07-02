package com.inetpsa.pct00.application.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Credit scoring
 * 
 * Status of the credit scoring of a finance request for the customer.
 * Relations to information for the assessment to be done and results of these assessments
 * Final judgement of the request done for the customer.
 * Every credit score is uniquely bounded to a request.
 */
@ApiModel(description = "Credit scoring Status of the credit scoring of a finance request for the customer. Relations to information for the assessment to be done and results of these assessments Final judgement of the request done for the customer. Every credit score is uniquely bounded to a request.")
@Entity
@Table(name = "credit_score")
public class CreditScore implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private Request request;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public CreditScore request(Request request) {
        this.request = request;
        return this;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreditScore creditScore = (CreditScore) o;
        if (creditScore.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), creditScore.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CreditScore{" +
            "id=" + getId() +
            "}";
    }
}
