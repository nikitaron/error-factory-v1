package com.crypto.errorfactory.error.factory.api.error.handler;

import com.crypto.errorfactory.error.factory.api.error.dto.ErrorResponse;
import com.crypto.errorfactory.error.factory.logic.operation.IErrorBuilder;
import com.crypto.errorfactory.error.factory.model.IdentityException;
import com.crypto.errorfactory.error.factory.model.SignInException;
import com.crypto.errorfactory.error.factory.model.SignUpException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {
    private final IErrorBuilder<? super RuntimeException> errorBuilder;

    @ExceptionHandler(SignUpException.class)
    public ResponseEntity<ErrorResponse> handle(SignUpException e) {
        var error = errorBuilder.build(e);

        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(SignInException.class)
    public ResponseEntity<ErrorResponse> handle(SignInException e) {
        var error = errorBuilder.build(e);

        return new ResponseEntity<>(error, error.getHttpStatus());
    }

    @ExceptionHandler(IdentityException.class)
    public ResponseEntity<ErrorResponse> handle(IdentityException e) {
        var error = errorBuilder.build(e);

        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
