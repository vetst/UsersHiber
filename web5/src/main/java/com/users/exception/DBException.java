package com.users.exception;

public class DBException extends Exception {

    public DBException(Throwable throwable) {
        super(throwable);
    }

    public DBException(String message, Throwable throwable) {
        super(throwable);
    }

    public DBException(String message) {
        super(message);
    }
}
