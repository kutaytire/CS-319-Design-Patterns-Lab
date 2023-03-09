/**
 * Interface for the memory representation of the directory
 */

public interface MemoryStrategy {
    
    /**
     * Creates the memory representation
     * @param info info of the directory
     * @return the memory representation of the directory
     */
    public String representMemory(String info);
}
