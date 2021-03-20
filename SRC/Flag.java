import java.awt.Graphics;
import java.awt.Color;

public class Flag extends Item {

    public Flag(Coordonnee c) {
        super(c);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Graphics renderItem(Graphics g, int scale) {
        int absBarreDrapeau = 15;
        int ordBarreDrapeauDebut = 02;
        int ordBarreDrapeauFin = 42;
        int absBoutDrapeau = 35;
        int ordBoutDrapeau = 25;
        g.setColor(Color.green);
        g.drawLine(this.getCoordonnee().getX() * scale + absBarreDrapeau,
                this.getCoordonnee().getY() * scale + ordBarreDrapeauDebut,
                this.getCoordonnee().getX() * scale + absBarreDrapeau,
                this.getCoordonnee().getY() * scale + ordBarreDrapeauFin);
        g.drawLine(this.getCoordonnee().getX() * scale + absBarreDrapeau,
                this.getCoordonnee().getY() * scale + ordBarreDrapeauDebut,
                this.getCoordonnee().getX() * scale + absBoutDrapeau,
                this.getCoordonnee().getY() * scale + ordBoutDrapeau);
        g.drawLine(this.getCoordonnee().getX() * scale + absBarreDrapeau,
                this.getCoordonnee().getY() * scale + ordBoutDrapeau,
                this.getCoordonnee().getX() * scale + absBoutDrapeau,
                this.getCoordonnee().getY() * scale + ordBoutDrapeau);

        return g;

    }
}
