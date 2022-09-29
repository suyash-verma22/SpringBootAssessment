package com.basics.exceptionHandlers;

import java.util.Date;

public class ErrorInfo {
    private String message;
    private Date timestamp;
    private String errorInfo;


    public ErrorInfo() {
        //default constructor
    }

    public ErrorInfo(String message, Date timestamp, String errorInfo) {
        this.message = message;
        this.timestamp = timestamp;
        this.errorInfo = errorInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
