package serveur;

import java.sql.Connection;
import java.sql.Statement;

import org.hsqldb.jdbc.jdbcDataSource;

public class Arreter {
	public static void main(String[] args) {
		Connection cnx;
		jdbcDataSource dataSource= new jdbcDataSource();
		dataSource.setDatabase("jdbc:hsqldb:hsql://127.0.0.1");
		dataSource.setUser("sa");
		dataSource.setPassword("");
		try{
			cnx =  dataSource.getConnection();
			Statement statement;
			statement = cnx.createStatement();
			statement.executeQuery("SHUTDOWN");
			statement.close();
			System.out.println("la base de donnée est arretée");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
