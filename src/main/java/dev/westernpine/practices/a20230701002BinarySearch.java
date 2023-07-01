package dev.westernpine.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a20230701002BinarySearch {

    public static void main(String[] args) {
        int result = find(new Integer[] {0,1,2,3,4, 5}, 4);
        System.out.println(result);
    }

    //Time complexity: O(log n) - Since the search is being divided every time, this produces a logarithmic result.
    //Space complexity: O(1) - Since there is no recursion or additional data structures, space complexity does not grow with input length.
    public static Integer find(Integer[] values, Integer toFind) {
        /*
         * Here's the first time I need to break something down.
         * So when dealing with a binary search, I know that I will need to
         * get the middle result of my bounds, and compare.
         */

        //Initially I know I will need a "cursor" to identify my position.
        int cursor = values.length/2;

        //Since I know Arrays.copyOfRange *could* be heavy, and is partially cheating. I will be utilizing bounds.
        int lower = 0, upper = values.length-1;

        //Then start the while loop until I run out of options or find the value.
        while(lower <= upper) {

            // 0 = same, <0 = ToFind>, >0 = ToFind<
            int direction = values[cursor].compareTo(toFind);

            if(direction == 0)
                return cursor;

            //Update bounds, we only need to move one at a time.
            if(direction > 0) { // ToFind is less than the value.
                upper = cursor;
            } else { // ToFind is greater than the value.
                lower = cursor;
            }

            //Update cursor
            cursor = lower + (upper - lower) / 2;

            //try again...
        }
        return -1;
    }
}
