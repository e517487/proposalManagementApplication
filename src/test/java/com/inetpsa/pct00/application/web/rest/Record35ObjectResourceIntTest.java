package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record35Object;
import com.inetpsa.pct00.application.repository.Record35ObjectRepository;
import com.inetpsa.pct00.application.service.dto.Record35ObjectDTO;
import com.inetpsa.pct00.application.service.mapper.Record35ObjectMapper;
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
 * Test class for the Record35ObjectResource REST controller.
 *
 * @see Record35ObjectResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record35ObjectResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record35ObjectRepository record35ObjectRepository;


    @Autowired
    private Record35ObjectMapper record35ObjectMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord35ObjectMockMvc;

    private Record35Object record35Object;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record35ObjectResource record35ObjectResource = new Record35ObjectResource(record35ObjectRepository, record35ObjectMapper);
        this.restRecord35ObjectMockMvc = MockMvcBuilders.standaloneSetup(record35ObjectResource)
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
    public static Record35Object createEntity(EntityManager em) {
        Record35Object record35Object = new Record35Object()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record35Object;
    }

    @Before
    public void initTest() {
        record35Object = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord35Object() throws Exception {
        int databaseSizeBeforeCreate = record35ObjectRepository.findAll().size();

        // Create the Record35Object
        Record35ObjectDTO record35ObjectDTO = record35ObjectMapper.toDto(record35Object);
        restRecord35ObjectMockMvc.perform(post("/api/record-35-objects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record35ObjectDTO)))
            .andExpect(status().isCreated());

        // Validate the Record35Object in the database
        List<Record35Object> record35ObjectList = record35ObjectRepository.findAll();
        assertThat(record35ObjectList).hasSize(databaseSizeBeforeCreate + 1);
        Record35Object testRecord35Object = record35ObjectList.get(record35ObjectList.size() - 1);
        assertThat(testRecord35Object.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord35Object.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord35Object.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord35ObjectWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record35ObjectRepository.findAll().size();

        // Create the Record35Object with an existing ID
        record35Object.setId(1L);
        Record35ObjectDTO record35ObjectDTO = record35ObjectMapper.toDto(record35Object);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord35ObjectMockMvc.perform(post("/api/record-35-objects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record35ObjectDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record35Object in the database
        List<Record35Object> record35ObjectList = record35ObjectRepository.findAll();
        assertThat(record35ObjectList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord35Objects() throws Exception {
        // Initialize the database
        record35ObjectRepository.saveAndFlush(record35Object);

        // Get all the record35ObjectList
        restRecord35ObjectMockMvc.perform(get("/api/record-35-objects?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record35Object.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord35Object() throws Exception {
        // Initialize the database
        record35ObjectRepository.saveAndFlush(record35Object);

        // Get the record35Object
        restRecord35ObjectMockMvc.perform(get("/api/record-35-objects/{id}", record35Object.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record35Object.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord35Object() throws Exception {
        // Get the record35Object
        restRecord35ObjectMockMvc.perform(get("/api/record-35-objects/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord35Object() throws Exception {
        // Initialize the database
        record35ObjectRepository.saveAndFlush(record35Object);

        int databaseSizeBeforeUpdate = record35ObjectRepository.findAll().size();

        // Update the record35Object
        Record35Object updatedRecord35Object = record35ObjectRepository.findById(record35Object.getId()).get();
        // Disconnect from session so that the updates on updatedRecord35Object are not directly saved in db
        em.detach(updatedRecord35Object);
        updatedRecord35Object
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);
        Record35ObjectDTO record35ObjectDTO = record35ObjectMapper.toDto(updatedRecord35Object);

        restRecord35ObjectMockMvc.perform(put("/api/record-35-objects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record35ObjectDTO)))
            .andExpect(status().isOk());

        // Validate the Record35Object in the database
        List<Record35Object> record35ObjectList = record35ObjectRepository.findAll();
        assertThat(record35ObjectList).hasSize(databaseSizeBeforeUpdate);
        Record35Object testRecord35Object = record35ObjectList.get(record35ObjectList.size() - 1);
        assertThat(testRecord35Object.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord35Object.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord35Object.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord35Object() throws Exception {
        int databaseSizeBeforeUpdate = record35ObjectRepository.findAll().size();

        // Create the Record35Object
        Record35ObjectDTO record35ObjectDTO = record35ObjectMapper.toDto(record35Object);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord35ObjectMockMvc.perform(put("/api/record-35-objects")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record35ObjectDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record35Object in the database
        List<Record35Object> record35ObjectList = record35ObjectRepository.findAll();
        assertThat(record35ObjectList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord35Object() throws Exception {
        // Initialize the database
        record35ObjectRepository.saveAndFlush(record35Object);

        int databaseSizeBeforeDelete = record35ObjectRepository.findAll().size();

        // Get the record35Object
        restRecord35ObjectMockMvc.perform(delete("/api/record-35-objects/{id}", record35Object.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record35Object> record35ObjectList = record35ObjectRepository.findAll();
        assertThat(record35ObjectList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record35Object.class);
        Record35Object record35Object1 = new Record35Object();
        record35Object1.setId(1L);
        Record35Object record35Object2 = new Record35Object();
        record35Object2.setId(record35Object1.getId());
        assertThat(record35Object1).isEqualTo(record35Object2);
        record35Object2.setId(2L);
        assertThat(record35Object1).isNotEqualTo(record35Object2);
        record35Object1.setId(null);
        assertThat(record35Object1).isNotEqualTo(record35Object2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record35ObjectDTO.class);
        Record35ObjectDTO record35ObjectDTO1 = new Record35ObjectDTO();
        record35ObjectDTO1.setId(1L);
        Record35ObjectDTO record35ObjectDTO2 = new Record35ObjectDTO();
        assertThat(record35ObjectDTO1).isNotEqualTo(record35ObjectDTO2);
        record35ObjectDTO2.setId(record35ObjectDTO1.getId());
        assertThat(record35ObjectDTO1).isEqualTo(record35ObjectDTO2);
        record35ObjectDTO2.setId(2L);
        assertThat(record35ObjectDTO1).isNotEqualTo(record35ObjectDTO2);
        record35ObjectDTO1.setId(null);
        assertThat(record35ObjectDTO1).isNotEqualTo(record35ObjectDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record35ObjectMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record35ObjectMapper.fromId(null)).isNull();
    }
}
