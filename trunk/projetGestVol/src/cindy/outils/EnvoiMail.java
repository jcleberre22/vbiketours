package cindy.outils;

import java.io.IOException;

import com.jscape.inet.smtp.SmtpException;
import com.jscape.inet.smtpssl.SmtpSsl;
import com.jscape.inet.email.EmailMessage;

;

public class EnvoiMail {

	// Cette classe a besoin de la librairie sinetfactory.jar

	public EnvoiMail(){
		
	}
	
	public void EnvoyerMail(String[] ListDest, String cCorps, String cSujet, String mdp,String login) {
		String EnvoyerA = ""; // un seul Destinataire à la fois
		String EnvoieDe = login; // Login
		String pwd = mdp; // Password
		for (int i = 0; i < ListDest.length; i++) {
			// On récupère l'élément et on l'envoie
			EnvoyerA = ListDest[i];
			try {
				envoyer(EnvoieDe, pwd, EnvoyerA, cSujet, cCorps);
			} catch (IOException ex) {
				System.out.println("L'erreur est " + ex);
			}

		}
	}

	public void envoyer(String username, String password, String to,
			String cSujet, String cCorps) throws IOException {

		SmtpSsl smtp = null;

		try {
			// On crée une instance de connexion par SmtpSsl via le port 465
			smtp = new SmtpSsl("smtp.gmail.com", 465);
			// On établit une connexion sécurisée
			smtp.connect();

			// les cordonnées du compte mail
			smtp.login(username, password);

			// Création du nouveau message avec le sujet et corps du mail
			EmailMessage message = new EmailMessage();
			message.setTo(to);
			message.setFrom(username);
			message.setSubject(cSujet);
			message.setBody(cCorps);

			// On précise qu'on peut utiliser le format HTML
			message.setContentType("text/html");

			// Envoi de message
			smtp.send(message);

			// Enfin, on se déconnecte
			smtp.disconnect();
		} catch (Exception e) {
			System.out.println("Une erreur s'est produite : " + e);
		}
	}
	
	public static boolean verifierAuthentification(String username,String password){
		SmtpSsl smtp = null;

		
			// On crée une instance de connexion par SmtpSsl via le port 465
			smtp = new SmtpSsl("smtp.gmail.com", 465);
			// On établit une connexion sécurisée
			try {
				smtp.connect();
			} catch (SmtpException e) {
				new RuntimeException("probleme de connexion au serveur smtp");
				return false;
			}

			// les cordonnées du compte mail
			try {
				smtp.login(username, password);
			} catch (SmtpException e) {
				new RuntimeException("Utilisateur ou mot de passe incorrect");
				return false;
			}
			
			try {
				smtp.disconnect();
			} catch (SmtpException e) {
				new RuntimeException("problème lors de la deconnection");
				return false;
			}
			return true;
	}
}
