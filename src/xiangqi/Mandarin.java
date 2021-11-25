package xiangqi;

public class Mandarin extends Piece{
    public Mandarin(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (getCouleur() == "noir") {
            if (arrivee.getColonne() >= 0 && arrivee.getColonne() < 3 && arrivee.getLigne() > 2 && arrivee.getLigne() < 6) {
                if (arrivee.getColonne() == depart.getColonne() + 1) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1) {
                        return true;
                    }
                }
                else if (arrivee.getColonne() == depart.getColonne() - 1) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1) {
                        return true;
                    }
                }
            }
        }
        else if (getCouleur() == "rouge") {
            if (arrivee.getColonne() <= 9 && arrivee.getColonne() > 6 && arrivee.getLigne() > 2 && arrivee.getLigne() < 6) {
                if (arrivee.getColonne() == depart.getColonne() + 1) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1) {
                        return true;
                    }
                }
                else if (arrivee.getColonne() == depart.getColonne() - 1) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1) {
                        return true;
                    }

                }
            }
        }
        return false;
    }


}

