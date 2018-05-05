import java.awt.*;

public abstract class TitleBarDecorator extends AbstractSimpleWindow{
    private AbstractSimpleWindow simpleWindow;
    private String title;

    public TitleBarDecorator(SimpleWindow simpleWindow, Coordinates coordinates, Color color, String title) {
        super(simpleWindow.getWindowSystem(), coordinates, color);
        this.simpleWindow = simpleWindow;
        this.title = title;
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
}
