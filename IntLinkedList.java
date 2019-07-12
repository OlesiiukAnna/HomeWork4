package org.anna.task_4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntLinkedList implements IntList, IntQueue, IntStack {

    private int numberOfElements = 0;
    private Node first;
    private Node last;

    @Override
    public boolean add(int element) {
        Node newNode = new Node(element);
        if (numberOfElements == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        numberOfElements++;
        return true;
    }

    @Override
    public int remove() {
        Node current = first;
        first = first.next;

        numberOfElements--;
        return current.value;
    }

    @Override
    public int element() {
        return first.value;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(element);
        if (index == 0 && isEmpty()) {
            first = newNode;
            last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        } else if (index == size()) {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        } else {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.previous = current.previous;

            current.previous.next = newNode;
            current.previous = newNode;
        }

        numberOfElements++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        numberOfElements = 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = first;
        if (index == 0) {
            first = current.next;
        } else if (index == numberOfElements - 1) {
            last = current.previous;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        numberOfElements--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        Node current = first;
        while (current.value != value) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }

        if (current == first) {
            first = current.next;
        } else if (current == last) {
            last = current.previous;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        numberOfElements--;
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            first.value = element;
        } else if (index == numberOfElements - 1) {
            last.value = element;
        } else {
            Node current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.value = element;
        }
        return true;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (toIndex < fromIndex) {
            throw new IllegalArgumentException();
        }
        if (fromIndex < 0 || toIndex > numberOfElements) {
            throw new IndexOutOfBoundsException();
        }

        IntList subList = new IntLinkedList();
        Node current = first;
        for (int i = 0; i < fromIndex; i++) {
            current = current.next;
        }
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.value);
            current = current.next;
        }

        return subList;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[numberOfElements];
        Node temp = first;
        for (int i = 0; i < numberOfElements; i++) {
            result[i] = temp.value;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public void push(int value) {
        Node newNode = new Node(value);

        if (numberOfElements == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        numberOfElements++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = last.value;
        last = last.previous;

        numberOfElements--;
        return result;
    }

    @Override
    public int peek() {
        return last.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private static class Node {
        int value;
        Node previous;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
