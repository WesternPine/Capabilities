package dev.westernpine;

import dev.westernpine.algorithms.BigONotation;
import dev.westernpine.algorithms.BinarySearch;
import dev.westernpine.algorithms.LinearSearch;
import dev.westernpine.datastructures.*;

public class Main {

    public static void main(String[] args) throws Exception {
        /*
         * I've been programming for many years, 9-10 years at the time of writing this.
         * However, I feel that I've always been lacking in 3 departments:
         *
         * - Separation of Concerns
         * - DataStructures & Algorithms (& Big O notation)
         * - Technical Terminology
         *
         * The purpose of this project in particular is to show my progression and understanding.
         * Tutorial followed: https://www.youtube.com/watch?v=CBYHwZcbD-s
         */

        // Some List/Array based Data Structures.
        StackDS.main();
        QueueDS.main();
        PriorityQueueDS.main();
        LinkedListDS.main();
        DynamicArrayDS.main();

        BigONotation.main();

        LinearSearch.main(); // O(n)
        BinarySearch.main(); // O(log n)


        System.out.println("Learning Complete.");
        // Small side note... I feel like this is such a great thing to print out after all of this! :D
    }

}
