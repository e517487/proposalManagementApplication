package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record40AcceptatieScore;
import com.inetpsa.pct00.application.repository.Record40AcceptatieScoreRepository;
import com.inetpsa.pct00.application.service.dto.Record40AcceptatieScoreDTO;
import com.inetpsa.pct00.application.service.mapper.Record40AcceptatieScoreMapper;
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
 * Test class for the Record40AcceptatieScoreResource REST controller.
 *
 * @see Record40AcceptatieScoreResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record40AcceptatieScoreResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record40AcceptatieScoreRepository record40AcceptatieScoreRepository;


    @Autowired
    private Record40AcceptatieScoreMapper record40AcceptatieScoreMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord40AcceptatieScoreMockMvc;

    private Record40AcceptatieScore record40AcceptatieScore;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record40AcceptatieScoreResource record40AcceptatieScoreResource = new Record40AcceptatieScoreResource(record40AcceptatieScoreRepository, record40AcceptatieScoreMapper);
        this.restRecord40AcceptatieScoreMockMvc = MockMvcBuilders.standaloneSetup(record40AcceptatieScoreResource)
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
    public static Record40AcceptatieScore createEntity(EntityManager em) {
        Record40AcceptatieScore record40AcceptatieScore = new Record40AcceptatieScore()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record40AcceptatieScore;
    }

    @Before
    public void initTest() {
        record40AcceptatieScore = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord40AcceptatieScore() throws Exception {
        int databaseSizeBeforeCreate = record40AcceptatieScoreRepository.findAll().size();

        // Create the Record40AcceptatieScore
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO = record40AcceptatieScoreMapper.toDto(record40AcceptatieScore);
        restRecord40AcceptatieScoreMockMvc.perform(post("/api/record-40-acceptatie-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record40AcceptatieScoreDTO)))
            .andExpect(status().isCreated());

        // Validate the Record40AcceptatieScore in the database
        List<Record40AcceptatieScore> record40AcceptatieScoreList = record40AcceptatieScoreRepository.findAll();
        assertThat(record40AcceptatieScoreList).hasSize(databaseSizeBeforeCreate + 1);
        Record40AcceptatieScore testRecord40AcceptatieScore = record40AcceptatieScoreList.get(record40AcceptatieScoreList.size() - 1);
        assertThat(testRecord40AcceptatieScore.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord40AcceptatieScore.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord40AcceptatieScore.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord40AcceptatieScoreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record40AcceptatieScoreRepository.findAll().size();

        // Create the Record40AcceptatieScore with an existing ID
        record40AcceptatieScore.setId(1L);
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO = record40AcceptatieScoreMapper.toDto(record40AcceptatieScore);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord40AcceptatieScoreMockMvc.perform(post("/api/record-40-acceptatie-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record40AcceptatieScoreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record40AcceptatieScore in the database
        List<Record40AcceptatieScore> record40AcceptatieScoreList = record40AcceptatieScoreRepository.findAll();
        assertThat(record40AcceptatieScoreList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord40AcceptatieScores() throws Exception {
        // Initialize the database
        record40AcceptatieScoreRepository.saveAndFlush(record40AcceptatieScore);

        // Get all the record40AcceptatieScoreList
        restRecord40AcceptatieScoreMockMvc.perform(get("/api/record-40-acceptatie-scores?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record40AcceptatieScore.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord40AcceptatieScore() throws Exception {
        // Initialize the database
        record40AcceptatieScoreRepository.saveAndFlush(record40AcceptatieScore);

        // Get the record40AcceptatieScore
        restRecord40AcceptatieScoreMockMvc.perform(get("/api/record-40-acceptatie-scores/{id}", record40AcceptatieScore.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record40AcceptatieScore.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord40AcceptatieScore() throws Exception {
        // Get the record40AcceptatieScore
        restRecord40AcceptatieScoreMockMvc.perform(get("/api/record-40-acceptatie-scores/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord40AcceptatieScore() throws Exception {
        // Initialize the database
        record40AcceptatieScoreRepository.saveAndFlush(record40AcceptatieScore);

        int databaseSizeBeforeUpdate = record40AcceptatieScoreRepository.findAll().size();

        // Update the record40AcceptatieScore
        Record40AcceptatieScore updatedRecord40AcceptatieScore = record40AcceptatieScoreRepository.findById(record40AcceptatieScore.getId()).get();
        // Disconnect from session so that the updates on updatedRecord40AcceptatieScore are not directly saved in db
        em.detach(updatedRecord40AcceptatieScore);
        updatedRecord40AcceptatieScore
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO = record40AcceptatieScoreMapper.toDto(updatedRecord40AcceptatieScore);

        restRecord40AcceptatieScoreMockMvc.perform(put("/api/record-40-acceptatie-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record40AcceptatieScoreDTO)))
            .andExpect(status().isOk());

        // Validate the Record40AcceptatieScore in the database
        List<Record40AcceptatieScore> record40AcceptatieScoreList = record40AcceptatieScoreRepository.findAll();
        assertThat(record40AcceptatieScoreList).hasSize(databaseSizeBeforeUpdate);
        Record40AcceptatieScore testRecord40AcceptatieScore = record40AcceptatieScoreList.get(record40AcceptatieScoreList.size() - 1);
        assertThat(testRecord40AcceptatieScore.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord40AcceptatieScore.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord40AcceptatieScore.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord40AcceptatieScore() throws Exception {
        int databaseSizeBeforeUpdate = record40AcceptatieScoreRepository.findAll().size();

        // Create the Record40AcceptatieScore
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO = record40AcceptatieScoreMapper.toDto(record40AcceptatieScore);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord40AcceptatieScoreMockMvc.perform(put("/api/record-40-acceptatie-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record40AcceptatieScoreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record40AcceptatieScore in the database
        List<Record40AcceptatieScore> record40AcceptatieScoreList = record40AcceptatieScoreRepository.findAll();
        assertThat(record40AcceptatieScoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord40AcceptatieScore() throws Exception {
        // Initialize the database
        record40AcceptatieScoreRepository.saveAndFlush(record40AcceptatieScore);

        int databaseSizeBeforeDelete = record40AcceptatieScoreRepository.findAll().size();

        // Get the record40AcceptatieScore
        restRecord40AcceptatieScoreMockMvc.perform(delete("/api/record-40-acceptatie-scores/{id}", record40AcceptatieScore.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record40AcceptatieScore> record40AcceptatieScoreList = record40AcceptatieScoreRepository.findAll();
        assertThat(record40AcceptatieScoreList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record40AcceptatieScore.class);
        Record40AcceptatieScore record40AcceptatieScore1 = new Record40AcceptatieScore();
        record40AcceptatieScore1.setId(1L);
        Record40AcceptatieScore record40AcceptatieScore2 = new Record40AcceptatieScore();
        record40AcceptatieScore2.setId(record40AcceptatieScore1.getId());
        assertThat(record40AcceptatieScore1).isEqualTo(record40AcceptatieScore2);
        record40AcceptatieScore2.setId(2L);
        assertThat(record40AcceptatieScore1).isNotEqualTo(record40AcceptatieScore2);
        record40AcceptatieScore1.setId(null);
        assertThat(record40AcceptatieScore1).isNotEqualTo(record40AcceptatieScore2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record40AcceptatieScoreDTO.class);
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO1 = new Record40AcceptatieScoreDTO();
        record40AcceptatieScoreDTO1.setId(1L);
        Record40AcceptatieScoreDTO record40AcceptatieScoreDTO2 = new Record40AcceptatieScoreDTO();
        assertThat(record40AcceptatieScoreDTO1).isNotEqualTo(record40AcceptatieScoreDTO2);
        record40AcceptatieScoreDTO2.setId(record40AcceptatieScoreDTO1.getId());
        assertThat(record40AcceptatieScoreDTO1).isEqualTo(record40AcceptatieScoreDTO2);
        record40AcceptatieScoreDTO2.setId(2L);
        assertThat(record40AcceptatieScoreDTO1).isNotEqualTo(record40AcceptatieScoreDTO2);
        record40AcceptatieScoreDTO1.setId(null);
        assertThat(record40AcceptatieScoreDTO1).isNotEqualTo(record40AcceptatieScoreDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record40AcceptatieScoreMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record40AcceptatieScoreMapper.fromId(null)).isNull();
    }
}
