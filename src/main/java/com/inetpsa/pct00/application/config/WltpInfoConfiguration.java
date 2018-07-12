package com.inetpsa.pct00.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Proposal Management Application.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "wltp-info", ignoreUnknownFields = true)
public class WltpInfoConfiguration {

/*    public final WltpInfo = new WltpInfo();

    public static class WltpInfo{


        public static class Api{

            private String url
        }
    }*/
}
