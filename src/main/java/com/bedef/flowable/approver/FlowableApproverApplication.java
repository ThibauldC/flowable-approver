package com.bedef.flowable.approver;

import com.bedef.flowable.approver.feign.PersonActionClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlowableApproverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlowableApproverApplication.class, args);
	}

	@Override
	public void run(String... args){
		PersonActionClient client = Feign.builder()
				.decoder(new JacksonDecoder())
				.target(PersonActionClient.class, "http://localhost:8080");

		client.getTasks("snr").getTasks().forEach(System.out::println);
	}
}
