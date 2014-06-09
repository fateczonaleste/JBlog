package com.github.easelias.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			String url = "jdbc:postgresql://127.0.0.1/jblog";
			String usuario = "jblog";
			String senha = "ptd1voem2";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			//throw new SQLException("Classe não encontrada.\n" + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		

	}

}
