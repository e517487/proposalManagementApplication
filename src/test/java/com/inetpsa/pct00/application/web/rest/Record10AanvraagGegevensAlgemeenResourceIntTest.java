package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record10AanvraagGegevensAlgemeen;
import com.inetpsa.pct00.application.repository.Record10AanvraagGegevensAlgemeenRepository;
import com.inetpsa.pct00.application.service.dto.Record10AanvraagGegevensAlgemeenDTO;
import com.inetpsa.pct00.application.service.mapper.Record10AanvraagGegevensAlgemeenMapper;
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
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.sameInstant;
import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the Record10AanvraagGegevensAlgemeenResource REST controller.
 *
 * @see Record10AanvraagGegevensAlgemeenResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record10AanvraagGegevensAlgemeenResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    private static final String DEFAULT_DEALER_NR = "AAAAAAAAAA";
    private static final String UPDATED_DEALER_NR = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ZOEKNAAM = "AAAAAAAAAA";
    private static final String UPDATED_ZOEKNAAM = "BBBBBBBBBB";

    private static final String DEFAULT_VERKOPER = "AAAAAAAAAA";
    private static final String UPDATED_VERKOPER = "BBBBBBBBBB";

    private static final String DEFAULT_DEALER_TELNR = "AAAAAAAAAA";
    private static final String UPDATED_DEALER_TELNR = "BBBBBBBBBB";

    private static final String DEFAULT_ACCEPTATIE = "AAAAAAAAAA";
    private static final String UPDATED_ACCEPTATIE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_AANVANG_DATUM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_AANVANG_DATUM = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_AANVANG_TIJD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_AANVANG_TIJD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final LocalDate DEFAULT_ACCEPTATIE_DATUM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ACCEPTATIE_DATUM = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_ACCEPTATIE_TIJD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ACCEPTATIE_TIJD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final LocalDate DEFAULT_PRT_DATUM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PRT_DATUM = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_INVOERDER = "AAAAAAAAAA";
    private static final String UPDATED_INVOERDER = "BBBBBBBBBB";

    private static final String DEFAULT_ACCEPTANT = "AAAAAAAAAA";
    private static final String UPDATED_ACCEPTANT = "BBBBBBBBBB";

    @Autowired
    private Record10AanvraagGegevensAlgemeenRepository record10AanvraagGegevensAlgemeenRepository;


    @Autowired
    private Record10AanvraagGegevensAlgemeenMapper record10AanvraagGegevensAlgemeenMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord10AanvraagGegevensAlgemeenMockMvc;

    private Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record10AanvraagGegevensAlgemeenResource record10AanvraagGegevensAlgemeenResource = new Record10AanvraagGegevensAlgemeenResource(record10AanvraagGegevensAlgemeenRepository, record10AanvraagGegevensAlgemeenMapper);
        this.restRecord10AanvraagGegevensAlgemeenMockMvc = MockMvcBuilders.standaloneSetup(record10AanvraagGegevensAlgemeenResource)
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
    public static Record10AanvraagGegevensAlgemeen createEntity(EntityManager em) {
        Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen = new Record10AanvraagGegevensAlgemeen()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .dealerNr(DEFAULT_DEALER_NR)
            .productCode(DEFAULT_PRODUCT_CODE)
            .zoeknaam(DEFAULT_ZOEKNAAM)
            .verkoper(DEFAULT_VERKOPER)
            .dealerTelnr(DEFAULT_DEALER_TELNR)
            .acceptatie(DEFAULT_ACCEPTATIE)
            .aanvangDatum(DEFAULT_AANVANG_DATUM)
            .aanvangTijd(DEFAULT_AANVANG_TIJD)
            .acceptatieDatum(DEFAULT_ACCEPTATIE_DATUM)
            .acceptatieTijd(DEFAULT_ACCEPTATIE_TIJD)
            .prtDatum(DEFAULT_PRT_DATUM)
            .invoerder(DEFAULT_INVOERDER)
            .acceptant(DEFAULT_ACCEPTANT);
        return record10AanvraagGegevensAlgemeen;
    }

    @Before
    public void initTest() {
        record10AanvraagGegevensAlgemeen = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord10AanvraagGegevensAlgemeen() throws Exception {
        int databaseSizeBeforeCreate = record10AanvraagGegevensAlgemeenRepository.findAll().size();

        // Create the Record10AanvraagGegevensAlgemeen
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO = record10AanvraagGegevensAlgemeenMapper.toDto(record10AanvraagGegevensAlgemeen);
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(post("/api/record-10-aanvraag-gegevens-algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record10AanvraagGegevensAlgemeenDTO)))
            .andExpect(status().isCreated());

        // Validate the Record10AanvraagGegevensAlgemeen in the database
        List<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeenList = record10AanvraagGegevensAlgemeenRepository.findAll();
        assertThat(record10AanvraagGegevensAlgemeenList).hasSize(databaseSizeBeforeCreate + 1);
        Record10AanvraagGegevensAlgemeen testRecord10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeenList.get(record10AanvraagGegevensAlgemeenList.size() - 1);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getDealerNr()).isEqualTo(DEFAULT_DEALER_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getProductCode()).isEqualTo(DEFAULT_PRODUCT_CODE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getZoeknaam()).isEqualTo(DEFAULT_ZOEKNAAM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getVerkoper()).isEqualTo(DEFAULT_VERKOPER);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getDealerTelnr()).isEqualTo(DEFAULT_DEALER_TELNR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatie()).isEqualTo(DEFAULT_ACCEPTATIE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAanvangDatum()).isEqualTo(DEFAULT_AANVANG_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAanvangTijd()).isEqualTo(DEFAULT_AANVANG_TIJD);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatieDatum()).isEqualTo(DEFAULT_ACCEPTATIE_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatieTijd()).isEqualTo(DEFAULT_ACCEPTATIE_TIJD);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getPrtDatum()).isEqualTo(DEFAULT_PRT_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getInvoerder()).isEqualTo(DEFAULT_INVOERDER);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptant()).isEqualTo(DEFAULT_ACCEPTANT);
    }

    @Test
    @Transactional
    public void createRecord10AanvraagGegevensAlgemeenWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record10AanvraagGegevensAlgemeenRepository.findAll().size();

        // Create the Record10AanvraagGegevensAlgemeen with an existing ID
        record10AanvraagGegevensAlgemeen.setId(1L);
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO = record10AanvraagGegevensAlgemeenMapper.toDto(record10AanvraagGegevensAlgemeen);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(post("/api/record-10-aanvraag-gegevens-algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record10AanvraagGegevensAlgemeenDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record10AanvraagGegevensAlgemeen in the database
        List<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeenList = record10AanvraagGegevensAlgemeenRepository.findAll();
        assertThat(record10AanvraagGegevensAlgemeenList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord10AanvraagGegevensAlgemeens() throws Exception {
        // Initialize the database
        record10AanvraagGegevensAlgemeenRepository.saveAndFlush(record10AanvraagGegevensAlgemeen);

        // Get all the record10AanvraagGegevensAlgemeenList
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(get("/api/record-10-aanvraag-gegevens-algemeens?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record10AanvraagGegevensAlgemeen.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)))
            .andExpect(jsonPath("$.[*].dealerNr").value(hasItem(DEFAULT_DEALER_NR.toString())))
            .andExpect(jsonPath("$.[*].productCode").value(hasItem(DEFAULT_PRODUCT_CODE.toString())))
            .andExpect(jsonPath("$.[*].zoeknaam").value(hasItem(DEFAULT_ZOEKNAAM.toString())))
            .andExpect(jsonPath("$.[*].verkoper").value(hasItem(DEFAULT_VERKOPER.toString())))
            .andExpect(jsonPath("$.[*].dealerTelnr").value(hasItem(DEFAULT_DEALER_TELNR.toString())))
            .andExpect(jsonPath("$.[*].acceptatie").value(hasItem(DEFAULT_ACCEPTATIE.toString())))
            .andExpect(jsonPath("$.[*].aanvangDatum").value(hasItem(DEFAULT_AANVANG_DATUM.toString())))
            .andExpect(jsonPath("$.[*].aanvangTijd").value(hasItem(sameInstant(DEFAULT_AANVANG_TIJD))))
            .andExpect(jsonPath("$.[*].acceptatieDatum").value(hasItem(DEFAULT_ACCEPTATIE_DATUM.toString())))
            .andExpect(jsonPath("$.[*].acceptatieTijd").value(hasItem(sameInstant(DEFAULT_ACCEPTATIE_TIJD))))
            .andExpect(jsonPath("$.[*].prtDatum").value(hasItem(DEFAULT_PRT_DATUM.toString())))
            .andExpect(jsonPath("$.[*].invoerder").value(hasItem(DEFAULT_INVOERDER.toString())))
            .andExpect(jsonPath("$.[*].acceptant").value(hasItem(DEFAULT_ACCEPTANT.toString())));
    }
    

    @Test
    @Transactional
    public void getRecord10AanvraagGegevensAlgemeen() throws Exception {
        // Initialize the database
        record10AanvraagGegevensAlgemeenRepository.saveAndFlush(record10AanvraagGegevensAlgemeen);

        // Get the record10AanvraagGegevensAlgemeen
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(get("/api/record-10-aanvraag-gegevens-algemeens/{id}", record10AanvraagGegevensAlgemeen.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record10AanvraagGegevensAlgemeen.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR))
            .andExpect(jsonPath("$.dealerNr").value(DEFAULT_DEALER_NR.toString()))
            .andExpect(jsonPath("$.productCode").value(DEFAULT_PRODUCT_CODE.toString()))
            .andExpect(jsonPath("$.zoeknaam").value(DEFAULT_ZOEKNAAM.toString()))
            .andExpect(jsonPath("$.verkoper").value(DEFAULT_VERKOPER.toString()))
            .andExpect(jsonPath("$.dealerTelnr").value(DEFAULT_DEALER_TELNR.toString()))
            .andExpect(jsonPath("$.acceptatie").value(DEFAULT_ACCEPTATIE.toString()))
            .andExpect(jsonPath("$.aanvangDatum").value(DEFAULT_AANVANG_DATUM.toString()))
            .andExpect(jsonPath("$.aanvangTijd").value(sameInstant(DEFAULT_AANVANG_TIJD)))
            .andExpect(jsonPath("$.acceptatieDatum").value(DEFAULT_ACCEPTATIE_DATUM.toString()))
            .andExpect(jsonPath("$.acceptatieTijd").value(sameInstant(DEFAULT_ACCEPTATIE_TIJD)))
            .andExpect(jsonPath("$.prtDatum").value(DEFAULT_PRT_DATUM.toString()))
            .andExpect(jsonPath("$.invoerder").value(DEFAULT_INVOERDER.toString()))
            .andExpect(jsonPath("$.acceptant").value(DEFAULT_ACCEPTANT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingRecord10AanvraagGegevensAlgemeen() throws Exception {
        // Get the record10AanvraagGegevensAlgemeen
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(get("/api/record-10-aanvraag-gegevens-algemeens/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord10AanvraagGegevensAlgemeen() throws Exception {
        // Initialize the database
        record10AanvraagGegevensAlgemeenRepository.saveAndFlush(record10AanvraagGegevensAlgemeen);

        int databaseSizeBeforeUpdate = record10AanvraagGegevensAlgemeenRepository.findAll().size();

        // Update the record10AanvraagGegevensAlgemeen
        Record10AanvraagGegevensAlgemeen updatedRecord10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeenRepository.findById(record10AanvraagGegevensAlgemeen.getId()).get();
        // Disconnect from session so that the updates on updatedRecord10AanvraagGegevensAlgemeen are not directly saved in db
        em.detach(updatedRecord10AanvraagGegevensAlgemeen);
        updatedRecord10AanvraagGegevensAlgemeen
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .dealerNr(UPDATED_DEALER_NR)
            .productCode(UPDATED_PRODUCT_CODE)
            .zoeknaam(UPDATED_ZOEKNAAM)
            .verkoper(UPDATED_VERKOPER)
            .dealerTelnr(UPDATED_DEALER_TELNR)
            .acceptatie(UPDATED_ACCEPTATIE)
            .aanvangDatum(UPDATED_AANVANG_DATUM)
            .aanvangTijd(UPDATED_AANVANG_TIJD)
            .acceptatieDatum(UPDATED_ACCEPTATIE_DATUM)
            .acceptatieTijd(UPDATED_ACCEPTATIE_TIJD)
            .prtDatum(UPDATED_PRT_DATUM)
            .invoerder(UPDATED_INVOERDER)
            .acceptant(UPDATED_ACCEPTANT);
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO = record10AanvraagGegevensAlgemeenMapper.toDto(updatedRecord10AanvraagGegevensAlgemeen);

        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(put("/api/record-10-aanvraag-gegevens-algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record10AanvraagGegevensAlgemeenDTO)))
            .andExpect(status().isOk());

        // Validate the Record10AanvraagGegevensAlgemeen in the database
        List<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeenList = record10AanvraagGegevensAlgemeenRepository.findAll();
        assertThat(record10AanvraagGegevensAlgemeenList).hasSize(databaseSizeBeforeUpdate);
        Record10AanvraagGegevensAlgemeen testRecord10AanvraagGegevensAlgemeen = record10AanvraagGegevensAlgemeenList.get(record10AanvraagGegevensAlgemeenList.size() - 1);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getDealerNr()).isEqualTo(UPDATED_DEALER_NR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getProductCode()).isEqualTo(UPDATED_PRODUCT_CODE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getZoeknaam()).isEqualTo(UPDATED_ZOEKNAAM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getVerkoper()).isEqualTo(UPDATED_VERKOPER);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getDealerTelnr()).isEqualTo(UPDATED_DEALER_TELNR);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatie()).isEqualTo(UPDATED_ACCEPTATIE);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAanvangDatum()).isEqualTo(UPDATED_AANVANG_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAanvangTijd()).isEqualTo(UPDATED_AANVANG_TIJD);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatieDatum()).isEqualTo(UPDATED_ACCEPTATIE_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptatieTijd()).isEqualTo(UPDATED_ACCEPTATIE_TIJD);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getPrtDatum()).isEqualTo(UPDATED_PRT_DATUM);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getInvoerder()).isEqualTo(UPDATED_INVOERDER);
        assertThat(testRecord10AanvraagGegevensAlgemeen.getAcceptant()).isEqualTo(UPDATED_ACCEPTANT);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord10AanvraagGegevensAlgemeen() throws Exception {
        int databaseSizeBeforeUpdate = record10AanvraagGegevensAlgemeenRepository.findAll().size();

        // Create the Record10AanvraagGegevensAlgemeen
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO = record10AanvraagGegevensAlgemeenMapper.toDto(record10AanvraagGegevensAlgemeen);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(put("/api/record-10-aanvraag-gegevens-algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record10AanvraagGegevensAlgemeenDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record10AanvraagGegevensAlgemeen in the database
        List<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeenList = record10AanvraagGegevensAlgemeenRepository.findAll();
        assertThat(record10AanvraagGegevensAlgemeenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord10AanvraagGegevensAlgemeen() throws Exception {
        // Initialize the database
        record10AanvraagGegevensAlgemeenRepository.saveAndFlush(record10AanvraagGegevensAlgemeen);

        int databaseSizeBeforeDelete = record10AanvraagGegevensAlgemeenRepository.findAll().size();

        // Get the record10AanvraagGegevensAlgemeen
        restRecord10AanvraagGegevensAlgemeenMockMvc.perform(delete("/api/record-10-aanvraag-gegevens-algemeens/{id}", record10AanvraagGegevensAlgemeen.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record10AanvraagGegevensAlgemeen> record10AanvraagGegevensAlgemeenList = record10AanvraagGegevensAlgemeenRepository.findAll();
        assertThat(record10AanvraagGegevensAlgemeenList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record10AanvraagGegevensAlgemeen.class);
        Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen1 = new Record10AanvraagGegevensAlgemeen();
        record10AanvraagGegevensAlgemeen1.setId(1L);
        Record10AanvraagGegevensAlgemeen record10AanvraagGegevensAlgemeen2 = new Record10AanvraagGegevensAlgemeen();
        record10AanvraagGegevensAlgemeen2.setId(record10AanvraagGegevensAlgemeen1.getId());
        assertThat(record10AanvraagGegevensAlgemeen1).isEqualTo(record10AanvraagGegevensAlgemeen2);
        record10AanvraagGegevensAlgemeen2.setId(2L);
        assertThat(record10AanvraagGegevensAlgemeen1).isNotEqualTo(record10AanvraagGegevensAlgemeen2);
        record10AanvraagGegevensAlgemeen1.setId(null);
        assertThat(record10AanvraagGegevensAlgemeen1).isNotEqualTo(record10AanvraagGegevensAlgemeen2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record10AanvraagGegevensAlgemeenDTO.class);
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO1 = new Record10AanvraagGegevensAlgemeenDTO();
        record10AanvraagGegevensAlgemeenDTO1.setId(1L);
        Record10AanvraagGegevensAlgemeenDTO record10AanvraagGegevensAlgemeenDTO2 = new Record10AanvraagGegevensAlgemeenDTO();
        assertThat(record10AanvraagGegevensAlgemeenDTO1).isNotEqualTo(record10AanvraagGegevensAlgemeenDTO2);
        record10AanvraagGegevensAlgemeenDTO2.setId(record10AanvraagGegevensAlgemeenDTO1.getId());
        assertThat(record10AanvraagGegevensAlgemeenDTO1).isEqualTo(record10AanvraagGegevensAlgemeenDTO2);
        record10AanvraagGegevensAlgemeenDTO2.setId(2L);
        assertThat(record10AanvraagGegevensAlgemeenDTO1).isNotEqualTo(record10AanvraagGegevensAlgemeenDTO2);
        record10AanvraagGegevensAlgemeenDTO1.setId(null);
        assertThat(record10AanvraagGegevensAlgemeenDTO1).isNotEqualTo(record10AanvraagGegevensAlgemeenDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record10AanvraagGegevensAlgemeenMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record10AanvraagGegevensAlgemeenMapper.fromId(null)).isNull();
    }
}
