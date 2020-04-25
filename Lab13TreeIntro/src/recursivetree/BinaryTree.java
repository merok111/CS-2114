package recursivetree;

// -------------------------------------------------------------------------
/**
 * Represents a binary tree of arbitrary structure. This class is different
 * from those in the textbook. It does not use a separate node class.
 *
 * @param <T>
 *            The type of data elements contained in the tree.
 *
 *            Created by: John Lewis (lewis63) and Stephen Edwards (stedwar2)
 *            Revised (2015.04.30) by: Megan Rigsbee (mrigsbee)
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.25.2020
 */
public class BinaryTree<T> {
    // ~ Instance/static variables .............................................

    private T element;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    // ~ Constructors ..........................................................


    // ----------------------------------------------------------
    /**
     * Creates a single binary tree node containing the
     * given element and no children.
     * 
     * @param value
     *            The data element to store in the new tree node.
     */
    public BinaryTree(T value) {
        element = value;
        left = null;
        right = null;
    }


    // ----------------------------------------------------------
    /**
     * Creates a single binary tree node containing the given
     * element and child subtrees.
     * 
     * @param value
     *            The data value to store on the new node.
     * @param leftChild
     *            A reference to the left child for the new node.
     * @param rightChild
     *            A reference to the right child for the new node.
     */
    public BinaryTree(
        T value,
        BinaryTree<T> leftChild,
        BinaryTree<T> rightChild) {
        element = value;
        left = leftChild;
        right = rightChild;
    }

    // ~ Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Get the data element in this node (i.e., stored at the root of
     * this tree).
     * 
     * @return This node's data element
     */
    public T getElement() {
        return this.element;
    }


    // ----------------------------------------------------------
    /**
     * Sets the data element in this node (i.e., store it at the root of
     * this tree).
     * 
     * @param value
     *            The new data value to store in this node
     */
    public void setElement(T value) {
        this.element = value;
    }


    // ----------------------------------------------------------
    /**
     * Get the left child of this node.
     * 
     * @return This node's left child, or null if none.
     */
    public BinaryTree<T> getLeft() {
        return left;
    }


    // ----------------------------------------------------------
    /**
     * Sets the left child of this node.
     * 
     * @param subtree
     *            A reference to the new left child for this node.
     */
    public void setLeft(BinaryTree<T> subtree) {
        left = subtree;
    }


    // ----------------------------------------------------------
    /**
     * Get the right child of this node.
     * 
     * @return This node's right child, or null if none.
     */
    public BinaryTree<T> getRight() {
        return this.right;
    }


    // ----------------------------------------------------------
    /**
     * Sets the right child of this node.
     * 
     * @param subtree
     *            A reference to the new right child for this node.
     */
    public void setRight(BinaryTree<T> subtree) {
        this.right = subtree;
    }


    // ----------------------------------------------------------
    /**
     * Calculate the size of this binary tree.
     * 
     * @return The size of this tree.
     */
    public int size() {
        int size = 1;
        if (this.right != null) {
            size += this.right.size();
        }
        if (this.left != null) {
            size += this.left.size();
        }
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Calculate the height of this binary tree.
     * The height is longest path from the root to
     * a leaf node.
     * Examples:
     * A A A
     * / / \
     * B B C
     * Height: 1 2 2
     * 
     * @return The height of this tree.
     */
    public int height() {
        int r = 0;
        int l = 0;
        if (this.right != null) {
            r = this.right.height();
        }
        if (this.left != null) {
            l = this.left.height();
        }
        return (Math.max(r, l) + 1);
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a pre-order traversal. The tree's contents are printed
     * as a parenthesized list.
     * 
     * Example: (A(B)(C))
     * Visually: A
     * / \ Traversal: A B C
     * B C
     * 
     * @return a printable representation of this tree's contents, using
     *         a pre-order traversal.
     */
    public String toPreOrderString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(element);
        if (left != null) {
            builder.append(left.toPreOrderString());
        }
        if (right != null) {
            builder.append(right.toPreOrderString());
        }
        builder.append(")");

        return builder.toString();
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a in-order traversal. The tree's contents are printed as
     * a parenthesized list.
     * 
     * Example: ((B)A(C))
     * Visually: A
     * / \ Traversal: B A C
     * B C
     * 
     * @return a printable representation of this tree's contents, using
     *         an in-order traversal.
     */
    public String toInOrderString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        if (left != null) {
            builder.append(left.toInOrderString());
        }
        builder.append(element);
        if (right != null) {
            builder.append(right.toInOrderString());
        }
        builder.append(")");

        return builder.toString();
    }


    // ----------------------------------------------------------
    /**
     * Generate a string containing the "printed version" of this binary
     * tree using a post-order traversal. The tree's contents are printed
     * as a parenthesized list.
     * 
     * For example, if a tree containing the data
     * value A has a left child containing B and a right child containing C,
     * it would be printed as ((B)(C)A).
     * Visually: A
     * / \ Traversal: B C A
     * B C
     * 
     * The parentheses directly reflect
     * the structure of each node in the tree.
     * 
     * @return a printable representation of this tree's contents, using
     *         a post-order traversal.
     */
    public String toPostOrderString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        if (left != null) {
            builder.append(left.toPostOrderString());
        }
        if (right != null) {
            builder.append(right.toPostOrderString());
        }
        builder.append(element);
        builder.append(")");

        return builder.toString();
    }
}
