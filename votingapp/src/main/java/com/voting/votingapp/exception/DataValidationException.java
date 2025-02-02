package com.voting.votingapp.exception;

import lombok.Data;

@Data
public class DataValidationException extends PollException {

    private final String errorDescription;

    public DataValidationException(String message) {
        super(message);
        this.errorDescription = "something went wrong";
    }

    public DataValidationException(String message, String errorDescription) {
        super(message, errorDescription);
        this.errorDescription = errorDescription;
    }
}
