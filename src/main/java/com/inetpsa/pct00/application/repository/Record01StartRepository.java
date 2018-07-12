package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record01Start;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record01Start entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record01StartRepository extends JpaRepository<Record01Start, Long> {

}
