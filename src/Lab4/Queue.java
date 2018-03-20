package Lab4;

public interface Queue<T> {
    void insert(T item);

    void remove();

    boolean isEmpty();

    boolean isFull();
}