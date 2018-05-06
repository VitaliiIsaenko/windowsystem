package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class Minimize extends MinimizeDecorator {
    public Minimize(WindowComponent simpleWindow, Color color) {
        super(simpleWindow, color);
    }

    @Override
    public void draw() {
        getSimpleWindow().draw();

        if (getExpandedWindow() == null) {
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
                    new Point(getWindowSystem(), 50*getId(), 550),
                    new Point(getWindowSystem(), 50*getId()+50,580)
            );
            getWindowSystem().setColor(getColor());
            getWindowSystem().drawRect(minimizeWindow);
            getWindowSystem().fillRect(minimizeWindow);
        }
    }

    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {
            System.out.println("crazy");
            for (WindowComponent sw : getWindowSystem().getSimpleWindows()) {
                if (getId() == sw.getId()) {
                    setExpandedWindow(sw);
                    getWindowSystem().getSimpleWindows().remove(sw);
                    getWindowSystem().addMinimizedSimpleWindow(sw);
                    break;
                }
            }
            //unminimize

        } else {
            getSimpleWindow().react(clickedPoint);
        }
    }
}
