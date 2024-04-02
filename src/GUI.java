import java.awt.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel ocean;
    private JPanel shop;
    private JPanel mobBattle;
    private JPanel bossBattle;
    public GUI() {
        ocean = new JPanel();
        ocean.setLayout(null);
        ocean.setSize(1000, 1000);
        ocean.setBackground(Color.CYAN);
        makeGrid(ocean, 0);
        shop = new JPanel();
        mobBattle = new JPanel();
        bossBattle = new JPanel();
    }

    public JPanel getOcean() {
        return ocean;
    }

    public JPanel getShop() {
        return shop;
    }
    public JPanel getMobBattle() {
        return mobBattle;
    }
    public JPanel getBossBattle() {
        return bossBattle;
    }

    public int makeGrid(JPanel gui, int X) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(X, 0, 5, 1000);
        gui.add(line);
        if (X == 1000) {
            return finishGrid(gui, 0);
        } return makeGrid(gui, X + 50);
    }

    private int finishGrid(JPanel gui, int Y) {
        JPanel line = new JPanel();
        line.setBackground(Color.LIGHT_GRAY);
        line.setBounds(0, Y, 1000, 5);
        gui.add(line);
        if (Y == 1000) {
            return 0;
        } return finishGrid(gui,Y + 50);
    }
}