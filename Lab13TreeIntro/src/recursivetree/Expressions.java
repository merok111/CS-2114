package recursivetree;

/**
 * Create an expression tree post lab activity
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.25.2020
 *
 */
public class Expressions {
    /**
     * Main run method
     * 
     * @param args
     *            Command Line Arguments
     */
    public static void main(String... args) {
        BinaryTree<String> mult = new BinaryTree<String>("*");
        BinaryTree<String> minus = new BinaryTree<String>("-");
        BinaryTree<String> a = new BinaryTree<String>("a");
        BinaryTree<String> b = new BinaryTree<String>("b");
        BinaryTree<String> div = new BinaryTree<String>("/");
        BinaryTree<String> plus = new BinaryTree<String>("+");
        BinaryTree<String> c = new BinaryTree<String>("c");
        BinaryTree<String> d = new BinaryTree<String>("d");
        BinaryTree<String> e = new BinaryTree<String>("e");

        mult.setLeft(minus);
        mult.setRight(div);

        minus.setLeft(a);
        minus.setRight(b);

        div.setLeft(plus);
        div.setRight(e);

        plus.setLeft(c);
        plus.setRight(d);

        String str = mult.toInOrderString();
        System.out.println(str);
    }
}
