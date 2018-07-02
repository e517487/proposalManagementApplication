package com.inetpsa.pct00.application.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the KredietAanvraag entity.
 */
public class KredietAanvraagDTO implements Serializable {

    private Long id;

    private Long volgnummer;

    private String duurInMnd;

    private String soortAanvraag;

    private String produktCodeNaam;

    private BigDecimal leningBedrag;

    private BigDecimal mndAflosBedrag;

    private BigDecimal gevrBedrInHanden;

    private String zekerheid;

    private String bestedingsdoel;

    private String merkObject;

    private String typeObject;

    private String bouwjaarObject;

    private String koopsomWaardeObj;

    private String kenteken;

    private String chassisnr;

    private BigDecimal inruilbedrag;

    private String doelNieuw;

    private BigDecimal aanbetalingbedrag;

    private String modelObject;

    private String sparen;

    private String typeTarief;

    private String tariefNaam;

    private String soortContract;

    private String kontraktNaam;

    private String produktNr;

    private String perspectief;

    private String nieuwGebruikt;

    private BigDecimal verkoopprijs;

    private BigDecimal aanbetaling;

    private String overnameLopendeLening;

    private BigDecimal kredietSom;

    private String gMI;

    private String overnameKentekennr;

    private String overnameFinanMy;

    private String ovvrnameContractNr;

    private String overnamePlaats;

    private String duurinMnd;

    private BigDecimal restantbetaling;

    private String effectiveRente;

    private String verkoper;

