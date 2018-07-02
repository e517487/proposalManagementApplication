package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.VrijeTekst;
import com.inetpsa.pct00.application.repository.VrijeTekstRepository;
import com.inetpsa.pct00.application.service.VrijeTekstService;
import com.inetpsa.pct00.application.service.dto.VrijeTekstDTO;
import com.inetpsa.pct00.application.service.mapper.VrijeTekstMapper;
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
 * Test class for the VrijeTekstResource REST controller.
 *
 * @see VrijeTekstResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class VrijeTekstResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    @Autowired
    private VrijeTekstRepository vrijeTekstRepository;


    @Autowired
    private VrijeTekstMapper vrijeTekstMapper;
    

    @Autowired
    private VrijeTekstService vrijeTekstService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restVrijeTekstMockMvc;

    private VrijeTekst vrijeTekst;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final VrijeTekstResource vrijeTekstResource = new VrijeTekstResource(vrijeTekstService);
        this.restVrijeTekstMockMvc = MockMvcBuilders.standaloneSetup(vrijeTekstResource)
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
    public static VrijeTekst createEntity(EntityManager em) {
        VrijeTekst vrijeTekst = new VrijeTekst()
            .volgnummer(DEFAULT_VOLGNUMMER);
        return vrijeTekst;
    }

    @Before
    public void initTest() {
        vrijeTekst = createEntity(em);
    }

    @Test
    @Transactional
    public void createVrijeTekst() throws Exception {
        int databaseSizeBeforeCreate = vrijeTekstRepository.findAll().size();

        // Create the VrijeTekst
        VrijeTekstDTO vrijeTekstDTO = vrijeTekstMapper.toDto(vrijeTekst);
        restVrijeTekstMockMvc.perform(post("/api/vrije-teksts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vrijeTekstDTO)))
            .andExpect(status().isCreated());

        // Validate the VrijeTekst in the database
        List<VrijeTekst> vrijeTekstList = vrijeTekstRepository.findAll();
        assertThat(vrijeTekstList).hasSize(databaseSizeBeforeCreate + 1);
        VrijeTekst testVrijeTekst = vrijeTekstList.get(vrijeTekstList.size() - 1);
        assertThat(testVrijeTekst.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
    }

    @Test
    @Transactional
    public void createVrijeTekstWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = vrijeTekstRepository.findAll().size();

        // Create the VrijeTekst with an existing ID
        vrijeTekst.setId(1L);
        VrijeTekstDTO vrijeTekstDTO = vrijeTekstMapper.toDto(vrijeTekst);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVrijeTekstMockMvc.perform(post("/api/vrije-teksts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vrijeTekstDTO)))
            .andExpect(status().isBadRequest());

        // Validate the VrijeTekst in the database
        List<VrijeTekst> vrijeTekstList = vrijeTekstRepository.findAll();
        assertThat(vrijeTekstList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllVrijeTeksts() throws Exception {
        // Initialize the database
        vrijeTekstRepository.saveAndFlush(vrijeTekst);

        // Get all the vrijeTekstList
        restVrijeTekstMockMvc.perform(get("/api/vrije-teksts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vrijeTekst.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())));
    }
    

    @Test
    @Transactional
    public void getVrijeTekst() throws Exception {
        // Initialize the database
        vrijeTekstRepository.saveAndFlush(vrijeTekst);

        // Get the vrijeTekst
        restVrijeTekstMockMvc.perform(get("/api/vrije-teksts/{id}", vrijeTekst.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(vrijeTekst.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingVrijeTekst() throws Exception {
        // Get the vrijeTekst
        restVrijeTekstMockMvc.perform(get("/api/vrije-teksts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVrijeTekst() throws Exception {
        // Initialize the database
        vrijeTekstRepository.saveAndFlush(vrijeTekst);

        int databaseSizeBeforeUpdate = vrijeTekstRepository.findAll().size();

        // Update the vrijeTekst
        VrijeTekst updatedVrijeTekst = vrijeTekstRepository.findById(vrijeTekst.getId()).get();
        // Disconnect from session so that the updates on updatedVrijeTekst are not directly saved in db
        em.detach(updatedVrijeTekst);
        updatedVrijeTekst
            .volgnummer(UPDATED_VOLGNUMMER);
        VrijeTekstDTO vrijeTekstDTO = vrijeTekstMapper.toDto(updatedVrijeTekst);

        restVrijeTekstMockMvc.perform(put("/api/vrije-teksts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vrijeTekstDTO)))
            .andExpect(status().isOk());

        // Validate the VrijeTekst in the database
        List<VrijeTekst> vrijeTekstList = vrijeTekstRepository.findAll();
        assertThat(vrijeTekstList).hasSize(databaseSizeBeforeUpdate);
        VrijeTekst testVrijeTekst = vrijeTekstList.get(vrijeTekstList.size() - 1);
        assertThat(testVrijeTekst.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
    }

    @Test
    @Transactional
    public void updateNonExistingVrijeTekst() throws Exception {
        int databaseSizeBeforeUpdate = vrijeTekstRepository.findAll().size();

        // Create the VrijeTekst
        VrijeTekstDTO vrijeTekstDTO = vrijeTekstMapper.toDto(vrijeTekst);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restVrijeTekstMockMvc.perform(put("/api/vrije-teksts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(vrijeTekstDTO)))
            .andExpect(status().isBadRequest());

        // Validate the VrijeTekst in the database
        List<VrijeTekst> vrijeTekstList = vrijeTekstRepository.findAll();
        assertThat(vrijeTekstList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteVrijeTekst() throws Exception {
        // Initialize the database
        vrijeTekstRepository.saveAndFlush(vrijeTekst);

        int databaseSizeBeforeDelete = vrijeTekstRepository.findAll().size();

        // Get the vrijeTekst
        restVrijeTekstMockMvc.perform(delete("/api/vrije-teksts/{id}", vrijeTekst.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<VrijeTekst> vrijeTekstList = vrijeTekstRepository.findAll();
        assertThat(vrijeTekstList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(VrijeTekst.class);
        VrijeTekst vrijeTekst1 = new VrijeTekst();
        vrijeTekst1.setId(1L);
        VrijeTekst vrijeTekst2 = new VrijeTekst();
        vrijeTekst2.setId(vrijeTekst1.getId());
        assertThat(vrijeTekst1).isEqualTo(vrijeTekst2);
        vrijeTekst2.setId(2L);
        assertThat(vrijeTekst1).isNotEqualTo(vrijeTekst2);
        vrijeTekst1.setId(null);
        assertThat(vrijeTekst1).isNotEqualTo(vrijeTekst2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VrijeTekstDTO.class);
        VrijeTekstDTO vrijeTekstDTO1 = new VrijeTekstDTO();
        vrijeTekstDTO1.setId(1L);
        VrijeTekstDTO vrijeTekstDTO2 = new VrijeTekstDTO();
        assertThat(vrijeTekstDTO1).isNotEqualTo(vrijeTekstDTO2);
        vrijeTekstDTO2.setId(vrijeTekstDTO1.getId());
        assertThat(vrijeTekstDTO1).isEqualTo(vrijeTekstDTO2);
        vrijeTekstDTO2.setId(2L);
        assertThat(vrijeTekstDTO1).isNotEqualTo(vrijeTekstDTO2);
        vrijeTekstDTO1.setId(null);
        assertThat(vrijeTekstDTO1).isNotEqualTo(vrijeTekstDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(vrijeTekstMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(vrijeTekstMapper.fromId(null)).isNull();
    }
}
