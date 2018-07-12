package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record99Eind;
import com.inetpsa.pct00.application.repository.Record99EindRepository;
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
 * Test class for the Record99EindResource REST controller.
 *
 * @see Record99EindResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record99EindResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    private static final LocalDate DEFAULT_CREATIE_DATUM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATIE_DATUM = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_CREATIE_TIJD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATIE_TIJD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Integer DEFAULT_AANTAL_AANVRAGEN = 1;
    private static final Integer UPDATED_AANTAL_AANVRAGEN = 2;

    private static final Integer DEFAULT_AANTAL_REGELS = 1;
    private static final Integer UPDATED_AANTAL_REGELS = 2;

    @Autowired
    private Record99EindRepository record99EindRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord99EindMockMvc;

    private Record99Eind record99Eind;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record99EindResource record99EindResource = new Record99EindResource(record99EindRepository);
        this.restRecord99EindMockMvc = MockMvcBuilders.standaloneSetup(record99EindResource)
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
    public static Record99Eind createEntity(EntityManager em) {
        Record99Eind record99Eind = new Record99Eind()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .creatieDatum(DEFAULT_CREATIE_DATUM)
            .creatieTijd(DEFAULT_CREATIE_TIJD)
            .aantalAanvragen(DEFAULT_AANTAL_AANVRAGEN)
            .aantalRegels(DEFAULT_AANTAL_REGELS);
        return record99Eind;
    }

    @Before
    public void initTest() {
        record99Eind = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord99Eind() throws Exception {
        int databaseSizeBeforeCreate = record99EindRepository.findAll().size();

        // Create the Record99Eind
        restRecord99EindMockMvc.perform(post("/api/record-99-einds")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99Eind)))
            .andExpect(status().isCreated());

        // Validate the Record99Eind in the database
        List<Record99Eind> record99EindList = record99EindRepository.findAll();
        assertThat(record99EindList).hasSize(databaseSizeBeforeCreate + 1);
        Record99Eind testRecord99Eind = record99EindList.get(record99EindList.size() - 1);
        assertThat(testRecord99Eind.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord99Eind.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord99Eind.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord99Eind.getCreatieDatum()).isEqualTo(DEFAULT_CREATIE_DATUM);
        assertThat(testRecord99Eind.getCreatieTijd()).isEqualTo(DEFAULT_CREATIE_TIJD);
        assertThat(testRecord99Eind.getAantalAanvragen()).isEqualTo(DEFAULT_AANTAL_AANVRAGEN);
        assertThat(testRecord99Eind.getAantalRegels()).isEqualTo(DEFAULT_AANTAL_REGELS);
    }

    @Test
    @Transactional
    public void createRecord99EindWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record99EindRepository.findAll().size();

        // Create the Record99Eind with an existing ID
        record99Eind.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord99EindMockMvc.perform(post("/api/record-99-einds")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99Eind)))
            .andExpect(status().isBadRequest());

        // Validate the Record99Eind in the database
        List<Record99Eind> record99EindList = record99EindRepository.findAll();
        assertThat(record99EindList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord99Einds() throws Exception {
        // Initialize the database
        record99EindRepository.saveAndFlush(record99Eind);

        // Get all the record99EindList
        restRecord99EindMockMvc.perform(get("/api/record-99-einds?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record99Eind.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)))
            .andExpect(jsonPath("$.[*].creatieDatum").value(hasItem(DEFAULT_CREATIE_DATUM.toString())))
            .andExpect(jsonPath("$.[*].creatieTijd").value(hasItem(sameInstant(DEFAULT_CREATIE_TIJD))))
            .andExpect(jsonPath("$.[*].aantalAanvragen").value(hasItem(DEFAULT_AANTAL_AANVRAGEN)))
            .andExpect(jsonPath("$.[*].aantalRegels").value(hasItem(DEFAULT_AANTAL_REGELS)));
    }
    

    @Test
    @Transactional
    public void getRecord99Eind() throws Exception {
        // Initialize the database
        record99EindRepository.saveAndFlush(record99Eind);

        // Get the record99Eind
        restRecord99EindMockMvc.perform(get("/api/record-99-einds/{id}", record99Eind.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record99Eind.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR))
            .andExpect(jsonPath("$.creatieDatum").value(DEFAULT_CREATIE_DATUM.toString()))
            .andExpect(jsonPath("$.creatieTijd").value(sameInstant(DEFAULT_CREATIE_TIJD)))
            .andExpect(jsonPath("$.aantalAanvragen").value(DEFAULT_AANTAL_AANVRAGEN))
            .andExpect(jsonPath("$.aantalRegels").value(DEFAULT_AANTAL_REGELS));
    }
    @Test
    @Transactional
    public void getNonExistingRecord99Eind() throws Exception {
        // Get the record99Eind
        restRecord99EindMockMvc.perform(get("/api/record-99-einds/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord99Eind() throws Exception {
        // Initialize the database
        record99EindRepository.saveAndFlush(record99Eind);

        int databaseSizeBeforeUpdate = record99EindRepository.findAll().size();

        // Update the record99Eind
        Record99Eind updatedRecord99Eind = record99EindRepository.findById(record99Eind.getId()).get();
        // Disconnect from session so that the updates on updatedRecord99Eind are not directly saved in db
        em.detach(updatedRecord99Eind);
        updatedRecord99Eind
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .creatieDatum(UPDATED_CREATIE_DATUM)
            .creatieTijd(UPDATED_CREATIE_TIJD)
            .aantalAanvragen(UPDATED_AANTAL_AANVRAGEN)
            .aantalRegels(UPDATED_AANTAL_REGELS);

        restRecord99EindMockMvc.perform(put("/api/record-99-einds")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord99Eind)))
            .andExpect(status().isOk());

        // Validate the Record99Eind in the database
        List<Record99Eind> record99EindList = record99EindRepository.findAll();
        assertThat(record99EindList).hasSize(databaseSizeBeforeUpdate);
        Record99Eind testRecord99Eind = record99EindList.get(record99EindList.size() - 1);
        assertThat(testRecord99Eind.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord99Eind.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord99Eind.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord99Eind.getCreatieDatum()).isEqualTo(UPDATED_CREATIE_DATUM);
        assertThat(testRecord99Eind.getCreatieTijd()).isEqualTo(UPDATED_CREATIE_TIJD);
        assertThat(testRecord99Eind.getAantalAanvragen()).isEqualTo(UPDATED_AANTAL_AANVRAGEN);
        assertThat(testRecord99Eind.getAantalRegels()).isEqualTo(UPDATED_AANTAL_REGELS);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord99Eind() throws Exception {
        int databaseSizeBeforeUpdate = record99EindRepository.findAll().size();

        // Create the Record99Eind

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord99EindMockMvc.perform(put("/api/record-99-einds")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99Eind)))
            .andExpect(status().isBadRequest());

        // Validate the Record99Eind in the database
        List<Record99Eind> record99EindList = record99EindRepository.findAll();
        assertThat(record99EindList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord99Eind() throws Exception {
        // Initialize the database
        record99EindRepository.saveAndFlush(record99Eind);

        int databaseSizeBeforeDelete = record99EindRepository.findAll().size();

        // Get the record99Eind
        restRecord99EindMockMvc.perform(delete("/api/record-99-einds/{id}", record99Eind.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record99Eind> record99EindList = record99EindRepository.findAll();
        assertThat(record99EindList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record99Eind.class);
        Record99Eind record99Eind1 = new Record99Eind();
        record99Eind1.setId(1L);
        Record99Eind record99Eind2 = new Record99Eind();
        record99Eind2.setId(record99Eind1.getId());
        assertThat(record99Eind1).isEqualTo(record99Eind2);
        record99Eind2.setId(2L);
        assertThat(record99Eind1).isNotEqualTo(record99Eind2);
        record99Eind1.setId(null);
        assertThat(record99Eind1).isNotEqualTo(record99Eind2);
    }
}
