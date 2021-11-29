package xiangqi;

import org.junit.Test;

import static org.junit.Assert.*;

public class XiangqiTest {

    Roi r, r2;
    Mandarin m1, m2;
    Elephant e1, e2;
    Cavalier c1, c2;
    Char t1, t2;
    Pion p1, p2, p3, p4, p5;
    Bombarde b1, b2;


    @org.junit.Before
    public void setUp() throws Exception {

        r = new Roi("r", "rouge");
        r2 = new Roi("r2", "noir");

        m1 = new Mandarin("m1", "rouge");
        m2 = new Mandarin("m2", "noir");

        e1 = new Elephant("e1", "rouge");
        e2 = new Elephant("e2", "noir");

        c1 = new Cavalier("c1", "rouge");
        c2 = new Cavalier("c2", "noir");

        t1 = new Char("t1", "rouge");
        t2 = new Char("t2", "noir");

        p1 = new Pion("p1", "rouge");
        p2 = new Pion("p2", "noir");

        b1 = new Bombarde("b1", "rouge");
        b2 = new Bombarde("b2", "noir");
    }

    @Test
    public void testChar(){
        Position depart = new Position(4, 7);
        Position arrivee = new Position(4, 3);
        assertTrue(t1.estValide(depart, arrivee));
    }

    @Test
    public void testPion(){
        Position depart = new Position(2,6);
        Position arrivee = new Position(2, 5);
        assertTrue(p2.estValide(depart, arrivee));
    }

    @Test
    public void testElephant(){
        Position depart = new Position(2,4);
        Position arrivee = new Position(0, 6);
        assertTrue(e1.estValide(depart, arrivee));
    }

    @Test
    public void testElephant2(){
        Position depart = new Position(2,4);
        Position arrivee = new Position(0, 6);
        assertTrue(e2.estValide(depart, arrivee));
    }

    @Test
    public void testElephant3(){
        Position depart = new Position(2, 4);
        Position arrivee = new Position(4, 2);
        assertTrue(e2.estValide(depart, arrivee));
    }

    @Test
    public void testElephant4(){
        Position depart = new Position(2,5);
        Position arrivee = new Position(4, 7);
        assertTrue(e1.estValide(depart, arrivee));
    }

    @Test
    public void testRoi(){
        Position depart = new Position(4,9);
        Position arrivee = new Position(3, 9);
        assertTrue(r.estValide(depart, arrivee));
    }

    @Test
    public void testRoi2(){
        Position depart = new Position(4,0);
        Position arrivee = new Position(3, 1);
        assertTrue(r2.estValide(depart, arrivee));
    }

    @Test
    public void testRoi3(){
        Position depart = new Position(4, 0);
        Position arrivee = new Position(4, 0);
        assertTrue(r2.estValide(depart, arrivee));
    }

    @Test
    public void testMandarin(){
        Position depart = new Position(4,1);
        Position arrivee = new Position(3, 0);
        assertTrue(m2.estValide(depart, arrivee));
    }

    @Test
    public void testMandarin2(){
        Position depart = new Position(3, 9);
        Position arrivee = new Position(3, 8);
        assertTrue(m1.estValide(depart, arrivee));
    }



}