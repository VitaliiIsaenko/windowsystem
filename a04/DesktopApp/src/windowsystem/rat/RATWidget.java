package windowsystem.rat;

import windowsystem.SimpleWindow;
import windowsystem.coordinates.Coordinates;

import java.util.LinkedList;
import java.util.List;

public abstract class RATWidget {
    private SimpleWindow simpleWindow;
    private List<RATMouseListener> listeners;
    private Coordinates coordinates;

    public RATWidget(Coordinates coordinates){
        this.coordinates = coordinates;
        this.listeners = new LinkedList<>();
    }

    public void draw() {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        if (coordinates.getStartPoint() == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        coordinates.getStartPoint().setX(coordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX());
        coordinates.getStartPoint().setY(coordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY());
        if (coordinates.getEndPoint() != null) {
            coordinates.getEndPoint().setX(coordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX());
            coordinates.getEndPoint().setY(coordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY());
        }
    };

    public void addActionListener(RATMouseListener mouseListener) {
        listeners.add(mouseListener);
    }

    public void removeActionListener(RATMouseListener mouseListener){
        listeners.remove(mouseListener);
    }

    public void notifyListeners(RATActionEvent ae) {
        for (RATMouseListener mouseListener :
                listeners) {
            mouseListener.mouseClicked(ae);
        }
    }

    public SimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    public void setSimpleWindow(SimpleWindow simpleWindow) {
        this.simpleWindow = simpleWindow;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
