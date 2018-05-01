/**
 * Main app to test WindowSystem
 */
public class MyApp {
    public static void main(String[] args) {

        WindowSystem ws = new WindowSystem(600,600);
        ws.addSimpleWindow(new SimpleWindow(100,10,150,100));
    }
}
