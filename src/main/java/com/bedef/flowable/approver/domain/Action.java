package com.bedef.flowable.approver.domain;

import lombok.Getter;

import java.util.Arrays;

public enum Action {
    MARITAL("MaritalChange"),
    ADDRESS("AddressChange"),
    FAMILY("FamilyChange");

    @Getter
    private String change;
    Action(String change){
        this.change = change;
    }

    public static Action fromString(String change){
        return Arrays.stream(values())
                .filter(v -> v.getChange().equals(change))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Action not found"));
    }
}
