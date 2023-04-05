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

    RUNTIME_EXCEPTION(9000, "Unhandled runtime error occurred!", INTERNAL_SERVER_ERROR),

    /*
        General errors.
     */
    INTERNAL_ERROR(9001, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(9002, "Invalid Parameter Error", BAD_REQUEST),
    RESOURCE_NOT_FOUND(9003, "Resource is not Found", NOT_FOUND),
    RESPONSE_NOT_FOUND(9004, "Response is not Found", BAD_REQUEST),

    QUESTION_NOT_FOUND(9005, "Question is not Found", BAD_REQUEST),
    CLASSROOM_NOT_FOUND(9006, "Classroom is not found", BAD_REQUEST),
    CLASSROOM_ALREADY_EXISTS(9007, "Classroom is already exists", BAD_REQUEST),
    SURVEY_ALREADY_ANSWERED(9008, "This user already has answers for this survey.", BAD_REQUEST),
    USER_DOES_NOT_EXIST(9009, "No such user.", BAD_REQUEST),
    USER_INSUFFICIENT_ANSWER(9010, "User must answer all the questions.", BAD_REQUEST),
    QUESTIONS_AND_RESPONSES_DOES_NOT_MATCH(9011, "Questions and responses does not matches", BAD_REQUEST),
    QUESTION_TYPE_NOT_FOUND(9012, "Question type is not Found", BAD_REQUEST),
    SURVEY_NOT_FOUND(9013, "Survey is not found", BAD_REQUEST),
    ROLE_ALREADY_EXISTS(9014, "Role is already exists", BAD_REQUEST),
    ROLE_NOT_FOUND(9015, "Role is not found", BAD_REQUEST),

    STUDENT_TAG_ALREADY_EXISTS(9016, "Student Tag is already exists", INTERNAL_SERVER_ERROR),
    QUESTION_TAG_ALREADY_EXISTS(9017, "Question Tag is already exists", INTERNAL_SERVER_ERROR),
    TRAINER_TAG_ALREADY_EXISTS(9018, "Trainer Tag is already exists", INTERNAL_SERVER_ERROR),
    SURVEY_TAG_ALREADY_EXISTS(9019, "Survey Tag is already exists", INTERNAL_SERVER_ERROR),

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
