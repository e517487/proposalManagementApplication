package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.TekstRegel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TekstRegel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TekstRegelRepository extends JpaRepository<TekstRegel, Long> {

}
