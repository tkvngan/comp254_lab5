import org.junit.jupiter.api.Test;
import week8examples.Position;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise1Test is a class that tests the methods in Exercise1.
 */
public class Exercise1Test {

    /**
     * Create a binary tree for testing.
     */
    final Exercise1<Integer> tree = new Exercise1<>();
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
     * Test the preorder traversal of the binary tree.
     */
    @Test
    public void testPreorderTraverse() {
        assertEquals(n1, tree.preorderNext(n0));
        assertEquals(n11, tree.preorderNext(n1));
        assertEquals(n111, tree.preorderNext(n11));
        assertEquals(n12, tree.preorderNext(n111));
        assertEquals(n2, tree.preorderNext(n12));
        assertEquals(n21, tree.preorderNext(n2));
        assertEquals(n212, tree.preorderNext(n21));
        assertEquals(n22, tree.preorderNext(n212));
        assertEquals(n221, tree.preorderNext(n22));
        assertEquals(n222, tree.preorderNext(n221));
        assertNull(tree.preorderNext(n222));
    }

    /**
     * Test the inorder traversal of the binary tree.
     */
    @Test
    public void testInorderTraverse() {
        assertEquals(n111, tree.inorderFirst(n0));
        assertEquals(n11, tree.inorderNext(n111));
        assertEquals(n1, tree.inorderNext(n11));
        assertEquals(n12, tree.inorderNext(n1));
        assertEquals(n0, tree.inorderNext(n12));
        assertEquals(n21, tree.inorderNext(n0));
        assertEquals(n212, tree.inorderNext(n21));
        assertEquals(n2, tree.inorderNext(n212));
        assertEquals(n221, tree.inorderNext(n2));
        assertEquals(n22, tree.inorderNext(n221));
        assertEquals(n222, tree.inorderNext(n22));
        assertNull(tree.inorderNext(n222));
    }

    /**
     * Test the postorder traversal of the binary tree.
     */
    @Test
    public void testPostorderTraverse() {
        assertEquals(n111, tree.postorderFirst(n0));
        assertEquals(n11, tree.postorderNext(n111));
        assertEquals(n12, tree.postorderNext(n11));
        assertEquals(n1, tree.postorderNext(n12));
        assertEquals(n212, tree.postorderNext(n1));
        assertEquals(n21, tree.postorderNext(n212));
        assertEquals(n221, tree.postorderNext(n21));
        assertEquals(n222, tree.postorderNext(n221));
        assertEquals(n22, tree.postorderNext(n222));
        assertEquals(n2, tree.postorderNext(n22));
        assertEquals(n0, tree.postorderNext(n2));
        assertNull(tree.postorderNext(n0));
    }
}
