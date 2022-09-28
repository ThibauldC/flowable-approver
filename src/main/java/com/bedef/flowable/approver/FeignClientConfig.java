package com.bedef.flowable.approver;

import com.bedef.flowable.approver.feign.PersonActionClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Value("${flowable.url:http://localhost:8080}")
    String flowableUrl;

    @Bean
    PersonActionClient client(){
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(PersonActionClient.class, flowableUrl);
    }
}
