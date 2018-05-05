package windowsystem;

public class Coordinates {

    private Point startPoint;
    private Point endPoint;

    public Coordinates(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
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

    public boolean contains(Point point) {
        boolean contains = false;
        if (getStartPoint().getX() < point.getX() && point.getX() < getEndPoint().getX() &&
                getStartPoint().getY() < point.getY() && point.getY() < getEndPoint().getY()) {
            contains = true;
        }
        return contains;
    }
}