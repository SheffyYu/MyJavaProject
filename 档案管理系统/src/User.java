import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public  abstract class User{
	protected String name;
	protected String password;
	protected String role;
	
	User(String name,String password,String role){
		this.name=name;
		this.password=password;
		this.role=role;
	}
	
/*	public boolean ChangeInfo(String password){
		if(DataProcessing.update(name,password,role)){
			this.password=password;
			
			System.out.println("修改成功！");
			return true;
		}
		else
			return false;
	}*/
	/*
	//数据库链接
		public static void MySQLConnect() throws SQLException{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("找不到驱动程序类，加载驱动失败！");
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/test" ;    
		     String username = "root" ;
		     String password = "root" ;
		try{
			Connection con = DriverManager.getConnection(url , username , password ) ; 	  
		}catch(SQLException se){   
			System.out.println("数据库连接失败！");   
			se.printStackTrace() ;   
		     }   
		  System.out.println("数据库连接成功！");
		}
*/

	public String setName(){
		return name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPassword(String p){
		password = p;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setRole(String ro){
		role=ro;
	}
	
	public String getRole(){
		return role;
	}
	
	public abstract void ShowMenu();

	public boolean ChangeInfo(String newPassword) throws IllegalStateException, SQLException {
		// TODO Auto-generated method stub
		if(DataProcessing.updateUser(name,password,role)){
			this.password=newPassword;
			System.out.println("修改成功！");
			return true;
		}
		else
			return false;
	}

} 
