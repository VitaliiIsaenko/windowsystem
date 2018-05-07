import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Concrete title bar component
 */
public class TitleBar extends TitleBarDecorator {
    public TitleBar(WindowComponent simpleWindow, String title, Color color, Color activeColor, Color textColor) {
        super(simpleWindow, title, color, activeColor, textColor);
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        getWindowComponent().draw();

        IWindowSystem ws = getWindowComponent().getWindowSystem();

        Point titleStartPoint = getWindowComponent().getCoordinates().getStartPoint();
        Point titleEndPoint = new Point(ws,
                getWindowComponent().getCoordinates().getEndPoint().getX(),
                getWindowComponent().getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(titleStartPoint, titleEndPoint));

        //Set color of the title bar depending on state of the window (active/not active)
        if (getWindowComponent().getId() == (ws.getWindows().size())) {
            ws.setColor(getActiveColor());
        } else {
            ws.setColor(getColor());
        }
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        ws.setColor(getTextColor());
        Point titleTextStartPoint = new Point(getWindowComponent().getWindowSystem(),
                getCoordinates().getStartPoint().getX(),
                getCoordinates().getStartPoint().getY() + 10);
        ws.drawString(getTitle(), titleTextStartPoint);

    }

    /**
     * Drags the window
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void react(Point clickedPoint, Point toMove) {
        if (getCoordinates().contains(clickedPoint)) {
            int newStartX = getWindowComponent().getCoordinates().getStartPoint().getX() + toMove.getX();
            int newStartY = getWindowComponent().getCoordinates().getStartPoint().getY() + toMove.getY();
            int newEndX = getWindowComponent().getCoordinates().getEndPoint().getX() + toMove.getX();
            int newEndY = getWindowComponent().getCoordinates().getEndPoint().getY() + toMove.getY();
            getWindowComponent().setCoordinates(new Coordinates(
                    new Point(getWindowSystem(), newStartX, newStartY),
                    new Point(getWindowSystem(), newEndX, newEndY)
            ));
        } else {
            getWindowComponent().react(clickedPoint, toMove);
        }
    }
}
