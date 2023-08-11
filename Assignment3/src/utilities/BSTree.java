package utilities;

import java.util.ArrayList;
import java.util.Queue;
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
		if (isEmpty()) {
			throw new TreeException();
		}

		boolean foundEnd = false;
		BSTreeNode<E> currentNode = root;
		while (!foundEnd) {
			if (currentNode.getElement().equals(entry)) {
				return currentNode;
			} else if (entry.compareTo(currentNode.getElement()) > 0) {
				// Move left
				BSTreeNode<E> leftNode = currentNode.getLeft();
				
				if (leftNode == null) {
					// Add to this position
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
					foundEnd = true;
				} else {
					// Continue the search
					currentNode = rightNode;
				}
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
			
			if (newEntry.compareTo(currentNode.getElement()) > 0) {
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

	@Override
	public Iterator<E> inorderIterator() {
		ArrayList<BSTreeNode<E>> nodeList = new ArrayList<>();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> preorderIterator() {
		ArrayList<BSTreeNode<E>> nodeList = new ArrayList<>();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> postorderIterator() {
		Stack<BSTreeNode<E>> nodeStack = new Stack<>();
		// TODO Auto-generated method stub
		return null;
	}

}
