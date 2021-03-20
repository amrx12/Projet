
// package src;
import java.awt.Color;
import java.awt.Graphics;

public class Piege extends Item {

    public Piege(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    public Graphics renderItem(Graphics g, int scale) {
        float[] cols = new float[3];
        // Color.RGBtoHSB(132, 78, 33, cols);
        Color.RGBtoHSB(175, 175, 175, cols);// gris clair

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));

        g.fillOval(5 + this.getCoordonnee().getX() * scale, 5 + this.getCoordonnee().getY() * scale, scale - 10,
                scale - 10);

        Color.RGBtoHSB(80, 80, 80, cols);// gris foncé

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));

        g.fillOval(10 + this.getCoordonnee().getX() * scale, 10 + this.getCoordonnee().getY() * scale, scale - 20,
                scale - 20);

        Color.RGBtoHSB(20, 20, 20, cols);// gris très foncé

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));

        g.fillOval(28 + this.getCoordonnee().getX() * scale, 28 + this.getCoordonnee().getY() * scale, scale - 56,
                scale - 56);
        return g;
    }
}
