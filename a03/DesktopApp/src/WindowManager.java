package com.company;

import java.awt.*;

public class WindowManager implements IWindowManager {
    private WindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    private void addTitleBars(int i) {
        SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
        Point titleStartPoint = simpleWindow.getStartPoint();
        Point titleEndPoint = new Point(windowSystem, simpleWindow.getEndPoint().getX(), simpleWindow.getStartPoint().getY() + 15);

        // This sets the color of the top bar
        if (i == (windowSystem.getSimpleWindows().size() - 1)) {
            windowSystem.setColor(Color.CYAN);
        } else {
            windowSystem.setColor(Color.white);
        }
        // Draw the top bar of the window
        windowSystem.drawRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());
        windowSystem.fillRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());

        // Adding title to the window
        windowSystem.setColor(Color.BLACK);
        windowSystem.drawString(simpleWindow.getTitle(), titleStartPoint.getX(), titleStartPoint.getY() + 10);
    }

    private void addCloseButtons(int i) {
        SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
        // Adding close button to the window
        Point exitStartPoint = new Point(windowSystem, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY());
        Point exitEndPoint = new Point(windowSystem, simpleWindow.getEndPoint().getX(), simpleWindow.getStartPoint().getY() + 15);
        windowSystem.setColor(Color.RED);
        windowSystem.drawRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
        windowSystem.fillRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());

        windowSystem.setColor(Color.BLACK);
        windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
        windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY() + 15, exitEndPoint.getX(), exitStartPoint.getY());
    }

    private void addMinimiseButtons(int i) {
        SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
        // Adding minimise button to the window
        Point minStartPoint = new Point(windowSystem, simpleWindow.getEndPoint().getX() - 30, simpleWindow.getStartPoint().getY());
        Point minEndPoint = new Point(windowSystem, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY() + 15);
        windowSystem.setColor(Color.GREEN);
        windowSystem.drawRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
        windowSystem.fillRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
    }

    @Override
    public void decorateWindow(int i) {
        addTitleBars(i);
        addCloseButtons(i);
        addMinimiseButtons(i);
    }

    public void addSimpleWindow(int width, int height, String title) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()) {
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new Point(windowSystem, (windowSystem.getSimpleWindows().size() + 1) * 30,
                (windowSystem.getSimpleWindows().size() + 1) * 30);
        Point endPoint = new Point(windowSystem, width + startPoint.getX(), height + startPoint.getY());
        windowSystem.addSimpleWindow(new SimpleWindow(startPoint, endPoint, Color.BLACK, title));
    }

    public void dragWindow() {

    }
}
