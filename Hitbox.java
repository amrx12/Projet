public class Hitbox {
    private int height;
    private int width;

    public Hitbox(int h, int w) {
        this.height = h;
        this.width = w;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void resize(int h, int w) {
        this.height = h;
        this.width = w;
    }

    public String toString() {
        return "hauteur= " + this.height + ", largeur= " + this.width;
    }
}