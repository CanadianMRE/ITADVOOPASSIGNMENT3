package tests;
import utilities.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import exceptions.TreeException;


public class BSTreeTests {

    private BSTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BSTree<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        tree.add(5);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, tree.size());
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertEquals(3, tree.size());
    }

    @Test
    public void testContains() throws TreeException {
        tree.add(4);
        assertFalse(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));
    }

    @Test
    public void testAdd() {
        assertTrue(tree.add(5));
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());

        try {
            tree.add(null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test
    public void testClear() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testGetRoot() throws TreeException {
        try {
            tree.getRoot(); // Getting root of an empty tree should throw TreeException
            fail("Expected TreeException to be thrown");
        } catch (TreeException e) {
        }

        tree.add(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, (int) tree.getRoot().getElement());
    }
    @Test
    public void testSearch() throws TreeException {
        try {
            assertNull(tree.search(5)); // Searching in an empty tree should return null
        } catch (TreeException e) {
        	// Expected exception
        }
        
        tree.add(5);
        tree.add(3);
        tree.add(7);
        
        try {
            assertNull(tree.search(9)); // Searching for a non-existing element should return null
        } catch (TreeException e) {
        	// Expected exception
        	}
        try {
            assertNotNull(tree.search(5)); // Searching for an existing element should return a non-null node
            assertEquals(5, (int) tree.search(5).getElement());
            
        } catch (TreeException e) {
            fail("Unexpected TreeException: " + e.getMessage());
        }

        try {
            assertNull(tree.search(2)); // Searching for a non-existing element should return null
        } catch (TreeException e) {
        	// Expected exception
        }
    }



    @Test
    public void testHeight() {
        assertEquals(0, tree.getHeight()); // Height of an empty tree should be 0

        tree.add(5);
        assertEquals(1, tree.getHeight());

        tree.add(3);
        tree.add(7);
        assertEquals(2, tree.getHeight());
    }

    @Test
    public void testInorderIterator() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        Iterator<Integer> iterator = tree.inorderIterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        assertEquals("2 3 4 5 6 7 8 ", result);
    }

    @Test
    public void testPreorderIterator() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        Iterator<Integer> iterator = tree.preorderIterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        assertEquals("5 3 2 4 7 6 8 ", result);
    }

    @Test
    public void testPostorderIterator() {
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        Iterator<Integer> iterator = tree.postorderIterator();
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next() + " ";
        }
        assertEquals("2 4 3 6 8 7 5 ", result);
    }
    

    @Test
    public void testEmptyTreeInorderIterator() {
        Iterator<Integer> iterator = tree.inorderIterator();
        assertFalse(iterator.hasNext());
        try {
            iterator.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }

    @Test
    public void testEmptyTreePreorderIterator() {
        Iterator<Integer> iterator = tree.preorderIterator();
        assertFalse(iterator.hasNext());
        try {
            iterator.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }

    @Test
    public void testEmptyTreePostorderIterator() {
        Iterator<Integer> iterator = tree.postorderIterator();
        assertFalse(iterator.hasNext());
        try {
            iterator.next();
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            // Expected
        }
    }
}
