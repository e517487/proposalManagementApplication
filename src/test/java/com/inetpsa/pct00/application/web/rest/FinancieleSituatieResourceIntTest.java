package com.inetpsa.pct00.application.web.rest;

import com.inetpsa.pct00.application.ProposalManagementApplicationApp;

import com.inetpsa.pct00.application.domain.FinancieleSituatie;
import com.inetpsa.pct00.application.repository.FinancieleSituatieRepository;
import com.inetpsa.pct00.application.service.FinancieleSituatieService;
import com.inetpsa.pct00.application.service.dto.FinancieleSituatieDTO;
import com.inetpsa.pct00.application.service.mapper.FinancieleSituatieMapper;
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
import java.math.BigDecimal;
import java.util.List;


import static com.inetpsa.pct00.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the FinancieleSituatieResource REST controller.
 *
 * @see FinancieleSituatieResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProposalManagementApplicationApp.class)
public class FinancieleSituatieResourceIntTest {

    private static final Long DEFAULT_VOLGNUMMER = 1L;
    private static final Long UPDATED_VOLGNUMMER = 2L;

    private static final BigDecimal DEFAULT_BRUTO_MAAND_INK = new BigDecimal(1);
    private static final BigDecimal UPDATED_BRUTO_MAAND_INK = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NETTO_MAAND_INK = new BigDecimal(1);
    private static final BigDecimal UPDATED_NETTO_MAAND_INK = new BigDecimal(2);

    private static final String DEFAULT_VOORLOPIGE_TERUGGAAF = "AAAAAAAAAA";
    private static final String UPDATED_VOORLOPIGE_TERUGGAAF = "BBBBBBBBBB";

    private static final String DEFAULT_EIGEN_WONING = "AAAAAAAAAA";
    private static final String UPDATED_EIGEN_WONING = "BBBBBBBBBB";

    private static final String DEFAULT_HYPOTHEEK = "AAAAAAAAAA";
    private static final String UPDATED_HYPOTHEEK = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_BRUTO_MND_HYPOTHEEK = new BigDecimal(1);
    private static final BigDecimal UPDATED_BRUTO_MND_HYPOTHEEK = new BigDecimal(2);

    private static final String DEFAULT_LOPENDE_LENINGEN = "AAAAAAAAAA";
    private static final String UPDATED_LOPENDE_LENINGEN = "BBBBBBBBBB";

    private static final String DEFAULT_WOONSITUATIE = "AAAAAAAAAA";
    private static final String UPDATED_WOONSITUATIE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_WOONLASTEN = new BigDecimal(1);
    private static final BigDecimal UPDATED_WOONLASTEN = new BigDecimal(2);

    @Autowired
    private FinancieleSituatieRepository financieleSituatieRepository;


    @Autowired
    private FinancieleSituatieMapper financieleSituatieMapper;
    

    @Autowired
    private FinancieleSituatieService financieleSituatieService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFinancieleSituatieMockMvc;

    private FinancieleSituatie financieleSituatie;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FinancieleSituatieResource financieleSituatieResource = new FinancieleSituatieResource(financieleSituatieService);
        this.restFinancieleSituatieMockMvc = MockMvcBuilders.standaloneSetup(financieleSituatieResource)
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
    public static FinancieleSituatie createEntity(EntityManager em) {
        FinancieleSituatie financieleSituatie = new FinancieleSituatie()
            .volgnummer(DEFAULT_VOLGNUMMER)
            .brutoMaandInk(DEFAULT_BRUTO_MAAND_INK)
            .nettoMaandInk(DEFAULT_NETTO_MAAND_INK)
            .voorlopigeTeruggaaf(DEFAULT_VOORLOPIGE_TERUGGAAF)
            .eigenWoning(DEFAULT_EIGEN_WONING)
            .hypotheek(DEFAULT_HYPOTHEEK)
            .brutoMndHypotheek(DEFAULT_BRUTO_MND_HYPOTHEEK)
            .lopendeLeningen(DEFAULT_LOPENDE_LENINGEN)
            .woonsituatie(DEFAULT_WOONSITUATIE)
            .woonlasten(DEFAULT_WOONLASTEN);
        return financieleSituatie;
    }

