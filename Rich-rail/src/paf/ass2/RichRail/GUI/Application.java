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

    public Application() {
        commit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commitMessage.getText();
                Receiver rec = new Receiver();
                rec.executeCommand(command);
                LogsHolder lh = new LogsHolder();
                updateWindows(lh);
                commitMessage.setText("");
            }

            private void updateWindows(LogsHolder lh){
                System.out.println("ding!" + lh.getGUIObject("DSL") + lh.getGUIText("DSL"));
                leftPane.append(lh.getGUIObject("DSL"));
                rightPane.append(lh.getGUIText("DSL"));
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
