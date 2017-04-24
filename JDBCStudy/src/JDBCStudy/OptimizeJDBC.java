package JDBCStudy;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class OptimizeJDBC {

	/*定义常用的字段*/
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	/*声明一个OptimizeJDBC类型的常量*/
	private static final OptimizeJDBC FACTORY=new OptimizeJDBC();
	/*声明Connection对象*/
	private Connection connection;
/*	static声明静态代码块，jvm会执行，且执行一次*/
	static {
		/*通过实例化Properties对象进行文件流获取*/
		Properties properties = new Properties();
		try {
			/*用流获取文件中的信息*/
			InputStream inputStream = OptimizeJDBC.class.getClassLoader().getResourceAsStream("JDBC.properties");
			/*装载流信息*/
			properties.load(inputStream);
		} catch (Exception e) {
			System.out.print("配置文件读取失败");
		}
		/*将读取到的信息赋值给全局声明变量*/
		driver=properties.getProperty("driver");
		url=properties.getProperty("url");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
	}
	/*定义构造方法*/
	private OptimizeJDBC(){
		
	}
	/*单例模式 在程序运行期间只有一个实例，这里获取一个FACTORY对象*/
	public static OptimizeJDBC getInstence(){
		return FACTORY;
		
	}
	/*数据库连接的方法*/
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
