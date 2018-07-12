package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record25Herfinancieering;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record25Herfinancieering entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record25HerfinancieeringRepository extends JpaRepository<Record25Herfinancieering, Long> {

}
