package windowsystem;

import java.util.List;

public interface IWindowManager {
    void decorateWindow(int i);
    void handleMouseClicked(Point point);
    void handleMouseDragged(int x,int y, int x2, int y2);
}
