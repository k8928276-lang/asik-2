import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) increaseCapacity();
        elements[size++] = item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) elements[index];
    }

    @Override public int size() { return size; }
    @Override public boolean isEmpty() { return size == 0; }
    @Override public void clear() { size = 0; }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) elements[i] = elements[i + 1];
        size--;
    }

    // Заглушки для компиляции
    @Override public void set(int index, T item) { elements[index] = item; }
    @Override public void add(int index, T item) { add(item); }
    @Override public void addFirst(T item) { add(item); }
    @Override public void addLast(T item) { add(item); }
    @Override public void removeFirst() { remove(0); }
    @Override public void removeLast() { if (size > 0) size--; }
    @Override public T getFirst() { return get(0); }
    @Override public T getLast() { return get(size - 1); }
    @Override public int lastIndexOf(Object object) { return -1; }
    @Override public boolean exists(Object object) { return indexOf(object) != -1; }
    @Override public void sort() {}
    @Override public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(elements, 0, arr, 0, size);
        return arr;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0;
            public boolean hasNext() { return cursor < size; }
            public T next() { return (T) elements[cursor++]; }
        };
    }
}