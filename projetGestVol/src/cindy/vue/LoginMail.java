package cindy.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginMail extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8948312729868282822L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private String mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginMail dialog = new LoginMail(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginMail(VueMail vueMail) {
		setBounds(100, 100, 246, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLogin = new JLabel("Login : ");
			lblLogin.setBounds(10, 31, 46, 14);
			contentPanel.add(lblLogin);
		}
		{
			JLabel lblMotDePasse = new JLabel("Mot de passe :");
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
						dispose();
					}
				});
				vueMail.setMotDePasse(mdp);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
