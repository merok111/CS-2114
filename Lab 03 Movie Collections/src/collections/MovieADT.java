package collections;
/**
 *  MovieADT abstraction to represent a movie to be stored
 *  in a movie collection. Each movie object has a title (string),
 *  genre (string), rating (int), and year (int).
 *
 *  @author  Megan Rigsbee
 *  @version 2015.02.18
 */
public abstract class MovieADT
{
    private String title;
    private String genre;
    private int rating;
    private int year;

    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     * @param title The name of the movie.
     */
    public MovieADT(String title)
    {
        this.title = title;
    }

    // ----------------------------------------------------------
    /**
     * The name/title of the movie.
     * @return Return the movie's title.
     */
    public String getTitle()
    {
        return title;
    }

    // ----------------------------------------------------------
    /**
     * Genre of a movie.
     * @return Returns the movie's genre.
     */
    public String getGenre()
    {
        return genre;
    }

    // ----------------------------------------------------------
    /**
     * Set the genre of a movie.
     * @param genre The movie's new genre.
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }


    // ----------------------------------------------------------
    /**
     * The rating of a movie out of 5 stars.
     * @return Returns the movie's rating.
     */
    public int getRating()
    {
        return rating;
    }

    // ----------------------------------------------------------
    /**
     * The rating of a movie out of 5 stars.
     * @param rating The movie's new rating.
     */
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    // ----------------------------------------------------------
    /**
     * The year the movie was released.
     * @return Returns the year.
     */
    public int getYear()
    {
        return year;
    }

    // ----------------------------------------------------------
    /**
     * The year the movie was released.
     * @param year The movie's new year.
     */
    public void setYear(int year)
    {
        this.year = year;
    }
    
    

    // ----------------------------------------------------------
    /**
     * Determines if two objects are equal.
     * Two movies are equal if they have the same title.
     *
     * @return Returns true if objects are equal.
     * @param other The object to compare this to.
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        if (this.getClass() == other.getClass())
        {
            Movie movie2 = (Movie) other;
            return this.getTitle().equals(movie2.getTitle());
        }
        else
        {
            return false;
        }
    }
}