public class MyStack extends MyArrayList {
    private MyLinkedList<Object> kakoitolist = new MyLinkedList<>();

    public int getSize() {
        return kakoitolist.size();
    }

    public Object peek() {
        return kakoitolist.getLast();
    }

    public void pop() {
        kakoitolist.removeLast();
    }

    public void push(Object o) {
        kakoitolist.addFirst(o);
    }
}
