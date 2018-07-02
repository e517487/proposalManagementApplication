package com.inetpsa.pct00.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 0..n of KredietAanvraag allowed per <Aanvraagbericht>
 */
@ApiModel(description = "0..n of KredietAanvraag allowed per <Aanvraagbericht>")
@Entity
@Table(name = "krediet_aanvraag")
public class KredietAanvraag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "volgnummer")
    private Long volgnummer;

    @Column(name = "duur_in_mnd")
    private String duurInMnd;

    @Column(name = "soort_aanvraag")
    private String soortAanvraag;

    @Column(name = "produkt_code_naam")
    private String produktCodeNaam;

    @Column(name = "lening_bedrag", precision = 10, scale = 2)
    private BigDecimal leningBedrag;

    @Column(name = "mnd_aflos_bedrag", precision = 10, scale = 2)
    private BigDecimal mndAflosBedrag;

    @Column(name = "gevr_bedr_in_handen", precision = 10, scale = 2)
    private BigDecimal gevrBedrInHanden;

    @Column(name = "zekerheid")
    private String zekerheid;

    @Column(name = "bestedingsdoel")
    private String bestedingsdoel;

    @Column(name = "merk_object")
    private String merkObject;

    @Column(name = "type_object")
    private String typeObject;

    @Column(name = "bouwjaar_object")
    private String bouwjaarObject;

    @Column(name = "koopsom_waarde_obj")
    private String koopsomWaardeObj;

    @Column(name = "kenteken")
    private String kenteken;

    @Column(name = "chassisnr")
    private String chassisnr;

    @Column(name = "inruilbedrag", precision = 10, scale = 2)
    private BigDecimal inruilbedrag;

    @Column(name = "doel_nieuw")
    private String doelNieuw;

    @Column(name = "aanbetalingbedrag", precision = 10, scale = 2)
    private BigDecimal aanbetalingbedrag;

    @Column(name = "model_object")
    private String modelObject;

    @Column(name = "sparen")
    private String sparen;

    @Column(name = "type_tarief")
    private String typeTarief;

    @Column(name = "tarief_naam")
    private String tariefNaam;

    @Column(name = "soort_contract")
    private String soortContract;

    @Column(name = "kontrakt_naam")
    private String kontraktNaam;

    @Column(name = "produkt_nr")
    private String produktNr;

    @Column(name = "perspectief")
    private String perspectief;

    @Column(name = "nieuw_gebruikt")
    private String nieuwGebruikt;

    @Column(name = "verkoopprijs", precision = 10, scale = 2)
    private BigDecimal verkoopprijs;

    @Column(name = "aanbetaling", precision = 10, scale = 2)
    private BigDecimal aanbetaling;

    @Column(name = "overname_lopende_lening")
    private String overnameLopendeLening;

    @Column(name = "krediet_som", precision = 10, scale = 2)
    private BigDecimal kredietSom;

    @Column(name = "g_mi")
    private String gMI;

    @Column(name = "overname_kentekennr")
    private String overnameKentekennr;

    @Column(name = "overname_finan_my")
    private String overnameFinanMy;

    @Column(name = "ovvrname_contract_nr")
    private String ovvrnameContractNr;

    @Column(name = "overname_plaats")
    private String overnamePlaats;

    @Column(name = "duurin_mnd")
    private String duurinMnd;

    @Column(name = "restantbetaling", precision = 10, scale = 2)
    private BigDecimal restantbetaling;

    @Column(name = "effective_rente")
    private String effectiveRente;

    @Column(name = "verkoper")
    private String verkoper;

    @ManyToOne
    @JsonIgnoreProperties("kredietAanvraags")
    private Aanvraagbericht aanvraagbericht;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVolgnummer() {
        return volgnummer;
    }

    public KredietAanvraag volgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
        return this;
    }

    public void setVolgnummer(Long volgnummer) {
        this.volgnummer = volgnummer;
    }

    public String getDuurInMnd() {
        return duurInMnd;
    }

    public KredietAanvraag duurInMnd(String duurInMnd) {
        this.duurInMnd = duurInMnd;
        return this;
    }

    public void setDuurInMnd(String duurInMnd) {
        this.duurInMnd = duurInMnd;
    }

    public String getSoortAanvraag() {
        return soortAanvraag;
    }

    public KredietAanvraag soortAanvraag(String soortAanvraag) {
        this.soortAanvraag = soortAanvraag;
        return this;
    }

    public void setSoortAanvraag(String soortAanvraag) {
        this.soortAanvraag = soortAanvraag;
    }

    public String getProduktCodeNaam() {
        return produktCodeNaam;
    }

    public KredietAanvraag produktCodeNaam(String produktCodeNaam) {
        this.produktCodeNaam = produktCodeNaam;
        return this;
    }

    public void setProduktCodeNaam(String produktCodeNaam) {
        this.produktCodeNaam = produktCodeNaam;
    }

    public BigDecimal getLeningBedrag() {
        return leningBedrag;
    }

    public KredietAanvraag leningBedrag(BigDecimal leningBedrag) {
        this.leningBedrag = leningBedrag;
        return this;
    }

    public void setLeningBedrag(BigDecimal leningBedrag) {
        this.leningBedrag = leningBedrag;
    }

    public BigDecimal getMndAflosBedrag() {
        return mndAflosBedrag;
    }

    public KredietAanvraag mndAflosBedrag(BigDecimal mndAflosBedrag) {
        this.mndAflosBedrag = mndAflosBedrag;
        return this;
    }

    public void setMndAflosBedrag(BigDecimal mndAflosBedrag) {
        this.mndAflosBedrag = mndAflosBedrag;
    }

    public BigDecimal getGevrBedrInHanden() {
        return gevrBedrInHanden;
    }

    public KredietAanvraag gevrBedrInHanden(BigDecimal gevrBedrInHanden) {
        this.gevrBedrInHanden = gevrBedrInHanden;
        return this;
    }

    public void setGevrBedrInHanden(BigDecimal gevrBedrInHanden) {
        this.gevrBedrInHanden = gevrBedrInHanden;
    }

    public String getZekerheid() {
        return zekerheid;
    }

    public KredietAanvraag zekerheid(String zekerheid) {
        this.zekerheid = zekerheid;
        return this;
    }

    public void setZekerheid(String zekerheid) {
        this.zekerheid = zekerheid;
    }

    public String getBestedingsdoel() {
        return bestedingsdoel;
    }

    public KredietAanvraag bestedingsdoel(String bestedingsdoel) {
        this.bestedingsdoel = bestedingsdoel;
        return this;
    }

    public void setBestedingsdoel(String bestedingsdoel) {
        this.bestedingsdoel = bestedingsdoel;
    }

    public String getMerkObject() {
        return merkObject;
    }

    public KredietAanvraag merkObject(String merkObject) {
        this.merkObject = merkObject;
        return this;
    }

    public void setMerkObject(String merkObject) {
        this.merkObject = merkObject;
    }

    public String getTypeObject() {
        return typeObject;
    }

    public KredietAanvraag typeObject(String typeObject) {
        this.typeObject = typeObject;
        return this;
    }

    public void setTypeObject(String typeObject) {
        this.typeObject = typeObject;
    }

    public String getBouwjaarObject() {
        return bouwjaarObject;
    }

    public KredietAanvraag bouwjaarObject(String bouwjaarObject) {
        this.bouwjaarObject = bouwjaarObject;
        return this;
    }

    public void setBouwjaarObject(String bouwjaarObject) {
        this.bouwjaarObject = bouwjaarObject;
    }

    public String getKoopsomWaardeObj() {
        return koopsomWaardeObj;
    }

    public KredietAanvraag koopsomWaardeObj(String koopsomWaardeObj) {
        this.koopsomWaardeObj = koopsomWaardeObj;
        return this;
    }

    public void setKoopsomWaardeObj(String koopsomWaardeObj) {
        this.koopsomWaardeObj = koopsomWaardeObj;
    }

    public String getKenteken() {
        return kenteken;
    }

    public KredietAanvraag kenteken(String kenteken) {
        this.kenteken = kenteken;
        return this;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }

    public String getChassisnr() {
        return chassisnr;
    }

    public KredietAanvraag chassisnr(String chassisnr) {
        this.chassisnr = chassisnr;
        return this;
    }

    public void setChassisnr(String chassisnr) {
        this.chassisnr = chassisnr;
    }

    public BigDecimal getInruilbedrag() {
        return inruilbedrag;
    }

    public KredietAanvraag inruilbedrag(BigDecimal inruilbedrag) {
        this.inruilbedrag = inruilbedrag;
        return this;
    }

    public void setInruilbedrag(BigDecimal inruilbedrag) {
        this.inruilbedrag = inruilbedrag;
    }

    public String getDoelNieuw() {
        return doelNieuw;
    }

    public KredietAanvraag doelNieuw(String doelNieuw) {
        this.doelNieuw = doelNieuw;
        return this;
    }

    public void setDoelNieuw(String doelNieuw) {
        this.doelNieuw = doelNieuw;
    }

    public BigDecimal getAanbetalingbedrag() {
        return aanbetalingbedrag;
    }

    public KredietAanvraag aanbetalingbedrag(BigDecimal aanbetalingbedrag) {
        this.aanbetalingbedrag = aanbetalingbedrag;
        return this;
    }

    public void setAanbetalingbedrag(BigDecimal aanbetalingbedrag) {
        this.aanbetalingbedrag = aanbetalingbedrag;
    }

    public String getModelObject() {
        return modelObject;
    }

    public KredietAanvraag modelObject(String modelObject) {
        this.modelObject = modelObject;
        return this;
    }

    public void setModelObject(String modelObject) {
        this.modelObject = modelObject;
    }

    public String getSparen() {
        return sparen;
    }

    public KredietAanvraag sparen(String sparen) {
        this.sparen = sparen;
        return this;
    }

    public void setSparen(String sparen) {
        this.sparen = sparen;
    }

    public String getTypeTarief() {
        return typeTarief;
    }

    public KredietAanvraag typeTarief(String typeTarief) {
        this.typeTarief = typeTarief;
        return this;
    }

    public void setTypeTarief(String typeTarief) {
        this.typeTarief = typeTarief;
    }

    public String getTariefNaam() {
        return tariefNaam;
    }

    public KredietAanvraag tariefNaam(String tariefNaam) {
        this.tariefNaam = tariefNaam;
        return this;
    }

    public void setTariefNaam(String tariefNaam) {
        this.tariefNaam = tariefNaam;
    }

    public String getSoortContract() {
        return soortContract;
    }

    public KredietAanvraag soortContract(String soortContract) {
        this.soortContract = soortContract;
        return this;
    }

    public void setSoortContract(String soortContract) {
        this.soortContract = soortContract;
    }

    public String getKontraktNaam() {
        return kontraktNaam;
    }

    public KredietAanvraag kontraktNaam(String kontraktNaam) {
        this.kontraktNaam = kontraktNaam;
        return this;
    }

    public void setKontraktNaam(String kontraktNaam) {
        this.kontraktNaam = kontraktNaam;
    }

    public String getProduktNr() {
        return produktNr;
    }

    public KredietAanvraag produktNr(String produktNr) {
        this.produktNr = produktNr;
        return this;
    }

    public void setProduktNr(String produktNr) {
        this.produktNr = produktNr;
    }

    public String getPerspectief() {
        return perspectief;
    }

    public KredietAanvraag perspectief(String perspectief) {
        this.perspectief = perspectief;
        return this;
    }

    public void setPerspectief(String perspectief) {
        this.perspectief = perspectief;
    }

    public String getNieuwGebruikt() {
        return nieuwGebruikt;
    }

    public KredietAanvraag nieuwGebruikt(String nieuwGebruikt) {
        this.nieuwGebruikt = nieuwGebruikt;
        return this;
    }

    public void setNieuwGebruikt(String nieuwGebruikt) {
        this.nieuwGebruikt = nieuwGebruikt;
    }

    public BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }

    public KredietAanvraag verkoopprijs(BigDecimal verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
        return this;
    }

    public void setVerkoopprijs(BigDecimal verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    public BigDecimal getAanbetaling() {
        return aanbetaling;
    }

    public KredietAanvraag aanbetaling(BigDecimal aanbetaling) {
        this.aanbetaling = aanbetaling;
        return this;
    }

    public void setAanbetaling(BigDecimal aanbetaling) {
        this.aanbetaling = aanbetaling;
    }

    public String getOvernameLopendeLening() {
        return overnameLopendeLening;
    }

    public KredietAanvraag overnameLopendeLening(String overnameLopendeLening) {
        this.overnameLopendeLening = overnameLopendeLening;
        return this;
    }

    public void setOvernameLopendeLening(String overnameLopendeLening) {
        this.overnameLopendeLening = overnameLopendeLening;
    }

    public BigDecimal getKredietSom() {
        return kredietSom;
    }

    public KredietAanvraag kredietSom(BigDecimal kredietSom) {
        this.kredietSom = kredietSom;
        return this;
    }

    public void setKredietSom(BigDecimal kredietSom) {
        this.kredietSom = kredietSom;
    }

    public String getgMI() {
        return gMI;
    }

    public KredietAanvraag gMI(String gMI) {
        this.gMI = gMI;
        return this;
    }

    public void setgMI(String gMI) {
        this.gMI = gMI;
    }

    public String getOvernameKentekennr() {
        return overnameKentekennr;
    }

    public KredietAanvraag overnameKentekennr(String overnameKentekennr) {
        this.overnameKentekennr = overnameKentekennr;
        return this;
    }

    public void setOvernameKentekennr(String overnameKentekennr) {
        this.overnameKentekennr = overnameKentekennr;
    }

    public String getOvernameFinanMy() {
        return overnameFinanMy;
    }

    public KredietAanvraag overnameFinanMy(String overnameFinanMy) {
        this.overnameFinanMy = overnameFinanMy;
        return this;
    }

    public void setOvernameFinanMy(String overnameFinanMy) {
        this.overnameFinanMy = overnameFinanMy;
    }

    public String getOvvrnameContractNr() {
        return ovvrnameContractNr;
    }

    public KredietAanvraag ovvrnameContractNr(String ovvrnameContractNr) {
        this.ovvrnameContractNr = ovvrnameContractNr;
        return this;
    }

    public void setOvvrnameContractNr(String ovvrnameContractNr) {
        this.ovvrnameContractNr = ovvrnameContractNr;
    }

    public String getOvernamePlaats() {
        return overnamePlaats;
    }

    public KredietAanvraag overnamePlaats(String overnamePlaats) {
        this.overnamePlaats = overnamePlaats;
        return this;
    }

    public void setOvernamePlaats(String overnamePlaats) {
        this.overnamePlaats = overnamePlaats;
    }

    public String getDuurinMnd() {
        return duurinMnd;
    }

    public KredietAanvraag duurinMnd(String duurinMnd) {
        this.duurinMnd = duurinMnd;
        return this;
    }

    public void setDuurinMnd(String duurinMnd) {
        this.duurinMnd = duurinMnd;
    }

    public BigDecimal getRestantbetaling() {
        return restantbetaling;
    }

    public KredietAanvraag restantbetaling(BigDecimal restantbetaling) {
        this.restantbetaling = restantbetaling;
        return this;
    }

    public void setRestantbetaling(BigDecimal restantbetaling) {
        this.restantbetaling = restantbetaling;
    }

    public String getEffectiveRente() {
        return effectiveRente;
    }

    public KredietAanvraag effectiveRente(String effectiveRente) {
        this.effectiveRente = effectiveRente;
        return this;
    }

    public void setEffectiveRente(String effectiveRente) {
        this.effectiveRente = effectiveRente;
    }

    public String getVerkoper() {
        return verkoper;
    }

    public KredietAanvraag verkoper(String verkoper) {
        this.verkoper = verkoper;
        return this;
    }

    public void setVerkoper(String verkoper) {
        this.verkoper = verkoper;
    }

    public Aanvraagbericht getAanvraagbericht() {
        return aanvraagbericht;
    }

    public KredietAanvraag aanvraagbericht(Aanvraagbericht aanvraagbericht) {
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
        KredietAanvraag kredietAanvraag = (KredietAanvraag) o;
        if (kredietAanvraag.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), kredietAanvraag.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "KredietAanvraag{" +
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
            "}";
    }
}
