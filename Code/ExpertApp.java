import java.awt.*;
/**
 * ExpertApp to generate a window and attach the calculator to it
 */
public class ExpertApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.PINK);
        ws.setWindowManager(new WindowManager(ws));
        // Creating the calculator window
        SimpleWindow calculatorWindow = ws.addWindow(200, 300, "Calculator");
        // Attach the calculator to the window;
        Calculator calculator = new Calculator(calculatorWindow);
    }
}
