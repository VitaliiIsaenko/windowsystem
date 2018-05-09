package windowsystem.rat;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

public class RATLabel extends RATWidget {
    private String text;

    public RATLabel(Point point, String text) {
        super(new Coordinates(point, null));
        this.text = text;
    }

    @Override
    public void draw() {
        getSimpleWindow().getWindowSystem().drawString(text, getCoordinates().getStartPoint());
    }
}
