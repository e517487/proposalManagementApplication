package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.TekstRegel;
import com.inetpsa.pct00.application.repository.TekstRegelRepository;
import com.inetpsa.pct00.application.service.TekstRegelService;
import com.inetpsa.pct00.application.service.dto.TekstRegelDTO;
import com.inetpsa.pct00.application.service.mapper.TekstRegelMapper;
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
 * Test class for the TekstRegelResource REST controller.
 *
 * @see TekstRegelResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class TekstRegelResourceIntTest {

    private static final Long DEFAULT_REGELNUMMER = 1L;
    private static final Long UPDATED_REGELNUMMER = 2L;

    private static final String DEFAULT_TEKST = "AAAAAAAAAA";
    private static final String UPDATED_TEKST = "BBBBBBBBBB";

    @Autowired
    private TekstRegelRepository tekstRegelRepository;


    @Autowired
    private TekstRegelMapper tekstRegelMapper;
    

    @Autowired
    private TekstRegelService tekstRegelService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTekstRegelMockMvc;

    private TekstRegel tekstRegel;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TekstRegelResource tekstRegelResource = new TekstRegelResource(tekstRegelService);
        this.restTekstRegelMockMvc = MockMvcBuilders.standaloneSetup(tekstRegelResource)
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
    public static TekstRegel createEntity(EntityManager em) {
        TekstRegel tekstRegel = new TekstRegel()
            .regelnummer(DEFAULT_REGELNUMMER)
            .tekst(DEFAULT_TEKST);
        return tekstRegel;
    }

    @Before
    public void initTest() {
        tekstRegel = createEntity(em);
    }

    @Test
    @Transactional
    public void createTekstRegel() throws Exception {
        int databaseSizeBeforeCreate = tekstRegelRepository.findAll().size();

        // Create the TekstRegel
        TekstRegelDTO tekstRegelDTO = tekstRegelMapper.toDto(tekstRegel);
        restTekstRegelMockMvc.perform(post("/api/tekst-regels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tekstRegelDTO)))
            .andExpect(status().isCreated());

        // Validate the TekstRegel in the database
        List<TekstRegel> tekstRegelList = tekstRegelRepository.findAll();
        assertThat(tekstRegelList).hasSize(databaseSizeBeforeCreate + 1);
        TekstRegel testTekstRegel = tekstRegelList.get(tekstRegelList.size() - 1);
        assertThat(testTekstRegel.getRegelnummer()).isEqualTo(DEFAULT_REGELNUMMER);
        assertThat(testTekstRegel.getTekst()).isEqualTo(DEFAULT_TEKST);
    }

    @Test
    @Transactional
    public void createTekstRegelWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = tekstRegelRepository.findAll().size();

        // Create the TekstRegel with an existing ID
        tekstRegel.setId(1L);
        TekstRegelDTO tekstRegelDTO = tekstRegelMapper.toDto(tekstRegel);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTekstRegelMockMvc.perform(post("/api/tekst-regels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tekstRegelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TekstRegel in the database
        List<TekstRegel> tekstRegelList = tekstRegelRepository.findAll();
        assertThat(tekstRegelList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllTekstRegels() throws Exception {
        // Initialize the database
        tekstRegelRepository.saveAndFlush(tekstRegel);

        // Get all the tekstRegelList
        restTekstRegelMockMvc.perform(get("/api/tekst-regels?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tekstRegel.getId().intValue())))
            .andExpect(jsonPath("$.[*].regelnummer").value(hasItem(DEFAULT_REGELNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].tekst").value(hasItem(DEFAULT_TEKST.toString())));
    }
    

    @Test
    @Transactional
    public void getTekstRegel() throws Exception {
        // Initialize the database
        tekstRegelRepository.saveAndFlush(tekstRegel);

        // Get the tekstRegel
        restTekstRegelMockMvc.perform(get("/api/tekst-regels/{id}", tekstRegel.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(tekstRegel.getId().intValue()))
            .andExpect(jsonPath("$.regelnummer").value(DEFAULT_REGELNUMMER.intValue()))
            .andExpect(jsonPath("$.tekst").value(DEFAULT_TEKST.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingTekstRegel() throws Exception {
        // Get the tekstRegel
        restTekstRegelMockMvc.perform(get("/api/tekst-regels/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTekstRegel() throws Exception {
        // Initialize the database
        tekstRegelRepository.saveAndFlush(tekstRegel);

        int databaseSizeBeforeUpdate = tekstRegelRepository.findAll().size();

        // Update the tekstRegel
        TekstRegel updatedTekstRegel = tekstRegelRepository.findById(tekstRegel.getId()).get();
        // Disconnect from session so that the updates on updatedTekstRegel are not directly saved in db
        em.detach(updatedTekstRegel);
        updatedTekstRegel
            .regelnummer(UPDATED_REGELNUMMER)
            .tekst(UPDATED_TEKST);
        TekstRegelDTO tekstRegelDTO = tekstRegelMapper.toDto(updatedTekstRegel);

        restTekstRegelMockMvc.perform(put("/api/tekst-regels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tekstRegelDTO)))
            .andExpect(status().isOk());

        // Validate the TekstRegel in the database
        List<TekstRegel> tekstRegelList = tekstRegelRepository.findAll();
        assertThat(tekstRegelList).hasSize(databaseSizeBeforeUpdate);
        TekstRegel testTekstRegel = tekstRegelList.get(tekstRegelList.size() - 1);
        assertThat(testTekstRegel.getRegelnummer()).isEqualTo(UPDATED_REGELNUMMER);
        assertThat(testTekstRegel.getTekst()).isEqualTo(UPDATED_TEKST);
    }

    @Test
    @Transactional
    public void updateNonExistingTekstRegel() throws Exception {
        int databaseSizeBeforeUpdate = tekstRegelRepository.findAll().size();

        // Create the TekstRegel
        TekstRegelDTO tekstRegelDTO = tekstRegelMapper.toDto(tekstRegel);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTekstRegelMockMvc.perform(put("/api/tekst-regels")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(tekstRegelDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TekstRegel in the database
        List<TekstRegel> tekstRegelList = tekstRegelRepository.findAll();
        assertThat(tekstRegelList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTekstRegel() throws Exception {
        // Initialize the database
        tekstRegelRepository.saveAndFlush(tekstRegel);

        int databaseSizeBeforeDelete = tekstRegelRepository.findAll().size();

        // Get the tekstRegel
        restTekstRegelMockMvc.perform(delete("/api/tekst-regels/{id}", tekstRegel.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<TekstRegel> tekstRegelList = tekstRegelRepository.findAll();
        assertThat(tekstRegelList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TekstRegel.class);
        TekstRegel tekstRegel1 = new TekstRegel();
        tekstRegel1.setId(1L);
        TekstRegel tekstRegel2 = new TekstRegel();
        tekstRegel2.setId(tekstRegel1.getId());
        assertThat(tekstRegel1).isEqualTo(tekstRegel2);
        tekstRegel2.setId(2L);
        assertThat(tekstRegel1).isNotEqualTo(tekstRegel2);
        tekstRegel1.setId(null);
        assertThat(tekstRegel1).isNotEqualTo(tekstRegel2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TekstRegelDTO.class);
        TekstRegelDTO tekstRegelDTO1 = new TekstRegelDTO();
        tekstRegelDTO1.setId(1L);
        TekstRegelDTO tekstRegelDTO2 = new TekstRegelDTO();
        assertThat(tekstRegelDTO1).isNotEqualTo(tekstRegelDTO2);
        tekstRegelDTO2.setId(tekstRegelDTO1.getId());
        assertThat(tekstRegelDTO1).isEqualTo(tekstRegelDTO2);
        tekstRegelDTO2.setId(2L);
        assertThat(tekstRegelDTO1).isNotEqualTo(tekstRegelDTO2);
        tekstRegelDTO1.setId(null);
        assertThat(tekstRegelDTO1).isNotEqualTo(tekstRegelDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(tekstRegelMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(tekstRegelMapper.fromId(null)).isNull();
    }
}
