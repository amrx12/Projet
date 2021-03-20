import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Bloc {

    public Grass(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    // bloc vert

    public Graphics renderBloc(Graphics g, int scale) {
        // TODO Auto-generated method stub
        // g.setColor(Color.green);

        float[] cols = new float[3];
        Color.RGBtoHSB(55, 180, 27, cols);

        g.setColor(Color.getHSBColor(cols[0], cols[1], cols[2]));
        return super.renderBloc(g, scale);
    }

}
