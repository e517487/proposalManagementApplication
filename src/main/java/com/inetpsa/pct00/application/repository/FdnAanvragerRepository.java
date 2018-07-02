package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.FdnAanvrager;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FdnAanvrager entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FdnAanvragerRepository extends JpaRepository<FdnAanvrager, Long> {

}
