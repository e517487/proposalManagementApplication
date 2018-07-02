package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.FdnAanvrager;
import com.inetpsa.pct00.application.repository.FdnAanvragerRepository;
import com.inetpsa.pct00.application.service.FdnAanvragerService;
import com.inetpsa.pct00.application.service.dto.FdnAanvragerDTO;
import com.inetpsa.pct00.application.service.mapper.FdnAanvragerMapper;
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
 * Test class for the FdnAanvragerResource REST controller.
 *
 * @see FdnAanvragerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class FdnAanvragerResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final String DEFAULT_SOORT_AANVRAGER = "AAAAAAAAAA";
    private static final String UPDATED_SOORT_AANVRAGER = "BBBBBBBBBB";

    private static final String DEFAULT_ACHTER_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_ACHTER_NAAM = "BBBBBBBBBB";

    private static final String DEFAULT_VOORLETTERS = "AAAAAAAAAA";
    private static final String UPDATED_VOORLETTERS = "BBBBBBBBBB";

    private static final String DEFAULT_GEB_NAAM = "AAAAAAAAAA";
    private static final String UPDATED_GEB_NAAM = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_WOONACHTIG_HUIDIG_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_WOONACHTIG_HUIDIG_DT = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_TEL_BEREIKBAAR = "AAAAAAAAAA";
    private static final String UPDATED_TEL_BEREIKBAAR = "BBBBBBBBBB";

    private static final String DEFAULT_TELEFOON_NR_PRIVE = "AAAAAAAAAA";
    private static final String UPDATED_TELEFOON_NR_PRIVE = "BBBBBBBBBB";

    private static final String DEFAULT_IBAN = "AAAAAAAAAA";
    private static final String UPDATED_IBAN = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_GEBOORTE_DT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_GEBOORTE_DT = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_NATIONALITEIT = "AAAAAAAAAA";
    private static final String UPDATED_NATIONALITEIT = "BBBBBBBBBB";

    private static final String DEFAULT_GESLACHT = "AAAAAAAAAA";
    private static final String UPDATED_GESLACHT = "BBBBBBBBBB";

    private static final String DEFAULT_SOCIAAL_FISCAAL_NR = "AAAAAAAAAA";
    private static final String UPDATED_SOCIAAL_FISCAAL_NR = "BBBBBBBBBB";

    private static final String DEFAULT_RELATIE_TP = "AAAAAAAAAA";
    private static final String UPDATED_RELATIE_TP = "BBBBBBBBBB";

    @Autowired
    private FdnAanvragerRepository fdnAanvragerRepository;


    @Autowired
    private FdnAanvragerMapper fdnAanvragerMapper;
    

    @Autowired
    private FdnAanvragerService fdnAanvragerService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFdnAanvragerMockMvc;

    private FdnAanvrager fdnAanvrager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FdnAanvragerResource fdnAanvragerResource = new FdnAanvragerResource(fdnAanvragerService);
        this.restFdnAanvragerMockMvc = MockMvcBuilders.standaloneSetup(fdnAanvragerResource)
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
    public static FdnAanvrager createEntity(EntityManager em) {
        FdnAanvrager fdnAanvrager = new FdnAanvrager()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .soortAanvrager(DEFAULT_SOORT_AANVRAGER)
            .achterNaam(DEFAULT_ACHTER_NAAM)
            .voorletters(DEFAULT_VOORLETTERS)
            .gebNaam(DEFAULT_GEB_NAAM)
            .woonachtigHuidigDt(DEFAULT_WOONACHTIG_HUIDIG_DT)
            .telBereikbaar(DEFAULT_TEL_BEREIKBAAR)
            .telefoonNrPrive(DEFAULT_TELEFOON_NR_PRIVE)
            .iban(DEFAULT_IBAN)
            .geboorteDt(DEFAULT_GEBOORTE_DT)
            .nationaliteit(DEFAULT_NATIONALITEIT)
            .geslacht(DEFAULT_GESLACHT)
            .sociaalFiscaalNr(DEFAULT_SOCIAAL_FISCAAL_NR)
            .relatieTp(DEFAULT_RELATIE_TP);
        return fdnAanvrager;
    }

    @Before
    public void initTest() {
        fdnAanvrager = createEntity(em);
    }

    @Test
    @Transactional
    public void createFdnAanvrager() throws Exception {
        int databaseSizeBeforeCreate = fdnAanvragerRepository.findAll().size();

        // Create the FdnAanvrager
        FdnAanvragerDTO fdnAanvragerDTO = fdnAanvragerMapper.toDto(fdnAanvrager);
        restFdnAanvragerMockMvc.perform(post("/api/fdn-aanvragers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fdnAanvragerDTO)))
            .andExpect(status().isCreated());

        // Validate the FdnAanvrager in the database
        List<FdnAanvrager> fdnAanvragerList = fdnAanvragerRepository.findAll();
        assertThat(fdnAanvragerList).hasSize(databaseSizeBeforeCreate + 1);
        FdnAanvrager testFdnAanvrager = fdnAanvragerList.get(fdnAanvragerList.size() - 1);
        assertThat(testFdnAanvrager.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testFdnAanvrager.getSoortAanvrager()).isEqualTo(DEFAULT_SOORT_AANVRAGER);
        assertThat(testFdnAanvrager.getAchterNaam()).isEqualTo(DEFAULT_ACHTER_NAAM);
        assertThat(testFdnAanvrager.getVoorletters()).isEqualTo(DEFAULT_VOORLETTERS);
        assertThat(testFdnAanvrager.getGebNaam()).isEqualTo(DEFAULT_GEB_NAAM);
        assertThat(testFdnAanvrager.getWoonachtigHuidigDt()).isEqualTo(DEFAULT_WOONACHTIG_HUIDIG_DT);
        assertThat(testFdnAanvrager.getTelBereikbaar()).isEqualTo(DEFAULT_TEL_BEREIKBAAR);
        assertThat(testFdnAanvrager.getTelefoonNrPrive()).isEqualTo(DEFAULT_TELEFOON_NR_PRIVE);
        assertThat(testFdnAanvrager.getIban()).isEqualTo(DEFAULT_IBAN);
        assertThat(testFdnAanvrager.getGeboorteDt()).isEqualTo(DEFAULT_GEBOORTE_DT);
        assertThat(testFdnAanvrager.getNationaliteit()).isEqualTo(DEFAULT_NATIONALITEIT);
        assertThat(testFdnAanvrager.getGeslacht()).isEqualTo(DEFAULT_GESLACHT);
        assertThat(testFdnAanvrager.getSociaalFiscaalNr()).isEqualTo(DEFAULT_SOCIAAL_FISCAAL_NR);
        assertThat(testFdnAanvrager.getRelatieTp()).isEqualTo(DEFAULT_RELATIE_TP);
    }

    @Test
    @Transactional
    public void createFdnAanvragerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = fdnAanvragerRepository.findAll().size();

        // Create the FdnAanvrager with an existing ID
        fdnAanvrager.setId(1L);
        FdnAanvragerDTO fdnAanvragerDTO = fdnAanvragerMapper.toDto(fdnAanvrager);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFdnAanvragerMockMvc.perform(post("/api/fdn-aanvragers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fdnAanvragerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FdnAanvrager in the database
        List<FdnAanvrager> fdnAanvragerList = fdnAanvragerRepository.findAll();
        assertThat(fdnAanvragerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllFdnAanvragers() throws Exception {
        // Initialize the database
        fdnAanvragerRepository.saveAndFlush(fdnAanvrager);

        // Get all the fdnAanvragerList
        restFdnAanvragerMockMvc.perform(get("/api/fdn-aanvragers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(fdnAanvrager.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].soortAanvrager").value(hasItem(DEFAULT_SOORT_AANVRAGER.toString())))
            .andExpect(jsonPath("$.[*].achterNaam").value(hasItem(DEFAULT_ACHTER_NAAM.toString())))
            .andExpect(jsonPath("$.[*].voorletters").value(hasItem(DEFAULT_VOORLETTERS.toString())))
            .andExpect(jsonPath("$.[*].gebNaam").value(hasItem(DEFAULT_GEB_NAAM.toString())))
            .andExpect(jsonPath("$.[*].woonachtigHuidigDt").value(hasItem(DEFAULT_WOONACHTIG_HUIDIG_DT.toString())))
            .andExpect(jsonPath("$.[*].telBereikbaar").value(hasItem(DEFAULT_TEL_BEREIKBAAR.toString())))
            .andExpect(jsonPath("$.[*].telefoonNrPrive").value(hasItem(DEFAULT_TELEFOON_NR_PRIVE.toString())))
            .andExpect(jsonPath("$.[*].iban").value(hasItem(DEFAULT_IBAN.toString())))
            .andExpect(jsonPath("$.[*].geboorteDt").value(hasItem(DEFAULT_GEBOORTE_DT.toString())))
            .andExpect(jsonPath("$.[*].nationaliteit").value(hasItem(DEFAULT_NATIONALITEIT.toString())))
            .andExpect(jsonPath("$.[*].geslacht").value(hasItem(DEFAULT_GESLACHT.toString())))
            .andExpect(jsonPath("$.[*].sociaalFiscaalNr").value(hasItem(DEFAULT_SOCIAAL_FISCAAL_NR.toString())))
            .andExpect(jsonPath("$.[*].relatieTp").value(hasItem(DEFAULT_RELATIE_TP.toString())));
    }
    

    @Test
    @Transactional
    public void getFdnAanvrager() throws Exception {
        // Initialize the database
        fdnAanvragerRepository.saveAndFlush(fdnAanvrager);

        // Get the fdnAanvrager
        restFdnAanvragerMockMvc.perform(get("/api/fdn-aanvragers/{id}", fdnAanvrager.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(fdnAanvrager.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.soortAanvrager").value(DEFAULT_SOORT_AANVRAGER.toString()))
            .andExpect(jsonPath("$.achterNaam").value(DEFAULT_ACHTER_NAAM.toString()))
            .andExpect(jsonPath("$.voorletters").value(DEFAULT_VOORLETTERS.toString()))
            .andExpect(jsonPath("$.gebNaam").value(DEFAULT_GEB_NAAM.toString()))
            .andExpect(jsonPath("$.woonachtigHuidigDt").value(DEFAULT_WOONACHTIG_HUIDIG_DT.toString()))
            .andExpect(jsonPath("$.telBereikbaar").value(DEFAULT_TEL_BEREIKBAAR.toString()))
            .andExpect(jsonPath("$.telefoonNrPrive").value(DEFAULT_TELEFOON_NR_PRIVE.toString()))
            .andExpect(jsonPath("$.iban").value(DEFAULT_IBAN.toString()))
            .andExpect(jsonPath("$.geboorteDt").value(DEFAULT_GEBOORTE_DT.toString()))
            .andExpect(jsonPath("$.nationaliteit").value(DEFAULT_NATIONALITEIT.toString()))
            .andExpect(jsonPath("$.geslacht").value(DEFAULT_GESLACHT.toString()))
            .andExpect(jsonPath("$.sociaalFiscaalNr").value(DEFAULT_SOCIAAL_FISCAAL_NR.toString()))
            .andExpect(jsonPath("$.relatieTp").value(DEFAULT_RELATIE_TP.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingFdnAanvrager() throws Exception {
        // Get the fdnAanvrager
        restFdnAanvragerMockMvc.perform(get("/api/fdn-aanvragers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFdnAanvrager() throws Exception {
        // Initialize the database
        fdnAanvragerRepository.saveAndFlush(fdnAanvrager);

        int databaseSizeBeforeUpdate = fdnAanvragerRepository.findAll().size();

        // Update the fdnAanvrager
        FdnAanvrager updatedFdnAanvrager = fdnAanvragerRepository.findById(fdnAanvrager.getId()).get();
        // Disconnect from session so that the updates on updatedFdnAanvrager are not directly saved in db
        em.detach(updatedFdnAanvrager);
        updatedFdnAanvrager
            .volgnummer(UPDATED_VOLGNUMMER)
            .soortAanvrager(UPDATED_SOORT_AANVRAGER)
            .achterNaam(UPDATED_ACHTER_NAAM)
            .voorletters(UPDATED_VOORLETTERS)
            .gebNaam(UPDATED_GEB_NAAM)
            .woonachtigHuidigDt(UPDATED_WOONACHTIG_HUIDIG_DT)
            .telBereikbaar(UPDATED_TEL_BEREIKBAAR)
            .telefoonNrPrive(UPDATED_TELEFOON_NR_PRIVE)
            .iban(UPDATED_IBAN)
            .geboorteDt(UPDATED_GEBOORTE_DT)
            .nationaliteit(UPDATED_NATIONALITEIT)
            .geslacht(UPDATED_GESLACHT)
            .sociaalFiscaalNr(UPDATED_SOCIAAL_FISCAAL_NR)
            .relatieTp(UPDATED_RELATIE_TP);
        FdnAanvragerDTO fdnAanvragerDTO = fdnAanvragerMapper.toDto(updatedFdnAanvrager);

        restFdnAanvragerMockMvc.perform(put("/api/fdn-aanvragers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fdnAanvragerDTO)))
            .andExpect(status().isOk());

        // Validate the FdnAanvrager in the database
        List<FdnAanvrager> fdnAanvragerList = fdnAanvragerRepository.findAll();
        assertThat(fdnAanvragerList).hasSize(databaseSizeBeforeUpdate);
        FdnAanvrager testFdnAanvrager = fdnAanvragerList.get(fdnAanvragerList.size() - 1);
        assertThat(testFdnAanvrager.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testFdnAanvrager.getSoortAanvrager()).isEqualTo(UPDATED_SOORT_AANVRAGER);
        assertThat(testFdnAanvrager.getAchterNaam()).isEqualTo(UPDATED_ACHTER_NAAM);
        assertThat(testFdnAanvrager.getVoorletters()).isEqualTo(UPDATED_VOORLETTERS);
        assertThat(testFdnAanvrager.getGebNaam()).isEqualTo(UPDATED_GEB_NAAM);
        assertThat(testFdnAanvrager.getWoonachtigHuidigDt()).isEqualTo(UPDATED_WOONACHTIG_HUIDIG_DT);
        assertThat(testFdnAanvrager.getTelBereikbaar()).isEqualTo(UPDATED_TEL_BEREIKBAAR);
        assertThat(testFdnAanvrager.getTelefoonNrPrive()).isEqualTo(UPDATED_TELEFOON_NR_PRIVE);
        assertThat(testFdnAanvrager.getIban()).isEqualTo(UPDATED_IBAN);
        assertThat(testFdnAanvrager.getGeboorteDt()).isEqualTo(UPDATED_GEBOORTE_DT);
        assertThat(testFdnAanvrager.getNationaliteit()).isEqualTo(UPDATED_NATIONALITEIT);
        assertThat(testFdnAanvrager.getGeslacht()).isEqualTo(UPDATED_GESLACHT);
        assertThat(testFdnAanvrager.getSociaalFiscaalNr()).isEqualTo(UPDATED_SOCIAAL_FISCAAL_NR);
        assertThat(testFdnAanvrager.getRelatieTp()).isEqualTo(UPDATED_RELATIE_TP);
    }

    @Test
    @Transactional
    public void updateNonExistingFdnAanvrager() throws Exception {
        int databaseSizeBeforeUpdate = fdnAanvragerRepository.findAll().size();

        // Create the FdnAanvrager
        FdnAanvragerDTO fdnAanvragerDTO = fdnAanvragerMapper.toDto(fdnAanvrager);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restFdnAanvragerMockMvc.perform(put("/api/fdn-aanvragers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(fdnAanvragerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FdnAanvrager in the database
        List<FdnAanvrager> fdnAanvragerList = fdnAanvragerRepository.findAll();
        assertThat(fdnAanvragerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFdnAanvrager() throws Exception {
        // Initialize the database
        fdnAanvragerRepository.saveAndFlush(fdnAanvrager);

        int databaseSizeBeforeDelete = fdnAanvragerRepository.findAll().size();

        // Get the fdnAanvrager
        restFdnAanvragerMockMvc.perform(delete("/api/fdn-aanvragers/{id}", fdnAanvrager.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<FdnAanvrager> fdnAanvragerList = fdnAanvragerRepository.findAll();
        assertThat(fdnAanvragerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FdnAanvrager.class);
        FdnAanvrager fdnAanvrager1 = new FdnAanvrager();
        fdnAanvrager1.setId(1L);
        FdnAanvrager fdnAanvrager2 = new FdnAanvrager();
        fdnAanvrager2.setId(fdnAanvrager1.getId());
        assertThat(fdnAanvrager1).isEqualTo(fdnAanvrager2);
        fdnAanvrager2.setId(2L);
        assertThat(fdnAanvrager1).isNotEqualTo(fdnAanvrager2);
        fdnAanvrager1.setId(null);
        assertThat(fdnAanvrager1).isNotEqualTo(fdnAanvrager2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FdnAanvragerDTO.class);
        FdnAanvragerDTO fdnAanvragerDTO1 = new FdnAanvragerDTO();
        fdnAanvragerDTO1.setId(1L);
        FdnAanvragerDTO fdnAanvragerDTO2 = new FdnAanvragerDTO();
        assertThat(fdnAanvragerDTO1).isNotEqualTo(fdnAanvragerDTO2);
        fdnAanvragerDTO2.setId(fdnAanvragerDTO1.getId());
        assertThat(fdnAanvragerDTO1).isEqualTo(fdnAanvragerDTO2);
        fdnAanvragerDTO2.setId(2L);
        assertThat(fdnAanvragerDTO1).isNotEqualTo(fdnAanvragerDTO2);
        fdnAanvragerDTO1.setId(null);
        assertThat(fdnAanvragerDTO1).isNotEqualTo(fdnAanvragerDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(fdnAanvragerMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(fdnAanvragerMapper.fromId(null)).isNull();
    }
}
