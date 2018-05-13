import java.awt.*;

/**
 * Class for button
 */
public class RATButton extends RATLabel {
    private Color backgroundColor;
    private Color borderColor;

    /**
     * Initializes new button
     * @param startingPoint starting point of button position
     * @param text text on the button
     * @param backgroundColor background color of the button
     * @param borderColor border color of the button
     * @param textColor color of the text on the button
     */
    public RATButton(Point startingPoint, String text, Color backgroundColor, Color borderColor, Color textColor) {
        super(startingPoint, text, textColor);
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        Coordinates windowSystemBasedCoordinates = getWindowSystemBasedCoordinates();
        windowSystemBasedCoordinates.setEndPoint(new Point(
                windowSystemBasedCoordinates.getStartPoint().getX() + 50,
                windowSystemBasedCoordinates.getStartPoint().getY() + 25));

        getSimpleWindow().getWindowSystem().setColor(borderColor);
        getSimpleWindow().getWindowSystem().drawRect(getCoordinates());
        getSimpleWindow().getWindowSystem().setColor(backgroundColor);
        getSimpleWindow().getWindowSystem().fillRect(getCoordinates());
        super.draw();
    }
}
