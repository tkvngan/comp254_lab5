import org.junit.jupiter.api.Test;
import week8examples.Position;

/**
 * Exercise2Test is a class that tests the methods in Exercise2.
 */
public class Exercise2Test {

    /**
     * Create a binary tree for testing.
     */
    final Exercise2<Integer> tree = new Exercise2<>();
    final Position<Integer> n0 = tree.addRoot(0);
    final Position<Integer> n1 = tree.addLeft(n0, 1);
    final Position<Integer> n2 = tree.addRight(n0, 2);
    final Position<Integer> n11 = tree.addLeft(n1, 11);
    final Position<Integer> n12 = tree.addRight(n1, 12);
    final Position<Integer> n21 = tree.addLeft(n2, 21);
    final Position<Integer> n22 = tree.addRight(n2, 22);
    final Position<Integer> n111 = tree.addLeft(n11, 111);
    final Position<Integer> n212 = tree.addRight(n21, 212);
    final Position<Integer> n221 = tree.addLeft(n22, 221);
    final Position<Integer> n222 = tree.addRight(n22, 222);
/*
                           0
                   +-----------------+
                   |                 |
                   1                 2
               +-------+         +--------+
               |       |         |        |
              11       12       21        22
            +--+                +-+     +---+
            |                     |     |   |
           111                   212   221 222
    */

    /**
     * Test the postorder traversal of the binary tree and calculate
     * the height of each node.
     */
    @Test
    public void testPostorderHeight() {
        tree.postorderHeight(n0);
    }
}
