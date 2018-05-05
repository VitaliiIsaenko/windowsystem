package windowsystem;

import windowsystem.decorators.CloseWindow;
import windowsystem.decorators.TitleBar;

import java.awt.*;

public class WindowManager implements IWindowManager {
    private IWindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    private void addTitleBars(int i) {
    }

    private void addCloseButtons(int i) {
//        windowsystem.SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
//        // Adding close button to the window
//        windowsystem.Point exitStartPoint = new windowsystem.Point(windowSystem, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY());
//        windowsystem.Point exitEndPoint = new windowsystem.Point(windowSystem, simpleWindow.getEndPoint().getX(), simpleWindow.getStartPoint().getY() + 15);
//        windowSystem.setColor(Color.RED);
//        windowSystem.drawRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
//        windowSystem.fillRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
//
//        windowSystem.setColor(Color.BLACK);
//        windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
//        windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY() + 15, exitEndPoint.getX(), exitStartPoint.getY());
    }

    private void addMinimiseButtons(int i) {
//        windowsystem.SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
//        // Adding minimise button to the window
//        windowsystem.Point minStartPoint = new windowsystem.Point(windowSystem, simpleWindow.getEndPoint().getX() - 30, simpleWindow.getStartPoint().getY());
//        windowsystem.Point minEndPoint = new windowsystem.Point(windowSystem, simpleWindow.getEndPoint().getX() - 15, simpleWindow.getStartPoint().getY() + 15);
//        windowSystem.setColor(Color.GREEN);
//        windowSystem.drawRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
//        windowSystem.fillRect(minStartPoint.getX(), minStartPoint.getY(), minEndPoint.getX(), minEndPoint.getY());
    }

    @Override
    public void decorateWindow(int i) {
//        addTitleBars(i);
//        addCloseButtons(i);
//        addMinimiseButtons(i);
    }

    @Override
    public void handleMouseClicked(Point point) {
        System.out.println("Fuck off!");
        for (AbstractSimpleWindow sw :
                windowSystem.getSimpleWindows()) {
            sw.react(point);
            windowSystem.requestRepaint();
        }

//        for (int i = windowSystem.getSimpleWindows().size() - 1; i >= 0; i--) {
//            windowsystem.SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(i);
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
    public void handleMouseDragged(int x, int y, int x2, int y2) {
//        if (windowSystem.getSimpleWindows().size() > 0) {
//            windowsystem.SimpleWindow simpleWindow = windowSystem.getSimpleWindows().get(windowSystem.getSimpleWindows().size()-1);
//            // Check if the dragged coordinates are in the window
//            if (x >= simpleWindow.getStartPoint().getX() && x <= simpleWindow.getEndPoint().getX()
//                    && y >= simpleWindow.getStartPoint().getY() && y <= simpleWindow.getEndPoint().getY()) {
//                windowsystem.Point startPointNew = new windowsystem.Point(windowSystem, simpleWindow.getStartPoint().getX() + x2,
//                        simpleWindow.getStartPoint().getY() + y2);
//                windowsystem.Point endPointNew = new windowsystem.Point(windowSystem, simpleWindow.getEndPoint().getX() + x2,
//                        simpleWindow.getEndPoint().getY() + y2);
//
//                simpleWindow.setPosition(startPointNew, endPointNew);
//                System.out.println("Window" + simpleWindow.getTitle() + "is being draged");
//                windowSystem.requestRepaint();
//            }
//        }
    }

    public void addSimpleWindow(int width, int height, String title) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()) {
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new Point(windowSystem, (windowSystem.getSimpleWindows().size() + 1) * 30,
                (windowSystem.getSimpleWindows().size() + 1) * 30);
        Point endPoint = new Point(windowSystem, width + startPoint.getX(), height + startPoint.getY());
        Coordinates simpleWindowCoordinates = new Coordinates(startPoint, endPoint);

        AbstractSimpleWindow simpleWindow = new CloseWindow(
                new TitleBar(
                        new SimpleWindow(windowSystem, simpleWindowCoordinates, Color.BLACK),
                        Color.WHITE, Color.CYAN, Color.BLACK, title),
                Color.RED, Color.BLACK);

        windowSystem.addSimpleWindow(simpleWindow);
    }

    public void dragWindow() {

    }
}
