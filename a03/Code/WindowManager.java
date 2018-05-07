import java.awt.*;

/**
 * Window manager
 */
public class WindowManager implements IWindowManager {
    private IWindowSystem windowSystem;

    /**
     * Initializes window manager
     *
     * @param windowSystem window system to apply window manager to
     */
    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    /**
     * Handles mouse click
     *
     * @param point point where mouse was clicked
     */
    @Override
    public void handleMouseClicked(Point point) {
        for (int i = 0; i < windowSystem.getWindows().size(); i++) {
            windowSystem.getWindows().get(i).react(point);
        }
        windowSystem.requestRepaint();
    }

    /**
     * Handles mouse dragging
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void handleMouseDragged(Point clickedPoint, Point toMove) {
        for (int i = 0; i < windowSystem.getWindows().size(); i++) {
            windowSystem.getWindows().get(i).react(clickedPoint, toMove);
        }
        windowSystem.requestRepaint();
    }

    /**
     * Adds simple window decorating it with all necessary decorators of this concrete window manager
     *
     * @param width  width of the created window
     * @param height height of the created window
     * @param title  title of the created window
     */
    public void addSimpleWindow(int width, int height, String title) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()) {
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new Point(windowSystem, (windowSystem.getWindows().size() + 1) * 30,
                (windowSystem.getWindows().size() + 1) * 30);
        Point endPoint = new Point(windowSystem, width + startPoint.getX(), height + startPoint.getY());
        Coordinates simpleWindowCoordinates = new Coordinates(startPoint, endPoint);

        WindowComponent simpleWindow =
                new Close(
                        new TitleBar(
                                new SimpleWindow(windowSystem, simpleWindowCoordinates, Color.BLACK),
                                title, Color.WHITE, Color.CYAN, Color.BLACK),
                        Color.RED, Color.BLACK);

        windowSystem.addWindow(simpleWindow);
    }
}
