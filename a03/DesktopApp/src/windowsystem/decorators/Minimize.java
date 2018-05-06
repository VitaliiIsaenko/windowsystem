package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class Minimize extends MinimizeDecorator {
    public Minimize(WindowComponent simpleWindow, Color color, Color minimizedColor) {
        super(simpleWindow, color, minimizedColor);
    }

    @Override
    public void draw() {
        if (!isMinimized()) {
            getSimpleWindow().draw();
            // Adding minimise button to the window
            setCoordinates(new Coordinates(
                    new Point(getWindowSystem(),
                            getSimpleWindow().getCoordinates().getEndPoint().getX() - 30,
                            getSimpleWindow().getCoordinates().getStartPoint().getY()),
                    new Point(getWindowSystem(),
                            getSimpleWindow().getCoordinates().getEndPoint().getX() - 15,
                            getSimpleWindow().getCoordinates().getStartPoint().getY() + 15)));
            getWindowSystem().setColor(getColor());
            getWindowSystem().drawRect(getCoordinates());
            getWindowSystem().fillRect(getCoordinates());

        } else {
            Coordinates minimizeWindow = new Coordinates(
                    new Point(getWindowSystem(), 50 * getId(), 550),
                    new Point(getWindowSystem(), 50 * getId() + 50, 580)
            );
            setCoordinates(minimizeWindow);
            getWindowSystem().setColor(getMinimizedColor());
            getWindowSystem().drawRect(minimizeWindow);
            getWindowSystem().fillRect(minimizeWindow);


        }
    }

    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {
            System.out.println("crazy");
            if (isMinimized()) {
                setMinimized(false);
            } else {
                setMinimized(true);
            }
        } else {
            getSimpleWindow().react(clickedPoint);
        }
    }
}
