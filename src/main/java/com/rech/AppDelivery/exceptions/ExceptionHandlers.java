package com.rech.AppDelivery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(UserInfoOutOfCompliance.class)
    public ResponseEntity<StandardException> userInfoOutOfComplianceException(UserInfoOutOfCompliance ex, HttpServletRequest request){
        StandardException exception = new StandardException(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI());
        return ResponseEntity.status(exception.getStatus()).body(exception);
    }

    @ExceptionHandler(EmailAlreadyInUse.class)
    public ResponseEntity<StandardException> emailAlreadyInUseException(EmailAlreadyInUse ex, HttpServletRequest request) {
        StandardException standardException = new StandardException(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI());
        return ResponseEntity.status(standardException.getStatus()).body(standardException);
    }
}
