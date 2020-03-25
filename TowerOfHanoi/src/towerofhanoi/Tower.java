// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

/**
 * Tower structure which extends LinkedStack but specifics its data in Disks
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;


    /**
     * Create a Tower object with a certain Position
     * 
     * @param pos
     *            Position of this Tower
     */
    public Tower(Position pos) {
        super();
        this.position = pos;
    }


    /**
     * getter for the Position of this Tower
     * 
     * @return Position of this Tower
     */
    public Position position() {
        return this.position;
    }


    /**
     * attempt to add a Disk to the top of the Tower
     * 
     * @throws IllegalArgumentException
     *             if the disk is null
     * @throws IllegalStateException
     *             if the disk cannot be added to the Tower
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.size() == 0 || disk.compareTo(this.peek()) < 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
