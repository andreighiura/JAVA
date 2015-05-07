package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conn {

	public Conn() throws SQLException, ClassNotFoundException {

	}

	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {

		final String userName = "root";
		final String password = "123qweasdzxc";
		final String dbms = "mysql";
		final String serverName = "localhost";
		final String portNumber = "3306";
		final String dbName = "test";
		Connection conn;

		System.out.print("establishing connection" + "\n");

		Properties connectionProps = new Properties();

		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		String url = "jdbc:" + dbms + "://" + serverName + ":" + portNumber
				+ "/" + dbName;

		conn = DriverManager.getConnection(url, connectionProps);// connectionProps);

		if (conn == null) {
			System.out.print("Connection failed!");
		} else {
			System.out.println("Connected to database");
		}

		return conn;
	}
}
