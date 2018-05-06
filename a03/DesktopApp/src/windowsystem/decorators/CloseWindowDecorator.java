package windowsystem.decorators;

import windowsystem.*;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import java.awt.*;

public abstract class CloseWindowDecorator extends WindowComponent {
    private WindowComponent simpleWindow;
    private Color crossColor;
    private Coordinates coordinates;
    private Color color;

    public CloseWindowDecorator(WindowComponent simpleWindow, Color color, Color crossColor) {
        super(simpleWindow.getWindowSystem());
        this.simpleWindow = simpleWindow;
        this.crossColor = crossColor;
        this.color = color;
    }

    public Color getCrossColor() {
        return crossColor;
    }

    public void setCrossColor(Color crossColor) {
        this.crossColor = crossColor;
    }

    public WindowComponent getSimpleWindow() {
        return simpleWindow;
    }

    @Override
    public int getId() {
        return getSimpleWindow().getId();
    }

    @Override
    public void setId(int id) {
        getSimpleWindow().setId(id);
    }

    @Override
    public void react(Point clickedPoint, Point toMove) { getSimpleWindow().react(clickedPoint, toMove);
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
