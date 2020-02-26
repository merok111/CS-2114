package game;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * WhackAShape game
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.24.2020
 *
 */
public class WhackAShape {
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;

    private static final String[] combos = { "red circle", "blue circle",
        "red square", "blue square" };


    /**
     * Default constructor to initialize the bag with random size 7-12, fill
     * with random shapes/colors and setup the window frame
     */
    public WhackAShape() {
        this.randomGenerator = new TestableRandom();

        this.bag = new SimpleArrayBag<Shape>();
        this.window = new Window();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.SOUTH);

        int size = this.randomGenerator.nextInt(6) + 7;
        while (bag.getCurrentSize() < size) {
            bag.add(this.buildShape(combos[this.randomGenerator.nextInt(
                combos.length)]));
        }

        this.window.addShape(bag.pick());
    }


    /**
     * Constructor to initialize the bag with shapes/colors from a list and
     * setup the window frame
     * 
     * @param inputs
     *            list of shapes w/ color
     */
    public WhackAShape(String[] inputs) {
        this.randomGenerator = new TestableRandom();

        this.bag = new SimpleArrayBag<Shape>();
        this.window = new Window();
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        this.window.addButton(quitButton, WindowSide.SOUTH);

        for (String s : inputs) {
            try {
                bag.add(this.buildShape(s));
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        this.window.addShape(bag.pick());
    }


    /**
     * Getter for the bag field
     * 
     * @return bag field
     */
    public SimpleBagInterface<Shape> getBag() {
        return this.bag;
    }


    /**
     * Getter for the window
     * 
     * @return window field
     */
    public Window getWindow() {
        return this.window;
    }


    /**
     * Method to conduct when the quit button is clicked
     * 
     * @param button
     *            Button clicked
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Method to conduct when a shape is clicked
     * 
     * @param shape
     *            Shape clicked
     */
    public void clickedShape(Shape shape) {
        this.window.removeShape(shape);
        this.bag.remove(shape);
        Shape nextShape = this.bag.pick();
        if (nextShape != null) {
            this.window.addShape(nextShape);
            return;
        }
        TextShape text = new TextShape(0, 0, "You Win!");

        text.setX(this.window.getGraphPanelWidth() / 2 - text.getWidth() / 2);
        text.setY(this.window.getGraphPanelHeight() / 2 - text.getHeight() / 2);

        this.window.addShape(text);
    }


    /**
     * Method to turn a String input into a Shape based on the String's contents
     * 
     * @param input
     *            String input
     * @return Shape based on String input
     * 
     * @throws IllegalArgumentException
     *             when the String doesn't contain "red" or "blue" and "circle"
     *             or "square"
     */
    private Shape buildShape(String input) {
        int size = this.randomGenerator.nextInt(100) + 101;
        int y = this.randomGenerator.nextInt(this.window.getGraphPanelHeight()
            - size);
        int x = this.randomGenerator.nextInt(this.window.getGraphPanelWidth()
            - size);
        Color color = null;
        Shape currentShape = null;
        if (input.contains("red")) {
            color = Color.red;
        }
        else if (input.contains("blue")) {
            color = Color.blue;
        }
        else {
            throw new IllegalArgumentException();
        }

        if (input.contains("circle")) {
            currentShape = new CircleShape(x, y, size, color);
        }
        else if (input.contains("square")) {
            currentShape = new SquareShape(x, y, size, color);
        }
        else {
            throw new IllegalArgumentException();
        }
        currentShape.onClick(this, "clickedShape");
        return currentShape;

    }
}
