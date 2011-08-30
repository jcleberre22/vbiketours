package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cindy.metier.comm.IPersistance;


/**
 * Lecture du fichier en vue d'exploiter 
 * les enregistrements d'un escadron sur la base HSQL
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifi� le 29/08/2011
 */
public class DAOEscadron implements IPersistance {

	/**
	 * Constructeur par defaut
	 */
	public DAOEscadron(){}

	/**
	 * M�thode qui permet la lecture de la table Escadron.
	 * La requete s'effectue � l'aide d'un SELECT.
	 * La m�thode est englob� dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{

		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM escadron";

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
	 * M�thode qui de supprimer un tuple de la table Escadron.
	 * La requete s'effectue � l'aide d'un DELETE FROM.
	 * La m�thode est englob� dans un try catch.
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

			String requete1 = "DELETE FROM escadron" + " WHERE idescadron=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * M�thode qui modifie un tuple de la table Escadron.
	 * La requete s'effectue � l'aide d'un UPDATE.
	 * La m�thode est englob� dans un try catch.
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
			String requete1 = "UPDATE escadron SET libelleescadron=?" + " WHERE idescadron=?";

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
	 * M�thode qui insere un tuple dans la table Escadron.
	 * La requete s'effectue � l'aide d'un UPDATE.
	 * La m�thode est englob� dans un try catch.
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

			String requete1 = "INSERT INTO escadron" + "(idescadron,libelleescadron)" + 
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
	 * M�thode de Test.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		DAOEscadron bdd = new DAOEscadron();

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
