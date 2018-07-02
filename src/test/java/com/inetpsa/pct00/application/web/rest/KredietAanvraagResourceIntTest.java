package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.KredietAanvraag;
import com.inetpsa.pct00.application.repository.KredietAanvraagRepository;
import com.inetpsa.pct00.application.service.KredietAanvraagService;
import com.inetpsa.pct00.application.service.dto.KredietAanvraagDTO;
import com.inetpsa.pct00.application.service.mapper.KredietAanvraagMapper;
import com.inetpsa.pct00.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the KredietAanvraagResource REST controller.
 *
 * @see KredietAanvraagResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class KredietAanvraagResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_DUUR_IN_MND = "AAAAAAAAAA";
    private static final String UPDATED_DUUR_IN_MND = "BBBBBBBBBB";

    private static final String DEFAULT_SOORT_AANVRAAG = "AAAAAAAAAA";
    private static final String UPDATED_SOORT_AANVRAAG = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_CODE_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_CODE_NAAM = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_LENING_BEDRAG = new BigDecimal(1);
    private static final BigDecimal UPDATED_LENING_BEDRAG = new BigDecimal(2);

    private static final BigDecimal DEFAULT_MND_AFLOS_BEDRAG = new BigDecimal(1);
    private static final BigDecimal UPDATED_MND_AFLOS_BEDRAG = new BigDecimal(2);

    private static final BigDecimal DEFAULT_GEVR_BEDR_IN_HANDEN = new BigDecimal(1);
    private static final BigDecimal UPDATED_GEVR_BEDR_IN_HANDEN = new BigDecimal(2);

    private static final String DEFAULT_ZEKERHEID = "AAAAAAAAAA";
    private static final String UPDATED_ZEKERHEID = "BBBBBBBBBB";

    private static final String DEFAULT_BESTEDINGSDOEL = "AAAAAAAAAA";
    private static final String UPDATED_BESTEDINGSDOEL = "BBBBBBBBBB";

    private static final String DEFAULT_MERK_OBJECT = "AAAAAAAAAA";
    private static final String UPDATED_MERK_OBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_OBJECT = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_OBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_BOUWJAAR_OBJECT = "AAAAAAAAAA";
    private static final String UPDATED_BOUWJAAR_OBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_KOOPSOM_WAARDE_OBJ = "AAAAAAAAAA";
    private static final String UPDATED_KOOPSOM_WAARDE_OBJ = "BBBBBBBBBB";

    private static final String DEFAULT_KENTEKEN = "AAAAAAAAAA";
    private static final String UPDATED_KENTEKEN = "BBBBBBBBBB";

    private static final String DEFAULT_CHASSISNR = "AAAAAAAAAA";
    private static final String UPDATED_CHASSISNR = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_INRUILBEDRAG = new BigDecimal(1);
    private static final BigDecimal UPDATED_INRUILBEDRAG = new BigDecimal(2);

    private static final String DEFAULT_DOEL_NIEUW = "AAAAAAAAAA";
    private static final String UPDATED_DOEL_NIEUW = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_AANBETALINGBEDRAG = new BigDecimal(1);
    private static final BigDecimal UPDATED_AANBETALINGBEDRAG = new BigDecimal(2);

    private static final String DEFAULT_MODEL_OBJECT = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_OBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_SPAREN = "AAAAAAAAAA";
    private static final String UPDATED_SPAREN = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_TARIEF = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_TARIEF = "BBBBBBBBBB";

    private static final String DEFAULT_TARIEF_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_TARIEF_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_SOORT_CONTRACT = "AAAAAAAAAA";
    private static final String UPDATED_SOORT_CONTRACT = "BBBBBBBBBB";

    private static final String DEFAULT_KONTRAKT_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_KONTRAKT_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUKT_NR = "AAAAAAAAAA";
    private static final String UPDATED_PRODUKT_NR = "BBBBBBBBBB";

    private static final String DEFAULT_PERSPECTIEF = "AAAAAAAAAA";
    private static final String UPDATED_PERSPECTIEF = "BBBBBBBBBB";

    private static final String DEFAULT_NIEUW_GEBRUIKT = "AAAAAAAAAA";
    private static final String UPDATED_NIEUW_GEBRUIKT = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_VERKOOPPRIJS = new BigDecimal(1);
    private static final BigDecimal UPDATED_VERKOOPPRIJS = new BigDecimal(2);

    private static final BigDecimal DEFAULT_AANBETALING = new BigDecimal(1);
    private static final BigDecimal UPDATED_AANBETALING = new BigDecimal(2);

    private static final String DEFAULT_OVERNAME_LOPENDE_LENING = "AAAAAAAAAA";
    private static final String UPDATED_OVERNAME_LOPENDE_LENING = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_KREDIET_SOM = new BigDecimal(1);
    private static final BigDecimal UPDATED_KREDIET_SOM = new BigDecimal(2);

    private static final String DEFAULT_G_MI = "AAAAAAAAAA";
    private static final String UPDATED_G_MI = "BBBBBBBBBB";

    private static final String DEFAULT_OVERNAME_KENTEKENNR = "AAAAAAAAAA";
    private static final String UPDATED_OVERNAME_KENTEKENNR = "BBBBBBBBBB";

    private static final String DEFAULT_OVERNAME_FINAN_MY = "AAAAAAAAAA";
    private static final String UPDATED_OVERNAME_FINAN_MY = "BBBBBBBBBB";

    private static final String DEFAULT_OVVRNAME_CONTRACT_NR = "AAAAAAAAAA";
    private static final String UPDATED_OVVRNAME_CONTRACT_NR = "BBBBBBBBBB";

    private static final String DEFAULT_OVERNAME_PLAATS = "AAAAAAAAAA";
    private static final String UPDATED_OVERNAME_PLAATS = "BBBBBBBBBB";

    private static final String DEFAULT_DUURIN_MND = "AAAAAAAAAA";
    private static final String UPDATED_DUURIN_MND = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_RESTANTBETALING = new BigDecimal(1);
    private static final BigDecimal UPDATED_RESTANTBETALING = new BigDecimal(2);

    private static final String DEFAULT_EFFECTIVE_RENTE = "AAAAAAAAAA";
    private static final String UPDATED_EFFECTIVE_RENTE = "BBBBBBBBBB";

    private static final String DEFAULT_VERKOPER = "AAAAAAAAAA";
    private static final String UPDATED_VERKOPER = "BBBBBBBBBB";

    @Autowired
    private KredietAanvraagRepository kredietAanvraagRepository;


    @Autowired
    private KredietAanvraagMapper kredietAanvraagMapper;
    

    @Autowired
    private KredietAanvraagService kredietAanvraagService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restKredietAanvraagMockMvc;

    private KredietAanvraag kredietAanvraag;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final KredietAanvraagResource kredietAanvraagResource = new KredietAanvraagResource(kredietAanvraagService);
        this.restKredietAanvraagMockMvc = MockMvcBuilders.standaloneSetup(kredietAanvraagResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static KredietAanvraag createEntity(EntityManager em) {
        KredietAanvraag kredietAanvraag = new KredietAanvraag()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .duurInMnd(DEFAULT_DUUR_IN_MND)
            .soortAanvraag(DEFAULT_SOORT_AANVRAAG)
            .produktCodeNaam(DEFAULT_PRODUKT_CODE_NAAM)
            .leningBedrag(DEFAULT_LENING_BEDRAG)
            .mndAflosBedrag(DEFAULT_MND_AFLOS_BEDRAG)
            .gevrBedrInHanden(DEFAULT_GEVR_BEDR_IN_HANDEN)
            .zekerheid(DEFAULT_ZEKERHEID)
            .bestedingsdoel(DEFAULT_BESTEDINGSDOEL)
            .merkObject(DEFAULT_MERK_OBJECT)
            .typeObject(DEFAULT_TYPE_OBJECT)
            .bouwjaarObject(DEFAULT_BOUWJAAR_OBJECT)
            .koopsomWaardeObj(DEFAULT_KOOPSOM_WAARDE_OBJ)
            .kenteken(DEFAULT_KENTEKEN)
            .chassisnr(DEFAULT_CHASSISNR)
            .inruilbedrag(DEFAULT_INRUILBEDRAG)
            .doelNieuw(DEFAULT_DOEL_NIEUW)
            .aanbetalingbedrag(DEFAULT_AANBETALINGBEDRAG)
            .modelObject(DEFAULT_MODEL_OBJECT)
            .sparen(DEFAULT_SPAREN)
            .typeTarief(DEFAULT_TYPE_TARIEF)
            .tariefNaam(DEFAULT_TARIEF_NAAM)
            .soortContract(DEFAULT_SOORT_CONTRACT)
            .kontraktNaam(DEFAULT_KONTRAKT_NAAM)
            .produktNr(DEFAULT_PRODUKT_NR)
            .perspectief(DEFAULT_PERSPECTIEF)
            .nieuwGebruikt(DEFAULT_NIEUW_GEBRUIKT)
            .verkoopprijs(DEFAULT_VERKOOPPRIJS)
            .aanbetaling(DEFAULT_AANBETALING)
            .overnameLopendeLening(DEFAULT_OVERNAME_LOPENDE_LENING)
            .kredietSom(DEFAULT_KREDIET_SOM)
            .gMI(DEFAULT_G_MI)
            .overnameKentekennr(DEFAULT_OVERNAME_KENTEKENNR)
            .overnameFinanMy(DEFAULT_OVERNAME_FINAN_MY)
            .ovvrnameContractNr(DEFAULT_OVVRNAME_CONTRACT_NR)
            .overnamePlaats(DEFAULT_OVERNAME_PLAATS)
            .duurinMnd(DEFAULT_DUURIN_MND)
            .restantbetaling(DEFAULT_RESTANTBETALING)
            .effectiveRente(DEFAULT_EFFECTIVE_RENTE)
            .verkoper(DEFAULT_VERKOPER);
        return kredietAanvraag;
    }

    @Before
    public void initTest() {
        kredietAanvraag = createEntity(em);
    }

    @Test
    @Transactional
    public void createKredietAanvraag() throws Exception {
        int databaseSizeBeforeCreate = kredietAanvraagRepository.findAll().size();

        // Create the KredietAanvraag
        KredietAanvraagDTO kredietAanvraagDTO = kredietAanvraagMapper.toDto(kredietAanvraag);
        restKredietAanvraagMockMvc.perform(post("/api/krediet-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kredietAanvraagDTO)))
            .andExpect(status().isCreated());

        // Validate the KredietAanvraag in the database
        List<KredietAanvraag> kredietAanvraagList = kredietAanvraagRepository.findAll();
        assertThat(kredietAanvraagList).hasSize(databaseSizeBeforeCreate + 1);
        KredietAanvraag testKredietAanvraag = kredietAanvraagList.get(kredietAanvraagList.size() - 1);
        assertThat(testKredietAanvraag.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testKredietAanvraag.getDuurInMnd()).isEqualTo(DEFAULT_DUUR_IN_MND);
        assertThat(testKredietAanvraag.getSoortAanvraag()).isEqualTo(DEFAULT_SOORT_AANVRAAG);
        assertThat(testKredietAanvraag.getProduktCodeNaam()).isEqualTo(DEFAULT_PRODUKT_CODE_NAAM);
        assertThat(testKredietAanvraag.getLeningBedrag()).isEqualTo(DEFAULT_LENING_BEDRAG);
        assertThat(testKredietAanvraag.getMndAflosBedrag()).isEqualTo(DEFAULT_MND_AFLOS_BEDRAG);
        assertThat(testKredietAanvraag.getGevrBedrInHanden()).isEqualTo(DEFAULT_GEVR_BEDR_IN_HANDEN);
        assertThat(testKredietAanvraag.getZekerheid()).isEqualTo(DEFAULT_ZEKERHEID);
        assertThat(testKredietAanvraag.getBestedingsdoel()).isEqualTo(DEFAULT_BESTEDINGSDOEL);
        assertThat(testKredietAanvraag.getMerkObject()).isEqualTo(DEFAULT_MERK_OBJECT);
        assertThat(testKredietAanvraag.getTypeObject()).isEqualTo(DEFAULT_TYPE_OBJECT);
        assertThat(testKredietAanvraag.getBouwjaarObject()).isEqualTo(DEFAULT_BOUWJAAR_OBJECT);
        assertThat(testKredietAanvraag.getKoopsomWaardeObj()).isEqualTo(DEFAULT_KOOPSOM_WAARDE_OBJ);
        assertThat(testKredietAanvraag.getKenteken()).isEqualTo(DEFAULT_KENTEKEN);
        assertThat(testKredietAanvraag.getChassisnr()).isEqualTo(DEFAULT_CHASSISNR);
        assertThat(testKredietAanvraag.getInruilbedrag()).isEqualTo(DEFAULT_INRUILBEDRAG);
        assertThat(testKredietAanvraag.getDoelNieuw()).isEqualTo(DEFAULT_DOEL_NIEUW);
        assertThat(testKredietAanvraag.getAanbetalingbedrag()).isEqualTo(DEFAULT_AANBETALINGBEDRAG);
        assertThat(testKredietAanvraag.getModelObject()).isEqualTo(DEFAULT_MODEL_OBJECT);
        assertThat(testKredietAanvraag.getSparen()).isEqualTo(DEFAULT_SPAREN);
        assertThat(testKredietAanvraag.getTypeTarief()).isEqualTo(DEFAULT_TYPE_TARIEF);
        assertThat(testKredietAanvraag.getTariefNaam()).isEqualTo(DEFAULT_TARIEF_NAAM);
        assertThat(testKredietAanvraag.getSoortContract()).isEqualTo(DEFAULT_SOORT_CONTRACT);
        assertThat(testKredietAanvraag.getKontraktNaam()).isEqualTo(DEFAULT_KONTRAKT_NAAM);
        assertThat(testKredietAanvraag.getProduktNr()).isEqualTo(DEFAULT_PRODUKT_NR);
        assertThat(testKredietAanvraag.getPerspectief()).isEqualTo(DEFAULT_PERSPECTIEF);
        assertThat(testKredietAanvraag.getNieuwGebruikt()).isEqualTo(DEFAULT_NIEUW_GEBRUIKT);
        assertThat(testKredietAanvraag.getVerkoopprijs()).isEqualTo(DEFAULT_VERKOOPPRIJS);
        assertThat(testKredietAanvraag.getAanbetaling()).isEqualTo(DEFAULT_AANBETALING);
        assertThat(testKredietAanvraag.getOvernameLopendeLening()).isEqualTo(DEFAULT_OVERNAME_LOPENDE_LENING);
        assertThat(testKredietAanvraag.getKredietSom()).isEqualTo(DEFAULT_KREDIET_SOM);
        assertThat(testKredietAanvraag.getgMI()).isEqualTo(DEFAULT_G_MI);
        assertThat(testKredietAanvraag.getOvernameKentekennr()).isEqualTo(DEFAULT_OVERNAME_KENTEKENNR);
        assertThat(testKredietAanvraag.getOvernameFinanMy()).isEqualTo(DEFAULT_OVERNAME_FINAN_MY);
        assertThat(testKredietAanvraag.getOvvrnameContractNr()).isEqualTo(DEFAULT_OVVRNAME_CONTRACT_NR);
        assertThat(testKredietAanvraag.getOvernamePlaats()).isEqualTo(DEFAULT_OVERNAME_PLAATS);
        assertThat(testKredietAanvraag.getDuurinMnd()).isEqualTo(DEFAULT_DUURIN_MND);
        assertThat(testKredietAanvraag.getRestantbetaling()).isEqualTo(DEFAULT_RESTANTBETALING);
        assertThat(testKredietAanvraag.getEffectiveRente()).isEqualTo(DEFAULT_EFFECTIVE_RENTE);
        assertThat(testKredietAanvraag.getVerkoper()).isEqualTo(DEFAULT_VERKOPER);
    }

    @Test
    @Transactional
    public void createKredietAanvraagWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = kredietAanvraagRepository.findAll().size();

        // Create the KredietAanvraag with an existing ID
        kredietAanvraag.setId(1L);
        KredietAanvraagDTO kredietAanvraagDTO = kredietAanvraagMapper.toDto(kredietAanvraag);

        // An entity with an existing ID cannot be created, so this API call must fail
        restKredietAanvraagMockMvc.perform(post("/api/krediet-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kredietAanvraagDTO)))
            .andExpect(status().isBadRequest());

        // Validate the KredietAanvraag in the database
        List<KredietAanvraag> kredietAanvraagList = kredietAanvraagRepository.findAll();
        assertThat(kredietAanvraagList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllKredietAanvraags() throws Exception {
        // Initialize the database
        kredietAanvraagRepository.saveAndFlush(kredietAanvraag);

        // Get all the kredietAanvraagList
        restKredietAanvraagMockMvc.perform(get("/api/krediet-aanvraags?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(kredietAanvraag.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].duurInMnd").value(hasItem(DEFAULT_DUUR_IN_MND.toString())))
            .andExpect(jsonPath("$.[*].soortAanvraag").value(hasItem(DEFAULT_SOORT_AANVRAAG.toString())))
            .andExpect(jsonPath("$.[*].produktCodeNaam").value(hasItem(DEFAULT_PRODUKT_CODE_NAAM.toString())))
            .andExpect(jsonPath("$.[*].leningBedrag").value(hasItem(DEFAULT_LENING_BEDRAG.intValue())))
            .andExpect(jsonPath("$.[*].mndAflosBedrag").value(hasItem(DEFAULT_MND_AFLOS_BEDRAG.intValue())))
            .andExpect(jsonPath("$.[*].gevrBedrInHanden").value(hasItem(DEFAULT_GEVR_BEDR_IN_HANDEN.intValue())))
            .andExpect(jsonPath("$.[*].zekerheid").value(hasItem(DEFAULT_ZEKERHEID.toString())))
            .andExpect(jsonPath("$.[*].bestedingsdoel").value(hasItem(DEFAULT_BESTEDINGSDOEL.toString())))
            .andExpect(jsonPath("$.[*].merkObject").value(hasItem(DEFAULT_MERK_OBJECT.toString())))
            .andExpect(jsonPath("$.[*].typeObject").value(hasItem(DEFAULT_TYPE_OBJECT.toString())))
            .andExpect(jsonPath("$.[*].bouwjaarObject").value(hasItem(DEFAULT_BOUWJAAR_OBJECT.toString())))
            .andExpect(jsonPath("$.[*].koopsomWaardeObj").value(hasItem(DEFAULT_KOOPSOM_WAARDE_OBJ.toString())))
            .andExpect(jsonPath("$.[*].kenteken").value(hasItem(DEFAULT_KENTEKEN.toString())))
            .andExpect(jsonPath("$.[*].chassisnr").value(hasItem(DEFAULT_CHASSISNR.toString())))
            .andExpect(jsonPath("$.[*].inruilbedrag").value(hasItem(DEFAULT_INRUILBEDRAG.intValue())))
            .andExpect(jsonPath("$.[*].doelNieuw").value(hasItem(DEFAULT_DOEL_NIEUW.toString())))
            .andExpect(jsonPath("$.[*].aanbetalingbedrag").value(hasItem(DEFAULT_AANBETALINGBEDRAG.intValue())))
            .andExpect(jsonPath("$.[*].modelObject").value(hasItem(DEFAULT_MODEL_OBJECT.toString())))
            .andExpect(jsonPath("$.[*].sparen").value(hasItem(DEFAULT_SPAREN.toString())))
            .andExpect(jsonPath("$.[*].typeTarief").value(hasItem(DEFAULT_TYPE_TARIEF.toString())))
            .andExpect(jsonPath("$.[*].tariefNaam").value(hasItem(DEFAULT_TARIEF_NAAM.toString())))
            .andExpect(jsonPath("$.[*].soortContract").value(hasItem(DEFAULT_SOORT_CONTRACT.toString())))
            .andExpect(jsonPath("$.[*].kontraktNaam").value(hasItem(DEFAULT_KONTRAKT_NAAM.toString())))
            .andExpect(jsonPath("$.[*].produktNr").value(hasItem(DEFAULT_PRODUKT_NR.toString())))
            .andExpect(jsonPath("$.[*].perspectief").value(hasItem(DEFAULT_PERSPECTIEF.toString())))
            .andExpect(jsonPath("$.[*].nieuwGebruikt").value(hasItem(DEFAULT_NIEUW_GEBRUIKT.toString())))
            .andExpect(jsonPath("$.[*].verkoopprijs").value(hasItem(DEFAULT_VERKOOPPRIJS.intValue())))
            .andExpect(jsonPath("$.[*].aanbetaling").value(hasItem(DEFAULT_AANBETALING.intValue())))
            .andExpect(jsonPath("$.[*].overnameLopendeLening").value(hasItem(DEFAULT_OVERNAME_LOPENDE_LENING.toString())))
            .andExpect(jsonPath("$.[*].kredietSom").value(hasItem(DEFAULT_KREDIET_SOM.intValue())))
            .andExpect(jsonPath("$.[*].gMI").value(hasItem(DEFAULT_G_MI.toString())))
            .andExpect(jsonPath("$.[*].overnameKentekennr").value(hasItem(DEFAULT_OVERNAME_KENTEKENNR.toString())))
            .andExpect(jsonPath("$.[*].overnameFinanMy").value(hasItem(DEFAULT_OVERNAME_FINAN_MY.toString())))
            .andExpect(jsonPath("$.[*].ovvrnameContractNr").value(hasItem(DEFAULT_OVVRNAME_CONTRACT_NR.toString())))
            .andExpect(jsonPath("$.[*].overnamePlaats").value(hasItem(DEFAULT_OVERNAME_PLAATS.toString())))
            .andExpect(jsonPath("$.[*].duurinMnd").value(hasItem(DEFAULT_DUURIN_MND.toString())))
            .andExpect(jsonPath("$.[*].restantbetaling").value(hasItem(DEFAULT_RESTANTBETALING.intValue())))
            .andExpect(jsonPath("$.[*].effectiveRente").value(hasItem(DEFAULT_EFFECTIVE_RENTE.toString())))
            .andExpect(jsonPath("$.[*].verkoper").value(hasItem(DEFAULT_VERKOPER.toString())));
    }
    

    @Test
    @Transactional
    public void getKredietAanvraag() throws Exception {
        // Initialize the database
        kredietAanvraagRepository.saveAndFlush(kredietAanvraag);

        // Get the kredietAanvraag
        restKredietAanvraagMockMvc.perform(get("/api/krediet-aanvraags/{id}", kredietAanvraag.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(kredietAanvraag.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.duurInMnd").value(DEFAULT_DUUR_IN_MND.toString()))
            .andExpect(jsonPath("$.soortAanvraag").value(DEFAULT_SOORT_AANVRAAG.toString()))
            .andExpect(jsonPath("$.produktCodeNaam").value(DEFAULT_PRODUKT_CODE_NAAM.toString()))
            .andExpect(jsonPath("$.leningBedrag").value(DEFAULT_LENING_BEDRAG.intValue()))
            .andExpect(jsonPath("$.mndAflosBedrag").value(DEFAULT_MND_AFLOS_BEDRAG.intValue()))
            .andExpect(jsonPath("$.gevrBedrInHanden").value(DEFAULT_GEVR_BEDR_IN_HANDEN.intValue()))
            .andExpect(jsonPath("$.zekerheid").value(DEFAULT_ZEKERHEID.toString()))
            .andExpect(jsonPath("$.bestedingsdoel").value(DEFAULT_BESTEDINGSDOEL.toString()))
            .andExpect(jsonPath("$.merkObject").value(DEFAULT_MERK_OBJECT.toString()))
            .andExpect(jsonPath("$.typeObject").value(DEFAULT_TYPE_OBJECT.toString()))
            .andExpect(jsonPath("$.bouwjaarObject").value(DEFAULT_BOUWJAAR_OBJECT.toString()))
            .andExpect(jsonPath("$.koopsomWaardeObj").value(DEFAULT_KOOPSOM_WAARDE_OBJ.toString()))
            .andExpect(jsonPath("$.kenteken").value(DEFAULT_KENTEKEN.toString()))
            .andExpect(jsonPath("$.chassisnr").value(DEFAULT_CHASSISNR.toString()))
            .andExpect(jsonPath("$.inruilbedrag").value(DEFAULT_INRUILBEDRAG.intValue()))
            .andExpect(jsonPath("$.doelNieuw").value(DEFAULT_DOEL_NIEUW.toString()))
            .andExpect(jsonPath("$.aanbetalingbedrag").value(DEFAULT_AANBETALINGBEDRAG.intValue()))
            .andExpect(jsonPath("$.modelObject").value(DEFAULT_MODEL_OBJECT.toString()))
            .andExpect(jsonPath("$.sparen").value(DEFAULT_SPAREN.toString()))
            .andExpect(jsonPath("$.typeTarief").value(DEFAULT_TYPE_TARIEF.toString()))
            .andExpect(jsonPath("$.tariefNaam").value(DEFAULT_TARIEF_NAAM.toString()))
            .andExpect(jsonPath("$.soortContract").value(DEFAULT_SOORT_CONTRACT.toString()))
            .andExpect(jsonPath("$.kontraktNaam").value(DEFAULT_KONTRAKT_NAAM.toString()))
            .andExpect(jsonPath("$.produktNr").value(DEFAULT_PRODUKT_NR.toString()))
            .andExpect(jsonPath("$.perspectief").value(DEFAULT_PERSPECTIEF.toString()))
            .andExpect(jsonPath("$.nieuwGebruikt").value(DEFAULT_NIEUW_GEBRUIKT.toString()))
            .andExpect(jsonPath("$.verkoopprijs").value(DEFAULT_VERKOOPPRIJS.intValue()))
            .andExpect(jsonPath("$.aanbetaling").value(DEFAULT_AANBETALING.intValue()))
            .andExpect(jsonPath("$.overnameLopendeLening").value(DEFAULT_OVERNAME_LOPENDE_LENING.toString()))
            .andExpect(jsonPath("$.kredietSom").value(DEFAULT_KREDIET_SOM.intValue()))
            .andExpect(jsonPath("$.gMI").value(DEFAULT_G_MI.toString()))
            .andExpect(jsonPath("$.overnameKentekennr").value(DEFAULT_OVERNAME_KENTEKENNR.toString()))
            .andExpect(jsonPath("$.overnameFinanMy").value(DEFAULT_OVERNAME_FINAN_MY.toString()))
            .andExpect(jsonPath("$.ovvrnameContractNr").value(DEFAULT_OVVRNAME_CONTRACT_NR.toString()))
            .andExpect(jsonPath("$.overnamePlaats").value(DEFAULT_OVERNAME_PLAATS.toString()))
            .andExpect(jsonPath("$.duurinMnd").value(DEFAULT_DUURIN_MND.toString()))
            .andExpect(jsonPath("$.restantbetaling").value(DEFAULT_RESTANTBETALING.intValue()))
            .andExpect(jsonPath("$.effectiveRente").value(DEFAULT_EFFECTIVE_RENTE.toString()))
            .andExpect(jsonPath("$.verkoper").value(DEFAULT_VERKOPER.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingKredietAanvraag() throws Exception {
        // Get the kredietAanvraag
        restKredietAanvraagMockMvc.perform(get("/api/krediet-aanvraags/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateKredietAanvraag() throws Exception {
        // Initialize the database
        kredietAanvraagRepository.saveAndFlush(kredietAanvraag);

        int databaseSizeBeforeUpdate = kredietAanvraagRepository.findAll().size();

        // Update the kredietAanvraag
        KredietAanvraag updatedKredietAanvraag = kredietAanvraagRepository.findById(kredietAanvraag.getId()).get();
        // Disconnect from session so that the updates on updatedKredietAanvraag are not directly saved in db
        em.detach(updatedKredietAanvraag);
        updatedKredietAanvraag
            .volgnummer(UPDATED_VOLGNUMMER)
            .duurInMnd(UPDATED_DUUR_IN_MND)
            .soortAanvraag(UPDATED_SOORT_AANVRAAG)
            .produktCodeNaam(UPDATED_PRODUKT_CODE_NAAM)
            .leningBedrag(UPDATED_LENING_BEDRAG)
            .mndAflosBedrag(UPDATED_MND_AFLOS_BEDRAG)
            .gevrBedrInHanden(UPDATED_GEVR_BEDR_IN_HANDEN)
            .zekerheid(UPDATED_ZEKERHEID)
            .bestedingsdoel(UPDATED_BESTEDINGSDOEL)
            .merkObject(UPDATED_MERK_OBJECT)
            .typeObject(UPDATED_TYPE_OBJECT)
            .bouwjaarObject(UPDATED_BOUWJAAR_OBJECT)
            .koopsomWaardeObj(UPDATED_KOOPSOM_WAARDE_OBJ)
            .kenteken(UPDATED_KENTEKEN)
            .chassisnr(UPDATED_CHASSISNR)
            .inruilbedrag(UPDATED_INRUILBEDRAG)
            .doelNieuw(UPDATED_DOEL_NIEUW)
            .aanbetalingbedrag(UPDATED_AANBETALINGBEDRAG)
            .modelObject(UPDATED_MODEL_OBJECT)
            .sparen(UPDATED_SPAREN)
            .typeTarief(UPDATED_TYPE_TARIEF)
            .tariefNaam(UPDATED_TARIEF_NAAM)
            .soortContract(UPDATED_SOORT_CONTRACT)
            .kontraktNaam(UPDATED_KONTRAKT_NAAM)
            .produktNr(UPDATED_PRODUKT_NR)
            .perspectief(UPDATED_PERSPECTIEF)
            .nieuwGebruikt(UPDATED_NIEUW_GEBRUIKT)
            .verkoopprijs(UPDATED_VERKOOPPRIJS)
            .aanbetaling(UPDATED_AANBETALING)
            .overnameLopendeLening(UPDATED_OVERNAME_LOPENDE_LENING)
            .kredietSom(UPDATED_KREDIET_SOM)
            .gMI(UPDATED_G_MI)
            .overnameKentekennr(UPDATED_OVERNAME_KENTEKENNR)
            .overnameFinanMy(UPDATED_OVERNAME_FINAN_MY)
            .ovvrnameContractNr(UPDATED_OVVRNAME_CONTRACT_NR)
            .overnamePlaats(UPDATED_OVERNAME_PLAATS)
            .duurinMnd(UPDATED_DUURIN_MND)
            .restantbetaling(UPDATED_RESTANTBETALING)
            .effectiveRente(UPDATED_EFFECTIVE_RENTE)
            .verkoper(UPDATED_VERKOPER);
        KredietAanvraagDTO kredietAanvraagDTO = kredietAanvraagMapper.toDto(updatedKredietAanvraag);

        restKredietAanvraagMockMvc.perform(put("/api/krediet-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kredietAanvraagDTO)))
            .andExpect(status().isOk());

        // Validate the KredietAanvraag in the database
        List<KredietAanvraag> kredietAanvraagList = kredietAanvraagRepository.findAll();
        assertThat(kredietAanvraagList).hasSize(databaseSizeBeforeUpdate);
        KredietAanvraag testKredietAanvraag = kredietAanvraagList.get(kredietAanvraagList.size() - 1);
        assertThat(testKredietAanvraag.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testKredietAanvraag.getDuurInMnd()).isEqualTo(UPDATED_DUUR_IN_MND);
        assertThat(testKredietAanvraag.getSoortAanvraag()).isEqualTo(UPDATED_SOORT_AANVRAAG);
        assertThat(testKredietAanvraag.getProduktCodeNaam()).isEqualTo(UPDATED_PRODUKT_CODE_NAAM);
        assertThat(testKredietAanvraag.getLeningBedrag()).isEqualTo(UPDATED_LENING_BEDRAG);
        assertThat(testKredietAanvraag.getMndAflosBedrag()).isEqualTo(UPDATED_MND_AFLOS_BEDRAG);
        assertThat(testKredietAanvraag.getGevrBedrInHanden()).isEqualTo(UPDATED_GEVR_BEDR_IN_HANDEN);
        assertThat(testKredietAanvraag.getZekerheid()).isEqualTo(UPDATED_ZEKERHEID);
        assertThat(testKredietAanvraag.getBestedingsdoel()).isEqualTo(UPDATED_BESTEDINGSDOEL);
        assertThat(testKredietAanvraag.getMerkObject()).isEqualTo(UPDATED_MERK_OBJECT);
        assertThat(testKredietAanvraag.getTypeObject()).isEqualTo(UPDATED_TYPE_OBJECT);
        assertThat(testKredietAanvraag.getBouwjaarObject()).isEqualTo(UPDATED_BOUWJAAR_OBJECT);
        assertThat(testKredietAanvraag.getKoopsomWaardeObj()).isEqualTo(UPDATED_KOOPSOM_WAARDE_OBJ);
        assertThat(testKredietAanvraag.getKenteken()).isEqualTo(UPDATED_KENTEKEN);
        assertThat(testKredietAanvraag.getChassisnr()).isEqualTo(UPDATED_CHASSISNR);
        assertThat(testKredietAanvraag.getInruilbedrag()).isEqualTo(UPDATED_INRUILBEDRAG);
        assertThat(testKredietAanvraag.getDoelNieuw()).isEqualTo(UPDATED_DOEL_NIEUW);
        assertThat(testKredietAanvraag.getAanbetalingbedrag()).isEqualTo(UPDATED_AANBETALINGBEDRAG);
        assertThat(testKredietAanvraag.getModelObject()).isEqualTo(UPDATED_MODEL_OBJECT);
        assertThat(testKredietAanvraag.getSparen()).isEqualTo(UPDATED_SPAREN);
        assertThat(testKredietAanvraag.getTypeTarief()).isEqualTo(UPDATED_TYPE_TARIEF);
        assertThat(testKredietAanvraag.getTariefNaam()).isEqualTo(UPDATED_TARIEF_NAAM);
        assertThat(testKredietAanvraag.getSoortContract()).isEqualTo(UPDATED_SOORT_CONTRACT);
        assertThat(testKredietAanvraag.getKontraktNaam()).isEqualTo(UPDATED_KONTRAKT_NAAM);
        assertThat(testKredietAanvraag.getProduktNr()).isEqualTo(UPDATED_PRODUKT_NR);
        assertThat(testKredietAanvraag.getPerspectief()).isEqualTo(UPDATED_PERSPECTIEF);
        assertThat(testKredietAanvraag.getNieuwGebruikt()).isEqualTo(UPDATED_NIEUW_GEBRUIKT);
        assertThat(testKredietAanvraag.getVerkoopprijs()).isEqualTo(UPDATED_VERKOOPPRIJS);
        assertThat(testKredietAanvraag.getAanbetaling()).isEqualTo(UPDATED_AANBETALING);
        assertThat(testKredietAanvraag.getOvernameLopendeLening()).isEqualTo(UPDATED_OVERNAME_LOPENDE_LENING);
        assertThat(testKredietAanvraag.getKredietSom()).isEqualTo(UPDATED_KREDIET_SOM);
        assertThat(testKredietAanvraag.getgMI()).isEqualTo(UPDATED_G_MI);
        assertThat(testKredietAanvraag.getOvernameKentekennr()).isEqualTo(UPDATED_OVERNAME_KENTEKENNR);
        assertThat(testKredietAanvraag.getOvernameFinanMy()).isEqualTo(UPDATED_OVERNAME_FINAN_MY);
        assertThat(testKredietAanvraag.getOvvrnameContractNr()).isEqualTo(UPDATED_OVVRNAME_CONTRACT_NR);
        assertThat(testKredietAanvraag.getOvernamePlaats()).isEqualTo(UPDATED_OVERNAME_PLAATS);
        assertThat(testKredietAanvraag.getDuurinMnd()).isEqualTo(UPDATED_DUURIN_MND);
        assertThat(testKredietAanvraag.getRestantbetaling()).isEqualTo(UPDATED_RESTANTBETALING);
        assertThat(testKredietAanvraag.getEffectiveRente()).isEqualTo(UPDATED_EFFECTIVE_RENTE);
        assertThat(testKredietAanvraag.getVerkoper()).isEqualTo(UPDATED_VERKOPER);
    }

    @Test
    @Transactional
    public void updateNonExistingKredietAanvraag() throws Exception {
        int databaseSizeBeforeUpdate = kredietAanvraagRepository.findAll().size();

        // Create the KredietAanvraag
        KredietAanvraagDTO kredietAanvraagDTO = kredietAanvraagMapper.toDto(kredietAanvraag);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restKredietAanvraagMockMvc.perform(put("/api/krediet-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kredietAanvraagDTO)))
            .andExpect(status().isBadRequest());

        // Validate the KredietAanvraag in the database
        List<KredietAanvraag> kredietAanvraagList = kredietAanvraagRepository.findAll();
        assertThat(kredietAanvraagList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteKredietAanvraag() throws Exception {
        // Initialize the database
        kredietAanvraagRepository.saveAndFlush(kredietAanvraag);

        int databaseSizeBeforeDelete = kredietAanvraagRepository.findAll().size();

        // Get the kredietAanvraag
        restKredietAanvraagMockMvc.perform(delete("/api/krediet-aanvraags/{id}", kredietAanvraag.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<KredietAanvraag> kredietAanvraagList = kredietAanvraagRepository.findAll();
        assertThat(kredietAanvraagList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(KredietAanvraag.class);
        KredietAanvraag kredietAanvraag1 = new KredietAanvraag();
        kredietAanvraag1.setId(1L);
        KredietAanvraag kredietAanvraag2 = new KredietAanvraag();
        kredietAanvraag2.setId(kredietAanvraag1.getId());
        assertThat(kredietAanvraag1).isEqualTo(kredietAanvraag2);
        kredietAanvraag2.setId(2L);
        assertThat(kredietAanvraag1).isNotEqualTo(kredietAanvraag2);
        kredietAanvraag1.setId(null);
        assertThat(kredietAanvraag1).isNotEqualTo(kredietAanvraag2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(KredietAanvraagDTO.class);
        KredietAanvraagDTO kredietAanvraagDTO1 = new KredietAanvraagDTO();
        kredietAanvraagDTO1.setId(1L);
        KredietAanvraagDTO kredietAanvraagDTO2 = new KredietAanvraagDTO();
        assertThat(kredietAanvraagDTO1).isNotEqualTo(kredietAanvraagDTO2);
        kredietAanvraagDTO2.setId(kredietAanvraagDTO1.getId());
        assertThat(kredietAanvraagDTO1).isEqualTo(kredietAanvraagDTO2);
        kredietAanvraagDTO2.setId(2L);
        assertThat(kredietAanvraagDTO1).isNotEqualTo(kredietAanvraagDTO2);
        kredietAanvraagDTO1.setId(null);
        assertThat(kredietAanvraagDTO1).isNotEqualTo(kredietAanvraagDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(kredietAanvraagMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(kredietAanvraagMapper.fromId(null)).isNull();
    }
}
