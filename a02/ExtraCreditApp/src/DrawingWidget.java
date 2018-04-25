import javax.swing.*;
import java.awt.*;

public class DrawingWidget extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0,0,0));
        g.drawLine(50,50,150,150);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(250,250);
    }
}
