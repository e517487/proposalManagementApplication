package com.inetpsa.pct00.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PcfinetImportService {

    private final Logger log = LoggerFactory.getLogger(PcfinetImportService.class);

}
