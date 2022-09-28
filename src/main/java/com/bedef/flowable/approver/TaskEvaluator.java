package com.bedef.flowable.approver;

import com.bedef.flowable.approver.domain.PersonInfo;
import com.bedef.flowable.approver.domain.Task;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class TaskEvaluator {

    public void evaluateTask(Task task){
        PersonInfo info = task.getInfo();
        System.out.printf("Name: %s%nMil code: %s%n",info.getName(), info.getMilCode());

        switch (task.getAction()) {
            case MARITAL -> System.out.println("This person has a marital change. Approve?");
            case FAMILY -> System.out.println("This person has a family change. Approve?");
            case ADDRESS -> System.out.println("This person has an address change. Approve?");
        }

        Scanner scanner= new Scanner(System.in);
        String appr = scanner.nextLine().equalsIgnoreCase("y") ? "approved" : "rejected";
        System.out.println(appr);
    }
}
