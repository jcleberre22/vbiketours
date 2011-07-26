package cindy.vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class VuePrincipale extends javax.swing.JFrame {


	private static final long serialVersionUID = 1L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem4;
	private JMenu jMenu9;
	private JMenu jMenu8;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JMenuItem jMenuItem10;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JMenuItem Lister;
	private JMenuItem jMenuItem3;
	private JMenu jMenu3;
	private JMenu jMenu2;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VuePrincipale inst = new VuePrincipale();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VuePrincipale() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Cindy Application");
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setSize(794, 150);
				jPanel1.setPreferredSize(new java.awt.Dimension(794, 545));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					@SuppressWarnings("unused")
					FlowLayout jLabel1Layout = new FlowLayout();
					jLabel1.setText("Bienvenue dans l'application");
					jLabel1.setLayout(null);
					jLabel1.setFont(new java.awt.Font("Algerian",1,28));
					jLabel1.setForeground(Color.RED);
					jLabel1.setBounds(170, 12, 497, 84);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText(" Gestion des escadrons");
					jLabel2.setBounds(216, 120, 386, 64);
					jLabel2.setFont(new java.awt.Font("Algerian",1,28));
					jLabel2.setForeground(Color.RED);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("CINDY");
					jLabel3.setBounds(373, 82, 90, 28);
					jLabel3.setFont(new java.awt.Font("Algerian",1,28));
					jLabel3.setForeground(Color.RED);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("Base Aérienne 312");
					jLabel4.setBounds(261, 254, 311, 41);
					jLabel4.setFont(new java.awt.Font("Algerian",1,28));
					jLabel4.setForeground(Color.BLUE);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("-------------");
					jLabel5.setBounds(352, 207, 151, 26);
					jLabel5.setFont(new java.awt.Font("Algerian",1,28));
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.setSize(784, 25);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Fichier");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("A Propos");
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Quitter");
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Vol");
					{
						jMenuItem3 = new JMenuItem();
						jMenu2.add(jMenuItem3);
						jMenuItem3.setText("Ajouter");
					}
					{
						Lister = new JMenuItem();
						jMenu2.add(Lister);
						Lister.setText("Lister");
					}
					{
						jMenuItem8 = new JMenuItem();
						jMenu2.add(jMenuItem8);
						jMenuItem8.setText("Modifier");
					}
					{
						jMenuItem9 = new JMenuItem();
						jMenu2.add(jMenuItem9);
						jMenuItem9.setText("Supprimer");
					}
				}
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Statistiques");
					{
						jMenuItem6 = new JMenuItem();
						jMenu3.add(jMenuItem6);
						jMenuItem6.setText("Nombre de vol / nombre de vol avec probleme");
					}
					{
						jMenuItem7 = new JMenuItem();
						jMenu3.add(jMenuItem7);
						jMenuItem7.setText("Nombre de problème par secteur de vol");
					}
				}
				{
					jMenu8 = new JMenu();
					jMenuBar1.add(jMenu8);
					jMenu8.setText("Compte-rendu");
					{
						jMenuItem4 = new JMenuItem();
						jMenu8.add(jMenuItem4);
						jMenuItem4.setText("Ajouter");
					}
					{
						jMenuItem5 = new JMenuItem();
						jMenu8.add(jMenuItem5);
						jMenuItem5.setText("Supprimer");
					}
				}
				{
					jMenu9 = new JMenu();
					jMenuBar1.add(jMenu9);
					jMenu9.setText("Mail");
					{
						jMenuItem10 = new JMenuItem();
						jMenu9.add(jMenuItem10);
						jMenuItem10.setText("Nouveau courrier");
					}
				}
			}
			pack();
			this.setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
