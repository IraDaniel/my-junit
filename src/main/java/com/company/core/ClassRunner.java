package com.company.core;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassRunner {

    private static final String TESTS_FAILED = "The following tests are failed: ";
    private static final String RESULT = "Result: Pass: %d; Failed: %d; Total: %d";
    private static final String NO_RUNNABLE_METHODS = "No runnable methods";

    public <T> void runMethods(Class<T> clazz) throws Exception {
        Object object = clazz.getDeclaredConstructor().newInstance();// create instance of your class
        List<TestMethod> testMethods = findTestMethods(clazz);
        if (testMethods.isEmpty()) {
            throw new Exception(NO_RUNNABLE_METHODS);
        }
        testMethods.forEach(testMethod -> testMethod.invokeMethod(object));
        processResult(testMethods);
    }

    /**
     * Validate that class contains at least one test method and all test methods are valid
     */
    private static <T> void validateTestClass(Class<T> clazz) {
//        List<String> errors;
//        Arrays.stream(clazz.getDeclaredMethods())
//                .filter(MethodValidator::isTestMethod)
    }

    private static List<TestMethod> findTestMethods(Class c) {
        return Arrays.stream(c.getDeclaredMethods())
                .filter(MethodValidator::isTestMethod)
                .map(TestMethod::new)
                .collect(Collectors.toList());
    }

    private void processResult(List<TestMethod> testMethods) {
        List<TestMethod> failedMethods = testMethods.stream()
                .filter(TestMethod::isFailed)
                .collect(Collectors.toList());
        long numberOfPassedMethods = testMethods.stream()
                .filter(test -> !test.isFailed())
                .count();
        if (!failedMethods.isEmpty()) {
            String failedMethodNames = failedMethods.stream()
                    .map(TestMethod::getMethod)
                    .map(Method::getName)
                    .collect(Collectors.joining(","));
            System.err.println(TESTS_FAILED + failedMethodNames);
        }
        System.out.println(String.format(RESULT, numberOfPassedMethods, failedMethods.size(), testMethods.size()));
    }


}
