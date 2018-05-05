package windowsystem.decorators;

import windowsystem.AbstractSimpleWindow;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public abstract class MinimizeDecorator extends AbstractSimpleWindow {
    private AbstractSimpleWindow simpleWindow;

    public MinimizeDecorator(AbstractSimpleWindow simpleWindow, Color color) {
        super(simpleWindow.getWindowSystem(), simpleWindow.getCoordinates(), color);
        this.simpleWindow = simpleWindow;
    }

    public AbstractSimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    @Override
    public int getId() {
        return simpleWindow.getId();
    }

    @Override
    public void setId(int id) {
        simpleWindow.setId(id);
    }

    @Override
    abstract public void draw();


    @Override
    public void react(Point clickedPoint, Point toMove) { getSimpleWindow().react(clickedPoint,toMove);
    }
}
