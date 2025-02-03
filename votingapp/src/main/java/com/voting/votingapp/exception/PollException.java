package com.voting.votingapp.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PollException extends Exception {

    private final String errorDescription;

    public PollException(String message) {
        super(message);
        errorDescription = "Something went wrong";
    }

    public PollException(String message, String errorDescription) {
        super(message);
        this.errorDescription = errorDescription;
    }
}
