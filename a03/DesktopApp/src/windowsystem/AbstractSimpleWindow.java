package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.contracts.Observer;
import windowsystem.coordinates.Coordinates;
import java.awt.*;

public abstract class AbstractSimpleWindow implements Observer {
    private Color color;
    private IWindowSystem windowSystem;
    private Coordinates coordinates;

    public AbstractSimpleWindow(IWindowSystem windowSystem, Color color) {
        this.windowSystem = windowSystem;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract public int getId();

    abstract public void setId(int id);

    public IWindowSystem getWindowSystem() {
        return windowSystem;
    }

    public abstract void draw();

    public Color getColor() {
        return color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
