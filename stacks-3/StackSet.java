/**
 *
 * Set of stacks
 *
 **/

import java.util.*;

class Node {
    Node above, below;
    int value;
    Node (int value) {
        this.value = value;
        this.above = null;
        this.below = null;
    }
}


class Stack {
    private int capacity;
    private int size = 0;
    Node top, bottom;

    Stack(int capacity) {
        this.capacity = capacity;
    }

    boolean isFull() {
        return this.capacity == this.size;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    void join(Node above, Node below) {
        if (below != null)
            below.above = above;
        if (above != null)
            above.below = below;
    }

    boolean push(int v) {
        if (this.size >= this.capacity) {
            return false;
        }

        this.size++;
        Node n = new Node(v);
        if (this.size == 1)
            this.bottom = n;
        this.join(n, this.top);
        this.top = n;
        return true;
    }

    int pop() {
        Node t = this.top;
        this.top = this.top.below;
        this.size--;
        return t.value;
    }

    int removeBottom() {
        Node b = this.bottom;
        this.bottom = this.bottom.above;
        if (this.bottom != null)
            this.bottom.below = null;
        this.size--;
        return b.value;
    }
}

class SetOfStacks {
    private ArrayList<Stack> stacks;
    private int capacity;

    SetOfStacks(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<Stack>();
    }

    Stack getLastStack() {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size()-1);
    }

    void push (int value) {
        Stack last = this.getLastStack();
        if (last == null || last.isFull()) {
            stacks.add(new Stack(this.capacity));
            last = this.getLastStack();
        }
        last.push(value);
    }

    int pop() {
        Stack last = this.getLastStack();
        int v = last.pop();
        if (last.isEmpty())
            stacks.remove(stacks.size() - 1);
        return v;
    }

    boolean isEmpty() {
        Stack last = this.getLastStack();
        return last == null || last.isEmpty();
    }

    int popAt(int index) {
        return leftShift(index, true);
    }

    int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop)
            removed_item = stack.pop();
        else
            removed_item = stack.removeBottom();

        if (stack.isEmpty())
            this.stacks.remove(index);
        else if (this.stacks.size() > index + 1) {
            int v = this.leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    int count() {
        return this.stacks.size();
    }
}


public class StackSet {
    public static void main(String []args) {
        SetOfStacks set = new SetOfStacks(3);
        set.push(1);
        set.push(1);
        set.push(1);

        set.push(2);
        set.push(2);
        set.push(2);

        set.push(3);
        set.push(3);
        set.push(3);

        System.out.format("Set size: %d\n", set.count());

        System.out.println(set.pop());
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(1));
        System.out.println(set.popAt(1));

        System.out.format("Set size: %d\n", set.count());


    }
}