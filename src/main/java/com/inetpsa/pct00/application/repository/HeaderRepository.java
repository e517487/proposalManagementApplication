package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Header;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Header entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HeaderRepository extends JpaRepository<Header, Long> {

}
