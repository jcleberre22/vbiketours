package gestdepartement.persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		Properties prop = new Properties(); //instanciation 

		prop.load(new FileInputStream("test.properties")); //chargement du fichier

	//	String valeurCle1 = prop.getProperty("modified" ); //obtention de la valeur d’une cle

		
		
	/*	Class.forName( "org.hsqldb.jdbcDriver" );
	
		String url = "jdbc:hsqldb:hsql://127.0.0.1"; // URL de la BDD
		Connection cnx = DriverManager.getConnection(url,"sa","");
	
		
		String requete = "SELECT * FROM departement";
		
		Statement stmt = cnx.createStatement();
		
		ResultSet rs = stmt.executeQuery (requete);
		
		while (rs.next()){
			System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
					+rs.getString(3)+"\t\t\t\t"+rs.getInt(4)+"\t"+
					rs.getInt(5)+"\t"+rs.getInt(6)+"\n");
			
		}

		stmt.close();
		
		cnx.close(); 
	 */
		
		
	}

}
