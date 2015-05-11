package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.User;

public class UserDAO {
	public void insert(String name, String id, Session conn) {
		Transaction t = conn.beginTransaction();
		User user = new User(name, id);
		conn.save(user);
		t.commit();

	}

	public List<User> selectAll(Session conn) {
		System.out.print("getting records from table users \n");

		@SuppressWarnings("unchecked")
		List<User> list = conn.createQuery("from User").list();
		return list;
	}
}
