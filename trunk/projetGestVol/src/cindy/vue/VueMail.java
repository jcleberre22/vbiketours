package cindy.vue;

//TODO dans toutes les vues remplacer les action mouseClicked par des actionPerformed
//FIXME mot de passe null, apparition de la fenetre de login 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cindy.outils.EnvoiMail;

public class VueMail extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 822236182020094669L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtA;
	private JTextField textObjet;
	private JTextArea textArea;
	private String motDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueMail dialog = new VueMail();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueMail() {
		LoginMail login=new LoginMail(this);
		login.setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("\u00E0 :");
			label.setBounds(10, 25, 21, 14);
			contentPanel.add(label);
		}
		{
			txtA = new JTextField();
			txtA.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtA.getText().equals("Adresses separ\u00E9es d'un \";\"")) {
						txtA.setText("");
						txtA.setForeground(Color.BLACK);
					}
				}
			});
			txtA.setBounds(58, 18, 340, 28);
			txtA.setText("Adresses separ\u00E9es d'un \";\"");
			txtA.setForeground(Color.GRAY);
			contentPanel.add(txtA);
		}
		
		JLabel lblObjet = new JLabel("Objet :");
		lblObjet.setBounds(10, 55, 38, 14);
		contentPanel.add(lblObjet);
		
		textObjet = new JTextField();
		textObjet.setBounds(58, 48, 340, 28);
		contentPanel.add(textObjet);
		textObjet.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(58, 84, 340, 134);
		contentPanel.add(textArea);
		
		JLabel lblCorps = new JLabel("Corps :");
		lblCorps.setBounds(10, 142, 46, 14);
		contentPanel.add(lblCorps);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new EnvoiMail(txtA.getText().split(";"),textArea.getText(),textObjet.getText(),motDePasse);
						JOptionPane.showMessageDialog(null, "Message envoyé!");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
