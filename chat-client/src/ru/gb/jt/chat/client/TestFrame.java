package ru.gb.jt.chat.client;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {

    public static void main(String[] args) {
        new TestFrame();
    }

    TestFrame() {
        setLayout(new GridLayout(2,2));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p0.setBackground(Color.RED);
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.YELLOW);
        p3.setBackground(Color.MAGENTA);
        add(p0);
        add(p1);
        add(p2);
        add(p3);
        setSize(100,100);
        setVisible(true);
    }
}
