package ru.gb.jtwo.la.online.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MainCanvas extends JPanel {

    long lastFrameTime;
    private long lastBackgroundTime;
    private final MainCircles controller;
    private final long DELTA_TIME_BG_CHANGE = 5_000_000_000L; //частота в наносекундах смены фона

    MainCanvas(MainCircles controller) {
        lastFrameTime = System.nanoTime();
        lastBackgroundTime = System.nanoTime();
        this.controller = controller;
        this.addMouseListener(new MyMouseListener(this.controller));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - this.lastFrameTime) * 0.000000001f;
        this.controller.onCanvasRepainted(this, g, deltaTime);
     //   changeBackground();
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.lastFrameTime = currentTime;
        changeBackground();
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

    private void changeBackground() {
        if (this.lastFrameTime - this.lastBackgroundTime >= DELTA_TIME_BG_CHANGE) {
            System.out.println("ПРОШЛО СЕКУНД --> "+(this.lastFrameTime - this.lastBackgroundTime)/1_000_000_000);
            Background background = new Background();
            setBackground(background.getColor());
            this.lastBackgroundTime = this.lastFrameTime;
        }
    }
}
