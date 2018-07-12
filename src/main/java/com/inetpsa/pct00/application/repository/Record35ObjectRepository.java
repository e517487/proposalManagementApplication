package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record35Object;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record35Object entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record35ObjectRepository extends JpaRepository<Record35Object, Long> {

}
