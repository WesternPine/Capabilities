package dev.westernpine.algorithms;

import java.util.function.Function;

public class BigONotation {

    public static void main() {

        // Big O Notation
        // - How code slows as data grows.

        // 1. Describes performance of algorithms as the amount of data increases.
        // 2. Machine independent.
        // 3. Ignore smaller operations. O(n+1) is just O(n)

        /*
         * Data (n)
         * |
         * |
         * |_______
         * L__________ Time (steps)
         * O(1) - Constant time, no matter the size.
         * - HashMaps basically...
         *
         * Data (n)
         * |
         * |  /-----------
         * |/
         * L__________ Time (steps)
         * O(log n) - Logarithmic time.
         * - Binary Searches
         *
         * Data (n)
         * |        /
         * |     /
         * |  /
         * L__________ Time (steps)
         * O(n) - Linear time, time increases with data size.
         * - Looping through each element.
         *
         * Data (n)
         * |      /
         * |    /
         * |  /
         * L__________ Time (steps)
         * O(n log n) - Quasilinear time. Time increases with data size, plus leftover data from failed analysis.
         * - QuickSort, MergeSort, HeapSort.
         *
         *
         * Data (n)
         * |   |
         * |  /
         * | /
         * L__________ Time (steps)
         * O(n^2) - Quadratic time. Time increases by double the data amount.
         * - InsertionSort, SelectionSort, BubbleSort.
         *
         *
         * Data (n)
         * |  |
         * |  |
         * | /
         * L__________ Time (steps)
         * O(n!) - Factorial time. Time increases exponentially as the dataset grows.
         * - Traveling salesman problem.
         */

        // This is O(1), because to get the same result, we are not dependent on the data size. We can calculate the same result in the same amount of steps.
        Function<Integer, Integer> addUpConstant = (n) -> {
            return n * (n+1) / 2;
        };

        // This is O(n), because to complete all operations, we're dependent on the data size. In this case, int n is the data size.
        Function<Integer, Integer> addUpLinear = (n) -> {
            int sum = 0;
            for(int i = 0; i <= n; i++)
                sum += i;
            return sum;
        };

    }

}
