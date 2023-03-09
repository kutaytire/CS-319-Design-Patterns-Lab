/**
 * A class for a file in the file system
 */
public class File implements FileSystemElement{

    private String fileName;
    private String extension;
    private int fileSize;

    /**
     * Creates a File with given name, extension and size
     * @param fileName name of the file
     * @param extension extension of the file
     * @param fileSize size of the file in kb
     */
    public File(String fileName, String extension, int fileSize) {

        this.fileName = fileName;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    /**
     * Creates a string which contains the info
     * @return a string which contains the info
     */
    public String getInfo() {

        String result = (fileName + "." + extension + " | File Size: " + fileSize + " kb");
        return result;
    }
    
}
