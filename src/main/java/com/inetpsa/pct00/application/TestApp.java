package com.inetpsa.pct00.application;

import com.inetpsa.pct00.application.service.PcfinetImportService;

public class TestApp {

    public static void main(String[] args) {
        PcfinetImportService p = new PcfinetImportService();

        p.importRequestsFromFile( "D:\\06 PSA-Projecten\\proposalManagementApplication\\test_data\\FIN2PCRT.VRW" );
    }
}
