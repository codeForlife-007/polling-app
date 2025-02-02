package com.voting.votingapp.core;

import com.voting.votingapp.exception.DataValidationException;
import com.voting.votingapp.exception.NotFoundException;
import com.voting.votingapp.exception.PollException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        return new ResponseEntity<>(ErrorDto.from(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PollException.class)
    public ResponseEntity<ErrorDto> handlePollException(PollException e) {
        return new ResponseEntity<>(ErrorDto.from(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ErrorDto.from(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataValidationException.class)
    public ResponseEntity<ErrorDto> handleDataValidationException(DataValidationException e) {
        return new ResponseEntity<>(ErrorDto.from(e), HttpStatus.BAD_REQUEST);
    }
}
