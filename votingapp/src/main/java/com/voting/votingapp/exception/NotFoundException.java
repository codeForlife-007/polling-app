package com.voting.votingapp.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends PollException {

    private final String errorDescription;

    public NotFoundException(String message) {
        super(message);
        this.errorDescription = "Something went wrong";
    }

    public NotFoundException(String message, String errorDescription) {
        super(message);
        this.errorDescription = errorDescription;
    }
}
