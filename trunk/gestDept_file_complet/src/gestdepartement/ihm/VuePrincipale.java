package gestdepartement.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Affichage de la vue swing de gestion des regions.
 * La construction de cette vue est réalisé étape par étape.
 * Cette classe ne porte que la vue principal.
 * @author nicolas.tabuteaud
 * @version 1.0 du 06/07/2011
 */
public class VuePrincipale extends JFrame{
	private final String TITRE = "Gestion des régions";
	/** l'ecran principlal.*/
	private JFrame laFrame;
	
	private JPanel interne;
	
	/**
	 * Initialisation des composants.
	 */
	public VuePrincipale(JPanel unPanel){
		initComposant(unPanel);
		visible();
	}
	
	public VuePrincipale()
	{
		
	}


	//METHODES PRIVEES
	/**
	 * Affichage securisée de la frame.
	 */
	private void visible() {
		Runnable affichage = new Runnable() {
			public void run() {
				laFrame.setVisible(true);
				laFrame.setLocationRelativeTo(null);
			}
		};
		EventQueue.invokeLater(affichage);
	}

	/**
	 * Initialisation des composants swing.
	 * @param unPanel a prendre comme panel 
	 * principale.
	 */
	private void initComposant(JPanel unPanel) {
		if (laFrame == null){
			//on crée la fenêtre
			laFrame = new JFrame();
			//on lui donne un titre
			laFrame.setTitle(TITRE);
			//on lui donne une dimension
			laFrame.setSize(new Dimension(527, 523));
			setResizable(false);
			laFrame.setContentPane(unPanel);
			//laFrame.pack();
			//on termine l'application a la fermeture de la fenêtre
			laFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//on la centre
			laFrame.setLocationRelativeTo(null);
			//on lui attribue un menu
			laFrame.setJMenuBar(new DecoupageMenu().getJJMB());
			
		}
	}
	
	public void ajouter(JPanel panel) {
		interne.add(panel, BorderLayout.CENTER);
		laFrame.validate();	
	}
	
	//TEST
	public static void main(String[] args) {
		new VuePrincipale(new JPanel(new BorderLayout()));
		
		
	}
}
