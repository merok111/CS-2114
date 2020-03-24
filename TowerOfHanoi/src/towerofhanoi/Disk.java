// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import CS2114.Shape;

public class Disk extends Shape implements Comparable<Disk> {
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
    }


    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return this.getWidth() - otherDisk.getWidth();
    }


    public String toString() {
        return this.getWidth() + "";
    }


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
