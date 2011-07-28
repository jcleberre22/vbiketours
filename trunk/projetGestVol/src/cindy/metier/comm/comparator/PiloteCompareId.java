package cindy.metier.comm.comparator;

import java.util.Comparator;

import cindy.metier.comm.IPersonnelNavigant;

public class PiloteCompareId implements Comparator<IPersonnelNavigant> {

	@Override
	public int compare(IPersonnelNavigant o1, IPersonnelNavigant o2) {
		return o1.getId() - o2.getId();
	}

}
