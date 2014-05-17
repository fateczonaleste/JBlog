package br.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection con;

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = (Connection) DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "FATEC");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return con;
	}

}
