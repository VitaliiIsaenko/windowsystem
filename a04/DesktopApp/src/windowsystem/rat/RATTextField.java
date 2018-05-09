package windowsystem.rat;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

public class RATTextField extends RATLabel {
    private Color backgroundColor;
    private Color borderColor;

    public RATTextField(Coordinates coordinates, String text, Color backgroundColor, Color borderColor) {
        super(coordinates, text);
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        super.draw();
        getSimpleWindow().getWindowSystem().setColor(borderColor);
        getSimpleWindow().getWindowSystem().drawRect(getCoordinates());
        getSimpleWindow().getWindowSystem().setColor(backgroundColor);
        getSimpleWindow().getWindowSystem().fillRect(getCoordinates());
    }
}
