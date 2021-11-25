package xiangqi;

public class Roi extends Piece{
    public Roi(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        if (getCouleur() == "noir") {
            if (arrivee.getColonne() >= 0 && arrivee.getColonne() < 3 && arrivee.getLigne() > 2 && arrivee.getLigne() < 6) {
                if (depart.getColonne() == arrivee.getColonne() + 1 && arrivee.getLigne() == depart.getLigne())
                    return true;
                else if (depart.getColonne() == arrivee.getColonne() - 1 && arrivee.getLigne() == depart.getLigne())
                    return true;
                else if (depart.getLigne() == arrivee.getLigne() + 1 && depart.getColonne() == arrivee.getColonne())
                    return true;
                else if (depart.getLigne() == arrivee.getLigne() - 1 && depart.getColonne() == arrivee.getColonne())
                    return true;
            }
        }

        else if (getCouleur() == "rouge"){
            if (arrivee.getColonne() <= 9 && arrivee.getColonne() > 6 && arrivee.getLigne() > 2 && arrivee.getLigne() < 6) {
                if (depart.getColonne() == arrivee.getColonne() + 1 && arrivee.getLigne() == depart.getLigne())
                    return true;
                else if (depart.getColonne() == arrivee.getColonne() - 1 && arrivee.getLigne() == depart.getLigne())
                    return true;
                else if (depart.getLigne() == arrivee.getLigne() + 1 && depart.getColonne() == arrivee.getColonne())
                    return true;
                else if (depart.getLigne() == arrivee.getLigne() - 1 && depart.getColonne() == arrivee.getColonne())
                    return true;
            }
        }

        return false;
    }
}
