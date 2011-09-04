package cindy.outils;

import java.io.IOException;
import com.jscape.inet.smtpssl.SmtpSsl;
import com.jscape.inet.email.EmailMessage;

;

public class EnvoiMail {

	// Cette classe a besoin de la librairie sinetfactory.jar

	public EnvoiMail(String[] ListDest, String cCorps, String cSujet, String mdp) {
		String EnvoyerA = ""; // un seul Destinataire à la fois
		// Pour des raisons de simplicité, les informations du mail
		// chargées de l'envoi sont inscrites en dur.
		String EnvoieDe = "jcleberre22@gmail.com"; // Login
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
}
