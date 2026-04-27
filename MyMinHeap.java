public class MyMinHeap {
    private MyArrayList<Integer> listlist = new MyArrayList<>();

    public void add(int item) {
        listlist.add(item);
        heapifyUp(listlist.size() - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && listlist.get(index) < listlist.get(parentIndex)) {
            swap(index, parentIndex);
        }
    }
    private void swap(int index1, int index2) {
        int temp = listlist.get(index1);
        listlist.set(index1, listlist.get(index2));
        listlist.set(index2, temp);
    }
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if (leftChildIndex < listlist.size() && listlist.get(leftChildIndex) < listlist.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < listlist.size() && listlist.get(rightChildIndex) < listlist.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }
    public int peek() {
        if (listlist.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return listlist.get(0);
    }

    public int size() {
        return listlist.size();
    }

    public boolean isEmpty() {
        return listlist.isEmpty();
    }
}
