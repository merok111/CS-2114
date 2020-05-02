package binarySearchTree;
//-------------------------------------------------------------------------
/**
 * Exception class for failed finds/removes in search
 * trees, hash tables, and list and tree iterators.
 *
 * @author Mark Allen Weiss (with modifications by John Lewis)
 * @version 2010.04.28
 */
public class ItemNotFoundException
    extends RuntimeException
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Constructs this exception object.
     */
    public ItemNotFoundException()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * Constructs this exception object.
     * @param message the error message.
     */
    public ItemNotFoundException(String message)
    {
        super(message);
    }
}
