package paf.ass2.RichRail.GUI;

import paf.ass2.RichRail.Controller.Receiver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jopo2 on 3-1-2017.
 */
public class Application {
    private JPanel mainPanel;
    private JTextPane leftPane;
    private JTextPane rightPane;
    private JTextField commitMessage;
    private JButton commit;

    public Application() {
        commit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commitMessage.getText();
                Receiver rec = new Receiver();
                rec.executeCommand(command);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RichRail");
        frame.setContentPane(new Application().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
