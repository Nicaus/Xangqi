package xiangqi;

public class Echiquier implements MethodesEchiquier {
    private Intersection[][] jeu;

    public Echiquier() {
        jeu = new Intersection[10][9];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 9; j++){
                jeu[i][j] = new Intersection();
            }
        }
    }

    @Override
    public Intersection getIntersection(int ligne, int colonne){
        return jeu[ligne][colonne];
    }

    @Override
    public void debuter() {
        jeu[0][0].setPiece(new Char("t1", "noir"));
        jeu[0][1].setPiece(new Cavalier("c1", "noir"));
        jeu[0][2].setPiece(new Elephant("e1", "noir"));
        jeu[0][3].setPiece(new Mandarin("m1", "noir"));
        jeu[0][4].setPiece(new Roi("r", "noir"));
        jeu[0][5].setPiece(new Mandarin("m2", "noir"));
        jeu[0][6].setPiece(new Elephant("e2", "noir"));
        jeu[0][7].setPiece(new Cavalier("c2", "noir"));
        jeu[0][8].setPiece(new Char("t2", "noir"));
        jeu[2][1].setPiece(new Bombarde("b1", "noir"));
        jeu[2][7].setPiece(new Bombarde("b2", "noir"));
        jeu[3][0].setPiece(new Pion("p1", "noir"));
        jeu[3][2].setPiece(new Pion("p2", "noir"));
        jeu[3][4].setPiece(new Pion("p3", "noir"));
        jeu[3][6].setPiece(new Pion("p4", "noir"));
        jeu[3][8].setPiece(new Pion("p5", "noir"));

        jeu[9][0].setPiece(new Char("t1", "rouge"));
        jeu[9][1].setPiece(new Cavalier("c1", "rouge"));
        jeu[9][2].setPiece(new Elephant("e1", "rouge"));
        jeu[9][3].setPiece(new Mandarin("m1", "rouge"));
        jeu[9][4].setPiece(new Roi("r", "rouge"));
        jeu[9][5].setPiece(new Mandarin("m2", "rouge"));
        jeu[9][6].setPiece(new Elephant("e2", "rouge"));
        jeu[9][7].setPiece(new Cavalier("c2", "rouge"));
        jeu[9][8].setPiece(new Char("t2", "rouge"));
        jeu[7][1].setPiece(new Bombarde("b1", "rouge"));
        jeu[7][7].setPiece(new Bombarde("b2", "rouge"));
        jeu[6][0].setPiece(new Pion("p1", "rouge"));
        jeu[6][2].setPiece(new Pion("p2", "rouge"));
        jeu[6][4].setPiece(new Pion("p3", "rouge"));
        jeu[6][6].setPiece(new Pion("p4", "rouge"));
        jeu[6][8].setPiece(new Pion("p5", "rouge"));
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {

        if (depart.getLigne() == arrivee.getLigne() && depart.getColonne() == arrivee.getColonne()){
            return true;
        }
        if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Cavalier){
            return cavalierMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Elephant){
            return elephantMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Mandarin){
            return mandarinMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Pion){
            return pionMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Char){
            return charMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Roi){
            return roiMouvVal(depart, arrivee);
        }
        else if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Bombarde){
            return bombardeMouvVal(depart, arrivee);
        }
        return false;
    }

    public boolean cavalierMouvVal(Position depart, Position arrivee){
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();
        // vers haut
        if (arrivee.getLigne() == depart.getLigne() - 2) {
            if (jeu[depart.getLigne() - 1][depart.getColonne()].estOccupee()) {
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        //vers le bas
        if (arrivee.getLigne() == depart.getLigne() + 2) {
            if (jeu[depart.getLigne() + 1][depart.getColonne()].estOccupee()) {
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        //vers left
        if (arrivee.getColonne() == depart.getColonne() - 2){
            if (jeu[depart.getLigne()][depart.getColonne() - 1].estOccupee()) {
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        //vers right
        if (arrivee.getColonne() == depart.getColonne() + 2){
            if (jeu[depart.getLigne()][depart.getColonne() + 1].estOccupee()) {
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        return false;
    }

    public boolean elephantMouvVal(Position depart, Position arrivee){
        // vers upleft
        if (depart.getLigne() - 2 == arrivee.getLigne() && depart.getColonne() - 2 == arrivee.getColonne()) {
            if (jeu[depart.getLigne() - 2][depart.getColonne() -2].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else if (jeu[depart.getLigne() - 1][depart.getColonne() - 1].estOccupee()){
                return false;

            }
            else
                return true;
        }


        // vers upright
        if (depart.getLigne() - 2 == arrivee.getLigne() && depart.getColonne() + 2 == arrivee.getColonne()){
            if (jeu[depart.getLigne() - 2][depart.getColonne() + 2].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else if (jeu[depart.getLigne() - 1][depart.getColonne() + 1].estOccupee()){
                return false;
            }
            else
                return true;
        }


        // vers downleft
        if (depart.getLigne() + 2 == arrivee.getLigne() && depart.getColonne() - 2 == arrivee.getColonne()){
            if (jeu[depart.getLigne() + 2][depart.getColonne() - 2].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else if (jeu[depart.getLigne() + 1][depart.getColonne() - 1].estOccupee()){
                return false;

            }
            else
                return true;
        }


        // vers downright
        if (depart.getLigne() + 2 == arrivee.getLigne() && depart.getColonne() + 2 == arrivee.getColonne()){
            if (jeu[depart.getLigne() + 2][depart.getColonne() + 2].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else if (jeu[depart.getLigne() + 1][depart.getColonne() + 1].estOccupee()){
                return false;
            }
            else
                return true;
        }


        return false;
    }

    public boolean mandarinMouvVal(Position depart, Position arrivee){
        //vers upleft
        if (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()){
            if (jeu[depart.getLigne() - 1][depart.getColonne() - 1].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers upright
        if (depart.getLigne() - 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()){
            if (jeu[depart.getLigne() - 1][depart.getColonne() + 1].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers downleft
        if (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() - 1 == arrivee.getColonne()){
            if (jeu[depart.getLigne() + 1][depart.getColonne() - 1].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers downright
        if (depart.getLigne() + 1 == arrivee.getLigne() && depart.getColonne() + 1 == arrivee.getColonne()){
            if (jeu[depart.getLigne() + 1][depart.getColonne() + 1].estOccupee()){
                return false;
            }
            else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        return false;
    }

    public boolean pionMouvVal(Position depart, Position arrivee){
        // vers le haut
        if (depart.getLigne() - 1 == arrivee.getLigne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers le bas
        if (depart.getLigne() + 1 == arrivee.getLigne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers left
        if (depart.getColonne() - 1 == arrivee.getColonne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers right
        if (depart.getColonne() + 1 == arrivee.getColonne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        return false;
    }

    public boolean charMouvVal(Position depart, Position arrivee){
        if (jeu[depart.getLigne()][depart.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
            return true;

        // vers le haut
        for (int i = depart.getLigne() - 1; i > arrivee.getLigne(); i--){
            if (jeu[i][depart.getColonne()].estOccupee()) {
                return false;
            }
        }

        // vers le bas
        for (int i = depart.getLigne() + 1; i < arrivee.getLigne(); i++){
            if (jeu[i][depart.getColonne()].estOccupee()) {
                return false;
            }
        }

        // vers left
        for (int i = depart.getColonne() - 1; i > arrivee.getColonne(); i--){
            if (jeu[depart.getLigne()][i].estOccupee()) {
                return false;
            }
        }

        // vers right
        for (int i = depart.getColonne() + 1; i < arrivee.getColonne(); i++){
            if (jeu[depart.getLigne()][i].estOccupee()) {
                return false;
            }
        }

        if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur()))
            return true;

        return false;
    }

    public boolean roiMouvVal(Position depart, Position arrivee){
        // vers le haut
        if (depart.getLigne() - 1 == arrivee.getLigne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers le bas
        if (depart.getLigne() + 1 == arrivee.getLigne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers left
        if (depart.getColonne() - 1 == arrivee.getColonne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        // vers right
        if (depart.getColonne() + 1 == arrivee.getColonne()) {
            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv(jeu[depart.getLigne()][depart.getColonne()].getPiece().getCouleur())) {
                    return true;
                }
                else
                    return false;
            }
            else
                return true;
        }

        return false;
    }

    public boolean bombardeMouvVal(Position depart, Position arrivee){
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();
        int nbPiecesEntre = 0;

        //vers le haut
        for (int i = depart.getLigne() - 1; i >= arrivee.getLigne(); i--) {
            if (jeu[i][depart.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur()) && nbPiecesEntre == 1) {
                    if (jeu[i][depart.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                    return true;
                }
                else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur())) {
                    nbPiecesEntre++;
                    if (jeu[i][arrivee.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                        return false;
                }
            }
        }

        // vers le bas
        for (int i = depart.getLigne() + 1; i <= arrivee.getLigne(); i++) {
            if (jeu[i][depart.getColonne()].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur()) && nbPiecesEntre == 1) {
                    if (jeu[i][depart.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                        return true;
                }
                else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur())) {
                    nbPiecesEntre++;
                    if (jeu[i][arrivee.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                        return false;
                }
            }
        }

        // vers left
        for (int i = depart.getColonne() - 1; i >= arrivee.getColonne(); i--) {
            if (jeu[depart.getLigne()][i].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur()) && jeu[depart.getLigne()][i] == jeu[arrivee.getLigne()][arrivee.getColonne()]) {
                    if (nbPiecesEntre == 1)
                        return true;
                }
                else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur())) {
                    nbPiecesEntre++;
                    if (jeu[i][arrivee.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                        return false;
                }
            }
        }

        // vers right
        for (int i = depart.getColonne() + 1; i <= arrivee.getColonne(); i++) {
            if (jeu[depart.getLigne()][i].estOccupee()) {
                if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur()) && jeu[depart.getLigne()][i] == jeu[arrivee.getLigne()][arrivee.getColonne()]) {
                    if (nbPiecesEntre == 1)
                        return true;
                }
                else if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur())) {
                    nbPiecesEntre++;
                    if (jeu[i][arrivee.getColonne()] == jeu[arrivee.getLigne()][arrivee.getColonne()])
                        return false;
                }
            }
        }

        return false;
    }


    @Override
    public boolean roisNePouvantPasEtreFaceAFace(Position depart, Position arrivee) {
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();
        int nbRoi = 0;
        int j = 0;

        if (diffColonne == 0){
            for (int i = 0; i < 10; i++) {
                if (jeu[i][arrivee.getColonne()].estOccupee()) {
                    if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Roi) {
                        if (nbRoi == 1)
                            return true;
                        nbRoi++;
                    }
                }
            }
        }

        return false;
    }
}
