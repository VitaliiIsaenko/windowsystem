import java.awt.*;

public class CloseWindow extends CloseWindowDecorator {
    public CloseWindow(AbstractSimpleWindow simpleWindow, Color color, Color crossColor) {
        super(simpleWindow, color, crossColor);
    }

    @Override
    public void apply() {
        getSimpleWindow().apply();

        IWindowSystem ws = getWindowSystem();
        AbstractSimpleWindow simpleWindow = getSimpleWindow();
        // Adding close button to the window
        Point exitStartPoint = new Point(ws, simpleWindow.getCoordinates().getEndPoint().getX() - 15, simpleWindow.getCoordinates().getStartPoint().getY());
        Point exitEndPoint = new Point(ws, simpleWindow.getCoordinates().getEndPoint().getX(), simpleWindow.getCoordinates().getStartPoint().getY() + 15);
        Coordinates exitCoordinates = new Coordinates(exitStartPoint, exitEndPoint);
        ws.setColor(getColor());
        ws.drawRect(exitCoordinates);
        ws.fillRect(exitCoordinates);

        ws.setColor(getCrossColor());
        ws.drawLine(exitCoordinates);
        Coordinates exitLineCoordinates = new Coordinates(
                new Point(ws, exitCoordinates.getStartPoint().getX(), exitCoordinates.getStartPoint().getY() + 15),
                new Point(ws, exitCoordinates.getEndPoint().getX(), exitCoordinates.getStartPoint().getY()));
        ws.drawLine(exitLineCoordinates);
    }
}
