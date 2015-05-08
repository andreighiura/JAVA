package service;

import java.sql.Connection;
import java.sql.SQLException;

import sqlConnection.Conn;
import dao.ItemsDAO;
import dao.UserDAO;
import entities.Item;
import entities.User;

public class Service {
	private ItemsDAO itemsDAO;
	private UserDAO userDAO;

	public Service() {
		itemsDAO = new ItemsDAO();
		userDAO = new UserDAO();
	}

	public void insertItem(String name, int id, String owner) {

		Connection conn = null;
		try {
			conn = Conn.getConnection();

			itemsDAO.insert(name, id, owner, conn);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.close(conn);
		}
	}

	public void insertUser(String name, String id) {
		Connection conn = null;

		try {
			conn = Conn.getConnection();
			userDAO.insert(name, id, conn);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.close(conn);
		}
	}

	public String selectAllUsers() {
		String s = "";
		Connection conn = null;

		try {
			conn = Conn.getConnection();

			for (User u : userDAO.selectAll(conn)) {
				s += u.toString();

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			Conn.close(conn);
		}

		return s;

	}

	public String selectAllItems() {

		String s = "";

		Connection conn = null;
		try {
			conn = Conn.getConnection();
			for (Item i : itemsDAO.selectAll(conn)) {
				s += i.toString();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.close(conn);
		}
		return s;
	}

	public String getPosesions(String userName) {
		Connection conn = null;
		String s = "";
		try {
			conn = Conn.getConnection();
			for (Item i : itemsDAO.getPosesions(conn, userName)) {
				s += i.toString();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;

	}
}
