package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Adres;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Adres entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdresRepository extends JpaRepository<Adres, Long> {

}
