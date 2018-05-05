package windowsystem.contracts;

import windowsystem.AbstractSimpleWindow;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;
import java.util.List;

public interface IWindowSystem {
    void setColor(Color color);
    void drawRect(Coordinates coordinates);
    void fillRect(Coordinates coordinates);
    List<AbstractSimpleWindow> getSimpleWindows();
    int getHeight();
    int getWidth();
    void drawString(String string, Point point);
    void drawLine(Coordinates coordinates);
    void removeSimpleWindow(int id);
    int addSimpleWindow(AbstractSimpleWindow simpleWindow);
    void requestRepaint();
}
