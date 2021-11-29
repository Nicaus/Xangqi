package xiangqi;

public class Roi extends Piece{
    public Roi(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {

        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne())
            return true;

        if (getCouleur() == "noir") {
            if (arrivee.getLigne() >= 0 && arrivee.getLigne() < 3 && arrivee.getColonne() > 2 && arrivee.getColonne() < 6) {
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
            if (arrivee.getLigne() <= 9 && arrivee.getLigne() > 6 && arrivee.getColonne() > 2 && arrivee.getColonne() < 6) {
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
