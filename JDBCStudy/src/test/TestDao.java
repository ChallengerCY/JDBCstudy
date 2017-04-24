package test;

import java.sql.Connection;
import java.sql.SQLException;

import JDBCStudy.OptimizeJDBC;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.User1;

public class TestDao {

	public static void main(String[] args) {

		/* 先创建一个connection 并且打开连接 */
		Connection connection = null;
		connection = OptimizeJDBC.getInstence().makeConnection();
		try {
			/* 关闭自动提交 */
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * UserDao userDao=new UserDaoImpl(); User1 dj=new User1();
		 * dj.setName("dj"); dj.setAge(10); try { userDao.insert(connection,
		 * dj); connection.commit(); } catch (SQLException e) { try {
		 * connection.rollback(); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); } // TODO
		 * Auto-generated catch block e.printStackTrace(); }finally { try {
		 * connection.close(); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 * 
		 * try { connection.setAutoCommit(false); } catch (SQLException e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); }
		 */
		/**
		 * UserDao userDao2 = new UserDaoImpl(); User1 user1 = new User1();
		 * user1.setAge(25); try { userDao2.update(connection, user1);
		 * connection.commit(); } catch (SQLException e) { try {
		 * connection.rollback(); } catch (SQLException e1) {
		 * e1.printStackTrace(); } e.printStackTrace(); }
		 */
		/* 实例化接口 和持久化对象 */
		UserDao userDao = new UserDaoImpl();
		User1 del = new User1();
		/* 向持久化对象中放入需要的数据 */
		del.setName("CY");
		try {
			/* 调用接口中的方法，并且传入相应的参数 */
			userDao.delete(connection, del);
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
