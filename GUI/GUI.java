package GUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

public class GUI implements ActionListener {
    int count = 0;
    JLabel lable;
    JButton button;
    JFrame frame;
    JPanel pannel;

    Event Mouse = new Event();

    public GUI() {
        frame = new JFrame();

        button = new JButton("Click ME");
        button.addActionListener(this);
        frame.addMouseListener(Mouse);
        pannel = new JPanel();
        lable = new JLabel("Number of clicks = 0");
        pannel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        pannel.setLayout(new GridLayout(3, 4));
        pannel.setSize(1500, 500);
        pannel.add(button);
        pannel.add(lable);
        frame.add(pannel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Banking System");
        frame.setSize(1500, 500);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        lable.setText("Number of Clicks: " + count);
        button.setText("Button Pressed: " + count);
        Mouse.DisplayStats();
        lable.setText(Mouse.ReturnStats());

    }
}