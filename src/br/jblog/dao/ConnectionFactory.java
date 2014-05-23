package br.jblog.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Properties p = new Properties();
				p.load(new FileInputStream("config.ini"));
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = (Connection) DriverManager.getConnection(
						"jdbc:oracle:thin:@" + p.getProperty("DBHost") + "",
						p.getProperty("DBUser"), p.getProperty("DBPassword"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return con;
	}

}
