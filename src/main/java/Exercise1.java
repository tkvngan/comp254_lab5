import week8examples.LinkedBinaryTree;
import week8examples.Position;

/**
 * Exercise1 is a class that extends LinkedBinaryTree and provides methods
 * to traverse a binary tree in preorder, inorder, and postorder.
 *
 * Worst-case time complexity for all three traversal methods is O(n). This is
 * because each node in the tree is visited once.
 * In fact, the average and best-case time complexity for all three traversal
 * methods is also O(n).
 *
 * @param <E>
 */
public class Exercise1<E> extends LinkedBinaryTree<E> {

    /**
     * Return the next position in a preorder traversal of a binary tree
     * starting at the specified position p.
     *
     * @param p the position to start the traversal
     * @return the next position in the traversal
     */
    public Position<E> preorderNext(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> leftChild = node.getLeft();
        Node<E> rightChild = node.getRight();
        if (leftChild != null) {
            // I have a left child, so the next node in the traversal is this
            // left child.
            return leftChild;
        } else if (rightChild != null) {
            // I don't have a left child, but I have a right child, so the next
            // node in the traversal is this right child.
            return rightChild;
        } else {
            // I don't have any children, so I need to backtrack upward
            // to find the next node in the traversal.
            return preorderUp(node);
        }
    }

    /**
     * Return the next position in a preorder traversal of a binary tree by
     * backtracking upward from the specified node.
     * @param node the node to backtrack from
     * @return the next position in the traversal
     */
    private Position<E> preorderUp(Node<E> node) {
        Node<E> parent = node.getParent();
        if (parent == null) {
            // I have no parent, so I am the root, and there is no next node.
            return null;
        }
        // Find out who I am in relation to my parent
        Node<E> leftChild = parent.getLeft();
        Node<E> rightChild = parent.getRight();
        if (node == leftChild && rightChild != null) {
            // I am the left child of my parent, and my parent has a right child,
            // so the next node in the traversal is the right child.
            return rightChild;
        } else {
            // I am the right child of my parent, or my parent does not have a
            // right child, so backtrack upward to find the next node in the
            return preorderUp(parent);
        }
    }

    /**
     * Returns the position of the first node of a subtree for an inorder
     * traversal of the subtree.
     * @param subtree the position of the subtree where the first position is
     *                to be found
     * @return the first position in the traversal
     */
    public Position<E> inorderFirst(Position<E> subtree) {
        Node<E> node = validate(subtree);
        Node<E> leftChild = node.getLeft();
        if (leftChild == null) {
            // I don't have a left child, so I am the first node in the
            // traversal of the subtree.
            return node;
        } else {
            // I have a left child, so recursively find the first node in the
            // subtree rooted at my left child.
            return inorderFirst(leftChild);
        }
    }

    /**
     * Return the next position in an inorder traversal of a binary tree starting
     * @param p the position to start the traversal
     * @return the next position in the traversal
     */
    public Position<E> inorderNext(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> rightChild = node.getRight();
        if (rightChild == null) {
            // I don't have a right child, so I am the last node in the subtree
            // rooted at my parent. Backtrack upward to find the next node in
            // the traversal.
            return inorderUp(node);
        } else {
            // I have a right child, so the next node in the traversal is the
            // first node in the subtree rooted at my right child.
            return inorderFirst(rightChild);
        }
    }

    /**
     * Return the next position in an inorder traversal of a binary tree by
     * backtracking upward from the specified node.
     * @param node the node to backtrack from
     * @return the next position in the traversal
     */
    private Position<E> inorderUp(Node<E> node) {
        Node<E> parent = node.getParent();
        if (node.getParent() == null) {
            // I have no parent, so I am the root, and there is no next node.
            return null;
        }
        // Find out who I am in relation to my parent
        Node<E> leftChild = parent.getLeft();
        Node<E> rightChild = parent.getRight();
        if (node == leftChild) {
            // I am the left child of my parent, so my parent is the next node.
            return parent;
        } else if (node == rightChild) {
            // I am the right child of my parent, so backtrack upward to find
            // the next node in the traversal.
            return inorderUp(parent);
        } else {
            // I am neither the left child nor the right child of my parent;
            // this is an error, an internal inconsistency in the tree.
            throw new IllegalArgumentException("p is not a child of its parent");
        }
    }

    /**
     * Return the position of the first node of a subtree for postorder
     * traversal of the subtree.
     * @param subtree the position of the subtree where the first position is
     *                to be found
     * @return the first position in the traversal
     */
    public Position<E> postorderFirst(Position<E> subtree) {
        Node<E> node = validate(subtree);
        Node<E> leftChild = node.getLeft();
        if (leftChild != null) {
            return isLeaf(leftChild) ? leftChild : postorderFirst(leftChild);
        }
        Node<E> rightChild = node.getRight();
        if (rightChild != null) {
            return isLeaf(rightChild) ? rightChild : postorderFirst(rightChild);
        }
        return node;
    }

    /**
     * Return the next position in a postorder traversal of a binary tree for
     * the given position.
     * @param p the position to start the traversal
     * @return the next position in the traversal
     */
    public Position<E> postorderNext(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> parent = node.getParent();
        if (parent == null) {
            // I have no parent, so I am the root, and there is no next node.
            return null;
        }
        // Find out who I am in relation to my parent
        Node<E> leftChild = parent.getLeft();
        Node<E> rightChild = parent.getRight();
        if (node == leftChild) {
            // I am the left child of my parent
            if (rightChild != null) {
                // If I am the left child of my parent and my parent has a
                // right child, then the subtree rooted at the right child
                // has not been traversed yet, so traverse it next.
                return postorderFirst(rightChild);
            } else {
                // My parent does not have a right child, and since I am
                // a left child, my parent is the next node.
                return parent;
            }
        } else if (node == rightChild) {
            // I am the right child; so the parent is the next node
            return parent;
        } else {
            // I am neither the left child nor the right child of my parent;
            // this is an error, an internal inconsistency in the tree.
            throw new IllegalArgumentException("p is not a child of its parent");
        }
    }

    /**
     * Return true if the specified node is a leaf node.
     * @param node the node to check
     * @return true if the node is a leaf node
     */
    private boolean isLeaf(Node<E> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

}
