package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record30Inruil;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record30Inruil entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record30InruilRepository extends JpaRepository<Record30Inruil, Long> {

}
