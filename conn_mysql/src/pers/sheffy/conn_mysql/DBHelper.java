/**
 *Tile: DBHelper
 *Description: ���ݾݿ��������ر�
 * @author Sheffy
 * @date 2017��5��9�� {time}
 *Problems:Statementִ��һ��sql�͵ñ���һ��
 *         PrepareStatementֻ����һ�Σ�
 *         ���ú���ԭ�����ڲ������÷ǳ����㣻
 *         ֻ������ȫ����Ϊ����ԭ���������һ��sql�����û�б�����ʱ��
 *         ��ʹ��ͨ����statement
 */
package pers.sheffy.conn_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



/**
 *Class Name: DBHelper
 *Description: �����򿪻��߹ر����ݿ�
 * @author Sheffy
 * @date 2017��5��9�� {time}
 * ˵����������WARN: Establishing SSL connection without server's identity verification is not recommended. 
 *               According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be 
 *               established by default if explicit option isn't set. For compliance with existing 
 *               applications not using SSL the verifyServerCertificate property is set to 'false'. 
 *               You need either to explicitly disable SSL by setting useSSL=false,
 *               or set useSSL=true and provide truststore for server certificate verification.
 *               �������Ľ���취����url�������?useUnicode=true&characterEncoding=utf-8&useSSL=false
 */
public class DBHelper {
	//URLָ��Ҫ���ʵ����ݿ���
	public static final String url = "jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	//����������
	public static final String driver = "com.mysql.jdbc.Driver";
	//��½���ݿ���û���
	public static final String user = "root";
	//��½���ݿ������
	public static final String password = "5835938";
	
	//connection ����
	public Connection conn = null;
	//׼��ִ�����
	public PreparedStatement pst = null;
	
	//���캯��,����sqlΪsql���,�����������ݿ�
	public DBHelper(String sql){
		try {
			//ָ����������
			Class.forName(driver);
			//��ȡ����
			conn = DriverManager.getConnection(url,user,password);
			//׼��ִ�����
			pst = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 *Method Name��close
	 *Description�����ڹر����ݿ�����
	 *Call��
	 *Remove��
	 *Update��
	 */
	public void close(){
		try {
			//�ر����ݿ�����
			this.conn.close();
			//�ر�׼��ִ�����
			this.pst.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

