package com.java.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void testQuickSort() {
        int[] A = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        this.quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    public int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i = i + 1;
                this.exchange(A, i, j);
            }
        }
        this.exchange(A, i + 1, r);
        return i + 1;
    }

    public void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = this.partition(A, p, r);
            this.quickSort(A, p, q - 1);
            this.quickSort(A, q + 1, r);
        }
    }

    public void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
