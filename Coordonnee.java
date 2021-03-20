
public class Coordonnee {
    private int verticalY;
    private int horizontalX;

    public Coordonnee(int x, int y) {
        this.horizontalX = x;
        this.verticalY = y;
    }

    public int getX() {
        return horizontalX;
    }

    public int getY() {
        return verticalY;
    }

    public void setX(int xx) {
        this.horizontalX = xx;
    }

    public void setY(int y) {
        this.verticalY = y;
    }

    public String toString() {
        return "(" + this.horizontalX + "," + this.verticalY + ")";
    }
}
