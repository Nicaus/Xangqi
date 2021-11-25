package xiangqi;

public class Echequier implements MethodesEchiquier {
    private Intersection[][] jeu;

    public Echequier(Intersection[][] jeu) {
        this.jeu = jeu;
    }

    @Override
    public void debuter() {
        jeu[0][0].setPiece(new Char("t1", "noir"));
        jeu[1][0].setPiece(new Cavalier("c1", "noir"));
        jeu[2][0].setPiece(new Elephant("e1", "noir"));
        jeu[3][0].setPiece(new Mandarin("m1", "noir"));
        jeu[4][0].setPiece(new Roi("r", "noir"));
        jeu[5][0].setPiece(new Mandarin("m2", "noir"));
        jeu[6][0].setPiece(new Elephant("e2", "noir"));
        jeu[7][0].setPiece(new Cavalier("c2", "noir"));
        jeu[8][0].setPiece(new Char("t2", "noir"));
        jeu[1][2].setPiece(new Bombarde("b1", "noir"));
        jeu[7][2].setPiece(new Bombarde("b2", "noir"));
        jeu[0][3].setPiece(new Pion("p1", "noir"));
        jeu[2][3].setPiece(new Pion("p2", "noir"));
        jeu[4][3].setPiece(new Pion("p3", "noir"));
        jeu[6][3].setPiece(new Pion("p4", "noir"));
        jeu[8][3].setPiece(new Pion("p5", "noir"));

        jeu[0][9].setPiece(new Char("t1", "rouge"));
        jeu[1][9].setPiece(new Cavalier("c1", "rouge"));
        jeu[2][9].setPiece(new Elephant("e1", "rouge"));
        jeu[3][9].setPiece(new Mandarin("m1", "rouge"));
        jeu[4][9].setPiece(new Roi("r", "rouge"));
        jeu[5][9].setPiece(new Mandarin("m2", "rouge"));
        jeu[6][9].setPiece(new Elephant("e2", "rouge"));
        jeu[7][9].setPiece(new Cavalier("c2", "rouge"));
        jeu[8][9].setPiece(new Char("t2", "rouge"));
        jeu[1][7].setPiece(new Bombarde("b1", "rouge"));
        jeu[7][7].setPiece(new Bombarde("b2", "rouge"));
        jeu[0][6].setPiece(new Pion("p1", "rouge"));
        jeu[2][6].setPiece(new Pion("p2", "rouge"));
        jeu[4][6].setPiece(new Pion("p3", "rouge"));
        jeu[6][6].setPiece(new Pion("p4", "rouge"));
        jeu[8][6].setPiece(new Pion("p5", "rouge"));
    }

    @Override
    public boolean cheminPossible(Position depart, Position arrivee) {
        //vers le haut
        int diffLigne = arrivee.getLigne() - depart.getLigne();
        int diffColonne = arrivee.getColonne() - depart.getColonne();
        int nbPiecesEntre = 0;

        if (diffColonne == 0) {
            if (diffLigne < 0) {
                for (int i = depart.getLigne() - 1; i > arrivee.getLigne(); i--) {
                    if (jeu[i][depart.getColonne()].estOccupee()) {
                        if (jeu[depart.getLigne()][depart.getColonne()].getPiece() instanceof Bombarde){
                            //verifier que la ccase d'arrivee est occupee par l'ennemi
                            if (jeu[arrivee.getLigne()][arrivee.getColonne()].estOccupeeAdv((jeu[depart.getLigne()][depart.getColonne()].getPiece()).getCouleur())) {
                                nbPiecesEntre += 1;
                                return true;
                            }
                            else
                                return false;

                        }
                        else { // si ce n'est pas une bombarde
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean roisNePouvantPasEtreFaceAFace(Position depart, Position arrivee) {
        return false;
    }
}
