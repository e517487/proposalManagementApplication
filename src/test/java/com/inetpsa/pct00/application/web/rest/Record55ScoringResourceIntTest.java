package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record55Scoring;
import com.inetpsa.pct00.application.repository.Record55ScoringRepository;
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
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the Record55ScoringResource REST controller.
 *
 * @see Record55ScoringResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record55ScoringResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record55ScoringRepository record55ScoringRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord55ScoringMockMvc;

    private Record55Scoring record55Scoring;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record55ScoringResource record55ScoringResource = new Record55ScoringResource(record55ScoringRepository);
        this.restRecord55ScoringMockMvc = MockMvcBuilders.standaloneSetup(record55ScoringResource)
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
    public static Record55Scoring createEntity(EntityManager em) {
        Record55Scoring record55Scoring = new Record55Scoring()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record55Scoring;
    }

    @Before
    public void initTest() {
        record55Scoring = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord55Scoring() throws Exception {
        int databaseSizeBeforeCreate = record55ScoringRepository.findAll().size();

        // Create the Record55Scoring
        restRecord55ScoringMockMvc.perform(post("/api/record-55-scorings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record55Scoring)))
            .andExpect(status().isCreated());

        // Validate the Record55Scoring in the database
        List<Record55Scoring> record55ScoringList = record55ScoringRepository.findAll();
        assertThat(record55ScoringList).hasSize(databaseSizeBeforeCreate + 1);
        Record55Scoring testRecord55Scoring = record55ScoringList.get(record55ScoringList.size() - 1);
        assertThat(testRecord55Scoring.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord55Scoring.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord55Scoring.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord55ScoringWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record55ScoringRepository.findAll().size();

        // Create the Record55Scoring with an existing ID
        record55Scoring.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord55ScoringMockMvc.perform(post("/api/record-55-scorings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record55Scoring)))
            .andExpect(status().isBadRequest());

        // Validate the Record55Scoring in the database
        List<Record55Scoring> record55ScoringList = record55ScoringRepository.findAll();
        assertThat(record55ScoringList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord55Scorings() throws Exception {
        // Initialize the database
        record55ScoringRepository.saveAndFlush(record55Scoring);

        // Get all the record55ScoringList
        restRecord55ScoringMockMvc.perform(get("/api/record-55-scorings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record55Scoring.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord55Scoring() throws Exception {
        // Initialize the database
        record55ScoringRepository.saveAndFlush(record55Scoring);

        // Get the record55Scoring
        restRecord55ScoringMockMvc.perform(get("/api/record-55-scorings/{id}", record55Scoring.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record55Scoring.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord55Scoring() throws Exception {
        // Get the record55Scoring
        restRecord55ScoringMockMvc.perform(get("/api/record-55-scorings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord55Scoring() throws Exception {
        // Initialize the database
        record55ScoringRepository.saveAndFlush(record55Scoring);

        int databaseSizeBeforeUpdate = record55ScoringRepository.findAll().size();

        // Update the record55Scoring
        Record55Scoring updatedRecord55Scoring = record55ScoringRepository.findById(record55Scoring.getId()).get();
        // Disconnect from session so that the updates on updatedRecord55Scoring are not directly saved in db
        em.detach(updatedRecord55Scoring);
        updatedRecord55Scoring
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);

        restRecord55ScoringMockMvc.perform(put("/api/record-55-scorings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord55Scoring)))
            .andExpect(status().isOk());

        // Validate the Record55Scoring in the database
        List<Record55Scoring> record55ScoringList = record55ScoringRepository.findAll();
        assertThat(record55ScoringList).hasSize(databaseSizeBeforeUpdate);
        Record55Scoring testRecord55Scoring = record55ScoringList.get(record55ScoringList.size() - 1);
        assertThat(testRecord55Scoring.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord55Scoring.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord55Scoring.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord55Scoring() throws Exception {
        int databaseSizeBeforeUpdate = record55ScoringRepository.findAll().size();

        // Create the Record55Scoring

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord55ScoringMockMvc.perform(put("/api/record-55-scorings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record55Scoring)))
            .andExpect(status().isBadRequest());

        // Validate the Record55Scoring in the database
        List<Record55Scoring> record55ScoringList = record55ScoringRepository.findAll();
        assertThat(record55ScoringList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord55Scoring() throws Exception {
        // Initialize the database
        record55ScoringRepository.saveAndFlush(record55Scoring);

        int databaseSizeBeforeDelete = record55ScoringRepository.findAll().size();

        // Get the record55Scoring
        restRecord55ScoringMockMvc.perform(delete("/api/record-55-scorings/{id}", record55Scoring.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record55Scoring> record55ScoringList = record55ScoringRepository.findAll();
        assertThat(record55ScoringList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record55Scoring.class);
        Record55Scoring record55Scoring1 = new Record55Scoring();
        record55Scoring1.setId(1L);
        Record55Scoring record55Scoring2 = new Record55Scoring();
        record55Scoring2.setId(record55Scoring1.getId());
        assertThat(record55Scoring1).isEqualTo(record55Scoring2);
        record55Scoring2.setId(2L);
        assertThat(record55Scoring1).isNotEqualTo(record55Scoring2);
        record55Scoring1.setId(null);
        assertThat(record55Scoring1).isNotEqualTo(record55Scoring2);
    }
}
