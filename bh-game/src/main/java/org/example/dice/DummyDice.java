package org.example.dice;

import java.util.LinkedList;
import java.util.Queue;

public class DummyDice implements Dice {
    private Queue circularQueue = new LinkedList<Integer>();

    public DummyDice() {
        circularQueue.add(2);
        circularQueue.add(2);
        circularQueue.add(1);
        circularQueue.add(4);
        circularQueue.add(4);
        circularQueue.add(2);
        circularQueue.add(4);
        circularQueue.add(4);
        circularQueue.add(2);
        circularQueue.add(2);
        circularQueue.add(2);
        circularQueue.add(1);
        circularQueue.add(4);
        circularQueue.add(4);
        circularQueue.add(2);
        circularQueue.add(4);
        circularQueue.add(4);
        circularQueue.add(2);
        circularQueue.add(2);
        circularQueue.add(2);
        circularQueue.add(1);
    }

    @Override
    public int getNum() {
        int value = (int) circularQueue.peek();
        circularQueue.remove();
        circularQueue.add(value);
        return value;
    }
}
