package xiangqi;

import java.util.Objects;

public class Elephant extends Piece{
    public Elephant(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        if (arrivee.getColonne() >= 0 && arrivee.getColonne() <= 9 && arrivee.getLigne() >= 0 && arrivee.getLigne() <= 8) {
            if (Objects.equals(getCouleur(), "noir")) {
                if (arrivee.getLigne() < 5) {
                    if (arrivee.getColonne() == depart.getColonne() + 2) {
                        if (arrivee.getLigne() == depart.getLigne() + 2 || arrivee.getLigne() == depart.getLigne() - 2) {
                            return true;
                        }
                    } else if (arrivee.getColonne() == depart.getColonne() - 2) {
                        if (arrivee.getLigne() == depart.getLigne() + 2 || arrivee.getLigne() == depart.getLigne() - 2) {
                            return true;
                        }
                    }
                }
            }

            if (Objects.equals(getCouleur(), "rouge")) {
                if (arrivee.getLigne() > 4) {
                    if (arrivee.getColonne() == depart.getColonne() + 2) {
                        if (arrivee.getLigne() == depart.getLigne() + 2 || arrivee.getLigne() == depart.getLigne() - 2) {
                            return true;
                        }
                    } else if (arrivee.getColonne() == depart.getColonne() - 2) {
                        if (arrivee.getLigne() == depart.getLigne() + 2 || arrivee.getLigne() == depart.getLigne() - 2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
