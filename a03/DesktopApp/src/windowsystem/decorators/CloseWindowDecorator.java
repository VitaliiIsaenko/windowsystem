package windowsystem.decorators;

import windowsystem.*;
import windowsystem.coordinates.Point;
import java.awt.*;

public abstract class CloseWindowDecorator extends AbstractSimpleWindow {
    private AbstractSimpleWindow simpleWindow;
    private Color crossColor;

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
}
