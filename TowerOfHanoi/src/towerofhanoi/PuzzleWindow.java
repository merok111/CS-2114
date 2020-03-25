// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Visual representation of the HanoiSolver as it solves the puzzle
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class PuzzleWindow implements Observer {
    public static final int WIDTH_FACTOR = 15;
    public static final int DISK_GAP = 2;
    public static final int DISK_HEIGHT = 4;
    private static final int TOWER_WIDTH = 2;
    private static final int TOWER_HEIGHT = 100;
    private static final Color COLOR = Color.black;

    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;


    /**
     * Method to be run when the solve button is pressed
     * 
     * @param button
     *            Button pressed
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Slow down the Thread to make the visual display smoother
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {

        }
    }


    /**
     * Update the visual when a Disk is moved
     * 
     * @param position
     *            Position of the Tower that the Disk was moved to
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            case RIGHT:
                currentPole = right;
                break;
            default:
                currentPole = left;
                break;
        }
        int y = currentPole.getY() + TOWER_HEIGHT - (game.getTower(position)
            .size() * (DISK_HEIGHT + DISK_GAP)) - DISK_GAP;
        int x = currentPole.getX() - (currentDisk.getWidth() - TOWER_WIDTH) / 2;
        currentDisk.moveTo(x, y);
    }


    /**
     * Create the visual of the Hanoi Puzzle initializing the Towers and Buttons
     * 
     * @param solver
     *            Hanoi puzzle solver
     */
    public PuzzleWindow(HanoiSolver solver) {
        this.game = solver;
        this.game.addObserver(this);
        this.window = new Window("Tower of Hanoi");

        int x = this.window.getGraphPanelWidth();
        int y = this.window.getGraphPanelHeight();

        this.left = new Shape(x / 4, y / 2 - TOWER_HEIGHT / 2, TOWER_WIDTH,
            TOWER_HEIGHT, COLOR);
        this.middle = new Shape(x / 2, y / 2 - TOWER_HEIGHT / 2, TOWER_WIDTH,
            TOWER_HEIGHT, COLOR);
        this.right = new Shape(x / 4 * 3, y / 2 - TOWER_HEIGHT / 2, TOWER_WIDTH,
            TOWER_HEIGHT, COLOR);

        for (int i = this.game.disks(); i > 0; i--) {
            Disk disk = new Disk(i * WIDTH_FACTOR);
            this.game.getTower(Position.RIGHT).push(disk);
            this.window.addShape(disk);
            moveDisk(Position.RIGHT);
        }

        window.addShape(this.left);
        window.addShape(this.middle);
        window.addShape(this.right);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * Method that is run when an update is called by the observed class
     * 
     * @param o
     *            Observed class
     * @param arg
     *            Object that hopefully is a Position
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position newPos = (Position)arg;
            moveDisk(newPos);
            sleep();
        }
    }
}
