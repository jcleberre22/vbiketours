package serveur;

import java.sql.Connection;
import java.sql.Statement;
import org.hsqldb.jdbc.JDBCDataSource;


public class Arreter {
	public static void main(String[] args) {
		Connection cnx;
		JDBCDataSource dataSource= new JDBCDataSource();
		dataSource.setDatabase("jdbc:hsqldb:hsql://127.0.0.1");
		dataSource.setUser("sa");
		dataSource.setPassword("");
		try{
			cnx =  dataSource.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			statement.executeQuery("SHUTDOWN");
			statement.close();
			System.out.println("la base de donn�e est arret�e");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
