package cindy.vue;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;


import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class VueLister extends javax.swing.JFrame {


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
	private JDesktopPane jDesktopPane1;
	private JButton jButton1;
	private JLabel jLabel1;
	private JTable jTable1;
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
				VueLister inst = new VueLister();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public VueLister() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setTitle("Cindy Application - Lister un vol ");
			setResizable(false);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setSize(794, 150);
				jPanel1.setPreferredSize(new java.awt.Dimension(794, 545));
				{
					TableModel jTable1Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable1 = new JTable();
					jPanel1.add(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setBounds(12, 51, 531, 484);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Consultation");
					jLabel1.setBounds(195, 20, 158, 16);
					jLabel1.setFont(new java.awt.Font("Algerian",1,20));
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("Supprimer");
					jButton1.setBounds(623, 281, 94, 26);
				}
				{
					jDesktopPane1 = new JDesktopPane();
					jPanel1.add(jDesktopPane1);
					jDesktopPane1.setBounds(555, 54, 221, 198);
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
