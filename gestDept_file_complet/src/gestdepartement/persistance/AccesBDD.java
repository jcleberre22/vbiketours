package gestdepartement.persistance;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;


public class AccesBDD {
	
	private static final Logger logger = Logger.getLogger(AccesBDD.class);
	
	private Connection cnx;
	
	//Création du Singleton
	private static AccesBDD instance;
	
	public static AccesBDD getInstance() throws Exception{
		
		if(instance == null){
			
			instance = new AccesBDD();
			return instance;
			
		}
		else{
			
			return instance;
			
		}
	}
	
	public AccesBDD() throws Exception {
		
		Properties pro = new Properties();
		try {
			
			pro.load(new FileInputStream("bdd.properties")); 
			Class.forName(pro.getProperty("driver"));
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String pwd = pro.getProperty("pwd");
			cnx = DriverManager.getConnection(url,user,pwd);
			logger.info("connexion réussi");
			
		} catch (SQLException e) {
			throw new RuntimeException("probleme a l'ouverture de la bdd");
		}

	}
	
	public void deconnecter()throws SQLException{
		try {
			cnx.close();
			instance = null;
			logger.info("déconnexion réussi");
		} catch (SQLException e) {
			throw new RuntimeException("probleme a la fermeture de la bdd");
		}
	}
	
	public Statement getStatement() throws SQLException{
		
		try {
			return cnx.createStatement();
		} catch (SQLException e) {
			logger.fatal(e.getMessage());
			throw new RuntimeException("Probleme a l'obtention du statement "+e.getMessage());
		}
		
	}
	public PreparedStatement getPrepareStatment(String sql) {
		try {
			return cnx.prepareStatement(sql);
		} catch (SQLException e) {
			logger.fatal(e.getMessage());
			throw new RuntimeException("Probleme a l'obtention du preparedstatement " + sql+ " erreur:"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
		AccesBDD bdd = AccesBDD.getInstance();
		bdd.deconnecter();
		} catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}


}
