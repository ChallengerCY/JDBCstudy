package JDBCStudy;

import java.sql.Connection;
import java.sql.SQLException;


public class testOptimize {

	public static void main(String[] args) {
		/*��ȡһ��OptimizeJDBCʵ��*/
		OptimizeJDBC optimizeJDBC=OptimizeJDBC.getInstence();
		/*���÷�����ȡ����*/
		Connection connection=optimizeJDBC.makeConnection();
		try {
			System.out.print(connection.getAutoCommit());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
