package gestdepartement.metier.comm.comparator;

import gestdepartement.metier.comm.IDepartementConsultable;

import java.util.Comparator;

public class DepCompareReg implements Comparator<IDepartementConsultable> {

	@Override
	public int compare(IDepartementConsultable o1, IDepartementConsultable o2) {
		 return o1.getAppartenance().compareTo(o2.getAppartenance());
	}

}
