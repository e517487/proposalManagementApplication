package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.CreditScore;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the CreditScore entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CreditScoreRepository extends JpaRepository<CreditScore, Long> {

}
