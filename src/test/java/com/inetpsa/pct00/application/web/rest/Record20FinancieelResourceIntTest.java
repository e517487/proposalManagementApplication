package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record20Financieel;
import com.inetpsa.pct00.application.repository.Record20FinancieelRepository;
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
 * Test class for the Record20FinancieelResource REST controller.
 *
 * @see Record20FinancieelResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record20FinancieelResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record20FinancieelRepository record20FinancieelRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord20FinancieelMockMvc;

    private Record20Financieel record20Financieel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record20FinancieelResource record20FinancieelResource = new Record20FinancieelResource(record20FinancieelRepository);
        this.restRecord20FinancieelMockMvc = MockMvcBuilders.standaloneSetup(record20FinancieelResource)
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
    public static Record20Financieel createEntity(EntityManager em) {
        Record20Financieel record20Financieel = new Record20Financieel()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record20Financieel;
    }

    @Before
    public void initTest() {
        record20Financieel = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord20Financieel() throws Exception {
        int databaseSizeBeforeCreate = record20FinancieelRepository.findAll().size();

        // Create the Record20Financieel
        restRecord20FinancieelMockMvc.perform(post("/api/record-20-financieels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record20Financieel)))
            .andExpect(status().isCreated());

        // Validate the Record20Financieel in the database
        List<Record20Financieel> record20FinancieelList = record20FinancieelRepository.findAll();
        assertThat(record20FinancieelList).hasSize(databaseSizeBeforeCreate + 1);
        Record20Financieel testRecord20Financieel = record20FinancieelList.get(record20FinancieelList.size() - 1);
        assertThat(testRecord20Financieel.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord20Financieel.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord20Financieel.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord20FinancieelWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record20FinancieelRepository.findAll().size();

        // Create the Record20Financieel with an existing ID
        record20Financieel.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord20FinancieelMockMvc.perform(post("/api/record-20-financieels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record20Financieel)))
            .andExpect(status().isBadRequest());

        // Validate the Record20Financieel in the database
        List<Record20Financieel> record20FinancieelList = record20FinancieelRepository.findAll();
        assertThat(record20FinancieelList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord20Financieels() throws Exception {
        // Initialize the database
        record20FinancieelRepository.saveAndFlush(record20Financieel);

        // Get all the record20FinancieelList
        restRecord20FinancieelMockMvc.perform(get("/api/record-20-financieels?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record20Financieel.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord20Financieel() throws Exception {
        // Initialize the database
        record20FinancieelRepository.saveAndFlush(record20Financieel);

        // Get the record20Financieel
        restRecord20FinancieelMockMvc.perform(get("/api/record-20-financieels/{id}", record20Financieel.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record20Financieel.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord20Financieel() throws Exception {
        // Get the record20Financieel
        restRecord20FinancieelMockMvc.perform(get("/api/record-20-financieels/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord20Financieel() throws Exception {
        // Initialize the database
        record20FinancieelRepository.saveAndFlush(record20Financieel);

        int databaseSizeBeforeUpdate = record20FinancieelRepository.findAll().size();

        // Update the record20Financieel
        Record20Financieel updatedRecord20Financieel = record20FinancieelRepository.findById(record20Financieel.getId()).get();
        // Disconnect from session so that the updates on updatedRecord20Financieel are not directly saved in db
        em.detach(updatedRecord20Financieel);
        updatedRecord20Financieel
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);

        restRecord20FinancieelMockMvc.perform(put("/api/record-20-financieels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord20Financieel)))
            .andExpect(status().isOk());

        // Validate the Record20Financieel in the database
        List<Record20Financieel> record20FinancieelList = record20FinancieelRepository.findAll();
        assertThat(record20FinancieelList).hasSize(databaseSizeBeforeUpdate);
        Record20Financieel testRecord20Financieel = record20FinancieelList.get(record20FinancieelList.size() - 1);
        assertThat(testRecord20Financieel.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord20Financieel.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord20Financieel.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord20Financieel() throws Exception {
        int databaseSizeBeforeUpdate = record20FinancieelRepository.findAll().size();

        // Create the Record20Financieel

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord20FinancieelMockMvc.perform(put("/api/record-20-financieels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record20Financieel)))
            .andExpect(status().isBadRequest());

        // Validate the Record20Financieel in the database
        List<Record20Financieel> record20FinancieelList = record20FinancieelRepository.findAll();
        assertThat(record20FinancieelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord20Financieel() throws Exception {
        // Initialize the database
        record20FinancieelRepository.saveAndFlush(record20Financieel);

        int databaseSizeBeforeDelete = record20FinancieelRepository.findAll().size();

        // Get the record20Financieel
        restRecord20FinancieelMockMvc.perform(delete("/api/record-20-financieels/{id}", record20Financieel.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record20Financieel> record20FinancieelList = record20FinancieelRepository.findAll();
        assertThat(record20FinancieelList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record20Financieel.class);
        Record20Financieel record20Financieel1 = new Record20Financieel();
        record20Financieel1.setId(1L);
        Record20Financieel record20Financieel2 = new Record20Financieel();
        record20Financieel2.setId(record20Financieel1.getId());
        assertThat(record20Financieel1).isEqualTo(record20Financieel2);
        record20Financieel2.setId(2L);
        assertThat(record20Financieel1).isNotEqualTo(record20Financieel2);
        record20Financieel1.setId(null);
        assertThat(record20Financieel1).isNotEqualTo(record20Financieel2);
    }
}
