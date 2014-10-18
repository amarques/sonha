package br.com.fiap.sonha.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private String url = "jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL";
	private String user = "OPS$RM71749";
	private String password = "070187";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,user,password);
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} 
	}
}
