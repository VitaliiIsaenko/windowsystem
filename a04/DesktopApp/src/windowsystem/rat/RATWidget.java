package windowsystem.rat;

import windowsystem.SimpleWindow;
import windowsystem.coordinates.Coordinates;

import java.util.List;

public abstract class RATWidget {
    private SimpleWindow simpleWindow;
    private List<RATMouseListener> listeners;
    private Coordinates coordinates;

    public RATWidget(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public abstract void draw();

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
