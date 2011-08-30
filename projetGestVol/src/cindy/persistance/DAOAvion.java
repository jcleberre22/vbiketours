package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cindy.metier.comm.IAvionPersistant;

/**
 * Classe DAOAvion. Classe permettant de gerer la persistance des avions 
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 29/08/2011
 */
public class DAOAvion implements IAvionPersistant{

	/**
	 * Constructeur par defaut
	 */
	public DAOAvion(){}

	/**
	 * Méthode qui permet la lecture de la table Avion.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM avion";

			Statement stmt = bdd.getStatement();

			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getBoolean(6)+"\t"+rs.getBoolean(7)+"\n");

			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui de supprimer un tuple de la table Armement.
	 * La requete s'effectue à l'aide d'un DELETE FROM.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void supprimerPersistance(Object obj) throws SQLException, Exception {
		if(obj instanceof Integer == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int param = (Integer)obj;

		try{
			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "DELETE FROM Avion" + " WHERE idavion=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui modifie un tuple de la table Avion.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false || obj3 instanceof String == false || obj4 instanceof Integer == false || obj5 instanceof Integer == false || obj6 instanceof Boolean == false || obj7 instanceof Boolean == false){

			throw new RuntimeException("Parametre incorrect");

		}
		int paramInt = (Integer)obj;
		String param1 = (String)obj2;
		String paramStr2 = (String)obj3;
		int paramInt2 = (Integer)obj4;
		int paramInt3 = (Integer)obj5;
		boolean paramBool= (Boolean)obj6;
		boolean paramBool2= (Boolean)obj7;

		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE avion SET immatriculation=?,typeavion=?,armeavion=?,heuresdevol=?,indisponibilite=?,transfert=?" + " WHERE idavion=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setString(1, param1);
			prSt1.setString(2, paramStr2);
			prSt1.setInt(3, paramInt2);
			prSt1.setInt(4, paramInt3);
			prSt1.setBoolean(5, paramBool);
			prSt1.setBoolean(6, paramBool2);
			prSt1.setInt(7, paramInt);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table Avion.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false || obj3 instanceof String == false || obj4 instanceof Integer == false || obj5 instanceof Integer == false || obj6 instanceof Boolean == false || obj7 instanceof Boolean == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int paramInt = (Integer)obj;
		String paramStr = (String)obj2;
		String paramStr2 = (String)obj3;
		int paramInt2 = (Integer)obj4;
		int paramInt3 = (Integer)obj5;
		boolean paramBool= (Boolean)obj6;
		boolean paramBool2= (Boolean)obj7;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO avion" + "(idavion,immatriculation,typeavion,armeavion,heuresdevol,indisponibilite,transfert)" + 
			"VALUES(?,?,?,?,?,?,?)";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt);
			prSt1.setString(2, paramStr);
			prSt1.setString(3, paramStr2);
			prSt1.setInt(4, paramInt2);
			prSt1.setInt(5, paramInt3);
			prSt1.setBoolean(6, paramBool);
			prSt1.setBoolean(7, paramBool2);
			prSt1.executeUpdate();
			prSt1.close();



		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	/**
	 * Méthode de Test.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		DAOAvion bdd = new DAOAvion();
		System.out.println("insert");
		bdd.insererPersistance(1, "56265ALH","chasse",1,54,false,false);

		System.out.println("******************************");
		System.out.println("read");
		bdd.lire();

		System.out.println("******************************");

		System.out.println("update");
		bdd.modifierPersistance(1, "56265ALH","chasseur",3,59,true,false);

		System.out.println("******************************");
		System.out.println("read");
		bdd.lire();
		System.out.println("******************************");

		System.out.println("insert2");		
		bdd.insererPersistance(2, "47857LKH","pêche",3,15,false,false);
		System.out.println("insert3");
		bdd.insererPersistance(3, "56286UJH","balade",3,110,false,false);

		System.out.println("******************************");
		System.out.println("read");
		bdd.lire();
		System.out.println("******************************");

		//bdd.supprimerPersistance(1);
		System.out.println("delete");
		bdd.supprimerPersistance(2);
		//bdd.supprimerPersistance(3);

		System.out.println("******************************");
		bdd.lire();
		System.out.println("******************************");


	}
}
