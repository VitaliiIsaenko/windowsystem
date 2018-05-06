package windowsystem;

import de.rwth.hci.Graphics.GraphicsEventSystem;
import windowsystem.contracts.IWindowManager;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Window system, has handles input, output and window management
 */
public class WindowSystem extends GraphicsEventSystem implements IWindowSystem {
    private List<WindowComponent> windows;
    private IWindowManager windowManager;

    private int width;
    private int height;

    private Point lastMousePosition;

    /**
     * Initializes window system
     *
     * @param width  width of the window system
     * @param height height of the window system
     */
    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        windows = new LinkedList<>();
    }

    public void setWindowManager(WindowManager windowManager) {
        this.windowManager = windowManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<WindowComponent> getWindows() {
        return windows;
    }

    /**
     * Adds window to the window system
     *
     * @param window window to add
     */
    public int addWindow(WindowComponent window) {
        window.setId(getNextWindowId());
        windows.add(window);
        return window.getId();
    }

    /**
     * Removes window from the window system
     *
     * @param id identification of window to remove
     */
    public void removeWindow(int id) {
        windows.remove(findWindow(id));
        for (WindowComponent sw : windows) {
            sw.setId(sw.getId() - 1);
        }
        requestRepaint();
    }

    /**
     * Finds window on the window system by coordinates
     *
     * @param id identification of required window
     * @return found simple window or null if not found
     */
    public WindowComponent findWindow(int id) {
        WindowComponent foundWindow = null;
        for (WindowComponent simpleWindow : windows) {
            if (simpleWindow.getId() == id) {
                foundWindow = simpleWindow;
            }
        }
        return foundWindow;
    }

    /**
     * Draws a line on the window system
     *
     * @param startX starting x position on the window system
     * @param startY starting y position on the window system
     * @param endX   ending x position on the window system
     * @param endY   ending y position on the window system
     */
    public void drawLine(float startX, float startY, float endX, float endY) {
        double startXCalculated = width * startX;
        double startYCalculated = height * startY;
        double endXCalculated = width * endX;
        double endYCalculated = height * endY;
        drawLine(startXCalculated, startYCalculated, endXCalculated, endYCalculated);
    }

    /**
     * Paints window system
     */
    @Override
    protected void handlePaint() {
        setBackground(Color.PINK);

        for (int i = 0; i < windows.size(); i++) {
            WindowComponent simpleWindow = windows.get(i);
            simpleWindow.draw();
        }
    }

    /**
     * Handles clicked mouse
     *
     * @param x x coordinate of the click
     * @param y y coordinate of the click
     */
    @Override
    public void handleMouseClicked(int x, int y) {
        System.out.println("Mouse clicked at x:" + x + " - y:" + y);
        System.out.println(windows);

        windowManager.handleMouseClicked(new Point(this, x, y));
    }

    /**
     * Handles mouse dragging
     *
     * @param x x coordinate of the drag
     * @param y y coordinate of the drag
     */
    @Override
    public void handleMouseDragged(int x, int y) {
        if (lastMousePosition == null) {
            lastMousePosition = new Point(this, x, y);
        } else {
            int x2 = x - lastMousePosition.getX();
            int y2 = y - lastMousePosition.getY();
            if (Math.abs(x2) >= 5 || Math.abs(y2) >= 5) {
                lastMousePosition = new Point(this, x, y);
            } else {
                windowManager.handleMouseDragged(new Point(this, x, y), new Point(this, x2, y2));
            }
        }
    }

    /**
     * Draws rectangle
     *
     * @param coordinates 2d coordinates
     */
    public void drawRect(Coordinates coordinates) {
        drawRect(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    /**
     * Fills rectangle
     *
     * @param coordinates 2d coordinates
     */
    public void fillRect(Coordinates coordinates) {
        fillRect(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    /**
     * Draws line
     *
     * @param coordinates 2d coordinates
     */
    public void drawLine(Coordinates coordinates) {
        drawLine(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    /**
     * Draws string on the window system
     *
     * @param text          text to draw
     * @param startingPoint starting point of the string drawing
     */
    public void drawString(String text, windowsystem.coordinates.Point startingPoint) {
        drawString(text, startingPoint.getX(), startingPoint.getY());
    }

    /**
     * Gets next window id
     *
     * @return window id
     */
    private int getNextWindowId() {
        int maxId = windows.stream().map(simpleWindow -> simpleWindow.getId())
                .mapToInt(id -> id)
                .max().orElse(0);
        return maxId + 1;
    }
}