import java.awt.*;

/**
 * Our main app to test window system
 */
public class MyApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.YELLOW);
        ws.setWindowManager(new WindowManager(ws));

        SimpleWindow window1 = ws.addWindow(300, 300, "Window 1");

        RATButton button = new RATButton(new Point(125,20), "Deutsch", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        RATButton button2 = new RATButton(new Point(125, 65), "English", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        RATButton button3 = new RATButton(new Point(125, 105), "Francais", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        RATButton button4 = new RATButton(new Point(230, 255), "Cancel", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        RATLabel label = new RATLabel(new Point(20,175), "No button pressed", Color.WHITE);

        button.addActionListener((ae) -> {
            label.setText("Guten Tag!");
        });

        button2.addActionListener((ae)-> {
            label.setText("Hi there!");
        });

        button3.addActionListener((ae)-> {
            label.setText("Bonjour!");
        });

        button4.addActionListener((ae -> {
            window1.getWindowSystem().removeWindow(window1.getId());}));

        window1.addWidget(button);
        window1.addWidget(button2);
        window1.addWidget(button3);
        window1.addWidget(button4);
        window1.addWidget(label);

    }
}
