package com.malets.clean.exception;

public class DAoException extends Exception {
    public DAoException() {
        super();
    }

    public DAoException(String message) {
        super(message);
    }

    public DAoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAoException(Throwable cause) {
        super(cause);
    }
}
