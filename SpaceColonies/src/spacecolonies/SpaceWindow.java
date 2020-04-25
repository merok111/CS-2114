// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

/**
 * Create a Visual Representation for this Project
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class SpaceWindow {
    public static final int PERSONINFOX = 5;
    public static final int PERSONINFOY = 5;

    public static final int QUEUE_BUFFER = 20;
    public static final int QUEUE_STARTY = 70;
    public static final int CIRCLE_SPACING = 2;

    public static final int PLANET_BUFFER = 80;
    public static final int PLANET_WIDTH = 60;
    public static final int MAX_PLANET_HEIGHT = 80;
    public static final int PLANET_STARTY = 150;

    private static final int PLANET_INFO_STARTY = PLANET_STARTY
        + MAX_PLANET_HEIGHT + 10;

    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;

    private AList<CircleShape> personCircles;
    private TextShape personInfo;

    private Shape[] planetFill;
    private Shape[] planetBackground;
    private TextShape[] planetInfo1;
    private TextShape[] planetInfo2;

    private final Color[] fillColor = { new Color(127, 96, 147), new Color(58,
        124, 122), new Color(49, 86, 119) };
    private final Color[] planetColor = { new Color(173, 147, 189), new Color(
        102, 176, 174), new Color(112, 148, 180) };
    private final Color noPref = new Color(165, 209, 232);


    /**
     * Construct this class with a given ColonyCalculator to handle the project
     * behind the scenes
     * 
     * @param calc
     *            ColonyCalculator with the Person and Planet information
     */
    public SpaceWindow(ColonyCalculator calc) {
        this.colonyCalculator = calc;
        this.window = new Window("Space Colony Placement");
        this.accept = new Button("ACCEPT");
        accept.onClick(this, "clickedAccept");
        this.reject = new Button("REJECT");
        reject.onClick(this, "clickedReject");

        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);

        setUpPlanetVisual();
        setUpQueueVisual();
        redraw(false);
    }


    /**
     * helper method to create the planet visuals
     */
    private void setUpPlanetVisual() {
        Planet[] planets = ColonyCalculator.getPlanets();
        int num = planets.length;

        this.planetBackground = new Shape[num];
        this.planetFill = new Shape[num];
        this.planetInfo1 = new TextShape[num];
        this.planetInfo2 = new TextShape[num];

        int totalx = window.getGraphPanelWidth() - 2 * PLANET_BUFFER;
        int frac = totalx / num;

        for (int i = 0; i < num; i++) {
            Planet planet = planets[i];
            int x = PLANET_BUFFER + (frac - PLANET_WIDTH) / 2;
            if (i != 0) {
                x += frac * i;
            }

            planetFill[i] = new Shape(x, PLANET_STARTY + MAX_PLANET_HEIGHT,
                PLANET_WIDTH, 0, fillColor[i]);
            window.addShape(planetFill[i]);

            planetBackground[i] = new Shape(x, PLANET_STARTY, PLANET_WIDTH,
                MAX_PLANET_HEIGHT, planetColor[i]);
            window.addShape(planetBackground[i]);

            String info = String.format("%s, %d/%d", planet.getName(), planet
                .getPopulationSize(), planet.getCapacity());
            planetInfo1[i] = new TextShape(x, PLANET_INFO_STARTY, info);
            planetInfo1[i].setBackgroundColor(Color.white);
            window.addShape(planetInfo1[i]);

            int y = planetInfo1[i].getHeight();
            info = String.format("%s", planet.getMinSkills().toString());
            planetInfo2[i] = new TextShape(x, PLANET_INFO_STARTY + y, info);
            planetInfo2[i].setBackgroundColor(Color.white);
            window.addShape(planetInfo2[i]);
        }
    }


    /**
     * helper method to create the queue visuals
     */
    private void setUpQueueVisual() {
        this.personInfo = new TextShape(PERSONINFOX, PERSONINFOY,
            "Player info panel");
        personInfo.setBackgroundColor(Color.white);
        window.addShape(personInfo);

        this.personCircles = new AList<CircleShape>();

        int initx = colonyCalculator.getQueue().getSize();
        int totalx = window.getGraphPanelWidth() - QUEUE_BUFFER * 2;
        int diameter = totalx / initx - CIRCLE_SPACING;
        Object[] objs = colonyCalculator.getQueue().toArray();
        for (int i = 0; i < objs.length; i++) {
            if (objs[i] instanceof Person) {
                Person person = (Person)objs[i];
                String pref = person.getPlanetPreference();
                int index = colonyCalculator.getPlanetIndex(pref);
                Color color = noPref;
                if (index != -1) {
                    color = planetColor[index];
                }

                CircleShape shape = null;
                if (i != 0) {
                    shape = new CircleShape(QUEUE_BUFFER + diameter * i
                        + CIRCLE_SPACING * i, QUEUE_STARTY, diameter, color);
                }
                else {
                    shape = new CircleShape(QUEUE_BUFFER, QUEUE_STARTY,
                        diameter, color);
                }
                personCircles.add(shape);
                window.addShape(shape);
            }
        }
    }


    /**
     * helper method to redraw and update the visuals
     * 
     * @param remove
     *            true if a Person has been removed since the last redraw
     */
    private void redraw(boolean remove) {
        Planet[] planets = ColonyCalculator.getPlanets();
        ArrayQueue<Person> people = colonyCalculator.getQueue();

        if (remove && !personCircles.isEmpty()) {
            CircleShape rem = personCircles.getEntry(0);
            window.removeShape(rem);
            int prev = rem.getX();
            for (int i = 0; i < personCircles.getLength(); i++) {
                CircleShape temp = personCircles.getEntry(i);
                int x = temp.getX();
                temp.setX(prev);
                prev = x;
            }

            for (int i = 0; i < planets.length; i++) {
                Shape fill = this.planetFill[i];
                TextShape info1 = this.planetInfo1[i];
                Planet planet = planets[i];
                int size = planet.getPopulationSize();
                int cap = planet.getCapacity();

                if (size != 0) {
                    window.removeShape(fill);
                    int height = MAX_PLANET_HEIGHT / cap * size;
                    int y = PLANET_STARTY + MAX_PLANET_HEIGHT - height;

                    planetFill[i] = new Shape(fill.getX(), y, PLANET_WIDTH,
                        height, fillColor[i]);
                    window.addShape(planetFill[i]);
                    window.moveToFront(planetFill[i]);

                    info1.setText(String.format("%s, %d/%d", planet.getName(),
                        planet.getPopulationSize(), planet.getCapacity()));
                }
            }
        }

        if (people.isEmpty()) {
            this.accept.disable();
            this.reject.disable();
            window.removeAllShapes();
            window.addShape(new TextShape(QUEUE_BUFFER, QUEUE_STARTY,
                "All Applicant Processed - Good Work!"));
            return;
        }
        Person next = people.getFront();
        if (next != null) {
            this.personInfo.setText(next.toString());
        }
    }


    /**
     * method to run when the Accept button is clicked
     * 
     * @param button
     *            Button clicked
     */
    public void clickedAccept(Button button) {
        if (colonyCalculator.getQueue().isEmpty()) {
            this.accept.disable();
        }
        boolean success = colonyCalculator.accept();
        if (!success) {
            this.accept.disable();
        }
        redraw(success);
    }


    /**
     * method to run when the Reject button is clicked
     * 
     * @param button
     *            Button clicked
     */
    public void clickedReject(Button button) {
        if (colonyCalculator.getQueue().isEmpty()) {
            this.reject.disable();
            redraw(false);
        }
        else {
            colonyCalculator.reject();
            this.accept.enable();
            redraw(true);
        }
    }
}
