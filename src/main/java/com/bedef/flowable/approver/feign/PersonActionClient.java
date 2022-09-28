package com.bedef.flowable.approver.feign;

import com.bedef.flowable.approver.TaskList;
import feign.Param;
import feign.RequestLine;

public interface PersonActionClient {

    @RequestLine("GET /tasks?assignee={assignee}")
    TaskList getTask(@Param("assignee") String assignee);
}
