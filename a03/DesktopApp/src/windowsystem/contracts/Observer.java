package windowsystem.contracts;

import windowsystem.coordinates.Point;

public interface Observer {
    void react(Point clickedPoint);
    void react(Point clickedPoint, Point toMove);
}
