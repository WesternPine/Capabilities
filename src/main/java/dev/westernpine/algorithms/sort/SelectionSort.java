package dev.westernpine.algorithms.sort;

public class SelectionSort {

    // Similar to BubbleSort.

    // Compares adjacent elements, from the beginning, and moves the smallest to the start.

    // Small data sets = okish
    // med-large data sets = BAD DONT! PLZ!

    public static void main() {
        Integer[] array = {5,7,4,9,3,6,1,8,2,0};
        sort(array);
        assert array[0] < array[array.length-1];
    }

    public static <T extends Comparable<T>> void sort(T[] array) {

        for(int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

    }
}
