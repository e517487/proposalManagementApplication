package com.inetpsa.pct00.application;

import com.inetpsa.pct00.application.service.PcFinetImportService;

public class TestApp {

    public static void main(String[] args) {
        PcFinetImportService p = new PcFinetImportService();

        p.importRequestsFromFile( "D:\\06 PSA-Projecten\\proposalManagementApplication\\test_data\\FIN2PCRT.VRW" );
    }
}
