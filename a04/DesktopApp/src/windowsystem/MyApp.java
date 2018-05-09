package windowsystem;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.rat.RATButton;
import windowsystem.rat.RATWidget;

import java.awt.*;

/**
 * Our main app to test window system
 */
public class MyApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.PINK);
        ws.setWindowManager(new WindowManager(ws));

        SimpleWindow window1 = ws.addWindow(250, 250, "Window 1");
        SimpleWindow window2 = ws.addWindow(250, 250, "Window 2");
        SimpleWindow window3 = ws.addWindow(250, 250, "Window 3");

        RATWidget ratWidget = new RATButton(new Coordinates(new Point(5,5), new Point(10,10)), "Hello", Color.WHITE, Color.WHITE);
        ratWidget.addActionListener((dfdf) -> {
            System.out.println("Hello");
        });
        window1.addWidget(ratWidget);


    }
}
