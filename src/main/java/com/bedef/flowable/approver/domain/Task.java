package com.bedef.flowable.approver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private PersonInfo info;
    private Action action;
}
