package gestionecole.persistance.ado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * Outil sql.
 * 
 * @author marc.leconte
 * @version 1.0
 */
public class UtilSQL {
	/** acces au logger. */
	private static final Logger logger = Logger.getLogger(UtilSQL.class);

	private Connection cnx ;

	public UtilSQL(){
		cnx = AccesBDD.getInstance();
	}



	
	/**
	 * Specifique a hsql, fournit la derniere clef auto generée
	 * @return
	 */
	public int getGenerateKey(){
		int ret = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = cnx.createStatement();
			rs = stmt.executeQuery("call identity()");
			if (rs.next()) {
				ret = rs.getInt(1);
			}
		} catch (SQLException e) {
			traitementErreurRequete(e,"call identity()");	
		} finally {
			fermeture(stmt, rs);
		}
		return ret;
	}

	
}
