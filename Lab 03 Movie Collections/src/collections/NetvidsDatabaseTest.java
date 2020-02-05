package collections;

import java.util.NoSuchElementException;

/**
 * test NetvidsDatabase class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.05
 *
 */
public class NetvidsDatabaseTest extends student.TestCase {
    private NetvidsDatabase database;
    private Movie testMovie;
    private Movie anotherMovie;
    private Movie not;


    /**
     * Set up the tests
     */
    public void setUp() {
        this.database = new NetvidsDatabase();

        testMovie = new Movie("Spiderman");
        testMovie.setGenre("Action");
        testMovie.setYear(2002);
        testMovie.setRating(4);

        anotherMovie = new Movie("Superman");
        anotherMovie.setGenre("Action");
        anotherMovie.setYear(2010);
        anotherMovie.setRating(7);

        not = null;
    }


    /**
     * test NetvidsDatabase addMovie method
     */
    public void testAddMovie() {
        // object not in the container
        assertTrue(database.addMovie(testMovie));
        // object already in the container
        assertFalse(database.addMovie(testMovie));
    }


    /**
     * test NetvidsDatabase remove method
     */
    public void testRemove() {
        // return object that was removed
        database.addMovie(this.testMovie);
        database.addMovie(this.anotherMovie);
        assertEquals(2, database.size());
        assertTrue(database.remove(this.testMovie).equals(this.testMovie));
        assertEquals(1, database.size());
        assertFalse(database.contains(this.testMovie));

        // illegal argument exception
        Exception exception = null;
        try {
            database.remove(not);
        }
        catch (IllegalArgumentException e) {
            exception = e;
        }
        assertNotNull(exception);

        // no such element exception
        exception = null;
        try {
            database.remove(this.testMovie);
        }
        catch (NoSuchElementException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * test NetvidsDatabase contains method
     */
    public void testContains() {
        // check if an empty data structure contains an object
        assertFalse(database.contains(testMovie));
        // and if a non-empty data structure has a particular object or not.
        database.addMovie(testMovie);
        assertTrue(database.contains(testMovie));
        assertFalse(database.contains(anotherMovie));

    }


    /**
     * test NetvidsDatabase isEmpty method
     */
    public void testIsEmpty() {
        // check if an empty data structure is empty
        assertTrue(database.isEmpty());
        // and if a non-empty data structure is empty.
        database.addMovie(testMovie);
        assertFalse(database.isEmpty());
    }


    /**
     * test NetvidsDatabase size changing
     */
    public void testSize() {
        // check the size of a non-empty and empty data structure
        assertEquals(0, database.size(), 0.01);
        database.addMovie(testMovie);
        assertEquals(1, database.size(), 0.01);
        database.addMovie(anotherMovie);
        assertEquals(2, database.size(), 0.01);
        database.remove(anotherMovie);
        assertEquals(1, database.size(), 0.01);

        // check that adding the same String object will not result in duplicate
        // entries.
        database.addMovie(testMovie);
        assertEquals(1, database.size(), 0.01);
    }


    /**
     * test NetvidsDatabase automatically expanding its capacity when needed
     */
    public void testExpandCapacity() {
        assertEquals(0, database.size(), 0.01);
        assertEquals(10, database.capacity(), 0.01);
        for (int i = 0; i <= 10; i++) {
            database.addMovie(new Movie("Movie" + i));
        }
        assertEquals(11, database.size(), 0.01);
        assertEquals(20, database.capacity(), 0.01);
    }
}
