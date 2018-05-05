package windowsystem;

import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow extends AbstractSimpleWindow {
    public SimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem, coordinates, color);
    }

    public void apply() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());
    }

    @Override
    public void react(Point point) {

    }
}
