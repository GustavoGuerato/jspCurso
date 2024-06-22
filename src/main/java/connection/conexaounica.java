package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Responsável por fazer a conexão ao banco de dados PostgreSQL
 */
public class conexaounica {

	private static final String URL = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";
	private static Connection connection = null;

	static {
		conectar();
	}

	private conexaounica() {
		conectar();
	}

	public static void conectar() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				connection.setAutoCommit(false);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados", e);
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
