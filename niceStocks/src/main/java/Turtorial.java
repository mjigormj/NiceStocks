
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Turtorial extends JFrame {

    public Turtorial() {
        setTitle("Graphics");
        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.drawLine(0, 480, 960, 480);
    }

    public static void main(String[] args) {
        Turtorial t = new Turtorial();
    }

}
