import java.awt.*;

public abstract class CloseWindowDecorator extends AbstractSimpleWindow {
    private AbstractSimpleWindow simpleWindow;
    private Color crossColor;

    public CloseWindowDecorator(AbstractSimpleWindow simpleWindow, Color color, Color crossColor) {
        super(simpleWindow.getWindowSystem(), simpleWindow.getCoordinates(), color);
        this.simpleWindow = simpleWindow;
        this.crossColor = crossColor;
    }

    public Color getCrossColor() {
        return crossColor;
    }

    public void setCrossColor(Color crossColor) {
        this.crossColor = crossColor;
    }

    @Override
    public AbstractSimpleWindow getSimpleWindow() {
        return simpleWindow;
    }
}
