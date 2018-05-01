import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow {
    private int id;
    private Point startPoint;
    private Point endPoint;

    private Color filledColor;

    public SimpleWindow(Point startPoint, Point endPoint, Color filledColor) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.filledColor = filledColor;
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


    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
