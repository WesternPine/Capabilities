package dev.westernpine.practices;

public class a20230701001LinearSearch {

    public static void main(String[] args) {
        int result = find(new int[] {0,1,2,3,4,5}, 4);
        System.out.println(result);
        System.out.println(7/2);
    }

    //Time complexity: O(n) - We only grow with the input length
    //Space complexity: O(1) - Since there is no recursion or additional data structures, space complexity does not grow with input length.
    public static int find(int[] values, int toFind) {
        for (int i = 0; i < values.length; i++)
            if (toFind == values[i]) {
                return i;
            }
        return -1;
    }

}
