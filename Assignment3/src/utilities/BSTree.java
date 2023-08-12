package utilities;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BSTreeNode<E> root;
	private int height = 0;
	private int size = 0;

	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		if (root == null) {
			throw new TreeException();
		}
		
		return root;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
		height = 0;
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		return search(entry) != null;
	}

	 @Override
	    public BSTreeNode<E> search(E entry) throws TreeException {
	        BSTreeNode<E> currentNode = root;
	        while (currentNode != null) {
	            if (entry.equals(currentNode.getElement())) {
	                return currentNode;
	            } else if (entry.compareTo(currentNode.getElement()) < 0) {
					currentNode = currentNode.getLeft();
				} else {
				currentNode = currentNode.getRight();
			}
		}

		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {

		if (newEntry == null) {
			throw new NullPointerException();
		}

		BSTreeNode<E> newNode = new BSTreeNode<E>(newEntry);

		// If we have no root, make this head
		if (root == null) {
			root = newNode;
			height = 1;
			size++;
			return true;
		}

		boolean foundEnd = false;
		int depth = 1;
		BSTreeNode<E> currentNode = root;
		while (!foundEnd) {
			depth++;

			if (newEntry.compareTo(currentNode.getElement()) < 0) {
				// Move left
				BSTreeNode<E> leftNode = currentNode.getLeft();

				if (leftNode == null) {
					// Add to this position
					currentNode.setLeft(newNode);
					foundEnd = true;
				} else {
					// Continue the search
					currentNode = leftNode;
				}
			} else {
				// Move right
				BSTreeNode<E> rightNode = currentNode.getRight();

				if (rightNode == null) {
					// Add to this position
					currentNode.setRight(newNode);
					foundEnd = true;
				} else {
					// Continue the search
					currentNode = rightNode;
				}
			}
		}

		if (depth > height) {
			height = depth;
		}

		size++;
		return true;
	}

	private void StashInOrder(ArrayList<E> list, BSTreeNode<E> node) {
		if (node == null) {
			return;
		}
		
		Stack<BSTreeNode<E>> stack = new Stack<>();

		BSTreeNode<E> currentNode = node;
		
		while (currentNode != null || stack.size() > 0) {
			
			while (currentNode != null) {
				
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			}
			
			currentNode = stack.pop();
			
			list.add(currentNode.getElement());
			
			currentNode = currentNode.getRight();
		}
		
//		StashInOrder(list, node.getLeft());
//		
//		list.add(node.getElement());
//		
//		StashInOrder(list, node.getRight());
	}

	private class InOrderIterator implements Iterator<E> {
		private ArrayList<E> list;
		private int currentIndex = 0;

		public InOrderIterator() {
			list = new ArrayList<E>();

			// Initialize Array
			if (root != null) {
				StashInOrder(list, root);
			}
		}

		public boolean hasNext() {
			return currentIndex <= list.size() - 1;
		}

		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			currentIndex++;

			return list.get(currentIndex - 1);
		}
	}

	@Override
	public Iterator<E> inorderIterator() {
		return new InOrderIterator();
	}

	private void StashPreOrder(ArrayList<E> list, BSTreeNode<E> node) {
		if (node == null) {
			return;
		}

		list.add(node.getElement());

		StashPreOrder(list, node.getLeft());

		StashPreOrder(list, node.getRight());
	}

	private class PreOrderIterator implements Iterator<E> {
		private ArrayList<E> list;
		private int currentIndex = 0;

		public PreOrderIterator() {
			list = new ArrayList<E>();

			// Initialize Array
			if (root != null) {
				StashPreOrder(list, root);
			}
		}

		public boolean hasNext() {
			return currentIndex <= list.size() - 1;
		}

		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			currentIndex++;

			return list.get(currentIndex - 1);
		}
	}

	@Override
	public Iterator<E> preorderIterator() {
		return new PreOrderIterator();
	}

	private void StashPostOrder(ArrayList<E> list, BSTreeNode<E> node) {
		if (node == null) {
			return;
		}

		StashPostOrder(list, node.getLeft());

		StashPostOrder(list, node.getRight());

		list.add(node.getElement());
	}

	private class PostOrderIterator implements Iterator<E> {
		private ArrayList<E> list;
		private int currentIndex = 0;

		public PostOrderIterator() {
			list = new ArrayList<E>();

			// Initialize Array
			if (root != null) {
				StashPostOrder(list, root);
			}
		}

		public boolean hasNext() {
			return currentIndex <= list.size() - 1;
		}

		public E next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			currentIndex++;

			return list.get(currentIndex - 1);
		}
	}

	@Override
	public Iterator<E> postorderIterator() {
		return new PostOrderIterator();
	}

}
