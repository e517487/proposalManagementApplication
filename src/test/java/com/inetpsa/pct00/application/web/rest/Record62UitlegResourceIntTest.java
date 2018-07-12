package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record62Uitleg;
import com.inetpsa.pct00.application.repository.Record62UitlegRepository;
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
 * Test class for the Record62UitlegResource REST controller.
 *
 * @see Record62UitlegResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record62UitlegResourceIntTest {

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
    private Record62UitlegRepository record62UitlegRepository;


    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord62UitlegMockMvc;

    private Record62Uitleg record62Uitleg;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record62UitlegResource record62UitlegResource = new Record62UitlegResource(record62UitlegRepository);
        this.restRecord62UitlegMockMvc = MockMvcBuilders.standaloneSetup(record62UitlegResource)
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
    public static Record62Uitleg createEntity(EntityManager em) {
        Record62Uitleg record62Uitleg = new Record62Uitleg()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .rol(DEFAULT_ROL)
            .uitlegGezin(DEFAULT_UITLEG_GEZIN)
            .uitlegInkomsten(DEFAULT_UITLEG_INKOMSTEN)
            .uitlegInPlatform(DEFAULT_UITLEG_IN_PLATFORM);
        return record62Uitleg;
    }

    @Before
    public void initTest() {
        record62Uitleg = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord62Uitleg() throws Exception {
        int databaseSizeBeforeCreate = record62UitlegRepository.findAll().size();

        // Create the Record62Uitleg
        restRecord62UitlegMockMvc.perform(post("/api/record-62-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record62Uitleg)))
            .andExpect(status().isCreated());

        // Validate the Record62Uitleg in the database
        List<Record62Uitleg> record62UitlegList = record62UitlegRepository.findAll();
        assertThat(record62UitlegList).hasSize(databaseSizeBeforeCreate + 1);
        Record62Uitleg testRecord62Uitleg = record62UitlegList.get(record62UitlegList.size() - 1);
        assertThat(testRecord62Uitleg.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord62Uitleg.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord62Uitleg.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord62Uitleg.getRol()).isEqualTo(DEFAULT_ROL);
        assertThat(testRecord62Uitleg.getUitlegGezin()).isEqualTo(DEFAULT_UITLEG_GEZIN);
        assertThat(testRecord62Uitleg.getUitlegInkomsten()).isEqualTo(DEFAULT_UITLEG_INKOMSTEN);
        assertThat(testRecord62Uitleg.getUitlegInPlatform()).isEqualTo(DEFAULT_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void createRecord62UitlegWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record62UitlegRepository.findAll().size();

        // Create the Record62Uitleg with an existing ID
        record62Uitleg.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord62UitlegMockMvc.perform(post("/api/record-62-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record62Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record62Uitleg in the database
        List<Record62Uitleg> record62UitlegList = record62UitlegRepository.findAll();
        assertThat(record62UitlegList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord62Uitlegs() throws Exception {
        // Initialize the database
        record62UitlegRepository.saveAndFlush(record62Uitleg);

        // Get all the record62UitlegList
        restRecord62UitlegMockMvc.perform(get("/api/record-62-uitlegs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record62Uitleg.getId().intValue())))
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
    public void getRecord62Uitleg() throws Exception {
        // Initialize the database
        record62UitlegRepository.saveAndFlush(record62Uitleg);

        // Get the record62Uitleg
        restRecord62UitlegMockMvc.perform(get("/api/record-62-uitlegs/{id}", record62Uitleg.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record62Uitleg.getId().intValue()))
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
    public void getNonExistingRecord62Uitleg() throws Exception {
        // Get the record62Uitleg
        restRecord62UitlegMockMvc.perform(get("/api/record-62-uitlegs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord62Uitleg() throws Exception {
        // Initialize the database
        record62UitlegRepository.saveAndFlush(record62Uitleg);

        int databaseSizeBeforeUpdate = record62UitlegRepository.findAll().size();

        // Update the record62Uitleg
        Record62Uitleg updatedRecord62Uitleg = record62UitlegRepository.findById(record62Uitleg.getId()).get();
        // Disconnect from session so that the updates on updatedRecord62Uitleg are not directly saved in db
        em.detach(updatedRecord62Uitleg);
        updatedRecord62Uitleg
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .rol(UPDATED_ROL)
            .uitlegGezin(UPDATED_UITLEG_GEZIN)
            .uitlegInkomsten(UPDATED_UITLEG_INKOMSTEN)
            .uitlegInPlatform(UPDATED_UITLEG_IN_PLATFORM);

        restRecord62UitlegMockMvc.perform(put("/api/record-62-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRecord62Uitleg)))
            .andExpect(status().isOk());

        // Validate the Record62Uitleg in the database
        List<Record62Uitleg> record62UitlegList = record62UitlegRepository.findAll();
        assertThat(record62UitlegList).hasSize(databaseSizeBeforeUpdate);
        Record62Uitleg testRecord62Uitleg = record62UitlegList.get(record62UitlegList.size() - 1);
        assertThat(testRecord62Uitleg.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord62Uitleg.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord62Uitleg.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord62Uitleg.getRol()).isEqualTo(UPDATED_ROL);
        assertThat(testRecord62Uitleg.getUitlegGezin()).isEqualTo(UPDATED_UITLEG_GEZIN);
        assertThat(testRecord62Uitleg.getUitlegInkomsten()).isEqualTo(UPDATED_UITLEG_INKOMSTEN);
        assertThat(testRecord62Uitleg.getUitlegInPlatform()).isEqualTo(UPDATED_UITLEG_IN_PLATFORM);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord62Uitleg() throws Exception {
        int databaseSizeBeforeUpdate = record62UitlegRepository.findAll().size();

        // Create the Record62Uitleg

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord62UitlegMockMvc.perform(put("/api/record-62-uitlegs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record62Uitleg)))
            .andExpect(status().isBadRequest());

        // Validate the Record62Uitleg in the database
        List<Record62Uitleg> record62UitlegList = record62UitlegRepository.findAll();
        assertThat(record62UitlegList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord62Uitleg() throws Exception {
        // Initialize the database
        record62UitlegRepository.saveAndFlush(record62Uitleg);

        int databaseSizeBeforeDelete = record62UitlegRepository.findAll().size();

        // Get the record62Uitleg
        restRecord62UitlegMockMvc.perform(delete("/api/record-62-uitlegs/{id}", record62Uitleg.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record62Uitleg> record62UitlegList = record62UitlegRepository.findAll();
        assertThat(record62UitlegList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record62Uitleg.class);
        Record62Uitleg record62Uitleg1 = new Record62Uitleg();
        record62Uitleg1.setId(1L);
        Record62Uitleg record62Uitleg2 = new Record62Uitleg();
        record62Uitleg2.setId(record62Uitleg1.getId());
        assertThat(record62Uitleg1).isEqualTo(record62Uitleg2);
        record62Uitleg2.setId(2L);
        assertThat(record62Uitleg1).isNotEqualTo(record62Uitleg2);
        record62Uitleg1.setId(null);
        assertThat(record62Uitleg1).isNotEqualTo(record62Uitleg2);
    }
}
