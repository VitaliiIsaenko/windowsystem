/**
 * Contract for window manager
 */
public interface IWindowManager {
    void handleMouseClicked(Point point);

    void handleMouseDragged(Point clickedPoint, Point toMove);
}