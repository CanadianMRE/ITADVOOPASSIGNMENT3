package utilities;

public class BSTreeNode<E> {
	private BSTreeNode<E> left;
	private BSTreeNode<E> right;
	private E element;
	
	public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.left = left;
		this.right = right;
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

	public void setElement(E element) {
		this.element = element;
	}

}
