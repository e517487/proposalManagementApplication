package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Legitimatiebewijs;
import com.inetpsa.pct00.application.repository.LegitimatiebewijsRepository;
import com.inetpsa.pct00.application.service.LegitimatiebewijsService;
import com.inetpsa.pct00.application.service.dto.LegitimatiebewijsDTO;
import com.inetpsa.pct00.application.service.mapper.LegitimatiebewijsMapper;
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
 * Test class for the LegitimatiebewijsResource REST controller.
 *
 * @see LegitimatiebewijsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class LegitimatiebewijsResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_SOORT = "AAAAAAAAAA";
    private static final String UPDATED_SOORT = "BBBBBBBBBB";

    private static final String DEFAULT_LAND = "AAAAAAAAAA";
    private static final String UPDATED_LAND = "BBBBBBBBBB";

    @Autowired
    private LegitimatiebewijsRepository legitimatiebewijsRepository;


    @Autowired
    private LegitimatiebewijsMapper legitimatiebewijsMapper;
    

    @Autowired
    private LegitimatiebewijsService legitimatiebewijsService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restLegitimatiebewijsMockMvc;

    private Legitimatiebewijs legitimatiebewijs;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final LegitimatiebewijsResource legitimatiebewijsResource = new LegitimatiebewijsResource(legitimatiebewijsService);
        this.restLegitimatiebewijsMockMvc = MockMvcBuilders.standaloneSetup(legitimatiebewijsResource)
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
    public static Legitimatiebewijs createEntity(EntityManager em) {
        Legitimatiebewijs legitimatiebewijs = new Legitimatiebewijs()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .soort(DEFAULT_SOORT)
            .land(DEFAULT_LAND);
        return legitimatiebewijs;
    }

    @Before
    public void initTest() {
        legitimatiebewijs = createEntity(em);
    }

    @Test
    @Transactional
    public void createLegitimatiebewijs() throws Exception {
        int databaseSizeBeforeCreate = legitimatiebewijsRepository.findAll().size();

        // Create the Legitimatiebewijs
        LegitimatiebewijsDTO legitimatiebewijsDTO = legitimatiebewijsMapper.toDto(legitimatiebewijs);
        restLegitimatiebewijsMockMvc.perform(post("/api/legitimatiebewijs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(legitimatiebewijsDTO)))
            .andExpect(status().isCreated());

        // Validate the Legitimatiebewijs in the database
        List<Legitimatiebewijs> legitimatiebewijsList = legitimatiebewijsRepository.findAll();
        assertThat(legitimatiebewijsList).hasSize(databaseSizeBeforeCreate + 1);
        Legitimatiebewijs testLegitimatiebewijs = legitimatiebewijsList.get(legitimatiebewijsList.size() - 1);
        assertThat(testLegitimatiebewijs.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testLegitimatiebewijs.getSoort()).isEqualTo(DEFAULT_SOORT);
        assertThat(testLegitimatiebewijs.getLand()).isEqualTo(DEFAULT_LAND);
    }

    @Test
    @Transactional
    public void createLegitimatiebewijsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = legitimatiebewijsRepository.findAll().size();

        // Create the Legitimatiebewijs with an existing ID
        legitimatiebewijs.setId(1L);
        LegitimatiebewijsDTO legitimatiebewijsDTO = legitimatiebewijsMapper.toDto(legitimatiebewijs);

        // An entity with an existing ID cannot be created, so this API call must fail
        restLegitimatiebewijsMockMvc.perform(post("/api/legitimatiebewijs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(legitimatiebewijsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Legitimatiebewijs in the database
        List<Legitimatiebewijs> legitimatiebewijsList = legitimatiebewijsRepository.findAll();
        assertThat(legitimatiebewijsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllLegitimatiebewijs() throws Exception {
        // Initialize the database
        legitimatiebewijsRepository.saveAndFlush(legitimatiebewijs);

        // Get all the legitimatiebewijsList
        restLegitimatiebewijsMockMvc.perform(get("/api/legitimatiebewijs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(legitimatiebewijs.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].soort").value(hasItem(DEFAULT_SOORT.toString())))
            .andExpect(jsonPath("$.[*].land").value(hasItem(DEFAULT_LAND.toString())));
    }
    

    @Test
    @Transactional
    public void getLegitimatiebewijs() throws Exception {
        // Initialize the database
        legitimatiebewijsRepository.saveAndFlush(legitimatiebewijs);

        // Get the legitimatiebewijs
        restLegitimatiebewijsMockMvc.perform(get("/api/legitimatiebewijs/{id}", legitimatiebewijs.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(legitimatiebewijs.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.soort").value(DEFAULT_SOORT.toString()))
            .andExpect(jsonPath("$.land").value(DEFAULT_LAND.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingLegitimatiebewijs() throws Exception {
        // Get the legitimatiebewijs
        restLegitimatiebewijsMockMvc.perform(get("/api/legitimatiebewijs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateLegitimatiebewijs() throws Exception {
        // Initialize the database
        legitimatiebewijsRepository.saveAndFlush(legitimatiebewijs);

        int databaseSizeBeforeUpdate = legitimatiebewijsRepository.findAll().size();

        // Update the legitimatiebewijs
        Legitimatiebewijs updatedLegitimatiebewijs = legitimatiebewijsRepository.findById(legitimatiebewijs.getId()).get();
        // Disconnect from session so that the updates on updatedLegitimatiebewijs are not directly saved in db
        em.detach(updatedLegitimatiebewijs);
        updatedLegitimatiebewijs
            .volgnummer(UPDATED_VOLGNUMMER)
            .soort(UPDATED_SOORT)
            .land(UPDATED_LAND);
        LegitimatiebewijsDTO legitimatiebewijsDTO = legitimatiebewijsMapper.toDto(updatedLegitimatiebewijs);

        restLegitimatiebewijsMockMvc.perform(put("/api/legitimatiebewijs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(legitimatiebewijsDTO)))
            .andExpect(status().isOk());

        // Validate the Legitimatiebewijs in the database
        List<Legitimatiebewijs> legitimatiebewijsList = legitimatiebewijsRepository.findAll();
        assertThat(legitimatiebewijsList).hasSize(databaseSizeBeforeUpdate);
        Legitimatiebewijs testLegitimatiebewijs = legitimatiebewijsList.get(legitimatiebewijsList.size() - 1);
        assertThat(testLegitimatiebewijs.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testLegitimatiebewijs.getSoort()).isEqualTo(UPDATED_SOORT);
        assertThat(testLegitimatiebewijs.getLand()).isEqualTo(UPDATED_LAND);
    }

    @Test
    @Transactional
    public void updateNonExistingLegitimatiebewijs() throws Exception {
        int databaseSizeBeforeUpdate = legitimatiebewijsRepository.findAll().size();

        // Create the Legitimatiebewijs
        LegitimatiebewijsDTO legitimatiebewijsDTO = legitimatiebewijsMapper.toDto(legitimatiebewijs);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restLegitimatiebewijsMockMvc.perform(put("/api/legitimatiebewijs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(legitimatiebewijsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Legitimatiebewijs in the database
        List<Legitimatiebewijs> legitimatiebewijsList = legitimatiebewijsRepository.findAll();
        assertThat(legitimatiebewijsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteLegitimatiebewijs() throws Exception {
        // Initialize the database
        legitimatiebewijsRepository.saveAndFlush(legitimatiebewijs);

        int databaseSizeBeforeDelete = legitimatiebewijsRepository.findAll().size();

        // Get the legitimatiebewijs
        restLegitimatiebewijsMockMvc.perform(delete("/api/legitimatiebewijs/{id}", legitimatiebewijs.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Legitimatiebewijs> legitimatiebewijsList = legitimatiebewijsRepository.findAll();
        assertThat(legitimatiebewijsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Legitimatiebewijs.class);
        Legitimatiebewijs legitimatiebewijs1 = new Legitimatiebewijs();
        legitimatiebewijs1.setId(1L);
        Legitimatiebewijs legitimatiebewijs2 = new Legitimatiebewijs();
        legitimatiebewijs2.setId(legitimatiebewijs1.getId());
        assertThat(legitimatiebewijs1).isEqualTo(legitimatiebewijs2);
        legitimatiebewijs2.setId(2L);
        assertThat(legitimatiebewijs1).isNotEqualTo(legitimatiebewijs2);
        legitimatiebewijs1.setId(null);
        assertThat(legitimatiebewijs1).isNotEqualTo(legitimatiebewijs2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(LegitimatiebewijsDTO.class);
        LegitimatiebewijsDTO legitimatiebewijsDTO1 = new LegitimatiebewijsDTO();
        legitimatiebewijsDTO1.setId(1L);
        LegitimatiebewijsDTO legitimatiebewijsDTO2 = new LegitimatiebewijsDTO();
        assertThat(legitimatiebewijsDTO1).isNotEqualTo(legitimatiebewijsDTO2);
        legitimatiebewijsDTO2.setId(legitimatiebewijsDTO1.getId());
        assertThat(legitimatiebewijsDTO1).isEqualTo(legitimatiebewijsDTO2);
        legitimatiebewijsDTO2.setId(2L);
        assertThat(legitimatiebewijsDTO1).isNotEqualTo(legitimatiebewijsDTO2);
        legitimatiebewijsDTO1.setId(null);
        assertThat(legitimatiebewijsDTO1).isNotEqualTo(legitimatiebewijsDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(legitimatiebewijsMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(legitimatiebewijsMapper.fromId(null)).isNull();
    }
}
