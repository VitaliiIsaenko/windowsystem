import java.awt.*;

public class WindowManager implements IWindowManager{
    private WindowSystem windowSystem;

    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
        windowSystem.setWindowManager(this);
    }

    private void addTitleBars() {
        for (SimpleWindow sw : windowSystem.getSimpleWindows()) {
            Point titleStartPoint = sw.getStartPoint();
            Point titleEndPoint = new Point(windowSystem, sw.getEndPoint().getX(), sw.getStartPoint().getY() + 15);

            windowSystem.setColor(Color.white);
            windowSystem.drawRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());
            windowSystem.fillRect(titleStartPoint.getX(), titleStartPoint.getY(), titleEndPoint.getX(), titleEndPoint.getY());

            Point exitStartPoint = new Point(windowSystem, sw.getEndPoint().getX() - 15, sw.getStartPoint().getY());
            Point exitEndPoint = new Point(windowSystem, sw.getEndPoint().getX(), sw.getStartPoint().getY() + 15);

            windowSystem.setColor(Color.RED);
            windowSystem.drawRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
            windowSystem.fillRect(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());

            windowSystem.setColor(Color.BLACK);
            windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY(), exitEndPoint.getX(), exitEndPoint.getY());
            windowSystem.drawLine(exitStartPoint.getX(), exitStartPoint.getY() + 15, exitEndPoint.getX(), exitStartPoint.getY());
        }

    }

    public void addSimpleWindow(int width, int height) {
        if (width + 20 > windowSystem.getWidth() || height + 20 > windowSystem.getHeight()){
            throw new IllegalArgumentException("Size of the window should be less than size of desktop");
        }
        Point startPoint = new Point(windowSystem, 10, 10);
        Point endPoint = new Point(windowSystem, width, height);
        windowSystem.addSimpleWindow(new SimpleWindow(startPoint, endPoint, Color.GRAY));
    }

    @Override
    public void decorateWindows() {
        addTitleBars();
    }
}
