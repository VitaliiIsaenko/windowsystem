import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow {
    private WindowSystem windowSystem;
    private SimpleWindow simpleWindow;
    private int id;
    private Coordinates coordinates;
    private String title;
    private Color filledColor;

    public SimpleWindow(WindowSystem windowSystem, Coordinates coordinates, Color filledColor,String title) {
        this.coordinates = coordinates;
        this.windowSystem = windowSystem;
        this.filledColor = filledColor;
        this.title = title;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getFilledColor() {
        return filledColor;
    }

    public void setFilledColor(Color filledColor) {
        this.filledColor = filledColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void draw() {
        windowSystem.setColor(filledColor);
        windowSystem.drawRect(coordinates);
        windowSystem.fillRect(coordinates);
        windowSystem.drawString(title, coordinates.getStartPoint());
    }
}
