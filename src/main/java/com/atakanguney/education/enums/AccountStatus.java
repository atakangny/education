package com.atakanguney.education.enums;

import java.util.Arrays;
import java.util.Objects;

public enum AccountStatus {
    EXPIRED("E","Expired"),
    ACTIVE("A","Active"),
    PASSIVE("P","Passive"),
    WAITING_APPROVAL("W","Waiting Approval");

    private final String key;
    private final String value;


    AccountStatus(String key, String value){
        this.key = key;
        this.value = value;
    }

    public AccountStatus of(String key) {
        return Arrays.stream(AccountStatus.values()).filter(a-> Objects.equals(a.key, key)).findFirst().orElse(null);
    }

}
