package com.java.algorithm.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 求前面的最大K个 解决方案：小根堆
 * (数据量比较大（特别是大到内存不可以容纳）时，偏向于采用堆)
 */
public class TopKByHeap {

    /**
     * 创建k个节点的小根堆
     *
     * @param a
     * @param k
     * @return
     */
    int[] createHeap(int a[], int k) {
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = a[i];
        }
        for (int i = 1; i < k; i++) {
            int child = i;
            int parent = (i - 1) / 2;
            int temp = a[i];
            while (parent >= 0 && child != 0 && result[parent] > temp) {
                result[child] = result[parent];
                child = parent;
                parent = (parent - 1) / 2;
            }
            result[child] = temp;
        }
        return result;

    }

    void insert(int a[], int value) {
        a[0] = value;
        int parent = 0;

        while (parent < a.length) {
            int lchild = 2 * parent + 1;
            int rchild = 2 * parent + 2;
            int minIndex = parent;
            if (lchild < a.length && a[parent] > a[lchild]) {
                minIndex = lchild;
            }
            if (rchild < a.length && a[minIndex] > a[rchild]) {
                minIndex = rchild;
            }
            if (minIndex == parent) {
                break;
            } else {
                int temp = a[parent];
                a[parent] = a[minIndex];
                a[minIndex] = temp;
                parent = minIndex;
            }
        }
    }

    /***
     * 从数组中加载数据并计算topN
     * @param input  源数据，用于计算topN的数组
     * @param k  topN中具体N的值
     * @return
     */
    int[] getTopKByHeap(int input[], int k) {
        int heap[] = this.createHeap(input, k);
        for (int i = k; i < input.length; i++) {
            if (input[i] > heap[0]) {
                this.insert(heap, input[i]);
            }
        }
        return heap;
    }

    /**
     * 从文件中加载数据并计算topN
     * 假设文件中一行数据格式为：商品名称/t 商品价格
     *
     * @param path 文件路径
     */
    public int[] readDataFromBigFile(String path, int k) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        int[] result = new int[k];
        int index = 0;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] vals = line.split("\\s");
                int price = Integer.parseInt(vals[1]);
                if (index >= k) {
                    this.insert(result, price);
                } else {
                    result[index++] = price;
                    if (index == k) {
                        result = createHeap(result, k);
                    }
                }
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {4, 3, 5, 1, 2, 8, 9, 10};
        int result[] = new TopKByHeap().getTopKByHeap(a, 3);
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}
