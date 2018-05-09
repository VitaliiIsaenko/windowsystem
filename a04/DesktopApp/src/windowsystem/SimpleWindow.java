package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.rat.RATWidget;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Window representation
 */
public class SimpleWindow extends WindowComponent {
    private int id;
    private Color color;
    private List<RATWidget> widgets;

    public SimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem);
        setCoordinates(coordinates);
        this.color = color;
        widgets = new LinkedList<>();
    }

    public void draw() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());

        for (RATWidget widget :
                widgets) {
            widget.draw();
        }
    }

    public void addWidget(RATWidget widget) {
        this.widgets.add(widget);
        widget.setSimpleWindow(this);
        getWindowSystem().requestRepaint();
    }

    @Override
    public void react(Point clickedPoint) {
    }

    @Override
    public void react(Point clickedPoint, Point toMove) {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
