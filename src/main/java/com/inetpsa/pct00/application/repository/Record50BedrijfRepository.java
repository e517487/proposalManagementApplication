package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record50Bedrijf;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record50Bedrijf entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record50BedrijfRepository extends JpaRepository<Record50Bedrijf, Long> {

}
