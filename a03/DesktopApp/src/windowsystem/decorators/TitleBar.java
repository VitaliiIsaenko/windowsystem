package windowsystem.decorators;

import windowsystem.*;
import windowsystem.Point;

import java.awt.*;

public class TitleBar extends TitleBarDecorator {
    public TitleBar(AbstractSimpleWindow simpleWindow, Color color, Color activeColor, Color textColor, String title) {
        super(simpleWindow, color, activeColor, textColor, title);
    }

    @Override
    public void apply() {
        getSimpleWindow().apply();

        IWindowSystem ws = getSimpleWindow().getWindowSystem();

        windowsystem.Point titleStartPoint = getSimpleWindow().getCoordinates().getStartPoint();
        windowsystem.Point titleEndPoint = new windowsystem.Point(ws,
                getSimpleWindow().getCoordinates().getEndPoint().getX(),
                getSimpleWindow().getCoordinates().getStartPoint().getY() + 15);
        Coordinates titleCoordinates = new Coordinates(titleStartPoint, titleEndPoint);

        // This sets the color of the top bar
        if (getSimpleWindow().getId() == (ws.getSimpleWindows().size() - 1)) {
            ws.setColor(getActiveColor());
        } else {
            ws.setColor(getColor());
        }
        // Draw the top bar of the window
        ws.drawRect(titleCoordinates);
        ws.fillRect(titleCoordinates);

        // Adding title to the window
        ws.setColor(getTextColor());
        windowsystem.Point titleTextStartPoint = new Point(getSimpleWindow().getWindowSystem(),
                titleCoordinates.getStartPoint().getX(),
                titleCoordinates.getStartPoint().getY() + 10);
        ws.drawString(getTitle(), titleTextStartPoint);

    }

    @Override
    public void react(Point point) {
        getSimpleWindow().react(point);
    }
}
