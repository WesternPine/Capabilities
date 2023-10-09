package dev.westernpine.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    // O(n^2)

    // Compares adjacent elements

    // Small data sets = okish
    // med-large data sets = BAD DONT! PLZ!

    public static void main() {
        Integer[] array = {5,7,4,9,3,6,1,8,2,0};
        sort(array);
        assert array[0] < array[array.length-1];
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        T temp = null;
        for(int i = 0; i < array.length-1; i++) {
            for(int j = 0; j < array.length - 1 - i; j++) {
                if(array[j].compareTo(array[j+1]) > 0) {
                    temp = array[j + 1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
