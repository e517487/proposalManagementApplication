package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record11AanvraagGegevensOpmerkingen;
import com.inetpsa.pct00.application.repository.Record11AanvraagGegevensOpmerkingenRepository;
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
 * Test class for the Record11AanvraagGegevensOpmerkingenResource REST controller.
 *
 * @see Record11AanvraagGegevensOpmerkingenResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record11AanvraagGegevensOpmerkingenResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record11AanvraagGegevensOpmerkingenRepository record11AanvraagGegevensOpmerkingenRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord11AanvraagGegevensOpmerkingenMockMvc;

    private Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record11AanvraagGegevensOpmerkingenResource record11AanvraagGegevensOpmerkingenResource = new Record11AanvraagGegevensOpmerkingenResource(record11AanvraagGegevensOpmerkingenRepository);
        this.restRecord11AanvraagGegevensOpmerkingenMockMvc = MockMvcBuilders.standaloneSetup(record11AanvraagGegevensOpmerkingenResource)
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
    public static Record11AanvraagGegevensOpmerkingen createEntity(EntityManager em) {
        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen = new Record11AanvraagGegevensOpmerkingen()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record11AanvraagGegevensOpmerkingen;
    }

    @Before
    public void initTest() {
        record11AanvraagGegevensOpmerkingen = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord11AanvraagGegevensOpmerkingen() throws Exception {
        int databaseSizeBeforeCreate = record11AanvraagGegevensOpmerkingenRepository.findAll().size();

        // Create the Record11AanvraagGegevensOpmerkingen
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(post("/api/record-11-aanvraag-gegevens-opmerkingens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record11AanvraagGegevensOpmerkingen)))
            .andExpect(status().isCreated());

        // Validate the Record11AanvraagGegevensOpmerkingen in the database
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingenList = record11AanvraagGegevensOpmerkingenRepository.findAll();
        assertThat(record11AanvraagGegevensOpmerkingenList).hasSize(databaseSizeBeforeCreate + 1);
        Record11AanvraagGegevensOpmerkingen testRecord11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenList.get(record11AanvraagGegevensOpmerkingenList.size() - 1);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord11AanvraagGegevensOpmerkingenWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record11AanvraagGegevensOpmerkingenRepository.findAll().size();

        // Create the Record11AanvraagGegevensOpmerkingen with an existing ID
        record11AanvraagGegevensOpmerkingen.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(post("/api/record-11-aanvraag-gegevens-opmerkingens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record11AanvraagGegevensOpmerkingen)))
            .andExpect(status().isBadRequest());

        // Validate the Record11AanvraagGegevensOpmerkingen in the database
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingenList = record11AanvraagGegevensOpmerkingenRepository.findAll();
        assertThat(record11AanvraagGegevensOpmerkingenList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord11AanvraagGegevensOpmerkingens() throws Exception {
        // Initialize the database
        record11AanvraagGegevensOpmerkingenRepository.saveAndFlush(record11AanvraagGegevensOpmerkingen);

        // Get all the record11AanvraagGegevensOpmerkingenList
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(get("/api/record-11-aanvraag-gegevens-opmerkingens?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record11AanvraagGegevensOpmerkingen.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord11AanvraagGegevensOpmerkingen() throws Exception {
        // Initialize the database
        record11AanvraagGegevensOpmerkingenRepository.saveAndFlush(record11AanvraagGegevensOpmerkingen);

        // Get the record11AanvraagGegevensOpmerkingen
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(get("/api/record-11-aanvraag-gegevens-opmerkingens/{id}", record11AanvraagGegevensOpmerkingen.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record11AanvraagGegevensOpmerkingen.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord11AanvraagGegevensOpmerkingen() throws Exception {
        // Get the record11AanvraagGegevensOpmerkingen
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(get("/api/record-11-aanvraag-gegevens-opmerkingens/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord11AanvraagGegevensOpmerkingen() throws Exception {
        // Initialize the database
        record11AanvraagGegevensOpmerkingenRepository.saveAndFlush(record11AanvraagGegevensOpmerkingen);

        int databaseSizeBeforeUpdate = record11AanvraagGegevensOpmerkingenRepository.findAll().size();

        // Update the record11AanvraagGegevensOpmerkingen
        Record11AanvraagGegevensOpmerkingen updatedRecord11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenRepository.findById(record11AanvraagGegevensOpmerkingen.getId()).get();
        // Disconnect from session so that the updates on updatedRecord11AanvraagGegevensOpmerkingen are not directly saved in db
        em.detach(updatedRecord11AanvraagGegevensOpmerkingen);
        updatedRecord11AanvraagGegevensOpmerkingen
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);

        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(put("/api/record-11-aanvraag-gegevens-opmerkingens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord11AanvraagGegevensOpmerkingen)))
            .andExpect(status().isOk());

        // Validate the Record11AanvraagGegevensOpmerkingen in the database
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingenList = record11AanvraagGegevensOpmerkingenRepository.findAll();
        assertThat(record11AanvraagGegevensOpmerkingenList).hasSize(databaseSizeBeforeUpdate);
        Record11AanvraagGegevensOpmerkingen testRecord11AanvraagGegevensOpmerkingen = record11AanvraagGegevensOpmerkingenList.get(record11AanvraagGegevensOpmerkingenList.size() - 1);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord11AanvraagGegevensOpmerkingen.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord11AanvraagGegevensOpmerkingen() throws Exception {
        int databaseSizeBeforeUpdate = record11AanvraagGegevensOpmerkingenRepository.findAll().size();

        // Create the Record11AanvraagGegevensOpmerkingen

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(put("/api/record-11-aanvraag-gegevens-opmerkingens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record11AanvraagGegevensOpmerkingen)))
            .andExpect(status().isBadRequest());

        // Validate the Record11AanvraagGegevensOpmerkingen in the database
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingenList = record11AanvraagGegevensOpmerkingenRepository.findAll();
        assertThat(record11AanvraagGegevensOpmerkingenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord11AanvraagGegevensOpmerkingen() throws Exception {
        // Initialize the database
        record11AanvraagGegevensOpmerkingenRepository.saveAndFlush(record11AanvraagGegevensOpmerkingen);

        int databaseSizeBeforeDelete = record11AanvraagGegevensOpmerkingenRepository.findAll().size();

        // Get the record11AanvraagGegevensOpmerkingen
        restRecord11AanvraagGegevensOpmerkingenMockMvc.perform(delete("/api/record-11-aanvraag-gegevens-opmerkingens/{id}", record11AanvraagGegevensOpmerkingen.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record11AanvraagGegevensOpmerkingen> record11AanvraagGegevensOpmerkingenList = record11AanvraagGegevensOpmerkingenRepository.findAll();
        assertThat(record11AanvraagGegevensOpmerkingenList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record11AanvraagGegevensOpmerkingen.class);
        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen1 = new Record11AanvraagGegevensOpmerkingen();
        record11AanvraagGegevensOpmerkingen1.setId(1L);
        Record11AanvraagGegevensOpmerkingen record11AanvraagGegevensOpmerkingen2 = new Record11AanvraagGegevensOpmerkingen();
        record11AanvraagGegevensOpmerkingen2.setId(record11AanvraagGegevensOpmerkingen1.getId());
        assertThat(record11AanvraagGegevensOpmerkingen1).isEqualTo(record11AanvraagGegevensOpmerkingen2);
        record11AanvraagGegevensOpmerkingen2.setId(2L);
        assertThat(record11AanvraagGegevensOpmerkingen1).isNotEqualTo(record11AanvraagGegevensOpmerkingen2);
        record11AanvraagGegevensOpmerkingen1.setId(null);
        assertThat(record11AanvraagGegevensOpmerkingen1).isNotEqualTo(record11AanvraagGegevensOpmerkingen2);
    }
}
