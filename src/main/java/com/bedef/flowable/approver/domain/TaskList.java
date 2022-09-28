package com.bedef.flowable.approver.domain;

import com.bedef.flowable.approver.domain.PersonInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskList {

    private List<PersonInfo> tasks;
}
