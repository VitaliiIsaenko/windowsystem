import java.awt.*;

/**
 * Main app to test WindowSystem
 */
public class MyApp {
    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600,600);
//        ws.addSimpleWindow(new SimpleWindow(new Point(ws,10, 10), new Point(ws, 100,100), Color.BLACK));
//        ws.addSimpleWindow(new SimpleWindow(new Point(ws,50, 50), new Point(ws, 300,600), Color.GREEN));

        WindowManager wm = new WindowManager(ws);
        wm.addSimpleWindow(100,200);
        wm.addSimpleWindow(200,300);



    }
}
