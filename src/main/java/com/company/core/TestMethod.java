package com.company.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {

    private static final String TEST_FAILED = "Test failed: ";

    private Method method;
    private boolean failed = false;

    public TestMethod(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public boolean isFailed() {
        return failed;
    }

    public void invokeMethod(Object object) {
        try {
            method.invoke(object);
        } catch (InvocationTargetException e) {
            failed = true;
            Throwable target = e.getTargetException();
            System.err.println(TEST_FAILED + method.getName());
            target.printStackTrace();
        } catch (Throwable e) {
            failed = true;
            System.err.println(TEST_FAILED + method.getName());
            e.printStackTrace();
        }
    }
}
