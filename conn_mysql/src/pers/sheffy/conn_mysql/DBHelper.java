/**
 *Tile: DBHelper
 *Description: 数据据库的连接与关闭
 * @author Sheffy
 * @date 2017年5月9日 {time}
 *Problems:Statement执行一条sql就得编译一次
 *         PrepareStatement只编译一次；
 *         常用后者原因在于参数设置非常方便；
 *         只有在完全是因为性能原因或者是在一行sql语句中没有变量的时候
 *         才使用通常的statement
 */
package pers.sheffy.conn_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



/**
 *Class Name: DBHelper
 *Description: 用来打开或者关闭数据库
 * @author Sheffy
 * @date 2017年5月9日 {time}
 * 说明：遇到了WARN: Establishing SSL connection without server's identity verification is not recommended. 
 *               According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be 
 *               established by default if explicit option isn't set. For compliance with existing 
 *               applications not using SSL the verifyServerCertificate property is set to 'false'. 
 *               You need either to explicitly disable SSL by setting useSSL=false,
 *               or set useSSL=true and provide truststore for server certificate verification.
 *               这个问题的解决办法是在url后面加上?useUnicode=true&characterEncoding=utf-8&useSSL=false
 */
public class DBHelper {
	//URL指向要访问的数据库名
	public static final String url = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//驱动程序名
	public static final String driver = "com.mysql.jdbc.Driver";
	//登陆数据库的用户名
	public static final String user = "root";
	//登陆数据库的密码
	public static final String password = "5835938";
	
	//connection 对象
	public Connection conn = null;
	//准备执行语句
	public PreparedStatement pst = null;
	
	//构造函数,其中sql为sql语句,用于连接数据库
	public DBHelper(String sql){
		try {
			//指定连接类型
			Class.forName(driver);
			//获取连接
			conn = DriverManager.getConnection(url,user,password);
			//准备执行语句
			pst = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 *Method Name：close
	 *Description：用于关闭数据库连接
	 *Call：
	 *Remove：
	 *Update：
	 */
	public void close(){
		try {
			//关闭数据库连接
			this.conn.close();
			//关闭准备执行语句
			this.pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

