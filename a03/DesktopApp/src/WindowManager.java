package com.company;

import java.awt.*;

public class WindowManager implements IWindowManager {
    private WindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    private void addTitleBars() {
        for (SimpleWindow sw : windowSystem.getSimpleWindows()) {

        }
    }

    public void addSimpleWindow(int width, int height,String title) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()) {
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new Point(windowSystem, (windowSystem.getSimpleWindows().size() + 1) * 10,
                (windowSystem.getSimpleWindows().size() + 1) * 10);
        Point endPoint = new Point(windowSystem, width, height);
        windowSystem.addSimpleWindow(new SimpleWindow(startPoint, endPoint, Color.BLACK,title));
    }

    @Override
    public void decorateWindows() {
        addTitleBars();
    }

    public void dragWindow() {

    }
}
