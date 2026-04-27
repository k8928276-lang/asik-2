import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private static class MyNode<T> {
        T element;
        MyNode<T> next;
        MyNode<T> prev;
        MyNode(T element) { this.element = element; }
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; newNode.prev = tail; tail = newNode; }
        size++;
    }

    @Override public void add(T item) { addLast(item); }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.element;
    }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }
    @Override public void clear() { head = tail = null; size = 0; }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    // Заглушки
    @Override public void set(int index, T item) {}
    @Override public void add(int index, T item) {}
    @Override public void addFirst(T item) {}
    @Override public void remove(int index) {}
    @Override public void removeFirst() { if (head != null) { head = head.next; size--; } }
    @Override public void removeLast() { if (tail != null) { tail = tail.prev; size--; } }
    @Override public T getFirst() { return head != null ? head.element : null; }
    @Override public T getLast() { return tail != null ? tail.element : null; }
    @Override public int lastIndexOf(Object object) { return -1; }
    @Override public boolean exists(Object object) { return indexOf(object) != -1; }
    @Override public void sort() {}
    @Override public Object[] toArray() { return new Object[0]; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> current = head;
            public boolean hasNext() { return current != null; }
            public T next() { T el = current.element; current = current.next; return el; }
        };
    }
}