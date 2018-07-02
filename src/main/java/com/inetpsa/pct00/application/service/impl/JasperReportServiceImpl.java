package com.inetpsa.pct00.application.service.impl;

import com.inetpsa.pct00.application.service.JasperReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JasperReportServiceImpl implements JasperReportService {

    private final Logger log = LoggerFactory.getLogger(JasperReportServiceImpl.class);

}
