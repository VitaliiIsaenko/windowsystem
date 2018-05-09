package windowsystem.rat;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

public class RATLabel extends RATWidget {
    private String text;

    public RATLabel(Coordinates coordinates, String text) {
        super(coordinates);
        this.text = text;
    }

    @Override
    public void draw() {
        super.draw();
        getSimpleWindow().getWindowSystem().drawString(text, getCoordinates().getStartPoint());
    }
}
