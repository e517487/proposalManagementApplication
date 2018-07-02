package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.KredietAanvraag;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the KredietAanvraag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KredietAanvraagRepository extends JpaRepository<KredietAanvraag, Long> {

}
