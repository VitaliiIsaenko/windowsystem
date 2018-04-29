import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDrawer extends JComponent {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private int prevY;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(250, 250);
    }

    public LineDrawer() {
        x1 = 100;
        y1 = 100;
        x2 = 150;
        y2 = 100;

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                resizeLine(e.getY());
                prevY = e.getY();
            }
        });
    }

    private void resizeLine(int y) {
        if (y < prevY) {
            if (x2 < 250) {
                x2++;
                x1--;
            }
        } else {
            if (x2 > x1) {
                x2--;
                x1++;
            }
        }
        repaint();
    }
}
