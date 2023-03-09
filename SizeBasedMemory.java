/**
 * Concrete class for size-based memory representation 
 */
import java.util.ArrayList;

public class SizeBasedMemory implements MemoryStrategy {
    
     /**
     * Creates the size-based memory representation of the directory
     * @param info 
     * @return size-based memory representation of the directory 
     */
    public String representMemory(String info) {

        ArrayList<String> items = getLines(info);
        
        String memory = "{ ";
        
        for(int i = 0; i < items.size(); i++) {

            String line = items.get(i);
            String newLine = "";
            
            if( line.contains("-")&& !line.contains("DIRECTORY") ) {

                newLine = "[ ";

                
            }

            else if (line.contains("DIRECTORY")) {

                newLine = "] ";
            }

            else{

                int sizeBegin = line.indexOf("File Size");
                int sizeEnd = line.indexOf("kb");
                String size = line.substring(sizeBegin + 11, sizeEnd - 1);
                newLine = "(" + size + ") "; 
            }

            memory = memory + newLine;

        }

        return memory + " }";

            
    }

   /**
     * Takes the info as a string and returns lines by parsing it.
     * @param info
     * @return Array list of strings containing each line.
     */

     public ArrayList<String> getLines(String info) {

        ArrayList<String> list = new ArrayList<String>();

        int startIndex = 0;
        int endIndex = 0;
        while(startIndex < info.length()) {

            endIndex = info.indexOf("\n", startIndex);
            if(endIndex < 0) {

                endIndex = info.length();
            }
            list.add(info.substring(startIndex, endIndex));
            startIndex = endIndex + 1;

        }

        return list;

    }
}
