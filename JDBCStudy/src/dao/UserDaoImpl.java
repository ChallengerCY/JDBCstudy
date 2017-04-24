package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dto.User1;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(Connection connection, User1 user1) throws SQLException {
		/*通过prepareCall输入数据库查询语句
		 * 其中的?代表占位符，位数从1开始。
		 * 通过execute方法执行。
		 * */
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareCall("insert into testjdbc (name,age) values(?,?)");
		
		preparedStatement.setString(1, user1.getName());
		preparedStatement.setInt(2,user1.getAge());
		preparedStatement.execute();
	}

	@Override
	public void update(Connection connection, User1 user1) throws SQLException {
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareCall("update testjdbc set age=? where name='ChallengerCY'");
		preparedStatement.setString(1, user1.getName());
		preparedStatement.execute();

	}

	@Override
	public void delete(Connection connection, User1 user1) throws SQLException {
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareCall("delete from testjdbc where name=?");
		preparedStatement.setString(1, user1.getName());
		preparedStatement.execute();

	}

}
