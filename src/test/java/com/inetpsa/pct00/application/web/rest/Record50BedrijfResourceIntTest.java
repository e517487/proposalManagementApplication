package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record50Bedrijf;
import com.inetpsa.pct00.application.repository.Record50BedrijfRepository;
import com.inetpsa.pct00.application.service.dto.Record50BedrijfDTO;
import com.inetpsa.pct00.application.service.mapper.Record50BedrijfMapper;
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
 * Test class for the Record50BedrijfResource REST controller.
 *
 * @see Record50BedrijfResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record50BedrijfResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLG_NR = 1;
    private static final Integer UPDATED_VOLG_NR = 2;

    @Autowired
    private Record50BedrijfRepository record50BedrijfRepository;


    @Autowired
    private Record50BedrijfMapper record50BedrijfMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord50BedrijfMockMvc;

    private Record50Bedrijf record50Bedrijf;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record50BedrijfResource record50BedrijfResource = new Record50BedrijfResource(record50BedrijfRepository, record50BedrijfMapper);
        this.restRecord50BedrijfMockMvc = MockMvcBuilders.standaloneSetup(record50BedrijfResource)
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
    public static Record50Bedrijf createEntity(EntityManager em) {
        Record50Bedrijf record50Bedrijf = new Record50Bedrijf()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgNr(DEFAULT_VOLG_NR);
        return record50Bedrijf;
    }

    @Before
    public void initTest() {
        record50Bedrijf = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord50Bedrijf() throws Exception {
        int databaseSizeBeforeCreate = record50BedrijfRepository.findAll().size();

        // Create the Record50Bedrijf
        Record50BedrijfDTO record50BedrijfDTO = record50BedrijfMapper.toDto(record50Bedrijf);
        restRecord50BedrijfMockMvc.perform(post("/api/record-50-bedrijfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record50BedrijfDTO)))
            .andExpect(status().isCreated());

        // Validate the Record50Bedrijf in the database
        List<Record50Bedrijf> record50BedrijfList = record50BedrijfRepository.findAll();
        assertThat(record50BedrijfList).hasSize(databaseSizeBeforeCreate + 1);
        Record50Bedrijf testRecord50Bedrijf = record50BedrijfList.get(record50BedrijfList.size() - 1);
        assertThat(testRecord50Bedrijf.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord50Bedrijf.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord50Bedrijf.getVolgNr()).isEqualTo(DEFAULT_VOLG_NR);
    }

    @Test
    @Transactional
    public void createRecord50BedrijfWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record50BedrijfRepository.findAll().size();

        // Create the Record50Bedrijf with an existing ID
        record50Bedrijf.setId(1L);
        Record50BedrijfDTO record50BedrijfDTO = record50BedrijfMapper.toDto(record50Bedrijf);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord50BedrijfMockMvc.perform(post("/api/record-50-bedrijfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record50BedrijfDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record50Bedrijf in the database
        List<Record50Bedrijf> record50BedrijfList = record50BedrijfRepository.findAll();
        assertThat(record50BedrijfList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord50Bedrijfs() throws Exception {
        // Initialize the database
        record50BedrijfRepository.saveAndFlush(record50Bedrijf);

        // Get all the record50BedrijfList
        restRecord50BedrijfMockMvc.perform(get("/api/record-50-bedrijfs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record50Bedrijf.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgNr").value(hasItem(DEFAULT_VOLG_NR)));
    }
    

    @Test
    @Transactional
    public void getRecord50Bedrijf() throws Exception {
        // Initialize the database
        record50BedrijfRepository.saveAndFlush(record50Bedrijf);

        // Get the record50Bedrijf
        restRecord50BedrijfMockMvc.perform(get("/api/record-50-bedrijfs/{id}", record50Bedrijf.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record50Bedrijf.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgNr").value(DEFAULT_VOLG_NR));
    }
    @Test
    @Transactional
    public void getNonExistingRecord50Bedrijf() throws Exception {
        // Get the record50Bedrijf
        restRecord50BedrijfMockMvc.perform(get("/api/record-50-bedrijfs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord50Bedrijf() throws Exception {
        // Initialize the database
        record50BedrijfRepository.saveAndFlush(record50Bedrijf);

        int databaseSizeBeforeUpdate = record50BedrijfRepository.findAll().size();

        // Update the record50Bedrijf
        Record50Bedrijf updatedRecord50Bedrijf = record50BedrijfRepository.findById(record50Bedrijf.getId()).get();
        // Disconnect from session so that the updates on updatedRecord50Bedrijf are not directly saved in db
        em.detach(updatedRecord50Bedrijf);
        updatedRecord50Bedrijf
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgNr(UPDATED_VOLG_NR);
        Record50BedrijfDTO record50BedrijfDTO = record50BedrijfMapper.toDto(updatedRecord50Bedrijf);

        restRecord50BedrijfMockMvc.perform(put("/api/record-50-bedrijfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record50BedrijfDTO)))
            .andExpect(status().isOk());

        // Validate the Record50Bedrijf in the database
        List<Record50Bedrijf> record50BedrijfList = record50BedrijfRepository.findAll();
        assertThat(record50BedrijfList).hasSize(databaseSizeBeforeUpdate);
        Record50Bedrijf testRecord50Bedrijf = record50BedrijfList.get(record50BedrijfList.size() - 1);
        assertThat(testRecord50Bedrijf.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord50Bedrijf.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord50Bedrijf.getVolgNr()).isEqualTo(UPDATED_VOLG_NR);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord50Bedrijf() throws Exception {
        int databaseSizeBeforeUpdate = record50BedrijfRepository.findAll().size();

        // Create the Record50Bedrijf
        Record50BedrijfDTO record50BedrijfDTO = record50BedrijfMapper.toDto(record50Bedrijf);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord50BedrijfMockMvc.perform(put("/api/record-50-bedrijfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record50BedrijfDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record50Bedrijf in the database
        List<Record50Bedrijf> record50BedrijfList = record50BedrijfRepository.findAll();
        assertThat(record50BedrijfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord50Bedrijf() throws Exception {
        // Initialize the database
        record50BedrijfRepository.saveAndFlush(record50Bedrijf);

        int databaseSizeBeforeDelete = record50BedrijfRepository.findAll().size();

        // Get the record50Bedrijf
        restRecord50BedrijfMockMvc.perform(delete("/api/record-50-bedrijfs/{id}", record50Bedrijf.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record50Bedrijf> record50BedrijfList = record50BedrijfRepository.findAll();
        assertThat(record50BedrijfList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record50Bedrijf.class);
        Record50Bedrijf record50Bedrijf1 = new Record50Bedrijf();
        record50Bedrijf1.setId(1L);
        Record50Bedrijf record50Bedrijf2 = new Record50Bedrijf();
        record50Bedrijf2.setId(record50Bedrijf1.getId());
        assertThat(record50Bedrijf1).isEqualTo(record50Bedrijf2);
        record50Bedrijf2.setId(2L);
        assertThat(record50Bedrijf1).isNotEqualTo(record50Bedrijf2);
        record50Bedrijf1.setId(null);
        assertThat(record50Bedrijf1).isNotEqualTo(record50Bedrijf2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record50BedrijfDTO.class);
        Record50BedrijfDTO record50BedrijfDTO1 = new Record50BedrijfDTO();
        record50BedrijfDTO1.setId(1L);
        Record50BedrijfDTO record50BedrijfDTO2 = new Record50BedrijfDTO();
        assertThat(record50BedrijfDTO1).isNotEqualTo(record50BedrijfDTO2);
        record50BedrijfDTO2.setId(record50BedrijfDTO1.getId());
        assertThat(record50BedrijfDTO1).isEqualTo(record50BedrijfDTO2);
        record50BedrijfDTO2.setId(2L);
        assertThat(record50BedrijfDTO1).isNotEqualTo(record50BedrijfDTO2);
        record50BedrijfDTO1.setId(null);
        assertThat(record50BedrijfDTO1).isNotEqualTo(record50BedrijfDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record50BedrijfMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record50BedrijfMapper.fromId(null)).isNull();
    }
}
