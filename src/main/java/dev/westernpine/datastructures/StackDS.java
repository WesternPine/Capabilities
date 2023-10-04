package dev.westernpine.datastructures;

import java.util.Stack;

public class StackDS {

    public static void main() {
        // LIFO
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert stack.peek() == 3;
        assert stack.pop() == 3;
        assert stack.search(1) == 2;
    }

}
