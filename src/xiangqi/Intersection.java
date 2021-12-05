package xiangqi;

import java.util.Objects;

public class Intersection {
    private Piece piece;

    public Intersection() {}
    public Intersection(Piece p) {
        this.piece = p;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean estOccupee(){
        if (piece == null){
            return false;
        }
        return true;
    }

    public boolean estOccupeeAdv(String couleur){
        if (estOccupee()){
            if (piece.getCouleur() == couleur)
                return false;
        }
        return true;
    }
}
