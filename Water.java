import java.awt.Color;
import java.awt.Graphics;

public class Water extends Bloc {

    public Water(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Graphics renderBloc(Graphics g, int scale) {
        // TODO Auto-generated method stub
        g.setColor(Color.blue);
        return super.renderBloc(g, scale);
    }
}
