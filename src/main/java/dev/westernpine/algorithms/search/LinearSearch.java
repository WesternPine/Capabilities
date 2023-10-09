package dev.westernpine.algorithms.search;

public class LinearSearch {

    // Iterate through a collection one element at a time.
    // Time Complexity: O(n)

    // Disadvantages:
    // - Slow for large data sets.

    // Advantages:
    // - Fast for small-medium data sets.
    // - No sorting required.
    // - Useful for Data Structures without random access.

    public static void main() {

        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12};

        assert search(array, 3) == 3;
        assert search(array, 1) == 1;
        assert search(array, 12) == 10;
    }

    public static <T> int search(T[] array, T value) {
        for(int i = 0; i < array.length; i++) // Using counting method since we want to find the index.
            if(array[i] == value)
                return i;
        return -1;
    }

}
