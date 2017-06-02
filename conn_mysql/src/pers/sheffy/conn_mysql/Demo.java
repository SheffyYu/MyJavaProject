/**
 *Tile: Demo
 *Description: 数据库的一些操作，增删改查
 * @author Sheffy
 * @date 2017年5月9日 {time}
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
 *Description: 一个数据库操作的例子
 * @author Sheffy
 * @date 2017年5月9日 {time}
 */
public class Demo {
	//sql语句
	public String sql = null;
	//结果集
	public ResultSet rs=null;
	//数据库连接
	public DBHelper dbh = null;
	/**
	 *Method Name：query
	 *Description：数据库的查询操作
	 *Call：
	 *Remove：
	 *Update：
	 */
	public void query(){
		//sqlcha'xu语句
		sql = "select * from actor;";
		//建立数据库连接
		dbh = new DBHelper(sql);
		
		try {
			//执行语句，得到结果集
			rs = dbh.pst.executeQuery();
			//打印结果集
			while(rs.next()){
				String actor_id = rs.getString(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String date = rs.getString(4);
				
				System.out.println(actor_id+"\t"+first_name+"\t"+last_name+"\t"+date);
			}
			//清除结果集
			rs.close();
			//关闭数据库连接
			dbh.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
				
	}
	
	/**
	 *Method Name：add
	 *Description：增加记录
	 *Call：
	 *Remove：
	 *Update：
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
			//时间
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = (Date) dateFormat.parse("2017-09-30");
				dbh.pst.setDate(4, new java.sql.Date(date.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//更新数据库
			dbh.pst.executeUpdate();
			
			//关闭数据库
			dbh.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 *Method Name：update
	 *Description：更新一条记录
	 *Call：
	 *Remove：
	 *Update：
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
	 *Method Name：delete
	 *Description：删除一条记录
	 *Call：
	 *Remove：
	 *Update：
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
