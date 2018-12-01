package cmsc351f18;

import java.util.ArrayList;

public class MaxHeap extends Heap {

    public MaxHeap(int capacity) {
        super(capacity);
    }

    void add(int value){
        if(size == heap.length){
            refactor();
        }
        heap[size] = value;
        int x = size;
        while(heap[x/2] < value){
            heap[x] = heap[x/2];
            heap[x/2] = value;
            x = x/2;
            comparisons++;
        }
        size++;
    }

    void heapify(int start){
        Integer root = start < heap.length ? heap[start] : null,
                left = start * 2 + 1 < heap.length ? heap[start * 2 + 1] : null,
                right = start * 2 + 2 < heap.length ? heap[start * 2 + 2]: null;
        if(root == null){
            return;
        }
        if(left != null) {
            if (right == null || left > right) {
                comparisons++;
                if (left > root) {
                    comparisons++;
                    heap[start] = left;
                    heap[start * 2 + 1] = root;
                    heapify(start * 2 + 1);
                }
            } else {
                if (right > root) {
                    comparisons++;
                    heap[start] = right;
                    heap[start * 2 + 2] = root;
                    heapify(start * 2 + 2);
                }
            }
        }
    }
}