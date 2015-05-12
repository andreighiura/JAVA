package dao;

import java.util.List;

import org.hibernate.Session;

import entities.User;

public class UserDAO {
	public void insert(User user, Session conn) {

		conn.save(user);

	}

	public void insert(List<User> users, Session conn) {
		for (User u : users) {
			insert(u, conn);
		}
	}

	public List<User> selectAll(Session conn) {
		System.out.print("getting records from table users \n");

		@SuppressWarnings("unchecked")
		List<User> list = conn.createQuery("from User").list();
		return list;
	}
}
