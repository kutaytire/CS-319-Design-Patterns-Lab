/**
 * A class for a directory in the file system
 */
import java.util.ArrayList;

public class Directory implements FileSystemElement {

    private String directoryName;
    public ArrayList<FileSystemElement> elements;
    private MemoryStrategy memoryRepresentation;

     /**
     * Creates a directory with given name and an empty documents
     * @param name name of the directory
     */
    public Directory(String name) {

        directoryName = name;
        elements = new ArrayList<FileSystemElement>();
    }

    /**
     * Adds a document to the directory.
     * @param element 
     */
    public void addElement(FileSystemElement element){

        if (element == this) {
            throw new IllegalArgumentException("Cannot add directory to itself");
        }
        elements.add(element);
    }

    /**
     * Gets the directory name.
     * @return directoryName 
     */
    public String getDirectoryName() {

        return directoryName;
    }

    /**
     * Removes a document from the directory.
     * @param element 
     */
    public void removeElement(FileSystemElement element) {

        elements.remove(element);
    }

    /**
     * Creates a string which contains the info
     * @return a string which contains the info
     */
    public String getInfo() {

        
        String res = "";

        String begin = ("- " + directoryName) + "\n";
        String end = ("- DIRECTORY END | " + directoryName);
        for(int i = 0; i < elements.size(); i++) {

           res = res + elements.get(i).getInfo() + "\n";
        }
        
        return begin + res + end;

    }

    /**
     * Adjusts the memory representation model of the directory
     * @param strategy the model of memory representation
     */
    public void adjustMemoryRepresentation(MemoryStrategy strategy){

        memoryRepresentation = strategy;
		
	}

    /**
     * Prints the memory representation of the directory
     */
    public void applyMemoryRepresentation() {

        if (this.memoryRepresentation == null) {
            throw new IllegalStateException("You have to choose the representation method first.");
        }
        System.out.println(memoryRepresentation.representMemory(getInfo()));
    }

    
    
}
