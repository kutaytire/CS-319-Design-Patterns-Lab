public class Main {

    public static void main(String[] args) {

        // Part 1
        System.out.println("----------- PART 1-----------");

        // Prints the info of the video file.
        System.out.println("Example 1");
        File videoFile = new File("video","mp4", 200);
        System.out.println(videoFile.getInfo());

        System.out.println();

        // Prints the info of the myDocuments directory.
        System.out.println("Example 2");
        Directory myDocs = new Directory("MyDocuments");
        System.out.println(myDocs.getInfo());

        System.out.println();

        // Adds a file to a directory and prints the contents.
        System.out.println("Example 3");
        Directory favMusic = new Directory("FavoriteMusic");
        File musicFile = new File("MetallicaTheUnforgiven", "mp3", 100);
        favMusic.addElement(musicFile);
        System.out.println(favMusic.getInfo());

        System.out.println();

        // Creates the case in Example 4 by adding directories in a directory.
        System.out.println("Example 4");
        Directory bilkentDir = new Directory("BilkentStuff");
        File internshipReport = new File("InternshipReport", "pdf", 10);
        File setup = new File("setup", "exe", 5);
        File toDoList = new File("ToDoList", "docx", 15);
        bilkentDir.addElement(internshipReport);
        bilkentDir.addElement(setup);
        bilkentDir.addElement(toDoList);
        bilkentDir.addElement(favMusic);
        System.out.println(bilkentDir.getInfo());

        System.out.println();

        // Creates a big directory which is the case in Example 5 and prints the contents.
        System.out.println("Example 5");
        Directory myPC = new Directory("MyPC");
        myPC.addElement(myDocs);
        myPC.addElement(bilkentDir);
        System.out.println(myPC.getInfo());

        System.out.println();

        // Part 2
        System.out.println("----------- PART 2-----------");

        // Indents the info the myPC directory by using Indentation class.
        System.out.println("Example 6");
        Indentation indent1 = new Indentation(myPC);
        System.out.println(indent1.getInfo());

        System.out.println();

        // Adds type indication to the info of myPC directory by using TypeIndication class.
        System.out.println("Example 7");
        TypeIndication type1 = new TypeIndication(myPC);
        System.out.println(type1.getInfo());

        System.out.println();

        // Combines both classes
        System.out.println("Example 8 and Another Combination");
        TypeIndication mixed1 = new TypeIndication(indent1);
        Indentation mixed2 = new Indentation(type1);
        System.out.println(mixed1.getInfo());
        System.out.println();
        System.out.println(mixed2.getInfo());

        System.out.println();

        // Part 3
        System.out.println("----------- PART 3 -----------");

        // Prints size-based memory representation
        System.out.println("Example 9");
        myPC.adjustMemoryRepresentation(new SizeBasedMemory());
        myPC.applyMemoryRepresentation();

        System.out.println();

        // Prints type-based memory representation
        System.out.println("Example 10");
        myPC.adjustMemoryRepresentation(new TypeBasedMemory());
        myPC.applyMemoryRepresentation();

        



    }
    
}
