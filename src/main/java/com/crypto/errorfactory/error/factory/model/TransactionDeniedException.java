package com.crypto.errorfactory.error.factory.model;

public class TransactionDeniedException extends RuntimeException {

    public TransactionDeniedException(String message) {
        super(message);
    }
}
