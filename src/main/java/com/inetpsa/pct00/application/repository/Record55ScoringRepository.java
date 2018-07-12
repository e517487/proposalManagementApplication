package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record55Scoring;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record55Scoring entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record55ScoringRepository extends JpaRepository<Record55Scoring, Long> {

}
