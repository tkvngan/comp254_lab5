import org.junit.jupiter.api.Test;
import week9examples.HeapPriorityQueue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise3Test is a class that tests the upheap method in Exercise3.
 */
public class Exercise3Test {

    /**
     * Test the upheap method in Exercise3.
     */
    @Test
    public void testUpheap() {
        HeapPriorityQueue<Integer, String> originalHeapPriorityQueue = new HeapPriorityQueue<>();
        Exercise3<Integer, String> modifiedHeapPriorityQueue = new Exercise3<>();

        int[] keys = {5, 1, 3, 4, 2};

        for (int key : keys) {
            originalHeapPriorityQueue.insert(key, "Value " + key);
            modifiedHeapPriorityQueue.insert(key, "Value " + key);
        }

        // Check that the minimum element is the same in both priority queues
        assertEquals(
            originalHeapPriorityQueue.min().getKey(),
            modifiedHeapPriorityQueue.min().getKey());
    }
}
