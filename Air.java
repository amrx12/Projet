import java.awt.Color;
import java.awt.Graphics;

public class Air extends Bloc {
    // bloc de base sans couleur
    public Air(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    public Graphics renderBloc(Graphics g, int scale) {
        float[] cols = new float[3];

        // Color.RGBtoHSB(33, 142, 201, cols);
        Color.RGBtoHSB(46, 189, 243, cols);

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));
        // g.setColor(Color.CYAN);
        return super.renderBloc(g, scale);

        // g.fillRect(this.coords.getX(), this.coords.getY(),
        // this.getHitbox().getWidth(), this.getHitbox().getHeight());

    }
}
