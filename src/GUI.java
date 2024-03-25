import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("Demo");
        JPanel gui = new JPanel();
        gui.setLayout(null);
        gui.setBackground(Color.CYAN);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(450, 450, 50, 50);
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
//    public static void keyPressed(KeyEvent e, JPanel panel) {
//        if (e.getKeyCode() == (KeyEvent.VK_A)) {
//            panel.setLocation(panel.getX(), panel.getY() - 50);
//        } else if (e.getKeyCode() == (KeyEvent.VK_S)) {
//            panel.setLocation(panel.getX() - 50, panel.getY());
//        } else if (e.getKeyCode() == (KeyEvent.VK_W)) {
//            panel.setLocation(panel.getX(), panel.getY() + 50);
//        } else if (e.getKeyCode() == (KeyEvent.VK_D)) {
//            panel.setLocation(panel.getX() + 50, panel.getY());
//        }
//    }
}