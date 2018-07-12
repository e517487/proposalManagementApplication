package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record25Herfinancieering;
import com.inetpsa.pct00.application.repository.Record25HerfinancieeringRepository;
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
 * Test class for the Record25HerfinancieeringResource REST controller.
 *
 * @see Record25HerfinancieeringResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record25HerfinancieeringResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record25HerfinancieeringRepository record25HerfinancieeringRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord25HerfinancieeringMockMvc;

    private Record25Herfinancieering record25Herfinancieering;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record25HerfinancieeringResource record25HerfinancieeringResource = new Record25HerfinancieeringResource(record25HerfinancieeringRepository);
        this.restRecord25HerfinancieeringMockMvc = MockMvcBuilders.standaloneSetup(record25HerfinancieeringResource)
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
    public static Record25Herfinancieering createEntity(EntityManager em) {
        Record25Herfinancieering record25Herfinancieering = new Record25Herfinancieering()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record25Herfinancieering;
    }

    @Before
    public void initTest() {
        record25Herfinancieering = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord25Herfinancieering() throws Exception {
        int databaseSizeBeforeCreate = record25HerfinancieeringRepository.findAll().size();

        // Create the Record25Herfinancieering
        restRecord25HerfinancieeringMockMvc.perform(post("/api/record-25-herfinancieerings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record25Herfinancieering)))
            .andExpect(status().isCreated());

        // Validate the Record25Herfinancieering in the database
        List<Record25Herfinancieering> record25HerfinancieeringList = record25HerfinancieeringRepository.findAll();
        assertThat(record25HerfinancieeringList).hasSize(databaseSizeBeforeCreate + 1);
        Record25Herfinancieering testRecord25Herfinancieering = record25HerfinancieeringList.get(record25HerfinancieeringList.size() - 1);
        assertThat(testRecord25Herfinancieering.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord25Herfinancieering.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord25Herfinancieering.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord25HerfinancieeringWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record25HerfinancieeringRepository.findAll().size();

        // Create the Record25Herfinancieering with an existing ID
        record25Herfinancieering.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord25HerfinancieeringMockMvc.perform(post("/api/record-25-herfinancieerings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record25Herfinancieering)))
            .andExpect(status().isBadRequest());

        // Validate the Record25Herfinancieering in the database
        List<Record25Herfinancieering> record25HerfinancieeringList = record25HerfinancieeringRepository.findAll();
        assertThat(record25HerfinancieeringList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord25Herfinancieerings() throws Exception {
        // Initialize the database
        record25HerfinancieeringRepository.saveAndFlush(record25Herfinancieering);

        // Get all the record25HerfinancieeringList
        restRecord25HerfinancieeringMockMvc.perform(get("/api/record-25-herfinancieerings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record25Herfinancieering.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord25Herfinancieering() throws Exception {
        // Initialize the database
        record25HerfinancieeringRepository.saveAndFlush(record25Herfinancieering);

        // Get the record25Herfinancieering
        restRecord25HerfinancieeringMockMvc.perform(get("/api/record-25-herfinancieerings/{id}", record25Herfinancieering.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record25Herfinancieering.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord25Herfinancieering() throws Exception {
        // Get the record25Herfinancieering
        restRecord25HerfinancieeringMockMvc.perform(get("/api/record-25-herfinancieerings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord25Herfinancieering() throws Exception {
        // Initialize the database
        record25HerfinancieeringRepository.saveAndFlush(record25Herfinancieering);

        int databaseSizeBeforeUpdate = record25HerfinancieeringRepository.findAll().size();

        // Update the record25Herfinancieering
        Record25Herfinancieering updatedRecord25Herfinancieering = record25HerfinancieeringRepository.findById(record25Herfinancieering.getId()).get();
        // Disconnect from session so that the updates on updatedRecord25Herfinancieering are not directly saved in db
        em.detach(updatedRecord25Herfinancieering);
        updatedRecord25Herfinancieering
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);

        restRecord25HerfinancieeringMockMvc.perform(put("/api/record-25-herfinancieerings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord25Herfinancieering)))
            .andExpect(status().isOk());

        // Validate the Record25Herfinancieering in the database
        List<Record25Herfinancieering> record25HerfinancieeringList = record25HerfinancieeringRepository.findAll();
        assertThat(record25HerfinancieeringList).hasSize(databaseSizeBeforeUpdate);
        Record25Herfinancieering testRecord25Herfinancieering = record25HerfinancieeringList.get(record25HerfinancieeringList.size() - 1);
        assertThat(testRecord25Herfinancieering.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord25Herfinancieering.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord25Herfinancieering.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord25Herfinancieering() throws Exception {
        int databaseSizeBeforeUpdate = record25HerfinancieeringRepository.findAll().size();

        // Create the Record25Herfinancieering

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord25HerfinancieeringMockMvc.perform(put("/api/record-25-herfinancieerings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record25Herfinancieering)))
            .andExpect(status().isBadRequest());

        // Validate the Record25Herfinancieering in the database
        List<Record25Herfinancieering> record25HerfinancieeringList = record25HerfinancieeringRepository.findAll();
        assertThat(record25HerfinancieeringList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord25Herfinancieering() throws Exception {
        // Initialize the database
        record25HerfinancieeringRepository.saveAndFlush(record25Herfinancieering);

        int databaseSizeBeforeDelete = record25HerfinancieeringRepository.findAll().size();

        // Get the record25Herfinancieering
        restRecord25HerfinancieeringMockMvc.perform(delete("/api/record-25-herfinancieerings/{id}", record25Herfinancieering.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record25Herfinancieering> record25HerfinancieeringList = record25HerfinancieeringRepository.findAll();
        assertThat(record25HerfinancieeringList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record25Herfinancieering.class);
        Record25Herfinancieering record25Herfinancieering1 = new Record25Herfinancieering();
        record25Herfinancieering1.setId(1L);
        Record25Herfinancieering record25Herfinancieering2 = new Record25Herfinancieering();
        record25Herfinancieering2.setId(record25Herfinancieering1.getId());
        assertThat(record25Herfinancieering1).isEqualTo(record25Herfinancieering2);
        record25Herfinancieering2.setId(2L);
        assertThat(record25Herfinancieering1).isNotEqualTo(record25Herfinancieering2);
        record25Herfinancieering1.setId(null);
        assertThat(record25Herfinancieering1).isNotEqualTo(record25Herfinancieering2);
    }
}
