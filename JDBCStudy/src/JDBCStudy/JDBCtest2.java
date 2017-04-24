package JDBCStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest2 {

	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void update() {
		String str = "update testjdbc set age = 24";
		Connection connection = getconnection();
		try {
			Statement statement = connection.createStatement();
			int sqlStatement = statement.executeUpdate(str);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert() {
		String sql = "insert into testjdbc (name,age) value('CY',24)";
		Connection connection = getconnection();
		try {
			Statement statement = connection.createStatement();
			int sqlStatement = statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void del() {
		String sql = "delete from testjdbc where name='CY'";
		Connection connection = getconnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			int sqlStatement = statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		update();
		insert();
		del();
	}
}
