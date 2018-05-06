package windowsystem.decorators;

import windowsystem.AbstractSimpleWindow;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public abstract class MinimizeDecorator extends AbstractSimpleWindow {
    private AbstractSimpleWindow simpleWindow;
    private Coordinates expandedWindowCoordinates;
    private Color color;
    private Coordinates coordinates;

    public MinimizeDecorator(AbstractSimpleWindow simpleWindow, Color color) {
        super(simpleWindow.getWindowSystem(), color);
        this.simpleWindow = simpleWindow;
        this.color = color;
    }

    public AbstractSimpleWindow getSimpleWindow() {
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

    public Coordinates getExpandedWindowCoordinates() {
        return expandedWindowCoordinates;
    }

    public void setExpandedWindowCoordinates(Coordinates expandedWindowCoordinates) {
        this.expandedWindowCoordinates = expandedWindowCoordinates;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
