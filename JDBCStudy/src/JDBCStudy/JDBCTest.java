package JDBCStudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String sql = "Select * from testJDBC"; //д���ѯ���
		String sql1 = "update testJDBC set name='ChallengerCY'";
		Connection connection = null; //����Connection����
		Statement statement = null; //����Connection����Statement����
		ResultSet resultset = null; //����Result����
		try {
			Class.forName("com.mysql.jdbc.Driver"); //ָ����������
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "123456");//ͨ��Connection�����ȡ���ݿ�����
			statement = connection.createStatement(); //����statement����
			resultset = statement.executeQuery(sql); //����SQL���
			//����resultset����
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
