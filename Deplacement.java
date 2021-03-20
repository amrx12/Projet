import java.awt.Frame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import javax.swing.Timer;

public class Deplacement extends Frame implements KeyListener, ActionListener {

    int vel; // Vitesse du personnage
    int amplitude = 20;

    final int height = 1180;
    final int width = 660;
    final Timer saut = new Timer(100, this);
    Player p;
    int cpt = 0;
    Stage stage;

    public Deplacement(Stage s) {
        stage = s;
        setSize(1185, 670);
        addKeyListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        p = new Player(new Hitbox(30, 30),
                new Coordonnee(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX() * stage.scale,
                        stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY() * stage.scale),
                "name", 10);

        vel = stage.scale;
    }

    // COLLISIONS

    public void CollisionsUp(Player p, int vel, Timer saut, int cpt) {
        if (p.getCoordonnee().getY() <= 30) {
        } else if ((p.getCoordonnee().getY() > 30) && (p.getCoordonnee().getY() + p.getHitbox().getWidth() < width)) {

            if (stage.stageRep.get(stage.index - 27) instanceof Air) {
                p.getCoordonnee().setY(p.getCoordonnee().getY() - vel);
                stage.index -= 27;

                // Mettre tout ca dans une fonction ?
                if (stage.itemRep.get(stage.index) == null) {

                } else if (stage.itemRep.get(stage.index) instanceof Piece) {
                    p.incrementScoreByX(1);

                } else if (stage.itemRep.get(stage.index) instanceof Piege) {
                    p.coords.setX(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX() * vel);
                    p.coords.setY(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY() * vel);
                    stage.index = stage.getIndexDepart();
                    // METTRE LE SCORE A 0

                } else if (stage.itemRep.get(stage.index) instanceof Flag) {
                    // AFFICHER LE NIVEAU SUIVANT
                }

            } else {
                System.out.println("MUR");
                // COLLISION MUR
            }

            // Le saut marche mais il est bloqué pour l'instant pour pouvoir
            // résoudre un pb d'affichage -> actualisation des obstacles

            // Plutot que de générer les obstacles a chaques mouvements il
            // faudra qu'ils soient générer une seule fois au début (fluidité du jeu)

            // SAUT : 4 LIGNES DU DESSOUS
            // saut.setActionCommand("Saut");
            // saut.stop();
            // saut.start();
            // cpt = 0;

        }
    }

    public void CollisionsDown(Player p, int vel, int width) {
        if (p.getCoordonnee().getY() + p.getHitbox().getWidth() >= width) {

        } else if ((p.getCoordonnee().getY() > 30) && (p.getCoordonnee().getY() + p.getHitbox().getWidth() < width)) {

            p.getCoordonnee().setY(p.getCoordonnee().getY() + vel);

        }
    }

    public void CollisionsRight(Player p, int vel, int height) {
        if (p.getCoordonnee().getX() + p.getHitbox().getHeight() >= height) {

        } else if ((p.getCoordonnee().getY() > 10) && (p.getCoordonnee().getX() + p.getHitbox().getHeight() < height)) {

            if (stage.stageRep.get(stage.index + 1) instanceof Air) {
                p.getCoordonnee().setX(p.getCoordonnee().getX() + vel);
                stage.index += 1;

                // Mettre tout ca dans une fonction ?
                if (stage.itemRep.get(stage.index) == null) {

                } else if (stage.itemRep.get(stage.index) instanceof Piece) {
                    p.incrementScoreByX(1);

                } else if (stage.itemRep.get(stage.index) instanceof Piege) {
                    p.coords.setX(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX() * vel);
                    p.coords.setY(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY() * vel);
                    stage.index = stage.getIndexDepart();
                    // METTRE LE SCORE A 0

                } else if (stage.itemRep.get(stage.index) instanceof Flag) {
                    // AFFICHER LE NIVEAU SUIVANT
                }

            } else {
                System.out.println("MUR");
                // COLLISION MUR
            }
        }
    }

    public void CollisionsLeft(Player p, int vel) {
        if (p.getCoordonnee().getX() <= 10) {

        } else if ((p.getCoordonnee().getY() > 10) && (p.getCoordonnee().getX() + p.getHitbox().getHeight() < height)) {

            if (stage.stageRep.get(stage.index - 1) instanceof Air) {
                p.getCoordonnee().setX(p.getCoordonnee().getX() - vel);
                stage.index -= 1;

                // Mettre tout ca dans une fonction ?
                if (stage.itemRep.get(stage.index) == null) {

                } else if (stage.itemRep.get(stage.index) instanceof Piece) {
                    p.incrementScoreByX(1);

                } else if (stage.itemRep.get(stage.index) instanceof Piege) {
                    p.coords.setX(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getX() * vel);
                    p.coords.setY(stage.stageRep.get(stage.getIndexDepart()).getCoordonnee().getY() * vel);
                    stage.index = stage.getIndexDepart();
                    // METTRE LE SCORE A 0

                } else if (stage.itemRep.get(stage.index) instanceof Flag) {
                    // AFFICHER LE NIVEAU SUIVANT
                }

            } else {
                System.out.println("MUR");
                // COLLISION MUR
            }
        }
    }

    // EVENT

    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        switch (keyCode) {
        case KeyEvent.VK_UP:
            CollisionsUp(p, vel, saut, cpt);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;
        case KeyEvent.VK_DOWN:
            CollisionsDown(p, vel, width);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;
        case KeyEvent.VK_LEFT:
            CollisionsLeft(p, vel);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;
        case KeyEvent.VK_RIGHT:
            CollisionsRight(p, vel, height);
            System.out.println("x = " + p.getCoordonnee().getX() + ", y = " + p.getCoordonnee().getY());
            break;
        }
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Saut")) {
            if (cpt <= amplitude) {

                if (cpt < amplitude / 2) {
                    // UTILISER LES COLLISIONS
                    p.getCoordonnee().setY(p.getCoordonnee().getY() - vel);
                    vel--;
                    // System.out.println("y = " + y + " - t = " + t);
                } else if (cpt >= amplitude / 2) {
                    // UTILISER LES COLLISIONS
                    vel++;
                    p.getCoordonnee().setY(p.getCoordonnee().getY() + vel);
                }
                cpt++;
                repaint();
                System.out.println(vel);
            }
        }
    }

}

// Le code est inspiré de :
// https://waytolearnx.com/2020/05/keylistener-java.html
// https://youtu.be/9sKY5_3HtUc
// https://waytolearnx.com/2020/05/comment-tracer-des-lignes-rectangles-et-cercles-dans-jframe.html