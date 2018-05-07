package windowsystem.coordinates;

import windowsystem.contracts.IWindowSystem;

/**
 * Represents 2D point on windows system in relative to window system scale
 */
public class Point {
    private final IWindowSystem contextWindowSystem;
    private float x;
    private float y;

    /**
     * Initialises the point
     *
     * @param contextWindowSystem window system where point is present
     * @param x                   absolute value of x coordinate of the point
     * @param y                   absolute value of y coordinate of the point
     */
    public Point(IWindowSystem contextWindowSystem, int x, int y) {
        this.contextWindowSystem = contextWindowSystem;
        if (x < 0 || x > contextWindowSystem.getWidth() || y < 0 || y > contextWindowSystem.getHeight()) {
//            throw new IllegalArgumentException("Coordinate values should not be negative or out of window size");
        }
        this.x = (float) x / contextWindowSystem.getWidth();
        this.y = (float) y / contextWindowSystem.getHeight();
    }

    /**
     * Initialises the point
     *
     * @param contextWindowSystem window system where point is present
     * @param x                   relative value of x coordinate of the point (from 0 to 1)
     * @param y                   relative value of y coordinate of the point (from 0 to 1)
     */
    public Point(IWindowSystem contextWindowSystem, float x, float y) {
        this.contextWindowSystem = contextWindowSystem;
        if (x < 0 || x > 1 || y < 0 || y > 1) {
            throw new IllegalArgumentException("Relative values of coordinates should be between 0 and 1");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return Math.round(this.x * contextWindowSystem.getWidth());
    }

    public void setX(float x) {
        if (x < 0 || x > 1) {
            throw new IllegalArgumentException("Relative values of coordinates should be between 0 and 1");
        }
        this.x = x;
    }

    public void setX(int x) {
        if (x < 0 || x > contextWindowSystem.getWidth()) {
            throw new IllegalArgumentException("Coordinate values should not be negative or out of window size");
        }
        this.x = (float) x / contextWindowSystem.getWidth();
    }

    public int getY() {
        return Math.round(this.y * contextWindowSystem.getHeight());
    }

    public void setY(float y) {
        if (y < 0 || y > 1) {
            throw new IllegalArgumentException("Relative values of coordinates should be between 0 and 1");
        }
        this.y = y;
    }

    public void setY(int y) {
        if (y < 0 || y > contextWindowSystem.getWidth()) {
            throw new IllegalArgumentException("Coordinate values should not be negative or out of window size");
        }
        this.y = (float) y / contextWindowSystem.getHeight();
    }
}