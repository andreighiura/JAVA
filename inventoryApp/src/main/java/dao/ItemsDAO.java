package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

public class ItemsDAO {

	public void insert(String name, int id, String owner, Connection conn)
			throws SQLException {
		System.out.print("inserting item..." + "\n");
		String sqlString = "INSERT INTO items VALUES (?,?,?)";
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		sql.setString(1, name);
		sql.setInt(2, id);
		sql.setString(3, owner);
		sql.execute();
	}

	public void dropTable(Connection conn) throws SQLException {
		System.out.print("droping table items \n");
		String sqlString = "DROP TABLE items";
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		sql.execute();

	}

	public List<Item> selectAll(Connection conn) throws SQLException {

		List<Item> list = new ArrayList<Item>();

		System.out.print("getting records from table items \n");
		String sqlString = "SELECT * \n FROM items ";
		ResultSet rs = null;
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		rs = sql.executeQuery();

		while (rs.next()) {
			list.add(new Item(rs.getString("name"), rs.getInt("id"), rs
					.getString("userID")));
		}
		return list;
	}

	public List<Item> getPosesions(Connection conn, String userName)
			throws SQLException {
		ResultSet rs;

		PreparedStatement sql = conn
				.prepareStatement("SELECT items.id, items.name,items.userID FROM users INNER JOIN items ON ?=users.userName AND users.userID=items.userID");
		sql.setString(1, userName);

		rs = sql.executeQuery();

		List<Item> list = new ArrayList<Item>();
		while (rs.next()) {
			list.add(new Item(rs.getString("name"), rs.getInt("id"), rs
					.getString("userID")));
		}
		return list;
	}
}
