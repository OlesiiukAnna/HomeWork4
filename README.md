Дз4
Написать интерфейс IntList и его реализацию IntLinkedList, который также должен реализовывать интерфейсы IntQueue и IntStack.

IntList:
    boolean add(int element);
    void add(int index, int element);
    void clear();
    int get(int index);
    boolean isEmpty();
    boolean remove(int index);
    boolean removeByValue(int value);
    boolean set(int index, int element);
    int size();
    IntList subList(int fromIndex, int toIndex);
    int[] toArray();
IntQueue:
    boolean add(int value);
    int remove(); // return first in Queue and remove it
    int element(); // return first in Queue but not remove it
IntStack:
    void push(int value);
    int pop(); // remove and get value on top of Stack
    int peek(); // get value on top of Stack
