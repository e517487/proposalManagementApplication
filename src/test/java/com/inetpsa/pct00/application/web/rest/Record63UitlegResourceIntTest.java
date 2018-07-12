package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record63Uitleg;
import com.inetpsa.pct00.application.repository.Record63UitlegRepository;
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
 * Test class for the Record63UitlegResource REST controller.
 *
 * @see Record63UitlegResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record63UitlegResourceIntTest {

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
    private Record63UitlegRepository record63UitlegRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord63UitlegMockMvc;

    private Record63Uitleg record63Uitleg;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record63UitlegResource record63UitlegResource = new Record63UitlegResource(record63UitlegRepository);
        this.restRecord63UitlegMockMvc = MockMvcBuilders.standaloneSetup(record63UitlegResource)
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
    public static Record63Uitleg createEntity(EntityManager em) {
        Record63Uitleg record63Uitleg = new Record63Uitleg()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .rol(DEFAULT_ROL)
            .uitlegGezin(DEFAULT_UITLEG_GEZIN)
            .uitlegInkomsten(DEFAULT_UITLEG_INKOMSTEN)
            .uitlegInPlatform(DEFAULT_UITLEG_IN_PLATFORM);
        return record63Uitleg;
    }

    @Before
    public void initTest() {
        record63Uitleg = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord63Uitleg() throws Exception {
        int databaseSizeBeforeCreate = record63UitlegRepository.findAll().size();

        // Create the Record63Uitleg
        restRecord63UitlegMockMvc.perform(post("/api/record-63-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record63Uitleg)))
            .andExpect(status().isCreated());

        // Validate the Record63Uitleg in the database
        List<Record63Uitleg> record63UitlegList = record63UitlegRepository.findAll();
        assertThat(record63UitlegList).hasSize(databaseSizeBeforeCreate + 1);
        Record63Uitleg testRecord63Uitleg = record63UitlegList.get(record63UitlegList.size() - 1);
        assertThat(testRecord63Uitleg.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord63Uitleg.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord63Uitleg.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord63Uitleg.getRol()).isEqualTo(DEFAULT_ROL);
        assertThat(testRecord63Uitleg.getUitlegGezin()).isEqualTo(DEFAULT_UITLEG_GEZIN);
        assertThat(testRecord63Uitleg.getUitlegInkomsten()).isEqualTo(DEFAULT_UITLEG_INKOMSTEN);
        assertThat(testRecord63Uitleg.getUitlegInPlatform()).isEqualTo(DEFAULT_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void createRecord63UitlegWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record63UitlegRepository.findAll().size();

        // Create the Record63Uitleg with an existing ID
        record63Uitleg.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord63UitlegMockMvc.perform(post("/api/record-63-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record63Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record63Uitleg in the database
        List<Record63Uitleg> record63UitlegList = record63UitlegRepository.findAll();
        assertThat(record63UitlegList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord63Uitlegs() throws Exception {
        // Initialize the database
        record63UitlegRepository.saveAndFlush(record63Uitleg);

        // Get all the record63UitlegList
        restRecord63UitlegMockMvc.perform(get("/api/record-63-uitlegs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record63Uitleg.getId().intValue())))
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
    public void getRecord63Uitleg() throws Exception {
        // Initialize the database
        record63UitlegRepository.saveAndFlush(record63Uitleg);

        // Get the record63Uitleg
        restRecord63UitlegMockMvc.perform(get("/api/record-63-uitlegs/{id}", record63Uitleg.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record63Uitleg.getId().intValue()))
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
    public void getNonExistingRecord63Uitleg() throws Exception {
        // Get the record63Uitleg
        restRecord63UitlegMockMvc.perform(get("/api/record-63-uitlegs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord63Uitleg() throws Exception {
        // Initialize the database
        record63UitlegRepository.saveAndFlush(record63Uitleg);

        int databaseSizeBeforeUpdate = record63UitlegRepository.findAll().size();

        // Update the record63Uitleg
        Record63Uitleg updatedRecord63Uitleg = record63UitlegRepository.findById(record63Uitleg.getId()).get();
        // Disconnect from session so that the updates on updatedRecord63Uitleg are not directly saved in db
        em.detach(updatedRecord63Uitleg);
        updatedRecord63Uitleg
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .rol(UPDATED_ROL)
            .uitlegGezin(UPDATED_UITLEG_GEZIN)
            .uitlegInkomsten(UPDATED_UITLEG_INKOMSTEN)
            .uitlegInPlatform(UPDATED_UITLEG_IN_PLATFORM);

        restRecord63UitlegMockMvc.perform(put("/api/record-63-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord63Uitleg)))
            .andExpect(status().isOk());

        // Validate the Record63Uitleg in the database
        List<Record63Uitleg> record63UitlegList = record63UitlegRepository.findAll();
        assertThat(record63UitlegList).hasSize(databaseSizeBeforeUpdate);
        Record63Uitleg testRecord63Uitleg = record63UitlegList.get(record63UitlegList.size() - 1);
        assertThat(testRecord63Uitleg.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord63Uitleg.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord63Uitleg.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord63Uitleg.getRol()).isEqualTo(UPDATED_ROL);
        assertThat(testRecord63Uitleg.getUitlegGezin()).isEqualTo(UPDATED_UITLEG_GEZIN);
        assertThat(testRecord63Uitleg.getUitlegInkomsten()).isEqualTo(UPDATED_UITLEG_INKOMSTEN);
        assertThat(testRecord63Uitleg.getUitlegInPlatform()).isEqualTo(UPDATED_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord63Uitleg() throws Exception {
        int databaseSizeBeforeUpdate = record63UitlegRepository.findAll().size();

        // Create the Record63Uitleg

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord63UitlegMockMvc.perform(put("/api/record-63-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record63Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record63Uitleg in the database
        List<Record63Uitleg> record63UitlegList = record63UitlegRepository.findAll();
        assertThat(record63UitlegList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord63Uitleg() throws Exception {
        // Initialize the database
        record63UitlegRepository.saveAndFlush(record63Uitleg);

        int databaseSizeBeforeDelete = record63UitlegRepository.findAll().size();

        // Get the record63Uitleg
        restRecord63UitlegMockMvc.perform(delete("/api/record-63-uitlegs/{id}", record63Uitleg.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record63Uitleg> record63UitlegList = record63UitlegRepository.findAll();
        assertThat(record63UitlegList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record63Uitleg.class);
        Record63Uitleg record63Uitleg1 = new Record63Uitleg();
        record63Uitleg1.setId(1L);
        Record63Uitleg record63Uitleg2 = new Record63Uitleg();
        record63Uitleg2.setId(record63Uitleg1.getId());
        assertThat(record63Uitleg1).isEqualTo(record63Uitleg2);
        record63Uitleg2.setId(2L);
        assertThat(record63Uitleg1).isNotEqualTo(record63Uitleg2);
        record63Uitleg1.setId(null);
        assertThat(record63Uitleg1).isNotEqualTo(record63Uitleg2);
    }
}
