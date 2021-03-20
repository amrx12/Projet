import java.awt.Color;
import java.awt.Graphics;

public class Dirt extends Bloc {

    public Dirt(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Graphics renderBloc(Graphics g, int scale) {
        // TODO Auto-generated method stub
        float[] cols = new float[3];
        // Color.RGBtoHSB(132, 78, 33, cols);
        Color.RGBtoHSB(122, 69, 0, cols);

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));

        return super.renderBloc(g, scale);
    }
}
