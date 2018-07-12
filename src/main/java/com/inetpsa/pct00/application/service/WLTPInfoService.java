package com.inetpsa.pct00.application.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inetpsa.pct00.application.service.wltp.Config;
import com.inetpsa.pct00.application.service.wltp.ObjectFactory;
import com.inetpsa.pct00.application.service.wltp.WLTP;
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

    private RestTemplate restTemplate;
    private MultiValueMap<String,String> headerWithKey;

    @Value("${wltp-info.api.url}")
    private String rootUri;
    @Value("${wltp-info.api.key}")
    private String key;

    public WLTPInfoService( RestTemplateBuilder builder) {
        log.info("WLTP Info Web Client constructed.");

        restTemplate =  builder.rootUri(rootUri).build();
        headerWithKey = new LinkedMultiValueMap<>();
//        headerWithKey.add("x-api-key", key);

//        WLTP wltp = new WLTP();
//        Config config = new Config();

        ObjectFactory objectFactory = new ObjectFactory();
        WLTP wltp = objectFactory.createWLTP();
    }


    /**
     * Do a REST API call to get information for  WLTP Info's.
     *
     * url
     *
     */
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Quote quote = restTemplate.getForObject(
//                "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//            log.info(quote.toString());
//        };
//    }


    public String getWltpInfo( String t){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> entity = new HttpEntity<>( "stringtext", headers);
//        URI location = template.postForLocation("http://example.com", entity);

        StringBuilder result = new StringBuilder();
        result = restTemplate.exchange( "/xxxx",HttpMethod.GET,entity,result.getClass()).getBody();
        return result.toString();
    }

}


