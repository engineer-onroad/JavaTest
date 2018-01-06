package com.java.algorithm.test;

import org.junit.Test;

public class NFactZeroTest {
    @Test
    public void testNFactZero() {
        int N = 100;
        int num0 = get0Num(N);
        System.out.println(N + "! has 0 in the end:" + num0);
    }

    public int get0Num(int nFact) {
        int num0 = 0;
        if (nFact > 0 && nFact < 5) {
            num0 = 0;
        } else if (nFact >= 5) {
            int times = nFact / 5;
            num0 = times + this.get0Num(times);
        }
        return num0;
    }
}
