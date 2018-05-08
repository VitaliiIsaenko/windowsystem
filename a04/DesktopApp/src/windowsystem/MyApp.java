package windowsystem;

import java.awt.*;

/**
 * Our main app to test window system
 */
public class MyApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.PINK);
        ws.setWindowManager(new WindowManager(ws));

        ws.addWindow(250, 250, "Window 1");
        ws.addWindow(250, 250, "Window 2");
        ws.addWindow(250, 250, "Window 3");

    }
}
