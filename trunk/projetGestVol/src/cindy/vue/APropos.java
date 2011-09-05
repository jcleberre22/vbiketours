package cindy.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Fenetre JDialog A propos. Construit sur Windows Builder.
 * @exte
 * @author Nicolas.Tabuteaud
 * @version 1.0 du 31/08/2011
 *
 */
public class APropos extends JDialog {

	private static final long serialVersionUID = 1L;
	
	/** Conteneur de la JDialog */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Lanceur de l'application
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
	 * Creation d'un panel. Fenetre generant une JDialog.
	 * 
	 */
	public APropos() {
		setBounds(100, 100, 432, 293);
		setTitle("Cindy Application - A propos");
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 88, 194, 133);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblLeberre = new JLabel(" LEBERRE Jean-Christophe");
		lblLeberre.setBounds(10, 11, 174, 14);
		panel.add(lblLeberre);
		
		JLabel lblMartinez = new JLabel(" MARTINEZ Jean-Philippe ");
		lblMartinez.setBounds(10, 60, 174, 14);
		panel.add(lblMartinez);
		
		JLabel lblTabuteaud = new JLabel(" TABUTEAUD Nicolas");
		lblTabuteaud.setBounds(10, 108, 174, 14);
		panel.add(lblTabuteaud);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(APropos.class.getResource("/cindy/vue/ecusson.png")));
		lblNewLabel_3.setBounds(230, 70, 152, 151);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setVisible(true);
	}
}
