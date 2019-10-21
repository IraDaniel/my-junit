package com.company.test;

import com.company.Test;

public class TestClass {

    @Test
    public void test() {
        System.out.println("This is a test method:test()");
    }


    @Test
    public void running() {
        System.out.println("This is a test method:running()");
        System.out.println(1/0);
    }
}
