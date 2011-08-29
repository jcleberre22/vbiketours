package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cindy.metier.comm.IPilotePersistance;

/**
 * Lecture du fichier en vue d'exploiter 
 * les enregistrements d'un pilote sur la base HSQL
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifi� le 29/08/2011
 */
public class DAOPilote implements IPilotePersistance{

	public DAOPilote() {}

	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM pilote";

			Statement stmt = bdd.getStatement();

			//executeQuery quand c'est un select
			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+
						"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+
						"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\t"+rs.getString(9)+
						"\t"+rs.getInt(10)+"\t"+rs.getInt(11)+"\t"+rs.getBoolean(12)+"\n");

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

			String requete1 = "DELETE FROM pilote" + " WHERE idpilote=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	@Override
	public void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) throws SQLException, Exception {
		if(obj instanceof String == false || obj2 instanceof String == false 
				|| obj3 instanceof String == false || obj4 instanceof String == false || obj5 instanceof Integer == false
				|| obj6 instanceof Integer == false || obj7 instanceof Integer == false || obj8 instanceof String == false
				|| obj9 instanceof Integer == false || obj10 instanceof Integer == false || obj11 instanceof Boolean == false || obj12 instanceof Integer == false ){

			throw new RuntimeException("Parametre incorrect");

		}

		
		String param1 = (String)obj;
		String param2 = (String)obj2;
		String param3 = (String)obj3;
		String param4 = (String)obj4;
		int param5 = (Integer)obj5;
		int param6 = (Integer)obj6;
		int param7 = (Integer)obj7;
		String param8 = (String)obj8;
		int param9 = (Integer)obj9;
		int param10 = (Integer)obj10;
		Boolean param11 = (Boolean)obj11;
		int param12 = (Integer)obj12;
		

		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE pilote SET nia=?,nid=?,nompilote=?,prenompilote=?,qualification=?,equipage=?," +
					"escadron=?,role=?,nbsortiesaeriennes=?,nbheuresdevol=?,examendevol=?" + " WHERE idpilote=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			
			prSt1.setString(1, param1);
			prSt1.setString(2, param2);
			prSt1.setString(3, param3);
			prSt1.setString(4, param4);
			prSt1.setInt(5, param5);
			prSt1.setInt(6, param6);
			prSt1.setInt(7, param7);
			prSt1.setString(8, param8);
			prSt1.setInt(9, param9);
			prSt1.setInt(10, param10);
			prSt1.setBoolean(11, param11);
			prSt1.setInt(12, param12);
			
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6,
			Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false || obj3 instanceof String == false 
				|| obj4 instanceof String == false || obj5 instanceof String == false || obj6 instanceof Integer == false
				|| obj7 instanceof Integer == false || obj8 instanceof Integer == false || obj9 instanceof String == false
				|| obj10 instanceof Integer == false || obj11 instanceof Integer == false || obj12 instanceof Boolean == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int param1 = (Integer)obj;
		String param2 = (String)obj2;
		String param3 = (String)obj3;
		String param4 = (String)obj4;
		String param5 = (String)obj5;
		int param6 = (Integer)obj6;
		int param7 = (Integer)obj7;
		int param8 = (Integer)obj8;
		String param9 = (String)obj9;
		int param10 = (Integer)obj10;
		int param11 = (Integer)obj11;
		Boolean param12 = (Boolean)obj12;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO pilote" + "(idpilote,nia,nid,nompilote,prenompilote,qualification,equipage," +
					"escadron,role,nbsortiesaeriennes,nbheuresdevol,examendevol)" + 
			"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, param1);
			prSt1.setString(2, param2);
			prSt1.setString(3, param3);
			prSt1.setString(4, param4);
			prSt1.setString(5, param5);
			prSt1.setInt(6, param6);
			prSt1.setInt(7, param7);
			prSt1.setInt(8, param8);
			prSt1.setString(9, param9);
			prSt1.setInt(10, param10);
			prSt1.setInt(11, param11);
			prSt1.setBoolean(12, param12);
			prSt1.executeUpdate();
			prSt1.close();



		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public static void main(String[] args) throws Exception {

		DAOPilote bdd = new DAOPilote();

	//	bdd.insererPersistance(1,"161SV4","AL25GJH","TABUTEAUD","Nicopops",1,1,1,"tireur au flanc",0,1,true);

		bdd.lire();

		System.out.println("******************************");

		bdd.modifierPersistance("161SV4","AL25GJH","TABUTEAUD","fdsf",1,1,1,"tireur au flanc",0,1,true,1);

		bdd.lire();
/*
		System.out.println("******************************");

		bdd.insererPersistance(2, "Coq");

		bdd.lire();

		bdd.supprimerPersistance(1);
		bdd.supprimerPersistance(2);

*/



	}
	
}
