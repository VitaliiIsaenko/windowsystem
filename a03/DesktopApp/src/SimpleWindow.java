import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow {
    private int id;
    private Point startPoint;
    private Point endPoint;
    private String title;
    private Color filledColor;

    public SimpleWindow(Point startPoint, Point endPoint, Color filledColor,String title) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.filledColor = filledColor;
        this.title = title;
    }

    public void setPosition(Point startPoint,Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
