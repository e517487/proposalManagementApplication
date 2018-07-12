package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record01Start;
import com.inetpsa.pct00.application.repository.Record01StartRepository;
import com.inetpsa.pct00.application.service.dto.Record01StartDTO;
import com.inetpsa.pct00.application.service.mapper.Record01StartMapper;
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
 * Test class for the Record01StartResource REST controller.
 *
 * @see Record01StartResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record01StartResourceIntTest {

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

    @Autowired
    private Record01StartRepository record01StartRepository;


    @Autowired
    private Record01StartMapper record01StartMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord01StartMockMvc;

    private Record01Start record01Start;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record01StartResource record01StartResource = new Record01StartResource(record01StartRepository, record01StartMapper);
        this.restRecord01StartMockMvc = MockMvcBuilders.standaloneSetup(record01StartResource)
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
    public static Record01Start createEntity(EntityManager em) {
        Record01Start record01Start = new Record01Start()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR)
            .creatieDatum(DEFAULT_CREATIE_DATUM)
            .creatieTijd(DEFAULT_CREATIE_TIJD);
        return record01Start;
    }

    @Before
    public void initTest() {
        record01Start = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord01Start() throws Exception {
        int databaseSizeBeforeCreate = record01StartRepository.findAll().size();

        // Create the Record01Start
        Record01StartDTO record01StartDTO = record01StartMapper.toDto(record01Start);
        restRecord01StartMockMvc.perform(post("/api/record-01-starts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record01StartDTO)))
            .andExpect(status().isCreated());

        // Validate the Record01Start in the database
        List<Record01Start> record01StartList = record01StartRepository.findAll();
        assertThat(record01StartList).hasSize(databaseSizeBeforeCreate + 1);
        Record01Start testRecord01Start = record01StartList.get(record01StartList.size() - 1);
        assertThat(testRecord01Start.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord01Start.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord01Start.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
        assertThat(testRecord01Start.getCreatieDatum()).isEqualTo(DEFAULT_CREATIE_DATUM);
        assertThat(testRecord01Start.getCreatieTijd()).isEqualTo(DEFAULT_CREATIE_TIJD);
    }

    @Test
    @Transactional
    public void createRecord01StartWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record01StartRepository.findAll().size();

        // Create the Record01Start with an existing ID
        record01Start.setId(1L);
        Record01StartDTO record01StartDTO = record01StartMapper.toDto(record01Start);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord01StartMockMvc.perform(post("/api/record-01-starts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record01StartDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record01Start in the database
        List<Record01Start> record01StartList = record01StartRepository.findAll();
        assertThat(record01StartList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord01Starts() throws Exception {
        // Initialize the database
        record01StartRepository.saveAndFlush(record01Start);

        // Get all the record01StartList
        restRecord01StartMockMvc.perform(get("/api/record-01-starts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record01Start.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)))
            .andExpect(jsonPath("$.[*].creatieDatum").value(hasItem(DEFAULT_CREATIE_DATUM.toString())))
            .andExpect(jsonPath("$.[*].creatieTijd").value(hasItem(sameInstant(DEFAULT_CREATIE_TIJD))));
    }
    

    @Test
    @Transactional
    public void getRecord01Start() throws Exception {
        // Initialize the database
        record01StartRepository.saveAndFlush(record01Start);

        // Get the record01Start
        restRecord01StartMockMvc.perform(get("/api/record-01-starts/{id}", record01Start.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record01Start.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR))
            .andExpect(jsonPath("$.creatieDatum").value(DEFAULT_CREATIE_DATUM.toString()))
            .andExpect(jsonPath("$.creatieTijd").value(sameInstant(DEFAULT_CREATIE_TIJD)));
    }
    @Test
    @Transactional
    public void getNonExistingRecord01Start() throws Exception {
        // Get the record01Start
        restRecord01StartMockMvc.perform(get("/api/record-01-starts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord01Start() throws Exception {
        // Initialize the database
        record01StartRepository.saveAndFlush(record01Start);

        int databaseSizeBeforeUpdate = record01StartRepository.findAll().size();

        // Update the record01Start
        Record01Start updatedRecord01Start = record01StartRepository.findById(record01Start.getId()).get();
        // Disconnect from session so that the updates on updatedRecord01Start are not directly saved in db
        em.detach(updatedRecord01Start);
        updatedRecord01Start
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR)
            .creatieDatum(UPDATED_CREATIE_DATUM)
            .creatieTijd(UPDATED_CREATIE_TIJD);
        Record01StartDTO record01StartDTO = record01StartMapper.toDto(updatedRecord01Start);

        restRecord01StartMockMvc.perform(put("/api/record-01-starts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record01StartDTO)))
            .andExpect(status().isOk());

        // Validate the Record01Start in the database
        List<Record01Start> record01StartList = record01StartRepository.findAll();
        assertThat(record01StartList).hasSize(databaseSizeBeforeUpdate);
        Record01Start testRecord01Start = record01StartList.get(record01StartList.size() - 1);
        assertThat(testRecord01Start.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord01Start.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord01Start.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
        assertThat(testRecord01Start.getCreatieDatum()).isEqualTo(UPDATED_CREATIE_DATUM);
        assertThat(testRecord01Start.getCreatieTijd()).isEqualTo(UPDATED_CREATIE_TIJD);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord01Start() throws Exception {
        int databaseSizeBeforeUpdate = record01StartRepository.findAll().size();

        // Create the Record01Start
        Record01StartDTO record01StartDTO = record01StartMapper.toDto(record01Start);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord01StartMockMvc.perform(put("/api/record-01-starts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record01StartDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record01Start in the database
        List<Record01Start> record01StartList = record01StartRepository.findAll();
        assertThat(record01StartList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord01Start() throws Exception {
        // Initialize the database
        record01StartRepository.saveAndFlush(record01Start);

        int databaseSizeBeforeDelete = record01StartRepository.findAll().size();

        // Get the record01Start
        restRecord01StartMockMvc.perform(delete("/api/record-01-starts/{id}", record01Start.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record01Start> record01StartList = record01StartRepository.findAll();
        assertThat(record01StartList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record01Start.class);
        Record01Start record01Start1 = new Record01Start();
        record01Start1.setId(1L);
        Record01Start record01Start2 = new Record01Start();
        record01Start2.setId(record01Start1.getId());
        assertThat(record01Start1).isEqualTo(record01Start2);
        record01Start2.setId(2L);
        assertThat(record01Start1).isNotEqualTo(record01Start2);
        record01Start1.setId(null);
        assertThat(record01Start1).isNotEqualTo(record01Start2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record01StartDTO.class);
        Record01StartDTO record01StartDTO1 = new Record01StartDTO();
        record01StartDTO1.setId(1L);
        Record01StartDTO record01StartDTO2 = new Record01StartDTO();
        assertThat(record01StartDTO1).isNotEqualTo(record01StartDTO2);
        record01StartDTO2.setId(record01StartDTO1.getId());
        assertThat(record01StartDTO1).isEqualTo(record01StartDTO2);
        record01StartDTO2.setId(2L);
        assertThat(record01StartDTO1).isNotEqualTo(record01StartDTO2);
        record01StartDTO1.setId(null);
        assertThat(record01StartDTO1).isNotEqualTo(record01StartDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record01StartMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record01StartMapper.fromId(null)).isNull();
    }
}
