package dev.westernpine.algorithms.sort;

public class InsertionSort {

    // Compares elements to the left of the current index. And shifts elements right if they're larger.
    // Okay for smaller data sets,
    // BAD for med-large data sets.
    // O(n^2)

    // Preferrable to bubble sort and selection sort, as it uses less steps, and less memory.

    public static void main() {
        Integer[] array = {5,7,4,9,3,6,1,8,2,0};
        sort(array);
        assert array[0] < array[array.length-1];
    }

    public static <T extends Comparable<T>> void sort(T[] array) {

        A: for(int i = 1; i < array.length; i++) {
            T temp = array[i];
            int j = i - 1;
            while(j >= 0 && temp.compareTo(array[j]) < 0) {
                array[j+1] = array[j];
                j -= 1;
            }
            array[j+1] = temp;
        }

    }
}
