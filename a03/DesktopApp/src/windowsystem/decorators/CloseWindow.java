package windowsystem.decorators;

import windowsystem.*;
import windowsystem.Point;

import java.awt.*;

public class CloseWindow extends CloseWindowDecorator {
    public CloseWindow(AbstractSimpleWindow simpleWindow, Color color, Color crossColor) {
        super(simpleWindow, color, crossColor);
    }

    @Override
    public void apply() {
        getSimpleWindow().apply();

        IWindowSystem ws = getWindowSystem();
        AbstractSimpleWindow simpleWindow = getSimpleWindow();
        // Adding close button to the window
        windowsystem.Point exitStartPoint = new windowsystem.Point(ws, simpleWindow.getCoordinates().getEndPoint().getX() - 15, simpleWindow.getCoordinates().getStartPoint().getY());
        windowsystem.Point exitEndPoint = new windowsystem.Point(ws, simpleWindow.getCoordinates().getEndPoint().getX(), simpleWindow.getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(exitStartPoint, exitEndPoint));
        ws.setColor(getColor());
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        ws.setColor(getCrossColor());
        ws.drawLine(getCoordinates());
        Coordinates exitLineCoordinates = new Coordinates(
                new windowsystem.Point(ws, getCoordinates().getStartPoint().getX(), getCoordinates().getStartPoint().getY() + 15),
                new Point(ws, getCoordinates().getEndPoint().getX(), getCoordinates().getStartPoint().getY()));
        ws.drawLine(exitLineCoordinates);
    }



    @Override
    public void react(Point point) {
        if (getCoordinates().contains(point)){
            getWindowSystem().removeSimpleWindow(getId());
            getWindowSystem().removeSimpleWindow(getSimpleWindow().getId());
        }
    }
}
