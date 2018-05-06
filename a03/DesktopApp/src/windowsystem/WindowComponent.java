package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.contracts.Observer;
import windowsystem.coordinates.Coordinates;
import java.awt.*;

public abstract class WindowComponent implements Observer {
    private IWindowSystem windowSystem;
    private Coordinates coordinates;

    public WindowComponent(IWindowSystem windowSystem) {
        this.windowSystem = windowSystem;
    }

    abstract public int getId();

    abstract public void setId(int id);

    public IWindowSystem getWindowSystem() {
        return windowSystem;
    }

    public abstract void draw();

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
