import java.awt.*;

public abstract class AbstractSimpleWindow {
    private Color color;
    public abstract void draw();
    private IWindowSystem windowSystem;
    private AbstractSimpleWindow simpleWindow;
    private int id;
    private Coordinates coordinates;

    public AbstractSimpleWindow(WindowSystem windowSystem, Coordinates coordinates, Color color) {
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

    public WindowSystem getWindowSystem() {
        return windowSystem;
    }

    public Color getColor() {
        return color;
    }

    public AbstractSimpleWindow getSimpleWindow() {
        return simpleWindow;
    }
}
