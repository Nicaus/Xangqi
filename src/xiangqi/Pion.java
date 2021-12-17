package xiangqi;

public class Pion extends Piece{
    public Pion (String nom, String couleur)
    {
        super (nom, couleur);
    }

    public boolean estValide (Position depart, Position arrivee) {
        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne())
            return true;

        else if (getCouleur() == "noir"){
            if (depart.getLigne() <= 4) {
                if ((arrivee.getLigne() - depart.getLigne() == 1) && arrivee.getColonne() == depart.getColonne())
                    return true;
                else
                    return false;
            }
            else { // de l'autre coté de la rivière
                if ((norme(depart, arrivee) <= 1)) {
                    if ( arrivee.getLigne() - depart.getLigne() == -1) // il recule
                        return false;
                    else
                        return true;
                }
                else
                    return false;

            }
        }
        else { // rouge
            if (depart.getLigne() >= 5) {
                if ((arrivee.getLigne() - depart.getLigne() == -1 ) && arrivee.getColonne() == depart.getColonne())
                    return true;
                else
                    return false;
            }
            else { //de l'autre coté de la rivière
                if ((norme(depart, arrivee) <= 1)) {
                    if (arrivee.getLigne() - depart.getLigne() == 1) // il recule
                        return false;
                    else
                        return true;
                }
                else
                    return false;

            }
        }
    }
}
