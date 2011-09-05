package cindy.vue;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import cindy.outils.EnvoiMail;

/**
 * Fenetre de vue 
 * @author jc.leberre
 * @version 1.0 du 05/09/2011
 *
 */
public class LoginMail extends JDialog {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8948312729868282822L;
	/** conteneneur panel */
	private final JPanel contentPanel = new JPanel();
	/** Zone de texte */
	private JTextField txtgmailcom;
	/** Label du login */
	private JLabel lblLogin;
	/** Label du mdp */
	private JLabel lblMotDePasse;
	/** Zone de texte crypté */
	private JPasswordField passwordField;
	/** String du mdp */
	private String mdp;
	/** String du login */
	private String login;
	/** String du annuler */
	private JButton btnAnnuler;

	/**
	 * Lanceur de l'application
	 */
	public static void main(String[] args) {
		try {
			LoginMail dialog = new LoginMail();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creation de la fenetre.
	 */
	public LoginMail() {
		setBounds(100, 100, 259, 219);
		setTitle("Cindy - Loggin Mail");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblLogin = new JLabel("Adresse Gmail : ");
			lblLogin.setBounds(10, 31, 94, 14);
			contentPanel.add(lblLogin);
		}
		{
			lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setBounds(10, 100, 94, 14);
			contentPanel.add(lblMotDePasse);
		}
		{
			txtgmailcom = new JTextField();
			txtgmailcom.setText("@gmail.com");
			txtgmailcom.setBounds(116, 24, 122, 28);
			contentPanel.add(txtgmailcom);
			txtgmailcom.setColumns(10);
		}

		passwordField = new JPasswordField();
		passwordField.setBounds(116, 93, 122, 28);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mdp = new String(passwordField.getPassword());
						login = txtgmailcom.getText();
						if (mdp != null) {
							if (!login.equals("@gmail.com")) {
								if (login.endsWith("@gmail.com")) {
									if (!mdp.trim().equals("")) {
										if (EnvoiMail.verifierAuthentification(
												login, mdp)) {
											dispose();
											new VueMail(mdp, login);
										} else {
											
										}
									} else {
										JOptionPane
												.showMessageDialog(null,
														"Le mot de passe ne peut pas etre vide!");
									}
								} else {
									JOptionPane
											.showMessageDialog(null,
													"Adresse non prise en charge,\nL'adresse doit etre de type gmail!");
								}
							} else {
								JOptionPane
										.showMessageDialog(null,
												"Veuillez remplir une adresse de type gmail!");
							}
						} else {
							throw new RuntimeException("mot de passe null! ");
						}
					}
				});
				{
					btnAnnuler = new JButton("Annuler");
					btnAnnuler.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
					buttonPane.add(btnAnnuler);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		this.setVisible(true);
	}
}
