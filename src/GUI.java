import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        JPanel gui = new JPanel();
        gui.setLayout(null);
        gui.setBackground(Color.CYAN);
        makeGUIX(gui,0);
        makeGUIY(gui,0);

        JLabel p = new JLabel(new ImageIcon("src/pirate.png"));
        p.setLayout(null);
        p.setBounds(450, 450, 50, 50);
        p.setBackground(Color.RED);
        gui.add(p);

        JLabel shop = new JLabel(new ImageIcon("src/Shop.png"));
        shop.setLayout(null);
        shop.setBounds(500, 450, 50, 50);
        gui.add(shop);

        f.add(gui);
        f.setSize(1000,1000);
        f.setVisible(true);
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
                    p.setLocation(p.getX(), p.getY() - 50);
                }
                else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
                    p.setLocation(p.getX(), p.getY() + 50);
                }
                else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
                    p.setLocation(p.getX() - 50, p.getY());
                }
                else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
                    p.setLocation(p.getX() + 50, p.getY());
                }
                if (p.getX() <  -50) {
                    p.setLocation(1050, p.getY());
                }
                if (p.getX() >  1050) {
                    p.setLocation(-50, p.getY());
                }
                if (p.getY() <  -50) {
                    p.setLocation(p.getX(), 1050);
                }
                if (p.getY() >  1050) {
                    p.setLocation(p.getX(), -50);
                }
            }
        });
    }
    public static int makeGUIX(JPanel gui, int X) {
        JPanel line = new JPanel();
        line.setBounds(X, 0, 5, 1000);
        gui.add(line);
        if (X == 1000) {
            return 0;
        } return makeGUIX(gui, X + 50);
    }

    public static int makeGUIY(JPanel gui, int Y) {
        JPanel line = new JPanel();
        line.setBounds(0, Y, 1000, 5);
        gui.add(line);
        if (Y == 1000) {
            return 0;
        } return makeGUIY(gui,Y + 50);
    }
}