package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cindy.metier.comm.ICategorie;
import cindy.metier.comm.ICategoriePersistant;
import cindy.metier.vol.Categorie;


/**
 * Lecture du fichier en vue d'exploiter 
 * les enregistrements d'une categorie sur la base HSQL
 * 
 * @author Nicolas.tabuteaud
 * @version 1.0 du 25/07/2011 modifié le 29/08/2011
 */
public class DAOCategorie implements ICategoriePersistant {

	private List<ICategorie> listeCategories;

	/**
	 * Constructeur par defaut
	 */
	public DAOCategorie(){
		listeCategories= new ArrayList<ICategorie>();
	}

	/**
	 * Méthode qui permet la lecture de la table Categorie.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	public void lire()throws SQLException,Exception{

		try{
			
			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM categorie";

			Statement stmt = bdd.getStatement();

			ResultSet rs = stmt.executeQuery(requete);

			while (rs.next()){
				System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\n");
				ICategorie cat=new Categorie(rs.getInt(1),rs.getString(2));
				listeCategories.add(cat);

			}

		}catch(Exception e){

			

		}

	}

	/**
	 * Méthode qui de supprimer un tuple de la table Categorie.
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

			String requete1 = "DELETE FROM categorie" + " WHERE idcategorie=?";

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
	public void modifierPersistance(Object obj, Object obj2) throws SQLException, Exception {
		if(obj instanceof Integer == false || obj2 instanceof String == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int param1 = (Integer)obj;
		String param2 = (String)obj2;
		

		try {

			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE categorie SET libellecategorie=?" + " WHERE idcategorie=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);

			prSt1.setString(1, param2);
			prSt1.setInt(2, param1);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table Categorie.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	public void insererPersistance(Object obj, Object obj2) throws SQLException, Exception {

		if(obj instanceof Integer == false || obj2 instanceof String == false){

			throw new RuntimeException("Parametre incorrect");

		}

		int paramInt = (Integer)obj;
		String paramStr = (String)obj2;

		try {

			AccesBDD bdd = AccesBDD.getInstance();

			String requete1 = "INSERT INTO categorie" + "(idcategorie,libellecategorie)" + 
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

	public List<ICategorie> getListeCategories() throws SQLException, Exception {
		lire();
		return listeCategories;
	}

	/**
	 * Méthode de Test.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		DAOCategorie bdd = new DAOCategorie();

		bdd.insererPersistance(6,"insertion");

		bdd.lire();

		System.out.println("******************************");

		bdd.modifierPersistance(6,"modification");

		bdd.lire();

		System.out.println("******************************");


		bdd.supprimerPersistance(6);
		
		bdd.lire();
		



	}


}
