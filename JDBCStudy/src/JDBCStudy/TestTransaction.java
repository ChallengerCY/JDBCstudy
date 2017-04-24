package JDBCStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 事务回滚需要调用Connection的三个方法
 * setsetAutoCommit(),Commit()和rollback()
 * setsetAutoCommit()中需要传递布尔值，如果是false则SQL语句不会自动执行
 * Commit()用于提交
 * rollback()用于提交时候发生错误进行回滚
*/

public class TestTransaction {

	public static Connection getconnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void insertTestJDBC(Connection connection) throws SQLException {
		String str = "insert into testjdbc (name,age) value('Challenger',24)";
		Statement statement = connection.createStatement();
		int sql = statement.executeUpdate(str);
	}

	public static void insertAddress(Connection connection) throws SQLException {
		String str = "insert into Address (id,address,testjdbc_name) value('1','cc','1')";
		Statement statement = connection.createStatement();
		int sql = statement.executeUpdate(str);
	}

	public static void main(String[] args) {
		Connection connection = getconnection();
		try {
			connection.setAutoCommit(false);
			insertTestJDBC(connection);
			insertAddress(connection);
			connection.commit();
		} catch (SQLException e) {
			System.out.println("捕获异常");
			e.printStackTrace();
			try {
				connection.rollback();
				System.out.println("回滚成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
