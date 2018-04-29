import javax.swing.*;

public class ExtraCreditApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Extra credit app");
        JPanel panel = new JPanel();

        LineDrawer ld = new LineDrawer();
        panel.add(ld);
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }


}
