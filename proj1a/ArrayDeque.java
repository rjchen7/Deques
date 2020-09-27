public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int front;
    private int rear;

    /** Constructor for ArrayDeque */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        front = -1;
        rear = -1;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (isFull()) {
            this.resize();
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front + items.length - 1) % items.length;
        }
        items[front] = item;
        size++;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isFull()) {
            this.resize();
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % items.length;
        }
        items[rear] = item;
        size++;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line.
     */
    public void printDeque() {
        int start = front;
        int end = rear;
        while (start != end) {
            System.out.print(items[start] + " ");
            start = (start + 1) % items.length;
        }
        System.out.print(items[end] + "\n");
    }

    /** Removes and returns the item at the front of the deque.
       If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size < items.length / 4 && items.length > 8) {
            this.desize();
        }
        if (isEmpty()) {
            return null;
        }

        T poppedItem = items[front];
        items[front] = null;
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % items.length;
        }
        size--;
        return poppedItem;
    }

    /** Removes and returns the item at the back of the deque.
       If no such item exists, returns null.
     */
    public T removeLast() {
        if (size < items.length / 4 && items.length > 8) {
            this.desize();
        }

        if (isEmpty()) {
            return null;
        }

        T poppedItem = items[rear];
        items[rear] = null;
        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear + items.length - 1) % items.length;
        }
        size--;
        return poppedItem;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
       If no such item exists, returns null. Must not alter the deque!
    */
    public T get(int index) {
        if (index > size) {
            return null;
        } else {
            int i = index + front;
            if (i >= items.length) {
                i -= items.length;
            }
            return items[i];
        }
    }

    /** Resizes the array items. */
    private void resize() {
        int newCap = size * 2;
        T[] temp = (T[]) new Object[newCap];

        if (rear < front) {
            System.arraycopy(items, front, temp, 0, size - front);
            System.arraycopy(items, 0, temp, size - front, rear + 1);
        } else {
            System.arraycopy(items, front, temp, 0, size);
        }
        this.items = temp;
        this.front = 0;
        this.rear = size - 1;
    }

    private void desize() {
        int newCap = (int) items.length / 2;
        T[] temp = (T[]) new Object[newCap];

        if (rear < front) {
            System.arraycopy(items, front, temp, 0, size - front);
            System.arraycopy(items, 0, temp, size - front, rear + 1);
        } else {
            System.arraycopy(items, front, temp, 0, size);
        }
        this.items = temp;
        this.front = 0;
        this.rear = size - 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    /** Returns true if array items is full capacity */
    private boolean isFull() {
        return size == items.length;
    }
}
