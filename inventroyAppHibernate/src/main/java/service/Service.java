package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ItemsDAO;
import dao.UserDAO;
import entities.Item;
import entities.User;

public class Service {
	private ItemsDAO itemDAO;
	private UserDAO userDAO;
	private SessionFactory SF;

	public Service() {
		SF = HibernateUtil.getSessionFactory();
		itemDAO = new ItemsDAO();
		userDAO = new UserDAO();

	}

	public Session createConnection() {
		return SF.openSession();
	}

	public void insertItem(Item item) {

		Session ses = null;

		try {

			ses = this.createConnection();

			Transaction t = ses.beginTransaction();
			itemDAO.insert(item, ses);
			t.commit();
		} finally {
			ses.close();
		}
	}

	public void insertTestData() {

		Session ses = null;

		try {

			ses = this.createConnection();

			Transaction t = ses.beginTransaction();

			for (int i = 0; i < 10; i++) {

				User user = new User(" user " + Integer.toString(100 - i),
						Integer.toString(i));
				userDAO.insert(user, ses);
				Item item = new Item("mouse_" + i, user);
				itemDAO.insert(item, ses);

			}
			t.commit();
		} finally {

			ses.close();
		}
	}

	public void insertUsers(List<User> users) {

		Session ses = null;

		try {

			ses = this.createConnection();

			Transaction t = ses.beginTransaction();
			userDAO.insert(users, ses);
			t.commit();
		} finally {
			ses.close();
		}
	}

	public void insertUser(User user) {

		Session ses = null;

		try {

			ses = this.createConnection();

			Transaction t = ses.beginTransaction();
			userDAO.insert(user, ses);
			t.commit();
		} finally {
			ses.close();
		}
	}

	public String selectAllUsers() {
		String s = "";
		Session ses = null;

		try {

			ses = this.createConnection();

			for (User u : userDAO.selectAll(ses)) {
				s += u.toString();

			}
		} finally {

			ses.close();
		}
		return s;
	}

	public String selectAllItems() {
		String s = "";
		Session ses = null;
		try {
			ses = this.createConnection();

			for (Item u : itemDAO.selectAll(ses)) {
				s += u.toString();

			}
		} finally {

			ses.close();
		}
		return s;
	}

	public String getPosesions(String userName) {

		String s = "";
		Session ses = null;

		try {
			ses = this.createConnection();
			for (Item i : itemDAO.getPosesions(ses, userName)) {

				s += i.toString();
			}
		}

		finally {
			ses.close();
		}
		return s;
	}
}
