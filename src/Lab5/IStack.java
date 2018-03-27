package Lab5;

public interface IStack<T> {
    boolean isEmpty();

    void push(T item);

    T pop();

    T peek();
}
