package utilities;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> preorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
