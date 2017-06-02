import java.sql.SQLException;
import java.util.*;

public class Menu{
	public static Scanner scan0=new Scanner(System.in);
	
	public void MajorMenu() throws IllegalStateException, SQLException{
		String Uname,Upassword;
		User man = null;
		System.out.println("*************************��ӭ���뵵������ϵͳ***************************");
		System.out.println("                                         1����½");
		System.out.println("                                         0���˳�");
		System.out.printf("��ѡ��");
		int choose = scan0.nextInt();
		
		switch(choose){
		case 1:{
		System.out.printf("�������û�����");
		Uname=scan0.next();
		System.out.printf("��������");
		Upassword=scan0.next();
		
		try{
	    man=DataProcessing.searchUser(Uname,Upassword);
		}catch ( SQLException sqlException ){      
		    sqlException.printStackTrace();           
		}finally{                                            
			boolean connectToDB = false;              
		}      
	    
	    switch(man.role){
	    case "administrator":{
			Administrator administrator=new Administrator(Uname, Upassword,null);
	    	administrator.ShowMenu();
	    	break;
	    }
	    case "operator":{
			Operator operator=new Operator(Uname, Upassword,null);
	    	operator.ShowMenu();
	    	break;
	    }
	    case "browser":{
			Browser browser=new Browser(Uname, Upassword,null);
	    	browser.ShowMenu();
	    	break;
	    }
	    }
	    break;
		}
		case 0:
			System.exit(0);
			break;
		}
	}
	
}