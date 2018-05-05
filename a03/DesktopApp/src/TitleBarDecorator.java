import java.awt.*;

public abstract class TitleBarDecorator extends AbstractSimpleWindow{
    private AbstractSimpleWindow simpleWindow;
    private String title;
    private Color textColor;
    private Color activeColor;

    public TitleBarDecorator(AbstractSimpleWindow simpleWindow, Color color, Color activeColor, Color textColor, String title) {
        super(simpleWindow.getWindowSystem(), simpleWindow.getCoordinates(), color);
        this.simpleWindow = simpleWindow;
        this.title = title;
        this.activeColor = activeColor;
        this.textColor = textColor;
    }

    @Override
    public AbstractSimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public void setActiveColor(Color activeColor) {
        this.activeColor = activeColor;
    }
}
