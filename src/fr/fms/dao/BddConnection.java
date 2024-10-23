/** Création de la connection à partir des données de connection dans CreateConfigFile  **/

package fr.fms.dao;

import java.util.Properties;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddConnection {

	private static Connection connection = null;
	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	
	private static final Logger logger = Logger.getLogger(BddConnection.class.getName());

	
	private BddConnection() {
		try {
			getConfigFile();								
			Class.forName(driver);	
			connection = DriverManager.getConnection(url,login,password);				
			if(connection != null) logger.info("access bdd success"); 
		}			
		catch (ClassNotFoundException | SQLException e) {
			logger.severe("La connection n'a pu être établie : " + e.getMessage());
		}
		catch (FileNotFoundException e) {
			logger.severe("Le fichier config.properties n'existe pas :" + e.getMessage());
		} 
		catch (IOException e) {
			logger.severe("La communication n'a pu être établie : " + e.getMessage());
		}
		catch (Exception e) {
			logger.severe("Nous avons rencontré un problème : " + e.getMessage());
		}
	}
	
	/** méthode qui retourne la connection si existante, une seule fois **/
	
	public static synchronized Connection getConnection() {	
		if(connection == null) 	new BddConnection();
		return connection;
	}
	/** méthode qui ouvre le fichier config d'une connection**/
	private static void getConfigFile() throws FileNotFoundException, IOException {
		Properties properties = new Properties();		
		try (FileInputStream fis = new FileInputStream("files/config.properties")){
			properties.load(fis);
			System.out.println("Connection ouverte");
		} catch (FileNotFoundException e1) {
			logger.severe("Fichier de config non trouvé " + e1.getMessage());
		} catch (IOException e1) {
			logger.severe("Erreur de lecture du fichier config " + e1.getMessage());
		}		
		driver = properties.getProperty("db.driver");
		url = properties.getProperty("db.url");
		login = properties.getProperty("db.login");
		password = properties.getProperty("db.password");
	}


}
