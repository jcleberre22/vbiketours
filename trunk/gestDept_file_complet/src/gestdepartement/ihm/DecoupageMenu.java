package gestdepartement.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

/**
 * Mise en place d'un menu.
 * @author nicolas.tabuteaud
 * @version 1.0 du 06/07/2011
 */
public class DecoupageMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMB = null;
	private JMenu jMenu = null;
	private JMenu jMenu2 = null;
	private JLabel jLabel = null;
	
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem6 = null;
	private JMenuItem jMenuItem7 = null;
	
	private JMenu jSousMenu = null;
	
	public DecoupageMenu() {
		initialize();
	}
	

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		this.setSize(527, 523);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getJJMB());
		
		
	}
	
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText("");
			jLabel.setForeground(Color.white);
			jLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
			jContentPane = new JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(jLabel, BorderLayout.NORTH);
			
			
		}
		return jContentPane;
	}

	public JMenuBar getJJMB() {
		if (jJMB == null) {
			jJMB = new JMenuBar();
			jMenu = new JMenu();
			jMenu.setText("Menu");
			jMenuItem1=new JMenuItem("About");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null, "@nicolas.TABUTEAUD");
				}
			});
			
			jMenu.add(jMenuItem1);
			
			jMenuItem2=new JMenuItem("Quitter");
			jMenu.add(jMenuItem2);
			jJMB = new JMenuBar();			
			
			jMenu2 = new JMenu();
			jMenu2.setText("Action");
			jMenuItem1=new JMenuItem("Consulter Region");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//TODO
				}
			});
			
			jMenu2.add(jMenuItem1);
			 
			jMenuItem2=new JMenuItem("Modifier Region");
			jMenu2.add(jMenuItem2);
						
			jMenuItem3=new JMenuItem("Supprimer Region");
			jMenu2.add(jMenuItem3);
			
			jMenu2.add(new JSeparator());
			
			jSousMenu = new JMenu();
			jSousMenu.setText("Gestion Departement");
			jMenuItem4=new JMenuItem("Ajouter");
			jSousMenu.add(jMenuItem4);
			
			jMenuItem5=new JMenuItem("Lister");
			jSousMenu.add(jMenuItem5);
			
			jMenuItem6=new JMenuItem("Modifier");
			jSousMenu.add(jMenuItem6);
			
			jMenuItem7=new JMenuItem("Modifier");
			jSousMenu.add(jMenuItem7);
			
			jMenu2.add(jSousMenu);
			
			jJMB = new JMenuBar();
			
			jJMB.add(jMenu);
			jJMB.add(jMenu2);

		}
		return jJMB;
	}
		//test
		public static void main(String[] args) {
			DecoupageMenu dlg = new DecoupageMenu();
			dlg.setVisible(true);
		}

	
}
