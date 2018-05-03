package com.company;

import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Window system. Has responsibilities for managing windows
 */
public class WindowSystem extends GraphicsEventSystem {
    private List<SimpleWindow> simpleWindows;
    private IWindowManager windowManager;

    private int width;
    private int height;

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        simpleWindows = new LinkedList<>();
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

    public List<SimpleWindow> getSimpleWindows() {
        return simpleWindows;
    }

    /**
     * Adds windows to the window system
     *
     * @param simpleWindow window to add
     */
    public int addSimpleWindow(SimpleWindow simpleWindow) {
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
            drawRect(sw.getStartPoint().getX(), sw.getStartPoint().getY(), sw.getEndPoint().getX(), sw.getEndPoint().getY());
            fillRect(sw.getStartPoint().getX(), sw.getStartPoint().getY(), sw.getEndPoint().getX(), sw.getEndPoint().getY());

        }
        if (windowManager != null) {
            windowManager.decorateWindows();
        }
    }

    @Override
    public void handleMouseClicked(int x, int y) {
        for(SimpleWindow simpleWindow : simpleWindows){
            if (x >= simpleWindow.getStartPoint().getX() && x <= simpleWindow.getEndPoint().getX()
                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getEndPoint().getY()){
                System.out.println("Mouse clicked in window");
            }
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

    private int getNextWindowId() {
        int maxId = simpleWindows.stream().map(sw -> sw.getId())
                .mapToInt(id -> id)
                .max().orElse(0);
        return maxId;
    }
}