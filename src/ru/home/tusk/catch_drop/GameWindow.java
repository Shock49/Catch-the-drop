package ru.home.tusk.catch_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class GameWindow extends JFrame {

    public static GameWindow gameWindow;
    private static Image drop;
    private static Image background;
    private static Image gameOver;
    private static long systemTime;
    private static int DROP_X = 0;
    private static int DROP_Y = -150;
    private static int DROP_HEIGHT;
    private static int DROP_WIDTH;
    private static int DROP_SPEED = 250;
    private static int score = 0;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        gameOver = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));

        gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(300, 200);
        gameWindow.setSize(900, 550);
        gameWindow.setTitle("Score : " + score);
        systemTime = System.nanoTime();
        GameField gameField = new GameField();
        gameWindow.add(gameField);
        gameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                DROP_HEIGHT = DROP_Y + drop.getHeight(null);
                DROP_WIDTH = DROP_X + drop.getWidth(null);
                boolean isDrop = (x >= DROP_X && x <= DROP_WIDTH && y >= DROP_Y && y <= DROP_HEIGHT);
                if(isDrop){
                    DROP_Y = -100;
                    DROP_X =(int) (Math.random() *(gameWindow.getWidth()-DROP_WIDTH));
                    DROP_SPEED += 20;
                    score++;
                    gameWindow.setTitle("Score : " + score);
                }
            }
        });
        gameWindow.setVisible(true);
        gameWindow.setResizable(false);
    }

    private static void onRepaint(Graphics g) {
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - systemTime)*0.000000001f;
        systemTime = currentTime;
        DROP_Y = DROP_Y+(int)(DROP_SPEED*deltaTime);

        g.drawImage(background,0,0,900,550,null);
        g.drawImage(drop,DROP_X,DROP_Y,null);
        if (DROP_Y >= gameWindow.getHeight()) g.drawImage(gameOver,200,0,null);

    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
        }
    }
}
