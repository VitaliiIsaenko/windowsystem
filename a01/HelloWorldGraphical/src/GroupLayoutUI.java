import javax.swing.*;
import java.awt.*;

public class GroupLayoutUI {
    public void launch() {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300, 300);

        Panel panel = new Panel();
        mainFrame.getContentPane().add(BorderLayout.CENTER, panel);
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JButton c1 = new JButton("c1");
        JButton c2 = new JButton("c2");
        JButton c3 = new JButton("c3");
        JButton c4 = new JButton("c4");


        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(c1)
                        .addComponent(c2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(c3)
                                .addComponent(c4))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(c1)
                                .addComponent(c2)
                                .addComponent(c3))
                        .addComponent(c4)
        );

        mainFrame.setVisible(true);
    }
}
