import java.awt.*;

/**
 * Window representation
 */
public class SimpleWindow {
    private int id;
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private Color filledColor;

    public SimpleWindow(int startX, int startY, int endX, int endY, Color filledColor) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
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

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getWidth() {
        return endX - startX;
    }

    public int getHeight() {
        return endY - startY;
    }
}
