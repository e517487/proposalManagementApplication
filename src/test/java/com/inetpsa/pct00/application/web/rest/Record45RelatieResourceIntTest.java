package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record45Relatie;
import com.inetpsa.pct00.application.repository.Record45RelatieRepository;
import com.inetpsa.pct00.application.service.dto.Record45RelatieDTO;
import com.inetpsa.pct00.application.service.mapper.Record45RelatieMapper;
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
 * Test class for the Record45RelatieResource REST controller.
 *
 * @see Record45RelatieResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record45RelatieResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record45RelatieRepository record45RelatieRepository;


    @Autowired
    private Record45RelatieMapper record45RelatieMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord45RelatieMockMvc;

    private Record45Relatie record45Relatie;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record45RelatieResource record45RelatieResource = new Record45RelatieResource(record45RelatieRepository, record45RelatieMapper);
        this.restRecord45RelatieMockMvc = MockMvcBuilders.standaloneSetup(record45RelatieResource)
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
    public static Record45Relatie createEntity(EntityManager em) {
        Record45Relatie record45Relatie = new Record45Relatie()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record45Relatie;
    }

    @Before
    public void initTest() {
        record45Relatie = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord45Relatie() throws Exception {
        int databaseSizeBeforeCreate = record45RelatieRepository.findAll().size();

        // Create the Record45Relatie
        Record45RelatieDTO record45RelatieDTO = record45RelatieMapper.toDto(record45Relatie);
        restRecord45RelatieMockMvc.perform(post("/api/record-45-relaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record45RelatieDTO)))
            .andExpect(status().isCreated());

        // Validate the Record45Relatie in the database
        List<Record45Relatie> record45RelatieList = record45RelatieRepository.findAll();
        assertThat(record45RelatieList).hasSize(databaseSizeBeforeCreate + 1);
        Record45Relatie testRecord45Relatie = record45RelatieList.get(record45RelatieList.size() - 1);
        assertThat(testRecord45Relatie.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord45Relatie.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord45Relatie.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord45RelatieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record45RelatieRepository.findAll().size();

        // Create the Record45Relatie with an existing ID
        record45Relatie.setId(1L);
        Record45RelatieDTO record45RelatieDTO = record45RelatieMapper.toDto(record45Relatie);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord45RelatieMockMvc.perform(post("/api/record-45-relaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record45RelatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record45Relatie in the database
        List<Record45Relatie> record45RelatieList = record45RelatieRepository.findAll();
        assertThat(record45RelatieList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord45Relaties() throws Exception {
        // Initialize the database
        record45RelatieRepository.saveAndFlush(record45Relatie);

        // Get all the record45RelatieList
        restRecord45RelatieMockMvc.perform(get("/api/record-45-relaties?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record45Relatie.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord45Relatie() throws Exception {
        // Initialize the database
        record45RelatieRepository.saveAndFlush(record45Relatie);

        // Get the record45Relatie
        restRecord45RelatieMockMvc.perform(get("/api/record-45-relaties/{id}", record45Relatie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record45Relatie.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord45Relatie() throws Exception {
        // Get the record45Relatie
        restRecord45RelatieMockMvc.perform(get("/api/record-45-relaties/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord45Relatie() throws Exception {
        // Initialize the database
        record45RelatieRepository.saveAndFlush(record45Relatie);

        int databaseSizeBeforeUpdate = record45RelatieRepository.findAll().size();

        // Update the record45Relatie
        Record45Relatie updatedRecord45Relatie = record45RelatieRepository.findById(record45Relatie.getId()).get();
        // Disconnect from session so that the updates on updatedRecord45Relatie are not directly saved in db
        em.detach(updatedRecord45Relatie);
        updatedRecord45Relatie
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);
        Record45RelatieDTO record45RelatieDTO = record45RelatieMapper.toDto(updatedRecord45Relatie);

        restRecord45RelatieMockMvc.perform(put("/api/record-45-relaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record45RelatieDTO)))
            .andExpect(status().isOk());

        // Validate the Record45Relatie in the database
        List<Record45Relatie> record45RelatieList = record45RelatieRepository.findAll();
        assertThat(record45RelatieList).hasSize(databaseSizeBeforeUpdate);
        Record45Relatie testRecord45Relatie = record45RelatieList.get(record45RelatieList.size() - 1);
        assertThat(testRecord45Relatie.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord45Relatie.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord45Relatie.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord45Relatie() throws Exception {
        int databaseSizeBeforeUpdate = record45RelatieRepository.findAll().size();

        // Create the Record45Relatie
        Record45RelatieDTO record45RelatieDTO = record45RelatieMapper.toDto(record45Relatie);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord45RelatieMockMvc.perform(put("/api/record-45-relaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record45RelatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record45Relatie in the database
        List<Record45Relatie> record45RelatieList = record45RelatieRepository.findAll();
        assertThat(record45RelatieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord45Relatie() throws Exception {
        // Initialize the database
        record45RelatieRepository.saveAndFlush(record45Relatie);

        int databaseSizeBeforeDelete = record45RelatieRepository.findAll().size();

        // Get the record45Relatie
        restRecord45RelatieMockMvc.perform(delete("/api/record-45-relaties/{id}", record45Relatie.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record45Relatie> record45RelatieList = record45RelatieRepository.findAll();
        assertThat(record45RelatieList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record45Relatie.class);
        Record45Relatie record45Relatie1 = new Record45Relatie();
        record45Relatie1.setId(1L);
        Record45Relatie record45Relatie2 = new Record45Relatie();
        record45Relatie2.setId(record45Relatie1.getId());
        assertThat(record45Relatie1).isEqualTo(record45Relatie2);
        record45Relatie2.setId(2L);
        assertThat(record45Relatie1).isNotEqualTo(record45Relatie2);
        record45Relatie1.setId(null);
        assertThat(record45Relatie1).isNotEqualTo(record45Relatie2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record45RelatieDTO.class);
        Record45RelatieDTO record45RelatieDTO1 = new Record45RelatieDTO();
        record45RelatieDTO1.setId(1L);
        Record45RelatieDTO record45RelatieDTO2 = new Record45RelatieDTO();
        assertThat(record45RelatieDTO1).isNotEqualTo(record45RelatieDTO2);
        record45RelatieDTO2.setId(record45RelatieDTO1.getId());
        assertThat(record45RelatieDTO1).isEqualTo(record45RelatieDTO2);
        record45RelatieDTO2.setId(2L);
        assertThat(record45RelatieDTO1).isNotEqualTo(record45RelatieDTO2);
        record45RelatieDTO1.setId(null);
        assertThat(record45RelatieDTO1).isNotEqualTo(record45RelatieDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record45RelatieMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record45RelatieMapper.fromId(null)).isNull();
    }
}
