import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Class containing the main method for HelloWorldGraphical application
 */
public class HelloWorldGraphical {

    /**
     * Main method of the HelloWorldGraphical program
     * Sets up the GUI
     */
    public static void main(String[] args) {
        HelloWorldGraphical gbld = new HelloWorldGraphical();
        gbld.launch();
    }

    /**
     * Launches the GUI by adding panels and buttons and arranging them into desired places
     * Also adds event listeners to the buttons and defines action to perform
     */
    public void launch() {
        JFrame mainFrame = new JFrame("Hello GUI");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setMinimumSize(new Dimension(390, 400));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 10, 10, 10));

        JLabel lGreeting = new JLabel("No button pressed");
        lGreeting.setPreferredSize(new Dimension(120, 30));
        GridBagConstraints cLabelGreeting = new GridBagConstraints();
        cLabelGreeting.weighty = 1.0;
        cLabelGreeting.weightx = 0.0;
        cLabelGreeting.gridx = 0;
        cLabelGreeting.gridy = 3;
        mainPanel.add(lGreeting, cLabelGreeting);

        JButton bGerman;
        GridBagConstraints cButtonGerman = new GridBagConstraints();
        bGerman = new JButton("Deutsch");
        bGerman.setPreferredSize(new Dimension(110, 30));
        bGerman.addActionListener(ae -> lGreeting.setText("Guten Tag!"));
        cButtonGerman.weightx = 1.0;
        cButtonGerman.insets = new Insets(0, 0, 20, 0);
        cButtonGerman.gridx = 1;
        cButtonGerman.gridy = 0;
        mainPanel.add(bGerman, cButtonGerman);

        JButton bEnglish;
        GridBagConstraints cButtonEnglish = new GridBagConstraints();
        bEnglish = new JButton("English");
        bEnglish.setPreferredSize(new Dimension(110, 30));
        bEnglish.addActionListener(ae -> lGreeting.setText("Hi there!"));
        cButtonEnglish.weightx = 1.0;
        cButtonEnglish.insets = new Insets(0, 0, 20, 0);
        cButtonEnglish.gridx = 1;
        cButtonEnglish.gridy = 1;
        mainPanel.add(bEnglish, cButtonEnglish);

        JButton bFrance;
        GridBagConstraints cButtonFrance = new GridBagConstraints();
        bFrance = new JButton("Francais");
        bFrance.setPreferredSize(new Dimension(110, 30));
        bFrance.addActionListener(ae -> lGreeting.setText("Bonjour!"));
        cButtonFrance.weightx = 1.0;
        cButtonFrance.insets = new Insets(0, 0, 20, 0);
        cButtonFrance.gridx = 1;
        cButtonFrance.gridy = 2;
        mainPanel.add(bFrance, cButtonFrance);

        JButton bClose = new JButton("Beenden");
        bClose.setPreferredSize(new Dimension(110, 30));
        GridBagConstraints cButtonClose = new GridBagConstraints();
        bClose.addActionListener(ae -> System.exit(0));
        cButtonClose.weightx = 0.0;
        cButtonClose.gridx = 2;
        cButtonClose.gridy = 4;
        mainPanel.add(bClose, cButtonClose);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}
