/**
 * Concrete class for type based memory representation 
 */

import java.util.ArrayList;

public class TypeBasedMemory implements MemoryStrategy {


     /**
     * Creates the type based memory representation of the directory
     * @param info 
     * @return type-based memory representation of the directory 
     */
    public String representMemory(String info) {

        int depth = 0;
        ArrayList<String> items = getLines(info);
        
        String memory = "{ ";
        
        for(int i = 0; i < items.size(); i++) {

            String line = items.get(i);
            String newLine = "";
            
            if( line.contains("-")&& !line.contains("DIRECTORY") ) {

                newLine = "[D" + depth + " ";
                depth++;
                
            }

            else if (line.contains("DIRECTORY")) {

                depth--;
                newLine = "EOD" + depth + "] ";
            }

            else{

               
                newLine = "(F) "; 
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
