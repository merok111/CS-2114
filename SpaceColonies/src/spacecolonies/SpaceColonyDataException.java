// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Custom Exception to throw in this project
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class SpaceColonyDataException extends Exception {
    /**
     * create this exception with a given localized message
     * 
     * @param msg
     *            localized message to throw in exception
     */
    public SpaceColonyDataException(String msg) {
        super(msg);
    }

}