    private Long aanvraagberichtId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolgnummer() {
        return volgnummer;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getDuurInMnd() {
        return duurInMnd;
    }

    public void setDuurInMnd(String duurInMnd) {
        this.duurInMnd = duurInMnd;
    }

    public String getSoortAanvraag() {
        return soortAanvraag;
    }

    public void setSoortAanvraag(String soortAanvraag) {
        this.soortAanvraag = soortAanvraag;
    }

    public String getProduktCodeNaam() {
        return produktCodeNaam;
    }

    public void setProduktCodeNaam(String produktCodeNaam) {
        this.produktCodeNaam = produktCodeNaam;
    }

    public BigDecimal getLeningBedrag() {
        return leningBedrag;
    }

    public void setLeningBedrag(BigDecimal leningBedrag) {
        this.leningBedrag = leningBedrag;
    }

    public BigDecimal getMndAflosBedrag() {
        return mndAflosBedrag;
    }

    public void setMndAflosBedrag(BigDecimal mndAflosBedrag) {
        this.mndAflosBedrag = mndAflosBedrag;
    }

    public BigDecimal getGevrBedrInHanden() {
        return gevrBedrInHanden;
    }

    public void setGevrBedrInHanden(BigDecimal gevrBedrInHanden) {
        this.gevrBedrInHanden = gevrBedrInHanden;
    }

    public String getZekerheid() {
        return zekerheid;
    }

    public void setZekerheid(String zekerheid) {
        this.zekerheid = zekerheid;
    }

    public String getBestedingsdoel() {
        return bestedingsdoel;
    }

    public void setBestedingsdoel(String bestedingsdoel) {
        this.bestedingsdoel = bestedingsdoel;
    }

    public String getMerkObject() {
        return merkObject;
    }

    public void setMerkObject(String merkObject) {
        this.merkObject = merkObject;
    }

    public String getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(String typeObject) {
        this.typeObject = typeObject;
    }

    public String getBouwjaarObject() {
        return bouwjaarObject;
    }

    public void setBouwjaarObject(String bouwjaarObject) {
        this.bouwjaarObject = bouwjaarObject;
    }

    public String getKoopsomWaardeObj() {
        return koopsomWaardeObj;
    }

    public void setKoopsomWaardeObj(String koopsomWaardeObj) {
        this.koopsomWaardeObj = koopsomWaardeObj;
    }

    public String getKenteken() {
        return kenteken;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getChassisnr() {
        return chassisnr;
    }

    public void setChassisnr(String chassisnr) {
        this.chassisnr = chassisnr;
    }

    public BigDecimal getInruilbedrag() {
        return inruilbedrag;
    }

    public void setInruilbedrag(BigDecimal inruilbedrag) {
        this.inruilbedrag = inruilbedrag;
    }

    public String getDoelNieuw() {
        return doelNieuw;
    }

    public void setDoelNieuw(String doelNieuw) {
        this.doelNieuw = doelNieuw;
    }

    public BigDecimal getAanbetalingbedrag() {
        return aanbetalingbedrag;
    }

    public void setAanbetalingbedrag(BigDecimal aanbetalingbedrag) {
        this.aanbetalingbedrag = aanbetalingbedrag;
    }

    public String getModelObject() {
        return modelObject;
    }

    public void setModelObject(String modelObject) {
        this.modelObject = modelObject;
    }

    public String getSparen() {
        return sparen;
    }

    public void setSparen(String sparen) {
        this.sparen = sparen;
    }

    public String getTypeTarief() {
        return typeTarief;
    }

    public void setTypeTarief(String typeTarief) {
        this.typeTarief = typeTarief;
    }

    public String getTariefNaam() {
        return tariefNaam;
    }

    public void setTariefNaam(String tariefNaam) {
        this.tariefNaam = tariefNaam;
    }

    public String getSoortContract() {
        return soortContract;
    }

    public void setSoortContract(String soortContract) {
        this.soortContract = soortContract;
    }

    public String getKontraktNaam() {
        return kontraktNaam;
    }

    public void setKontraktNaam(String kontraktNaam) {
        this.kontraktNaam = kontraktNaam;
    }

    public String getProduktNr() {
        return produktNr;
    }

    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    public String getPerspectief() {
        return perspectief;
    }

    public void setPerspectief(String perspectief) {
        this.perspectief = perspectief;
    }

    public String getNieuwGebruikt() {
        return nieuwGebruikt;
    }

    public void setNieuwGebruikt(String nieuwGebruikt) {
        this.nieuwGebruikt = nieuwGebruikt;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }

    public void setVerkoopprijs(BigDecimal verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    public BigDecimal getAanbetaling() {
        return aanbetaling;
    }

    public void setAanbetaling(BigDecimal aanbetaling) {
        this.aanbetaling = aanbetaling;
    }

    public String getOvernameLopendeLening() {
        return overnameLopendeLening;
    }

    public void setOvernameLopendeLening(String overnameLopendeLening) {
        this.overnameLopendeLening = overnameLopendeLening;
    }

    public BigDecimal getKredietSom() {
        return kredietSom;
    }

    public void setKredietSom(BigDecimal kredietSom) {
        this.kredietSom = kredietSom;
    }

    public String getgMI() {
        return gMI;
    }

    public void setgMI(String gMI) {
        this.gMI = gMI;
    }

    public String getOvernameKentekennr() {
        return overnameKentekennr;
    }

    public void setOvernameKentekennr(String overnameKentekennr) {
        this.overnameKentekennr = overnameKentekennr;
    }

    public String getOvernameFinanMy() {
        return overnameFinanMy;
    }

    public void setOvernameFinanMy(String overnameFinanMy) {
        this.overnameFinanMy = overnameFinanMy;
    }

    public String getOvvrnameContractNr() {
        return ovvrnameContractNr;
    }

    public void setOvvrnameContractNr(String ovvrnameContractNr) {
        this.ovvrnameContractNr = ovvrnameContractNr;
    }

    public String getOvernamePlaats() {
        return overnamePlaats;
    }

    public void setOvernamePlaats(String overnamePlaats) {
        this.overnamePlaats = overnamePlaats;
    }

    public String getDuurinMnd() {
        return duurinMnd;
    }

    public void setDuurinMnd(String duurinMnd) {
        this.duurinMnd = duurinMnd;
    }

    public BigDecimal getRestantbetaling() {
        return restantbetaling;
    }

    public void setRestantbetaling(BigDecimal restantbetaling) {
        this.restantbetaling = restantbetaling;
    }

    public String getEffectiveRente() {
        return effectiveRente;
    }

    public void setEffectiveRente(String effectiveRente) {
        this.effectiveRente = effectiveRente;
    }

    public String getVerkoper() {
        return verkoper;
    }

    public void setVerkoper(String verkoper) {
        this.verkoper = verkoper;
    }

    public Long getAanvraagberichtId() {
        return aanvraagberichtId;
    }

    public void setAanvraagberichtId(Long aanvraagberichtId) {
        this.aanvraagberichtId = aanvraagberichtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KredietAanvraagDTO kredietAanvraagDTO = (KredietAanvraagDTO) o;
        if (kredietAanvraagDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), kredietAanvraagDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "KredietAanvraagDTO{" +
            "id=" + getId() +
            ", volgnummer=" + getVolgnummer() +
            ", duurInMnd='" + getDuurInMnd() + "'" +
            ", soortAanvraag='" + getSoortAanvraag() + "'" +
            ", produktCodeNaam='" + getProduktCodeNaam() + "'" +
            ", leningBedrag=" + getLeningBedrag() +
            ", mndAflosBedrag=" + getMndAflosBedrag() +
            ", gevrBedrInHanden=" + getGevrBedrInHanden() +
            ", zekerheid='" + getZekerheid() + "'" +
            ", bestedingsdoel='" + getBestedingsdoel() + "'" +
            ", merkObject='" + getMerkObject() + "'" +
            ", typeObject='" + getTypeObject() + "'" +
            ", bouwjaarObject='" + getBouwjaarObject() + "'" +
            ", koopsomWaardeObj='" + getKoopsomWaardeObj() + "'" +
            ", kenteken='" + getKenteken() + "'" +
            ", chassisnr='" + getChassisnr() + "'" +
            ", inruilbedrag=" + getInruilbedrag() +
            ", doelNieuw='" + getDoelNieuw() + "'" +
            ", aanbetalingbedrag=" + getAanbetalingbedrag() +
            ", modelObject='" + getModelObject() + "'" +
            ", sparen='" + getSparen() + "'" +
            ", typeTarief='" + getTypeTarief() + "'" +
            ", tariefNaam='" + getTariefNaam() + "'" +
            ", soortContract='" + getSoortContract() + "'" +
            ", kontraktNaam='" + getKontraktNaam() + "'" +
            ", produktNr='" + getProduktNr() + "'" +
            ", perspectief='" + getPerspectief() + "'" +
            ", nieuwGebruikt='" + getNieuwGebruikt() + "'" +
            ", verkoopprijs=" + getVerkoopprijs() +
            ", aanbetaling=" + getAanbetaling() +
            ", overnameLopendeLening='" + getOvernameLopendeLening() + "'" +
            ", kredietSom=" + getKredietSom() +
            ", gMI='" + getgMI() + "'" +
            ", overnameKentekennr='" + getOvernameKentekennr() + "'" +
            ", overnameFinanMy='" + getOvernameFinanMy() + "'" +
            ", ovvrnameContractNr='" + getOvvrnameContractNr() + "'" +
            ", overnamePlaats='" + getOvernamePlaats() + "'" +
            ", duurinMnd='" + getDuurinMnd() + "'" +
            ", restantbetaling=" + getRestantbetaling() +
            ", effectiveRente='" + getEffectiveRente() + "'" +
            ", verkoper='" + getVerkoper() + "'" +
            ", aanvraagbericht=" + getAanvraagberichtId() +
            "}";
    }
}
