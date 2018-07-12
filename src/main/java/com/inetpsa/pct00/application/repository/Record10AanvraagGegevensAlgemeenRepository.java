package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record10AanvraagGegevensAlgemeen;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record10AanvraagGegevensAlgemeen entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record10AanvraagGegevensAlgemeenRepository extends JpaRepository<Record10AanvraagGegevensAlgemeen, Long> {

}
