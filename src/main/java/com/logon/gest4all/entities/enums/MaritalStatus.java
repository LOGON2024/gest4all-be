package com.logon.gest4all.entities.enums;

public enum MaritalStatus {
    SINGLE(1),
    MARRIED_IN_COMMUNITY_OF_PROPERTY(2),
    MARRIED_IN_A_SYSTEM_OF_PARTIAL_COMMUNITY_OF_PROPERTY(3),
    MARRIED_IN_A_SYSTEM_OF_SEPARATE_PROPERTY(4),
    SEPARATED(5),
    WIDOWED(6);

    private int code;

    private MaritalStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static MaritalStatus valueOf(int code) {
        for (MaritalStatus value : MaritalStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid MaritalStatus code");
    }

}
