package br.com.celular.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Fera2001#mysql";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/celularcrud";
	
	public static Connection createConnectionToMySQL() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	public static void main(String[] args) throws Exception {
		
		Connection conn = createConnectionToMySQL();
		if(conn != null) {
			System.out.println("Conexão estabelecida com sucesso");
			conn.close();
		}
		
	}

}
