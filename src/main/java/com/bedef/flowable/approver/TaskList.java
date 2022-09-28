package com.bedef.flowable.approver;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskList {

    private List<String> tasks;
}
