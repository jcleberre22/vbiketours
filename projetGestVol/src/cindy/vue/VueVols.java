package cindy.vue;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cindy.controleur.IControleur;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;

public class VueVols extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IControleur controleur;

	/**
	 * Create the frame.
	 */
	public VueVols(IControleur ctrl) {
		setTitle("Gestion des vols");
		controleur=ctrl;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Consulter", null, layeredPane_1, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tabbedPane.setEnabledAt(0, true);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Creer un vol", null, layeredPane, null);
	}
}
