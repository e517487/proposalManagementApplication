package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Record99End;
import com.inetpsa.pct00.application.repository.Record99EndRepository;
import com.inetpsa.pct00.application.service.dto.Record99EndDTO;
import com.inetpsa.pct00.application.service.mapper.Record99EndMapper;
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
 * Test class for the Record99EndResource REST controller.
 *
 * @see Record99EndResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class Record99EndResourceIntTest {

    private static final String DEFAULT_PC_FINET_NR = "AAAAAAAAAA";
    private static final String UPDATED_PC_FINET_NR = "BBBBBBBBBB";

    private static final Integer DEFAULT_RECORD_TYPE = 1;
    private static final Integer UPDATED_RECORD_TYPE = 2;

    private static final Integer DEFAULT_VOLGNR = 1;
    private static final Integer UPDATED_VOLGNR = 2;

    private static final LocalDate DEFAULT_CREATIE_DATUM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATIE_DATUM = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_CREATIE_TIJD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATIE_TIJD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Integer DEFAULT_AANTAL_AANVRAGEN = 1;
    private static final Integer UPDATED_AANTAL_AANVRAGEN = 2;

    private static final Integer DEFAULT_AANTAL_REGELS = 1;
    private static final Integer UPDATED_AANTAL_REGELS = 2;

    @Autowired
    private Record99EndRepository record99EndRepository;


    @Autowired
    private Record99EndMapper record99EndMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRecord99EndMockMvc;

    private Record99End record99End;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final Record99EndResource record99EndResource = new Record99EndResource(record99EndRepository, record99EndMapper);
        this.restRecord99EndMockMvc = MockMvcBuilders.standaloneSetup(record99EndResource)
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
    public static Record99End createEntity(EntityManager em) {
        Record99End record99End = new Record99End()
            .pcFinetNr(DEFAULT_PC_FINET_NR)
            .recordType(DEFAULT_RECORD_TYPE)
            .volgnr(DEFAULT_VOLGNR)
            .creatieDatum(DEFAULT_CREATIE_DATUM)
            .creatieTijd(DEFAULT_CREATIE_TIJD)
            .aantalAanvragen(DEFAULT_AANTAL_AANVRAGEN)
            .aantalRegels(DEFAULT_AANTAL_REGELS);
        return record99End;
    }

    @Before
    public void initTest() {
        record99End = createEntity(em);
    }

    @Test
    @Transactional
    public void createRecord99End() throws Exception {
        int databaseSizeBeforeCreate = record99EndRepository.findAll().size();

        // Create the Record99End
        Record99EndDTO record99EndDTO = record99EndMapper.toDto(record99End);
        restRecord99EndMockMvc.perform(post("/api/record-99-ends")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99EndDTO)))
            .andExpect(status().isCreated());

        // Validate the Record99End in the database
        List<Record99End> record99EndList = record99EndRepository.findAll();
        assertThat(record99EndList).hasSize(databaseSizeBeforeCreate + 1);
        Record99End testRecord99End = record99EndList.get(record99EndList.size() - 1);
        assertThat(testRecord99End.getPcFinetNr()).isEqualTo(DEFAULT_PC_FINET_NR);
        assertThat(testRecord99End.getRecordType()).isEqualTo(DEFAULT_RECORD_TYPE);
        assertThat(testRecord99End.getVolgnr()).isEqualTo(DEFAULT_VOLGNR);
        assertThat(testRecord99End.getCreatieDatum()).isEqualTo(DEFAULT_CREATIE_DATUM);
        assertThat(testRecord99End.getCreatieTijd()).isEqualTo(DEFAULT_CREATIE_TIJD);
        assertThat(testRecord99End.getAantalAanvragen()).isEqualTo(DEFAULT_AANTAL_AANVRAGEN);
        assertThat(testRecord99End.getAantalRegels()).isEqualTo(DEFAULT_AANTAL_REGELS);
    }

    @Test
    @Transactional
    public void createRecord99EndWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = record99EndRepository.findAll().size();

        // Create the Record99End with an existing ID
        record99End.setId(1L);
        Record99EndDTO record99EndDTO = record99EndMapper.toDto(record99End);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRecord99EndMockMvc.perform(post("/api/record-99-ends")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99EndDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record99End in the database
        List<Record99End> record99EndList = record99EndRepository.findAll();
        assertThat(record99EndList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRecord99Ends() throws Exception {
        // Initialize the database
        record99EndRepository.saveAndFlush(record99End);

        // Get all the record99EndList
        restRecord99EndMockMvc.perform(get("/api/record-99-ends?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(record99End.getId().intValue())))
            .andExpect(jsonPath("$.[*].pcFinetNr").value(hasItem(DEFAULT_PC_FINET_NR.toString())))
            .andExpect(jsonPath("$.[*].recordType").value(hasItem(DEFAULT_RECORD_TYPE)))
            .andExpect(jsonPath("$.[*].volgnr").value(hasItem(DEFAULT_VOLGNR)))
            .andExpect(jsonPath("$.[*].creatieDatum").value(hasItem(DEFAULT_CREATIE_DATUM.toString())))
            .andExpect(jsonPath("$.[*].creatieTijd").value(hasItem(sameInstant(DEFAULT_CREATIE_TIJD))))
            .andExpect(jsonPath("$.[*].aantalAanvragen").value(hasItem(DEFAULT_AANTAL_AANVRAGEN)))
            .andExpect(jsonPath("$.[*].aantalRegels").value(hasItem(DEFAULT_AANTAL_REGELS)));
    }
    

    @Test
    @Transactional
    public void getRecord99End() throws Exception {
        // Initialize the database
        record99EndRepository.saveAndFlush(record99End);

        // Get the record99End
        restRecord99EndMockMvc.perform(get("/api/record-99-ends/{id}", record99End.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(record99End.getId().intValue()))
            .andExpect(jsonPath("$.pcFinetNr").value(DEFAULT_PC_FINET_NR.toString()))
            .andExpect(jsonPath("$.recordType").value(DEFAULT_RECORD_TYPE))
            .andExpect(jsonPath("$.volgnr").value(DEFAULT_VOLGNR))
            .andExpect(jsonPath("$.creatieDatum").value(DEFAULT_CREATIE_DATUM.toString()))
            .andExpect(jsonPath("$.creatieTijd").value(sameInstant(DEFAULT_CREATIE_TIJD)))
            .andExpect(jsonPath("$.aantalAanvragen").value(DEFAULT_AANTAL_AANVRAGEN))
            .andExpect(jsonPath("$.aantalRegels").value(DEFAULT_AANTAL_REGELS));
    }
    @Test
    @Transactional
    public void getNonExistingRecord99End() throws Exception {
        // Get the record99End
        restRecord99EndMockMvc.perform(get("/api/record-99-ends/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRecord99End() throws Exception {
        // Initialize the database
        record99EndRepository.saveAndFlush(record99End);

        int databaseSizeBeforeUpdate = record99EndRepository.findAll().size();

        // Update the record99End
        Record99End updatedRecord99End = record99EndRepository.findById(record99End.getId()).get();
        // Disconnect from session so that the updates on updatedRecord99End are not directly saved in db
        em.detach(updatedRecord99End);
        updatedRecord99End
            .pcFinetNr(UPDATED_PC_FINET_NR)
            .recordType(UPDATED_RECORD_TYPE)
            .volgnr(UPDATED_VOLGNR)
            .creatieDatum(UPDATED_CREATIE_DATUM)
            .creatieTijd(UPDATED_CREATIE_TIJD)
            .aantalAanvragen(UPDATED_AANTAL_AANVRAGEN)
            .aantalRegels(UPDATED_AANTAL_REGELS);
        Record99EndDTO record99EndDTO = record99EndMapper.toDto(updatedRecord99End);

        restRecord99EndMockMvc.perform(put("/api/record-99-ends")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99EndDTO)))
            .andExpect(status().isOk());

        // Validate the Record99End in the database
        List<Record99End> record99EndList = record99EndRepository.findAll();
        assertThat(record99EndList).hasSize(databaseSizeBeforeUpdate);
        Record99End testRecord99End = record99EndList.get(record99EndList.size() - 1);
        assertThat(testRecord99End.getPcFinetNr()).isEqualTo(UPDATED_PC_FINET_NR);
        assertThat(testRecord99End.getRecordType()).isEqualTo(UPDATED_RECORD_TYPE);
        assertThat(testRecord99End.getVolgnr()).isEqualTo(UPDATED_VOLGNR);
        assertThat(testRecord99End.getCreatieDatum()).isEqualTo(UPDATED_CREATIE_DATUM);
        assertThat(testRecord99End.getCreatieTijd()).isEqualTo(UPDATED_CREATIE_TIJD);
        assertThat(testRecord99End.getAantalAanvragen()).isEqualTo(UPDATED_AANTAL_AANVRAGEN);
        assertThat(testRecord99End.getAantalRegels()).isEqualTo(UPDATED_AANTAL_REGELS);
    }

    @Test
    @Transactional
    public void updateNonExistingRecord99End() throws Exception {
        int databaseSizeBeforeUpdate = record99EndRepository.findAll().size();

        // Create the Record99End
        Record99EndDTO record99EndDTO = record99EndMapper.toDto(record99End);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRecord99EndMockMvc.perform(put("/api/record-99-ends")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(record99EndDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Record99End in the database
        List<Record99End> record99EndList = record99EndRepository.findAll();
        assertThat(record99EndList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRecord99End() throws Exception {
        // Initialize the database
        record99EndRepository.saveAndFlush(record99End);

        int databaseSizeBeforeDelete = record99EndRepository.findAll().size();

        // Get the record99End
        restRecord99EndMockMvc.perform(delete("/api/record-99-ends/{id}", record99End.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Record99End> record99EndList = record99EndRepository.findAll();
        assertThat(record99EndList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record99End.class);
        Record99End record99End1 = new Record99End();
        record99End1.setId(1L);
        Record99End record99End2 = new Record99End();
        record99End2.setId(record99End1.getId());
        assertThat(record99End1).isEqualTo(record99End2);
        record99End2.setId(2L);
        assertThat(record99End1).isNotEqualTo(record99End2);
        record99End1.setId(null);
        assertThat(record99End1).isNotEqualTo(record99End2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(Record99EndDTO.class);
        Record99EndDTO record99EndDTO1 = new Record99EndDTO();
        record99EndDTO1.setId(1L);
        Record99EndDTO record99EndDTO2 = new Record99EndDTO();
        assertThat(record99EndDTO1).isNotEqualTo(record99EndDTO2);
        record99EndDTO2.setId(record99EndDTO1.getId());
        assertThat(record99EndDTO1).isEqualTo(record99EndDTO2);
        record99EndDTO2.setId(2L);
        assertThat(record99EndDTO1).isNotEqualTo(record99EndDTO2);
        record99EndDTO1.setId(null);
        assertThat(record99EndDTO1).isNotEqualTo(record99EndDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(record99EndMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(record99EndMapper.fromId(null)).isNull();
    }
}
