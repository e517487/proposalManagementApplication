package com.inetpsa.pct00.application.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inetpsa.pct00.application.service.wltp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service
@Transactional
public class WLTPInfoService {

    private final Logger log = LoggerFactory.getLogger(WLTPInfoService.class);

    private ObjectFactory objectFactory;

/*    @Value("${wltp-info.api.url}")
    private String rootUri;
    @Value("${wltp-info.api.key}")
    private String key;*/

    public WLTPInfoService( ) {

        objectFactory = new ObjectFactory();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     *
     * url
     *
     */
    public String getWltpConfig( String t) {

        Config config = objectFactory.createConfig();
        ConfigResponse configResponse = objectFactory.createConfigResponse();

        configResponse.setConfigResponse(objectFactory.createConfigResponseType());

        ConfigType configType = config.getConfig();


        return "result";
    }

    public void getWltpConfigFeature() {

    }

    public void getWltpConfigV2() {

    }


}


