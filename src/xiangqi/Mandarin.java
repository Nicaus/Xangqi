package xiangqi;

public class Mandarin extends Piece{
    public Mandarin(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne())
            return true;

        if (getCouleur() == "noir") {
            if (arrivee.getLigne() >= 0 && arrivee.getLigne() < 3 && arrivee.getColonne() > 2 && arrivee.getColonne() < 6) {
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
            if (arrivee.getLigne() <= 9 && arrivee.getLigne() > 6 && arrivee.getColonne() > 2 && arrivee.getColonne() < 6) {
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

