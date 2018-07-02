package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Algemeen;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Algemeen entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AlgemeenRepository extends JpaRepository<Algemeen, Long> {

}
