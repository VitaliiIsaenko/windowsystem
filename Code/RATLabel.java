import java.awt.*;

/**
 * Class for label
 */
public class RATLabel extends RATWidget {
    private String text;
    private Color textColor;

    /**
     * Initializes new label
     * @param startingPoint starting point of the label on the window
     * @param text text of the label
     * @param textColor color of the label text
     */
    public RATLabel(Point startingPoint, String text, Color textColor) {
        super(startingPoint);
        this.textColor = textColor;
        this.text = text;
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        super.draw();
        getSimpleWindow().getWindowSystem().setColor(textColor);
        getSimpleWindow().getWindowSystem().drawString(text, new Point(getCoordinates().getStartPoint().getX()+3,getCoordinates().getStartPoint().getY()+15));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
