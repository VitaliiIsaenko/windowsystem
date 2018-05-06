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
    private AbstractSimpleWindow expandedWindow;

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

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public AbstractSimpleWindow getExpandedWindow() {
        return expandedWindow;
    }

    public void setExpandedWindow(AbstractSimpleWindow expandedWindow) {
        this.expandedWindow = expandedWindow;
    }
}
