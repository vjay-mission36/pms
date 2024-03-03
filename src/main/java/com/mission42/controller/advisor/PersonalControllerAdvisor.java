package com.mission42.controller.advisor;

import com.mission42.exception.PersonNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonalControllerAdvisor {

    @ExceptionHandler(PersonNotFoundException.class)
    public ErrorResponse personNotFoundWithGivenID(PersonNotFoundException personNotFoundException) {
        return ErrorResponse.create(personNotFoundException,
                HttpStatusCode.valueOf(500),
                "Person is not with given id");
    }

    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleAllGeneralizedExceptionAndErrors(Throwable th) {
        return ErrorResponse.create(th, HttpStatusCode.valueOf(400), "Some thing wring with service, Please retry aftersome time");
    }
}
