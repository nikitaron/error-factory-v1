package com.crypto.errorfactory.error.factory.logic.operation;

import com.crypto.errorfactory.error.factory.api.error.dto.ErrorResponse;
import com.crypto.errorfactory.error.factory.configuration.HandleError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.crypto.errorfactory.error.factory.model.ErrorType.VALIDATION;

@Component
@RequiredArgsConstructor
public class ErrorBuilder<T extends RuntimeException> implements IErrorBuilder<T> {

    @Override
    public ErrorResponse build(T e) {
        var stackTraceElement = e.getStackTrace()[0];

        try {
            var clazz = Class.forName(stackTraceElement.getClassName());

            var type = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(method -> method.toString().contains(stackTraceElement.getMethodName()))
                    .findFirst()
                    .map(method -> {
                        var eType = method.getAnnotation(HandleError.class);

                        return eType == null ? VALIDATION : eType.type();
                    })
                    .orElseThrow(RuntimeException::new);

            return ErrorResponse.builder()
                    .errorType(type)
                    .message(e.getMessage())
                    .httpStatus(type.get())
                    .build();
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Class is not declared in class path");
        }
    }
}
