package dev.westernpine.datastructures;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class PriorityQueueDS {

    public static void main() {
        // FIFO
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(0);
        priorityQueue.offer(2);

        assert priorityQueue.peek() == 0;
        assert priorityQueue.poll() == 0;
        assert  priorityQueue.peek() == 1;
    }

}
