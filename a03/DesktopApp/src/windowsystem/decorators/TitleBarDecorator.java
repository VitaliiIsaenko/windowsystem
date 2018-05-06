package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import java.awt.*;

public abstract class TitleBarDecorator extends WindowComponent {
    private WindowComponent simpleWindow;
    private String title;
    private Color textColor;
    private Color activeColor;
    private Color color;
    private Coordinates coordinates;

    public TitleBarDecorator(WindowComponent simpleWindow, Color color, Color activeColor, Color textColor, String title) {
        super(simpleWindow.getWindowSystem());
        this.simpleWindow = simpleWindow;
        this.title = title;
        this.color = color;
        this.activeColor = activeColor;
        this.textColor = textColor;
    }

    public WindowComponent getSimpleWindow() {
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

    @Override
    public int getId() {
        return getSimpleWindow().getId();
    }

    @Override
    public void setId(int id) {
        getSimpleWindow().setId(id);
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
