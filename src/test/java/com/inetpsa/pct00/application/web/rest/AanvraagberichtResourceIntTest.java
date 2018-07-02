package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Aanvraagbericht;
import com.inetpsa.pct00.application.repository.AanvraagberichtRepository;
import com.inetpsa.pct00.application.service.AanvraagberichtService;
import com.inetpsa.pct00.application.service.dto.AanvraagberichtDTO;
import com.inetpsa.pct00.application.service.mapper.AanvraagberichtMapper;
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
 * Test class for the AanvraagberichtResource REST controller.
 *
 * @see AanvraagberichtResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class AanvraagberichtResourceIntTest {

    @Autowired
    private AanvraagberichtRepository aanvraagberichtRepository;


    @Autowired
    private AanvraagberichtMapper aanvraagberichtMapper;
    

    @Autowired
    private AanvraagberichtService aanvraagberichtService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAanvraagberichtMockMvc;

    private Aanvraagbericht aanvraagbericht;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AanvraagberichtResource aanvraagberichtResource = new AanvraagberichtResource(aanvraagberichtService);
        this.restAanvraagberichtMockMvc = MockMvcBuilders.standaloneSetup(aanvraagberichtResource)
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
    public static Aanvraagbericht createEntity(EntityManager em) {
        Aanvraagbericht aanvraagbericht = new Aanvraagbericht();
        return aanvraagbericht;
    }

    @Before
    public void initTest() {
        aanvraagbericht = createEntity(em);
    }

    @Test
    @Transactional
    public void createAanvraagbericht() throws Exception {
        int databaseSizeBeforeCreate = aanvraagberichtRepository.findAll().size();

        // Create the Aanvraagbericht
        AanvraagberichtDTO aanvraagberichtDTO = aanvraagberichtMapper.toDto(aanvraagbericht);
        restAanvraagberichtMockMvc.perform(post("/api/aanvraagberichts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aanvraagberichtDTO)))
            .andExpect(status().isCreated());

        // Validate the Aanvraagbericht in the database
        List<Aanvraagbericht> aanvraagberichtList = aanvraagberichtRepository.findAll();
        assertThat(aanvraagberichtList).hasSize(databaseSizeBeforeCreate + 1);
        Aanvraagbericht testAanvraagbericht = aanvraagberichtList.get(aanvraagberichtList.size() - 1);
    }

    @Test
    @Transactional
    public void createAanvraagberichtWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aanvraagberichtRepository.findAll().size();

        // Create the Aanvraagbericht with an existing ID
        aanvraagbericht.setId(1L);
        AanvraagberichtDTO aanvraagberichtDTO = aanvraagberichtMapper.toDto(aanvraagbericht);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAanvraagberichtMockMvc.perform(post("/api/aanvraagberichts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aanvraagberichtDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Aanvraagbericht in the database
        List<Aanvraagbericht> aanvraagberichtList = aanvraagberichtRepository.findAll();
        assertThat(aanvraagberichtList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAanvraagberichts() throws Exception {
        // Initialize the database
        aanvraagberichtRepository.saveAndFlush(aanvraagbericht);

        // Get all the aanvraagberichtList
        restAanvraagberichtMockMvc.perform(get("/api/aanvraagberichts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aanvraagbericht.getId().intValue())));
    }
    

    @Test
    @Transactional
    public void getAanvraagbericht() throws Exception {
        // Initialize the database
        aanvraagberichtRepository.saveAndFlush(aanvraagbericht);

        // Get the aanvraagbericht
        restAanvraagberichtMockMvc.perform(get("/api/aanvraagberichts/{id}", aanvraagbericht.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(aanvraagbericht.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAanvraagbericht() throws Exception {
        // Get the aanvraagbericht
        restAanvraagberichtMockMvc.perform(get("/api/aanvraagberichts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAanvraagbericht() throws Exception {
        // Initialize the database
        aanvraagberichtRepository.saveAndFlush(aanvraagbericht);

        int databaseSizeBeforeUpdate = aanvraagberichtRepository.findAll().size();

        // Update the aanvraagbericht
        Aanvraagbericht updatedAanvraagbericht = aanvraagberichtRepository.findById(aanvraagbericht.getId()).get();
        // Disconnect from session so that the updates on updatedAanvraagbericht are not directly saved in db
        em.detach(updatedAanvraagbericht);
        AanvraagberichtDTO aanvraagberichtDTO = aanvraagberichtMapper.toDto(updatedAanvraagbericht);

        restAanvraagberichtMockMvc.perform(put("/api/aanvraagberichts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aanvraagberichtDTO)))
            .andExpect(status().isOk());

        // Validate the Aanvraagbericht in the database
        List<Aanvraagbericht> aanvraagberichtList = aanvraagberichtRepository.findAll();
        assertThat(aanvraagberichtList).hasSize(databaseSizeBeforeUpdate);
        Aanvraagbericht testAanvraagbericht = aanvraagberichtList.get(aanvraagberichtList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingAanvraagbericht() throws Exception {
        int databaseSizeBeforeUpdate = aanvraagberichtRepository.findAll().size();

        // Create the Aanvraagbericht
        AanvraagberichtDTO aanvraagberichtDTO = aanvraagberichtMapper.toDto(aanvraagbericht);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAanvraagberichtMockMvc.perform(put("/api/aanvraagberichts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(aanvraagberichtDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Aanvraagbericht in the database
        List<Aanvraagbericht> aanvraagberichtList = aanvraagberichtRepository.findAll();
        assertThat(aanvraagberichtList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAanvraagbericht() throws Exception {
        // Initialize the database
        aanvraagberichtRepository.saveAndFlush(aanvraagbericht);

        int databaseSizeBeforeDelete = aanvraagberichtRepository.findAll().size();

        // Get the aanvraagbericht
        restAanvraagberichtMockMvc.perform(delete("/api/aanvraagberichts/{id}", aanvraagbericht.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Aanvraagbericht> aanvraagberichtList = aanvraagberichtRepository.findAll();
        assertThat(aanvraagberichtList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Aanvraagbericht.class);
        Aanvraagbericht aanvraagbericht1 = new Aanvraagbericht();
        aanvraagbericht1.setId(1L);
        Aanvraagbericht aanvraagbericht2 = new Aanvraagbericht();
        aanvraagbericht2.setId(aanvraagbericht1.getId());
        assertThat(aanvraagbericht1).isEqualTo(aanvraagbericht2);
        aanvraagbericht2.setId(2L);
        assertThat(aanvraagbericht1).isNotEqualTo(aanvraagbericht2);
        aanvraagbericht1.setId(null);
        assertThat(aanvraagbericht1).isNotEqualTo(aanvraagbericht2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AanvraagberichtDTO.class);
        AanvraagberichtDTO aanvraagberichtDTO1 = new AanvraagberichtDTO();
        aanvraagberichtDTO1.setId(1L);
        AanvraagberichtDTO aanvraagberichtDTO2 = new AanvraagberichtDTO();
        assertThat(aanvraagberichtDTO1).isNotEqualTo(aanvraagberichtDTO2);
        aanvraagberichtDTO2.setId(aanvraagberichtDTO1.getId());
        assertThat(aanvraagberichtDTO1).isEqualTo(aanvraagberichtDTO2);
        aanvraagberichtDTO2.setId(2L);
        assertThat(aanvraagberichtDTO1).isNotEqualTo(aanvraagberichtDTO2);
        aanvraagberichtDTO1.setId(null);
        assertThat(aanvraagberichtDTO1).isNotEqualTo(aanvraagberichtDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(aanvraagberichtMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(aanvraagberichtMapper.fromId(null)).isNull();
    }
}
