import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.Set;

public class WindowSystem extends GraphicsEventSystem {
    private Set<SimpleWindow> simpleWindows;
    private int width;
    private int height;

    public void addSimpleWindow(SimpleWindow simpleWindow){
        simpleWindows.add(simpleWindow);
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
        setColor(new Color(255, 122, 36));
        drawLine(30, 70, 60, 150);
        drawLine(0.1f, 0.2f, 0.7f, 0.8f);
    }
}
