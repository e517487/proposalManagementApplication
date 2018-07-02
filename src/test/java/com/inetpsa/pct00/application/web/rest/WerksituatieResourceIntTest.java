package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Werksituatie;
import com.inetpsa.pct00.application.repository.WerksituatieRepository;
import com.inetpsa.pct00.application.service.WerksituatieService;
import com.inetpsa.pct00.application.service.dto.WerksituatieDTO;
import com.inetpsa.pct00.application.service.mapper.WerksituatieMapper;
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
import java.time.ZoneId;
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the WerksituatieResource REST controller.
 *
 * @see WerksituatieResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class WerksituatieResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_BEROEP = "AAAAAAAAAA";
    private static final String UPDATED_BEROEP = "BBBBBBBBBB";

    private static final String DEFAULT_AARD_DIENSTVERBAND = "AAAAAAAAAA";
    private static final String UPDATED_AARD_DIENSTVERBAND = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BEGIN_DIENSTVERBAND_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BEGIN_DIENSTVERBAND_DT = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private WerksituatieRepository werksituatieRepository;


    @Autowired
    private WerksituatieMapper werksituatieMapper;
    

    @Autowired
    private WerksituatieService werksituatieService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restWerksituatieMockMvc;

    private Werksituatie werksituatie;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WerksituatieResource werksituatieResource = new WerksituatieResource(werksituatieService);
        this.restWerksituatieMockMvc = MockMvcBuilders.standaloneSetup(werksituatieResource)
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
    public static Werksituatie createEntity(EntityManager em) {
        Werksituatie werksituatie = new Werksituatie()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .beroep(DEFAULT_BEROEP)
            .aardDienstverband(DEFAULT_AARD_DIENSTVERBAND)
            .beginDienstverbandDt(DEFAULT_BEGIN_DIENSTVERBAND_DT);
        return werksituatie;
    }

    @Before
    public void initTest() {
        werksituatie = createEntity(em);
    }

    @Test
    @Transactional
    public void createWerksituatie() throws Exception {
        int databaseSizeBeforeCreate = werksituatieRepository.findAll().size();

        // Create the Werksituatie
        WerksituatieDTO werksituatieDTO = werksituatieMapper.toDto(werksituatie);
        restWerksituatieMockMvc.perform(post("/api/werksituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(werksituatieDTO)))
            .andExpect(status().isCreated());

        // Validate the Werksituatie in the database
        List<Werksituatie> werksituatieList = werksituatieRepository.findAll();
        assertThat(werksituatieList).hasSize(databaseSizeBeforeCreate + 1);
        Werksituatie testWerksituatie = werksituatieList.get(werksituatieList.size() - 1);
        assertThat(testWerksituatie.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testWerksituatie.getBeroep()).isEqualTo(DEFAULT_BEROEP);
        assertThat(testWerksituatie.getAardDienstverband()).isEqualTo(DEFAULT_AARD_DIENSTVERBAND);
        assertThat(testWerksituatie.getBeginDienstverbandDt()).isEqualTo(DEFAULT_BEGIN_DIENSTVERBAND_DT);
    }

    @Test
    @Transactional
    public void createWerksituatieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = werksituatieRepository.findAll().size();

        // Create the Werksituatie with an existing ID
        werksituatie.setId(1L);
        WerksituatieDTO werksituatieDTO = werksituatieMapper.toDto(werksituatie);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWerksituatieMockMvc.perform(post("/api/werksituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(werksituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Werksituatie in the database
        List<Werksituatie> werksituatieList = werksituatieRepository.findAll();
        assertThat(werksituatieList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllWerksituaties() throws Exception {
        // Initialize the database
        werksituatieRepository.saveAndFlush(werksituatie);

        // Get all the werksituatieList
        restWerksituatieMockMvc.perform(get("/api/werksituaties?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(werksituatie.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].beroep").value(hasItem(DEFAULT_BEROEP.toString())))
            .andExpect(jsonPath("$.[*].aardDienstverband").value(hasItem(DEFAULT_AARD_DIENSTVERBAND.toString())))
            .andExpect(jsonPath("$.[*].beginDienstverbandDt").value(hasItem(DEFAULT_BEGIN_DIENSTVERBAND_DT.toString())));
    }
    

    @Test
    @Transactional
    public void getWerksituatie() throws Exception {
        // Initialize the database
        werksituatieRepository.saveAndFlush(werksituatie);

        // Get the werksituatie
        restWerksituatieMockMvc.perform(get("/api/werksituaties/{id}", werksituatie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(werksituatie.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.beroep").value(DEFAULT_BEROEP.toString()))
            .andExpect(jsonPath("$.aardDienstverband").value(DEFAULT_AARD_DIENSTVERBAND.toString()))
            .andExpect(jsonPath("$.beginDienstverbandDt").value(DEFAULT_BEGIN_DIENSTVERBAND_DT.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingWerksituatie() throws Exception {
        // Get the werksituatie
        restWerksituatieMockMvc.perform(get("/api/werksituaties/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWerksituatie() throws Exception {
        // Initialize the database
        werksituatieRepository.saveAndFlush(werksituatie);

        int databaseSizeBeforeUpdate = werksituatieRepository.findAll().size();

        // Update the werksituatie
        Werksituatie updatedWerksituatie = werksituatieRepository.findById(werksituatie.getId()).get();
        // Disconnect from session so that the updates on updatedWerksituatie are not directly saved in db
        em.detach(updatedWerksituatie);
        updatedWerksituatie
            .volgnummer(UPDATED_VOLGNUMMER)
            .beroep(UPDATED_BEROEP)
            .aardDienstverband(UPDATED_AARD_DIENSTVERBAND)
            .beginDienstverbandDt(UPDATED_BEGIN_DIENSTVERBAND_DT);
        WerksituatieDTO werksituatieDTO = werksituatieMapper.toDto(updatedWerksituatie);

        restWerksituatieMockMvc.perform(put("/api/werksituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(werksituatieDTO)))
            .andExpect(status().isOk());

        // Validate the Werksituatie in the database
        List<Werksituatie> werksituatieList = werksituatieRepository.findAll();
        assertThat(werksituatieList).hasSize(databaseSizeBeforeUpdate);
        Werksituatie testWerksituatie = werksituatieList.get(werksituatieList.size() - 1);
        assertThat(testWerksituatie.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testWerksituatie.getBeroep()).isEqualTo(UPDATED_BEROEP);
        assertThat(testWerksituatie.getAardDienstverband()).isEqualTo(UPDATED_AARD_DIENSTVERBAND);
        assertThat(testWerksituatie.getBeginDienstverbandDt()).isEqualTo(UPDATED_BEGIN_DIENSTVERBAND_DT);
    }

    @Test
    @Transactional
    public void updateNonExistingWerksituatie() throws Exception {
        int databaseSizeBeforeUpdate = werksituatieRepository.findAll().size();

        // Create the Werksituatie
        WerksituatieDTO werksituatieDTO = werksituatieMapper.toDto(werksituatie);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restWerksituatieMockMvc.perform(put("/api/werksituaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(werksituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Werksituatie in the database
        List<Werksituatie> werksituatieList = werksituatieRepository.findAll();
        assertThat(werksituatieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWerksituatie() throws Exception {
        // Initialize the database
        werksituatieRepository.saveAndFlush(werksituatie);

        int databaseSizeBeforeDelete = werksituatieRepository.findAll().size();

        // Get the werksituatie
        restWerksituatieMockMvc.perform(delete("/api/werksituaties/{id}", werksituatie.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Werksituatie> werksituatieList = werksituatieRepository.findAll();
        assertThat(werksituatieList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Werksituatie.class);
        Werksituatie werksituatie1 = new Werksituatie();
        werksituatie1.setId(1L);
        Werksituatie werksituatie2 = new Werksituatie();
        werksituatie2.setId(werksituatie1.getId());
        assertThat(werksituatie1).isEqualTo(werksituatie2);
        werksituatie2.setId(2L);
        assertThat(werksituatie1).isNotEqualTo(werksituatie2);
        werksituatie1.setId(null);
        assertThat(werksituatie1).isNotEqualTo(werksituatie2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(WerksituatieDTO.class);
        WerksituatieDTO werksituatieDTO1 = new WerksituatieDTO();
        werksituatieDTO1.setId(1L);
        WerksituatieDTO werksituatieDTO2 = new WerksituatieDTO();
        assertThat(werksituatieDTO1).isNotEqualTo(werksituatieDTO2);
        werksituatieDTO2.setId(werksituatieDTO1.getId());
        assertThat(werksituatieDTO1).isEqualTo(werksituatieDTO2);
        werksituatieDTO2.setId(2L);
        assertThat(werksituatieDTO1).isNotEqualTo(werksituatieDTO2);
        werksituatieDTO1.setId(null);
        assertThat(werksituatieDTO1).isNotEqualTo(werksituatieDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(werksituatieMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(werksituatieMapper.fromId(null)).isNull();
    }
}
