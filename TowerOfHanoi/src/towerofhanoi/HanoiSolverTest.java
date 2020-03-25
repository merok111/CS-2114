// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import student.TestCase;

/**
 * Test the HanoiSolver class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class HanoiSolverTest extends TestCase {

    private HanoiSolver hanoi1;
    private HanoiSolver hanoi2;
    private HanoiSolver empty;


    /**
     * Set up method tests
     */
    public void setUp() {
        this.hanoi1 = new HanoiSolver(5);
        for (int i = 5; i > 0; i--) {
            this.hanoi1.getTower(Position.RIGHT).push(new Disk(i));
        }

        this.hanoi2 = new HanoiSolver(5);
        this.hanoi2.getTower(Position.LEFT).push(new Disk(5));
        this.hanoi2.getTower(Position.LEFT).push(new Disk(2));
        this.hanoi2.getTower(Position.MIDDLE).push(new Disk(1));
        this.hanoi2.getTower(Position.RIGHT).push(new Disk(5));
        this.hanoi2.getTower(Position.RIGHT).push(new Disk(2));

        this.empty = new HanoiSolver(0);
    }


    /**
     * Test HanoiSolver disks method
     */
    public void testDisks() {
        assertEquals(this.hanoi1.disks(), 5, 0.01);
    }


    /**
     * Test HanoiSolver getTower method
     */
    public void testGetTower() {
        assertEquals(this.hanoi1.getTower(Position.LEFT).position(),
            Position.LEFT);
        assertEquals(this.hanoi1.getTower(Position.DEFAULT).position(),
            Position.MIDDLE);
        assertEquals(this.hanoi1.getTower(Position.MIDDLE).position(),
            Position.MIDDLE);
        assertEquals(this.hanoi1.getTower(Position.RIGHT).position(),
            Position.RIGHT);
        assertEquals(this.hanoi1.getTower(Position.LEFT).size(), 0, 0.01);
        assertEquals(this.hanoi1.getTower(Position.RIGHT).size(), 5, 0.01);
        this.hanoi1.getTower(Position.LEFT).push(new Disk(4));
        assertEquals(this.hanoi1.getTower(Position.LEFT).size(), 1, 0.01);
    }


    /**
     * Test HanoiSolver toString method
     */
    public void testToString() {
        assertEquals(this.hanoi1.toString(), "[][][1, 2, 3, 4, 5]");
        this.hanoi1.solve();
        assertEquals(this.hanoi1.toString(), "[1, 2, 3, 4, 5][][]");

        assertEquals(this.hanoi2.toString(), "[2, 5][1][2, 5]");
        assertEquals(this.empty.toString(), "[][][]");
    }


    /**
     * Test HanoiSolver solve method
     */
    public void testSolve() {
        assertEquals(this.hanoi1.toString(), "[][][1, 2, 3, 4, 5]");
        assertEquals(this.hanoi1.getTower(Position.LEFT).size(), 0, 0.01);
        assertEquals(this.hanoi1.getTower(Position.RIGHT).size(), 5, 0.01);
        assertEquals(this.hanoi1.getTower(Position.MIDDLE).size(), 0, 0.01);
        this.hanoi1.solve();
        assertEquals(this.hanoi1.toString(), "[1, 2, 3, 4, 5][][]");
        assertEquals(this.hanoi1.getTower(Position.LEFT).size(), 5, 0.01);
        assertEquals(this.hanoi1.getTower(Position.RIGHT).size(), 0, 0.01);
        assertEquals(this.hanoi1.getTower(Position.MIDDLE).size(), 0, 0.01);

        assertEquals(this.empty.toString(), "[][][]");
        assertEquals(this.empty.getTower(Position.LEFT).size(), 0, 0.01);
        assertEquals(this.empty.getTower(Position.RIGHT).size(), 0, 0.01);
        assertEquals(this.empty.getTower(Position.MIDDLE).size(), 0, 0.01);
        this.empty.solve();
        assertEquals(this.empty.toString(), "[][][]");
        assertEquals(this.empty.getTower(Position.LEFT).size(), 0, 0.01);
        assertEquals(this.empty.getTower(Position.RIGHT).size(), 0, 0.01);
        assertEquals(this.empty.getTower(Position.MIDDLE).size(), 0, 0.01);
    }

}
