import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// TEST POUR FAIRE BOUGER UN PERSONNAGE DANS UNE JFrame
public class KeyListenerTest extends JFrame implements KeyListener {

    JPanel panel;
    int x, y, w, h;
    Graphics rect;
    int pas = 5; // Le pas du personnage

    KeyListenerTest(int vx, int vy, int vw, int vh) {

        x = vx;
        y = vy;
        w = vw;
        h = vw;

        panel = new JPanel();
        this.setTitle("TEST");

        add(panel);
        setSize(1000, 700);
        setLayout(null);
        setVisible(true);
        addKeyListener(this);

    }

    public void paint(Graphics rect) {
        rect.drawRect(x, y, w, h); // (int x, int y, int width, int height)
        // rect.drawRect(x, y, w, h);
        // rect.setColor(Color.CYAN);
        // rect.fillRect(x, y, 50, 30);
    }

    public void moveUp(Graphics g) {
        System.out.println("up");
        y = y - pas;
        repaint();
    }

    public void moveDown(Graphics g) {
        System.out.println("down");
        y = y + pas;
        repaint();
    }

    public void moveRight(Graphics g) {
        System.out.println("right");
        x = x + pas;
        repaint();
    }

    public void moveLeft(Graphics g) {
        System.out.println("left");
        x = x - pas;
        repaint();
    }

    ////////////////////////////////////////////////////

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp(rect);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown(rect);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight(rect);
            panel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft(rect);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    ////////////////////////////////////////////////////

    public static void main(String[] args) {
        // position du personnage (rectangle)
        int x = 200;
        int y = 200;
        int w = 200;
        int h = 180;
        new KeyListenerTest(x, y, w, h);
    }
}

// Le code est inspiré de :
// https://waytolearnx.com/2020/05/keylistener-java.html
// https://youtu.be/9sKY5_3HtUc
// https://waytolearnx.com/2020/05/comment-tracer-des-lignes-rectangles-et-cercles-dans-jframe.html
