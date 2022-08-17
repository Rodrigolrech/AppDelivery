package com.rech.AppDelivery.exceptions;

public class EmailAlreadyInUse extends RuntimeException{
    public EmailAlreadyInUse(String message) {
        super(message);
    }
}
