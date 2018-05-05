package windowsystem;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

public interface IWindowManager {
    void decorateWindow(int i);
    void handleMouseClicked(Point point);
    void handleMouseDragged(Point clickedPoint, Point toMove);
}
