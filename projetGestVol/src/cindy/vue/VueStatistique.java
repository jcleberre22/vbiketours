package cindy.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.Component;


public class VueStatistique extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable nombreVol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueStatistique frame = new VueStatistique();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VueStatistique() {
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion des statistiques");
		setBounds(100, 100, 659, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fichier");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAPropos = new JMenuItem("A Propos");
		mnNewMenu.add(mntmAPropos);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mnNewMenu.add(mntmQuitter);
		
		JMenu mnVol = new JMenu("Vol");
		menuBar.add(mnVol);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gerer");
		mnVol.add(mntmNewMenuItem);
		
		JMenu mnStatistique = new JMenu("Statistique");
		menuBar.add(mnStatistique);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Gerer\r\n");
		mnStatistique.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Nombre de Vol/nombre vol avec probleme", null, layeredPane, null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 453);
		layeredPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel2,panel3);
//		ProblemeVol pv = new ProblemeVol("Probleme Vol");
//		/*splitPane.setLeftComponent(cam);
//		splitPane.setRightComponent(null);*/
//		splitPane.setLeftComponent(null);
//		splitPane.setRightComponent(null);
		panel.add(splitPane, BorderLayout.CENTER);
		
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Nombre de probleme/Secteur de vol", null, layeredPane_1, null);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(0, 0, 628, 453);
		layeredPane_1.add(splitPane_1);
	}
}
