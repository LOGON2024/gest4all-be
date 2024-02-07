package com.logon.gest4all.entities.enums;

public enum ClientState {
    CLIENT(1),
    NOT_CLIENT(2);

    private int code;

    private ClientState(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ClientState valueOf(int code) {
        for (ClientState value : ClientState.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ClientState code");
    }
}
