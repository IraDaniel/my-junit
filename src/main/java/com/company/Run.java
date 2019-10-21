package com.company;

import com.company.test.TestClass;

public class Run {


    public static void main(String[] args) throws Exception {
        ClassRunner classRunner = new ClassRunner();
        classRunner.runMethods(TestClass.class);
    }

}
