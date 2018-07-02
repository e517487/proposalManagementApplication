package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Werksituatie;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Werksituatie entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WerksituatieRepository extends JpaRepository<Werksituatie, Long> {

}
