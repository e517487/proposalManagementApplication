package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record63Uitleg;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record63Uitleg entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record63UitlegRepository extends JpaRepository<Record63Uitleg, Long> {

}
