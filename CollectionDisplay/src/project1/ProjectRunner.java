// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package project1;

/**
 * Run the project to display the Bag
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020-02-05
 *
 */
public class ProjectRunner {

    /**
     * Run the Project
     * 
     * @param args
     *            Command Line arguments
     */
    public static void main(String... args) {
        DisplayCollection disp = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(disp.getItemBag());

    }
}
