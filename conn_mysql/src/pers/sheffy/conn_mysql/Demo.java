/**
 *Tile: Demo
 *Description: ���ݿ��һЩ��������ɾ�Ĳ�
 * @author Sheffy
 * @date 2017��5��9�� {time}
 *Problems:
 */
package pers.sheffy.conn_mysql;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Class Name: Demo
 *Description: һ�����ݿ����������
 * @author Sheffy
 * @date 2017��5��9�� {time}
 */
public class Demo {
	//sql���
	public String sql = null;
	//�����
	public ResultSet rs=null;
	//���ݿ�����
	public DBHelper dbh = null;
	/**
	 *Method Name��query
	 *Description�����ݿ�Ĳ�ѯ����
	 *Call��
	 *Remove��
	 *Update��
	 */
	public void query(){
		//sqlcha'xu���
		sql = "select * from actor;";
		//�������ݿ�����
		dbh = new DBHelper(sql);
		
		try {
			//ִ����䣬�õ������
			rs = dbh.pst.executeQuery();
			//��ӡ�����
			while(rs.next()){
				String actor_id = rs.getString(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String date = rs.getString(4);
				
				System.out.println(actor_id+"\t"+first_name+"\t"+last_name+"\t"+date);
			}
			//��������
			rs.close();
			//�ر����ݿ�����
			dbh.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
				
	}
	
	/**
	 *Method Name��add
	 *Description�����Ӽ�¼
	 *Call��
	 *Remove��
	 *Update��
	 */
	public void add(){
		int id = 202;
		String first = "Yu";
		String last = "Shihui";
		sql = "insert into actor (actor_id,first_name,last_name,last_update) "+
	          "values(?,?,?,?);";
		dbh = new DBHelper(sql);
		try {
			dbh.pst.setInt(1, id);
			dbh.pst.setString(2, first);
			dbh.pst.setString(3, last);
			//ʱ��
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = (Date) dateFormat.parse("2017-09-30");
				dbh.pst.setDate(4, new java.sql.Date(date.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�������ݿ�
			dbh.pst.executeUpdate();
			
			//�ر����ݿ�
			dbh.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *Method Name��update
	 *Description������һ����¼
	 *Call��
	 *Remove��
	 *Update��
	 */
	public void update(){
		String first = "Yu";
		String last = "Yongyu";
		sql = "update actor set last_name = ? where first_name = ?;";
		
		dbh = new DBHelper(sql);
		try {
			dbh.pst.setString(1, last);
			dbh.pst.setString(2, first);
			dbh.pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 *Method Name��delete
	 *Description��ɾ��һ����¼
	 *Call��
	 *Remove��
	 *Update��
	 */
	public void delete(){
		sql = "delete from actor where actor_id = ?;";
		int actor_id = 202;
		
		dbh = new DBHelper(sql);
		try {
			dbh.pst.setInt(1, actor_id);
			dbh.pst.executeUpdate();
			dbh.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		Demo demo = new Demo();
//		demo.query();
//		demo.add();
//		demo.update();
		demo.delete();
		demo.query();
	}
}
