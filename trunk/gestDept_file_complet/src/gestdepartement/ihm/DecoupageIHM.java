package gestdepartement.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class DecoupageIHM extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private JLabel jLabel = null;	
	
	private JLabel jLabel1 = null;
	private JPanel jPanel1 = null;

	public DecoupageIHM() {
		initialize();
	}
	
	private void initialize() {
		
		this.setSize(527, 523);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setContentPane(getJContentPane());
				
		
	}
	
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());			
			jContentPane.add(getJPanel(),null);
			
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(10, 100, 150, 30));
			jLabel1.setEnabled(false);
			jLabel1.setText("Choisir numero de la region");
			jPanel1 = new JPanel();

			jPanel1.add(jLabel1, null);
		}
		return jPanel1;
	}
	
	
	public static void main(String[] args) {
		
		DecoupageIHM ihm = new DecoupageIHM();
		ihm.setVisible(true);
	}

}
