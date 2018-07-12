package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record61Uitleg;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record61Uitleg entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record61UitlegRepository extends JpaRepository<Record61Uitleg, Long> {

}
