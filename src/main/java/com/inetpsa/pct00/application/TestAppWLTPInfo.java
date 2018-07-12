package com.inetpsa.pct00.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inetpsa.pct00.application.service.WLTPInfoService;
import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
public class TestAppWLTPInfo {

	private static final Logger log = LoggerFactory.getLogger(TestAppWLTPInfo.class);


	public static void main(String args[]) {
//		SpringApplication.run(TestAppWLTPInfo.class);
	}





/*	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}*/
}
////////////////////////////////////

@JsonIgnoreProperties(ignoreUnknown = true)
class Quote {

    private String type;
    private Value value;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
            "type='" + type + '\'' +
            ", value=" + value +
            '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Value {

    private Long id;
    private String quote;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" +
            "id=" + id +
            ", quote='" + quote + '\'' +
            '}';
    }
}