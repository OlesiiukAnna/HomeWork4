package org.anna.task_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntList list = new IntLinkedList();

        list.add(99);
        list.add(12);
        list.add(764);
        list.add(5);
        list.add(10);
        list.add(456);

        System.out.println("List:");
        System.out.println("Should add new element: " + list.add(35));
        System.out.println(list + "\n");

        System.out.println("List get(index: 4): " + list.get(4) + "\n");

        System.out.println("List IsEmpty(): " + list.isEmpty() + "\n");

        list.add(0, 100);
        System.out.println("Added new element by index (index: 0, element: 100): ");
        System.out.println(list);
        list.add(3, 333);
        System.out.println("Added new element by index (index: 3, element: 333): ");
        System.out.println(list);
        list.add(list.size(), 1000);
        System.out.println("Added new element by index (index: list.size(), element: 1000): ");
        System.out.println(list + "\n");

        System.out.println("List remove(index: 0): " + list.remove(0));
        System.out.println(list);
        System.out.println("List remove(index: 3): " + list.remove(3));
        System.out.println(list);
        System.out.println("List remove(index: last): " + list.remove(list.size() - 1));
        System.out.println(list + "\n");

        System.out.println("List removeByValue(value: 333): " + list.removeByValue(333));
        System.out.println(list + "\n");

        System.out.println("List set(index: 3, value: 77): " + list.set(3, 77)  + "\n");

        System.out.println("List size(); " + list.size());
        System.out.println(list + "\n");

        System.out.println("Create subList(fromIndex: 1, toIndex: 6): " + list.subList(1, 6) + "\n");

        int[] array = list.toArray();
        System.out.println("List toArray(): " + Arrays.toString(array) + "\n");

        list.clear();
        System.out.println("List clear(): " + list + "\n");


        IntQueue queue = new IntLinkedList();

        queue.add(77);
        queue.add(44);
        queue.add(66);
        queue.add(11);
        queue.add(35);

        System.out.println("Queue:");
        System.out.println(queue + "\n");

        System.out.println("Queue element(): " + queue.element());
        System.out.println(queue + "\n");

        System.out.println("Queue remove(): " + queue.remove());
        System.out.println(queue + "\n");

        IntStack stack = new IntLinkedList();

        stack.push(77);
        stack.push(44);
        stack.push(66);
        stack.push(11);
        stack.push(35);

        System.out.println("Stack:");
        System.out.println(stack + "\n");

        System.out.println("Stack peek(): " + stack.peek());
        System.out.println(stack + "\n");

        System.out.println("Stack pop(): " + stack.pop());
        System.out.println(stack + "\n");
    }
}
