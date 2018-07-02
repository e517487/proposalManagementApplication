package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Customer
 * 
 * Customer of the financing request.
 * The customer has to be checked if it is already known (existing customer, or multiple requests from multiple dealers)
 * If Customer already known this can speedup credit scoring process if this previous scoring is available an still valid.
 * i.e. one credit scoring for multiple requests done by this customer.
 * 
 * Main issues for this entity
 * - customer known in Miles?
 * - processing multiple requests in short time window (multiple request for one financing issue)
 */
@ApiModel(description = "Customer Customer of the financing request. The customer has to be checked if it is already known (existing customer, or multiple requests from multiple dealers) If Customer already known this can speedup credit scoring process if this previous scoring is available an still valid. i.e. one credit scoring for multiple requests done by this customer. Main issues for this entity - customer known in Miles? - processing multiple requests in short time window (multiple request for one financing issue)")
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToMany(mappedBy = "customer")
    private Set<Request> requests = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public Customer requests(Set<Request> requests) {
        this.requests = requests;
        return this;
    }

    public Customer addRequest(Request request) {
        this.requests.add(request);
        request.setCustomer(this);
        return this;
    }

    public Customer removeRequest(Request request) {
        this.requests.remove(request);
        request.setCustomer(null);
        return this;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
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
        Customer customer = (Customer) o;
        if (customer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            "}";
    }
}
