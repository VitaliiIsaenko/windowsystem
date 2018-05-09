package windowsystem.rat;

import windowsystem.coordinates.Point;

import java.awt.*;

public class RATTextField extends RATLabel {
    private Color backgroundColor;
    private Color borderColor;

    public RATTextField(Point point, String text, Color backgroundColor, Color borderColor) {
        super(point, text);
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
