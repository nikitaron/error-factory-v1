package com.crypto.errorfactory.error.factory.logic.operation;

import com.crypto.errorfactory.error.factory.api.error.dto.ErrorResponse;

public interface IErrorBuilder<T extends RuntimeException> {

    ErrorResponse build(T e);
}
