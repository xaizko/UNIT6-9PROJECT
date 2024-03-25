import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        JPanel gui = new JPanel();
        gui.setLayout(null);
        gui.setBackground(Color.CYAN);

        JLabel p = new JLabel(new ImageIcon("src/pirate.png"));
        p.setLayout(null);
        p.setBounds(450, 450, 61, 50);
        p.setBackground(Color.RED);
        gui.add(p);

        f.add(gui);
        f.setSize(1000,1000);
        f.setVisible(true);
        f.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_W) {
                    p.setLocation(p.getX(), p.getY() - 50);
                }
                else if (keyCode == KeyEvent.VK_S) {
                    p.setLocation(p.getX(), p.getY() + 50);
                }
                else if (keyCode == KeyEvent.VK_A) {
                    p.setLocation(p.getX() - 50, p.getY());
                }
                else if (keyCode == KeyEvent.VK_D) {
                    p.setLocation(p.getX() + 50, p.getY());
                }
            }
        });
    }

}