package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Gezinssituatie;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Gezinssituatie entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GezinssituatieRepository extends JpaRepository<Gezinssituatie, Long> {

}
