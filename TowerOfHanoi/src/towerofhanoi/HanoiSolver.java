// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import java.util.Observable;

/**
 * HanoiSolver to solve the Hanoi puzzle
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;


    /**
     * Constructor to set up the game with a certain number of disks
     * 
     * @param numDisks
     *            number of disks in the game
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        this.left = new Tower(Position.LEFT);
        this.middle = new Tower(Position.MIDDLE);
        this.right = new Tower(Position.RIGHT);
    }


    /**
     * Get the number of disks in the game
     * 
     * @return number of disks
     */
    public int disks() {
        return this.numDisks;
    }


    /**
     * Get the Tower at a certain position
     * 
     * @param position
     *            Position of the Tower
     * @return Tower at position
     */
    public Tower getTower(Position position) {
        switch (position) {
            case LEFT:
                return this.left;
            case MIDDLE:
                return this.middle;
            case RIGHT:
                return this.right;
            default:
                return this.middle;
        }
    }


    /**
     * String representation of a HanoiSolver
     * 
     * @return String representation
     */
    public String toString() {
        return this.left.toString() + this.middle.toString() + this.right
            .toString();
    }


    /**
     * Move the disk on top from one Tower to another
     * 
     * @param source
     *            source of disk
     * @param destination
     *            destination of the disk
     */
    private void move(Tower source, Tower destination) {
        Disk disk = source.pop();
        destination.push(disk);
        this.setChanged();
        this.notifyObservers(destination.position());
    }


    /**
     * private recursive helper method to solve the Hanoi algorithm
     * 
     * @param currentDisks
     *            number of disks currently
     * @param startPole
     *            Disks from
     * @param tempPole
     *            spare pole
     * @param endPole
     *            Disks to
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 0) {
            return;
        }
        if (currentDisks == 1) {
            move(startPole, endPole);
            return;
        }
        solveTowers(currentDisks - 1, startPole, endPole, tempPole);
        move(startPole, endPole);
        solveTowers(currentDisks - 1, tempPole, startPole, endPole);
    }


    /**
     * method to begin solving the Hanoi algorithm
     */
    public void solve() {
        solveTowers(this.disks(), this.right, this.middle, this.left);
    }
}
