package com.testvagrant.rest.builders;

import com.testvagrant.rest.resources.ErrorResponse;

public class ErrorResponseBuilder {

    private ErrorResponse error = new ErrorResponse();

    public ErrorResponseBuilder() {
        error.setMessage("");
    }

    public ErrorResponseBuilder withErrorMessage(String message) {
        error.setMessage(message);
        return this;
    }

    public ErrorResponse build() {
        return error;
    }
}
