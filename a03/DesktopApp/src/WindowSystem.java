import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Window system. Has responsibilities for managing windows
 */
public class WindowSystem extends GraphicsEventSystem {
    private List<SimpleWindow> simpleWindows;
    private int width;
    private int height;

    /**
     * Adds windows to the window system
     *
     * @param simpleWindow window to add
     */
    public void addSimpleWindow(SimpleWindow simpleWindow) {
        simpleWindows.add(simpleWindow);
    }


    public void addSimpleWindow(int x1, int x2, int y1, int y2, Color filledColor) {
        SimpleWindow sw = new SimpleWindow(x1, x2, y1, y2, filledColor);
        simpleWindows.add(sw);
    }

    /**
     * Removes window from the window system
     *
     * @param id identficator of window to remove
     */
    public void removeSimpleWindow(int id) {
        simpleWindows.remove(getWindowById(id));
    }

    /**
     * finds window on the window system by coordinates
     *
     * @param id identificator of required window
     * @return found simple window or null if not found
     */
    public SimpleWindow findSimpleWindow(int id) {
        return getWindowById(id);
    }

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        simpleWindows = new LinkedList<>();
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
        for (SimpleWindow sw : simpleWindows) {
            setColor(sw.getFilledColor());
            drawRect(sw.getStartX(), sw.getStartY(), sw.getEndX(), sw.getEndY());
            fillRect(sw.getStartX(), sw.getStartY(), sw.getEndX(),  sw.getEndY());
        }
    }

    private SimpleWindow getWindowById(int id) {
        SimpleWindow foundWindow = null;
        for (SimpleWindow sw :
                simpleWindows) {
            if (sw.getId() == id) {
                foundWindow = sw;
            }
        }
        return foundWindow;
    }
}
