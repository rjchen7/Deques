/** creates deque using doubly linked lists */
public class LinkedListDeque<T> {
    /** nested DLList class */
    private class DLList {
        private T item;
        private DLList prev;
        private DLList next;

        /** Constructor for doubly linked list */
        DLList(T value) {
            this.item = value;
            this.prev = this;
            this.next = this;
        }

        DLList(T value, DLList prev, DLList next) {
            this.item = value;
            this.prev = prev;
            this.next = next;
        }

        public void addFirst(T value) {
            DLList currentNext = this.next;
            this.next = new DLList(value, this, currentNext);
            currentNext.prev = this.next;
        }

        public void addLast(T value) {
            DLList currentPrev = this.prev;
            this.prev = new DLList(value, currentPrev, this);
            currentPrev.next = this.prev;
        }

        public T removeFirst() {
            T poppedItem = this.next.get();
            this.next.next.prev = this;
            this.next = this.next.next;
            return poppedItem;
        }

        public T removeLast() {
            T poppedItem = this.prev.get();
            this.prev.prev.next = this;
            this.prev = this.prev.prev;
            return poppedItem;
        }

        public T get() {
            return this.item;
        }
    }

    private DLList sentinal;
    private int size;

    /** constructor */
    public LinkedListDeque() {
        this.sentinal = new DLList(null);
        this.size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        this.sentinal.addFirst(item);
        this.size++;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        this.sentinal.addLast(item);
        this.size++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return this.size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
        Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        DLList ptr = sentinal.next;
        while (ptr != sentinal) {
            System.out.print(ptr.item.toString() + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque.
        If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        return this.sentinal.removeFirst();
    }

    /** Removes and returns the item at the back of the deque.
        If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        return this.sentinal.removeLast();
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        If no such item exists, returns null.
        Must not alter the deque!
     */
    public T get(int index) {
        DLList ptr = sentinal.next;
        while (ptr != sentinal && index > 0) {
            ptr = ptr.next;
            index--;
        }

        return index == 0 ? ptr.get() : null;
    }

    /** helper function for the public getRecursive method */
    private T getRecursive(int index, DLList ptr) {
        if (index == 0) {
            return ptr.get();
        }
        return getRecursive(index - 1, ptr.next);
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        return this.getRecursive(index, this.sentinal.next);
    }
}
