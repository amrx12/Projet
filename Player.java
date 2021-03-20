import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entite {
    private int score;
    private String name;

    public Player(Hitbox h, Coordonnee c, String name, int ms) {
        super(h, c, ms);
        this.name = name;
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public void incrementScoreByX(int x) {
        this.score += x;
    }

    public void decrementScoreByX(int x) {
        if (this.score <= x) {
            this.score = 0;
        } else {
            this.score -= x;
        }
    }

    public String getName() {
        return this.name;
    }

    public Graphics renderPlayer(Graphics g, int scale) {
        // g.drawRect(scale * coords.getX(), scale * coords.getY(), scale *
        // getHitbox().getWidth(),
        // scale * getHitbox().getHeight());

        g.drawRect(coords.getX(), coords.getY(), getHitbox().getWidth(), getHitbox().getHeight());

        g.setColor(Color.BLACK);

        // g.fillRect(scale * coords.getX(), scale * coords.getY(), scale *
        // getHitbox().getWidth(),
        // scale * getHitbox().getHeight());

        g.fillRect(coords.getX(), coords.getY(), getHitbox().getWidth(), getHitbox().getHeight());

        return g;
    }

}