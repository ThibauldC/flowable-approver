package com.bedef.flowable.approver.feign;

import com.bedef.flowable.approver.domain.TaskEvaluation;
import com.bedef.flowable.approver.domain.TaskList;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PersonActionClient {

    @RequestLine("GET /tasks?assignee={assignee}")
    @Headers("Content-Type: application/json")
    TaskList getTasks(@Param("assignee") String assignee);

    @RequestLine("POST /task/evaluate")
    @Headers("Content-Type: application/json")
    void evaluateTask(TaskEvaluation taskEvaluation);
}
