package com.company;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassRunner {

    public void runMethods(Class c) throws Exception {
        Object object = c.newInstance();// create instance of your class
        List<TestMethod> testMethods = findTestMethods(c);
        testMethods.forEach(testMethod -> testMethod.invokeMethod(object));
        List<String> failedMethods = testMethods.stream().filter(TestMethod::isFailed).map(TestMethod::getMethod).map(Method::getName).collect(Collectors.toList());
        if (!failedMethods.isEmpty()) {
            System.out.println("The following tests are failed: " + String.join(", ", failedMethods));
        } else {
            System.out.println("All tests passed");
        }


    }

    public List<TestMethod> findTestMethods(Class c) {
        return Arrays.stream(c.getDeclaredMethods()).filter(ClassRunner::isTestMethod).map(TestMethod::new).collect(Collectors.toList());
    }


    private static boolean isTestMethod(Method method) {
        return method.isAnnotationPresent(Test.class) && method.getReturnType() == void.class && method.getParameterTypes().length == 0;
    }
}
