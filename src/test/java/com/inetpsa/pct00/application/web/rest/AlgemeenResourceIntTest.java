package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.Algemeen;
import com.inetpsa.pct00.application.repository.AlgemeenRepository;
import com.inetpsa.pct00.application.service.AlgemeenService;
import com.inetpsa.pct00.application.service.dto.AlgemeenDTO;
import com.inetpsa.pct00.application.service.mapper.AlgemeenMapper;
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
 * Test class for the AlgemeenResource REST controller.
 *
 * @see AlgemeenResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class AlgemeenResourceIntTest {

    private static final String DEFAULT_VIEWCODE = "AAAAAAAAAA";
    private static final String UPDATED_VIEWCODE = "BBBBBBBBBB";

    private static final String DEFAULT_VERSIECODE = "AAAAAAAAAA";
    private static final String UPDATED_VERSIECODE = "BBBBBBBBBB";

    private static final String DEFAULT_VALUTA = "AAAAAAAAAA";
    private static final String UPDATED_VALUTA = "BBBBBBBBBB";

    private static final Long DEFAULT_AANVRAAG_VERSIE = 1L;
    private static final Long UPDATED_AANVRAAG_VERSIE = 2L;

    private static final Long DEFAULT_AANVRAAG_VOLG_NR = 1L;
    private static final Long UPDATED_AANVRAAG_VOLG_NR = 2L;

    private static final Long DEFAULT_TUSSENPERSOON_NR = 1L;
    private static final Long UPDATED_TUSSENPERSOON_NR = 2L;

    private static final String DEFAULT_BEDRIJFSNAAM_TP = "AAAAAAAAAA";
    private static final String UPDATED_BEDRIJFSNAAM_TP = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_PERSOON_TP = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_PERSOON_TP = "BBBBBBBBBB";

    private static final String DEFAULT_MAATSCHAPPIJ = "AAAAAAAAAA";
    private static final String UPDATED_MAATSCHAPPIJ = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_REGISTRATIE_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_REGISTRATIE_DT = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_SUBAGENT_NR = 1L;
    private static final Long UPDATED_SUBAGENT_NR = 2L;

    private static final String DEFAULT_VERKOPERS_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_VERKOPERS_NAAM = "BBBBBBBBBB";

    @Autowired
    private AlgemeenRepository algemeenRepository;


    @Autowired
    private AlgemeenMapper algemeenMapper;
    

    @Autowired
    private AlgemeenService algemeenService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAlgemeenMockMvc;

    private Algemeen algemeen;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AlgemeenResource algemeenResource = new AlgemeenResource(algemeenService);
        this.restAlgemeenMockMvc = MockMvcBuilders.standaloneSetup(algemeenResource)
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
    public static Algemeen createEntity(EntityManager em) {
        Algemeen algemeen = new Algemeen()
            .viewcode(DEFAULT_VIEWCODE)
            .versiecode(DEFAULT_VERSIECODE)
            .valuta(DEFAULT_VALUTA)
            .aanvraagVersie(DEFAULT_AANVRAAG_VERSIE)
            .aanvraagVolgNr(DEFAULT_AANVRAAG_VOLG_NR)
            .tussenpersoonNr(DEFAULT_TUSSENPERSOON_NR)
            .bedrijfsnaamTp(DEFAULT_BEDRIJFSNAAM_TP)
            .contactPersoonTp(DEFAULT_CONTACT_PERSOON_TP)
            .maatschappij(DEFAULT_MAATSCHAPPIJ)
            .registratieDt(DEFAULT_REGISTRATIE_DT)
            .subagentNr(DEFAULT_SUBAGENT_NR)
            .verkopersNaam(DEFAULT_VERKOPERS_NAAM);
        return algemeen;
    }

    @Before
    public void initTest() {
        algemeen = createEntity(em);
    }

    @Test
    @Transactional
    public void createAlgemeen() throws Exception {
        int databaseSizeBeforeCreate = algemeenRepository.findAll().size();

        // Create the Algemeen
        AlgemeenDTO algemeenDTO = algemeenMapper.toDto(algemeen);
        restAlgemeenMockMvc.perform(post("/api/algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(algemeenDTO)))
            .andExpect(status().isCreated());

        // Validate the Algemeen in the database
        List<Algemeen> algemeenList = algemeenRepository.findAll();
        assertThat(algemeenList).hasSize(databaseSizeBeforeCreate + 1);
        Algemeen testAlgemeen = algemeenList.get(algemeenList.size() - 1);
        assertThat(testAlgemeen.getViewcode()).isEqualTo(DEFAULT_VIEWCODE);
        assertThat(testAlgemeen.getVersiecode()).isEqualTo(DEFAULT_VERSIECODE);
        assertThat(testAlgemeen.getValuta()).isEqualTo(DEFAULT_VALUTA);
        assertThat(testAlgemeen.getAanvraagVersie()).isEqualTo(DEFAULT_AANVRAAG_VERSIE);
        assertThat(testAlgemeen.getAanvraagVolgNr()).isEqualTo(DEFAULT_AANVRAAG_VOLG_NR);
        assertThat(testAlgemeen.getTussenpersoonNr()).isEqualTo(DEFAULT_TUSSENPERSOON_NR);
        assertThat(testAlgemeen.getBedrijfsnaamTp()).isEqualTo(DEFAULT_BEDRIJFSNAAM_TP);
        assertThat(testAlgemeen.getContactPersoonTp()).isEqualTo(DEFAULT_CONTACT_PERSOON_TP);
        assertThat(testAlgemeen.getMaatschappij()).isEqualTo(DEFAULT_MAATSCHAPPIJ);
        assertThat(testAlgemeen.getRegistratieDt()).isEqualTo(DEFAULT_REGISTRATIE_DT);
        assertThat(testAlgemeen.getSubagentNr()).isEqualTo(DEFAULT_SUBAGENT_NR);
        assertThat(testAlgemeen.getVerkopersNaam()).isEqualTo(DEFAULT_VERKOPERS_NAAM);
    }

    @Test
    @Transactional
    public void createAlgemeenWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = algemeenRepository.findAll().size();

        // Create the Algemeen with an existing ID
        algemeen.setId(1L);
        AlgemeenDTO algemeenDTO = algemeenMapper.toDto(algemeen);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAlgemeenMockMvc.perform(post("/api/algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(algemeenDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Algemeen in the database
        List<Algemeen> algemeenList = algemeenRepository.findAll();
        assertThat(algemeenList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAlgemeens() throws Exception {
        // Initialize the database
        algemeenRepository.saveAndFlush(algemeen);

        // Get all the algemeenList
        restAlgemeenMockMvc.perform(get("/api/algemeens?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(algemeen.getId().intValue())))
            .andExpect(jsonPath("$.[*].viewcode").value(hasItem(DEFAULT_VIEWCODE.toString())))
            .andExpect(jsonPath("$.[*].versiecode").value(hasItem(DEFAULT_VERSIECODE.toString())))
            .andExpect(jsonPath("$.[*].valuta").value(hasItem(DEFAULT_VALUTA.toString())))
            .andExpect(jsonPath("$.[*].aanvraagVersie").value(hasItem(DEFAULT_AANVRAAG_VERSIE.intValue())))
            .andExpect(jsonPath("$.[*].aanvraagVolgNr").value(hasItem(DEFAULT_AANVRAAG_VOLG_NR.intValue())))
            .andExpect(jsonPath("$.[*].tussenpersoonNr").value(hasItem(DEFAULT_TUSSENPERSOON_NR.intValue())))
            .andExpect(jsonPath("$.[*].bedrijfsnaamTp").value(hasItem(DEFAULT_BEDRIJFSNAAM_TP.toString())))
            .andExpect(jsonPath("$.[*].contactPersoonTp").value(hasItem(DEFAULT_CONTACT_PERSOON_TP.toString())))
            .andExpect(jsonPath("$.[*].maatschappij").value(hasItem(DEFAULT_MAATSCHAPPIJ.toString())))
            .andExpect(jsonPath("$.[*].registratieDt").value(hasItem(DEFAULT_REGISTRATIE_DT.toString())))
            .andExpect(jsonPath("$.[*].subagentNr").value(hasItem(DEFAULT_SUBAGENT_NR.intValue())))
            .andExpect(jsonPath("$.[*].verkopersNaam").value(hasItem(DEFAULT_VERKOPERS_NAAM.toString())));
    }
    

    @Test
    @Transactional
    public void getAlgemeen() throws Exception {
        // Initialize the database
        algemeenRepository.saveAndFlush(algemeen);

        // Get the algemeen
        restAlgemeenMockMvc.perform(get("/api/algemeens/{id}", algemeen.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(algemeen.getId().intValue()))
            .andExpect(jsonPath("$.viewcode").value(DEFAULT_VIEWCODE.toString()))
            .andExpect(jsonPath("$.versiecode").value(DEFAULT_VERSIECODE.toString()))
            .andExpect(jsonPath("$.valuta").value(DEFAULT_VALUTA.toString()))
            .andExpect(jsonPath("$.aanvraagVersie").value(DEFAULT_AANVRAAG_VERSIE.intValue()))
            .andExpect(jsonPath("$.aanvraagVolgNr").value(DEFAULT_AANVRAAG_VOLG_NR.intValue()))
            .andExpect(jsonPath("$.tussenpersoonNr").value(DEFAULT_TUSSENPERSOON_NR.intValue()))
            .andExpect(jsonPath("$.bedrijfsnaamTp").value(DEFAULT_BEDRIJFSNAAM_TP.toString()))
            .andExpect(jsonPath("$.contactPersoonTp").value(DEFAULT_CONTACT_PERSOON_TP.toString()))
            .andExpect(jsonPath("$.maatschappij").value(DEFAULT_MAATSCHAPPIJ.toString()))
            .andExpect(jsonPath("$.registratieDt").value(DEFAULT_REGISTRATIE_DT.toString()))
            .andExpect(jsonPath("$.subagentNr").value(DEFAULT_SUBAGENT_NR.intValue()))
            .andExpect(jsonPath("$.verkopersNaam").value(DEFAULT_VERKOPERS_NAAM.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingAlgemeen() throws Exception {
        // Get the algemeen
        restAlgemeenMockMvc.perform(get("/api/algemeens/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAlgemeen() throws Exception {
        // Initialize the database
        algemeenRepository.saveAndFlush(algemeen);

        int databaseSizeBeforeUpdate = algemeenRepository.findAll().size();

        // Update the algemeen
        Algemeen updatedAlgemeen = algemeenRepository.findById(algemeen.getId()).get();
        // Disconnect from session so that the updates on updatedAlgemeen are not directly saved in db
        em.detach(updatedAlgemeen);
        updatedAlgemeen
            .viewcode(UPDATED_VIEWCODE)
            .versiecode(UPDATED_VERSIECODE)
            .valuta(UPDATED_VALUTA)
            .aanvraagVersie(UPDATED_AANVRAAG_VERSIE)
            .aanvraagVolgNr(UPDATED_AANVRAAG_VOLG_NR)
            .tussenpersoonNr(UPDATED_TUSSENPERSOON_NR)
            .bedrijfsnaamTp(UPDATED_BEDRIJFSNAAM_TP)
            .contactPersoonTp(UPDATED_CONTACT_PERSOON_TP)
            .maatschappij(UPDATED_MAATSCHAPPIJ)
            .registratieDt(UPDATED_REGISTRATIE_DT)
            .subagentNr(UPDATED_SUBAGENT_NR)
            .verkopersNaam(UPDATED_VERKOPERS_NAAM);
        AlgemeenDTO algemeenDTO = algemeenMapper.toDto(updatedAlgemeen);

        restAlgemeenMockMvc.perform(put("/api/algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(algemeenDTO)))
            .andExpect(status().isOk());

        // Validate the Algemeen in the database
        List<Algemeen> algemeenList = algemeenRepository.findAll();
        assertThat(algemeenList).hasSize(databaseSizeBeforeUpdate);
        Algemeen testAlgemeen = algemeenList.get(algemeenList.size() - 1);
        assertThat(testAlgemeen.getViewcode()).isEqualTo(UPDATED_VIEWCODE);
        assertThat(testAlgemeen.getVersiecode()).isEqualTo(UPDATED_VERSIECODE);
        assertThat(testAlgemeen.getValuta()).isEqualTo(UPDATED_VALUTA);
        assertThat(testAlgemeen.getAanvraagVersie()).isEqualTo(UPDATED_AANVRAAG_VERSIE);
        assertThat(testAlgemeen.getAanvraagVolgNr()).isEqualTo(UPDATED_AANVRAAG_VOLG_NR);
        assertThat(testAlgemeen.getTussenpersoonNr()).isEqualTo(UPDATED_TUSSENPERSOON_NR);
        assertThat(testAlgemeen.getBedrijfsnaamTp()).isEqualTo(UPDATED_BEDRIJFSNAAM_TP);
        assertThat(testAlgemeen.getContactPersoonTp()).isEqualTo(UPDATED_CONTACT_PERSOON_TP);
        assertThat(testAlgemeen.getMaatschappij()).isEqualTo(UPDATED_MAATSCHAPPIJ);
        assertThat(testAlgemeen.getRegistratieDt()).isEqualTo(UPDATED_REGISTRATIE_DT);
        assertThat(testAlgemeen.getSubagentNr()).isEqualTo(UPDATED_SUBAGENT_NR);
        assertThat(testAlgemeen.getVerkopersNaam()).isEqualTo(UPDATED_VERKOPERS_NAAM);
    }

    @Test
    @Transactional
    public void updateNonExistingAlgemeen() throws Exception {
        int databaseSizeBeforeUpdate = algemeenRepository.findAll().size();

        // Create the Algemeen
        AlgemeenDTO algemeenDTO = algemeenMapper.toDto(algemeen);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAlgemeenMockMvc.perform(put("/api/algemeens")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(algemeenDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Algemeen in the database
        List<Algemeen> algemeenList = algemeenRepository.findAll();
        assertThat(algemeenList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAlgemeen() throws Exception {
        // Initialize the database
        algemeenRepository.saveAndFlush(algemeen);

        int databaseSizeBeforeDelete = algemeenRepository.findAll().size();

        // Get the algemeen
        restAlgemeenMockMvc.perform(delete("/api/algemeens/{id}", algemeen.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Algemeen> algemeenList = algemeenRepository.findAll();
        assertThat(algemeenList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Algemeen.class);
        Algemeen algemeen1 = new Algemeen();
        algemeen1.setId(1L);
        Algemeen algemeen2 = new Algemeen();
        algemeen2.setId(algemeen1.getId());
        assertThat(algemeen1).isEqualTo(algemeen2);
        algemeen2.setId(2L);
        assertThat(algemeen1).isNotEqualTo(algemeen2);
        algemeen1.setId(null);
        assertThat(algemeen1).isNotEqualTo(algemeen2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AlgemeenDTO.class);
        AlgemeenDTO algemeenDTO1 = new AlgemeenDTO();
        algemeenDTO1.setId(1L);
        AlgemeenDTO algemeenDTO2 = new AlgemeenDTO();
        assertThat(algemeenDTO1).isNotEqualTo(algemeenDTO2);
        algemeenDTO2.setId(algemeenDTO1.getId());
        assertThat(algemeenDTO1).isEqualTo(algemeenDTO2);
        algemeenDTO2.setId(2L);
        assertThat(algemeenDTO1).isNotEqualTo(algemeenDTO2);
        algemeenDTO1.setId(null);
        assertThat(algemeenDTO1).isNotEqualTo(algemeenDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(algemeenMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(algemeenMapper.fromId(null)).isNull();
    }
}
