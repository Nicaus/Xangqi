package xiangqi;

public class Cavalier extends Piece{

    public Cavalier(String nom, String couleur) {
        super(nom, couleur);
    }

    static void mouvement() {
        System.out.println("I just got executed!");
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne())
            return true;

        if (arrivee.getColonne() >= 0 && arrivee.getColonne() <= 9 && arrivee.getLigne() >= 0 && arrivee.getLigne() <= 8) {
            if (arrivee.getColonne() == depart.getColonne() + 2 && arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getColonne() == depart.getColonne() + 2 && arrivee.getLigne() == depart.getLigne() + 1) {
                return true;
            }
            else if (arrivee.getColonne() == depart.getColonne() - 2 && arrivee.getLigne() == depart.getLigne() - 1 || arrivee.getColonne() == depart.getColonne() - 2 && arrivee.getLigne() == depart.getLigne() + 1) {
                return true;
            }
            else if (arrivee.getLigne() == depart.getLigne() - 2 && arrivee.getColonne() == depart.getColonne() + 1 || arrivee.getLigne() == depart.getLigne() - 2 && arrivee.getColonne() == depart.getColonne() - 1) {
                return true;
            }
            else if (arrivee.getLigne() == depart.getLigne() + 2 && arrivee.getColonne() == depart.getColonne() + 1 || arrivee.getLigne() == depart.getLigne() + 2 && arrivee.getColonne() == depart.getColonne() - 1) {
                return true;
            }
        }
        return false;
    }
}
