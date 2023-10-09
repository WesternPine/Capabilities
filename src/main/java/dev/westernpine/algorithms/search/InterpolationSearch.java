package dev.westernpine.algorithms.search;

public class InterpolationSearch {

    // Improvement over binary for uniformly distributed data.
    // "guesses" where a value might be, are based on calculated probe results.
    // If probe is incorrect, search area is narrowed, and a new probe is calculated.

    // Basically we're converting a given value into a probable position, given an upper and lower bounds.
    // Meanwhile, we're constantly decreasing the search area.

    // Average case: O(log(log(n)))
    // Worst Case: O(n)

    public static void main() {
        Integer[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

        assert search(array, 256) == 8;
        assert search(array, 8) == 3;
        assert search(array, 10) == -1;
    }

    public static Integer search(Integer[] array, Integer value) {

        int lower = 0;
        int upper = array.length-1;

        // While we know we're within the bounds...
        while(value >= array[lower]
                && value <= array[upper]
                && lower <= upper) { // And we haven't exhausted all possibilities...

            // Multiply the possibilities, by a decimal/percentage representation
            // of where a value would lye if all data is evenly distributed. (2, 4, 6, 8, 10, etc...)
            int probe =
                    lower + (upper - lower) // count of all possible indexes, plus the lower to put value inside the array of possible indexes.
                    * // Multiply to get a index that would indicate where a value would be is all data were distributed evenly.
                    (value - array[lower]) // Get a remainder value, to level off with remaining possibilities of remaining values.
                    /
                    (array[upper] - array[lower]); // Get a value that represents total difference of distributed values.

            if(array[probe].equals(value))
                return  probe;

            if(array[probe] < value)
                lower = probe + 1;
            else
                upper = probe - 1;


        }


        return -1;
    }

}
