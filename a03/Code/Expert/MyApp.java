import java.awt.*;

/**
 * Our main app to test window system
 */
public class MyApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.PINK);

        WindowManager wm = new WindowManager(ws);

        wm.addSimpleWindow(250, 250, "Window 1");
        wm.addSimpleWindow(250, 250, "Window 2");
        wm.addSimpleWindow(250, 250, "Window 3");

    }
}
