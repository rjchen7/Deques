public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    /** Returns true if deque is empty, false otherwise. */
    default boolean isEmpty() {
        return this.size() == 0;
    }
}
