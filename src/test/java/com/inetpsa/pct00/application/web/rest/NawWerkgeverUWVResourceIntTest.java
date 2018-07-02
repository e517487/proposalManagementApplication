package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.NawWerkgeverUWV;
import com.inetpsa.pct00.application.repository.NawWerkgeverUWVRepository;
import com.inetpsa.pct00.application.service.NawWerkgeverUWVService;
import com.inetpsa.pct00.application.service.dto.NawWerkgeverUWVDTO;
import com.inetpsa.pct00.application.service.mapper.NawWerkgeverUWVMapper;
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
 * Test class for the NawWerkgeverUWVResource REST controller.
 *
 * @see NawWerkgeverUWVResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class NawWerkgeverUWVResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_PLAATS_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_PLAATS_NAAM = "BBBBBBBBBB";

    @Autowired
    private NawWerkgeverUWVRepository nawWerkgeverUWVRepository;


    @Autowired
    private NawWerkgeverUWVMapper nawWerkgeverUWVMapper;
    

    @Autowired
    private NawWerkgeverUWVService nawWerkgeverUWVService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restNawWerkgeverUWVMockMvc;

    private NawWerkgeverUWV nawWerkgeverUWV;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final NawWerkgeverUWVResource nawWerkgeverUWVResource = new NawWerkgeverUWVResource(nawWerkgeverUWVService);
        this.restNawWerkgeverUWVMockMvc = MockMvcBuilders.standaloneSetup(nawWerkgeverUWVResource)
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
    public static NawWerkgeverUWV createEntity(EntityManager em) {
        NawWerkgeverUWV nawWerkgeverUWV = new NawWerkgeverUWV()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .naam(DEFAULT_NAAM)
            .plaatsNaam(DEFAULT_PLAATS_NAAM);
        return nawWerkgeverUWV;
    }

    @Before
    public void initTest() {
        nawWerkgeverUWV = createEntity(em);
    }

    @Test
    @Transactional
    public void createNawWerkgeverUWV() throws Exception {
        int databaseSizeBeforeCreate = nawWerkgeverUWVRepository.findAll().size();

        // Create the NawWerkgeverUWV
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO = nawWerkgeverUWVMapper.toDto(nawWerkgeverUWV);
        restNawWerkgeverUWVMockMvc.perform(post("/api/naw-werkgever-uwvs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(nawWerkgeverUWVDTO)))
            .andExpect(status().isCreated());

        // Validate the NawWerkgeverUWV in the database
        List<NawWerkgeverUWV> nawWerkgeverUWVList = nawWerkgeverUWVRepository.findAll();
        assertThat(nawWerkgeverUWVList).hasSize(databaseSizeBeforeCreate + 1);
        NawWerkgeverUWV testNawWerkgeverUWV = nawWerkgeverUWVList.get(nawWerkgeverUWVList.size() - 1);
        assertThat(testNawWerkgeverUWV.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testNawWerkgeverUWV.getNaam()).isEqualTo(DEFAULT_NAAM);
        assertThat(testNawWerkgeverUWV.getPlaatsNaam()).isEqualTo(DEFAULT_PLAATS_NAAM);
    }

    @Test
    @Transactional
    public void createNawWerkgeverUWVWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = nawWerkgeverUWVRepository.findAll().size();

        // Create the NawWerkgeverUWV with an existing ID
        nawWerkgeverUWV.setId(1L);
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO = nawWerkgeverUWVMapper.toDto(nawWerkgeverUWV);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNawWerkgeverUWVMockMvc.perform(post("/api/naw-werkgever-uwvs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(nawWerkgeverUWVDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NawWerkgeverUWV in the database
        List<NawWerkgeverUWV> nawWerkgeverUWVList = nawWerkgeverUWVRepository.findAll();
        assertThat(nawWerkgeverUWVList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllNawWerkgeverUWVS() throws Exception {
        // Initialize the database
        nawWerkgeverUWVRepository.saveAndFlush(nawWerkgeverUWV);

        // Get all the nawWerkgeverUWVList
        restNawWerkgeverUWVMockMvc.perform(get("/api/naw-werkgever-uwvs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(nawWerkgeverUWV.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].naam").value(hasItem(DEFAULT_NAAM.toString())))
            .andExpect(jsonPath("$.[*].plaatsNaam").value(hasItem(DEFAULT_PLAATS_NAAM.toString())));
    }
    

    @Test
    @Transactional
    public void getNawWerkgeverUWV() throws Exception {
        // Initialize the database
        nawWerkgeverUWVRepository.saveAndFlush(nawWerkgeverUWV);

        // Get the nawWerkgeverUWV
        restNawWerkgeverUWVMockMvc.perform(get("/api/naw-werkgever-uwvs/{id}", nawWerkgeverUWV.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(nawWerkgeverUWV.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.naam").value(DEFAULT_NAAM.toString()))
            .andExpect(jsonPath("$.plaatsNaam").value(DEFAULT_PLAATS_NAAM.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingNawWerkgeverUWV() throws Exception {
        // Get the nawWerkgeverUWV
        restNawWerkgeverUWVMockMvc.perform(get("/api/naw-werkgever-uwvs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNawWerkgeverUWV() throws Exception {
        // Initialize the database
        nawWerkgeverUWVRepository.saveAndFlush(nawWerkgeverUWV);

        int databaseSizeBeforeUpdate = nawWerkgeverUWVRepository.findAll().size();

        // Update the nawWerkgeverUWV
        NawWerkgeverUWV updatedNawWerkgeverUWV = nawWerkgeverUWVRepository.findById(nawWerkgeverUWV.getId()).get();
        // Disconnect from session so that the updates on updatedNawWerkgeverUWV are not directly saved in db
        em.detach(updatedNawWerkgeverUWV);
        updatedNawWerkgeverUWV
            .volgnummer(UPDATED_VOLGNUMMER)
            .naam(UPDATED_NAAM)
            .plaatsNaam(UPDATED_PLAATS_NAAM);
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO = nawWerkgeverUWVMapper.toDto(updatedNawWerkgeverUWV);

        restNawWerkgeverUWVMockMvc.perform(put("/api/naw-werkgever-uwvs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(nawWerkgeverUWVDTO)))
            .andExpect(status().isOk());

        // Validate the NawWerkgeverUWV in the database
        List<NawWerkgeverUWV> nawWerkgeverUWVList = nawWerkgeverUWVRepository.findAll();
        assertThat(nawWerkgeverUWVList).hasSize(databaseSizeBeforeUpdate);
        NawWerkgeverUWV testNawWerkgeverUWV = nawWerkgeverUWVList.get(nawWerkgeverUWVList.size() - 1);
        assertThat(testNawWerkgeverUWV.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testNawWerkgeverUWV.getNaam()).isEqualTo(UPDATED_NAAM);
        assertThat(testNawWerkgeverUWV.getPlaatsNaam()).isEqualTo(UPDATED_PLAATS_NAAM);
    }

    @Test
    @Transactional
    public void updateNonExistingNawWerkgeverUWV() throws Exception {
        int databaseSizeBeforeUpdate = nawWerkgeverUWVRepository.findAll().size();

        // Create the NawWerkgeverUWV
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO = nawWerkgeverUWVMapper.toDto(nawWerkgeverUWV);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restNawWerkgeverUWVMockMvc.perform(put("/api/naw-werkgever-uwvs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(nawWerkgeverUWVDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NawWerkgeverUWV in the database
        List<NawWerkgeverUWV> nawWerkgeverUWVList = nawWerkgeverUWVRepository.findAll();
        assertThat(nawWerkgeverUWVList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNawWerkgeverUWV() throws Exception {
        // Initialize the database
        nawWerkgeverUWVRepository.saveAndFlush(nawWerkgeverUWV);

        int databaseSizeBeforeDelete = nawWerkgeverUWVRepository.findAll().size();

        // Get the nawWerkgeverUWV
        restNawWerkgeverUWVMockMvc.perform(delete("/api/naw-werkgever-uwvs/{id}", nawWerkgeverUWV.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<NawWerkgeverUWV> nawWerkgeverUWVList = nawWerkgeverUWVRepository.findAll();
        assertThat(nawWerkgeverUWVList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NawWerkgeverUWV.class);
        NawWerkgeverUWV nawWerkgeverUWV1 = new NawWerkgeverUWV();
        nawWerkgeverUWV1.setId(1L);
        NawWerkgeverUWV nawWerkgeverUWV2 = new NawWerkgeverUWV();
        nawWerkgeverUWV2.setId(nawWerkgeverUWV1.getId());
        assertThat(nawWerkgeverUWV1).isEqualTo(nawWerkgeverUWV2);
        nawWerkgeverUWV2.setId(2L);
        assertThat(nawWerkgeverUWV1).isNotEqualTo(nawWerkgeverUWV2);
        nawWerkgeverUWV1.setId(null);
        assertThat(nawWerkgeverUWV1).isNotEqualTo(nawWerkgeverUWV2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NawWerkgeverUWVDTO.class);
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO1 = new NawWerkgeverUWVDTO();
        nawWerkgeverUWVDTO1.setId(1L);
        NawWerkgeverUWVDTO nawWerkgeverUWVDTO2 = new NawWerkgeverUWVDTO();
        assertThat(nawWerkgeverUWVDTO1).isNotEqualTo(nawWerkgeverUWVDTO2);
        nawWerkgeverUWVDTO2.setId(nawWerkgeverUWVDTO1.getId());
        assertThat(nawWerkgeverUWVDTO1).isEqualTo(nawWerkgeverUWVDTO2);
        nawWerkgeverUWVDTO2.setId(2L);
        assertThat(nawWerkgeverUWVDTO1).isNotEqualTo(nawWerkgeverUWVDTO2);
        nawWerkgeverUWVDTO1.setId(null);
        assertThat(nawWerkgeverUWVDTO1).isNotEqualTo(nawWerkgeverUWVDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(nawWerkgeverUWVMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(nawWerkgeverUWVMapper.fromId(null)).isNull();
    }
}
