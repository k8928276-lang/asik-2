public class MyQueue {
    private MyLinkedList<Object> list = new MyLinkedList<>();

    public Object peek() {
        return list.getLast();
    }

    public void pop() {
        list.removeFirst();
    }

    public void push(Object o) {
        list.addLast(o);
    }
}
