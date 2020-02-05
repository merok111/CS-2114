// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package project1;

import java.awt.Color;
import CS2114.Button;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.BagInterface;

/**
 * Creates the GUI to display the Bag and its contents
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020-02-05
 *
 */
public class ShapeWindow {
    private final String TITLE = "Project 1";

    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;


    /**
     * Constructor to set up the GUI window
     * 
     * @param itemBag
     *            Bag Object
     */
    public ShapeWindow(BagInterface<String> itemBag) {
        this.window = new Window();
        this.window.setTitle(TITLE);
        this.itemBag = itemBag;

        this.quitButton = new Button("Quit");
        this.quitButton.onClick(this, "clickedQuit");
        this.window.addButton(this.quitButton, WindowSide.NORTH);

        this.chooseButton = new Button("Choose");
        this.chooseButton.onClick(this, "clickedChoose");
        this.window.addButton(this.chooseButton, WindowSide.SOUTH);

        this.textShape = new TextShape(0, 0, "");
        this.window.addShape(this.textShape);
    }


    /**
     * this method is performed when the quit button is pressed
     * 
     * @param button
     *            Quit button object
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * this method is performed when the choose button is pressed
     * 
     * @param button
     *            Choose button object
     */
    public void clickedChoose(Button button) {
        if (this.itemBag.getCurrentSize() > 0) {
            this.textShape.setText(this.itemBag.remove());
        }
        else {
            this.textShape.setText("No more items.");
        }
        colorText();
        centerText();
    }


    private void colorText() {
        String s = this.textShape.getText();
        Color color;
        if (s.toLowerCase().contains("red")) {
            color = Color.red;
        }
        else if (s.toLowerCase().contains("blue")) {
            color = Color.blue;
        }
        else {
            color = Color.black;
        }
        this.textShape.setForegroundColor(color);
    }


    private void centerText() {
        int pnlW = this.window.getGraphPanelWidth();
        int pnlH = this.window.getGraphPanelHeight();
        int textW = this.textShape.getWidth();
        int textH = this.textShape.getHeight();
        int x = (pnlW - textW) / 2;
        int y = (pnlH - textH) / 2;

        this.textShape.setX(x);
        this.textShape.setY(y);
    }

}
