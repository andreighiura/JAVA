package app;

import java.sql.ResultSet;
import java.sql.SQLException;

import sqlConnection.SQL;

public class App {

	public static void main(String[] args) {

		SQL conn = null;
		try {

			conn = new SQL();

			conn.dropTable("items");

			conn.createTableItems();

			for (int i = 0; i < 30; i++) {

				conn.insertItems("item ", Integer.toString(i));

			}

			ResultSet rs = conn.selectAll("items");

			while (rs.next()) {
				System.out.print((rs.getString("name") + "  "
						+ rs.getString("id") + " \n"));
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			conn.close();
		}

	}
}
