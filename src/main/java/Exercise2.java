import week8examples.LinkedBinaryTree;
import week8examples.Position;

/**
 * Exercise2 is a class that extends LinkedBinaryTree and provides a method to
 * calculate the height of each node in a binary tree using a postorder traversal.
 * @param <E>
 */
public class Exercise2<E> extends LinkedBinaryTree<E> {

    /**
     * Calculate the height of each node in a binary tree using a postorder traversal.
     * @param p the position to start the traversal
     * @return the height of the node
     */
    public int postorderHeight(Position<E> p) {
        LinkedBinaryTree.Node<E> node = validate(p);
        if (isLeaf(node)) {
            System.out.println("Element: " + node.getElement() + ", Height: 0");
            return 0;
        }
        int maxHeight = 0;
        for (Position<E> c : children(p)) {
            maxHeight = Math.max(maxHeight, postorderHeight(c));
        }
        int height = maxHeight + 1;
        System.out.println("Element: " + node.getElement() + ", Height: " + height);
        return height;
    }

    /**
     * Check if a node is a leaf.
     * @param node the node to check
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(LinkedBinaryTree.Node<E> node) {
        return node.getLeft() == null && node.getRight() == null;
    }
}
