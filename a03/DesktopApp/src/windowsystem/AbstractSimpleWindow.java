package windowsystem;

import java.awt.*;

public abstract class AbstractSimpleWindow implements Observer {
    private Color color;

    public abstract void apply();

    private IWindowSystem windowSystem;
    private int id;
    private Coordinates coordinates;

    public AbstractSimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        this.coordinates = coordinates;
        this.windowSystem = windowSystem;
        this.color = color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IWindowSystem getWindowSystem() {
        return windowSystem;
    }

    public Color getColor() {
        return color;
    }
}
