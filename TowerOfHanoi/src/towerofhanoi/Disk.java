// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import CS2114.Shape;

/**
 * Disk object
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class Disk extends Shape implements Comparable<Disk> {
    /**
     * Constructor to make a Disk of certain width
     * 
     * @param width
     *            disk width
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
    }


    /**
     * Compares this disk to another
     * 
     * @param otherDisk
     *            Disk to compare this to
     * @return < 0 for smaller disk, > 0 for larger disk, = 0 for same size disk
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }


    /**
     * String representation of a Disk
     * 
     * @return String representation
     */
    public String toString() {
        return this.getWidth() + "";
    }


    /**
     * Determine if this Disk is equal to another object
     * 
     * @param obj
     *            Object to compare to
     * @return equality
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass().equals(this.getClass())) {
            Disk o = (Disk)obj;
            return this.getWidth() == o.getWidth();
        }
        return false;
    }
}
