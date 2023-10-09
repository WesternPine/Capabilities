package dev.westernpine.algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    // Divide and conquer algorithm.

    // O(n log(n))

    // Better for larger data sets, but uses more space

    public static void main() {
        Integer[] array = {5,7,4,9,3,6,1,8,2,0};
        sort(array);
        assert array[0] < array[array.length-1];
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int length = array.length;

        if(length <= 1) // base case
            return;

        int middle = length/2;
        T[] left = Arrays.copyOfRange(array, 0, middle);
        T[] right = Arrays.copyOfRange(array, middle, length);

        sort(left);
        sort(right);
        merge(left, right, array);
    }

    /*
     * While watching the tutorial on this sort in particular, I wasn't sure why he wasn't cycling through
     * all the elements in both arrays. But now working on this, I understand it now.
     *
     * Because we're sorting all arrays that have more than one element, we know that moving from left-right,
     * will automatically mean that the least value will be on the left.
     *
     * This is what makes merge-sort so powerful, because you're not worried about cycling through all values over and over again.
     * You can be sure that sub-arrays are already sorted.
     */
    private static <T extends Comparable<T>> void merge(T[] left, T[] right, T[] array) {

        int leftSize = array.length/2;
        int rightSize = array.length - leftSize;

        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize) { // While there's still elements in the left and right arrays...
            if(left[l].compareTo(right[r]) <= 0) { // If left compared to right is lesser, add it first, otherwise add right first.
                array[i] = left[l];
                i++;
                l++;
            } else {
                array[i] = right[r];
                i++;
                r++;
            }
        }

        // Catch the edge case where there's only one element leftover in either left or right arrays (because of odd array sizes).
        while(l < leftSize) {
            array[i] = left[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = right[r];
            i++;
            r++;
        }

    }
}
