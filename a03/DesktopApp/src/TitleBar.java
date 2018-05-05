import java.awt.*;

public class TitleBar extends TitleBarDecorator {
    public TitleBar(SimpleWindow simpleWindow, Coordinates coordinates, Color color, String title) {
        super(simpleWindow, coordinates, color, title);
    }

    @Override
    public void draw() {
        IWindowSystem ws = getSimpleWindow().getWindowSystem();
        Coordinates titleCoordinates = getCoordinates();
        // This sets the color of the top bar
        if (getSimpleWindow().getId() == (ws.getSimpleWindows().size() - 1)) {
            ws.setColor(Color.CYAN);
        } else {
            ws.setColor(Color.white);
        }
        // Draw the top bar of the window
        ws.drawRect(titleCoordinates);
        ws.fillRect(titleCoordinates);

        // Adding title to the window
        ws.setColor(Color.BLACK);
        Point titleStartPoint = new Point(getSimpleWindow().getWindowSystem(),
                titleCoordinates.getStartPoint().getX(),
                titleCoordinates.getStartPoint().getY() + 10);
        ws.drawString(getTitle(), titleStartPoint);

    }
}
