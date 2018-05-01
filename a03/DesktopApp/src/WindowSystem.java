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
     * @param simpleWindow window to add
     */
    public void addSimpleWindow(SimpleWindow simpleWindow){
        simpleWindows.add(simpleWindow);
    }

    /**
     * Removes window from the window system
     * @param simpleWindow window to remove
     */
    public void removeSimpleWindow(SimpleWindow simpleWindow) {
        simpleWindows.remove(simpleWindow);
    }

    /**
     * finds window on the window system by coordinates
     * @param x absolute x position on the window system
     * @param y absolute y position on the window system
     * @return found simple window or null if not found
     */
    public SimpleWindow findSimpleWindow(int x, int y){
        return new SimpleWindow();
    }

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        simpleWindows = new LinkedList<>();
    }

    /**
     * Draws a line on the window system
     * @param startX starting x position on the window system
     * @param startY starting y position on the window system
     * @param endX ending x position on the window system
     * @param endY ending y position on the window system
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
        setColor(new Color(0,0,0));
        drawLine(0.2f, 0.3f, 0.8f, 0.7f);

    }
}
