package dao;

import java.util.List;

import org.hibernate.Session;

import entities.Item;

public class ItemsDAO {

	public void insert(Item item, Session conn) {

		conn.save(item);

	}

	public List<Item> selectAll(Session conn) {

		@SuppressWarnings("unchecked")
		List<Item> list = conn.createQuery("from Item").list();

		return list;
	}

	public List<Item> getPosesions(Session ses, String userName) {
		/*
		 * String sql =
		 * "SELECT item.* FROM item INNER JOIN user on user.userID=item.userID";
		 * 
		 * @SuppressWarnings("unchecked") List<Item> list = (List<Item>)
		 * conn.createSQLQuery(sql) .addEntity("entities.Item").list();//
		 * .setParameter("userName", // "2") .list();
		 * 
		 * for (Object i : list) { System.out.print(((Item) i).toString() +
		 * "\n"); } return list; }
		 */
		@SuppressWarnings("unchecked")
		List<Item> list = ses
				.createQuery("from Item i WHERE i.user.userName=(:userName)")
				.setString("userName", userName).list();
		return list;
	}
}
