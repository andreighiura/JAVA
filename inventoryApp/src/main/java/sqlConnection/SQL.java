package sqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SQL {
	private String userName;
	private String password;
	private String dbms;
	private String serverName;
	private String portNumber;
	private String dbName;
	private Connection conn;
	private Statement stmt;

	public SQL() throws SQLException, ClassNotFoundException {
		this.userName = "root";
		this.password = "123qweasdzxc";
		this.dbName = "test";
		this.portNumber = "3306";
		this.dbms = "mysql";
		this.serverName = "localhost";
		this.conn = this.getConnection();

	}

	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException,
			ClassNotFoundException {
		System.out.print("establishing connection" + "\n");

		Properties connectionProps = new Properties();

		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		String url = "jdbc:" + this.dbms + "://" + this.serverName + ":"
				+ this.portNumber + "/" + this.dbName;

		// Class.forName("JDBC_DRIVER");

		conn = DriverManager.getConnection(url, connectionProps);// connectionProps);

		if (conn == null) {
			System.out.print("Connection failed!");
		} else {
			System.out.println("Connected to database");
		}

		return conn;
	}

	public void insertItems(String name, String id) {
		System.out.print("inserting item..." + "\n");
		String sql = "INSERT INTO items \n" + "VALUES ('" + name + "','" + id
				+ "')";
		Statement stmt = null;

		try {
			stmt = this.conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createTableItems() {

		System.out.print("Creating items table: ------------" + "\n");
		String sql = "create table items ( name nchar(10), id int(10))";
		try {
			stmt = this.conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dropTable(String table) {
		System.out.print("droping table " + table + "\n");
		String sql = "DROP TABLE " + table;
		try {
			stmt = this.conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ResultSet selectAll(String table) {
		System.out.print("getting records from table " + table + "\n");
		String sql = "SELECT * \n FROM " + table;
		ResultSet rs = null;
		try {
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

}
