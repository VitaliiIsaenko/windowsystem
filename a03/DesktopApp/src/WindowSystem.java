import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Window system. Has responsibilities for managing windows
 */
public class WindowSystem extends GraphicsEventSystem implements IWindowSystem {
    private List<AbstractSimpleWindow> simpleWindows;

    private List<AbstractSimpleWindow> minimisedSimpleWindows;
    private IWindowManager windowManager;

    private int width;
    private int height;

    private Point lastMousePosition;

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        simpleWindows = new LinkedList<>();
        minimisedSimpleWindows = new LinkedList<>();
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

    public List<AbstractSimpleWindow> getSimpleWindows() {
        return simpleWindows;
    }

    /**
     * Adds windows to the window system
     *
     * @param simpleWindow window to add
     */
    public int addSimpleWindow(AbstractSimpleWindow simpleWindow) {
        simpleWindow.setId(getNextWindowId());
        simpleWindows.add(simpleWindow);
        return simpleWindow.getId();
    }

    /**
     * Removes window from the window system
     *
     * @param id identficator of window to remove
     */
    public void removeSimpleWindow(int id) {
        simpleWindows.remove(findSimpleWindow(id));
    }

    /**
     * finds window on the window system by coordinates
     *
     * @param id identificator of required window
     * @return found simple window or null if not found
     */
    public AbstractSimpleWindow findSimpleWindow(int id) {
        AbstractSimpleWindow foundWindow = null;
        for (AbstractSimpleWindow simpleWindow : simpleWindows) {
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

    public List<AbstractSimpleWindow> getMinimisedSimpleWindows() {
        return minimisedSimpleWindows;
    }

    /**
     * Paints window system
     */
    @Override
    protected void handlePaint() {
        setBackground(Color.PINK);

        for (int i = 0; i < simpleWindows.size(); i++) {
            AbstractSimpleWindow simpleWindow = simpleWindows.get(i);
            simpleWindow.apply();
//            windowManager.decorateWindow(i);
        }

        for (int i = 0; i < minimisedSimpleWindows.size(); i++) {
            AbstractSimpleWindow simpleWindow = minimisedSimpleWindows.get(i);
            setColor(Color.GREEN);

            drawRect(50 * i + 10, 550, 50 * i + 50, 580);
            fillRect(50 * i + 10, 550, 50 * i + 50, 580);
            setColor(Color.WHITE);
            drawString(Integer.toString(i), 50 * i + 13, 565);
        }

    }

    @Override
    public void handleMouseClicked(int x, int y) {
        System.out.println("Mouse clicked at x:" + x + " - y:" + y);
        System.out.println(simpleWindows);

        windowManager.handleMouseClicked(x, y);

        for (int i = 0; i < minimisedSimpleWindows.size(); i++) {
            AbstractSimpleWindow simpleWindow = minimisedSimpleWindows.get(i);
            if (x > (50 * i + 10) && x < (50 * i + 50) && y > 550 && y < 580) {
                System.out.println("Maximised Window");
                simpleWindows.add(simpleWindow);
                minimisedSimpleWindows.remove(simpleWindow);
                requestRepaint();
            }
        }
    }


    @Override
    public void handleMouseDragged(int x, int y) {
        System.out.println("x:" + x + " --- y:" + y);
        if (lastMousePosition == null) {
            lastMousePosition = new Point(this, x, y);
        } else {
            int x2 = x - lastMousePosition.getX();
            int y2 = y - lastMousePosition.getY();
            if (Math.abs(x2) >= 15 || Math.abs(y2) >= 15) {
                lastMousePosition = new Point(this, x, y);
            } else {
                System.out.println("lmx:" + lastMousePosition.getX() + " --- lmy:" + lastMousePosition.getY());
                windowManager.handleMouseDragged(x, y, x2, y2);
            }
        }
    }

    public void drawRect(Coordinates coordinates) {
        drawRect(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    public void fillRect(Coordinates coordinates) {
        fillRect(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    public void drawLine(Coordinates coordinates) {
        drawLine(coordinates.getStartPoint().getX(), coordinates.getStartPoint().getY(),
                coordinates.getEndPoint().getX(), coordinates.getEndPoint().getY());
    }

    public void drawString(String text, Point startingPoint){
        drawString(text, startingPoint.getX(), startingPoint.getY());
    }

    private int getNextWindowId() {
        int maxId = simpleWindows.stream().map(simpleWindow -> simpleWindow.getId())
                .mapToInt(id -> id)
                .max().orElse(0);
        return maxId;
    }
}