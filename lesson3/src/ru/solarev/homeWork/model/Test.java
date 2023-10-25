package ru.solarev.homeWork.model;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    static int count = 0;
    static volatile int count1 = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
//        Thread thread = new MyThread();
//        thread.setPriority(Thread.MAX_PRIORITY);
//        thread.start();
//        new MyThread().start();
//        new MyThread().start();
//
//        System.out.println("Final: " + count);
//        System.out.println("Final c1: " + count1);
//        System.out.println("Final atomic " + atomicInteger);

//        System.out.println(fact(3));
        int[] array = {4, 5, 1, 2, 7, 9, 3};
//        System.out.println(Arrays.toString(bubbleSort(array)));
        int low = 0;
        int high = array.length - 1;

        System.out.println(Arrays.toString(quickSort(array, low, high)));


    }

    public static int[] bubbleSort(int[] array) {
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i-1] > array[i]) {
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                    sorted = false;
                }
            }
        }

        return array;
    }

    public static int[] quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high) {
            return array;
        }

        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
        return array;
    }



    public static int fact(int num) {
        return num == 1? 1 : num * fact(num - 1);
    }



    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                count+= 1;
                count1++;
                atomicInteger.incrementAndGet();
                System.out.println(count);
            }
        }
    }
}


