/**
 * An abstarct class for the decorators
 */

public abstract class FileSystemElementDecorator implements FileSystemElement{

    private FileSystemElement element;

    /**
     * Creates a DocumentDecorator with given component
     * @param element 
     */
    public FileSystemElementDecorator(FileSystemElement element) {

        this.element = element;
    }

    /**
     * Creates a string which contains the info
     * @return a string which contains the info
     */
    public String getInfo() {

        return element.getInfo();
    }

   


    
}
