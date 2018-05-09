package windowsystem.rat;

import windowsystem.coordinates.Coordinates;

import java.awt.*;

public class RATButton extends RATLabel {
    private Color backgroundColor;
    private Color borderColor;

    public RATButton(Coordinates coordinates, String text, Color backgroundColor, Color borderColor) {
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
