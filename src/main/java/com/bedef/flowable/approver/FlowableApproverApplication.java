package com.bedef.flowable.approver;

import com.bedef.flowable.approver.domain.Action;
import com.bedef.flowable.approver.domain.Task;
import com.bedef.flowable.approver.feign.PersonActionClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlowableApproverApplication implements CommandLineRunner {

	@Autowired
	TaskEvaluator taskEvaluator;

	public static void main(String[] args) {
		SpringApplication.run(FlowableApproverApplication.class, args);
	}

	@Override
	public void run(String... args){
		PersonActionClient client = Feign.builder()
				.decoder(new JacksonDecoder())
				.target(PersonActionClient.class, "http://localhost:8080");

		List<Task> tasks = client.getTasks("snr").getTasks()
				.stream()
				.map(p -> new Task(p, Action.fromString(p.getAction())))
				.toList();

		System.out.println("Starting approval process");
		System.out.printf("You have %d open tasks to approve/reject.%n", tasks.size());

		tasks.forEach(t -> taskEvaluator.evaluateTask(t));
	}
}
