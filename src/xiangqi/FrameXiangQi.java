package xiangqi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameXiangQi extends JFrame {

	private JPanel contentPane;
	JPanel panelConteneur;
	JLabel labelImage, labelCouleur;
	JLabel grille[][]; //90 JLabels transparents s'apparentant aux intersections
	JPanel panelNoirs, panelRouges, panelControle;
	JButton boutonDebuter, boutonRecommencer;
	Ecouteur ec;
	Echiquier echiquier; //échiquier faisant le lien avec la logique du jeu

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameXiangQi frame = new FrameXiangQi();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *constructeur
	 */
	public FrameXiangQi() {
		
		echiquier = new Echiquier(); //création de l'échiquier et des 90 JLabels
		grille = new JLabel[10][9];

		setTitle("XiangQi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 789);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelConteneur= new JPanel();
		panelConteneur.setBackground(new Color(255, 228, 196));
		panelConteneur.setBounds(26, 105, 675, 653);
		panelConteneur.setLayout(new GridLayout(10, 9, 0, 0));
		panelConteneur.setOpaque(false);
		contentPane.add(panelConteneur);
		
		labelImage= new JLabel("");
		labelImage.setBounds(30, 115, 690, 627);
		contentPane.add(labelImage);
		labelImage.setIcon(( new ImageIcon( "fond2.png")));

		panelNoirs = new JPanel();
		panelNoirs.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		panelNoirs.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNoirs.setBounds(772, 77, 68, 751);
		contentPane.add(panelNoirs);
		
		panelRouges = new JPanel();
		panelRouges.setBackground(new Color(255, 102, 102));
		panelRouges.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRouges.setBounds(850, 77, 68, 751);
		contentPane.add(panelRouges);
		
		panelControle = new JPanel();
		panelControle.setBackground(new Color(255, 228, 196));
		panelControle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelControle.setBounds(0, 11, 918, 58);
		contentPane.add(panelControle);
		panelControle.setLayout(null);
		
		boutonRecommencer = new JButton("Recommencer");
		boutonRecommencer.setBounds(744, 22, 152, 23);
		boutonRecommencer.setBackground(new Color(255,239,213));
		boutonRecommencer.setContentAreaFilled(false);
		boutonRecommencer.setOpaque(true);
		panelControle.add(boutonRecommencer);
		boutonRecommencer.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		boutonDebuter = new JButton("Débuter");
		boutonDebuter.setBackground(new Color(255, 239, 213));
		boutonDebuter.setBounds(610, 22, 119, 23);
		boutonDebuter.setContentAreaFilled(false);
		boutonDebuter.setOpaque(true);
		panelControle.add(boutonDebuter);
		boutonDebuter.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCouleur = new JLabel("");
		labelCouleur.setBackground(new Color(255, 239, 213));
		labelCouleur.setOpaque(true);
		labelCouleur.setBounds(53, 11, 475, 41);
		
		panelControle.add(labelCouleur);
		labelCouleur.setFont(new Font("Tahoma", Font.BOLD, 20));

		//gestion des événements
		ec = new Ecouteur();
		for ( int i = 0 ; i < 10 ; i ++ )
			for ( int j = 0 ; j < 9 ; j ++ )
			{
				grille[i][j] = new JLabel();
				grille[i][j].addMouseListener( ec );
				panelConteneur.add( grille[i][j]);
				grille[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			}
		boutonDebuter.addMouseListener(ec);
		boutonRecommencer.addMouseListener(ec);

	}
	
	private class Ecouteur extends MouseAdapter {
		int ligneClic, colonneClic; //intersection where it gets clicked recently
		// if tampon vide, debuter, if tampon remplis, arrivee
		Piece pieceTampon, pieceEnlevee; //piece entrain de deplacer
		ImageIcon iconeTampon; //equivalent de piece tampon mais pour aspect graphique
		Position depart, arrivee;
		String couleurControle; //valeur rouge ou noir ;
		  
		public void reset(){
			echiquier = new Echiquier ();
			echiquier.debuter();
			// rafra�chir l'interface graphique
			panelRouges.removeAll();
			panelNoirs.removeAll();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 9; j ++) {
					grille[i][j].setIcon (null);
				}
			}
				//icones
			grille[0][0].setIcon(new ImageIcon("icones/charNoir.png"));
			grille[0][1].setIcon(new ImageIcon("icones/cavalierNoir.png"));
			grille[0][2].setIcon(new ImageIcon("icones/elephantNoir.png"));
			grille[0][3].setIcon(new ImageIcon("icones/mandarinNoir.png"));
			grille[0][4].setIcon(new ImageIcon("icones/roiNoir.png"));
			grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
			grille[0][6].setIcon(new ImageIcon("icones/elephantNoir.png"));
			grille[0][7].setIcon(new ImageIcon("icones/cavalierNoir.png"));
			grille[0][8].setIcon(new ImageIcon("icones/charNoir.png"));
			grille[2][1].setIcon(new ImageIcon("icones/bombardeNoir.png"));
			grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
			grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
			grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

			grille[9][0].setIcon(new ImageIcon("icones/charRouge.png"));
			grille[9][1].setIcon(new ImageIcon("icones/cavalierRouge.png"));
			grille[9][2].setIcon(new ImageIcon("icones/elephantRouge.png"));
			grille[9][3].setIcon(new ImageIcon("icones/mandarinRouge.png"));
			grille[9][4].setIcon(new ImageIcon("icones/roiRouge.png"));
			grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
			grille[9][6].setIcon(new ImageIcon("icones/elephantRouge.png"));
			grille[9][7].setIcon(new ImageIcon("icones/cavalierRouge.png"));
			grille[9][8].setIcon(new ImageIcon("icones/charRouge.png"));
			grille[7][1].setIcon(new ImageIcon("icones/bombardeRouge.png"));
			grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
			grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
			grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));

		    couleurControle = "noir";
		    labelCouleur.setText("C'est aux " + couleurControle + "s à jouer ");
		    // FenetreJeuCorr.this.setVisible(true);
		    repaint();
		    panelRouges.updateUI();
		    panelNoirs.updateUI();
		}
	

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if ( e.getSource() == boutonDebuter) {
				echiquier.debuter();
				grille[0][0].setIcon(new ImageIcon("icones/charNoir.png"));
				grille[0][1].setIcon(new ImageIcon("icones/cavalierNoir.png"));
				grille[0][2].setIcon(new ImageIcon("icones/elephantNoir.png"));
				grille[0][3].setIcon(new ImageIcon("icones/mandarinNoir.png"));
				grille[0][4].setIcon(new ImageIcon("icones/roiNoir.png"));
				grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
				grille[0][6].setIcon(new ImageIcon("icones/elephantNoir.png"));
				grille[0][7].setIcon(new ImageIcon("icones/cavalierNoir.png"));
				grille[0][8].setIcon(new ImageIcon("icones/charNoir.png"));
				grille[2][1].setIcon(new ImageIcon("icones/bombardeNoir.png"));
				grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
				grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

				grille[9][0].setIcon(new ImageIcon("icones/charRouge.png"));
				grille[9][1].setIcon(new ImageIcon("icones/cavalierRouge.png"));
				grille[9][2].setIcon(new ImageIcon("icones/elephantRouge.png"));
				grille[9][3].setIcon(new ImageIcon("icones/mandarinRouge.png"));
				grille[9][4].setIcon(new ImageIcon("icones/roiRouge.png"));
				grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
				grille[9][6].setIcon(new ImageIcon("icones/elephantRouge.png"));
				grille[9][7].setIcon(new ImageIcon("icones/cavalierRouge.png"));
				grille[9][8].setIcon(new ImageIcon("icones/charRouge.png"));
				grille[7][1].setIcon(new ImageIcon("icones/bombardeRouge.png"));
				grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
				grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));
			}
			else if ( e.getSource() == boutonRecommencer) {
				reset();
			}
			else { // il s'agit d'un label / intersection
			    //trouver lequel
				for (int i = 0; i < 10 ; i++) {
					for (int j = 0; j < 9; j++) {
						if (e.getSource() == grille[i][j]) {
							ligneClic = i;
							colonneClic = j;
						}
					}
				}

				// 1er cas : clique sur une case occupee , tampon vide : cas Depart
				if (echiquier.getIntersection(ligneClic, colonneClic).estOccupee() && pieceTampon == null){
					depart = new Position(ligneClic, colonneClic);
					pieceTampon = echiquier.getIntersection(ligneClic, colonneClic).getPiece();
					iconeTampon = (ImageIcon) grille[ligneClic][colonneClic].getIcon();
					grille[ligneClic][colonneClic].setIcon(null);
				}

				// 2éme cas : clique sur une case vide ; tampon plein cas d'arrivee,
				if (!(echiquier.getIntersection(ligneClic, colonneClic).estOccupee()) && pieceTampon != null){
					arrivee = new Position(ligneClic, colonneClic);
					if (pieceTampon.estValide(depart, arrivee)) {
						if (echiquier.cheminPossible(depart, arrivee)) {
//							if (echiquier.roisNePouvantPasEtreFaceAFace(depart, arrivee)) {
								depart = arrivee;
								pieceTampon = null;
								grille[ligneClic][colonneClic].setIcon(iconeTampon);
//							}
						}
					}
				}

			    // 3éme cas : clique sur une case occupee et tampon plein : case d arrivee /capture ( peut-etre piece qui ne bouge pas )

			}
		}
	}
}


			
		
		
	

