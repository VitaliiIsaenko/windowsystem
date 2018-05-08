package windowsystem.rat;

import java.util.List;

public abstract class RATWidget {
    private List<RATMouseListener> listeners;

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
}
