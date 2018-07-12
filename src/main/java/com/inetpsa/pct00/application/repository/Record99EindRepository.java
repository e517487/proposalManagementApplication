package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record99Eind;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record99Eind entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record99EindRepository extends JpaRepository<Record99Eind, Long> {

}
