import java.awt.*;

/**
 * Class for text field
 */
public class RATTextField extends RATLabel {
    private Color backgroundColor;
    private Color borderColor;

    /**
     * Initializes new text field
     * @param startingPoint starting point of the text field
     * @param text text in the text field
     * @param backgroundColor background color of the text field
     * @param borderColor border color of the text field
     * @param textColor color of the text in the text field
     */
    public RATTextField(Point startingPoint, String text, Color backgroundColor, Color borderColor, Color textColor) {
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
                windowSystemBasedCoordinates.getStartPoint().getX() + 130,
                windowSystemBasedCoordinates.getStartPoint().getY() + 25));

        getSimpleWindow().getWindowSystem().setColor(borderColor);
        getSimpleWindow().getWindowSystem().drawRect(getCoordinates());
        getSimpleWindow().getWindowSystem().setColor(backgroundColor);
        getSimpleWindow().getWindowSystem().fillRect(getCoordinates());
        super.draw();
    }
}
