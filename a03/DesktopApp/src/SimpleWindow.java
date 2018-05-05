import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow extends AbstractSimpleWindow {
    public SimpleWindow(WindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem, coordinates, color);
    }

    @Override
    public AbstractSimpleWindow getSimpleWindow() {
        return this;
    }

    public void apply() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());
    }
}
