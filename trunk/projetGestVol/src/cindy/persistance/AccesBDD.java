package cindy.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hsqldb.jdbc.jdbcDataSource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Offrir l'acces a la bdd, sous la forme de singleton.
 * Utilise un bean creer par spring.
 * @author JC.leberre
 * @version 1.0 du 19/08/2011
 */
public final class AccesBDD {
	/** acces au logger. */
	private static final Logger logger = Logger.getLogger(AccesBDD.class);
	/** la connexion avec la base de données. */
	private static Connection cnx;

	private static AccesBDD instance;

	private static String fileCnx = "cindy/persistance/dataSourceBean.xml";
	/**
	 * interdit l'instanciation de sorte a obliger 
	 * l'utilisation du singleton.
	 */
	private AccesBDD(){
		getInstanceConnexion();
	}

	public static AccesBDD getInstance(){
		if (instance == null) {
			instance = new AccesBDD();
		}
		return instance;
	}
	/**
	 * @return l'instance de connexion avec la bdd. 
	 */
	public static Connection getInstanceConnexion(){
		if (cnx == null){
			BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(fileCnx));
			jdbcDataSource dataSource= (jdbcDataSource) beanFactory.getBean("datasource");

			try {
				cnx =  dataSource.getConnection();
				logger.info("connexion réussi");
			} catch (SQLException e) {
				throw new RuntimeException("probleme a l'ouverture de la bdd");
			}
		}
		return cnx;
	}

	/**
	 * Force l'enregistrement des informations restées en mémoire.
	 */
	public static void fermer(){
		try {
			cnx.close();
			instance = null;
			cnx = null;
			logger.info("déconnexion réussi");
		} catch (SQLException e) {
			throw new RuntimeException("probleme a la fermeture de la bdd");
		}
	}

	/**
	 * Test.
	 */
	public static void main(String[] args) {
		AccesBDD.getInstanceConnexion();
		AccesBDD.fermer();
	}

	public Statement getStatement() {
		if (cnx == null){
			throw new RuntimeException("Aucune connexion a la base de données n'est active.");
		}
		try {
			return cnx.createStatement();
		} catch (SQLException e) {
			throw new RuntimeException("Impossible d'obtenir un statement!!.");
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
}
