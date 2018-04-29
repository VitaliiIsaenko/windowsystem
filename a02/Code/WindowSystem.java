import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class WindowSystem extends GraphicsEventSystem {
    private Map<Placement, SimpleWindow> simpleWindows;
    private int width;
    private int height;

    public void addSimpleWindow(Placement preferredPlacement, SimpleWindow simpleWindow){
        simpleWindows.put(preferredPlacement, simpleWindow);
    }

    public void removeSimpleWindow(SimpleWindow simpleWindow) {
        simpleWindows.remove(simpleWindow);
    }

    public SimpleWindow findSimpleWindow(int x, int y){
        return new SimpleWindow();
    }

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;

        simpleWindows = new HashMap<>();
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
        setColor(new Color(0,0,0));
        drawLine(0.2f, 0.3f, 0.8f, 0.7f);
    }
}
