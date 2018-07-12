package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record45Relatie;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record45Relatie entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record45RelatieRepository extends JpaRepository<Record45Relatie, Long> {

}
