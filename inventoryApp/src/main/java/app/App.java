package app;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import dbo.DBOitems;
import sqlConnection.Conn;

public class App {

	public static void main(String[] args) {

		java.sql.Connection conn=null;
		
		try {

			conn = Conn.getConnection();

			DBOitems itemsDBO=new DBOitems();


			for (int i = 0; i < 30; i++) {

				itemsDBO.insert("item ", i,conn);
				
			}

			ResultSet rs = itemsDBO.selectAll(conn);

			while (rs.next()) {
				System.out.print((rs.getString("name") + "  "
						+ rs.getString("id") + " \n"));
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			Conn.close(conn);
		}

	}
}
