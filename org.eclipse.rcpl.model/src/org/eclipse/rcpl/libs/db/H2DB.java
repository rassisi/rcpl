package org.eclipse.rcpl.libs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ramin
 *
 */
public class H2DB {

	private String id;

	public H2DB(String id) {
		this.id = id;
	}

	private static Connection conn;

	public Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:~/.h2/" + id, "", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {

			}

		}
		return conn;
	}

}