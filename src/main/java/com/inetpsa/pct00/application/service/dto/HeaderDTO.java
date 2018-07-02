package com.inetpsa.pct00.application.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Header entity.
 */
public class HeaderDTO implements Serializable {

    private Long id;

    private String emailZender;

    private String emailOntvanger;

    private String ontvangerNaam;

    private String lognaam;

    private String messageRef;

    private Integer berichtVersie;

    private LocalDate verzendDt;

    private LocalDate verzendTijd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailZender() {
        return emailZender;
    }

    public void setEmailZender(String emailZender) {
        this.emailZender = emailZender;
    }

    public String getEmailOntvanger() {
        return emailOntvanger;
    }

    public void setEmailOntvanger(String emailOntvanger) {
        this.emailOntvanger = emailOntvanger;
    }

    public String getOntvangerNaam() {
        return ontvangerNaam;
    }

    public void setOntvangerNaam(String ontvangerNaam) {
        this.ontvangerNaam = ontvangerNaam;
    }

    public String getLognaam() {
        return lognaam;
    }

    public void setLognaam(String lognaam) {
        this.lognaam = lognaam;
    }

    public String getMessageRef() {
        return messageRef;
    }

    public void setMessageRef(String messageRef) {
        this.messageRef = messageRef;
    }

    public Integer getBerichtVersie() {
        return berichtVersie;
    }

    public void setBerichtVersie(Integer berichtVersie) {
        this.berichtVersie = berichtVersie;
    }

    public LocalDate getVerzendDt() {
        return verzendDt;
    }

    public void setVerzendDt(LocalDate verzendDt) {
        this.verzendDt = verzendDt;
    }

    public LocalDate getVerzendTijd() {
        return verzendTijd;
    }

    public void setVerzendTijd(LocalDate verzendTijd) {
        this.verzendTijd = verzendTijd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HeaderDTO headerDTO = (HeaderDTO) o;
        if (headerDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), headerDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HeaderDTO{" +
            "id=" + getId() +
            ", emailZender='" + getEmailZender() + "'" +
            ", emailOntvanger='" + getEmailOntvanger() + "'" +
            ", ontvangerNaam='" + getOntvangerNaam() + "'" +
            ", lognaam='" + getLognaam() + "'" +
            ", messageRef='" + getMessageRef() + "'" +
            ", berichtVersie=" + getBerichtVersie() +
            ", verzendDt='" + getVerzendDt() + "'" +
            ", verzendTijd='" + getVerzendTijd() + "'" +
            "}";
    }
}
