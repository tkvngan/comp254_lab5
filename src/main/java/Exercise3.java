import week9examples.HeapPriorityQueue;

/**
 * Exercise 3 is a class that extends HeapPriorityQueue and overrides the
 * upheap method. The upheap method is overridden to use recursion instead
 * of a while loop.
 *
 * @param <K>
 * @param <V>
 */
public class Exercise3<K, V> extends HeapPriorityQueue<K, V> {

    /**
     * A recursive implementation of the upheap method.
     *
     * @param j the index of the entry to up-heap
     */
    @Override
    protected void upheap(int j) {
        if (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                return; // heap property verified
            }
            swap(j, p);
            upheap(p);
        }
    }
}
