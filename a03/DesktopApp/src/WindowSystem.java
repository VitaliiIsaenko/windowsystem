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

    private Point lastMousePosition;

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

        for (int i = 0; i < simpleWindows.size(); i++){
            SimpleWindow simpleWindow = simpleWindows.get(i);
            setColor(simpleWindow.getFilledColor());
            drawRect(simpleWindow.getStartPoint().getX(), simpleWindow.getStartPoint().getY(), simpleWindow.getEndPoint().getX(), simpleWindow.getEndPoint().getY());
            fillRect(simpleWindow.getStartPoint().getX(), simpleWindow.getStartPoint().getY(), simpleWindow.getEndPoint().getX(), simpleWindow.getEndPoint().getY());

            Point titleStartPoint = simpleWindow.getStartPoint();
            Point titleEndPoint = new Point(this, simpleWindow.getEndPoint().getX(), simpleWindow.getStartPoint().getY() + 15);

            // This sets the color of the top bar
            if (i == (simpleWindows.size() - 1)) {
                setColor(Color.CYAN);
            } else {
                setColor(Color.white);
            }
            // Draw the top bar of the window
            drawRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());
            fillRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());

            // Adding title to the window
            setColor(Color.BLACK);
            drawString(simpleWindow.getTitle(), titleStartPoint.getX(), titleStartPoint.getY() + 10);


            Point exitStartPoint = new Point(this, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY());
            Point exitEndPoint = new Point(this, simpleWindow.getEndPoint().getX(), simpleWindow.getStartPoint().getY() + 15);

            this.setColor(Color.RED);
            this.drawRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
            this.fillRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());

            this.setColor(Color.BLACK);
            this.drawLine(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
            this.drawLine(exitStartPoint.getX(), exitStartPoint.getY() + 15, exitEndPoint.getX(), exitStartPoint.getY());
        }

    }

    @Override
    public void handleMouseClicked(int x, int y) {
        for (int i = simpleWindows.size() - 1; i >= 0; i--) {
            SimpleWindow simpleWindow = simpleWindows.get(i);
            if (x >= simpleWindow.getEndPoint().getX() - 15 && x <= simpleWindow.getEndPoint().getX()
                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getStartPoint().getY() + 15) {
                System.out.println("Window: " + simpleWindow.getTitle() + " closed");
                simpleWindows.remove(i);
                requestRepaint();
            } else if (x >= simpleWindow.getStartPoint().getX() && x <= simpleWindow.getEndPoint().getX()
                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getEndPoint().getY()) {
                System.out.println("Window: " + simpleWindow.getTitle() + " clicked at x:" + x + " - y:" + y);
                simpleWindows.remove(i);
                simpleWindows.add(simpleWindow);
                requestRepaint();
                break;
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
            if (Math.abs(x2) >= 10 || Math.abs(y2) >= 10) {
                lastMousePosition = new Point(this, x, y);
            } else {
                System.out.println("lmx:" + lastMousePosition.getX() + " --- lmy:" + lastMousePosition.getY());
                SimpleWindow simpleWindow = simpleWindows.get(simpleWindows.size()-1);
                // Check if the dragged coordinates are in the window
                if (x >= simpleWindow.getStartPoint().getX() && x <= simpleWindow.getEndPoint().getX()
                        && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getEndPoint().getY()) {
                    Point startPointNew = new Point(this, simpleWindow.getStartPoint().getX() + x2,
                            simpleWindow.getStartPoint().getY() + y2);
                    Point endPointNew = new Point(this, simpleWindow.getEndPoint().getX() + x2,
                            simpleWindow.getEndPoint().getY() + y2);

                    simpleWindow.setPosition(startPointNew, endPointNew);
                    System.out.println("Window" + simpleWindow.getTitle() + "is being draged");
                    requestRepaint();
                }

            }
        }

    }


    private SimpleWindow getWindowById(int id) {
        SimpleWindow foundWindow = null;
        for (SimpleWindow simpleWindow :
                simpleWindows) {
            if (simpleWindow.getId() == id) {
                foundWindow = simpleWindow;
            }
        }
        return foundWindow;
    }

    private int getNextWindowId() {
        int maxId = simpleWindows.stream().map(simpleWindow -> simpleWindow.getId())
                .mapToInt(id -> id)
                .max().orElse(0);
        return maxId;
    }
}