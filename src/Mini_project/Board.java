package Mini_project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Image apple;
    private Image dot;
    private Image head;
    private int dots;
    int score = -1;

    private final int DOT_SIZE = 10;
    private final int all_dot = 900;  //300*300=9000,9000/100(dot_square)
    private final int x[] = new int[all_dot];
    private final int y[] = new int[all_dot];
    private final int RANDOM_POSITION = 29;
    private int apple_x;
    private int apple_y;
    private Timer timer;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    Board() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.BLACK);
        setFocusable(true);

        loadImage();
        initGame();

    }

    public void loadImage() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/apple.png"));
        apple = i1.getImage();
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("image/dot.png"));
        dot = i2.getImage();
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("image/head.png"));
        head = i3.getImage();

    }

    public void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * DOT_SIZE;
            y[z] = 50;
        }

        locateApple();

        timer = new Timer(140, this);
        timer.start();
    }

    public void locateApple() {
        score = score + 1;

        int r = (int) (Math.random() * RANDOM_POSITION);
        apple_x = (r * DOT_SIZE);

        r = (int) (Math.random() * RANDOM_POSITION);
        apple_y = (r * DOT_SIZE);
    }

    public void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            locateApple();
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);//add apple image

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);  //add head
                } else {
                    g.drawImage(dot, x[z], y[z], this); //add tail
                }
            }

            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    public void gameOver(Graphics g) {
        //  String msg = "Game Over \nYour score "+score;
        String scoreMsg = "Your score: " + score;
        Font font = new Font("SAN_SERIF", Font.BOLD, 14);
        FontMetrics metrices = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);
        //  g.drawString(msg, (300 - metrices.stringWidth(msg)) / 2 , 300/2);
        g.drawString(scoreMsg, (300 - metrices.stringWidth(scoreMsg)) / 2, 300 / 2);
    }

    public void checkCollision() {

        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= 300) {
            inGame = false;
        }

        if (x[0] >= 300) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    public void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[z - 1];
            y[z] = y[z - 1];
        }

        if (leftDirection) {
            x[0] = x[0] - DOT_SIZE;
        }
        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (upDirection) {
            y[0] = y[0] - DOT_SIZE;
        }
        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        // 240 + 10 = 250
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && (!downDirection)) {
                leftDirection = false;
                upDirection = true;
                rightDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }

}
