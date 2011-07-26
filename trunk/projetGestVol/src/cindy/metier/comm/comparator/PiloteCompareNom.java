package cindy.metier.comm.comparator;

import java.util.Comparator;

import cindy.metier.comm.IPersonnelNaviguant;

public class PiloteCompareNom implements Comparator<IPersonnelNaviguant> {

	@Override
	public int compare(IPersonnelNaviguant o1, IPersonnelNaviguant o2) {
		return o1.getNom().compareTo(o1.getNom());
	}

}
