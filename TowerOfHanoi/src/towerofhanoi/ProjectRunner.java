// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

/**
 * Class to start the project and visual representation
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class ProjectRunner {
    /**
     * main method to run this class and start the project
     * 
     * @param args
     *            Command Line Arguments
     */
    public static void main(String[] args) {
        int disks = 5;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disks);
        PuzzleWindow puzzle = new PuzzleWindow(solver);
    }
}
