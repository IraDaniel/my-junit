package com.company.core.exception;

import java.util.List;

/**
 * Created by Ira on 24.10.2019.
 */
public class InitializationException extends RuntimeException {

    private static final String begin = "Initialization error. \n";

    public InitializationException(List<String> messages) {
        super(begin + String.join("\n", messages));
    }
}
