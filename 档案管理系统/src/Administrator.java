import java.sql.SQLException;
import java.util.*;

public class Administrator extends User{
	public Scanner scan1=new Scanner(System.in);
	
	Administrator(String name,String password,String role){
		super(name, password, role);
		this.setRole("administrator");
	}
	
	//修改用户信息
	public boolean ChangeUserInfo(String name,String password,String role) throws IllegalStateException, SQLException{
		return (DataProcessing.updateUser(name, password, role));
	}
	
	//删除用户
	public boolean delUser(String name) throws IllegalStateException, SQLException{
		return (DataProcessing.deleteUser(name));
	}
	
	//添加用户
	public boolean addUser(String name, String password, String role){
		try {
			return (DataProcessing.insertUser(name, password, role));
		} catch (IllegalStateException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//打印出用户的清单
	public void listUser(){
		Enumeration<User> e  = DataProcessing.users.elements();
		User user;
		while(e.hasMoreElements() ){
			user=e.nextElement();
			System.out.println("Name:"+user.getName()+"\t Password:"+user.getPassword()+"\t  Role:"+user.getRole());
		}
	}
	
	//修改自己账户密码
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
public void exitAdministrator() throws IllegalStateException, SQLException{
	Menu menu=new Menu();
	menu.MajorMenu();
	}

	//管理员界面
	public void ShowMenu() {
			int choose =999;
			System.out.println("************************欢迎进入管理员菜单**************************");
			System.out.println("                                           1、添加用户");
			System.out.println("                                           2、更新用户");
			System.out.println("                                           3、删除用户");
			System.out.println("                                          4、用户清单");
			System.out.println("                                          5、修改密码");
			System.out.println("                                          0、退出");
			while(choose!=0){
			System.out.printf("请选择操作：");
			choose = scan1.nextInt();
		switch(choose){
		case 1:
			try {
				addUser(name,password,role);
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			String newName,newPassword,newRole;
			newName=  scan1.nextLine();
			newPassword =  scan1.nextLine();
			newRole =  scan1.nextLine();
			try {
				ChangeUserInfo(newName,newPassword,newRole);
			} catch (IllegalStateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 3:
			try {
				delUser(name);
			} catch (IllegalStateException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 4:
			System.out.println("                                          用户清单");
			listUser();
			break;
		case 5:
			System.out.println("请输入新密码：");
			String newpassword=null;
			scan1.nextLine();
			newpassword =  scan1.nextLine();
			try {
				super.setPassword(newpassword);
			//	System.out.println("u= " + this.name + "//p =" + this.password + "//r =" + this.role);
				ChangeInfo(this.getName(), newpassword, this.getRole());
			} catch (IllegalStateException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			//退出
		case 0:
			try {
				exitAdministrator();
			} catch (IllegalStateException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println("\n");
	  }
			//AdminiFrame aframe = new AdminiFrame();
			//aframe.main(null);
	}
}
	