package test;

import java.sql.Connection;
import java.sql.SQLException;

import JDBCStudy.OptimizeJDBC;
import dao.UserDao;
import dao.UserDaoImpl;
import dto.User1;

public class TestDao {

	public static void main(String[] args) {

		/* �ȴ���һ��connection ���Ҵ����� */
		Connection connection = null;
		connection = OptimizeJDBC.getInstence().makeConnection();
		try {
			/* �ر��Զ��ύ */
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
		/* ʵ�����ӿ� �ͳ־û����� */
		UserDao userDao = new UserDaoImpl();
		User1 del = new User1();
		/* ��־û������з�����Ҫ������ */
		del.setName("CY");
		try {
			/* ���ýӿ��еķ��������Ҵ�����Ӧ�Ĳ��� */
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
