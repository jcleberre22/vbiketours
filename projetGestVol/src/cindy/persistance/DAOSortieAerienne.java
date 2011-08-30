package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

import cindy.metier.comm.ISortieAeriennePersistant;

/**
 * Classe DAOSortieAerienne. Classe permettant de gerer la persistance des sorties aeriennes 
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 29/08/2011
 */
public class DAOSortieAerienne implements ISortieAeriennePersistant{
	
	/**
	 * Constructeur par defaut
	 */
	public DAOSortieAerienne(){}

	/**
	 * Méthode qui permet la lecture de la table SortieAerienne.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM sortieAerienne";

			Statement stmt = bdd.getStatement();

			//executeQuery quand c'est un select
			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getTimestamp(7)+"\t"+rs.getTimestamp(8)+"\t"+rs.getInt(9)+"\t"+rs.getString(10)+"\t"+rs.getString(11)+"\n");

			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui de supprimer un tuple de la table SortieAerienne.
	 * La requete s'effectue à l'aide d'un DELETE FROM.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void supprimerPersistance(Object obj) throws SQLException, Exception {
		//idt est un entier donc il faut passer l'obj en entier.
		if(obj instanceof Integer == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int param = (Integer)obj;

		try{
			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "DELETE FROM SortieAerienne" + " WHERE idsortie=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui modifie un tuple de la table SortieAerienne.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) throws SQLException, Exception {
		//idt est un entier donc il faut passer l'obj en entier.
		if(obj instanceof Integer == false || obj2 instanceof Integer == false || obj3 instanceof Integer == false || obj4 instanceof Integer == false || obj5 instanceof Integer == false || obj6 instanceof Integer == false || obj7 instanceof Date == false|| obj8 instanceof Date == false || obj9 instanceof Integer == false || obj10 instanceof String == false || obj11 instanceof String == false){

			throw new RuntimeException("Parametre incorrect");

		}
		int paramInt2 = (Integer)obj2;
		int paramInt3 = (Integer)obj3;
		int paramInt4 = (Integer)obj4;
		int paramInt5 = (Integer)obj5;
		int paramInt6 = (Integer)obj6;
		Date paramDate= (Date)obj7;
		Date paramDate2= (Date)obj8;
		int paramInt7 = (Integer)obj9;
		String paramString= (String)obj10;
		String paramString2= (String)obj11;
		int paramInt = (Integer)obj;


		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE sortieAerienne SET avion=?, armement=?, equipage=?, mission=?, vol=?, datedecollage=?, dateatterrissage=?, typeevenement=?, evenement=?, debriefing=?" + " WHERE idsortie=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt2);
			prSt1.setInt(2, paramInt3);
			prSt1.setInt(3, paramInt4);
			prSt1.setInt(4, paramInt5);
			prSt1.setInt(5, paramInt6);
			prSt1.setDate(6, new java.sql.Date(paramDate.getTime()));
			prSt1.setDate(7, new java.sql.Date(paramDate2.getTime()));
			prSt1.setInt(8, paramInt7);
			prSt1.setString(9, paramString);
			prSt1.setString(10, paramString2);
			prSt1.setInt(11, paramInt);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table SortieAerienne.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void insererPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof Integer == false || obj3 instanceof Integer == false || obj4 instanceof Integer == false || obj5 instanceof Integer == false || obj6 instanceof Integer == false || obj7 instanceof Date == false|| obj8 instanceof Date == false || obj9 instanceof Integer == false || obj10 instanceof String == false || obj11 instanceof String == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int paramInt2 = (Integer)obj2;
		int paramInt3 = (Integer)obj3;
		int paramInt4 = (Integer)obj4;
		int paramInt5 = (Integer)obj5;
		int paramInt6 = (Integer)obj6;
		Date paramDate= (Date)obj7;
		Date paramDate2= (Date)obj8;
		int paramInt7 = (Integer)obj9;
		String paramString= (String)obj10;
		String paramString2= (String)obj11;
		int paramInt = (Integer)obj;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO sortieAerienne" + "(idsortie, avion, armement, equipage, mission, vol, datedecollage, dateatterrissage, typeevenement, evenement, debriefing)" + 
			"VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setInt(1, paramInt);
			prSt1.setInt(2, paramInt2);
			prSt1.setInt(3, paramInt3);
			prSt1.setInt(4, paramInt4);
			prSt1.setInt(5, paramInt5);
			prSt1.setInt(6, paramInt6);
			prSt1.setDate(7, new java.sql.Date(paramDate.getTime()));
			prSt1.setDate(8, new java.sql.Date(paramDate2.getTime()));
			prSt1.setInt(9, paramInt7);
			prSt1.setString(10, paramString);
			prSt1.setString(11, paramString2);	
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

		DAOSortieAerienne bdd = new DAOSortieAerienne();
		System.out.println("insert");

		bdd.insererPersistance(7, 1, 1, 1, 1, 1,new GregorianCalendar(2011,8,29,10,0,0).getTime(), new GregorianCalendar(2011,8,30,14,0,0).getTime(), 1, "abc","def");

		System.out.println("******************************");
		System.out.println("read1");
		bdd.lire();

		System.out.println("******************************");

		System.out.println("update");
		bdd.modifierPersistance(7, 1, 1, 1, 1, 1,new GregorianCalendar(2010,2,12,10,0,0).getTime(), new GregorianCalendar(2011,6,23,14,0,0).getTime(), 1, "abc","def");

		System.out.println("******************************");
		System.out.println("read2");
		bdd.lire();
		System.out.println("******************************");


		System.out.println("delete");
		bdd.supprimerPersistance(7);


		System.out.println("******************************");
		System.out.println("read3");
		bdd.lire();
		System.out.println("******************************");


	}
}
