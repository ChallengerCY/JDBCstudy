package JDBCStudy;

import java.sql.Connection;
import java.sql.SQLException;


public class testOptimize {

	public static void main(String[] args) {
		/*获取一个OptimizeJDBC实例*/
		OptimizeJDBC optimizeJDBC=OptimizeJDBC.getInstence();
		/*调用方法获取连接*/
		Connection connection=optimizeJDBC.makeConnection();
		try {
			System.out.print(connection.getAutoCommit());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
