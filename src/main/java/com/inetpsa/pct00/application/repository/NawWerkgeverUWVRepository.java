package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.NawWerkgeverUWV;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the NawWerkgeverUWV entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NawWerkgeverUWVRepository extends JpaRepository<NawWerkgeverUWV, Long> {

}
