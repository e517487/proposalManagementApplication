package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.VrijeTekst;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the VrijeTekst entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VrijeTekstRepository extends JpaRepository<VrijeTekst, Long> {

}
