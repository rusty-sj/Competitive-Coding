import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Min Heap Generic Implementation
 */

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MinHeap() {
        this.heap = new ArrayList<T>();
    }

    /**
     * insert an item into the heap; respect the minheap order
     * Time Complexity: O(log n) ; n: number of items in heap
     *
     * @param item
     */
    public void insert(T item) {
        this.heap.add(item);
        bubbleUp();
    }

    /**
     * delete top item from heap
     * Time Complexity: O(log n) ; n: number of items in heap
     *
     * @return
     */
    public T delete() {
        if (this.heap.size() == 0)                  // Edge case heap empty
            throw new NoSuchElementException();
        if (this.heap.size() == 1)                  // If only one element in heap, simply remove it
            return this.heap.remove(0);

        T item = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size() - 1));   // Take last element and put it at 0th position
        bubbleDown();                               // Heapify to respect minheap properties
        return item;
    }

    /**
     * Move lower value items from bottom to top
     */
    private void bubbleUp() {
        int k = this.heap.size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;            // parent index for kth item
            T item = this.heap.get(k);      // kth item
            T parent = this.heap.get(p);    // parent item
            if (item.compareTo(parent) < 0) {   // if kth item is smaller than parent, swap the two
                // swap
                this.heap.set(k, parent);
                this.heap.set(p, item);

                k = p;                      // move up one level and compare with its parent again
            } else
                break;
        }
    }

    /**
     * Move higher value items from top to bottom
     */
    private void bubbleDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < this.heap.size()) {
            int minItemIdx = l, r = l + 1;
            if (r < this.heap.size()) {       // Right child exists
                if (this.heap.get(r).compareTo(this.heap.get(l)) < 0) {  // right item is smaller than left
                    minItemIdx++;
                }
            }
            if (this.heap.get(k).compareTo(this.heap.get(minItemIdx)) > 0) {    // If kth item is greater than minItemIdx, swap them
                // swap
                T temp = this.heap.get(k);
                this.heap.set(k, this.heap.get(minItemIdx));
                this.heap.set(minItemIdx, temp);

                k = minItemIdx;             // Update k for moving further down
                l = 2 * k + 1;
            } else
                break;
        }
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    @Override
    public String toString() {
        return this.heap.toString();
    }

    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(10);
        System.out.println(heap);

        heap.insert(4);
        System.out.println(heap);

        heap.insert(15);
        System.out.println(heap);

        heap.delete();
        System.out.println(heap);

        heap.insert(20);
        System.out.println(heap);

        heap.insert(0);
        System.out.println(heap);

        heap.insert(30);
        System.out.println(heap);

        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);

        heap.insert(2);
        System.out.println(heap);

        heap.insert(4);
        System.out.println(heap);

        heap.insert(-1);
        System.out.println(heap);

        heap.insert(-3);
        System.out.println(heap);

    }
}