package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements ActionListener {
    final String TITLE_OF_PROGRAM = "Chatter: simple chat bot";
    final int START_LOCATION = 250;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    SimpleBot sbot;

    JTextArea dialogue;
    JCheckBox si;
    JTextField message;

    Chat() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        dialogue = new JTextArea();
        dialogue.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(dialogue);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        si = new JCheckBox("SI");
        si.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton button = new JButton("Entre");
        button.addActionListener(this);
        panel.add(si);
        panel.add(message);
        panel.add(button);
        add(BorderLayout.CENTER, scrollPane);
        add(BorderLayout.SOUTH, panel);
        setVisible(true);
        sbot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            dialogue.append(message.getText() + "\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0, 9) +
                    sbot.sayInReturn(message.getText(), si.isSelected()) + "\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }

}
