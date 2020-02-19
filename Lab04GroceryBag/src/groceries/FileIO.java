package groceries;

import java.io.*;
import java.util.Scanner;

/**
 * Practice reading and writing to a file.
 * 
 * @author Megan Rigsbee (mrigsbee0
 * @version 2015.03.24
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.12
 */
public class FileIO {
    private static String fileName = "grocerylist.txt";


    /**
     * Reads groceries from a file and adds them to a GroceryBag object,
     * the writes the groceries back to a file using GroceryBag's
     * toString method.
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            GroceryBag bag = new GroceryBag();
            while (scanner.hasNext()) {
                bag.add(scanner.next());
            }
            scanner.close();

            PrintWriter out = new PrintWriter("output.txt");
            out.print(bag.toString());
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file ");
            System.out.println(e.getMessage());
        }
    }
}