    @Before
    public void initTest() {
        financieleSituatie = createEntity(em);
    }

    @Test
    @Transactional
    public void createFinancieleSituatie() throws Exception {
        int databaseSizeBeforeCreate = financieleSituatieRepository.findAll().size();

        // Create the FinancieleSituatie
        FinancieleSituatieDTO financieleSituatieDTO = financieleSituatieMapper.toDto(financieleSituatie);
        restFinancieleSituatieMockMvc.perform(post("/api/financiele-situaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(financieleSituatieDTO)))
            .andExpect(status().isCreated());

        // Validate the FinancieleSituatie in the database
        List<FinancieleSituatie> financieleSituatieList = financieleSituatieRepository.findAll();
        assertThat(financieleSituatieList).hasSize(databaseSizeBeforeCreate + 1);
        FinancieleSituatie testFinancieleSituatie = financieleSituatieList.get(financieleSituatieList.size() - 1);
        assertThat(testFinancieleSituatie.getVolgnummer()).isEqualTo(DEFAULT_VOLGNUMMER);
        assertThat(testFinancieleSituatie.getBrutoMaandInk()).isEqualTo(DEFAULT_BRUTO_MAAND_INK);
        assertThat(testFinancieleSituatie.getNettoMaandInk()).isEqualTo(DEFAULT_NETTO_MAAND_INK);
        assertThat(testFinancieleSituatie.getVoorlopigeTeruggaaf()).isEqualTo(DEFAULT_VOORLOPIGE_TERUGGAAF);
        assertThat(testFinancieleSituatie.getEigenWoning()).isEqualTo(DEFAULT_EIGEN_WONING);
        assertThat(testFinancieleSituatie.getHypotheek()).isEqualTo(DEFAULT_HYPOTHEEK);
        assertThat(testFinancieleSituatie.getBrutoMndHypotheek()).isEqualTo(DEFAULT_BRUTO_MND_HYPOTHEEK);
        assertThat(testFinancieleSituatie.getLopendeLeningen()).isEqualTo(DEFAULT_LOPENDE_LENINGEN);
        assertThat(testFinancieleSituatie.getWoonsituatie()).isEqualTo(DEFAULT_WOONSITUATIE);
        assertThat(testFinancieleSituatie.getWoonlasten()).isEqualTo(DEFAULT_WOONLASTEN);
    }

    @Test
    @Transactional
    public void createFinancieleSituatieWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = financieleSituatieRepository.findAll().size();

        // Create the FinancieleSituatie with an existing ID
        financieleSituatie.setId(1L);
        FinancieleSituatieDTO financieleSituatieDTO = financieleSituatieMapper.toDto(financieleSituatie);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFinancieleSituatieMockMvc.perform(post("/api/financiele-situaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(financieleSituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FinancieleSituatie in the database
        List<FinancieleSituatie> financieleSituatieList = financieleSituatieRepository.findAll();
        assertThat(financieleSituatieList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllFinancieleSituaties() throws Exception {
        // Initialize the database
        financieleSituatieRepository.saveAndFlush(financieleSituatie);

        // Get all the financieleSituatieList
        restFinancieleSituatieMockMvc.perform(get("/api/financiele-situaties?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(financieleSituatie.getId().intValue())))
            .andExpect(jsonPath("$.[*].volgnummer").value(hasItem(DEFAULT_VOLGNUMMER.intValue())))
            .andExpect(jsonPath("$.[*].brutoMaandInk").value(hasItem(DEFAULT_BRUTO_MAAND_INK.intValue())))
            .andExpect(jsonPath("$.[*].nettoMaandInk").value(hasItem(DEFAULT_NETTO_MAAND_INK.intValue())))
            .andExpect(jsonPath("$.[*].voorlopigeTeruggaaf").value(hasItem(DEFAULT_VOORLOPIGE_TERUGGAAF.toString())))
            .andExpect(jsonPath("$.[*].eigenWoning").value(hasItem(DEFAULT_EIGEN_WONING.toString())))
            .andExpect(jsonPath("$.[*].hypotheek").value(hasItem(DEFAULT_HYPOTHEEK.toString())))
            .andExpect(jsonPath("$.[*].brutoMndHypotheek").value(hasItem(DEFAULT_BRUTO_MND_HYPOTHEEK.intValue())))
            .andExpect(jsonPath("$.[*].lopendeLeningen").value(hasItem(DEFAULT_LOPENDE_LENINGEN.toString())))
            .andExpect(jsonPath("$.[*].woonsituatie").value(hasItem(DEFAULT_WOONSITUATIE.toString())))
            .andExpect(jsonPath("$.[*].woonlasten").value(hasItem(DEFAULT_WOONLASTEN.intValue())));
    }
    

    @Test
    @Transactional
    public void getFinancieleSituatie() throws Exception {
        // Initialize the database
        financieleSituatieRepository.saveAndFlush(financieleSituatie);

        // Get the financieleSituatie
        restFinancieleSituatieMockMvc.perform(get("/api/financiele-situaties/{id}", financieleSituatie.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(financieleSituatie.getId().intValue()))
            .andExpect(jsonPath("$.volgnummer").value(DEFAULT_VOLGNUMMER.intValue()))
            .andExpect(jsonPath("$.brutoMaandInk").value(DEFAULT_BRUTO_MAAND_INK.intValue()))
            .andExpect(jsonPath("$.nettoMaandInk").value(DEFAULT_NETTO_MAAND_INK.intValue()))
            .andExpect(jsonPath("$.voorlopigeTeruggaaf").value(DEFAULT_VOORLOPIGE_TERUGGAAF.toString()))
            .andExpect(jsonPath("$.eigenWoning").value(DEFAULT_EIGEN_WONING.toString()))
            .andExpect(jsonPath("$.hypotheek").value(DEFAULT_HYPOTHEEK.toString()))
            .andExpect(jsonPath("$.brutoMndHypotheek").value(DEFAULT_BRUTO_MND_HYPOTHEEK.intValue()))
            .andExpect(jsonPath("$.lopendeLeningen").value(DEFAULT_LOPENDE_LENINGEN.toString()))
            .andExpect(jsonPath("$.woonsituatie").value(DEFAULT_WOONSITUATIE.toString()))
            .andExpect(jsonPath("$.woonlasten").value(DEFAULT_WOONLASTEN.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingFinancieleSituatie() throws Exception {
        // Get the financieleSituatie
        restFinancieleSituatieMockMvc.perform(get("/api/financiele-situaties/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFinancieleSituatie() throws Exception {
        // Initialize the database
        financieleSituatieRepository.saveAndFlush(financieleSituatie);

        int databaseSizeBeforeUpdate = financieleSituatieRepository.findAll().size();

        // Update the financieleSituatie
        FinancieleSituatie updatedFinancieleSituatie = financieleSituatieRepository.findById(financieleSituatie.getId()).get();
        // Disconnect from session so that the updates on updatedFinancieleSituatie are not directly saved in db
        em.detach(updatedFinancieleSituatie);
        updatedFinancieleSituatie
            .volgnummer(UPDATED_VOLGNUMMER)
            .brutoMaandInk(UPDATED_BRUTO_MAAND_INK)
            .nettoMaandInk(UPDATED_NETTO_MAAND_INK)
            .voorlopigeTeruggaaf(UPDATED_VOORLOPIGE_TERUGGAAF)
            .eigenWoning(UPDATED_EIGEN_WONING)
            .hypotheek(UPDATED_HYPOTHEEK)
            .brutoMndHypotheek(UPDATED_BRUTO_MND_HYPOTHEEK)
            .lopendeLeningen(UPDATED_LOPENDE_LENINGEN)
            .woonsituatie(UPDATED_WOONSITUATIE)
            .woonlasten(UPDATED_WOONLASTEN);
        FinancieleSituatieDTO financieleSituatieDTO = financieleSituatieMapper.toDto(updatedFinancieleSituatie);

        restFinancieleSituatieMockMvc.perform(put("/api/financiele-situaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(financieleSituatieDTO)))
            .andExpect(status().isOk());

        // Validate the FinancieleSituatie in the database
        List<FinancieleSituatie> financieleSituatieList = financieleSituatieRepository.findAll();
        assertThat(financieleSituatieList).hasSize(databaseSizeBeforeUpdate);
        FinancieleSituatie testFinancieleSituatie = financieleSituatieList.get(financieleSituatieList.size() - 1);
        assertThat(testFinancieleSituatie.getVolgnummer()).isEqualTo(UPDATED_VOLGNUMMER);
        assertThat(testFinancieleSituatie.getBrutoMaandInk()).isEqualTo(UPDATED_BRUTO_MAAND_INK);
        assertThat(testFinancieleSituatie.getNettoMaandInk()).isEqualTo(UPDATED_NETTO_MAAND_INK);
        assertThat(testFinancieleSituatie.getVoorlopigeTeruggaaf()).isEqualTo(UPDATED_VOORLOPIGE_TERUGGAAF);
        assertThat(testFinancieleSituatie.getEigenWoning()).isEqualTo(UPDATED_EIGEN_WONING);
        assertThat(testFinancieleSituatie.getHypotheek()).isEqualTo(UPDATED_HYPOTHEEK);
        assertThat(testFinancieleSituatie.getBrutoMndHypotheek()).isEqualTo(UPDATED_BRUTO_MND_HYPOTHEEK);
        assertThat(testFinancieleSituatie.getLopendeLeningen()).isEqualTo(UPDATED_LOPENDE_LENINGEN);
        assertThat(testFinancieleSituatie.getWoonsituatie()).isEqualTo(UPDATED_WOONSITUATIE);
        assertThat(testFinancieleSituatie.getWoonlasten()).isEqualTo(UPDATED_WOONLASTEN);
    }

    @Test
    @Transactional
    public void updateNonExistingFinancieleSituatie() throws Exception {
        int databaseSizeBeforeUpdate = financieleSituatieRepository.findAll().size();

        // Create the FinancieleSituatie
        FinancieleSituatieDTO financieleSituatieDTO = financieleSituatieMapper.toDto(financieleSituatie);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restFinancieleSituatieMockMvc.perform(put("/api/financiele-situaties")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(financieleSituatieDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FinancieleSituatie in the database
        List<FinancieleSituatie> financieleSituatieList = financieleSituatieRepository.findAll();
        assertThat(financieleSituatieList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFinancieleSituatie() throws Exception {
        // Initialize the database
        financieleSituatieRepository.saveAndFlush(financieleSituatie);

        int databaseSizeBeforeDelete = financieleSituatieRepository.findAll().size();

        // Get the financieleSituatie
        restFinancieleSituatieMockMvc.perform(delete("/api/financiele-situaties/{id}", financieleSituatie.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<FinancieleSituatie> financieleSituatieList = financieleSituatieRepository.findAll();
        assertThat(financieleSituatieList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FinancieleSituatie.class);
        FinancieleSituatie financieleSituatie1 = new FinancieleSituatie();
        financieleSituatie1.setId(1L);
        FinancieleSituatie financieleSituatie2 = new FinancieleSituatie();
        financieleSituatie2.setId(financieleSituatie1.getId());
        assertThat(financieleSituatie1).isEqualTo(financieleSituatie2);
        financieleSituatie2.setId(2L);
        assertThat(financieleSituatie1).isNotEqualTo(financieleSituatie2);
        financieleSituatie1.setId(null);
        assertThat(financieleSituatie1).isNotEqualTo(financieleSituatie2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FinancieleSituatieDTO.class);
        FinancieleSituatieDTO financieleSituatieDTO1 = new FinancieleSituatieDTO();
        financieleSituatieDTO1.setId(1L);
        FinancieleSituatieDTO financieleSituatieDTO2 = new FinancieleSituatieDTO();
        assertThat(financieleSituatieDTO1).isNotEqualTo(financieleSituatieDTO2);
        financieleSituatieDTO2.setId(financieleSituatieDTO1.getId());
        assertThat(financieleSituatieDTO1).isEqualTo(financieleSituatieDTO2);
        financieleSituatieDTO2.setId(2L);
        assertThat(financieleSituatieDTO1).isNotEqualTo(financieleSituatieDTO2);
        financieleSituatieDTO1.setId(null);
        assertThat(financieleSituatieDTO1).isNotEqualTo(financieleSituatieDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(financieleSituatieMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(financieleSituatieMapper.fromId(null)).isNull();
    }
}
