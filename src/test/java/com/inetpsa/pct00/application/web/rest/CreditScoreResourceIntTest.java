package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.CreditScore;
import com.inetpsa.pct00.application.repository.CreditScoreRepository;
import com.inetpsa.pct00.application.service.CreditScoreService;
import com.inetpsa.pct00.application.service.dto.CreditScoreDTO;
import com.inetpsa.pct00.application.service.mapper.CreditScoreMapper;
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
 * Test class for the CreditScoreResource REST controller.
 *
 * @see CreditScoreResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class CreditScoreResourceIntTest {

    @Autowired
    private CreditScoreRepository creditScoreRepository;


    @Autowired
    private CreditScoreMapper creditScoreMapper;
    

    @Autowired
    private CreditScoreService creditScoreService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCreditScoreMockMvc;

    private CreditScore creditScore;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CreditScoreResource creditScoreResource = new CreditScoreResource(creditScoreService);
        this.restCreditScoreMockMvc = MockMvcBuilders.standaloneSetup(creditScoreResource)
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
    public static CreditScore createEntity(EntityManager em) {
        CreditScore creditScore = new CreditScore();
        return creditScore;
    }

    @Before
    public void initTest() {
        creditScore = createEntity(em);
    }

    @Test
    @Transactional
    public void createCreditScore() throws Exception {
        int databaseSizeBeforeCreate = creditScoreRepository.findAll().size();

        // Create the CreditScore
        CreditScoreDTO creditScoreDTO = creditScoreMapper.toDto(creditScore);
        restCreditScoreMockMvc.perform(post("/api/credit-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(creditScoreDTO)))
            .andExpect(status().isCreated());

        // Validate the CreditScore in the database
        List<CreditScore> creditScoreList = creditScoreRepository.findAll();
        assertThat(creditScoreList).hasSize(databaseSizeBeforeCreate + 1);
        CreditScore testCreditScore = creditScoreList.get(creditScoreList.size() - 1);
    }

    @Test
    @Transactional
    public void createCreditScoreWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = creditScoreRepository.findAll().size();

        // Create the CreditScore with an existing ID
        creditScore.setId(1L);
        CreditScoreDTO creditScoreDTO = creditScoreMapper.toDto(creditScore);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCreditScoreMockMvc.perform(post("/api/credit-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(creditScoreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CreditScore in the database
        List<CreditScore> creditScoreList = creditScoreRepository.findAll();
        assertThat(creditScoreList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCreditScores() throws Exception {
        // Initialize the database
        creditScoreRepository.saveAndFlush(creditScore);

        // Get all the creditScoreList
        restCreditScoreMockMvc.perform(get("/api/credit-scores?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(creditScore.getId().intValue())));
    }
    

    @Test
    @Transactional
    public void getCreditScore() throws Exception {
        // Initialize the database
        creditScoreRepository.saveAndFlush(creditScore);

        // Get the creditScore
        restCreditScoreMockMvc.perform(get("/api/credit-scores/{id}", creditScore.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(creditScore.getId().intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingCreditScore() throws Exception {
        // Get the creditScore
        restCreditScoreMockMvc.perform(get("/api/credit-scores/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCreditScore() throws Exception {
        // Initialize the database
        creditScoreRepository.saveAndFlush(creditScore);

        int databaseSizeBeforeUpdate = creditScoreRepository.findAll().size();

        // Update the creditScore
        CreditScore updatedCreditScore = creditScoreRepository.findById(creditScore.getId()).get();
        // Disconnect from session so that the updates on updatedCreditScore are not directly saved in db
        em.detach(updatedCreditScore);
        CreditScoreDTO creditScoreDTO = creditScoreMapper.toDto(updatedCreditScore);

        restCreditScoreMockMvc.perform(put("/api/credit-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(creditScoreDTO)))
            .andExpect(status().isOk());

        // Validate the CreditScore in the database
        List<CreditScore> creditScoreList = creditScoreRepository.findAll();
        assertThat(creditScoreList).hasSize(databaseSizeBeforeUpdate);
        CreditScore testCreditScore = creditScoreList.get(creditScoreList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingCreditScore() throws Exception {
        int databaseSizeBeforeUpdate = creditScoreRepository.findAll().size();

        // Create the CreditScore
        CreditScoreDTO creditScoreDTO = creditScoreMapper.toDto(creditScore);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restCreditScoreMockMvc.perform(put("/api/credit-scores")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(creditScoreDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CreditScore in the database
        List<CreditScore> creditScoreList = creditScoreRepository.findAll();
        assertThat(creditScoreList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCreditScore() throws Exception {
        // Initialize the database
        creditScoreRepository.saveAndFlush(creditScore);

        int databaseSizeBeforeDelete = creditScoreRepository.findAll().size();

        // Get the creditScore
        restCreditScoreMockMvc.perform(delete("/api/credit-scores/{id}", creditScore.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CreditScore> creditScoreList = creditScoreRepository.findAll();
        assertThat(creditScoreList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CreditScore.class);
        CreditScore creditScore1 = new CreditScore();
        creditScore1.setId(1L);
        CreditScore creditScore2 = new CreditScore();
        creditScore2.setId(creditScore1.getId());
        assertThat(creditScore1).isEqualTo(creditScore2);
        creditScore2.setId(2L);
        assertThat(creditScore1).isNotEqualTo(creditScore2);
        creditScore1.setId(null);
        assertThat(creditScore1).isNotEqualTo(creditScore2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CreditScoreDTO.class);
        CreditScoreDTO creditScoreDTO1 = new CreditScoreDTO();
        creditScoreDTO1.setId(1L);
        CreditScoreDTO creditScoreDTO2 = new CreditScoreDTO();
        assertThat(creditScoreDTO1).isNotEqualTo(creditScoreDTO2);
        creditScoreDTO2.setId(creditScoreDTO1.getId());
        assertThat(creditScoreDTO1).isEqualTo(creditScoreDTO2);
        creditScoreDTO2.setId(2L);
        assertThat(creditScoreDTO1).isNotEqualTo(creditScoreDTO2);
        creditScoreDTO1.setId(null);
        assertThat(creditScoreDTO1).isNotEqualTo(creditScoreDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(creditScoreMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(creditScoreMapper.fromId(null)).isNull();
    }
}
