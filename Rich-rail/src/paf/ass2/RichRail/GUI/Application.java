package paf.ass2.RichRail.GUI;

import paf.ass2.RichRail.Controller.Receiver;
import paf.ass2.RichRail.Logger.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by Jochem Kuus on 3-1-2017.
 */
public class Application {
    private JPanel mainPanel;
    private JTextArea leftPane;
    private JTextArea rightPane;
    private JTextField commitMessage;
    private JButton commit;
    private JButton newFrame;
    private JButton closeFrame;
    public String name;

    public Application() {
        Logger.registerGUI(this);
        name = "DSL";
        commit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commitMessage.getText();
                Receiver rec = new Receiver();
                boolean cmd = rec.executeCommand(command);
                if (cmd == false) {
                    Logger.log("Command not found");
                }
                commitMessage.setText("");
            }

        });
        newFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("RichRails");
                frame.setContentPane(new Application().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        closeFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton component = (JButton) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(component);
                frame.dispose();
            }
        });
    }
    public void updateWindows(String object, String text){
        leftPane.setText(object);
        rightPane.setText(text);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("RichRail");
        frame.setContentPane(new Application().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
