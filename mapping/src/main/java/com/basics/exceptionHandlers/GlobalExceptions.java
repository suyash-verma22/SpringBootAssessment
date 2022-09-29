package com.basics.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleCustomerNotFoundException
            (CustomerNotFoundException customerNotFoundException, WebRequest webRequest)
    {
        ErrorInfo errorMessageInfo=new ErrorInfo(
                customerNotFoundException.getMessage(),
                new Date(),
                webRequest.getDescription(false));
        return new ResponseEntity(errorMessageInfo, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customizedValidationError
            (MethodArgumentNotValidException exception)
    {
        ErrorInfo errorMessageInfo=new ErrorInfo(
                exception.getFieldError().getDefaultMessage(),
                new Date(), "Validation Error");
        return new ResponseEntity<>(errorMessageInfo,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException
            (Exception exception,WebRequest webRequest)
    {
        ErrorInfo errorMessageInfo=new ErrorInfo(
                exception.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity(errorMessageInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
