package cindy.outils;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class Outils {
	public static GregorianCalendar timestampToGregCal(Timestamp ts) {
		String t = ts.toString();
		String[] tSplited = t.split(" ");
		String date = tSplited[0];
		String heure = tSplited[1];
		heure=heure.substring(0, 8);
		String[] dateSplited = date.split("-");
		String[] heureSplited = heure.split(":");
		int annees = Integer.parseInt(dateSplited[0]);
		int mois = Integer.parseInt(dateSplited[1]);
		int jours = Integer.parseInt(dateSplited[2]);
		int heures = Integer.parseInt(heureSplited[0]);
		int minutes = Integer.parseInt(heureSplited[1]);
		int secondes = Integer.parseInt(heureSplited[2]);

		return new GregorianCalendar(annees, mois, jours, heures, minutes,
				secondes);

	}
}
