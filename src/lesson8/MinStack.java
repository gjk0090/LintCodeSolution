package lesson8;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public MinStack() {
        // do initialize if necessary
    }

    public void push(int number) {
        stack.push(number);
        minStack.push(minStack.isEmpty()? number : Math.min(number, minStack.peek()));
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
