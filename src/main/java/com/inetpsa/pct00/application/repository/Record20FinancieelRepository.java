package com.inetpsa.pct00.application.repository;

import com.inetpsa.pct00.application.domain.Record20Financieel;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Record20Financieel entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Record20FinancieelRepository extends JpaRepository<Record20Financieel, Long> {

}
