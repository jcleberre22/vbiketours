package cindy.vue;

import java.awt.BorderLayout;
//import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JSplitPane;

import cindy.controleur.IControleur;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
//import javax.swing.table.DefaultTableModel;


public class VueStatistique extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 */
	public VueStatistique(IControleur controleur) {
		this.ctl = controleur;
		initVue();
		initialiserMenu();
		//initialisation du conteneur de la frame
		contentPane = new JPanel();
		//attribution des layout au panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//d�claration d'un conteneur d'onglet
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		/**Construction des JSplitPane */
				/** Premier JSplitPane : les Probl�mes de vol*/
		//Ce conteneur permet de g�rer des composants dispos�s sur plusieurs couches
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Nombre vol avec probleme", null, layeredPane, null);
		//d�finition et ajout d'un nouveau conteneur
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		layeredPane.add(panel);
		panel.setLayout(null);
		//d�claration d'un nouveau conteneur
		//pour contenir un jsplitpane
		JPanel panelHaut = new JPanel();
		JPanel panelBas = new JPanel();
		//Ce composant permet de r�partir l'espace entre deux composants
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelHaut,panelBas);
		splitPane.setBounds(0, 0, 800, 600);
		splitPane.setLeftComponent(panelHaut); 
		splitPane.setRightComponent(new Camembert(controleur));
		panel.add(splitPane);
		
			/**Second JSplitPane : les pb par secteur de vol	*/
		//Ce conteneur permet de g�rer des composants dispos�s sur plusieurs couches
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Nombre de probleme/Secteur de vol", null, layeredPane_1, null);
		//d�finition et ajout d'un nouveau conteneur
		JPanel pane2 = new JPanel();
		pane2.setSize(800, 600);
		layeredPane_1.add(pane2);
		pane2.setLayout(null);
		//d�claration d'un nouveau conteneur
		//pour contenir un jsplitpane
		JPanel panel4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel4.getLayout();
		JPanel panel5 = new JPanel();
		//Ce composant permet de r�partir l'espace entre deux composants
		JSplitPane splitPane_1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel4,panel5);
		splitPane_1.setBounds(10, 11, 800, 600);
		//construction du tableau
		nombreVol = ConstruireTableau();
		//panel4.add(nombreVol.getTableHeader(),BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(nombreVol);
		scrollPane.setViewportBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		panel4.add(scrollPane,BorderLayout.CENTER);
		splitPane_1.setLeftComponent(panel4); 
		ProblemeVol problemeVol = new ProblemeVol("Probl�mes de vol");
		FlowLayout flowLayout_1 = (FlowLayout) problemeVol.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		splitPane_1.setRightComponent(problemeVol);
		pane2.add(splitPane_1);
		
	}
	
	public void initVue(){
		//elle st positionn�e au centre de l'�cran
				setLocationRelativeTo(null);
				//ferm� l'application � la fermeture de la fen�tre
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//titre de la fen�tre
				setTitle("Gestion des statistiques");
				//on d�finit les dimensions de cette fen�tre
				setBounds(100, 100, 800, 600);
				//elle ne peut pas etre redimensionn�e
				setResizable(false);
	}
	
	public void initialiserMenu(){
		//cr�ation de la barre de menu
				JMenuBar menuBar = new JMenuBar();
				//ajout de cette barre � la frame
				setJMenuBar(menuBar);
				
				/**cr�ation de menus pour le MenuBar*/
				JMenu mnNewMenu = new JMenu("Fichier");
				menuBar.add(mnNewMenu);
				//cr�ation d'objet qui seront ins�r�s dans le menu
				//puis ajout des objets dans les menus
				mntmAPropos = new JMenuItem("A Propos");
				mntmAPropos.addActionListener(this);
				mnNewMenu.add(mntmAPropos);
				
				mntmQuitter = new JMenuItem("Quitter");
				mntmQuitter.addActionListener(this);
				mnNewMenu.add(mntmQuitter);
				
				JMenu mnVol = new JMenu("Vol");
				menuBar.add(mnVol);
				
				mntmNewMenuItem = new JMenuItem("Gerer");
				mntmNewMenuItem.addActionListener(this);
				mnVol.add(mntmNewMenuItem);
				
				JMenu mnStatistique = new JMenu("Statistique");
				menuBar.add(mnStatistique);
				
				mntmNewMenuItem_1 = new JMenuItem("Gerer\r\n");
				mntmNewMenuItem_1.addActionListener(this);
				mnStatistique.add(mntmNewMenuItem_1);
	}
	
	public JTable ConstruireTableau(){
		String[] title = {"Nombre de vol","Pourcentage"};
		Object[][] dataBidon = {{"9 vols","20%"},
								{"15 vols","30%"},
								{"20 vols","40%"},
								{"5 vols","10%"}}; 
		nombreVol = new JTable(dataBidon,title);
		/*nombreVol.setModel(new DefaultTableModel(
			new Object[][] {
				{"9 vols", "20%"},
				{"15 vols", "30%"},
				{"20 vols", "40%"},
				{"5 vols", "10%"},
			},
			new String[] {
				"Nombre de vol", "Pourcentage"
			}
		));*/
		nombreVol.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreVol.setBackground(new Color(255, 255, 255));
		nombreVol.setPreferredScrollableViewportSize((new Dimension(400,150)));
		return nombreVol;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmAPropos){
			ctl.APropos();
		}
		if(e.getSource() == mntmQuitter){
			this.dispose();
		}
		if(e.getSource() == mntmNewMenuItem){
			//TODO : d�marrer la frame correspondante
		}
		if(e.getSource() == mntmNewMenuItem_1){
			//TODO : d�marrer la frame correspondante
		}
	}
}