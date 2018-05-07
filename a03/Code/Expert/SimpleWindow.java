import java.awt.Color;

/**
 * Window representation
 */
public class SimpleWindow extends WindowComponent {
    private int id;
    private Color color;

    public SimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem);
        setCoordinates(coordinates);
        this.color = color;
    }

    public void draw() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());
    }

    @Override
    public void react(Point clickedPoint) {
    }

    @Override
    public void react(Point clickedPoint, Point toMove) {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
