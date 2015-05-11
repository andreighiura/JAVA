package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Item;

public class ItemsDAO {

	public void insert(String name, String owner, Session conn) {
		Transaction t = conn.beginTransaction();
		Item item = new Item(name, owner);
		conn.save(item);
		t.commit();

	}

	public List<Item> selectAll(Session conn) {

		@SuppressWarnings("unchecked")
		List<Item> list = conn.createQuery("from Item").list();

		return list;
	}

	public List<Item> getPosesions(Session conn, String userName) {

		String hql = "SELECT item.id, item.name, item.userID " + "FROM user "
				+ "JOIN item " + "on user.userID=item.userID";

		@SuppressWarnings("unchecked")
		List<Item> list = conn.createSQLQuery(hql).list();// .setParameter("userName",
		// "2") .list();

		return list;
	}
}
