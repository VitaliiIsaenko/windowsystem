package windowsystem.decorators;

import windowsystem.*;
import windowsystem.Point;

import java.awt.*;

public abstract class CloseWindowDecorator extends AbstractSimpleWindow {
    private AbstractSimpleWindow simpleWindow;
    private Color crossColor;
    private Coordinates coordinates;

    public CloseWindowDecorator(AbstractSimpleWindow simpleWindow, Color color, Color crossColor) {
        super(simpleWindow.getWindowSystem(), simpleWindow.getCoordinates(), color);
        this.simpleWindow = simpleWindow;
        this.crossColor = crossColor;
    }

    public Color getCrossColor() {
        return crossColor;
    }

    public void setCrossColor(Color crossColor) {
        this.crossColor = crossColor;
    }

    public AbstractSimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
