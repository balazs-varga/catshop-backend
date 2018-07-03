package com.greenfox.catshop.error;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResource {
    private final HttpStatus status;

    private final String message;

    private final Date timestamp;

    public ErrorResource(final String message, final HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timestamp = new Date();
    }

    public static ErrorResource of(final String message, HttpStatus status) {
        return new ErrorResource(message, status);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
