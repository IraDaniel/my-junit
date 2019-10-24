package com.company;

import com.company.core.ClassRunner;

public class Run {

    public static void main(String[] args) throws Exception {
        ClassRunner classRunner = new ClassRunner();
        if (args.length == 0) {
            throw new IllegalArgumentException("Please add a class to testSuccess.");
        }

        try {
            Class<?> aClass = Class.forName(args[0]);
            classRunner.runMethods(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
