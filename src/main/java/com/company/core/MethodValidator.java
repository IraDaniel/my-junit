package com.company.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodValidator {

    private static final String ERROR_METHOD_SHOULD_BE_VOID = "Method %s should be void";
    private static final String ERROR_METHOD_SHOULD_HAVE_NO_PARAMETERS = "Method %s should have no parameters";

    public static boolean isTestMethod(Method method) throws InitializationException{
        if (method.isAnnotationPresent(Test.class)) {
            List<String> errors = validateMethod(method);
            if (!errors.isEmpty()) {
                throw new InitializationException(errors);
            }
            return true;
        }
        return false;
    }

    private static List<String> validateMethod(Method method) {
        List<String> errors = new ArrayList<>();
        if (methodHasNoReturnType(method)) {
            errors.add(String.format(ERROR_METHOD_SHOULD_BE_VOID, method.getName()));
        }
        if (methodHasNoArguments(method)) {
            errors.add(String.format(ERROR_METHOD_SHOULD_HAVE_NO_PARAMETERS, method.getName()));
        }
        return errors;
    }

    private static boolean methodHasNoArguments(Method method) {
        return method.getParameterTypes().length != 0;
    }

    private static boolean methodHasNoReturnType(Method method) {
        return method.getReturnType() != void.class;
    }
}
