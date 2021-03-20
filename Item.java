import java.awt.Graphics;

public abstract class Item extends Bloc {

    public Item(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    public Graphics renderItem(Graphics g, int scale) {
        return g;
    }
}
