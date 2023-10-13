package dev.westernpine;

import dev.westernpine.algorithms.*;
import dev.westernpine.algorithms.misc.Recursion;
import dev.westernpine.algorithms.search.*;
import dev.westernpine.algorithms.sort.*;
import dev.westernpine.datastructures.*;
import dev.westernpine.datastructures.Custom.Tree.BST;

import java.util.Arrays;

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
        InterpolationSearch.main(); // O(log(log(n))) - O(n)

        BubbleSort.main(); // O(n^2) - ok
        SelectionSort.main(); // O(n^2) - good
        InsertionSort.main(); // O(n^2) - better
        // TODO: Dual-Pivot Quicksort // - BEST

        Recursion.main();

        MergeSort.main(); // Time = O(n log(n)) Space = O(n)
        QuickSort.main(); // Time:  O(n log(n)) Space: O(log(n)) (for recursion memory consumption)

        // TIME FOR THE FUN STUFF! :D
        HashTableDS.main(); // O(1)
        GraphDS.main();

        DepthFirstSearch.main(); // Traverses a graph one direction at a time, utilizes recursion, and is better when destination is far from the start.
        BreadthFirstSearch.main(); // Traverses a graph by level, utilizes loops, and is better for closer destinations.

        BST.main();


        System.out.println("Learning Complete.");
        // Small side note... I feel like this is such a great thing to print out after all of this! :D
    }

}
