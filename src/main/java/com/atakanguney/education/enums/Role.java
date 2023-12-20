package com.atakanguney.education.enums;

import java.util.Arrays;
import java.util.Objects;

public enum Role {

    UNASSIGNED("UNASSIGNED", "ROLE_UNASSIGNED"),
    ADMIN("ADMIN", "ROLE_ADMIN"),
    STUDENT("STUDENT", "ROLE_STUDENT"),
    TEACHER("TEACHER", "ROLE_TEACHER");


    private final String key;
    private final String value;

    Role(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Role of(String key) {
        return Arrays.stream(Role.values()).filter(a-> Objects.equals(a.key, key)).findFirst().orElse(null);
    }

}
