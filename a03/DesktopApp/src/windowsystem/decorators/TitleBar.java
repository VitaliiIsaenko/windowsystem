package windowsystem.decorators;

import windowsystem.*;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class TitleBar extends TitleBarDecorator {
    public TitleBar(AbstractSimpleWindow simpleWindow, Color color, Color activeColor, Color textColor, String title) {
        super(simpleWindow, color, activeColor, textColor, title);
    }

    @Override
    public void draw() {
        getSimpleWindow().draw();

        IWindowSystem ws = getSimpleWindow().getWindowSystem();

        windowsystem.coordinates.Point titleStartPoint = getSimpleWindow().getCoordinates().getStartPoint();
        windowsystem.coordinates.Point titleEndPoint = new windowsystem.coordinates.Point(ws,
                getSimpleWindow().getCoordinates().getEndPoint().getX(),
                getSimpleWindow().getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(titleStartPoint, titleEndPoint));

        // This sets the color of the top bar
        if (getSimpleWindow().getId() == (ws.getSimpleWindows().size())) {
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
        } else {
            getSimpleWindow().react(clickedPoint, toMove);
        }
    }

    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {
            List<AbstractSimpleWindow> simpleWindows = new LinkedList<>(getWindowSystem().getSimpleWindows());
            getWindowSystem().getSimpleWindows().removeAll(simpleWindows);

            AbstractSimpleWindow currentSimpleWindow = null;
            for (AbstractSimpleWindow sw : simpleWindows) {
                if (sw.getId() == this.getId()) {
                    currentSimpleWindow = sw;
                } else {
                    getWindowSystem().addSimpleWindow(sw);
                }
            }
            getWindowSystem().addSimpleWindow(currentSimpleWindow);
        } else {
            getSimpleWindow().react(clickedPoint);
        }
    }
}
