package cindy.vue;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cindy.outils.EnvoiMail;

/**
 * Vue de la fenetre
 * @author jc.leberre
 * @version 1.0 du 05/09/2011
 *
 */
public class VueMail extends JDialog{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 822236182020094669L;
	/** Conteneur JPanel */
	private final JPanel contentPanel = new JPanel();
	/** Champs de texte du texte */
	private JTextField txtA;
	/** Champs de texte du texte Objet d'un mail */
	private JTextField textObjet;
	/** Zone de texte pour la saisie des mails */
	private JTextArea textArea;
	private String motDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VueMail dialog = new VueMail("mdp","login");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VueMail(final String motDePasse,final String login) {
		setBounds(100, 100, 450, 300);
		setTitle("Cindy - Envoyer un mail");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JMenuBar menuEnvoyerMail = new JMenuBar();
			
			JMenu fichier = new JMenu("Fichier");
			JMenuItem quitter = new JMenuItem("Quitter");
			quitter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();					
				}
			});
			fichier.add(quitter);
			
			JMenu aide = new JMenu("Aide");
			JMenuItem apropos = new JMenuItem("A Propos");
			apropos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new APropos();
				}
			});
			aide.add(apropos);
			
			menuEnvoyerMail.add(fichier);
			menuEnvoyerMail.add(aide);
			setJMenuBar(menuEnvoyerMail);
		}
		{
			JLabel label = new JLabel("\u00E0 :");
			label.setBounds(10, 25, 21, 14);
			contentPanel.add(label);
		}
		{
			txtA = new JTextField();
			txtA.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
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
						EnvoiMail mail=new EnvoiMail();
						mail.EnvoyerMail(txtA.getText().split(";"),textArea.getText(),textObjet.getText(),motDePasse,login);
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
		this.setVisible(true);
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
