package dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import dto.User1;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(Connection connection, User1 user1) throws SQLException {
		/*ͨ��prepareCall�������ݿ��ѯ���
		 * ���е�?����ռλ����λ����1��ʼ��
		 * ͨ��execute����ִ�С�
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
