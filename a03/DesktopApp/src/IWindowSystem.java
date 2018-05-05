import java.awt.*;
import java.util.List;

public interface IWindowSystem {
    void setColor(Color color);
    void drawRect(Coordinates coordinates);
    void fillRect(Coordinates coordinates);
    List<AbstractSimpleWindow> getSimpleWindows();
    int getHeight();
    int getWidth();
    void drawString(String string, Point point);
}
