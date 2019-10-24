package com.company;

import com.company.core.Test;

import static com.company.core.AssertUtils.assertThat;

/**
 * This class will be launched with an initialization exception because it contains invalid test methods
 */
public class TestClass {

    @Test
    public void testSuccess() {
        System.out.println("This is a testSuccess method:testSuccess()");
    }

    @Test
    public void testThrowException() {
        System.out.println("This is a testSuccess method: testThrowException()");
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
