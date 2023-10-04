package dev.westernpine.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDS {

    public static void main() {
        // FIFO
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assert queue.peek() == 0;
        assert queue.poll() == 0;
    }

}
