package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import java.awt.Color;

/**
 * Window representation
 */
public class SimpleWindow extends AbstractSimpleWindow {
    private int id;

    public SimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem, color);
        setCoordinates(coordinates);
    }

    public void draw() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());
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
}
