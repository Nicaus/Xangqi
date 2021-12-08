package xiangqi;

public class Bombarde extends Piece{
    public Bombarde(String nom, String couleur) {
        super(nom, couleur);
    }

    @Override
    public boolean estValide(Position depart, Position arrivee) {
        if (depart.getColonne() == arrivee.getColonne()){       //meme colonne
            return true;
        } else if (depart.getLigne() == arrivee.getLigne()){    //meme ligne
            return true;
        } else {
            return false;
        }
    }
}
