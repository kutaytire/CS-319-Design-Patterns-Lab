/**
 * Concrete class that overrides the getInfo() method of the abstract DocumentDecorator class and adds indentation in getInfo().
 */

import java.util.ArrayList;

public class Indentation extends FileSystemElementDecorator {

    /**
     * Creates a Indentation object by taking a document
     * @param element
     */
    public Indentation(FileSystemElement element) {

        super(element);
    }

    /**
     * Adds indentation to the string representation.
     * @return string representation of info with added indentation
     */
    @Override
    public String getInfo() {

        int indent = 0;    
        ArrayList<String> items = getLines(super.getInfo());
        
        String newRes = "";
        
        for(int i = 0; i < items.size(); i++) {

            String line = items.get(i);
            String newLine = "";
            

            if(line.contains("-") && !line.contains("DIRECTORY") ) {

                newLine = addIndentation(indent, line);
                indent++;
                
            }

            else if (line.contains("DIRECTORY")) {

                indent--;
                newLine = addIndentation(indent, line);
            }

            else{
                newLine = addIndentation(indent, line);
            }

            newRes = newRes + newLine + "\n";

        }

        return newRes;

            
    }

    /**
     * Adds indentation to a single line by number of tabs
     * @param number, line
     * @return indented single line
     */

    public String addIndentation(int number, String line) {

        String indentation = "";
        for (int k = 0; k < number; k++) {

            indentation = "\t" + indentation;
            
        }
        return indentation + line;
        
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
