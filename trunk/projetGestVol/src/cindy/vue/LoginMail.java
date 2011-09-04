package cindy.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import cindy.controleur.Controleur;
import cindy.controleur.IControleur;

public class LoginMail extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8948312729868282822L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JLabel lblLogin;
	private JLabel lblMotDePasse;
	private JPasswordField passwordField;
	private String mdp;
	private String login;

	/**
	 * Launch the application.
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
	 * Create the dialog.
	 */
	public LoginMail() {
		setBounds(100, 100, 246, 219);
		setTitle("Cindy - Loggin Mail"); 
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblLogin = new JLabel("Login : ");
			lblLogin.setBounds(10, 31, 46, 14);
			contentPanel.add(lblLogin);
		}
		{
			lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setBounds(10, 100, 94, 14);
			contentPanel.add(lblMotDePasse);
		}
		{
			textField = new JTextField();
			textField.setBounds(96, 24, 122, 28);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 93, 122, 28);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mdp=new String(passwordField.getPassword());
						//mdp = lblMotDePasse.getText();
						login = lblLogin.getText();
						if(mdp != null){
							if(!mdp.equals("Mot de passe :")){
								if(!mdp.trim().equals("")){
									dispose();
									new VueMail(mdp);
								}
							}
						}
						else
							System.out.println("le mot de passe est null : " + mdp);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		this.setVisible(true);
	}
}
