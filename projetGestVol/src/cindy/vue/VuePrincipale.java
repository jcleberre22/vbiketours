package cindy.vue;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VuePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur monControleur;
	
	/**
	 * Creer la vue.
	 */
	public VuePrincipale(IControleur ctrl) {
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Cindy Application - Fenetre Principale");
		setBounds(100, 100, 376, 266);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmAPropos = new JMenuItem("A Propos");
		mntmAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monControleur.APropos();
			}
		});
		mnFichier.add(mntmAPropos);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		JMenu mnMessagerie = new JMenu("Messagerie");
		menuBar.add(mnMessagerie);
		
		JMenuItem mntmEnvoyerMail = new JMenuItem("Envoyer Mail");
		mnMessagerie.add(mntmEnvoyerMail);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gestion des Vols\r\n");
		btnNewButton.setBounds(10, 105, 160, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Statistiques\r\n");
		btnNewButton_1.setBounds(196, 105, 154, 61);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBienvenue = new JLabel("Bienvenue");
		lblBienvenue.setFont(new Font("Andalus", Font.PLAIN, 18));
		lblBienvenue.setBounds(139, 27, 79, 33);
		contentPane.add(lblBienvenue);
		
		this.monControleur=ctrl;
	}

}
