package com.company;

import com.company.core.Test;

/**
 * Created by Ira on 24.10.2019.
 */
public class TestClassValid {
    @Test
    public void testSuccess() {
        System.out.println("This is a testSuccess method:testSuccess()");
    }

    @Test
    public void testThrowException() {
        int i = 1 / 0;
    }
}
