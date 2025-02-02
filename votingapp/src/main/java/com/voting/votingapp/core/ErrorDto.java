package com.voting.votingapp.core;

import com.voting.votingapp.exception.PollException;
import lombok.Data;

@Data
public class ErrorDto {

    private String message;
    private String errorDescription;

    public static ErrorDto from(Exception e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        Throwable cause = new Throwable();
        if (cause != null) {
            errorDto.setErrorDescription(cause.getLocalizedMessage());
        }
        return errorDto;
    }

    public static ErrorDto from(PollException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setErrorDescription(e.getLocalizedMessage());
        return errorDto;
    }
}
