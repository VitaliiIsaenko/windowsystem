package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public abstract class MinimizeDecorator extends WindowComponent {
    private WindowComponent simpleWindow;
    private Coordinates expandedWindowCoordinates;
    private Color color;
    private WindowComponent expandedWindow;

    public MinimizeDecorator(WindowComponent simpleWindow, Color color) {
        super(simpleWindow.getWindowSystem());
        this.simpleWindow = simpleWindow;
        this.color = color;
    }

    public WindowComponent getSimpleWindow() {
        return simpleWindow;
    }

    @Override
    public int getId() {
        return simpleWindow.getId();
    }

    @Override
    public void setId(int id) {
        simpleWindow.setId(id);
    }

    @Override
    abstract public void draw();


    @Override
    public void react(Point clickedPoint, Point toMove) { getSimpleWindow().react(clickedPoint,toMove);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public WindowComponent getExpandedWindow() {
        return expandedWindow;
    }

    public void setExpandedWindow(WindowComponent expandedWindow) {
        this.expandedWindow = expandedWindow;
    }
}
