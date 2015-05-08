package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserDAO {
	public void insert(String name, String id, Connection conn)
			throws SQLException {
		System.out.print("inserting user..." + "\n");
		String sqlString = "INSERT INTO users VALUES (?,?)";
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		sql.setString(1, name);
		sql.setString(2, id);
		sql.execute();
	}

	public void dropTable(Connection conn) throws SQLException {
		System.out.print("droping table users \n");
		String sqlString = "DROP TABLE users";
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		sql.execute();

	}

	public List<User> selectAll(Connection conn) throws SQLException {
		System.out.print("getting records from table users \n");
		String sqlString = "SELECT * \n FROM users ";
		ResultSet rs = null;
		PreparedStatement sql;
		sql = conn.prepareStatement(sqlString);
		rs = sql.executeQuery();
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			list.add(new User(rs.getString("userName"), rs.getString("userID")));
		}
		return list;
	}
}
