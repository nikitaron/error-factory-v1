package com.crypto.errorfactory.error.factory.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorType {
    BUSINESS("Business") {
        @Override
        public HttpStatus get() {
            return UNPROCESSABLE_ENTITY;
        }
    },
    VALIDATION("Validation") {
        @Override
        public HttpStatus get() {
            return BAD_REQUEST;
        }
    },
    SECURITY("Security") {
        @Override
        public HttpStatus get() {
            return FORBIDDEN;
        }
    };

    private final String type;
    public abstract HttpStatus get();
}
