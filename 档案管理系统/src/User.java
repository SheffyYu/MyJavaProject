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
			
			System.out.println("�޸ĳɹ���");
			return true;
		}
		else
			return false;
	}*/
	/*
	//���ݿ�����
		public static void MySQLConnect() throws SQLException{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("�Ҳ������������࣬��������ʧ�ܣ�");
				e.printStackTrace();
			}
			String url = "jdbc:mysql://localhost:3306/test" ;    
		     String username = "root" ;
		     String password = "root" ;
		try{
			Connection con = DriverManager.getConnection(url , username , password ) ; 	  
		}catch(SQLException se){   
			System.out.println("���ݿ�����ʧ�ܣ�");   
			se.printStackTrace() ;   
		     }   
		  System.out.println("���ݿ����ӳɹ���");
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
			System.out.println("�޸ĳɹ���");
			return true;
		}
		else
			return false;
	}

} 
