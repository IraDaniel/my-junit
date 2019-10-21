package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {

    private Method method;
    private boolean failed = false;

    public void invokeMethod(Object object) {
        try {
            method.invoke(object);
        } catch (InvocationTargetException e) {
            Throwable target = e.getTargetException();
            failed = true;
            target.printStackTrace();
        } catch (Throwable e) {
            failed = true;
            System.out.println("Test failed:" + method.getName());
            e.printStackTrace();
        }
    }

    public TestMethod(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public boolean isFailed() {
        return failed;
    }
}
