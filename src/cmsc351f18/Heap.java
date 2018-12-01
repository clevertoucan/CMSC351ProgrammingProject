package cmsc351f18;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Heap {
    Integer[] heap;
    int size;
    public static int comparisons = 0;
    public Heap(int capacity){
        size = 0;
        heap = new Integer[capacity+3];
    }

    protected void refactor(){
        Integer[] temp = new Integer[heap.length * 2];
        for(int i = 0; i < heap.length - 1; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }
    int pop(){
        int root = heap[0];
        heap[0] = heap[size-1];
        heap[size() - 1] = null;
        size--;
        heapify(0);
        return  root;
    }

    Integer peek(){
        return heap[0];
    }

    int size(){
        return size;
    }

    abstract void heapify(int start);

}
