package xiangqi;

public class Pion extends Piece{

    public Pion(String nom, String couleur){
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        if (arrivee.getColonne() >= 0 && arrivee.getColonne() <= 9 && arrivee.getLigne() >= 0 && arrivee.getLigne() <= 8) {
            if (getCouleur() == "noir") {
                if (arrivee.getColonne() <= 4 && depart.getColonne() < 5) {
                    if (arrivee.getColonne() == depart.getColonne() + 1) {
                        return true;
                    }
                } else if (depart.getColonne() > 4) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getColonne() == depart.getColonne() + 1) {
                        return true;
                    }
                }
            } else if (getCouleur() == "rouge") {
                if (arrivee.getColonne() > 4 && depart.getColonne() > 5) {
                    if (arrivee.getColonne() == depart.getColonne() - 1) {
                        return true;
                    }
                } else if (depart.getColonne() < 5) {
                    if (arrivee.getLigne() == depart.getLigne() + 1 || arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getColonne() == depart.getColonne() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
