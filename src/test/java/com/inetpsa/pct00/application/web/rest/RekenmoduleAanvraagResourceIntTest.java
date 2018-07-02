package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.RekenmoduleAanvraag;
import com.inetpsa.pct00.application.repository.RekenmoduleAanvraagRepository;
import com.inetpsa.pct00.application.service.RekenmoduleAanvraagService;
import com.inetpsa.pct00.application.service.dto.RekenmoduleAanvraagDTO;
import com.inetpsa.pct00.application.service.mapper.RekenmoduleAanvraagMapper;
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
 * Test class for the RekenmoduleAanvraagResource REST controller.
 *
 * @see RekenmoduleAanvraagResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class RekenmoduleAanvraagResourceIntTest {

    private static final String DEFAULT_REKENMODULE_AANVRAAG_FILE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REKENMODULE_AANVRAAG_FILE_NAME = "BBBBBBBBBB";

    @Autowired
    private RekenmoduleAanvraagRepository rekenmoduleAanvraagRepository;


    @Autowired
    private RekenmoduleAanvraagMapper rekenmoduleAanvraagMapper;
    

    @Autowired
    private RekenmoduleAanvraagService rekenmoduleAanvraagService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRekenmoduleAanvraagMockMvc;

    private RekenmoduleAanvraag rekenmoduleAanvraag;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RekenmoduleAanvraagResource rekenmoduleAanvraagResource = new RekenmoduleAanvraagResource(rekenmoduleAanvraagService);
        this.restRekenmoduleAanvraagMockMvc = MockMvcBuilders.standaloneSetup(rekenmoduleAanvraagResource)
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
    public static RekenmoduleAanvraag createEntity(EntityManager em) {
        RekenmoduleAanvraag rekenmoduleAanvraag = new RekenmoduleAanvraag()
            .rekenmoduleAanvraagFileName(DEFAULT_REKENMODULE_AANVRAAG_FILE_NAME);
        return rekenmoduleAanvraag;
    }

    @Before
    public void initTest() {
        rekenmoduleAanvraag = createEntity(em);
    }

    @Test
    @Transactional
    public void createRekenmoduleAanvraag() throws Exception {
        int databaseSizeBeforeCreate = rekenmoduleAanvraagRepository.findAll().size();

        // Create the RekenmoduleAanvraag
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO = rekenmoduleAanvraagMapper.toDto(rekenmoduleAanvraag);
        restRekenmoduleAanvraagMockMvc.perform(post("/api/rekenmodule-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rekenmoduleAanvraagDTO)))
            .andExpect(status().isCreated());

        // Validate the RekenmoduleAanvraag in the database
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = rekenmoduleAanvraagRepository.findAll();
        assertThat(rekenmoduleAanvraagList).hasSize(databaseSizeBeforeCreate + 1);
        RekenmoduleAanvraag testRekenmoduleAanvraag = rekenmoduleAanvraagList.get(rekenmoduleAanvraagList.size() - 1);
        assertThat(testRekenmoduleAanvraag.getRekenmoduleAanvraagFileName()).isEqualTo(DEFAULT_REKENMODULE_AANVRAAG_FILE_NAME);
    }

    @Test
    @Transactional
    public void createRekenmoduleAanvraagWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rekenmoduleAanvraagRepository.findAll().size();

        // Create the RekenmoduleAanvraag with an existing ID
        rekenmoduleAanvraag.setId(1L);
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO = rekenmoduleAanvraagMapper.toDto(rekenmoduleAanvraag);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRekenmoduleAanvraagMockMvc.perform(post("/api/rekenmodule-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rekenmoduleAanvraagDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RekenmoduleAanvraag in the database
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = rekenmoduleAanvraagRepository.findAll();
        assertThat(rekenmoduleAanvraagList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRekenmoduleAanvraags() throws Exception {
        // Initialize the database
        rekenmoduleAanvraagRepository.saveAndFlush(rekenmoduleAanvraag);

        // Get all the rekenmoduleAanvraagList
        restRekenmoduleAanvraagMockMvc.perform(get("/api/rekenmodule-aanvraags?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rekenmoduleAanvraag.getId().intValue())))
            .andExpect(jsonPath("$.[*].rekenmoduleAanvraagFileName").value(hasItem(DEFAULT_REKENMODULE_AANVRAAG_FILE_NAME.toString())));
    }
    

    @Test
    @Transactional
    public void getRekenmoduleAanvraag() throws Exception {
        // Initialize the database
        rekenmoduleAanvraagRepository.saveAndFlush(rekenmoduleAanvraag);

        // Get the rekenmoduleAanvraag
        restRekenmoduleAanvraagMockMvc.perform(get("/api/rekenmodule-aanvraags/{id}", rekenmoduleAanvraag.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rekenmoduleAanvraag.getId().intValue()))
            .andExpect(jsonPath("$.rekenmoduleAanvraagFileName").value(DEFAULT_REKENMODULE_AANVRAAG_FILE_NAME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingRekenmoduleAanvraag() throws Exception {
        // Get the rekenmoduleAanvraag
        restRekenmoduleAanvraagMockMvc.perform(get("/api/rekenmodule-aanvraags/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRekenmoduleAanvraag() throws Exception {
        // Initialize the database
        rekenmoduleAanvraagRepository.saveAndFlush(rekenmoduleAanvraag);

        int databaseSizeBeforeUpdate = rekenmoduleAanvraagRepository.findAll().size();

        // Update the rekenmoduleAanvraag
        RekenmoduleAanvraag updatedRekenmoduleAanvraag = rekenmoduleAanvraagRepository.findById(rekenmoduleAanvraag.getId()).get();
        // Disconnect from session so that the updates on updatedRekenmoduleAanvraag are not directly saved in db
        em.detach(updatedRekenmoduleAanvraag);
        updatedRekenmoduleAanvraag
            .rekenmoduleAanvraagFileName(UPDATED_REKENMODULE_AANVRAAG_FILE_NAME);
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO = rekenmoduleAanvraagMapper.toDto(updatedRekenmoduleAanvraag);

        restRekenmoduleAanvraagMockMvc.perform(put("/api/rekenmodule-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rekenmoduleAanvraagDTO)))
            .andExpect(status().isOk());

        // Validate the RekenmoduleAanvraag in the database
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = rekenmoduleAanvraagRepository.findAll();
        assertThat(rekenmoduleAanvraagList).hasSize(databaseSizeBeforeUpdate);
        RekenmoduleAanvraag testRekenmoduleAanvraag = rekenmoduleAanvraagList.get(rekenmoduleAanvraagList.size() - 1);
        assertThat(testRekenmoduleAanvraag.getRekenmoduleAanvraagFileName()).isEqualTo(UPDATED_REKENMODULE_AANVRAAG_FILE_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingRekenmoduleAanvraag() throws Exception {
        int databaseSizeBeforeUpdate = rekenmoduleAanvraagRepository.findAll().size();

        // Create the RekenmoduleAanvraag
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO = rekenmoduleAanvraagMapper.toDto(rekenmoduleAanvraag);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRekenmoduleAanvraagMockMvc.perform(put("/api/rekenmodule-aanvraags")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rekenmoduleAanvraagDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RekenmoduleAanvraag in the database
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = rekenmoduleAanvraagRepository.findAll();
        assertThat(rekenmoduleAanvraagList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRekenmoduleAanvraag() throws Exception {
        // Initialize the database
        rekenmoduleAanvraagRepository.saveAndFlush(rekenmoduleAanvraag);

        int databaseSizeBeforeDelete = rekenmoduleAanvraagRepository.findAll().size();

        // Get the rekenmoduleAanvraag
        restRekenmoduleAanvraagMockMvc.perform(delete("/api/rekenmodule-aanvraags/{id}", rekenmoduleAanvraag.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = rekenmoduleAanvraagRepository.findAll();
        assertThat(rekenmoduleAanvraagList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RekenmoduleAanvraag.class);
        RekenmoduleAanvraag rekenmoduleAanvraag1 = new RekenmoduleAanvraag();
        rekenmoduleAanvraag1.setId(1L);
        RekenmoduleAanvraag rekenmoduleAanvraag2 = new RekenmoduleAanvraag();
        rekenmoduleAanvraag2.setId(rekenmoduleAanvraag1.getId());
        assertThat(rekenmoduleAanvraag1).isEqualTo(rekenmoduleAanvraag2);
        rekenmoduleAanvraag2.setId(2L);
        assertThat(rekenmoduleAanvraag1).isNotEqualTo(rekenmoduleAanvraag2);
        rekenmoduleAanvraag1.setId(null);
        assertThat(rekenmoduleAanvraag1).isNotEqualTo(rekenmoduleAanvraag2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RekenmoduleAanvraagDTO.class);
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO1 = new RekenmoduleAanvraagDTO();
        rekenmoduleAanvraagDTO1.setId(1L);
        RekenmoduleAanvraagDTO rekenmoduleAanvraagDTO2 = new RekenmoduleAanvraagDTO();
        assertThat(rekenmoduleAanvraagDTO1).isNotEqualTo(rekenmoduleAanvraagDTO2);
        rekenmoduleAanvraagDTO2.setId(rekenmoduleAanvraagDTO1.getId());
        assertThat(rekenmoduleAanvraagDTO1).isEqualTo(rekenmoduleAanvraagDTO2);
        rekenmoduleAanvraagDTO2.setId(2L);
        assertThat(rekenmoduleAanvraagDTO1).isNotEqualTo(rekenmoduleAanvraagDTO2);
        rekenmoduleAanvraagDTO1.setId(null);
        assertThat(rekenmoduleAanvraagDTO1).isNotEqualTo(rekenmoduleAanvraagDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(rekenmoduleAanvraagMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(rekenmoduleAanvraagMapper.fromId(null)).isNull();
    }
}
