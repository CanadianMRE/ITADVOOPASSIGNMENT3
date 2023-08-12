package utilities;

import java.io.Serializable;

public class BSTreeNode<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BSTreeNode<E> left;
	private BSTreeNode<E> right;
	private E element;
	
	public BSTreeNode(E element) {
		this.element = element;
	}

	public BSTreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	public BSTreeNode<E> getRight() {
		return right;
	}

	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}

	public E getElement() {
		return element;
	}

}
