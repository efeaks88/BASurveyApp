package com.bilgeadam.basurveyapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Eralp Nitelik
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionType {
    /*
        Unknown errors.
     */
    UNEXPECTED_ERROR(9000, "Unexpected Error! Please submit a report.", INTERNAL_SERVER_ERROR),

    /*
        General errors.
     */
    INTERNAL_ERROR(9001, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(9002, "Invalid Parameter Error", BAD_REQUEST),
    RESOURCE_NOT_FOUND(9003, "Resource is not Found", BAD_REQUEST),
    /*
        Validation errors.
     */
    DATA_NOT_VALID(1001, "Data does not meet requirements", BAD_REQUEST),

    /*
        Authentication errors.
     */
    ACCESS_DENIED(2000, "Access denied.", UNAUTHORIZED),
    LOGIN_ERROR_USERNAME_DOES_NOT_EXIST(2001, "Username does not exist.", NOT_FOUND),
    LOGIN_ERROR_WRONG_PASSWORD(2002, "Wrong password.", BAD_REQUEST),

    /*
        Register errors.
     */
    REGISTER_ERROR_DATA_EXISTS(3001, "Data already exists.", BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}