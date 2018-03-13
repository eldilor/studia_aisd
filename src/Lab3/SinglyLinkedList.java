package Lab3;

public class SinglyLinkedList<E> {
    private Element head = null;

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        Element currentElement = this.head;

        while (currentElement != null) {
            size++;
            currentElement = currentElement.getNext();
        }

        return size;
    }

    private Element getElement(int index) {
        Element currentElement = this.head;

        while (index > 0 && currentElement != null) {
            index--;
            currentElement = currentElement.getNext();
        }

        return currentElement;
    }

    public E get(int index) {
        Element element = this.getElement(index);

        return element.getValue();
    }

    public void add(E element) {
        Element newElement = new Element(element);
        if (this.head == null) {
            this.head = newElement;
        } else {
            Element currentElement = this.head;

            while (currentElement.getNext() != null) {
                currentElement = currentElement.getNext();
            }

            currentElement.setNext(newElement);
        }
    }

    public void add(int index, E element) {
        Element newElement = new Element(element);

        if (index < this.size()) {
            if (this.head == null) {
                this.head = newElement;
            } else {
                int i = 0;
                Element currentElement = this.head;
                Element previousElement = this.head;

                if (index > 0) {
                    while (currentElement.getNext() != null && i++ != index) {
                        previousElement = currentElement;
                        currentElement = currentElement.getNext();
                    }

                    Element tmpCurrentElement = currentElement;
                    currentElement = newElement;
                    currentElement.setNext(tmpCurrentElement);
                    previousElement.setNext(currentElement);
                } else {
                    Element tmpHead = this.head;
                    newElement.setNext(tmpHead);
                    this.head = newElement;
                }
            }
        } else {
            this.add(element);
        }
    }

    public void remove(int index) {
        if (this.head != null && index < this.size()) {
            Element currentElement = this.head;
            Element previousElement = this.head;
            int i = 0;

            if (index > 0) {
                while (currentElement.getNext() != null && i++ != index) {
                    previousElement = currentElement;
                    currentElement = currentElement.getNext();
                }

                previousElement.setNext(currentElement.getNext());
            } else {
                this.head = this.head.getNext();
            }
        }
    }

    public void display() {
        Element currentElement = this.head;

        if (currentElement != null) {
            while (currentElement.getNext() != null) {
                System.out.println(currentElement);
                currentElement = currentElement.getNext();
            }
            System.out.println(currentElement);
        }

    }

    private class Element {
        private E value;
        private Element next;

        public Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }
}
