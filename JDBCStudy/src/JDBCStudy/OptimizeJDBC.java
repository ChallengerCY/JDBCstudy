package JDBCStudy;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class OptimizeJDBC {

	/*���峣�õ��ֶ�*/
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	/*����һ��OptimizeJDBC���͵ĳ���*/
	private static final OptimizeJDBC FACTORY=new OptimizeJDBC();
	/*����Connection����*/
	private Connection connection;
/*	static������̬����飬jvm��ִ�У���ִ��һ��*/
	static {
		/*ͨ��ʵ����Properties��������ļ�����ȡ*/
		Properties properties = new Properties();
		try {
			/*������ȡ�ļ��е���Ϣ*/
			InputStream inputStream = OptimizeJDBC.class.getClassLoader().getResourceAsStream("JDBC.properties");
			/*װ������Ϣ*/
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.print("�����ļ���ȡʧ��");
		}
		/*����ȡ������Ϣ��ֵ��ȫ����������*/
		driver=properties.getProperty("driver");
		url=properties.getProperty("url");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
	}
	/*���幹�췽��*/
	private OptimizeJDBC(){
		
	}
	/*����ģʽ �ڳ��������ڼ�ֻ��һ��ʵ���������ȡһ��FACTORY����*/
	public static OptimizeJDBC getInstence(){
		return FACTORY;
		
	}
	/*���ݿ����ӵķ���*/
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
