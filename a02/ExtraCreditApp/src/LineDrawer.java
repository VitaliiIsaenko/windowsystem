import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Widget that draws lines
 */
public class LineDrawer extends JComponent {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private int prevY;

    /**
     * Paints widget
     * @param g Graphics object or its heir
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.drawLine(x1, y1, x2, y2);
    }

    /**
     * Initializes widget, sets initial coordinates for the line to draw
     */
    public LineDrawer() {
        x1 = 150;
        x2 = 150;
        y1 = 200;
        y2 = 200;

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                resizeLine(e.getY());
                prevY = e.getY();
            }
        });
    }

    /**
     * Handles mouse d&d action - changes line's size
     * @param y new y coordinate of the mouse
     */
    private void resizeLine(int y) {
        if (y < prevY) {
            if (x2 < getWidth()) {
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
