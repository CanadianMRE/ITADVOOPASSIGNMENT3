package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeBTree {
	public static final String SERIALIZED_FILE_NAME = "res/repository.ser";
	
	public static BSTree<TreeWord> loadSerialized() {
		BSTree<TreeWord> bTree = new BSTree<TreeWord>();

		// Check for repository.ser file
		// If we have that file, load it
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE_NAME));

			int size = ois.readInt();
			
			for (int i = 0; i < size; ++i) {
				  bTree.add((TreeWord) ois.readObject());
			}
			System.out.println("Read " + size);
			
			ois.close();
		} catch(Exception e) {
			
		}

		return bTree;
	}
	
	public static void serializeBTree(BSTree<TreeWord> bTree) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME));
			
			Iterator<TreeWord> iter = bTree.inorderIterator();
			
			oos.writeInt(bTree.size());
			
			while (iter.hasNext()) {
				TreeWord next = iter.next();

				oos.writeObject(next);
			}
			
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
