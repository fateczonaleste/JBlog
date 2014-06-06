package br.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	/*
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
	
	*/
	
	public static Connection getConnection() {
        try {
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
            String usuario = "system";
            String senha = "123456";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return  DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {             
            System.out.println("Erro de conexao");
            e.printStackTrace();
            return null;
        }
	 }
	 
	

}
