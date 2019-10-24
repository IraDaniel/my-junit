package com.company.core.exception;

import java.util.List;

import static java.lang.String.join;

public class ValidationException extends Exception {
    private List<String> error;

    public ValidationException(List<String> error) {
        super(join(". ", error));
        this.error = error;
    }

    public List<String> getError() {
        return error;
    }
}
