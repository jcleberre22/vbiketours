package cindy.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import cindy.metier.comm.IVol;
import cindy.metier.comm.IVolPersistant;
import cindy.metier.vol.Vol;
import cindy.outils.Outils;

/**
 * Classe DAOVol. Classe permettant de gerer la persistance des vols 
 * 
 * @author LE BERRE J.Christophe
 * @version 1.0 du 29/08/2011
 */
public class DAOVol implements IVolPersistant{
	
	private List<IVol> listeVols;
	
	/**
	 * Constructeur par defaut
	 */
	public DAOVol(){
		listeVols=new ArrayList<IVol>();
	}
	
	/**
	 * Méthode qui permet la lecture de la table Vol.
	 * La requete s'effectue à l'aide d'un SELECT.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 */
	@Override
	public void lire()throws SQLException,Exception{
		
		listeVols=new ArrayList<IVol>();
		try{

			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM vol";

			Statement stmt = bdd.getStatement();

			//executeQuery quand c'est un select
			ResultSet rs = stmt.executeQuery(requete);
			
			System.out.println("Obtention de la liste des vols");
			
			while (rs.next()){
				GregorianCalendar gCDecol=Outils.timestampToGregCal(rs.getTimestamp(4));
				GregorianCalendar gCAtter=Outils.timestampToGregCal(rs.getTimestamp(5));
				IVol vol=new Vol(rs.getInt(1),rs.getInt(2),rs.getInt(3),gCDecol,gCAtter,rs.getBoolean(6));
				listeVols.add(vol);			
			}
		}catch(Exception e){

			e.printStackTrace();

		}
	}
	

	

	/**
	 * Méthode qui de supprimer un tuple de la table Vol.
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

			String requete =  "DELETE FROM sortieaerienne WHERE vol=?";
			String requete1 = "DELETE FROM Vol" + " WHERE idvol=?";

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();

		}catch(Exception e){

			e.printStackTrace();

		}

	}

	/**
	 * Méthode qui modifie un tuple de la table Vol.
	 * La requete s'effectue à l'aide d'un UPDATE.
	 * La méthode est englobé dans un try catch.
	 * @throws SQLException, Exception 
	 * @param obj[n]
	 */
	@Override
	public void modifierPersistance(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) throws SQLException, Exception {
		//idt est un entier donc il faut passer l'obj en entier.
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
			prSt1.setTimestamp(3, new Timestamp(paramDate.getTime()));
			prSt1.setTimestamp(4, new Timestamp(paramDate2.getTime()));
			prSt1.setBoolean(5, paramBool);
			prSt1.setInt(6, paramInt);
			prSt1.executeUpdate();
			prSt1.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Méthode qui insere un tuple dans la table Vol.
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
			prSt1.setTimestamp(4, new Timestamp(paramDate.getTime()));
			prSt1.setTimestamp(5, new Timestamp(paramDate2.getTime()));
			prSt1.setBoolean(6, paramBool);
			prSt1.executeUpdate();
			prSt1.close();



		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<IVol> getListeVols() throws SQLException, Exception {
		lire();
		return listeVols;
	}

	/**
	 * Méthode de Test.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		DAOVol bdd = new DAOVol();
//		System.out.println("******************************");
//		System.out.println("read1");
//		bdd.lire();
//
//		System.out.println("******************************");
//		
//		System.out.println("insert");
		//bdd.insererPersistance(15, 1, 1, new GregorianCalendar(2011,8,29,10,0,0).getTime(), new GregorianCalendar(2011,8,30,14,0,0).getTime(), true);
//
//		System.out.println("******************************");
//		System.out.println("read1");
//		bdd.lire();
//
//		System.out.println("******************************");
//
//		System.out.println("update");
//		bdd.modifierPersistance(11, 1, 1, new GregorianCalendar(2010,8,29,14,0,0).getTime(), new GregorianCalendar(2011,8,30,12,0,0).getTime(), false);
//
//		System.out.println("******************************");
//		System.out.println("read2");
//		bdd.lire();
//		System.out.println("******************************");
//
//		System.out.println("delete");
		bdd.supprimerPersistance(0);
//
//
//		System.out.println("******************************");
//		System.out.println("read3");
//		bdd.lire();
//		System.out.println("******************************");


	}
}
