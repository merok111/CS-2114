package game;

/**
 * Run Project 2 with proper arguments
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.24.2020
 *
 */
public class ProjectRunner {
    /**
     * Useless Default Constructor
     */
    public ProjectRunner() {

    }


    /**
     * Run project method
     * 
     * @param args
     *            Command Line Arguments
     */
    public static void main(String... args) {
        if (args.length > 0) {
            new WhackAShape(args);
        }
        else {
            new WhackAShape();
        }
    }
}
