
public interface Deque<T> {
    /* Linklist deque methods */
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public T removeLast();
    public T removeFirst();
    public T get(int index);
    public int front();
    public int end();
    public boolean Equal(int i, int j);
    public T getIndex(int i);

}
