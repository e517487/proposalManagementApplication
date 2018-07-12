package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record30Inruil;
import com.inetpsa.pct00.application.repository.Record30InruilRepository;
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
 * Test class for the Record30InruilResource REST controller.
 *
 * @see Record30InruilResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record30InruilResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record30InruilRepository record30InruilRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord30InruilMockMvc;

    private Record30Inruil record30Inruil;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record30InruilResource record30InruilResource = new Record30InruilResource(record30InruilRepository);
        this.restRecord30InruilMockMvc = MockMvcBuilders.standaloneSetup(record30InruilResource)
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
    public static Record30Inruil createEntity(EntityManager em) {
        Record30Inruil record30Inruil = new Record30Inruil()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record30Inruil;
    }

    @Before
    public void initTest() {
        record30Inruil = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord30Inruil() throws Exception {
        int databaseSizeBeforeCreate = record30InruilRepository.findAll().size();

        // Create the Record30Inruil
        restRecord30InruilMockMvc.perform(post("/api/record-30-inruils")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record30Inruil)))
            .andExpect(status().isCreated());

        // Validate the Record30Inruil in the database
        List<Record30Inruil> record30InruilList = record30InruilRepository.findAll();
        assertThat(record30InruilList).hasSize(databaseSizeBeforeCreate + 1);
        Record30Inruil testRecord30Inruil = record30InruilList.get(record30InruilList.size() - 1);
        assertThat(testRecord30Inruil.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord30Inruil.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord30Inruil.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord30InruilWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record30InruilRepository.findAll().size();

        // Create the Record30Inruil with an existing ID
        record30Inruil.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord30InruilMockMvc.perform(post("/api/record-30-inruils")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record30Inruil)))
            .andExpect(status().isBadRequest());

        // Validate the Record30Inruil in the database
        List<Record30Inruil> record30InruilList = record30InruilRepository.findAll();
        assertThat(record30InruilList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord30Inruils() throws Exception {
        // Initialize the database
        record30InruilRepository.saveAndFlush(record30Inruil);

        // Get all the record30InruilList
        restRecord30InruilMockMvc.perform(get("/api/record-30-inruils?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record30Inruil.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord30Inruil() throws Exception {
        // Initialize the database
        record30InruilRepository.saveAndFlush(record30Inruil);

        // Get the record30Inruil
        restRecord30InruilMockMvc.perform(get("/api/record-30-inruils/{id}", record30Inruil.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record30Inruil.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord30Inruil() throws Exception {
        // Get the record30Inruil
        restRecord30InruilMockMvc.perform(get("/api/record-30-inruils/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord30Inruil() throws Exception {
        // Initialize the database
        record30InruilRepository.saveAndFlush(record30Inruil);

        int databaseSizeBeforeUpdate = record30InruilRepository.findAll().size();

        // Update the record30Inruil
        Record30Inruil updatedRecord30Inruil = record30InruilRepository.findById(record30Inruil.getId()).get();
        // Disconnect from session so that the updates on updatedRecord30Inruil are not directly saved in db
        em.detach(updatedRecord30Inruil);
        updatedRecord30Inruil
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);

        restRecord30InruilMockMvc.perform(put("/api/record-30-inruils")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord30Inruil)))
            .andExpect(status().isOk());

        // Validate the Record30Inruil in the database
        List<Record30Inruil> record30InruilList = record30InruilRepository.findAll();
        assertThat(record30InruilList).hasSize(databaseSizeBeforeUpdate);
        Record30Inruil testRecord30Inruil = record30InruilList.get(record30InruilList.size() - 1);
        assertThat(testRecord30Inruil.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord30Inruil.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord30Inruil.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord30Inruil() throws Exception {
        int databaseSizeBeforeUpdate = record30InruilRepository.findAll().size();

        // Create the Record30Inruil

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord30InruilMockMvc.perform(put("/api/record-30-inruils")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record30Inruil)))
            .andExpect(status().isBadRequest());

        // Validate the Record30Inruil in the database
        List<Record30Inruil> record30InruilList = record30InruilRepository.findAll();
        assertThat(record30InruilList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord30Inruil() throws Exception {
        // Initialize the database
        record30InruilRepository.saveAndFlush(record30Inruil);

        int databaseSizeBeforeDelete = record30InruilRepository.findAll().size();

        // Get the record30Inruil
        restRecord30InruilMockMvc.perform(delete("/api/record-30-inruils/{id}", record30Inruil.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record30Inruil> record30InruilList = record30InruilRepository.findAll();
        assertThat(record30InruilList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record30Inruil.class);
        Record30Inruil record30Inruil1 = new Record30Inruil();
        record30Inruil1.setId(1L);
        Record30Inruil record30Inruil2 = new Record30Inruil();
        record30Inruil2.setId(record30Inruil1.getId());
        assertThat(record30Inruil1).isEqualTo(record30Inruil2);
        record30Inruil2.setId(2L);
        assertThat(record30Inruil1).isNotEqualTo(record30Inruil2);
        record30Inruil1.setId(null);
        assertThat(record30Inruil1).isNotEqualTo(record30Inruil2);
    }
}
