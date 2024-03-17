package com.rybialek.invoicesystem.error;

import java.util.Date;

public class ErrorDetails {
    private final Date timestamp;
    private final String message;
    private final String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public final Date getTimestamp() {
        return timestamp;
    }

    public final String getMessage() {
        return message;
    }

    public final String getDetails() {
        return details;
    }
}
