package com.rech.AppDelivery.exceptions;

import java.time.LocalDateTime;

public class StandardException {
    LocalDateTime timeStamp;
    String errorMessage;
    Integer status;
    String path;

    public StandardException(LocalDateTime timeStamp, String errorMessage, Integer status, String path) {
        this.timeStamp = timeStamp;
        this.errorMessage = errorMessage;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
