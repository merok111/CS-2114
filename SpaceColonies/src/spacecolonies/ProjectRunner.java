// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * Java Executable class to run this project
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class ProjectRunner {
    /**
     * run method
     * 
     * @param args
     *            Command Line Arguments
     * @throws ParseException
     *             if the files are not formatted correctly
     * @throws SpaceColonyDataException
     *             if the skills are not between 1 and 5
     * @throws FileNotFoundException
     *             if the file can not be found
     */
    public static void main(String... args)
        throws ParseException,
        SpaceColonyDataException,
        FileNotFoundException {
        if (args.length == 2) {
            new ColonyReader(args[0], args[1]);
        }
        else {
            new ColonyReader("inputAllAccept.txt", "planets.txt");
        }
    }
}
