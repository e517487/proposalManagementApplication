package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * Main entry of rekenmodule aanvraag xml file with the request.
 */
@ApiModel(description = "Main entry of rekenmodule aanvraag xml file with the request.")
@Entity
@Table(name = "aanvraagbericht")
public class Aanvraagbericht implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private RekenmoduleAanvraag rekenmoduleAanvraag;

    @OneToOne
    @JoinColumn(unique = true)
    private Header header;

    @OneToOne
    @JoinColumn(unique = true)
    private Algemeen algemeen;

    @OneToMany(mappedBy = "aanvraagbericht")
    private Set<FdnAanvrager> fdnAanvragers = new HashSet<>();

    @OneToMany(mappedBy = "aanvraagbericht")
    private Set<KredietAanvraag> kredietAanvraags = new HashSet<>();

    @OneToMany(mappedBy = "aanvraagbericht")
    private Set<VrijeTekst> vrijeTeksts = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RekenmoduleAanvraag getRekenmoduleAanvraag() {
        return rekenmoduleAanvraag;
    }

    public Aanvraagbericht rekenmoduleAanvraag(RekenmoduleAanvraag rekenmoduleAanvraag) {
        this.rekenmoduleAanvraag = rekenmoduleAanvraag;
        return this;
    }

    public void setRekenmoduleAanvraag(RekenmoduleAanvraag rekenmoduleAanvraag) {
        this.rekenmoduleAanvraag = rekenmoduleAanvraag;
    }

    public Header getHeader() {
        return header;
    }

    public Aanvraagbericht header(Header header) {
        this.header = header;
        return this;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Algemeen getAlgemeen() {
        return algemeen;
    }

    public Aanvraagbericht algemeen(Algemeen algemeen) {
        this.algemeen = algemeen;
        return this;
    }

    public void setAlgemeen(Algemeen algemeen) {
        this.algemeen = algemeen;
    }

    public Set<FdnAanvrager> getFdnAanvragers() {
        return fdnAanvragers;
    }

    public Aanvraagbericht fdnAanvragers(Set<FdnAanvrager> fdnAanvragers) {
        this.fdnAanvragers = fdnAanvragers;
        return this;
    }

    public Aanvraagbericht addFdnAanvrager(FdnAanvrager fdnAanvrager) {
        this.fdnAanvragers.add(fdnAanvrager);
        fdnAanvrager.setAanvraagbericht(this);
        return this;
    }

    public Aanvraagbericht removeFdnAanvrager(FdnAanvrager fdnAanvrager) {
        this.fdnAanvragers.remove(fdnAanvrager);
        fdnAanvrager.setAanvraagbericht(null);
        return this;
    }

    public void setFdnAanvragers(Set<FdnAanvrager> fdnAanvragers) {
        this.fdnAanvragers = fdnAanvragers;
    }

    public Set<KredietAanvraag> getKredietAanvraags() {
        return kredietAanvraags;
    }

    public Aanvraagbericht kredietAanvraags(Set<KredietAanvraag> kredietAanvraags) {
        this.kredietAanvraags = kredietAanvraags;
        return this;
    }

    public Aanvraagbericht addKredietAanvraag(KredietAanvraag kredietAanvraag) {
        this.kredietAanvraags.add(kredietAanvraag);
        kredietAanvraag.setAanvraagbericht(this);
        return this;
    }

    public Aanvraagbericht removeKredietAanvraag(KredietAanvraag kredietAanvraag) {
        this.kredietAanvraags.remove(kredietAanvraag);
        kredietAanvraag.setAanvraagbericht(null);
        return this;
    }

    public void setKredietAanvraags(Set<KredietAanvraag> kredietAanvraags) {
        this.kredietAanvraags = kredietAanvraags;
    }

    public Set<VrijeTekst> getVrijeTeksts() {
        return vrijeTeksts;
    }

    public Aanvraagbericht vrijeTeksts(Set<VrijeTekst> vrijeTeksts) {
        this.vrijeTeksts = vrijeTeksts;
        return this;
    }

    public Aanvraagbericht addVrijeTekst(VrijeTekst vrijeTekst) {
        this.vrijeTeksts.add(vrijeTekst);
        vrijeTekst.setAanvraagbericht(this);
        return this;
    }

    public Aanvraagbericht removeVrijeTekst(VrijeTekst vrijeTekst) {
        this.vrijeTeksts.remove(vrijeTekst);
        vrijeTekst.setAanvraagbericht(null);
        return this;
    }

    public void setVrijeTeksts(Set<VrijeTekst> vrijeTeksts) {
        this.vrijeTeksts = vrijeTeksts;
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
        Aanvraagbericht aanvraagbericht = (Aanvraagbericht) o;
        if (aanvraagbericht.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), aanvraagbericht.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Aanvraagbericht{" +
            "id=" + getId() +
            "}";
    }
}
