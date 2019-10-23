package com.company.core;

import java.util.List;

import static java.lang.String.join;

public class InitializationException extends RuntimeException {
    private List<String> error;
    private static final String begin = "Initialization error.";

    public InitializationException(List<String> error) {
        super(begin + join(".", error));
        this.error = error;
    }

    public List<String> getError() {
        return error;
    }
}
