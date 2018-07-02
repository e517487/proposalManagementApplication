package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Aanvraagbericht;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Aanvraagbericht entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AanvraagberichtRepository extends JpaRepository<Aanvraagbericht, Long> {

}
