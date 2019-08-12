package main.streammedian;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<? super T>> {

    private final boolean maxHeap;
    private List<T> values;

    public Heap(boolean maxHeap) {
        this.maxHeap = maxHeap;
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
        heapifyUpwards(values.size() - 1);
    }

    private void heapifyUpwards(int lastAddedIndex) {
        // check parent exists
        if (lastAddedIndex == 0) return;

        // get parent
        int parentIndex = (lastAddedIndex - 1) / 2;

        // swap if should swap
        if (shouldSwap(lastAddedIndex, parentIndex)) {
            swap(lastAddedIndex, parentIndex);
            heapifyUpwards(parentIndex);
        }
    }

    private void swap(int lastAddedIndex, int parentIndex) {
        T temp = values.get(parentIndex);
        values.set(parentIndex, values.get(lastAddedIndex));
        values.set(lastAddedIndex, temp);
    }

    private boolean shouldSwap(int childIndex, int parentIndex) {
        T parent = values.get(parentIndex);
        T child = values.get(childIndex);

        if (maxHeap) return child.compareTo(parent) > 0;
        else return child.compareTo(parent) < 0;
    }

    public T getRoot() {
        return values.get(0);
    }

    public int size() {
        return values.size();
    }

    public void removeRoot() {
        T last = values.remove(values.size() - 1);
        values.set(0, last);
        heapifyDownwards(0);
    }

    private void heapifyDownwards(int index) {
        int leftChildIndex = index * 2;
        int rightChildIndex = leftChildIndex + 1;

        if (leftChildIndex < values.size() && shouldSwap(leftChildIndex, index)) {
            swap(index, leftChildIndex);
            heapifyDownwards(leftChildIndex);
        } else if (rightChildIndex < values.size() && shouldSwap(rightChildIndex, index)) {
            swap(index, rightChildIndex);
            heapifyDownwards(rightChildIndex);
        }
    }
}
