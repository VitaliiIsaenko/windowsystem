import javax.swing.*;
import java.awt.*;

public class ExtraCreditApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Extra credit app");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,400));

        LineDrawer ld = new LineDrawer();
        panel.setLayout(new BorderLayout());
        panel.add(ld, BorderLayout.CENTER);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


}
