package Lab5;

public class Stack<T> implements IStack {
    private Element top;

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void push(Object item) {
        Element newElement = new Element((T) item);
        newElement.setPrev(this.top);
        this.top = newElement;
    }

    @Override
    public T pop() {
        T value = this.top.getValue();
        this.top = this.top.getPrev();

        return value;
    }

    @Override
    public T peek() {
        return this.top.getValue();
    }

    private class Element {
        private T value;
        private Element prev;

        public Element(T value) {
            this.value = value;
        }

        Element getPrev() {
            return prev;
        }

        void setPrev(Element prev) {
            this.prev = prev;
        }

        T getValue() {
            return value;
        }
    }
}