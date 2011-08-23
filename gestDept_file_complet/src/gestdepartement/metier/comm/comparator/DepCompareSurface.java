package gestdepartement.metier.comm.comparator;

import gestdepartement.metier.comm.IDepartementConsultable;

import java.util.Comparator;

public class DepCompareSurface implements Comparator<IDepartementConsultable> {

	@Override
	public int compare(IDepartementConsultable o1, IDepartementConsultable o2) {
		 return o1.getSuperficie() - o2.getSuperficie();
	}
}

