package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DBOitems {
	public DBOitems(){};
	
	public void insert(String name, int id, java.sql.Connection conn) {
		System.out.print("inserting item..." + "\n");
		String sql = "INSERT INTO items \n" + "VALUES ('" + name + "','" + id
				+ "')";
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void dropTable(Connection conn) {
		System.out.print("droping table items \n");
		String sql = "DROP TABLE items" ;
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public ResultSet selectAll(java.sql.Connection conn) {
		System.out.print("getting records from table items \n");
		String sql = "SELECT * \n FROM items ";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
}
