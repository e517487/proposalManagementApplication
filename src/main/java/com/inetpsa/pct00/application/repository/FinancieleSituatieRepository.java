package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.FinancieleSituatie;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FinancieleSituatie entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FinancieleSituatieRepository extends JpaRepository<FinancieleSituatie, Long> {

}
