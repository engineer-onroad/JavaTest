package com.java.algorithm.test;

import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void testHeapSort() {
        int[] A = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        this.heapSort(A);
        System.out.println(Arrays.toString(A));
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public void maxHeapify(int[] A, int i, int length) {
        int l = left(i);
        int r = right(i);
        int largetest = i;
        if (l < length && A[l] > A[i]) {
            largetest = l;
        } else {
            largetest = i;
        }
        if (r < length && A[r] > A[largetest]) {
            largetest = r;
        }
        if (largetest != i) {
            int temp = A[i];
            A[i] = A[largetest];
            A[largetest] = temp;
            this.maxHeapify(A, largetest, length);
        }
    }

    public void buildMaxHeap(int[] A) {
        int heapSize = A.length - 1;
        for (int i = heapSize / 2; i >= 0; i--) {
            this.maxHeapify(A, i, A.length);
        }
    }

    public void heapSort(int[] A) {
        this.buildMaxHeap(A);
        for (int i = A.length - 1; i >= 1; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            System.out.println(Arrays.toString(A));
            this.maxHeapify(A, 0, i);
        }
    }
}
