package utilities;

import java.io.Serializable;

/**
 * Represents a node in a Binary Search Tree (BST).
 *
 * @param <E> The type of element stored in the node.
 */
public class BSTreeNode<E> implements Serializable {
    /**
     * The serialization version UID for object persistence.
     */
    private static final long serialVersionUID = 1L;

    private BSTreeNode<E> left;   // Reference to the left child node
    private BSTreeNode<E> right;  // Reference to the right child node
    private E element;            // The element stored in the node

    /**
     * Creates a new instance of a BSTreeNode with the given element.
     *
     * @param element The element to be stored in the node.
     */
    public BSTreeNode(E element) {
        this.element = element;
    }

    /**
     * Gets the left child node of this node.
     *
     * @return The left child node.
     */
    public BSTreeNode<E> getLeft() {
        return left;
    }

    /**
     * Sets the left child node of this node.
     *
     * @param left The left child node to be set.
     */
    public void setLeft(BSTreeNode<E> left) {
        this.left = left;
    }

    /**
     * Gets the right child node of this node.
     *
     * @return The right child node.
     */
    public BSTreeNode<E> getRight() {
        return right;
    }

    /**
     * Sets the right child node of this node.
     *
     * @param right The right child node to be set.
     */
    public void setRight(BSTreeNode<E> right) {
        this.right = right;
    }

    /**
     * Gets the element stored in this node.
     *
     * @return The element stored in the node.
     */
    public E getElement() {
        return element;
    }
}
