package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record11AanvraagGegevensOpmerkingen;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record11AanvraagGegevensOpmerkingen entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record11AanvraagGegevensOpmerkingenRepository extends JpaRepository<Record11AanvraagGegevensOpmerkingen, Long> {

}
