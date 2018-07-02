package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.RekenmoduleAanvraag;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RekenmoduleAanvraag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RekenmoduleAanvraagRepository extends JpaRepository<RekenmoduleAanvraag, Long> {

}
