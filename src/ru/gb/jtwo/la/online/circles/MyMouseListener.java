package ru.gb.jtwo.la.online.circles;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
    private MainCircles mainCircles;
    public MyMouseListener(MainCircles controller) {
        this.mainCircles = controller;
    }

    @Override
    /**
     *  по клику мышки добавляется новый sprite типа  Ball
     */
    public void mouseClicked(MouseEvent e) {
        int buttonNumber=e.getButton();
        if (buttonNumber==1){
            Sprite sprite = new Ball();
            this.mainCircles.addSprite(sprite);
        }
        if (buttonNumber==3){
            this.mainCircles.removeSprite();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
