package windowsystem;

import windowsystem.contracts.IWindowManager;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.decorators.CloseWindow;
import windowsystem.decorators.Minimize;
import windowsystem.decorators.TitleBar;

import java.awt.*;

public class WindowManager implements IWindowManager {
    private IWindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    @Override
    public void handleMouseClicked(Point point) {
        for (int i = 0; i < windowSystem.getSimpleWindows().size(); i++) {
            windowSystem.getSimpleWindows().get(i).react(point);
        }
        windowSystem.requestRepaint();
    }

    @Override
    public void handleMouseDragged(Point clickedPoint, Point toMove) {
        for (int i = 0; i < windowSystem.getSimpleWindows().size(); i++) {
            windowSystem.getSimpleWindows().get(i).react(clickedPoint, toMove);

        }
        windowSystem.requestRepaint();
    }

    public void addSimpleWindow(int width, int height, String title) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()) {
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new windowsystem.coordinates.Point(windowSystem, (windowSystem.getSimpleWindows().size() + 1) * 30,
                (windowSystem.getSimpleWindows().size() + 1) * 30);
        Point endPoint = new windowsystem.coordinates.Point(windowSystem, width + startPoint.getX(), height + startPoint.getY());
        Coordinates simpleWindowCoordinates = new Coordinates(startPoint, endPoint);

        AbstractSimpleWindow simpleWindow = new Minimize(new CloseWindow(
                new TitleBar(
                        new SimpleWindow(windowSystem, simpleWindowCoordinates, Color.BLACK),
                        Color.WHITE, Color.CYAN, Color.BLACK, title),
                Color.RED, Color.BLACK), Color.GREEN);

        windowSystem.addSimpleWindow(simpleWindow);
    }
}
