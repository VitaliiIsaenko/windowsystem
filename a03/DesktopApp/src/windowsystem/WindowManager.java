package windowsystem;

import windowsystem.contracts.IWindowManager;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.decorators.CloseWindow;
import windowsystem.decorators.TitleBar;

import java.awt.*;

public class WindowManager implements IWindowManager {
    private IWindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    private void addMinimiseButtons(int i) {
//        windowsystem.SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
//        // Adding minimise button to the window
//        windowsystem.coordinates.Point minStartPoint = new windowsystem.coordinates.Point(windowSystem, simpleWindow.getEndPoint().getX() - 30, simpleWindow.getStartPoint().getY());
//        windowsystem.coordinates.Point minEndPoint = new windowsystem.coordinates.Point(windowSystem, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY() + 15);
//        windowSystem.setColor(Color.GREEN);
//        windowSystem.drawRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
//        windowSystem.fillRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
    }

    @Override
    public void handleMouseClicked(Point point) {
        for (int i = 0; i < windowSystem.getSimpleWindows().size(); i++) {
            windowSystem.getSimpleWindows().get(i).react(point);

        }
        windowSystem.requestRepaint();

//        for (int i = windowSystem.getSimpleWindows().size() - 1; i >= 0; i--) {
//            SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
//            if (x >= simpleWindow.getEndPoint().getX() - 15 && x <= simpleWindow.getEndPoint().getX()
//                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getStartPoint().getY() + 15) {
//                System.out.println("Window: " + simpleWindow.getTitle() + " closed");
//                windowSystem.getSimpleWindows().remove(i);
//                windowSystem.requestRepaint();
//            } else if(x > simpleWindow.getEndPoint().getX() - 30 && x < simpleWindow.getEndPoint().getX() - 15
//                    && y > simpleWindow.getStartPoint().getY() && y < simpleWindow.getStartPoint().getY() + 15) {
//                System.out.println("Window: " + simpleWindow.getTitle() + " minimised");
//                windowSystem.getMinimisedSimpleWindows().add(simpleWindow);
//                windowSystem.getSimpleWindows().remove(simpleWindow);
//                windowSystem.requestRepaint();
//            } else if (x >= simpleWindow.getStartPoint().getX() && x <= simpleWindow.getEndPoint().getX()
//                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getEndPoint().getY()) {
//                System.out.println("Window: " + simpleWindow.getTitle() + " clicked at x:" + x + " - y:" + y);
//                windowSystem.getSimpleWindows().remove(i);
//                windowSystem.getSimpleWindows().add(simpleWindow);
//                windowSystem.requestRepaint();
//                break;
//            }
//        }
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

        AbstractSimpleWindow simpleWindow = new CloseWindow(
                new TitleBar(
                        new SimpleWindow(windowSystem, simpleWindowCoordinates, Color.BLACK),
                        Color.WHITE, Color.CYAN, Color.BLACK, title),
                Color.RED, Color.BLACK);

        windowSystem.addSimpleWindow(simpleWindow);
    }
}
