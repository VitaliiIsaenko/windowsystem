package windowsystem.decorators;

import windowsystem.*;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class CloseWindow extends CloseWindowDecorator {
    public CloseWindow(WindowComponent simpleWindow, Color color, Color crossColor) {
        super(simpleWindow, color, crossColor);
    }

    @Override
    public void draw() {
        getSimpleWindow().draw();

        IWindowSystem ws = getWindowSystem();
        WindowComponent simpleWindow = getSimpleWindow();
        // Adding close button to the window
        Point exitStartPoint = new windowsystem.coordinates.Point(ws, simpleWindow.getCoordinates().getEndPoint().getX() - 15, simpleWindow.getCoordinates().getStartPoint().getY());
        windowsystem.coordinates.Point exitEndPoint = new windowsystem.coordinates.Point(ws, simpleWindow.getCoordinates().getEndPoint().getX(), simpleWindow.getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(exitStartPoint, exitEndPoint));
        ws.setColor(getColor());
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        ws.setColor(getCrossColor());
        ws.drawLine(getCoordinates());
        Coordinates exitLineCoordinates = new Coordinates(
                new Point(ws, getCoordinates().getStartPoint().getX(), getCoordinates().getStartPoint().getY() + 15),
                new Point(ws, getCoordinates().getEndPoint().getX(), getCoordinates().getStartPoint().getY()));
        ws.drawLine(exitLineCoordinates);
    }

    @Override
    public void react(Point point) {
        if (getCoordinates().contains(point)) {
            getWindowSystem().removeSimpleWindow(getId());
        } else {
            getSimpleWindow().react(point);
        }
    }

}
