import java.io.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.util.List;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import java.awt.Frame;
import java.awt.Graphics;

public class Stage {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final double width = screenSize.getWidth();
    final double height = screenSize.getHeight();
    final int scale = (int) height / 17;
    public List<Bloc> stageRep;
    public List<Item> itemRep;
    public int index; // index du bloc ou se trouve le joueur
    private int indexDepart;

    public Stage(File stage, File items) throws IOException {
        File f = stage;
        stageRep = new ArrayList<Bloc>();
        itemRep = new ArrayList<Item>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int ligne = 0;// Compteur de lignes
            Bloc bloc;
            while (br.ready()) {
                String l = br.readLine();

                for (int i = 0; i < l.length(); i++) {
                    Coordonnee tempCord = new Coordonnee(i, ligne);
                    switch (l.charAt(i)) {
                    case ('0'):
                        bloc = new Air(tempCord);
                        break;
                    case ('1'):
                        bloc = new Grass(tempCord);
                        break;
                    case ('2'):
                        bloc = new Dirt(tempCord);
                        break;
                    case ('3'):
                        bloc = new Water(tempCord);
                        break;
                    default:
                        bloc = new Air(tempCord);
                        break;
                    }
                    stageRep.add(bloc);
                }
                ligne += 1;
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        ///////////////////////////////////

        f = items;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int ligne = 0;// Compteur de lignes
            Item item;
            int idx = 0;
            while (br.ready()) {
                String l = br.readLine();

                for (int i = 0; i < l.length(); i++, idx++) {
                    Coordonnee tempCord = new Coordonnee(i, ligne);
                    switch (l.charAt(i)) {
                    case ('1'):
                        item = new Piege(tempCord);
                        itemRep.add(item);
                        break;
                    case ('2'):
                        item = new Piece(tempCord);
                        itemRep.add(item);
                        break;

                    case ('3'):
                        item = new Flag(tempCord);
                        itemRep.add(item);
                        break;

                    case ('4'):
                        item = new Depart(tempCord);
                        itemRep.add(item);
                        this.index = idx;
                        this.indexDepart = this.index;
                        break;

                    default:
                        itemRep.add(null);
                        break;
                    }

                }
                ligne += 1;
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public int getIndexDepart() {
        return indexDepart;
    }

    public Frame toFrame() {
        Deplacement f = new Deplacement(this) {
            public void paint(Graphics g) {
                for (Bloc e : stageRep) {
                    g = e.renderBloc(g, scale);
                }
                for (Item e : itemRep) {
                    if (e != null) {
                        g = e.renderItem(g, scale);
                    }
                }
                p.renderPlayer(g, scale);
            }
        };
        return f;
    }

}
