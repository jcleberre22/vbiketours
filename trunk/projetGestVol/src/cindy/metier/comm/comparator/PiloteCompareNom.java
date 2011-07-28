package cindy.metier.comm.comparator;

import java.util.Comparator;

import cindy.metier.comm.IPersonnelNavigant;

public class PiloteCompareNom implements Comparator<IPersonnelNavigant> {

	@Override
	public int compare(IPersonnelNavigant o1, IPersonnelNavigant o2) {
		return o1.getNom().compareTo(o1.getNom());
	}

}
