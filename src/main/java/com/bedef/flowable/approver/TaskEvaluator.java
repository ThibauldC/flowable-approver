package com.bedef.flowable.approver;

import com.bedef.flowable.approver.domain.Action;
import com.bedef.flowable.approver.domain.PersonInfo;
import com.bedef.flowable.approver.domain.TaskEvaluation;
import com.bedef.flowable.approver.domain.TaskInfo;
import com.bedef.flowable.approver.feign.PersonActionClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TaskEvaluator {

    @Autowired
    private PersonActionClient client;

    public void evaluateTask(TaskInfo task){
        PersonInfo info = task.getInfo();
        System.out.printf("Name: %s%nMil code: %s%n",info.getName(), info.getMilCode());

        switch (Action.fromString(info.getAction())) {
            case MARITAL -> System.out.println("This person has a marital change. Approve?");
            case FAMILY -> System.out.println("This person has a family change. Approve?");
            case ADDRESS -> System.out.println("This person has an address change. Approve?");
        }

        Scanner scanner= new Scanner(System.in);
        TaskEvaluation eval = new TaskEvaluation(task.getId(), scanner.nextLine().equalsIgnoreCase("y"));
        System.out.println(eval);
        client.evaluateTask(eval);
    }
}
