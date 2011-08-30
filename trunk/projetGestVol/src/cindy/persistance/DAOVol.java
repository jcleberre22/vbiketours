package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import cindy.metier.comm.IVolPersistant;

/**
 * Classe DAOVol. Classe permettant de gerer la persistance des vols 
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 29/08/2011
 */
public class DAOVol implements IVolPersistant{
	
	/**
	 * Constructeur par defaut
	 */
	public DAOVol(){}

	/**
	 * Méthode qui permet la lecture de la table Armement.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM vol";

			Statement stmt = bdd.getStatement();

			//executeQuery quand c'est un select
			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getDate(4)+" "+rs.getDate(4).getTime()+"\t"+rs.getDate(5)+"\t"+rs.getBoolean(6)+"\n");

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

			String requete1 = "DELETE FROM Vol" + " WHERE idvol=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui modifie un tuple de la table Categorie.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) throws SQLException, Exception {
		if(obj instanceof Integer == false || obj2 instanceof Integer == false || obj3 instanceof Integer == false || obj4 instanceof Date == false || obj5 instanceof Date == false || obj6 instanceof Boolean == false){

			throw new RuntimeException("Parametre incorrect");

		}
		int paramInt2 = (Integer)obj2;
		int paramInt3 = (Integer)obj3;
		Date paramDate= (Date)obj4;
		Date paramDate2= (Date)obj5;
		Boolean paramBool= (Boolean)obj6;
		int paramInt= (Integer)obj;

		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE vol SET circulation=?, categorie=?, datedecollage=? ,dateatterrissage=?, annulation=?" + " WHERE idvol=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt2);
			prSt1.setInt(2, paramInt3);
			prSt1.setDate(3, new java.sql.Date(paramDate.getTime()));
			prSt1.setDate(4, new java.sql.Date(paramDate2.getTime()));
			prSt1.setBoolean(5, paramBool);
			prSt1.setInt(6, paramInt);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table Armement.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof Integer == false || obj3 instanceof Integer == false || obj4 instanceof Date == false || obj5 instanceof Date == false || obj6 instanceof Boolean == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int paramInt2 = (Integer)obj2;
		int paramInt3 = (Integer)obj3;
		Date paramDate= (Date)obj4;
		Date paramDate2= (Date)obj5;
		Boolean paramBool= (Boolean)obj6;
		int paramInt= (Integer)obj;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO vol" + "(idvol, circulation, categorie, datedecollage, dateatterrissage, annulation)" + 
			"VALUES(?,?,?,?,?,?)";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt);
			prSt1.setInt(2, paramInt2);
			prSt1.setInt(3, paramInt3);
			prSt1.setDate(4, new java.sql.Date(paramDate.getTime()));
			prSt1.setDate(5, new java.sql.Date(paramDate2.getTime()));
			prSt1.setBoolean(6, paramBool);
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

		DAOVol bdd = new DAOVol();
		System.out.println("insert");
		bdd.insererPersistance(12, 1, 1, new GregorianCalendar(2011,8,29,10,00,00).getTime(), new GregorianCalendar(2011,8,30,14,00,00).getTime(), true);

		System.out.println("******************************");
		System.out.println("read");
		bdd.lire();

		System.out.println("******************************");

		//		System.out.println("update");
		//		bdd.modifierPersistance(1, "56265ALH","chasseur",3,59,true,false);
		//		
		//		System.out.println("******************************");
		//		System.out.println("read");
		//		bdd.lire();
		//		System.out.println("******************************");
		//		
		//		System.out.println("insert2");		
		//		bdd.insererPersistance(2, "47857LKH","pêche",3,15,false,false);
		//		System.out.println("insert3");
		//		bdd.insererPersistance(3, "56286UJH","balade",3,110,false,false);
		//		
		//		System.out.println("******************************");
		//		System.out.println("read");
		//		bdd.lire();
		//		System.out.println("******************************");
		//		
		//		//bdd.supprimerPersistance(1);
		//		System.out.println("delete");
		//		bdd.supprimerPersistance(2);
		//		//bdd.supprimerPersistance(3);
		//
		//		System.out.println("******************************");
		//		bdd.lire();
		//		System.out.println("******************************");


	}
}
