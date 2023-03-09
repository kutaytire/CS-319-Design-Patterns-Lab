/**
 * Concrete class that overrides the getInfo() method of the abstract DocumentDecorator class and adds type indication in getInfo().
 */

import java.util.ArrayList;

public class TypeIndication extends FileSystemElementDecorator {

    /**
     * Creates a TypeIndication object by taking a document
     * @param element
     */
    public TypeIndication(FileSystemElement element) {

        super(element);
    }

    /**
     * Adds type indication to the string representation.
     * @return string representation of info with added type indication
     */
    @Override
    public String getInfo() {

        
        ArrayList<String> items = getLines(super.getInfo());
        
        String newRes = "";
        
        for(int i = 0; i < items.size(); i++) {

            String line = items.get(i);
            String newLine = "";
            


            if( line.contains("-")&& !line.contains("DIRECTORY") ) {

                newLine = "(d) " + line;

                
            }

            else if (line.contains("DIRECTORY")) {

                newLine = "(!) " + line;
            }

            else{

                newLine = "(f) " + line;
            }

            newRes = newRes + newLine + "\n";

        }

        return newRes;

            
    }

    /**
     * Takes the info as a string and returns lines by parsing it.
     * @param info
     * @return Array list of strings containing each line.
     */

    private ArrayList<String> getLines(String info) {

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
