package recursivetree;

/**
 * Test the BinaryTree class and its methods for proper functionality
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.25.2020
 *
 */
public class BinaryTreeTest extends student.TestCase {
    private BinaryTree<String> tree;
    private BinaryTree<String> solo;
    private BinaryTree<String> example;


    /**
     * Set up the test methods
     */
    public void setUp() {
        this.tree = new BinaryTree<String>("A");
        this.solo = new BinaryTree<String>("Solo");
        this.example = new BinaryTree<String>("A", new BinaryTree<String>("B"),
            new BinaryTree<String>("C"));

        BinaryTree<String> b = new BinaryTree<String>("B");
        BinaryTree<String> c = new BinaryTree<String>("C");
        BinaryTree<String> d = new BinaryTree<String>("D");
        BinaryTree<String> e = new BinaryTree<String>("E");
        BinaryTree<String> f = new BinaryTree<String>("F");
        BinaryTree<String> g = new BinaryTree<String>("G");
        BinaryTree<String> h = new BinaryTree<String>("H");

        this.tree.setLeft(b);
        this.tree.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        c.setLeft(f);
        c.setRight(g);

        d.setLeft(h);
    }


    /**
     * Test BinaryTree setElement and getElement methods
     */
    public void testElement() {
        assertEquals("A", tree.getElement());
        tree.setElement("Z");
        assertEquals("Z", tree.getElement());
    }


    /**
     * Test BinaryTree setLeft and getLeft methods
     */
    public void testLeft() {
        assertEquals("B", tree.getLeft().getElement());
        BinaryTree<String> temp = new BinaryTree<String>("test");
        tree.setLeft(temp);
        assertEquals(temp, tree.getLeft());
        assertEquals("test", tree.getLeft().getElement());
    }


    /**
     * Test BinaryTree setRight and getRight methods
     */
    public void testRight() {
        assertEquals("C", tree.getRight().getElement());
        BinaryTree<String> temp = new BinaryTree<String>("test");
        tree.setRight(temp);
        assertEquals(temp, tree.getRight());
        assertEquals("test", tree.getRight().getElement());
    }


    /**
     * Test BinaryTree size method
     */
    public void testSize() {
        assertEquals(8, tree.size(), 0.01);
        assertEquals(1, solo.size(), 0.01);

        solo.setLeft(new BinaryTree<String>("left"));
        assertEquals(2, solo.size(), 0.01);

        solo.setRight(new BinaryTree<String>("right"));
        assertEquals(3, solo.size(), 0.01);

        solo.setLeft(null);
        assertEquals(2, solo.size(), 0.01);

        solo.setRight(null);
        assertEquals(1, solo.size(), 0.01);
    }


    /**
     * Test BinaryTree height method
     */
    public void testHeight() {
        assertEquals(4, tree.height(), 0.01);
        assertEquals(1, solo.height(), 0.01);

        solo.setLeft(new BinaryTree<String>("left1", new BinaryTree<String>(
            "left2"), null));
        assertEquals(3, solo.height(), 0.01);

        solo.setRight(new BinaryTree<String>("right1", null,
            new BinaryTree<String>("right2")));
        assertEquals(3, solo.height(), 0.01);

        solo.getLeft().setLeft(null);
        assertEquals(3, solo.height(), 0.01);

        solo.getRight().setRight(null);
        assertEquals(2, solo.height(), 0.01);

        solo.setLeft(null);
        solo.setRight(null);
        assertEquals(1, solo.height(), 0.01);
    }


    /**
     * Test BinaryTree toPreOrderString method
     */
    public void testPreOrder() {
        assertEquals("(A(B)(C))", example.toPreOrderString());
        assertEquals("(A(B(D(H))(E))(C(F)(G)))", tree.toPreOrderString());
    }


    /**
     * Test BinaryTree toInOrderString method
     */
    public void testInOrder() {
        assertEquals("((B)A(C))", example.toInOrderString());
        assertEquals("((((H)D)B(E))A((F)C(G)))", tree.toInOrderString());
    }


    /**
     * Test BinaryTree toPostOrderString method
     */
    public void testPostOrder() {
        assertEquals("((B)(C)A)", example.toPostOrderString());
        assertEquals("((((H)D)(E)B)((F)(G)C)A)", tree.toPostOrderString());
    }

}
