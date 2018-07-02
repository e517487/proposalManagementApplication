package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Request from Rekenmodule.
 * Input xml file containing request(s) for financing a car.
 */
@ApiModel(description = "Request from Rekenmodule. Input xml file containing request(s) for financing a car.")
@Entity
@Table(name = "rekenmodule_aanvraag")
public class RekenmoduleAanvraag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "rekenmodule_aanvraag_file_name")
    private String rekenmoduleAanvraagFileName;

    @OneToOne
    @JoinColumn(unique = true)
    private Request request;

    @OneToOne(mappedBy = "rekenmoduleAanvraag")
    @JsonIgnore
    private Aanvraagbericht aanvraagbericht;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRekenmoduleAanvraagFileName() {
        return rekenmoduleAanvraagFileName;
    }

    public RekenmoduleAanvraag rekenmoduleAanvraagFileName(String rekenmoduleAanvraagFileName) {
        this.rekenmoduleAanvraagFileName = rekenmoduleAanvraagFileName;
        return this;
    }

    public void setRekenmoduleAanvraagFileName(String rekenmoduleAanvraagFileName) {
        this.rekenmoduleAanvraagFileName = rekenmoduleAanvraagFileName;
    }

    public Request getRequest() {
        return request;
    }

    public RekenmoduleAanvraag request(Request request) {
        this.request = request;
        return this;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public RekenmoduleAanvraag aanvraagbericht(Aanvraagbericht aanvraagbericht) {
        this.aanvraagbericht = aanvraagbericht;
        return this;
    }

    public void setAanvraagbericht(Aanvraagbericht aanvraagbericht) {
        this.aanvraagbericht = aanvraagbericht;
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
        RekenmoduleAanvraag rekenmoduleAanvraag = (RekenmoduleAanvraag) o;
        if (rekenmoduleAanvraag.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rekenmoduleAanvraag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RekenmoduleAanvraag{" +
            "id=" + getId() +
            ", rekenmoduleAanvraagFileName='" + getRekenmoduleAanvraagFileName() + "'" +
            "}";
    }
}
