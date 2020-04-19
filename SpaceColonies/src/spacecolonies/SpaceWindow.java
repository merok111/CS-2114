package spacecolonies;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

public class SpaceWindow {
    public static final int QUEUE_STARTX = 100;
    public static final int QUEUE_STARTY = 150;
    public static final int CIRCLE_SIZE = 10;
    public static final int CIRCLE_SPACING = 10;

    public static final int PERSONINFOX = 5;
    public static final int PERSONINFOY = 5;

    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    private AList<CircleShape> personCircles;

    private TextShape personInfo;
    private TextShape[] planetInfo;


    public SpaceWindow(ColonyCalculator calc) {
        this.colonyCalculator = calc;
        this.window = new Window("Space Colony Placement");
        this.accept = new Button("ACCEPT");
        accept.onClick(this, "clickedAccept");
        this.reject = new Button("REJECT");
        reject.onClick(this, "clickedReject");

        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);

        this.personInfo = new TextShape(PERSONINFOX, PERSONINFOY,
            "Player info panel");
        personInfo.setBackgroundColor(Color.white);
        
        window.addShape(personInfo);

    }


    public void clickedAccept(Button button) {
        // redraw();
    }


    public void clickedReject(Button button) {
        // redraw();
    }


    public static void main(String... args) {
        new SpaceWindow(null);
    }
}