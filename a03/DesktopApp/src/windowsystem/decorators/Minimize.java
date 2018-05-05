package windowsystem.decorators;

import windowsystem.AbstractSimpleWindow;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class Minimize extends MinimizeDecorator {
    public Minimize(AbstractSimpleWindow simpleWindow, Color color) {
        super(simpleWindow, color);
    }

    @Override
    public void draw() {
        getSimpleWindow().draw();

        // Adding minimise button to the window
        Coordinates minimizeCoordinates = new Coordinates(
                new Point(getWindowSystem(),
                        getSimpleWindow().getCoordinates().getEndPoint().getX() - 30,
                        getSimpleWindow().getCoordinates().getStartPoint().getY()),
                new Point(getWindowSystem(),
                        getSimpleWindow().getCoordinates().getEndPoint().getX() - 15,
                        getSimpleWindow().getCoordinates().getStartPoint().getY() + 15));
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(minimizeCoordinates);
        getWindowSystem().fillRect(minimizeCoordinates);
    }

    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {

        } else {
            getSimpleWindow().react(clickedPoint);
        }
    }
}
