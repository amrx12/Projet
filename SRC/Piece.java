import java.awt.Graphics;
import java.awt.Color;

public class Piece extends Item {

    public Piece(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    public Graphics renderItem(Graphics g, int scale) {
        float[] cols = new float[3];
        // Color.RGBtoHSB(132, 78, 33, cols);
        Color.RGBtoHSB(255, 255, 0, cols);

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));

        g.fillOval(5 + this.getCoordonnee().getX() * scale, 5 + this.getCoordonnee().getY() * scale, scale - 10,
                scale - 10);
        return g;
    }

}
