package collections;

import java.util.NoSuchElementException;

/**
 * A simple representation of Netflix's database.
 *
 * @author Megan Rigsbee, Xin Chen, Matthew Grillo
 * @version 2015.02.17, 2015.06.15, 2020.02.05
 */
public class NetvidsDatabase implements MovieCollection {
    private int size;
    private Movie[] movies;


    // ----------------------------------------------------------
    /**
     * Create a new NetvidsDatabase object.
     */
    public NetvidsDatabase() {
        size = 0;
        movies = new Movie[10];
    }


    /**
     * Add a movie object to the database.
     * 
     * @param aMovie
     *            The movie to be added.
     * @return true if the movie is added
     *         false if the movie is already in the collection.
     *         and leaves the database unchanged and
     */
    public boolean addMovie(Movie aMovie) {
        if (contains(aMovie)) {
            return false;
        }

        if (size == movies.length) {
            expandCapacity();
        }
        movies[size] = aMovie;
        size++;
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Removes a specific movie.
     * 
     * @param movie
     *            The movie to be removed.
     * @return the Movie object that was removed.
     * @throws NoSuchElementException
     *             if the movie is not in the database
     * @throws IllegalArgumentException
     *             is the movie is null
     */
    public Movie remove(Movie movie) {
        // Step 1: Throw an exception if the thing you want to remove is null
        if (movie == null) {
            throw new IllegalArgumentException();
        }
        // Step 2: Search through the array and try to find movie.
        Movie removed = null;

        for (int i = 0; i < this.size; i++) {
            if (removed != null) {
                movies[i - 1] = movies[i];
            }
            else if (movies[i].equals(movie)) {
                removed = movie;
            }
        }

        // Step 3: Throw an exception if you failed to find the movie,
        // else return the movie
        if (removed == null) {
            throw new NoSuchElementException();
        }
        movies[size] = null;
        this.size--;
        return removed;
    }


    // ----------------------------------------------------------
    /**
     * Determines whether or not the database contains a specific movie.
     * 
     * @param movie
     *            The movie to be checked.
     * @return Returns true if the movie exists in the database.
     */
    public boolean contains(Movie movie) {
        for (int i = 0; i < size; i++) {
            if (movies[i].equals(movie)) {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Determines if the database has any movies.
     * 
     * @return Returns true if the database is empty (0 Movie objects).
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    // ----------------------------------------------------------
    /**
     * The number of Movie objects currently in the database.
     * 
     * @return The number of movies.
     */
    public int size() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * The number of movies that the database can currently hold before
     * expanding its capacity.
     * 
     * @return The number of slots.
     */
    public int capacity() {
        return movies.length;
    }


    /**
     * Expands the capacity of the database by doubling
     * its current capacity.
     */
    private void expandCapacity() {
        Movie[] larger = new Movie[2 * movies.length];
        for (int i = 0; i < movies.length; i++) {
            larger[i] = movies[i];
        }
        movies = larger;
    }
}
