package ru.home.tusk.catch_drop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public static GameWindow gameWindow;

    public static void main(String[] args) {
        gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(300, 200);
        gameWindow.setSize(900, 550);
        GameField gameField = new GameField();
        gameWindow.add(gameField);
        gameWindow.setVisible(true);
        gameWindow.setResizable(false);
    }

    private static void onRepaint(Graphics g) {
        g.fillOval(0,0,50,20);
        g.drawLine(10,40,100,40);
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
