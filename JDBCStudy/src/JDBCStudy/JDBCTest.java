package JDBCStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String sql = "Select * from testJDBC"; //写入查询语句
		String sql1 = "update testJDBC set name='ChallengerCY'";
		Connection connection = null; //设置Connection对象
		Statement statement = null; //设置Connection对象Statement对象
		ResultSet resultset = null; //设置Result对象
		try {
			Class.forName("com.mysql.jdbc.Driver"); //指定驱动程序
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");//通过Connection对象获取数据库连接
			statement = connection.createStatement(); //创建statement对象
			resultset = statement.executeQuery(sql); //发送SQL语句
			//遍历resultset对象
			while (resultset.next()) { 
				
				System.out.println(resultset.getInt("id"));
				System.out.println(resultset.getString("name"));
				System.out.println(resultset.getInt("age"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
