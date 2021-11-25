package xiangqi;

public class Char extends Piece{

    public Char(String nom, String couleur){
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
