import java.io.File;
import java.io.IOException;

public class MainAffichageNiveau {
    public static void main(String[] args) throws IOException {
        Stage s = new Stage(new File("../Ressources/Niveau1.txt"), new File("../Ressources/Niveau1_objets.txt"));
        s.toFrame().show();
    }
}
