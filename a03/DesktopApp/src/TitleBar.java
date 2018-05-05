import java.awt.*;

public class TitleBar extends TitleBarDecorator {
    private ISimpleWindow simpleWindow;

    public TitleBar(ISimpleWindow simpleWindow) {
        this.simpleWindow = simpleWindow;
    }

    @Override
    public void draw() {
        WindowSystem ws = simpleWindow.getWindowSystem();
        Coordinates titleCoordinates = getCoordinates();
        // This sets the color of the top bar
        if (simpleWindow.getId() == (ws.getSimpleWindows().size() - 1)) {
            ws.setColor(Color.CYAN);
        } else {
            ws.setColor(Color.white);
        }
        // Draw the top bar of the window
        ws.drawRect(titleCoordinates);
        ws.fillRect(titleCoordinates);

        // Adding title to the window
        ws.setColor(Color.BLACK);
        ws.drawString(simpleWindow.getTitle(), titleCoordinates.getStartPoint().getX(), titleCoordinates.getStartPoint().getY() + 10);

    }

    @Override
    public WindowSystem getWindowSystem() {
        return simpleWindow.getWindowSystem();
    }

    @Override
    public Coordinates getCoordinates() {
        return new Coordinates(simpleWindow.getCoordinates().getStartPoint(),
                new Point(getWindowSystem(), simpleWindow.getCoordinates().getEndPoint().getX(), simpleWindow.getCoordinates().getStartPoint().getY() + 15));
        ;
    }

    @Override
    public int getId() {
        return simpleWindow.getId();
    }

    @Override
    public String getTitle() {
        return simpleWindow.getTitle();
    }
}
