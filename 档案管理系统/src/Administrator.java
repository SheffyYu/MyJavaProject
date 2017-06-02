import java.sql.SQLException;
import java.util.*;

public class Administrator extends User{
	public Scanner scan1=new Scanner(System.in);
	
	Administrator(String name,String password,String role){
		super(name, password, role);
		this.setRole("administrator");
	}
	
	//�޸��û���Ϣ
	public boolean ChangeUserInfo(String name,String password,String role) throws IllegalStateException, SQLException{
		return (DataProcessing.updateUser(name, password, role));
	}
	
	//ɾ���û�
	public boolean delUser(String name) throws IllegalStateException, SQLException{
		return (DataProcessing.deleteUser(name));
	}
	
	//����û�
	public boolean addUser(String name, String password, String role){
		try {
			return (DataProcessing.insertUser(name, password, role));
		} catch (IllegalStateException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//��ӡ���û����嵥
	public void listUser(){
		Enumeration<User> e  = DataProcessing.users.elements();
		User user;
		while(e.hasMoreElements() ){
			user=e.nextElement();
			System.out.println("Name:"+user.getName()+"\t Password:"+user.getPassword()+"\t  Role:"+user.getRole());
		}
	}
	
	//�޸��Լ��˻�����
	public boolean  ChangeInfo(String name,String password,String role) throws IllegalStateException, SQLException{

		return (DataProcessing.updateUser(name, password, role));
	}
	
public void exitAdministrator() throws IllegalStateException, SQLException{
	Menu menu=new Menu();
	menu.MajorMenu();
	}

	//����Ա����
	public void ShowMenu() {
			int choose =999;
			System.out.println("************************��ӭ�������Ա�˵�**************************");
			System.out.println("                                           1������û�");
			System.out.println("                                           2�������û�");
			System.out.println("                                           3��ɾ���û�");
			System.out.println("                                          4���û��嵥");
			System.out.println("                                          5���޸�����");
			System.out.println("                                          0���˳�");
			while(choose!=0){
			System.out.printf("��ѡ�������");
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
			System.out.println("                                          �û��嵥");
			listUser();
			break;
		case 5:
			System.out.println("�����������룺");
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
			//�˳�
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
	