package collections;

/**
 * Test the movie object and it's methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.05
 *
 */
public class MovieTest extends student.TestCase {
    private Movie movie;
    private Movie itself;
    private Movie not;
    private Movie sameName;
    private Movie diffName;


    /**
     * Set up the Movie tests
     */
    public void setUp() {
        movie = new Movie("Spiderman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);

        this.itself = this.movie;
        this.not = null;
        this.sameName = new Movie("Spiderman");
        this.diffName = new Movie("Not Spiderman");
    }


    /**
     * test Movie getTitle method
     */
    public void testGetTitle() {
        assertEquals("Spiderman", movie.getTitle());
    }


    /**
     * test Movie getGenre and setGenre methods
     */
    public void testGetGenre() {
        assertEquals("Action", movie.getGenre());
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());
    }


    /**
     * test Movie getRating and setRating methods
     */
    public void testGetRating() {
        assertEquals(4, movie.getRating(), 0.01);
        movie.setRating(6);
        assertEquals(6, movie.getRating(), 0.01);
    }


    /**
     * test Movie getYear and setYear methods
     */
    public void testGetYear() {
        assertEquals(2002, movie.getYear());
        movie.setYear(2010);
        assertEquals(2010, movie.getYear(), 0.01);
    }


    /**
     * test Movie equals method
     */
    public void testEquals() {
        // compare a movie to itself
        assertTrue(this.movie.equals(this.itself));
        // compare to null
        assertFalse(this.movie.equals(this.not));
        // compare to another movie object (same title and different title)
        assertTrue(this.movie.equals(this.sameName));
        assertFalse(this.movie.equals(this.diffName));
        // compare to a non Movie object
        assertFalse(this.movie.equals("Test"));
    }

}
