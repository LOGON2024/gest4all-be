package com.logon.gest4all.entities.enums;

public enum DeletedState {
    ACTIVE(1),
    DELETED(2);

    private int code;

    private DeletedState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static DeletedState valueOf(int code) {
        for (DeletedState value : DeletedState.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid DeletedState code");
    }
}
