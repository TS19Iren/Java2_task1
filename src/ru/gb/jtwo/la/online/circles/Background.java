package ru.gb.jtwo.la.online.circles;

import java.awt.*;

//Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
public class Background {
    private final Color color;

    public Background() {
        this.color = new Color (
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
    }
    public Color getColor () {
        return this.color;
    }
}
