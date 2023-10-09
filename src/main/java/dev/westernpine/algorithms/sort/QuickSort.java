package dev.westernpine.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    // Most QuickSort algorithms use a pivot point at the end of the array.

    // Basically the main goal is to move out pivot to it's correct position.
    // So we go through the entire array comparing everything to the pivot.
    // After that, we know where our pivot lies,
    // as it's the last position that was last measured to be less that the pivot.

    // Then we partition out the array, and recursively quick-sort the partitions.

    // Like merge-sort, it's a divide and conquor algorithm.
    // Unlike merge-sort, this is an in-place sorting algorithm.

    // Time:
    // Best: O(n log(n))
    // Average: O(n log(n))
    // Worst: O(n^2) if already sorted.
    //
    // Space: O(log(n)) (for recursion memory consumption)

    public static void main() {
        Integer[] array = {6,7,4,9,3,0,1,8,2,5};
        sort(array);
        assert array[0] < array[array.length-1];
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length-1);
    }

    public static <T extends Comparable<T>> void sort(T[] array, int start, int end) {

        // Base case.
        if(end <= start)
            return;

        int pivot = partition(array, start, end);
        sort(array, start, pivot-1);
        sort(array, pivot+1, end);
    }

    public static <T extends Comparable<T>> int partition(T[] array, int start, int end) {
        int i = start-1;
        int pivot = end;

        for(int j = start; j <= end; j++) {
            if(array[j].compareTo(array[pivot]) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Final swap.
        // Since I was just a placeholder to swap lesser values to,
        // we increment I, and set the resting pivot point.
        i++;
        T temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i; // "i" is the pivot point now.
    }
}
