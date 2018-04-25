import javax.swing.*;
import java.awt.*;

public class ExtraCreditApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Extra credit app");
        JPanel panel = new JPanel();


        DrawingWidget dw = new DrawingWidget();
        panel.add(dw);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);
    }


}
