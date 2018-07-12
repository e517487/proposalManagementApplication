package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record61Uitleg;
import com.inetpsa.pct00.application.repository.Record61UitlegRepository;
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
 * Test class for the Record61UitlegResource REST controller.
 *
 * @see Record61UitlegResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record61UitlegResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    private static final String DEFAULT_ROL = "AAAAAAAAAA";
    private static final String UPDATED_ROL = "BBBBBBBBBB";

    private static final String DEFAULT_UITLEG_GEZIN = "AAAAAAAAAA";
    private static final String UPDATED_UITLEG_GEZIN = "BBBBBBBBBB";

    private static final String DEFAULT_UITLEG_INKOMSTEN = "AAAAAAAAAA";
    private static final String UPDATED_UITLEG_INKOMSTEN = "BBBBBBBBBB";

    private static final String DEFAULT_UITLEG_IN_PLATFORM = "AAAAAAAAAA";
    private static final String UPDATED_UITLEG_IN_PLATFORM = "BBBBBBBBBB";

    @Autowired
    private Record61UitlegRepository record61UitlegRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord61UitlegMockMvc;

    private Record61Uitleg record61Uitleg;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record61UitlegResource record61UitlegResource = new Record61UitlegResource(record61UitlegRepository);
        this.restRecord61UitlegMockMvc = MockMvcBuilders.standaloneSetup(record61UitlegResource)
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
    public static Record61Uitleg createEntity(EntityManager em) {
        Record61Uitleg record61Uitleg = new Record61Uitleg()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .rol(DEFAULT_ROL)
            .uitlegGezin(DEFAULT_UITLEG_GEZIN)
            .uitlegInkomsten(DEFAULT_UITLEG_INKOMSTEN)
            .uitlegInPlatform(DEFAULT_UITLEG_IN_PLATFORM);
        return record61Uitleg;
    }

    @Before
    public void initTest() {
        record61Uitleg = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord61Uitleg() throws Exception {
        int databaseSizeBeforeCreate = record61UitlegRepository.findAll().size();

        // Create the Record61Uitleg
        restRecord61UitlegMockMvc.perform(post("/api/record-61-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record61Uitleg)))
            .andExpect(status().isCreated());

        // Validate the Record61Uitleg in the database
        List<Record61Uitleg> record61UitlegList = record61UitlegRepository.findAll();
        assertThat(record61UitlegList).hasSize(databaseSizeBeforeCreate + 1);
        Record61Uitleg testRecord61Uitleg = record61UitlegList.get(record61UitlegList.size() - 1);
        assertThat(testRecord61Uitleg.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord61Uitleg.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord61Uitleg.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord61Uitleg.getRol()).isEqualTo(DEFAULT_ROL);
        assertThat(testRecord61Uitleg.getUitlegGezin()).isEqualTo(DEFAULT_UITLEG_GEZIN);
        assertThat(testRecord61Uitleg.getUitlegInkomsten()).isEqualTo(DEFAULT_UITLEG_INKOMSTEN);
        assertThat(testRecord61Uitleg.getUitlegInPlatform()).isEqualTo(DEFAULT_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void createRecord61UitlegWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record61UitlegRepository.findAll().size();

        // Create the Record61Uitleg with an existing ID
        record61Uitleg.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord61UitlegMockMvc.perform(post("/api/record-61-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record61Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record61Uitleg in the database
        List<Record61Uitleg> record61UitlegList = record61UitlegRepository.findAll();
        assertThat(record61UitlegList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord61Uitlegs() throws Exception {
        // Initialize the database
        record61UitlegRepository.saveAndFlush(record61Uitleg);

        // Get all the record61UitlegList
        restRecord61UitlegMockMvc.perform(get("/api/record-61-uitlegs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record61Uitleg.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)))
            .andExpect(jsonPath("$.[*].rol").value(hasItem(DEFAULT_ROL.toString())))
            .andExpect(jsonPath("$.[*].uitlegGezin").value(hasItem(DEFAULT_UITLEG_GEZIN.toString())))
            .andExpect(jsonPath("$.[*].uitlegInkomsten").value(hasItem(DEFAULT_UITLEG_INKOMSTEN.toString())))
            .andExpect(jsonPath("$.[*].uitlegInPlatform").value(hasItem(DEFAULT_UITLEG_IN_PLATFORM.toString())));
    }
    

    @Test
    @Transactional
    public void getRecord61Uitleg() throws Exception {
        // Initialize the database
        record61UitlegRepository.saveAndFlush(record61Uitleg);

        // Get the record61Uitleg
        restRecord61UitlegMockMvc.perform(get("/api/record-61-uitlegs/{id}", record61Uitleg.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record61Uitleg.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR))
            .andExpect(jsonPath("$.rol").value(DEFAULT_ROL.toString()))
            .andExpect(jsonPath("$.uitlegGezin").value(DEFAULT_UITLEG_GEZIN.toString()))
            .andExpect(jsonPath("$.uitlegInkomsten").value(DEFAULT_UITLEG_INKOMSTEN.toString()))
            .andExpect(jsonPath("$.uitlegInPlatform").value(DEFAULT_UITLEG_IN_PLATFORM.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingRecord61Uitleg() throws Exception {
        // Get the record61Uitleg
        restRecord61UitlegMockMvc.perform(get("/api/record-61-uitlegs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord61Uitleg() throws Exception {
        // Initialize the database
        record61UitlegRepository.saveAndFlush(record61Uitleg);

        int databaseSizeBeforeUpdate = record61UitlegRepository.findAll().size();

        // Update the record61Uitleg
        Record61Uitleg updatedRecord61Uitleg = record61UitlegRepository.findById(record61Uitleg.getId()).get();
        // Disconnect from session so that the updates on updatedRecord61Uitleg are not directly saved in db
        em.detach(updatedRecord61Uitleg);
        updatedRecord61Uitleg
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .rol(UPDATED_ROL)
            .uitlegGezin(UPDATED_UITLEG_GEZIN)
            .uitlegInkomsten(UPDATED_UITLEG_INKOMSTEN)
            .uitlegInPlatform(UPDATED_UITLEG_IN_PLATFORM);

        restRecord61UitlegMockMvc.perform(put("/api/record-61-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord61Uitleg)))
            .andExpect(status().isOk());

        // Validate the Record61Uitleg in the database
        List<Record61Uitleg> record61UitlegList = record61UitlegRepository.findAll();
        assertThat(record61UitlegList).hasSize(databaseSizeBeforeUpdate);
        Record61Uitleg testRecord61Uitleg = record61UitlegList.get(record61UitlegList.size() - 1);
        assertThat(testRecord61Uitleg.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord61Uitleg.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord61Uitleg.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord61Uitleg.getRol()).isEqualTo(UPDATED_ROL);
        assertThat(testRecord61Uitleg.getUitlegGezin()).isEqualTo(UPDATED_UITLEG_GEZIN);
        assertThat(testRecord61Uitleg.getUitlegInkomsten()).isEqualTo(UPDATED_UITLEG_INKOMSTEN);
        assertThat(testRecord61Uitleg.getUitlegInPlatform()).isEqualTo(UPDATED_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord61Uitleg() throws Exception {
        int databaseSizeBeforeUpdate = record61UitlegRepository.findAll().size();

        // Create the Record61Uitleg

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord61UitlegMockMvc.perform(put("/api/record-61-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record61Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record61Uitleg in the database
        List<Record61Uitleg> record61UitlegList = record61UitlegRepository.findAll();
        assertThat(record61UitlegList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord61Uitleg() throws Exception {
        // Initialize the database
        record61UitlegRepository.saveAndFlush(record61Uitleg);

        int databaseSizeBeforeDelete = record61UitlegRepository.findAll().size();

        // Get the record61Uitleg
        restRecord61UitlegMockMvc.perform(delete("/api/record-61-uitlegs/{id}", record61Uitleg.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record61Uitleg> record61UitlegList = record61UitlegRepository.findAll();
        assertThat(record61UitlegList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record61Uitleg.class);
        Record61Uitleg record61Uitleg1 = new Record61Uitleg();
        record61Uitleg1.setId(1L);
        Record61Uitleg record61Uitleg2 = new Record61Uitleg();
        record61Uitleg2.setId(record61Uitleg1.getId());
        assertThat(record61Uitleg1).isEqualTo(record61Uitleg2);
        record61Uitleg2.setId(2L);
        assertThat(record61Uitleg1).isNotEqualTo(record61Uitleg2);
        record61Uitleg1.setId(null);
        assertThat(record61Uitleg1).isNotEqualTo(record61Uitleg2);
    }
}
