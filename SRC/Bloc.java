import java.awt.Graphics;

import java.awt.Color;

public abstract class Bloc extends Entite {

    public Bloc(Coordonnee c) {
        super(new Hitbox(1, 1), c, 0);

    }

    public Graphics renderBloc(Graphics g, int scale) {
        g.drawRect(scale * coords.getX(), scale * coords.getY(), scale * getHitbox().getWidth(),
                scale * getHitbox().getHeight());

        g.fillRect(scale * coords.getX(), scale * coords.getY(), scale * getHitbox().getWidth(),
                scale * getHitbox().getHeight());
        return g;
    }
}
