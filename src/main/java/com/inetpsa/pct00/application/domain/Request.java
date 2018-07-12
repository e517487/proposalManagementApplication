package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Request to be scored
 * 
 * Contains all the information and assessment status of the request for financing done.
 */
@ApiModel(description = "Request to be scored Contains all the information and assessment status of the request for financing done.")
@Entity
@Table(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "[0-9]+")
    @Column(name = "pc_finet_nr", length = 11, nullable = false)
    private String pcFinetNr;

    @OneToOne(mappedBy = "request")
    @JsonIgnore
    private CreditScore creditScore;

    @OneToOne(mappedBy = "request")
    @JsonIgnore
    private RekenmoduleAanvraag rekenmoduleAanvraag;

    @ManyToOne
    @JsonIgnoreProperties("requests")
    private Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPcFinetNr() {
        return pcFinetNr;
    }

    public Request pcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
        return this;
    }

    public void setPcFinetNr(String pcFinetNr) {
        this.pcFinetNr = pcFinetNr;
    }

    public CreditScore getCreditScore() {
        return creditScore;
    }

    public Request creditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
        return this;
    }

    public void setCreditScore(CreditScore creditScore) {
        this.creditScore = creditScore;
    }

    public RekenmoduleAanvraag getRekenmoduleAanvraag() {
        return rekenmoduleAanvraag;
    }

    public Request rekenmoduleAanvraag(RekenmoduleAanvraag rekenmoduleAanvraag) {
        this.rekenmoduleAanvraag = rekenmoduleAanvraag;
        return this;
    }

    public void setRekenmoduleAanvraag(RekenmoduleAanvraag rekenmoduleAanvraag) {
        this.rekenmoduleAanvraag = rekenmoduleAanvraag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Request customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        Request request = (Request) o;
        if (request.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), request.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Request{" +
            "id=" + getId() +
            ", pcFinetNr='" + getPcFinetNr() + "'" +
            "}";
    }
}
