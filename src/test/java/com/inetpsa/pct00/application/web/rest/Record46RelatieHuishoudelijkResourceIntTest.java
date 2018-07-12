package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record46RelatieHuishoudelijk;
import com.inetpsa.pct00.application.repository.Record46RelatieHuishoudelijkRepository;
import com.inetpsa.pct00.application.service.dto.Record46RelatieHuishoudelijkDTO;
import com.inetpsa.pct00.application.service.mapper.Record46RelatieHuishoudelijkMapper;
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
 * Test class for the Record46RelatieHuishoudelijkResource REST controller.
 *
 * @see Record46RelatieHuishoudelijkResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record46RelatieHuishoudelijkResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record46RelatieHuishoudelijkRepository record46RelatieHuishoudelijkRepository;


    @Autowired
    private Record46RelatieHuishoudelijkMapper record46RelatieHuishoudelijkMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord46RelatieHuishoudelijkMockMvc;

    private Record46RelatieHuishoudelijk record46RelatieHuishoudelijk;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record46RelatieHuishoudelijkResource record46RelatieHuishoudelijkResource = new Record46RelatieHuishoudelijkResource(record46RelatieHuishoudelijkRepository, record46RelatieHuishoudelijkMapper);
        this.restRecord46RelatieHuishoudelijkMockMvc = MockMvcBuilders.standaloneSetup(record46RelatieHuishoudelijkResource)
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
    public static Record46RelatieHuishoudelijk createEntity(EntityManager em) {
        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk = new Record46RelatieHuishoudelijk()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record46RelatieHuishoudelijk;
    }

    @Before
    public void initTest() {
        record46RelatieHuishoudelijk = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord46RelatieHuishoudelijk() throws Exception {
        int databaseSizeBeforeCreate = record46RelatieHuishoudelijkRepository.findAll().size();

        // Create the Record46RelatieHuishoudelijk
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO = record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijk);
        restRecord46RelatieHuishoudelijkMockMvc.perform(post("/api/record-46-relatie-huishoudelijks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record46RelatieHuishoudelijkDTO)))
            .andExpect(status().isCreated());

        // Validate the Record46RelatieHuishoudelijk in the database
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijkList = record46RelatieHuishoudelijkRepository.findAll();
        assertThat(record46RelatieHuishoudelijkList).hasSize(databaseSizeBeforeCreate + 1);
        Record46RelatieHuishoudelijk testRecord46RelatieHuishoudelijk = record46RelatieHuishoudelijkList.get(record46RelatieHuishoudelijkList.size() - 1);
        assertThat(testRecord46RelatieHuishoudelijk.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord46RelatieHuishoudelijk.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord46RelatieHuishoudelijk.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord46RelatieHuishoudelijkWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record46RelatieHuishoudelijkRepository.findAll().size();

        // Create the Record46RelatieHuishoudelijk with an existing ID
        record46RelatieHuishoudelijk.setId(1L);
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO = record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijk);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord46RelatieHuishoudelijkMockMvc.perform(post("/api/record-46-relatie-huishoudelijks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record46RelatieHuishoudelijkDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record46RelatieHuishoudelijk in the database
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijkList = record46RelatieHuishoudelijkRepository.findAll();
        assertThat(record46RelatieHuishoudelijkList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord46RelatieHuishoudelijks() throws Exception {
        // Initialize the database
        record46RelatieHuishoudelijkRepository.saveAndFlush(record46RelatieHuishoudelijk);

        // Get all the record46RelatieHuishoudelijkList
        restRecord46RelatieHuishoudelijkMockMvc.perform(get("/api/record-46-relatie-huishoudelijks?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record46RelatieHuishoudelijk.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord46RelatieHuishoudelijk() throws Exception {
        // Initialize the database
        record46RelatieHuishoudelijkRepository.saveAndFlush(record46RelatieHuishoudelijk);

        // Get the record46RelatieHuishoudelijk
        restRecord46RelatieHuishoudelijkMockMvc.perform(get("/api/record-46-relatie-huishoudelijks/{id}", record46RelatieHuishoudelijk.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record46RelatieHuishoudelijk.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord46RelatieHuishoudelijk() throws Exception {
        // Get the record46RelatieHuishoudelijk
        restRecord46RelatieHuishoudelijkMockMvc.perform(get("/api/record-46-relatie-huishoudelijks/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord46RelatieHuishoudelijk() throws Exception {
        // Initialize the database
        record46RelatieHuishoudelijkRepository.saveAndFlush(record46RelatieHuishoudelijk);

        int databaseSizeBeforeUpdate = record46RelatieHuishoudelijkRepository.findAll().size();

        // Update the record46RelatieHuishoudelijk
        Record46RelatieHuishoudelijk updatedRecord46RelatieHuishoudelijk = record46RelatieHuishoudelijkRepository.findById(record46RelatieHuishoudelijk.getId()).get();
        // Disconnect from session so that the updates on updatedRecord46RelatieHuishoudelijk are not directly saved in db
        em.detach(updatedRecord46RelatieHuishoudelijk);
        updatedRecord46RelatieHuishoudelijk
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO = record46RelatieHuishoudelijkMapper.toDto(updatedRecord46RelatieHuishoudelijk);

        restRecord46RelatieHuishoudelijkMockMvc.perform(put("/api/record-46-relatie-huishoudelijks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record46RelatieHuishoudelijkDTO)))
            .andExpect(status().isOk());

        // Validate the Record46RelatieHuishoudelijk in the database
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijkList = record46RelatieHuishoudelijkRepository.findAll();
        assertThat(record46RelatieHuishoudelijkList).hasSize(databaseSizeBeforeUpdate);
        Record46RelatieHuishoudelijk testRecord46RelatieHuishoudelijk = record46RelatieHuishoudelijkList.get(record46RelatieHuishoudelijkList.size() - 1);
        assertThat(testRecord46RelatieHuishoudelijk.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord46RelatieHuishoudelijk.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord46RelatieHuishoudelijk.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord46RelatieHuishoudelijk() throws Exception {
        int databaseSizeBeforeUpdate = record46RelatieHuishoudelijkRepository.findAll().size();

        // Create the Record46RelatieHuishoudelijk
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO = record46RelatieHuishoudelijkMapper.toDto(record46RelatieHuishoudelijk);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord46RelatieHuishoudelijkMockMvc.perform(put("/api/record-46-relatie-huishoudelijks")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record46RelatieHuishoudelijkDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record46RelatieHuishoudelijk in the database
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijkList = record46RelatieHuishoudelijkRepository.findAll();
        assertThat(record46RelatieHuishoudelijkList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord46RelatieHuishoudelijk() throws Exception {
        // Initialize the database
        record46RelatieHuishoudelijkRepository.saveAndFlush(record46RelatieHuishoudelijk);

        int databaseSizeBeforeDelete = record46RelatieHuishoudelijkRepository.findAll().size();

        // Get the record46RelatieHuishoudelijk
        restRecord46RelatieHuishoudelijkMockMvc.perform(delete("/api/record-46-relatie-huishoudelijks/{id}", record46RelatieHuishoudelijk.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record46RelatieHuishoudelijk> record46RelatieHuishoudelijkList = record46RelatieHuishoudelijkRepository.findAll();
        assertThat(record46RelatieHuishoudelijkList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record46RelatieHuishoudelijk.class);
        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk1 = new Record46RelatieHuishoudelijk();
        record46RelatieHuishoudelijk1.setId(1L);
        Record46RelatieHuishoudelijk record46RelatieHuishoudelijk2 = new Record46RelatieHuishoudelijk();
        record46RelatieHuishoudelijk2.setId(record46RelatieHuishoudelijk1.getId());
        assertThat(record46RelatieHuishoudelijk1).isEqualTo(record46RelatieHuishoudelijk2);
        record46RelatieHuishoudelijk2.setId(2L);
        assertThat(record46RelatieHuishoudelijk1).isNotEqualTo(record46RelatieHuishoudelijk2);
        record46RelatieHuishoudelijk1.setId(null);
        assertThat(record46RelatieHuishoudelijk1).isNotEqualTo(record46RelatieHuishoudelijk2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record46RelatieHuishoudelijkDTO.class);
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO1 = new Record46RelatieHuishoudelijkDTO();
        record46RelatieHuishoudelijkDTO1.setId(1L);
        Record46RelatieHuishoudelijkDTO record46RelatieHuishoudelijkDTO2 = new Record46RelatieHuishoudelijkDTO();
        assertThat(record46RelatieHuishoudelijkDTO1).isNotEqualTo(record46RelatieHuishoudelijkDTO2);
        record46RelatieHuishoudelijkDTO2.setId(record46RelatieHuishoudelijkDTO1.getId());
        assertThat(record46RelatieHuishoudelijkDTO1).isEqualTo(record46RelatieHuishoudelijkDTO2);
        record46RelatieHuishoudelijkDTO2.setId(2L);
        assertThat(record46RelatieHuishoudelijkDTO1).isNotEqualTo(record46RelatieHuishoudelijkDTO2);
        record46RelatieHuishoudelijkDTO1.setId(null);
        assertThat(record46RelatieHuishoudelijkDTO1).isNotEqualTo(record46RelatieHuishoudelijkDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record46RelatieHuishoudelijkMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record46RelatieHuishoudelijkMapper.fromId(null)).isNull();
    }
}
