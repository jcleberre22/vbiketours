package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cindy.metier.comm.IPersistance;

/**
 * Lecture du fichier en vue d'exploiter 
 * les enregistrements d'une mission sur la base HSQL
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifié le 29/08/2011
 */
public class DAOMission implements IPersistance {

	public DAOMission() {}

	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM mission";

			Statement stmt = bdd.getStatement();

			//executeQuery quand c'est un select
			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\n");

			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	@Override
	public void supprimerPersistance(Object obj) throws SQLException, Exception {
		//idt est un entier donc il faut passer l'obj en entier.
		if(obj instanceof Integer == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int param = (Integer)obj;

		try{
			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "DELETE FROM mission" + " WHERE idmission=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	@Override
	public void modifierPersistance(Object obj, Object obj2) throws SQLException, Exception {
		if(obj2 instanceof String == false || obj instanceof Integer == false){

			throw new RuntimeException("Parametre incorrect");

		}

		String param1 = (String)obj2;
		int param2 = (Integer)obj;

		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE mission SET typemission=?" + " WHERE idmission=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setString(1, param1);
			prSt1.setInt(2, param2);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insererPersistance(Object obj, Object obj2) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int paramInt = (Integer)obj;
		String paramStr = (String)obj2;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO mission" + "(idmission,typemission)" + 
			"VALUES(?,?)";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt);
			prSt1.setString(2, paramStr);
			prSt1.executeUpdate();
			prSt1.close();



		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public static void main(String[] args) throws Exception {

		DAOMission bdd = new DAOMission();

		bdd.insererPersistance(1,"fdsf");

		bdd.lire();

		System.out.println("******************************");

		bdd.modifierPersistance(1,"poulet");

		bdd.lire();

		System.out.println("******************************");

		bdd.insererPersistance(2, "Coq");

		bdd.lire();

		bdd.supprimerPersistance(1);
		bdd.supprimerPersistance(2);




	}
}
