import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WindowSystem extends GraphicsEventSystem {
    private Map<Placement, SimpleWindow> simpleWindows;
    private int width;
    private int height;

    public void addSimpleWindow(SimpleWindow simpleWindow, Placement placement) {
        simpleWindows = new HashMap<>();
        simpleWindows.put(simpleWindow, placement);
    }

    public void removeSimpleWindow(SimpleWindow simpleWindow) {
        simpleWindows.remove(simpleWindow);
    }

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }

    public void drawLine(float startX, float startY, float endX, float endY) {
        double startXCalculated = width * startX;
        double startYCalculated = height * startY;
        double endXCalculated = width * endX;
        double endYCalculated = height * endY;
        drawLine(startXCalculated, startYCalculated, endXCalculated, endYCalculated);
    }

    @Override
    protected void handlePaint() {
        setColor(new Color(0, 0, 0));
        drawLine(0.2f, 0.3f, 0.8f, 0.7f);
    }
}
