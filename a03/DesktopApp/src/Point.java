public class Point {
    private final WindowSystem contextWindowSystem;

    private float x;
    private float y;

    public Point(WindowSystem contextWindowSystem, int x, int y) {
        this.contextWindowSystem = contextWindowSystem;
        if (x < 0 || x > contextWindowSystem.getWidth() || y < 0 || y > contextWindowSystem.getHeight()) {
            throw  new IllegalArgumentException("Coordinate values should not be negative or out of window size");
        }
        this.x = (float)x/contextWindowSystem.getWidth();
        this.y = (float)y/contextWindowSystem.getHeight();
    }

    public Point(WindowSystem contextWindowSystem, float x, float y) {
        this.contextWindowSystem = contextWindowSystem;
        if (x < 0 || x > 1 || y < 0 || y > 1) {
            throw  new IllegalArgumentException("Relative values of coordinates should be between 0 and 1");
        }
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return Math.round(this.x * contextWindowSystem.getWidth());
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x = x/contextWindowSystem.getWidth();
    }

    public int getY() {
        return Math.round(this.x * contextWindowSystem.getHeight());
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setY(int y) {
        this.y = y/contextWindowSystem.getHeight();
    }
}
