package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ItemsDAO;
import dao.UserDAO;
import entities.Item;
import entities.User;

public class Service {
	private ItemsDAO itemsDAO;
	private UserDAO userDAO;
	private SessionFactory SF;

	public Service() {
		SF = HibernateUtil.getSessionFactory();
		itemsDAO = new ItemsDAO();
		userDAO = new UserDAO();

	}

	public Session createConnection() {
		return SF.openSession();
	}

	public void insertItem(String name, String owner) {
		Session ses = this.createConnection();
		itemsDAO.insert(name, owner, ses);
		ses.close();
	}

	public void insertUser(String name, String id) {
		Session ses = this.createConnection();
		userDAO.insert(name, id, ses);
		ses.close();
	}

	public String selectAllUsers() {
		String s = "";
		Session ses = this.createConnection();

		for (User u : userDAO.selectAll(ses)) {
			s += u.toString();

		}

		ses.close();

		return s;
	}

	public String selectAllItems() {
		String s = "";
		Session ses = this.createConnection();

		for (Item u : itemsDAO.selectAll(ses)) {
			s += u.toString();

		}

		ses.close();

		return s;
	}

	public String getPosesions(String userName) {

		String s = "";

		Session ses = this.createConnection();
		for (Item i : itemsDAO.getPosesions(ses, userName)) {
			s += i.toString();
			ses.close();

		}
		return s;
	}
}
