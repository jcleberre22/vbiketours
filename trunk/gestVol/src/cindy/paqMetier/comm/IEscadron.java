package cindy.paqMetier.comm;

import java.util.ArrayList;
import cindy.paqMetier.personnel.Pilote;

public interface IEscadron {
	
	public ArrayList<Pilote> getPilotes();

	public String getNomEscadron();
}