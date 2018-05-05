import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow extends AbstractSimpleWindow {
    public SimpleWindow(WindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem, coordinates, color);
    }

    public void draw() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());
    }
}
