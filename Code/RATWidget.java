import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class for all RAT widgets
 */
public abstract class RATWidget {
    private SimpleWindow simpleWindow;
    private List<RATMouseListener> listeners;
    private Coordinates windowSystemBasedCoordinates;

    /**
     * Initializes new widget
     * @param startingPoint starting point on the window of the widget
     */
    public RATWidget(Point startingPoint) {
        this.windowSystemBasedCoordinates = new Coordinates(startingPoint, null);
        this.listeners = new LinkedList<>();
    }

    public void draw() {
    }

    /**
     * Adds subscriber to listeners collection
     * @param mouseListener class that implements interface for mouse listeners
     */
    public void addActionListener(RATMouseListener mouseListener) {
        listeners.add(mouseListener);
    }

    /**
     * Unsubscribes mouse listener by removing it form listeners collection
     * @param mouseListener mouse listener to add
     */
    public void removeActionListener(RATMouseListener mouseListener) {
        listeners.remove(mouseListener);
    }

    /**
     * Notifies all the listeners on mouse click
     * @param ae action event
     */
    public void notifyListeners(RATActionEvent ae) {
        for (RATMouseListener mouseListener :
                listeners) {
            mouseListener.mouseClicked(ae);
        }
    }

    /**
     * Mouse clicked on the widget
     */
    public void clicked() {
        for (RATMouseListener listener :
                listeners) {
            listener.mouseClicked(null);
        }   
    }

    public SimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    public void setSimpleWindow(SimpleWindow simpleWindow) {
        this.simpleWindow = simpleWindow;
    }

    /**
     * Gets widnow bases coordinates by calculating them from window system based coordinates
     * @return window based coordinates
     */
    public Coordinates getCoordinates() {
        if (windowSystemBasedCoordinates == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        if (windowSystemBasedCoordinates.getStartPoint() == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        Coordinates simpleWindowBasedCoordinates = new Coordinates(new Point(
                windowSystemBasedCoordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX(),
                windowSystemBasedCoordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY()),
                null
        );

        simpleWindowBasedCoordinates.getStartPoint().setX(windowSystemBasedCoordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX());
        simpleWindowBasedCoordinates.getStartPoint().setY(windowSystemBasedCoordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY());
        if (windowSystemBasedCoordinates.getEndPoint() != null) {
            simpleWindowBasedCoordinates.setEndPoint(new Point(
                    windowSystemBasedCoordinates.getEndPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX(),
                    windowSystemBasedCoordinates.getEndPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY()
            ));
        }
        return simpleWindowBasedCoordinates;
    }

    public Coordinates getWindowSystemBasedCoordinates() {
        return windowSystemBasedCoordinates;
    }
}
