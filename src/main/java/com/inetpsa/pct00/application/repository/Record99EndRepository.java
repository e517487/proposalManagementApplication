package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record99End;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record99End entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record99EndRepository extends JpaRepository<Record99End, Long> {

}
