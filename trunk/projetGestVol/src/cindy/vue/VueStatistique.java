package cindy.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import cindy.controleur.IControleur;


public class VueStatistique extends JFrame implements ActionListener{

	/**
	 * les secteurs de vol n'etant pas prevus lors de l'analyse,
	 * les données sont entrees en dur afin de tester la fonctionnalite
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private IControleur ctl;
	private JPanel contentPane;
	private JTable nombreVol;
	private JMenuItem mntmAPropos;
	private JMenuItem mntmQuitter;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	//private IControleur controleur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueStatistique frame = new VueStatistique(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public VueStatistique(IControleur controleur) throws SQLException, Exception {
		this.ctl = controleur;
		initVue();
		initialiserMenu();
		//initialisation du conteneur de la frame
		contentPane = new JPanel();
		//attribution des layout au panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//déclaration d'un conteneur d'onglet
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		/**Construction des JSplitPane */
				/** Premier JSplitPane : les Problèmes de vol*/
		//Ce conteneur permet de gérer des composants disposés sur plusieurs couches
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Nombre vol avec probleme", null, layeredPane, null);
		//définition et ajout d'un nouveau conteneur
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		layeredPane.add(panel);
		panel.setLayout(null);
		//déclaration d'un nouveau conteneur
		//pour contenir un jsplitpane
		JPanel panelHaut = new JPanel();
		JPanel panelBas = new JPanel();
		//Ce composant permet de répartir l'espace entre deux composants
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelHaut,panelBas);
		splitPane.setBounds(0, 0, 800, 600);
		splitPane.setLeftComponent(panelHaut); 
		splitPane.setRightComponent(new Camembert(controleur));
		panel.add(splitPane);
		
			/**Second JSplitPane : les pb par secteur de vol	*/
		//Ce conteneur permet de gérer des composants disposés sur plusieurs couches
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Nombre de probleme/Secteur de vol", null, layeredPane_1, null);
		//définition et ajout d'un nouveau conteneur
		JPanel pane2 = new JPanel();
		pane2.setSize(800, 600);
		layeredPane_1.add(pane2);
		pane2.setLayout(null);
		//déclaration d'un nouveau conteneur
		//pour contenir un jsplitpane
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		//Ce composant permet de répartir l'espace entre deux composants
		JSplitPane splitPane_1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel4,panel5);
		splitPane_1.setBounds(10, 11, 800, 600);
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//construction du tableau
		nombreVol = ConstruireTableau();
		//panel4.add(nombreVol.getTableHeader(),BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(nombreVol);
		scrollPane.setViewportBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		panel4.add(scrollPane);
		splitPane_1.setLeftComponent(panel4); 
		ProblemeVol problemeVol = new ProblemeVol("Problèmes de vol");
		FlowLayout flowLayout_1 = (FlowLayout) problemeVol.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		splitPane_1.setRightComponent(problemeVol);
		pane2.add(splitPane_1);
		
	}
	
	public void initVue(){

				//fermé l'application à la fermeture de la fenêtre
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//titre de la fenêtre
				setTitle("Gestion des statistiques");
				//on définit les dimensions de cette fenêtre
				setBounds(100, 100, 800, 600);
				//elle ne peut pas etre redimensionnée
				setResizable(false);
				//elle st positionnée au centre de l'écran
				setLocationRelativeTo(null);
	}
	
	public void initialiserMenu(){
		//création de la barre de menu
				JMenuBar menuBar = new JMenuBar();
				//ajout de cette barre à la frame
				setJMenuBar(menuBar);
				
				/**création de menus pour le MenuBar*/
				JMenu mnNewMenu = new JMenu("Fichier");
				menuBar.add(mnNewMenu);
				JMenu aide = new JMenu("Aide");
				menuBar.add(aide);
				//création d'objet qui seront insérés dans le menu
				//puis ajout des objets dans les menus
				mntmAPropos = new JMenuItem("A Propos");
				mntmAPropos.addActionListener(this);
				aide.add(mntmAPropos);
				mntmQuitter = new JMenuItem("Quitter");
				mntmQuitter.addActionListener(this);
				mnNewMenu.add(mntmQuitter);
				
	}
	
	public JTable ConstruireTableau(){
		nombreVol = new JTable();
		nombreVol.setModel(new DefaultTableModel(
			new Object[][] {
				{"secteur 1", "9 vols", "20%"},
				{"secteur 2", "15 vols", "30%"},
				{"secteur 3", "20 vols", "40%"},
				{"secteur 4", "5 vols", "10%"},
			},
			new String[] {
				"Secteur", "Nombre de vol", "Pourcentage"
			}
		));

		nombreVol.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreVol.setBackground(new Color(255, 255, 255));
		nombreVol.setPreferredScrollableViewportSize((new Dimension(400,150)));
		return nombreVol;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmAPropos){
			APropos aPropos=new APropos();
			aPropos.setVisible(true);
		}
		if(e.getSource() == mntmQuitter){
			this.dispose();
		}
	}
}
