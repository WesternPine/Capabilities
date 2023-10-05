package dev.westernpine.algorithms;

import java.util.Comparator;

public class BinarySearch {

    // Iterate through a collection, half of its elements at a time.
    // Time Complexity: O(log n)

    // Disadvantages:
    // - Requires sorting
    // - Not great for medium data sets.
    // - Requires random access.
    // - Requires a comparator.

    // Advantages:
    // - Fast for small and large data sets.

    public static void main() {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 12};

        assert search(array, 9, Integer::compareTo) == 9;
        assert search(array, 12, Integer::compareTo) == 10;
        assert search(array, 10, Integer::compareTo) == -1;
    }

    public static <T> int search(T[] array, T value, Comparator<T> comparator) {
        int startIndex = 0;
        int maxIndex = array.length-1;
        int index = maxIndex/2;
        int result;

        while(true) {
            result = comparator.compare(value, array[index]);

            if(result == 0)
                return index;

            // This means there's 2 possible checks left. We're either the start or max, or we aren't here.
            if(maxIndex - startIndex <= 1) {
                if(comparator.compare(value, array[startIndex]) == 0)
                    return startIndex;

                if(comparator.compare(value, array[maxIndex]) == 0)
                    return maxIndex;

                return -1;
            }

            // Shrink the bounds.
            startIndex = result < 0 ? startIndex : index;
            maxIndex = result > 0 ? maxIndex : index;

            // Index assignment put at end for better optimization.
            index = maxIndex - (maxIndex - startIndex)/2;
        }
    }

}
