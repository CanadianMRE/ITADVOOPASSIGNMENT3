package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializeBTree {
    public static final String SERIALIZED_FILE_NAME = "res/repository.ser";
    
    /**
     * Loads a serialized binary search tree (BST) from a file.
     *
     * @return The loaded BSTree containing TreeWord objects.
     */
    public static BSTree<TreeWord> loadSerialized() {
        BSTree<TreeWord> bTree = new BSTree<TreeWord>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE_NAME));

            int size = ois.readInt();
            
            // Deserialize TreeWord objects and add them to the BSTree
            for (int i = 0; i < size; ++i) {
                bTree.add((TreeWord) ois.readObject());
            }
            System.out.println("Read " + size + " objects from serialized file.");
            
            ois.close();
        } catch(Exception e) {
            // Ignore exceptions and proceed, as file may not exist or is empty
        }

        return bTree;
    }
    
    /**
     * Serializes a binary search tree (BST) containing TreeWord objects to a file.
     *
     * @param bTree The BSTree to be serialized.
     */
    public static void serializeBTree(BSTree<TreeWord> bTree) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME));
            
            Iterator<TreeWord> iter = bTree.inorderIterator();
            
            // Serialize the number of TreeWord objects in the BSTree
            oos.writeInt(bTree.size());
            
            // Serialize each TreeWord object in the BSTree
            while (iter.hasNext()) {
                TreeWord next = iter.next();

                oos.writeObject(next);
            }
            
            oos.close();
            System.out.println("Serialized " + bTree.size() + " objects to file.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

