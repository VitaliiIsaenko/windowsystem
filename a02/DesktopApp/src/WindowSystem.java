import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;

public class WindowSystem extends GraphicsEventSystem {
    public WindowSystem(int width, int height) {
        super(width, height);
    }

    @Override
    public void drawLine(double v, double v1, double v2, double v3) {
        super.drawLine(v, v1, v2, v3);
    }

    @Override
    protected void handlePaint() {
        setColor(new Color(255,122,36));
        drawLine(30, 70, 60, 150);
    }
}
