package windowsystem.decorators;

import windowsystem.*;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class TitleBar extends TitleBarDecorator {
    public TitleBar(AbstractSimpleWindow simpleWindow, Color color, Color activeColor, Color textColor, String title) {
        super(simpleWindow, color, activeColor, textColor, title);
    }

    @Override
    public void apply() {
        getSimpleWindow().apply();

        IWindowSystem ws = getSimpleWindow().getWindowSystem();

        windowsystem.coordinates.Point titleStartPoint = getSimpleWindow().getCoordinates().getStartPoint();
        windowsystem.coordinates.Point titleEndPoint = new windowsystem.coordinates.Point(ws,
                getSimpleWindow().getCoordinates().getEndPoint().getX(),
                getSimpleWindow().getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(titleStartPoint, titleEndPoint));

        // This sets the color of the top bar
        if (getSimpleWindow().getId() == (ws.getSimpleWindows().size() - 1)) {
            ws.setColor(getActiveColor());
        } else {
            ws.setColor(getColor());
        }
        // Draw the top bar of the window
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        // Adding title to the window
        ws.setColor(getTextColor());
        Point titleTextStartPoint = new Point(getSimpleWindow().getWindowSystem(),
                getCoordinates().getStartPoint().getX(),
                getCoordinates().getStartPoint().getY() + 10);
        ws.drawString(getTitle(), titleTextStartPoint);

    }

    @Override
    public void react(Point clickedPoint, Point toMove) {
        if (getCoordinates().contains(clickedPoint)) {
            int newStartX = getSimpleWindow().getCoordinates().getStartPoint().getX() + toMove.getX();
            int newStartY = getSimpleWindow().getCoordinates().getStartPoint().getY() + toMove.getY();
            int newEndX = getSimpleWindow().getCoordinates().getEndPoint().getX() + toMove.getX();
            int newEndY = getSimpleWindow().getCoordinates().getEndPoint().getY() + toMove.getY();
            getSimpleWindow().setCoordinates(new Coordinates(
                    new Point(getWindowSystem(), newStartX, newStartY),
                    new Point(getWindowSystem(), newEndX, newEndY)
            ));
        }

    }
}
