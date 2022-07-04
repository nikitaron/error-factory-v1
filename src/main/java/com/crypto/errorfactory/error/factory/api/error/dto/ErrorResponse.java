package com.crypto.errorfactory.error.factory.api.error.dto;

import com.crypto.errorfactory.error.factory.model.ErrorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Value
@Builder
public class ErrorResponse {
    String message;

    @JsonProperty(value = "type")
    ErrorType errorType;

    @JsonIgnore
    HttpStatus httpStatus;

    Instant timestamp = Instant.now();
}
