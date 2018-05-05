package windowsystem.contracts;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

public interface IWindowManager {
    void handleMouseClicked(Point point);
    void handleMouseDragged(Point clickedPoint, Point toMove);
}
