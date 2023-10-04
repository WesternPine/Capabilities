package dev.westernpine.datastructures;

import java.util.LinkedList;

public class LinkedListDS {

    public static void main() {

        LinkedList<Integer> linkedList = new LinkedList<>();

        // Treated as stack
        linkedList.push(0);
        linkedList.push(1);
        assert linkedList.pop() == 1;
        assert linkedList.pop() == 0;

        // Treated as a queue
        linkedList.offer(0);
        linkedList.offer(1);
        assert linkedList.poll() == 0;
        assert linkedList.poll() == 1;


        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);

        linkedList.add(3, 3);
        assert linkedList.get(3) == 3;
        linkedList.remove(4);
        assert linkedList.peekLast() == 3;
        assert linkedList.peekFirst() == 0;
    }

}
