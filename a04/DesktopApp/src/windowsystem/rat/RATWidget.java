package windowsystem.rat;

import java.util.List;

public abstract class RATWidget {
    private List<RATMouseListener> listeners;

    public abstract void draw();

    public void addMouseClickListener(RATMouseListener mouseListener) {
        listeners.add(mouseListener);
    }

    public void removeMouseClickListener(RATMouseListener mouseListener){
        listeners.remove(mouseListener);
    }

    public void mouseClicked(RATActionEvent ae) {
        for (RATMouseListener mouseListener :
                listeners) {
            mouseListener.mouseClicked(ae);
        }
    }
}
