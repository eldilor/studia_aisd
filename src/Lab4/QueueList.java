package Lab4;

public class QueueList<T> implements Queue {
    private final int MAX_CAPACITY = 30;
    private Element head;
    private int size = 0;

    @Override
    public void insert(Object item) {
        if (this.size < this.MAX_CAPACITY) {
            Element newElement = new Element((T) item);
            if (this.head == null) {
                this.head = newElement;
            } else {
                Element currentElement = this.head;

                while (currentElement.getNext() != null) {
                    currentElement = currentElement.getNext();
                }

                currentElement.setNext(newElement);
            }

            this.size++;
        }
    }

    @Override
    public void remove() {
        if (this.head != null) {
            this.head = this.head.next;
            this.size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean isFull() {
        return this.size == this.MAX_CAPACITY;
    }

    private Element getElement(int index) {
        Element currentElement = this.head;

        while (index > 0 && currentElement != null) {
            index--;
            currentElement = currentElement.getNext();
        }

        return currentElement;
    }

    public T get(int index) {
        Element element = this.getElement(index);

        return element.getValue();
    }

    public int getSize() {
        return size;
    }

    private class Element {
        private T value;
        private Element next;

        public Element(T value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }
    }
}
