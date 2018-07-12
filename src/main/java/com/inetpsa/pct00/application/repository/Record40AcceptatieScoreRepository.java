package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record40AcceptatieScore;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record40AcceptatieScore entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record40AcceptatieScoreRepository extends JpaRepository<Record40AcceptatieScore, Long> {

}
