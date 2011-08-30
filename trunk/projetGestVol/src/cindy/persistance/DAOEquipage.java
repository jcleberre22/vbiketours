package cindy.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import cindy.metier.comm.IPersistance;

/**
 * Lecture du fichier en vue d'exploiter 
 * les enregistrements d'equipage sur la base HSQL
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifié le 29/08/2011
 */
public class DAOEquipage implements IPersistance {

	/**
	 * Constructeur par defaut
	 */
	public DAOEquipage(){}

	/**
	 * Méthode qui permet la lecture de la table Equipage.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM equipage";

			Statement stmt = bdd.getStatement();

			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\n");

			}

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui de supprimer un tuple de la table Equipage.
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
		
			String requete1 = "DELETE FROM Equipage" + " WHERE idequipage=?";
		
			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}

	/**
	 * Méthode qui modifie un tuple de la table Equipage.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception
	 * @param obj[n] 
	 */
	@Override
	public void modifierPersistance(Object obj, Object obj2) throws SQLException, Exception {
		if(obj2 instanceof String == false || obj instanceof Integer == false){
			
			throw new RuntimeException("Parametre incorrect");
			
		}
		
		String param1 = (String)obj2;
		int param2 = (Integer)obj;
		
		try {
			
			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE equipage SET libelleequipage=?" + " WHERE idequipage=?";
			
			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			
			prSt1.setString(1, param1);
			prSt1.setInt(2, param2);
			prSt1.executeUpdate();
			prSt1.close();
			
			
		} catch (Exception e) {
				e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table Equipage.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void insererPersistance(Object obj, Object obj2) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false){
			
			throw new RuntimeException("Parametre incorrect");
			
		}
		
		int paramInt = (Integer)obj;
		String paramStr = (String)obj2;
		
		try {
			
			AccesBDD bdd = AccesBDD.getInstance();
			
			String requete1 = "INSERT INTO equipage" + "(idequipage,libelleequipage)" + 
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
	
	/**
	 * Méthode de Test.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		DAOEquipage bdd = new DAOEquipage();
		
		bdd.insererPersistance(1, "fdsgf");
		
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
