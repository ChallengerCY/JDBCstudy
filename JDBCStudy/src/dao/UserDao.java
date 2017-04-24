package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dto.User1;

public interface UserDao {

	public void insert(Connection connection,User1 user1) throws SQLException;
	public void update(Connection connection,User1 user1) throws SQLException;
	public void delete(Connection connection,User1 user1) throws SQLException;
}
