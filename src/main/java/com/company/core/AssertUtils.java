package com.company.core;

public class AssertUtils {

    private AssertUtils() {
    }

    public static void assertThat(String reason, boolean assertion) {
        if (!assertion) {
            throw new AssertionError(reason);
        }
    }
}
