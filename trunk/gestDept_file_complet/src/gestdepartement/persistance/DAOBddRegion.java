package gestdepartement.persistance;

import gestdepartement.metier.comm.IPaysPersistant;
import gestdepartement.metier.comm.IPersistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DAOBddRegion implements IPersistance, IClientLecture{
	
	private static final Logger LOG = Logger.getLogger(DAOBddRegion.class);
	private List<String> regionLues;
	private IPaysPersistant conteneur;
	
	/**
	 * On instancie la liste.
	 */
	public DAOBddRegion(){
		regionLues = new ArrayList<String>();
	}
	
	/* SELECT, DELETE, UPDATE, INSERT */
	
	public void lireRegion() throws SQLException,Exception{
	
		try{
			
			AccesBDD bdd = AccesBDD.getInstance();

			String requete = "SELECT * FROM region";
			
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
	
	public void supprimerRegionPersistance(Object obj) throws SQLException,Exception{
		//idt est un entier donc il faut passer l'obj en entier.
		if(obj instanceof Integer == false){
			
			throw new RuntimeException("Parametre incorrect");
			
		}
		
		int param = (Integer)obj;
		
		try{
			AccesBDD bdd = AccesBDD.getInstance();
		
			String requete1 = "DELETE FROM region" + " WHERE idt=?";
		
			String requete2 = "DELETE FROM departement" + " WHERE idt_region=?";
		
			// pas dans l'ordre a cause des contraintes d'identité fonctionelle de la bdd
			PreparedStatement prSt2 = bdd.getPrepareStatment(requete2);
			prSt2.setInt(1, param);
			prSt2.executeUpdate();
			prSt2.close();

			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			prSt1.setInt(1, param);
			prSt1.executeUpdate();
			prSt1.close();
			
			//public FacadeMetier public void supprimerRegion(String nomReg)
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	public void modifierRegionPersistance(Object obj){
		
		//idt est un entier donc il faut passer l'obj en entier.
		if(obj instanceof Integer == false || obj instanceof String == false){
			
			throw new RuntimeException("Parametre incorrect");
			
		}
		
		int param1 = (Integer)obj;
		String param2 = (String)obj;
		
		try {
			
			AccesBDD bdd = AccesBDD.getInstance();
			String requete1 = "UPDATE region SET nom=?" + " WHERE idt=?";
			
			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			
			prSt1.setInt(2, param1);
			prSt1.setString(1, param2);
			prSt1.executeUpdate();
			prSt1.close();
			
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		
		
		
	}
	
	public void insererRegionPersistance(Object obj){
		
		
		if(obj instanceof Integer == false || obj instanceof String == false){
			
			throw new RuntimeException("Parametre incorrect");
			
		}
		
		int paramInt = (Integer)obj;
		String paramStr = (String)obj;
		
		try {
			
			AccesBDD bdd = AccesBDD.getInstance();
			
			String requete1 = "INSERT INTO region" + "(idt,nom)" + 
								"VALUES(?,?)";
			
			PreparedStatement prSt1 = bdd.getPrepareStatment(requete1);
			
			prSt1.setInt(2, paramInt);
			prSt1.setString(1, paramStr);
			prSt1.executeUpdate();
			prSt1.close();
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void lireTous(Object conteneur) {
		exploiteConteneur(conteneur);
		LecteurCSV lecteur = new LecteurCSV(this);
		lecteur.lire("persistanceFile.csv");
		LOG.debug(lecteur.rapporter());
		LOG.debug("region(s) ajoutée(s) "+regionLues.size());
		
	}
	
	@Override
	public void quitter(Object conteneur) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void exploiteEnregistrement(String[] lesChamps, int numLigne) {
		if (numLigne == 0){//on saute la premier ligne
			return;
		}
		if (regionLues.contains(lesChamps[4])==false){
			conteneur.ajouterRegion(lesChamps[4]);
			regionLues.add(lesChamps[4]);
			LOG.debug(lesChamps[4]);
		}
		
	}
	
	//METHODES PRIVEES
	private void exploiteConteneur(Object cont) {
		if (cont instanceof IPaysPersistant == false){
			throw new RuntimeException ("la persistance de la region ne sait travailler qu'avec un IPaysPersistant");
		}
		conteneur = (IPaysPersistant) cont;
	}
		
	public static void main(String[] args) throws Exception {
		
		DAOBddRegion dbdd = new DAOBddRegion();
		
		dbdd.lireRegion();
		
		
		
	}






	
	
	

}
