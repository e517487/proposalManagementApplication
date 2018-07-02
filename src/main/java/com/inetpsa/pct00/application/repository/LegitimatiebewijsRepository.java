package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Legitimatiebewijs;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Legitimatiebewijs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LegitimatiebewijsRepository extends JpaRepository<Legitimatiebewijs, Long> {

}
