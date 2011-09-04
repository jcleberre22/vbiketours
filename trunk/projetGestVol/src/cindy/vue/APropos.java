package cindy.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * Fenetre JDialog A propos. Construit sur Windows Builder.
 * @author Nicolas.Tabuteaud
 * @version 1.0 du 31/08/2011
 *
 */
public class APropos extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			APropos dialog = new APropos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public APropos() {
		//definition d'une taille pour le apropos
		setSize(432, 293);
		//titre de la fenetre
		setTitle("Cindy Application - A propos");
		//position au centre de l'écran
		setLocationRelativeTo(null);
		//impossible de redimensionner la frame
		setResizable(false);
		//fermeture de l'application à la fermeture de la fenêtre
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//attribution d'un conteneur a la frame
		getContentPane().setLayout(new BorderLayout());
		//définition des bords
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//ajout du conteneur principal a la frame
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cindy Application - Logiciel de Gestion des Escadrons");
		lblNewLabel.setFont(new Font("Andalus", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 11, 321, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Créé par la PIF");
		lblNewLabel_1.setFont(new Font("Andalus", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(156, 45, 95, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("- -");
		lblNewLabel_2.setBounds(192, 30, 11, 14);
		contentPanel.add(lblNewLabel_2);
		
		String id = "LEBERRE Jean-Christophe \n \n MARTINEZ Jean-Philippe \n \n TABUTEAUD Nicolas";
		JTextPane lblNewLabel_3 = new JTextPane();
		lblNewLabel_3.setFont(new Font("Andalus", Font.PLAIN, 14));
		lblNewLabel_3.setText(id);
		lblNewLabel_3.setBackground(null);
		lblNewLabel_3.setBounds(31, 91, 161, 120);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Nicolas\\Desktop\\ecusson.png"));
		lblNewLabel_4.setBounds(236, 63, 155, 148);
		contentPanel.add(lblNewLabel_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
