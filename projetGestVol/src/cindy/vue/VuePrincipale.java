package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;

public class VuePrincipale extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur controleur;
	
	/**
	 * Creer la vue.
	 */
	public VuePrincipale(IControleur ctrl) {
		this.controleur=ctrl;
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Cindy Application - Fenetre Principale");
		setBounds(100, 100, 376, 266);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmAPropos = new JMenuItem("A Propos");
		mntmAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APropos aPropos=new APropos();
				aPropos.setVisible(true);
				
			}
		});
		mnFichier.add(mntmAPropos);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnFichier.add(mntmQuitter);
		
		JMenu mnMessagerie = new JMenu("Messagerie");
		menuBar.add(mnMessagerie);
		
		JMenuItem mntmEnvoyerMail = new JMenuItem("Envoyer Mail");
		mntmEnvoyerMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VueMail mail= new VueMail();
				mail.setVisible(true);
			}
		});

		mnMessagerie.add(mntmEnvoyerMail);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 358, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenue = new JLabel("Bienvenue");
		lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenue.setBounds(123, 24, 117, 40);
		panel.add(lblBienvenue);
		lblBienvenue.setFont(new Font("Andalus", Font.PLAIN, 22));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 109, 159, 70);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnGestionDesVols = new JButton("Gestion des vols");
		btnGestionDesVols.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VueVols vol;
				try {
					vol = new VueVols(controleur);
					vol.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel_1.add(btnGestionDesVols);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(199, 109, 159, 70);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnStatistiques = new JButton("Statistiques");
		btnStatistiques.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VueStatistique stat=new VueStatistique(controleur);
				stat.setVisible(true);
			}
		});
		panel_2.add(btnStatistiques, BorderLayout.CENTER);
	}
}
