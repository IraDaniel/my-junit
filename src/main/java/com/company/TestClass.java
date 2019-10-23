package com.company;

import com.company.core.Test;

import static com.company.core.AssertUtils.assertThat;

public class TestClass {

    @Test
    public void test() {
        System.out.println("This is a test method:test()");
    }

    @Test
    public void running() {
        System.out.println("This is a test method:running()");
        System.out.println(1 / 0);
    }

    @Test
    public void testWithAssertion() {
        assertThat("error", false);
    }

    @Test
    public int testWithIncorrectResultType(int i){
        return i;
    }
}
